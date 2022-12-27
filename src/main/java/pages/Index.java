package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testingData.StandardData;
import testingData.TimeDelay;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Index extends BasePageClass {

    private final String indexURL = StandardData.INDEX_URL;
    private final By buttonDetaljnaPretraga = By.xpath("//button[text()='DETALJNA PRETRAGA']");

    public Index (WebDriver driver) {
        super(driver);
    }

    public Index open(){
        openUrl(indexURL);
        return this;
    }

    public Index DetaljnaPretragaClick(){
        buttonClick(buttonDetaljnaPretraga);
        return this;
    }

    //@Deprecated
    public Index SwitchToMainTab(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeDelay.DELAY_3_SEC));

        String MainWindow=driver.getWindowHandle();
        driver.switchTo().window(MainWindow);
        return this;
//        Set<String> s1=driver.getWindowHandles();
//        Iterator<String> i1=s1.iterator();
//        while (i1.hasNext()) {
//            String ChildWindow = i1.next();
//            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
//                driver.switchTo().window(ChildWindow);
//                driver.close();
//            }driver.switchTo().window(MainWindow);
//        }return this;

    }

}
