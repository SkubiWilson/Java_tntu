import java.util.LinkedList;
import java.util.Queue;

public class LoaderProcessorApp {

    private static final Queue<String> queue = new LinkedList<>();
    private static final Object lock = new Object();
    private static boolean finishedLoading = false;

    public static void main(String[] args) {
        Thread loader = new Thread(new Loader(), "Завантажувач");
        Thread processor = new Thread(new Processor(), "Обробник");

        loader.start();
        processor.start();

        try {
            loader.join();
            processor.join();
        } catch (InterruptedException e) {
            System.out.println("Головний потік перерваний.");
        }

        System.out.println("Програма завершена.");
    }

    static class Loader implements Runnable {
        private final String[] data = {
                "Java — це круто!",
                "Багатопоточність корисна",
                "Пишемо лабораторну №9",
                "ТНТУ — наш університет"
        };

        @Override
        public void run() {
            for (String line : data) {
                synchronized (lock) {
                    queue.add(line);
                    System.out.println("Завантажено: " + line);
                    lock.notify();
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Завантаження перервано.");
                }
            }

            synchronized (lock) {
                finishedLoading = true;
                lock.notify();
            }

            System.out.println("Завантаження завершено.");
        }
    }

    static class Processor implements Runnable {
        @Override
        public void run() {
            while (true) {
                String line;
                synchronized (lock) {
                    while (queue.isEmpty() && !finishedLoading) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Обробку перервано.");
                        }
                    }

                    if (queue.isEmpty() && finishedLoading) {
                        break;
                    }

                    line = queue.poll();
                }

                if (line != null) {
                    String result = line.toUpperCase();
                    System.out.println("Оброблено: " + result);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Потік обробки перерваний.");
                }
            }

            System.out.println("Обробка завершена.");
        }
    }
}
