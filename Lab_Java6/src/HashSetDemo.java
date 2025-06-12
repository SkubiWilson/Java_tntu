import java.util.HashSet;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        return name.equals(((Person)o).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String toString() {
        return name;
    }
}

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        set.add(new Person("Oleg"));
        set.add(new Person("Oleg"));
        set.add(new Person("Piter"));

        System.out.println(set);
    }
}
