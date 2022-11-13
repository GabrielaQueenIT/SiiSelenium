package Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Arrays;

@Slf4j
public class DriverFactory {

    private WebDriver driver;

    public WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                log.info("Browser = " + browser);
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
                break;
            case "firefox":
                log.info("Browser = " + browser);
                WebDriverManager.firefoxdriver().setup();
                //options aren't working with options
//                FirefoxOptions optionsFirefox = new FirefoxOptions();
//                optionsFirefox.addArguments("start-maximized");
//                optionsFirefox.addArguments("incognito");
//                  optionsFirefox.addArguments("headless");
//                optionsFirefox.addArguments("--ignore-certificate-errors");
//                  driver.manage().window().maximize();

                driver = new FirefoxDriver();

                //wait strategy [prędkości w różnych środowiskach]
                //1. implicity wait ->
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));// czekanie na WebElementy zeby Selunium poczekalo
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2)); //ladowanie sie strony na poczatku przed driver.get(url)
                //2. explicit wait
                //3. fluent wait
                break;
            default:
                log.info("Browser = " + browser);
                WebDriverManager.chromedriver().setup(); //wywoluje WebDriverManager -> pobierze na nasz dysk odpowiedniej wersji drivera Chroma
                ChromeOptions optionsChromeDefault = new ChromeOptions();
                optionsChromeDefault.addArguments("start-maximized"); //otwieramy okno maksymalizowane
                optionsChromeDefault.addArguments("incognito"); //otwieramy w trybie incognito, zyskujemy ok 7% czasu bo nie ma cookies
//        optionsChrome.addArguments("headless"); // nie widzimy graficznych okien przegladarki ale wszsytko sie robi
                optionsChromeDefault.addArguments("--ignore-certificate-errors"); //certyfikaty http są ignorowane
                optionsChromeDefault.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));//usuwa info bar
//        driver.manage().window().maximize();
                driver = new ChromeDriver(optionsChromeDefault);
                //wait strategy [prędkości w różnych środowiskach]
                //1. implicity wait ->
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));// czekanie na WebElementy zeby Selunium poczekalo
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2)); //ladowanie sie strony na poczatku przed driver.get(url)
                //2. explicit wait
                //3. fluent wait
                break;
        }
        return this.driver;
    }

}
