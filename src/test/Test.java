import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Test {

    /**
     * Testy pre e-mail.
     */
    @org.junit.jupiter.api.Test
    void emailAdmin() {
        email emailTest = new email();
        assertEquals("timeafuntik@gmail.com",email.nazovMailu("timeafuntik@gmail.com"));
    }

    @org.junit.jupiter.api.Test
    void emailNotAdmin() {
        email emailTest = new email();
        assertNotEquals("timeafuntik@gmail.com",email.nazovMailu("jankoMrkvicka@gmail.com"));
    }

    @org.junit.jupiter.api.Test
    void emailValid() {
        email emailik = new email();
        assertEquals('Y', emailik.checkValidEmail("timeafuntik@gmail.com"));
    }
    @org.junit.jupiter.api.Test
    void emailNotValid() {
        email emailik = new email();
        assertEquals('N', emailik.checkValidEmail("timeafuntikgmailcom"));
    }

    /**
     * Testy pre heslo.
     */
    @org.junit.jupiter.api.Test
    void hesloValid (){
        password heslo = new password();
        assertEquals('Y', heslo.isValid("HEslo321"));
    }

    @org.junit.jupiter.api.Test
    void hesloNotValid (){
        password heslo = new password();
        assertEquals('N', heslo.isValid("Short"));
    }

}
