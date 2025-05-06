import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть рядок:");
        String input = scanner.nextLine();

        String onlyLetters = input.replaceAll("[^a-zA-Zа-яА-ЯіїєґІЇЄҐ]", "");

        char[] chars = onlyLetters.toCharArray();

        Arrays.sort(chars);

        System.out.println("Відсортовані літери:");
        System.out.println(new String(chars));
    }
}
