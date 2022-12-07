package com.tutorialsninja.demo.laptopandnotebook;

import com.tutorialsninja.demo.pages.Desktops;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooks;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaptopsAndNotebooksTest extends BaseTest {
    Desktops desktops = new Desktops();
    LaptopsAndNotebooks laptopsAndNotebooks = new LaptopsAndNotebooks();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        laptopsAndNotebooks.clickOnLaptopsLink();
        laptopsAndNotebooks.clickOnAllLaptopAndNotebooksLink();
        laptopsAndNotebooks.shortPriceLowToHigh();

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        desktops.clickOnCurrencyLink();
        laptopsAndNotebooks.changeCurrency();

        Thread.sleep(1000);
        laptopsAndNotebooks.clickOnLaptopsLink();
        laptopsAndNotebooks.clickOnAllLaptopAndNotebooksLink();
        laptopsAndNotebooks.shortPriceLowToHigh();
        laptopsAndNotebooks.clickOnMacbookLink();
        Assert.assertEquals(laptopsAndNotebooks.getVerifyMacbook(), "MacBook", "Error Message not displayed");
        laptopsAndNotebooks.clickOnAddToCart();
        Assert.assertEquals(laptopsAndNotebooks.getVerifySuccess(), "Success: You have added MacBook to your shopping cart!\n" +
                "×", "Error Message not displayed");
        laptopsAndNotebooks.clickOnShoppingCart();
        Assert.assertEquals(laptopsAndNotebooks.getVerifyCart(), "shopping cart", "Error Message not displayed");
        Assert.assertEquals(laptopsAndNotebooks.getVerifyProductMacbook(), "MacBook", "Error Message not displayed");

      //  Actions actions1 = new Actions(driver);
        WebElement quantity = driver.findElement(By.xpath("//input[contains(@name, 'quantity')]"));
        quantity.clear();
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[contains(@name, 'quantity')]"), " ");
        laptopsAndNotebooks.clickOnUpdateCart();
        Thread.sleep(1000);
        Assert.assertEquals(laptopsAndNotebooks.getVerifyCartText(), "Success: You have added MacBook to your shopping cart!\n" +
                "×", "Error Message not displayed");
        Assert.assertEquals(laptopsAndNotebooks.getVerifyTotal(), "2 item(s) - £737.45", "Error Message not displayed");

        laptopsAndNotebooks.clickOnCheckoutCart();
        laptopsAndNotebooks.clickOnFinalCheckout();

        Assert.assertEquals(laptopsAndNotebooks.getVerifyCheckout(), "Checkout", "Error Message not displayed");
        Assert.assertEquals(laptopsAndNotebooks.getVerifyNewCustomer(), "New Customer", "Error Message not displayed");
        Thread.sleep(1000);
        laptopsAndNotebooks.clickOnGuestCheckout();
        laptopsAndNotebooks.clickOnContinueTab();
        laptopsAndNotebooks.enterName("Prime");
        laptopsAndNotebooks.enterLastName("Testing");
        laptopsAndNotebooks.enterEmail("testNg@gmail.com");
        laptopsAndNotebooks.enterTelephone("cucumber123");
        laptopsAndNotebooks.enterAddress("postman road");
        laptopsAndNotebooks.enterCity("London");
        laptopsAndNotebooks.enterPostcode("ha86 9La");
        laptopsAndNotebooks.enterCountry("UK");
        laptopsAndNotebooks.enterState("London");

        laptopsAndNotebooks.clickOnCheckout();
        laptopsAndNotebooks.enterText("Please Update Delivery date.");

        laptopsAndNotebooks.clickOnTerms();
        laptopsAndNotebooks.clickContinue();

        Assert.assertEquals(laptopsAndNotebooks.getVerifyWarningMsg(), "Warning: Payment method required!\n" +
                "×", "Error Message not displayed");

    }


}
