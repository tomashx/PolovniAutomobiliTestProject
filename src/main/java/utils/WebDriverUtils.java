package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import testingData.TimeDelay;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.time.Duration;

public class WebDriverUtils {
    private static WebDriver driver;
    public static WebDriver setUpWebDriver(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        //options.addArguments("--disable-extensions");
        options.addArguments("--enable-automation");
        //options.addArguments("--load-extension=//src/main/java/utils/adBlockPlus");
        options.addExtensions(new File("src/main/java/utils/ublock_origin_lite.crx"));
        //options.addArguments("--blink-settings=imagesEnabled=false");
        driver = new ChromeDriver(options);

        //driver = WebDriverManager.chromedriver(options).create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeDelay.DELAY_3_SEC));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeDelay.DELAY_5_SEC));
        return driver;
    }

    public static void driverExit(WebDriver driver){
        driver.quit();
    }
}