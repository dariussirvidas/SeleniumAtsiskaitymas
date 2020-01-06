import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {
    static WebDriver chrome;
    static final int WAIT_TIME_SEC = 2;

    public static void setupChrome() {
        System.setProperty("webdriver.chrome.driver", ".\\.\\drivers\\chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.get("http://localhost/selenium/filmai.php");
    }

    public static void closeChrome() {
        chrome.close();
    }

    public static WebElement waitByCssSelector(String selector) {
        WebDriverWait waiter = new WebDriverWait(chrome, WAIT_TIME_SEC);
        return waiter.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
    }

    public static void addEntry(String pavadinimas, String zanras, String rezisierius) {
        WebElement inputPavadinimas = waitByCssSelector("input[name=\"pavadinimas\"]");
        WebElement inputZanras = waitByCssSelector("input[name=\"zanras\"]");
        WebElement inputRezisierius = waitByCssSelector("input[name=\"rezisierius\"]");
        WebElement buttonSiusti = waitByCssSelector("button[name=\"insert\"]");
        inputPavadinimas.sendKeys(pavadinimas);
        inputZanras.sendKeys(zanras);
        inputRezisierius.sendKeys(rezisierius);
        buttonSiusti.click();
    }

    public static void editEntry(int id, String pavadinimas, String zanras, String rezisierius) {
        WebElement inputId = waitByCssSelector("input[name=\"id\"]");
        WebElement inputPavadinimas = waitByCssSelector("input[name=\"pavadinimas\"]");
        WebElement inputZanras = waitByCssSelector("input[name=\"zanras\"]");
        WebElement inputRezisierius = waitByCssSelector("input[name=\"rezisierius\"]");
        WebElement buttonRedaguoti = waitByCssSelector("button[name=\"update\"]");
        inputId.sendKeys(String.valueOf(id));
        inputPavadinimas.sendKeys(pavadinimas);
        inputZanras.sendKeys(zanras);
        inputRezisierius.sendKeys(rezisierius);
        buttonRedaguoti.click();
    }

    public static void deleteEntry(int id) {
        WebElement inputId = waitByCssSelector("input[name=\"id\"]");
        WebElement buttonTrinti = waitByCssSelector("button[name=\"delete\"]");
        inputId.sendKeys(String.valueOf(id));
        buttonTrinti.click();
    }

}
