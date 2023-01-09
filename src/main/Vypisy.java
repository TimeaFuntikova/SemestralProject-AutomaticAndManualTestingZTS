import java.util.Scanner;

import java.io.IOException;
import java.util.Scanner;

public class Vypisy {
    public void vypisZaciatok() {
        System.out.println("Zacina sa automaticke testovanie stranky");
    }
    public void vypisKoniec() {
        System.out.println("Koniec programu.");
    }

    public void vypisFunkcionality() {
        System.out.println("Zadajte číslo od 1 - 5 podla toho, aka sa ma testovat funkcionalita.");
        System.out.println("Dostupne funkcionality:");
        System.out.println("1 - Testovanie okna stránky.");
        System.out.println("2 - Testovanie vyhľadávania na stránke.");
        System.out.println("3 - Testovanie prihlasovania do webu.");
        System.out.println("4 - Testovanie vyhľadávnia v pomocníkovi.");
        System.out.println("5 - Testovanie pridávania do košíka.");
    }

    public int nacitajFunkcionalitu() {
        Scanner myInput = new Scanner( System.in );
        int cisloFunkcionality = myInput.nextInt();
        System.out.println("Registrujem funkcionalitu : " + cisloFunkcionality);
        return cisloFunkcionality;
    }

    public int nacitajTest() {

        Scanner myInput = new Scanner( System.in );
        int cisloTestu = myInput.nextInt();

        System.out.println("Registrujem : " + cisloTestu);
        return cisloTestu;
    }
    public void handlerFunkcionality(int cisloFunkcionality) {
        if(cisloFunkcionality==99) {
            vypisFunkcionality();
        }
        if(cisloFunkcionality>0 && cisloFunkcionality < 6) {
            System.out.println("Zvolte cislo podla toho, aky test sa ma vykonat.");
            switch (cisloFunkcionality) {
                case 1:
                    vypisTesty1();
                    break;
                case 2:
                    vypisTesty2();
                    break;
                case 3:
                    vypisTesty3();
                    break;
                case 4:
                    vypisTesty4();
                    break;
                case 5:
                    vypisTesty5();
                    break;
                default:
                    System.out.println("Nedefinovany prikaz.");
            }
        }
    }

    public void handlerTesty(int cisloPrikazu) {
        Testy testyHandler = new Testy();

        if(cisloPrikazu==99) {
            vypisFunkcionality();
        }
        if(cisloPrikazu ==98) {
            testyHandler.closeBrowser();
        }
        if(cisloPrikazu>0 && cisloPrikazu < 14) {
            System.out.println("Zvolte cislo podla toho, aky test sa ma vykonat.");
            switch (cisloPrikazu) {
                case 1: testyHandler.Test1(); break;
                case 2: testyHandler.Test2(); break;
                case 3: testyHandler.Test3(); break;
                case 4: testyHandler.Test4(); break;
                case 5: testyHandler.Test5(); break;
                case 6: testyHandler.Test6(); break;
                case 7: testyHandler.Test7(); break;
                case 8: testyHandler.Test8(); break;
                case 9: testyHandler.Test9(); break;
                case 10: testyHandler.Test10(); break;
                case 11: testyHandler.Test11(); break;
                case 12: testyHandler.Test12(); break;
                case 13: testyHandler.Test13(); break;
                default:
                    System.out.println("Nedefinovany prikaz. Koncim program.");
                    testyHandler.closeBrowser();
            }
        } else {
            System.out.println("Nedefinovany prikaz. Koncim program.");
            testyHandler.closeBrowser();
        }
    }

    public void vypisTesty1() {
        System.out.println("1 - Test maximalizacie okna.");
        System.out.println("2 - Test minimalizacie okna.");
    }
    public void vypisTesty2() {
        System.out.println("3 - Test zobrazenia ponuky telefonov.");
        System.out.println("4 - Test zobrazenia ponuky telefonov iPhone.");
        System.out.println("5 - Test zobrazenia ponuky telefonov iPhone pod 1200 €.");
        System.out.println("6 - Test vypisanie kodu stranky do suboru pre ponuku telefonov.");
        System.out.println("7 - Test zobrazenia ponuky notebookov.");
    }
    public void vypisTesty3() {
        System.out.println("8 - Test prihlásenia sa na web bez zadania udajov.");
        System.out.println("9 - Test registracie uz registrovaneho pouzivatela.");
        System.out.println("10 - Test prihlasenia sa iba pomocou loginu.");
        System.out.println("11 - Test na odoslanie linku na zabudnute heslo.");
    }
    public void vypisTesty4() {
        System.out.println("12 - Test nakupneho poradcu.");

    }
    public void vypisTesty5() {
        System.out.println("13 - Test vloženia produktu do košíka.");
    }

}
