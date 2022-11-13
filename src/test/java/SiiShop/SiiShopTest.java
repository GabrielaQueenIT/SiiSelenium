package SiiShop;

import Base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SiiShopTest extends BaseTest {

//    private static final Logger log = LoggerFactory.getLogger(SiiShopTest.class); //zamiast tegi jest @Slf4j

    @Test
    public void loginToSystem() throws InterruptedException {
        String url = "http://146.59.32.4/index.php";
        log.info("url naszej aplikacji to: " + url);
        driver.get(url);
        String actualTitle = driver.getTitle();
        log.info("Actual title is: " + actualTitle);
        String expectedTitle = "TesterSii";
        //asercja(musi być ostatnia i jest obowiązkowa!!!)
        assertThat(expectedTitle).isEqualTo(actualTitle);
        assertThat(actualTitle).startsWith("T");
        assertThat(actualTitle).isNotBlank();
        assertThat(22).isLessThan(55);
    }

    @Test
    public void loginToPudelek() throws InterruptedException {
        String url = "http://pudelek.pl";
        log.info("url naszej aplikacji to: " + url);
        driver.get(url);
    }

    @Test
    public void loginToWpPl() throws InterruptedException {
        String url = "http://wp.pl";
        log.info("url naszej aplikacji to: " + url);
        driver.get(url);
        String title = driver.getTitle();
        log.info("Actual title is: " + title);
    }
}