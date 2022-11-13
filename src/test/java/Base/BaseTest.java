package Base;

import Factory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Arrays;

@Slf4j
public class BaseTest { //w baseTest możemy dodać Hooki

    protected WebDriver driver;
    protected static DriverFactory driverFactory;

    @BeforeAll
    static void setConfigurations() {
        driverFactory = new DriverFactory();
    }

    @BeforeEach
    void setUpDriver() {
        driver = driverFactory.getDriver("blablabla"); //zasada kuriera - kurier przynosi nam paczke, musimy ja odebrac dlatego zapisujemy ja do drivera, i ten driver jest protected
        log.info("WebDriver started successfully");
    }

    @AfterEach
    void exit() {
        driver.quit(); //cała przeglądarka, a -> driver.close() to bieżąca okno, robi za nas wszystko
        log.info("Driver has been closed properly");
    }
//    @AfterAll
//    static void closeConnection(){
//        log.info("Data base connection close");
//    }

}
