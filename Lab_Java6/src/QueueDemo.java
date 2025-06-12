import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("перший");
        queue.add("другий");

        System.out.println(queue.poll());
    }
}
