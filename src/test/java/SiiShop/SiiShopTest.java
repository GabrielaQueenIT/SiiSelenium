package SiiShop;

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
public class SiiShopTest {
    private WebDriver driver;
//    private static final Logger log = LoggerFactory.getLogger(SiiShopTest.class); //zamiast tegi jest @Slf4j
    @BeforeAll
    static void setConfigurations(){
        log.info("Start data base");
    }
    @BeforeEach
    void setUpDriver(){
        WebDriverManager.chromedriver().setup(); //wywoluje WebDriverManager -> pobierze na nasz dysk odpowiedniej wersji drivera Chroma


        ChromeOptions optionsChrome = new ChromeOptions();

        optionsChrome.addArguments("start-maximized"); //otwieramy okno maksymalizowane
        optionsChrome.addArguments("incognito"); //otwieramy w trybie incognito, zyskujemy ok 7% czasu bo nie ma cookies
//        optionsChrome.addArguments("headless"); // nie widzimy graficznych okien przegladarki ale wszsytko sie robi
        optionsChrome.addArguments("--ignore-certificate-errors"); //certyfikaty http są ignorowane
        optionsChrome.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));//usuwa info bar
//        driver.manage().window().maximize();

        driver = new ChromeDriver(optionsChrome);
        //wait strategy [prędkości w różnych środowiskach]
        //1. implicity wait ->
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));// czekanie na WebElementy zeby Selunium poczekalo
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2)); //ladowanie sie strony na poczatku przed driver.get(url)
        //2. explicit wait
        //3. fluent wait
    }
    @AfterEach
    void exit(){
        driver.quit(); //cała przeglądarka, a -> driver.close() to bieżąca okno, robi za nas wszystko
        log.info("Driver has been closed properly");
        log.info("****************TEST PASS :) ");
    }
    @AfterAll
    static void closeConnection(){
        log.info("Data base connection close");
    }

    @Test
    public void loginToSystem() throws InterruptedException {
        //konfiguracja WevDrivera
        String browser = "chrome";
        String url = "http://146.59.32.4/index.php";
        log.info("url naszej aplikacji to: " + url);
        log.info("Przeglądarka: " + browser);
        driver.get(url);
        String actualTitle = driver.getTitle();
        log.info("Actual title is: "+ actualTitle);
        String expectedTitle = "TesterSii";
        //asercja(musi być ostatnia i jest obowiązkowa!!!)
        assertThat(expectedTitle).isEqualTo(actualTitle);
        assertThat(actualTitle).startsWith("T");
        assertThat(actualTitle).isNotBlank();
        assertThat(22).isLessThan(55);
    }
    @Test
    public void loginToPudelek() throws InterruptedException {
        //konfiguracja WevDrivera
        String browser = "chrome";
        String url = "http://pudelek.pl";
        log.info("url naszej aplikacji to: " + url);
        log.info("Przeglądarka: " + browser);
        driver.get(url);
        Thread.sleep(1000);
    }
    @Test
    public void loginToWpPl() throws InterruptedException {
        //konfiguracja WevDrivera
        String browser = "chrome";
        String url = "http://wp.pl";
        log.info("url naszej aplikacji to: " + url);
        log.info("Przeglądarka: " + browser);
        driver.get(url);
        String title = driver.getTitle();
        log.info("Actual title is: "+title);
        Thread.sleep(1000);
    }
}