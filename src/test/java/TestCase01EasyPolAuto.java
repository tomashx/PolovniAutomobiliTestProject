
import org.testng.annotations.AfterMethod;
import pages.AutoOglasiPretraga;
import pages.Index;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testingData.StandardData;

public class TestCase01EasyPolAuto extends BaseTestClass {

        private WebDriver driver;
        private String minCena;
        private String maxCena;

        private String pretraziModel;

        @BeforeMethod
        public void setUpTest(){
            driver = setUpDriver();
            minCena = StandardData.MIN_CENA_VOZILA;
            maxCena = StandardData.MAX_CENA_VOZILA;
            pretraziModel = "A4";

        }

        @Test
        public void TC_01() throws InterruptedException {
            Index zatvoriTab = new Index(driver);
            Index zatvoriDrugiTab = zatvoriTab.SwitchToMainTab();

            //Otvori web stranu
            Index index = new Index(driver).open();


            AutoOglasiPretraga pretraga = new AutoOglasiPretraga(driver);




            //Klikni na detaljna pretraga
            Index buttonDetaljnaPretraga = index.DetaljnaPretragaClick();

            //Ako postoji anketa klikni na ne zelim
            AutoOglasiPretraga neZelimAnketu = pretraga.pronadjiAnketu();

            AutoOglasiPretraga clickBrend = pretraga.clickBrend().selectAudi();
            Thread.sleep(1000);
            AutoOglasiPretraga model = pretraga.clickModel().clickModel().pretraziA4(pretraziModel).selectA4();
            AutoOglasiPretraga cena = pretraga.clickMinCena().upisiMinCenu(minCena).upisiMaxCenu(maxCena);
            AutoOglasiPretraga karoserija = pretraga.clickKaroserija().selectLimuzina();
            AutoOglasiPretraga gorivo = pretraga.clickGorivo().selectBenzin();
            AutoOglasiPretraga region = pretraga.clickRegion().selectBeograd();
            AutoOglasiPretraga godina = pretraga.clickGodinaOd().selectGodina2005().clickGodinaDo().selectGodina2020();
            AutoOglasiPretraga brojVrata = pretraga.clickBrojVrata().selectBrojVrata();
            AutoOglasiPretraga pretrazi = pretraga.pretrazi();

        }


        @AfterMethod(alwaysRun = true)
        public void tearDownTest(){
            quitDriver(driver);
        }
}
