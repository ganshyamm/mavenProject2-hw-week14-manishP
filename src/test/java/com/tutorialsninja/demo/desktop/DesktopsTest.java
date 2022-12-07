package com.tutorialsninja.demo.desktop;

import com.tutorialsninja.demo.pages.Desktops;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooks;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesktopsTest extends BaseTest {
    HomePage homePage = new HomePage();
    Desktops desktops = new Desktops();
    LaptopsAndNotebooks laptopsAndNotebooks = new LaptopsAndNotebooks();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {

        homePage.clickOnDesktopLink();
        desktops.clickOnAllDesktop();
        desktops.verifyZtoAFromDropDroDown();

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully () throws InterruptedException {
        desktops.clickOnCurrencyLink();
        laptopsAndNotebooks.changeCurrency();
        homePage.clickOnDesktopLink();
        desktops.clickOnAllDesktop();
        desktops.SortByNameZtoAFromDropdown();
        desktops.clickOnHPlp3065();
        String expectedMessage = "HP LP3065";
        Assert.assertEquals(desktops.getVerifyTextHp(), expectedMessage, "Error Message not displayed");
        desktops.selectDeliveryDate();

        desktops.clickOnAdToCart();
        String expectedMessage1 = "Success: You have added HP LP3065 to your shopping cart!";
        Assert.assertEquals(desktops.getVerifyShoppingCart(), expectedMessage, "Error Message not displayed");
        desktops.clickOnShoppingCart();
        Thread.sleep(3000);
        String expectedM = "HP LP3065";
        Assert.assertEquals(desktops.getVerifyProductName(), "HP LP3065", "Error Message not displayed");
       String expectedM1 = "Product Code: Product 21";
        Assert.assertEquals(desktops.getVerifyModel(), "Product Code: Product 21", "Error Message not displayed");
        Thread.sleep(2000);


    }
}

