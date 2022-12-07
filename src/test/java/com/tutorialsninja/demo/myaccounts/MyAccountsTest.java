package com.tutorialsninja.demo.myaccounts;

import com.tutorialsninja.demo.pages.MyAccount;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountsTest extends BaseTest {
    MyAccount myAccount = new MyAccount();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");
        Assert.assertEquals(myAccount.getVerifyRegister(), "Register Account", "Error Message not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Login");
        Assert.assertEquals(myAccount.getVerifyReturning(), "Returning Customer", "Error Message not displayed");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");

        myAccount.enterFirstName("Prime");
        myAccount.enterLastName("Testing");
        myAccount.enterEmailAdd("testng@gmail.com");
        myAccount.enterPhone("Cucumber123");
        myAccount.enterPassword("02082042526");
        myAccount.enterConfirmPass("02082042526");

        myAccount.clickYesonNewsLetter();
        myAccount.clickOnPrivacy();
        myAccount.clickFinalContinue();

        Assert.assertEquals(myAccount.getVerifyMessage(), "Your Account Has Been Created!", "Error Message not displayed");
        myAccount.clickOnContinueButton();

        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccount.getVerifyLogout(), "Account Logout", "Error Message not displayed");
        myAccount.clickOnContinueTab();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Login");

        myAccount.enterEmailAdd("testng@gmail.com");
        myAccount.enterPassword("02085456204");

        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Logout");
        myAccount.clickOnContinueTab();
    }
}

