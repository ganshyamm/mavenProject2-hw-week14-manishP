package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Desktops extends UtilityClass {
    By currencyLink = By.xpath("//span[contains(text(),'Currency')]");

    public void clickOnCurrencyLink() {
        clickOnElement(currencyLink);
    }

    By clickOnPoundSterling = By.xpath("//button[contains(text(),'£ Pound Sterling')]");

    public void setClickOnPoundSterling() {
        clickOnElement(clickOnPoundSterling);
    }

    By clickOnShowAllDeskTop = By.xpath("//a[contains(text(),'Show All Desktops')]");

    public void clickOnAllDesktop() {
        clickOnElement(clickOnShowAllDeskTop);
    }

    By sortByNameZtoA = By.id("input-sort");

    public void SortByNameZtoAFromDropdown() {
        sendTextToElement(sortByNameZtoA, "Name (Z - A)");

    }

    By clickOnHpLp3065 = By.xpath("//a[contains(text(),'HP LP3065')]");

    public void clickOnHPlp3065() {
        clickOnElement(clickOnHpLp3065);
    }


    By verifyText = By.xpath("//h1[contains(text(),'HP LP3065')]");

    public String getVerifyText() {
        return getTextFromElement(verifyText);
    }


    By selectQuantity = By.name("quantity");

    public void changeQuantity(String quantity) {
        sendTextToElement(selectQuantity, quantity);
    }

    By addToCart = By.xpath("//button[@id='button-cart']");

    public void clickOnAdToCart() {
        clickOnElement(addToCart);
    }


    By verifyTextHplp3065 = By.xpath("//h1[contains(text(),'HP LP3065')]");

    public String getVerifyTextHp() {
        return getTextFromElement(verifyTextHplp3065);
    }


    By clickShoppingCart = By.xpath("//button[@id='button-cart']");

    public void clickOnShoppingCart() {
        clickOnElement(clickShoppingCart);
    }

    By verifyShoppingCart = By.xpath("//div[@id='content']//h1");

    public String getVerifyShoppingCart() {
        return getTextFromElement(verifyShoppingCart);
    }

    By verifyHPlp3065 = By.xpath("//h1[contains(text(),'HP LP3065')]");

    public String getVerifyProductName() {
        return getTextFromElement(verifyHPlp3065);
    }

    By verifyModel = By.xpath("//li[contains(text(),'Product Code: Product 21')]");
    public String getVerifyModel() {
        return getTextFromElement(verifyModel);
    }

    By verifyDate = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");

    public String getVerifyDeliveryDate() {
        return getTextFromElement(verifyDate);
    }
    public void selectDeliveryDate(){
        //select delivery date
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        //desktops.selectDeliveryDate();
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }
    public void verifyZtoAFromDropDroDown(){
        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectbyvisibleTextFRomDropDown(By.id("input-sort"), "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);


    }
}


