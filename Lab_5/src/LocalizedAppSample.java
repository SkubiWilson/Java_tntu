import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizedAppSample {
    public static void main(String[] args) {
        Locale current = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("i18n.Bundle", current);

        String hello = bundle.getString("hello");
        String info = bundle.getString("info");

        System.out.println(hello);
        System.out.println(info);
    }
}
