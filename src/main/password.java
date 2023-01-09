
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class password {

    public static char isValid(String password_) {
        if(password_.length() >= 6 || password_.matches("[0-9]")) {
            return 'Y';
        }
        System.out.println("Heslo musí mať aspoň 6 znakov a obsahovať číslicu.");
        return 'N';
    }
}
