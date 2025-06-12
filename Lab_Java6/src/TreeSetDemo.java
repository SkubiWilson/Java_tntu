import java.util.TreeSet;

class Student implements Comparable<Student> {
    String name;
    int grade;

    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public int compareTo(Student other) {
        return Integer.compare(this.grade, other.grade); // сортуємо за оцінкою
    }

    public String toString() {
        return name + ": " + grade;
    }
}

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Student> set = new TreeSet<>();
        set.add(new Student("Анна", 95));
        set.add(new Student("Микикта", 87));
        set.add(new Student("Богдан", 87));

        System.out.println(set);
    }
}
