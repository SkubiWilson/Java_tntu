import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("початок");
        list.add("середина");
        list.addLast("кінець");

        System.out.println(list);
    }
}
