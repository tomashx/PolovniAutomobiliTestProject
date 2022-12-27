package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testingData.TimeDelay;

public class AutoOglasiPretraga extends BasePageClass {

    private final By brendClickLocator = By.xpath("//*[contains(@class, 'sumo_brand')]");

    private final By brendAudiLocator = By.xpath("//*[contains(@class, 'sumo_brand')]//label[text()='Audi']");

    private final By modelClickLocator = By.xpath("//*[contains(@class, 'sumo_model')]");

    private final By modelSearchLocator = By.xpath("//*[@title=' Svi modeli']//*[contains(@class, 'search-txt')]");


    private final By modelA4Locator = By.xpath("//*[contains(@class, 'sumo_model')]//*[contains(@class, 'options')]/li[8]/span/i");

    private final By chassisClickLocator = By.xpath("//*[contains(@class, 'sumo_chassis')]");

    private final By limuzinaLocator = By.xpath("//*[contains(@class, 'sumo_chassis')]//*[contains(@class, 'options')]/li/span/i");
    private final By minCenaLocator = By.id("price_from");

    private final By maxCenaLocator = By.id("price_to");

    private final By fuelClickLocator = By.xpath("//*[contains(@class, 'sumo_fuel')]");

    private final By benzinLocator = By.xpath("//*[contains(@class, 'sumo_fuel')]//*[contains(@class, 'options')]/li/span/i");

    private final By pronadjiNeZelimAnketa = By.xpath("//*[@id='btn_poll_no']");

    private final By regionClick = By.xpath("//*[@title=' Region']//*[contains(@class, 'placeholder')]");

    private final By selectRegionBeograd = By.xpath("//*[contains(@class, 'sumo_region')]//label[text()='Beograd']");

    private final By godinaOdClick = By.xpath("//*[@title=' Godina od']//*[contains(@class, 'placeholder')]");

    private final By selectGodinaOd = By.xpath("//*[contains(@class, 'sumo_year_from')]//label[text()='2005 god.']");

    private final By godinaDoClick = By.xpath("//*[@title=' do']//*[contains(@class, 'placeholder')]");

    private final By selectGodinaDo = By.xpath("//*[contains(@class, 'sumo_year_to')]//label[text()='2020 god.']");

    private final By brojVrataClick = By.xpath("//*[@title=' Broj vrata']//*[contains(@class, 'placeholder')]");

    private final By selectVrata45 = By.xpath("//label[text()='4/5 vrata']");

    private final By pretrazi = By.id("submit_1");

    public AutoOglasiPretraga (WebDriver driver) {
        super(driver);
    }

    public AutoOglasiPretraga clickBrend(){
        buttonClick(brendClickLocator);
        return this;
    }
    public AutoOglasiPretraga selectAudi(){
        buttonClick(brendAudiLocator);
        return this;
    }

    public AutoOglasiPretraga clickModel(){
        try {
            WebElement modelClick = locatedElementVisibleWait(modelClickLocator, TimeDelay.DELAY_5_SEC);
            boolean modelClickJeVidljiv = modelClick.isDisplayed();
            if (modelClickJeVidljiv) {
            buttonClick(modelClickLocator);
            } else
                System.out.println("Ne mogu da kliknem model");
        } catch (Exception e) {
            System.out.println(e);
        }
        return this;
    }

    public AutoOglasiPretraga pretraziA4 (String pretraziModel){
        WebElement modelTextField = locatedElementVisibleWait(modelSearchLocator, TimeDelay.DELAY_3_SEC);
        typeInElement(modelTextField, pretraziModel);
        return this;
    }


    public AutoOglasiPretraga selectA4() {

        try {
            WebElement modelSelection = locatedElementVisibleWait(modelA4Locator, TimeDelay.DELAY_5_SEC);
            boolean modelSelectionJeVidljiv = modelSelection.isDisplayed();
            if (modelSelectionJeVidljiv) {
                buttonClick(modelA4Locator);
            } else
                System.out.println("Ne mogu da nadjem A4");
        } catch (Exception e) {
            System.out.println(e);
        }
        return this;
    }

    public AutoOglasiPretraga clickMinCena(){
        buttonClick(minCenaLocator);
        return this;
    }

