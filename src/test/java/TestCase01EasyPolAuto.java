import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import pages.AutoOglasiPretraga;
import pages.Index;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testingData.StandardData;
import testingData.TimeDelay;

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





            //Inventory inventory = new Inventory(driver);

//            //Find - "PRODUCTS" header
//            String headerText = inventory.getProductHeaderText();
//            System.out.println("Find word PRODUCTS. Located element is: " + headerText);
//            Assert.assertEquals("PRODUCTS", headerText, "ERROR - PRODUCTS HEADER NOT FOUND");
//            //Find - shopping cart
//            boolean shoppingCart = inventory.getShoppingCartPresent();
//            System.out.println("Find element SHOPPING CART. Element found: " + shoppingCart);
//            Assert.assertTrue(shoppingCart, "ERROR - Element Shopping Cart not found!");
//
//            //Find - burger menu in the upper left corner
//            boolean burgerMenu = inventory.getBurgerMenuPresent();
//            System.out.println("Find element BURGER MENU BUTTON. Element found: " + burgerMenu);
//            Assert.assertTrue(burgerMenu, "ERROR - Element Burger Menu Button not found!");
//
//            //Find - Twitter, Facebook, Linkedin links
//            String tweeterLink = inventory.getTweeterLinkPresent();
//            System.out.println("Find element TWEETER LINK. Element found: " + tweeterLink);
//            Assert.assertEquals(tweeterLink, StandardData.SAUCE_DEMO_TWEETER_LINK, "ERROR - TWEETER WEB LINK NOT FOUND");
//
//            //Find - Twitter, Facebook, Linkedin links
//            String linkedInLink = inventory.getLinkedinLinkPresent();
//            System.out.println("Find element LINKEDIN LINK. Element found: " + linkedInLink);
//            Assert.assertEquals(linkedInLink, StandardData.SAUCE_DEMO_LINKEDIN_LINK, "ERROR - LINKEDIN WEB LINK NOT FOUND");
//
//            //Find - Twitter, Facebook, Linkedin links
//            String facebookLink = inventory.getFacebookLinkPresent();
//            System.out.println("Find element FACEBOOK LINK. Element found: " + facebookLink);
//            Assert.assertEquals(facebookLink, StandardData.SAUCE_DEMO_FACEBOOK_LINK, "ERROR - FACEBOOK WEB LINK NOT FOUND");
//
//            //Find - Logout
//            Inventory buttonBurgerMenu = inventory.clickButtonBurgerMenu();
//            boolean logoutInMenu = inventory.getLogoutPresent();
//            System.out.println("Find element LOGOUT IN BURGER MENU. Element found: " + logoutInMenu);
//            Assert.assertTrue(logoutInMenu, "ERROR - Element Logout not found!");
        }


        @AfterMethod(alwaysRun = true)
        public void tearDownTest(){
            quitDriver(driver);
        }
}
