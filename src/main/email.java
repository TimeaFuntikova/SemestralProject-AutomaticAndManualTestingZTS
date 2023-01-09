
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class email {
    public static String nazovMailu(String email_) {
        return email_;
    }


    public char checkValidEmail(String email_) {

        try {
            String regex = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(email_);
            System.out.println(email_ + " : " + matcher.matches());
            if (!matcher.matches()) {
                return 'N';

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 'Y';
    }
}

