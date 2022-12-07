package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends UtilityClass {
    By desktopLink = By.linkText("Desktops");

    public void clickOnDesktopLink() {
        clickOnElement(desktopLink);
    }

    By verifyText = By.xpath("//h2[contains(text(),'Desktops')]");

    public String getVerifyText() {
        return getTextFromElement(verifyText);
    }

    By laptopNotebookLink = By.linkText("Laptops & Notebooks");

    public void clickOnLaptopNotebooksLink() {
        clickOnElement(laptopNotebookLink);
    }


    By verifyText1 = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");

    public String getVerifyText1() {
        return getTextFromElement(verifyText1);
    }


    By componentsLink = By.linkText("Components");

    public void clickOnComponentsLink() {
        clickOnElement(componentsLink);
    }

    By verifyText2 = By.xpath("//h2[contains(text(),'Components')]");

    public String getVerifyText2() {
        return getTextFromElement(verifyText2);
    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }


}