    public AutoOglasiPretraga upisiMinCenu(String minCena){
        WebElement minCenaTextField = locatedElementVisibleWait(minCenaLocator, TimeDelay.DELAY_3_SEC);
        clearTypeTextInElement(minCenaTextField, minCena);
        return this;
    }

    public AutoOglasiPretraga upisiMaxCenu(String maxCena){
        WebElement maxCenaTextField = locatedElementVisibleWait(maxCenaLocator, TimeDelay.DELAY_3_SEC);
        clearTypeTextInElement(maxCenaTextField, maxCena);
        return this;
    }

    public AutoOglasiPretraga clickKaroserija(){
        buttonClick(chassisClickLocator);
        return this;
    }

    public AutoOglasiPretraga selectLimuzina(){
        buttonClick(limuzinaLocator);
        return this;
    }

    public AutoOglasiPretraga clickGorivo(){
        try {
            WebElement gorivoClick = locatedElementVisibleWait(fuelClickLocator, TimeDelay.DELAY_3_SEC);
            boolean gorivoClickIsVisible = gorivoClick.isDisplayed();
            if(gorivoClickIsVisible){
            buttonClick(fuelClickLocator);
            }else
                System.out.println("Ne mogu da kliknem gorivo");
        } catch (Exception e) {
            System.out.println(e);
        }
        return this;
    }

    public AutoOglasiPretraga selectBenzin(){
        try {
            WebElement benzinSelect = locatedElementVisibleWait(benzinLocator, TimeDelay.DELAY_3_SEC);
            boolean benzinSelectIsVisible = benzinSelect.isDisplayed();
            if(benzinSelectIsVisible){
                buttonClick(benzinLocator);
            }else
                System.out.println("Ne mogu da kliknem benzin");
        }catch (Exception e) {
            System.out.println(e);
        }
        return this;
    }

    public AutoOglasiPretraga clickRegion(){
        try {
            WebElement gorivoClick = locatedElementVisibleWait(regionClick, TimeDelay.DELAY_3_SEC);
            boolean gorivoClickIsVisible = gorivoClick.isDisplayed();
            if(gorivoClickIsVisible){
                buttonClick(regionClick);
            }else
                System.out.println("Ne mogu da kliknem region");
        } catch (Exception e) {
            System.out.println(e);
        }
        return this;
    }

    public AutoOglasiPretraga selectBeograd(){
        try {
            WebElement benzinSelect = locatedElementVisibleWait(selectRegionBeograd, TimeDelay.DELAY_3_SEC);
            boolean benzinSelectIsVisible = benzinSelect.isDisplayed();
            if(benzinSelectIsVisible){
                buttonClick(selectRegionBeograd);
            }else
                System.out.println("Ne mogu da kliknem Beograd");
        }catch (Exception e) {
            System.out.println(e);
        }
        return this;
    }

    public AutoOglasiPretraga clickGodinaOd(){
        buttonClick(godinaOdClick);
        return this;
    }

    public AutoOglasiPretraga selectGodina2005(){
        buttonClick(selectGodinaOd);
        return this;
    }
    public AutoOglasiPretraga clickGodinaDo(){
        buttonClick(godinaDoClick);
        return this;
    }

    public AutoOglasiPretraga selectGodina2020(){
        buttonClick(selectGodinaDo);
        return this;
    }

    public AutoOglasiPretraga clickBrojVrata(){
        buttonClick(brojVrataClick);
        return this;
    }

    public AutoOglasiPretraga selectBrojVrata(){
        buttonClick(selectVrata45);
        return this;
    }

    public AutoOglasiPretraga pretrazi(){
        buttonClick(pretrazi);
        return this;
    }

    public AutoOglasiPretraga pronadjiAnketu() {


        try {
            WebElement anketaNeZelim = locatedElementVisibleWait(pronadjiNeZelimAnketa, TimeDelay.DELAY_3_SEC);
            boolean anketaJeVidljiva = anketaNeZelim.isDisplayed();
            if (anketaJeVidljiva) {
                anketaNeZelim.click();
                System.out.println("Anketa postoji na strani, klik na ne zelim");
            } else
                System.out.println("Anketa ne postoji na strani");
        } catch (Exception e) {
            System.out.println(e);
        }return this;
    }
}
