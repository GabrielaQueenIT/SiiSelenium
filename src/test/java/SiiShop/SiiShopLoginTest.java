package SiiShop;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SiiShopLoginTest {

    private WebDriver driver;

    @Test
    void loginToApplication() {


        // 0. Konfiguracja Webdrivera -> spore wyzwanie//TO JEST KONIECZNOSC
        String browser = "chrome";
        driver= new ChromeDriver();

        // page object model
        //DO TEGO DĄŻYMY:
        //1. zwięzła
        //2. musi mieć asercje
    }
}
