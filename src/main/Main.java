
public class Main {
    /**
     * Trieda main služi na spúšťanie programu.
     * @param args
     */
    public static void main(String[] args) {
        {
            Vypisy vypisHandler = new Vypisy();
            Testy testyHandler = new Testy();
            testyHandler.initChromeDriver();
            testyHandler.invokeBrowser();

               vypisHandler.vypisZaciatok();
               vypisHandler.vypisFunkcionality();

               int cisloFunkcionality = vypisHandler.nacitajFunkcionalitu();
               vypisHandler.handlerFunkcionality(cisloFunkcionality);

               int cisloTestu = vypisHandler.nacitajTest();

            vypisHandler.handlerTesty(cisloTestu);
            //testyHandler.Test12();
            //testyHandler.Test13();

            vypisHandler.vypisKoniec();
        }
    }

}
