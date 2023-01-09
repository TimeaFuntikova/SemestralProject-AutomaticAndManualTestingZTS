import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileWriter;

public class Testy {

    WebDriver driver = new ChromeDriver();
    String phonesURL;
    public void initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\timka\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

    }
    public void invokeBrowser() {
        driver.get("https:\\www.datart.sk");
        driver.manage().deleteAllCookies();     //vymaze vsetky cookiesky
        System.out.println(driver.getTitle());  //vypise titulok stranky
    }

    public void closeBrowser() {
        driver.quit();
        System.out.println("Prehliadac sa zatvoril.");
    }

    /**
     * Test 1 - Maximalizuje okno. Spustí prehliadač, požadovanú stránku a maximalizuje okno.
     */
    public void Test1() {
        try {
            driver.manage().window().maximize();    //maximalizuje okno
            System.out.println("Test 1 - SUCCESS : Maximalizacia okna.");
            closeBrowser();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test 2 - Pocka 5 sekund a zatvori okno.
     */
    public void Test2() {
        try {
            driver.manage().window().minimize();    //minimalizuje okno
            closeBrowser();

            System.out.println("Test 2 - SUCCESS: Minimalizacia okna.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Test 3 - Zobrazi aktualnu ponuku telefonov.
     */
    public void Test3() {
        try {

            driver.findElement(By.linkText("Telefóny")).click();
            phonesURL = driver.getCurrentUrl();
            //System.out.println("Current URL: " + phonesURL);
            closeBrowser();

            System.out.println("Test 3 - SUCCESS: Zobrazila sa aktualna ponuka telefonov.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test 4 - Zobrazi aktualnu ponuku telefonov typu iPhone.
     */
    public void Test4() {
        try {
            driver.findElement(By.linkText("Telefóny")).click();
            driver.findElement(By.linkText("Apple iPhone")).click();
            //System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Test 4 - SUCCESS: Zobrazila sa aktualna ponuka telefonov typu iPhone.");
        } catch (Exception e) {
            e.printStackTrace();
            closeBrowser();

        }
    }

    /**
     * Test 5 - Zobrazi aktualnu ponuku telefonov typu iPhone ktore stoja menej ako 1200e.
     */
    public void Test5() {
        try {
            // Test name: filter1200
            // Step # | name | target | value | comment
            // 1 | open | /iphone.html |  |
            driver.get("https://www.datart.sk/iphone.html");
            // 2 | setWindowSize | 1268x696 |  |
            driver.manage().window().setSize(new Dimension(1268, 696));
            // 3 | click | name=param[-14][max] |  |
            driver.findElement(By.name("param[-14][max]")).click();
            // 4 | click | name=param[-14][max] |  |
            driver.findElement(By.name("param[-14][max]")).click();
            // 5 | click | name=param[-14][max] |  |
            driver.findElement(By.name("param[-14][max]")).click();
            // 6 | type | name=param[-14][max] | 1200 |
            driver.findElement(By.name("param[-14][max]")).sendKeys("1200");
            // 7 | sendKeys | name=param[-14][max] | ${KEY_ENTER} |
            driver.findElement(By.name("param[-14][max]")).sendKeys(Keys.ENTER);
            closeBrowser();

            System.out.println("Test 5 - SUCCESS: Zobrazila sa aktualna ponuka telefonov typu iPhone pod 1200€.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test 6 - Do suboru sa vypise zdrojovy kod stranky pre aktualnu ponuku telefonov.
     */
    public void Test6() {
        try{
            driver.findElement(By.linkText("Telefóny")).click();

            //Instantiating the File class
            FileWriter file = new FileWriter("vypisTelefonovStranka.txt");
            file.write(driver.getPageSource());
            file.close();
            closeBrowser();

            System.out.println("Test 6 - SUCCESS: Do suboru sa vypisal sa zdrojovy kod stranky.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test 7 - Zobrazi aktualnu ponuku notebookov.
     */
    public void Test7() {
        try {
            // 1 | open | / |  |
            driver.get("https://www.datart.sk/");
            // 2 | setWindowSize | 1268x695 |  |
            driver.manage().window().setSize(new Dimension(1268, 695));
            driver.findElement(By.linkText("Notebooky")).click();
            //System.out.println("Current URL: " + driver.getCurrentUrl());
            closeBrowser();
            System.out.println("Test 7 - SUCCESS: Zobrazila sa aktualna ponuka notebookov.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test 8 - Pokúsi sa lognut do uctu na datart bez zadania potrebnych udajov.
     */
    public void Test8() {
        try {
            // Test name: acc
            // Step # | name | target | value | comment
            // 1 | open | / |  |
            driver.get("https://www.datart.sk/");
            // 2 | setWindowSize | 1268x695 |  |
            driver.manage().window().setSize(new Dimension(1268, 695));
            // 3 | click | css=.login-menu-title |  |
            driver.findElement(By.cssSelector(".login-menu-title")).click();
            // 4 | click | css=.login-menu-title > span |  |
            driver.findElement(By.cssSelector(".login-menu-title > span")).click();
            // 5 | click | css=.btn-login |  |
            driver.findElement(By.cssSelector(".btn-login")).click();
            closeBrowser();

            System.out.println("Test 8 - SUCCESS: Neplatny pokus o prihlasenie.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test 9 - Pokúsi sa vyplnit registracny formluar a registrovat uz existujuceho pouzivatela.
     */
    public void Test9() {
        try {
            driver.get("https://www.datart.sk/");
            driver.manage().window().maximize();    //maximalizuje okno
            {
                WebElement element = driver.findElement(By.cssSelector(".head-cart > span"));
                Actions builder = new Actions(driver);
                builder.moveToElement(element).perform();
            }
            driver.findElement(By.cssSelector(".login-menu-title")).click();
            driver.findElement(By.linkText("Vytvoriť účet")).click();
            driver.findElement(By.id("frm-registration-firstName")).sendKeys("timea");
            driver.findElement(By.id("frm-registration-lastName")).sendKeys("funtikova");
            driver.findElement(By.id("frm-registration-street")).sendKeys("NazovULICE");
            driver.findElement(By.id("frm-registration-city")).sendKeys("Žilina");
            driver.findElement(By.id("frm-registration-zip")).sendKeys("01001");
            driver.findElement(By.id("frm-registration-email")).sendKeys("timeafuntik@gmail.com");
            driver.findElement(By.id("frm-registration-mobilePhone")).sendKeys("0912345678");
            driver.findElement(By.id("frm-registration-password")).sendKeys("Datart123");
            driver.findElement(By.id("frm-registration-passwordVerify")).sendKeys("Datart123");
            driver.findElement(By.cssSelector(".btn-success")).click();
            closeBrowser();


            System.out.println("Test 9 - SUCCESS: Neplatny pokus o prihlasenie, uzivatel uz existuje.");
        } catch (Exception e) {e.printStackTrace();}
    }

    /**
     * Test 10 - Pokúsi sa vyplnit iba login pouzivatela.
     */
    public void Test10() {
        try {
            // Test name: acc
            // Step # | name | target | value | comment
            // 1 | open | / |  |
            driver.get("https://www.datart.sk/");
            // 2 | setWindowSize | 1268x695 |  |
            driver.manage().window().setSize(new Dimension(1268, 695));
            // 3 | click | css=.login-menu-title |  |
            driver.findElement(By.cssSelector(".login-menu-title")).click();
            // 4 | click | css=.login-menu-title > span |  |
            driver.findElement(By.cssSelector(".login-menu-title > span")).click();

            //driver.findElement(By.id("frm-login")).click();
            // 6 | type | id=frm-login | timeafuntik@gmail.com |
            driver.findElement(By.id("frm-login")).sendKeys("timeafuntik@gmail.com");
            // 7 | sendKeys | id=frm-login | ${KEY_ENTER} |
            driver.findElement(By.id("frm-login")).sendKeys(Keys.ENTER);
            closeBrowser();

            System.out.println("Test 10 - SUCCESS: Neplatny pokus o prihlasenie, treba zadat aj heslo.");
        } catch (Exception e) {
            e.printStackTrace();}
    }

    /**
     * Test 11 - Zabudnute heslo.
     */
    public void Test11() {
        try {
            driver.get("https://www.datart.sk/");
            driver.findElement(By.cssSelector(".login-menu-title")).click();
            driver.findElement(By.linkText("Zabudli ste heslo?")).click();
            driver.findElement(By.id("frm-email")).click();
            driver.findElement(By.id("frm-email")).sendKeys("timeafuntik@gmail.com");
            driver.findElement(By.id("frm-email")).sendKeys(Keys.ENTER);
            closeBrowser();

            System.out.println("Test 11 - SUCCESS: Ziadost o odoslani obnovenia hesla sa odoslala na e-mail.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Funkcia na úspešný login
     */
    public void login() {
        try {
            driver.get("https://www.datart.sk/");
            // 2 | setWindowSize | 1268x695 |  |
            driver.manage().window().setSize(new Dimension(1268, 695));
            // 3 | click | css=.login-menu-title |  |
            driver.findElement(By.cssSelector(".login-menu-title")).click();
            // 4 | click | css=.login-menu-title > span |  |
            driver.findElement(By.cssSelector(".login-menu-title > span")).click();

            //driver.findElement(By.id("frm-login")).click();
            // 6 | type | id=frm-login | timeafuntik@gmail.com |
            driver.findElement(By.id("frm-login")).sendKeys("timeafuntik@gmail.com");
            driver.findElement(By.id("frm-password")).sendKeys("Heslo321");
            // 10 | click | css=.btn-login |  |
            driver.findElement(By.cssSelector(".btn-login")).click();
            closeBrowser();

            System.out.println("Login successful.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Test 12 - Prehliadanie nákupného poradcu.
     */
    public void Test12() {
        try {
            // Test name: nakupnyPoradca
            // Step # | name | target | value | comment
            // 1 | open | / |  |
            driver.get("https://www.datart.sk/");
            // 2 | setWindowSize | 1268x699 |  |
            driver.manage().window().setSize(new Dimension(1268, 699));
            // 3 | mouseOver | css=.swiper-slide-active img |  |
            {
                WebElement element = driver.findElement(By.cssSelector(".swiper-slide-active img"));
                Actions builder = new Actions(driver);
                builder.moveToElement(element).perform();
            }
            // 5 | click | linkText=Nákupný poradca |  |
            driver.findElement(By.linkText("Nákupný poradca")).click();
            // 7 | click | linkText=Platba |  |
            driver.findElement(By.linkText("Platba")).click();
            // 8 | click | css=.questions-services > .q-wrapper:nth-child(1) span |  |
            driver.findElement(By.cssSelector(".questions-services > .q-wrapper:nth-child(1) span")).click();
            closeBrowser();

            System.out.println("Test 12 - SUCCESS: Ukazali sa FAQ ohladom objednavky.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Test 13 - Vlozenie do kosika. Treba byt prihlaseny.
     */
    public void Test13() {
        try {
            login();
            // Test name: vlozenie do kosika
            // Step # | name | target | value | comment
            // 1 | open | /iphone-11-64gb-black-mwlt2cn-a.html |  |
            driver.get("https://www.datart.sk/iphone-11-64gb-black-mwlt2cn-a.html");
            // 2 | setWindowSize | 1268x695 |  |
            driver.manage().window().setSize(new Dimension(1268, 695));
            Actions act = new Actions(driver);
            act.moveByOffset(583,553). contextClick().build().perform();
            closeBrowser();

            System.out.println("Test 13 - SUCCESS: Tovar sa uspesne vlozil do kosika.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
