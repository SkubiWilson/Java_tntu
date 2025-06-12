import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("apple", 3);
        map.put("banana", 2);
        map.put("orange", 5);

        System.out.println(map);
    }
}
