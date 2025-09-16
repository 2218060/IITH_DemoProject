package com.inetbanking.stepDefinitions;

import org.junit.Assert;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.testCases.BaseClass;
import com.inetbanking.utilities.ReadConfig;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    ReadConfig config = new ReadConfig();
    LoginPage lp;

    @Given("the user is on the login page")
    public void the_user_is_on_login_page() {
        BaseClass.driver.get(config.getApplicationURL());
        lp = new LoginPage(BaseClass.driver);
    }

    @When("the user enters valid username and password")
    public void the_user_enters_valid_username_and_password() {
        lp.setUserName(config.getUsername());
        lp.setPassword(config.getPassword());
    }

    @And("clicks the login button")
    public void clicks_the_login_button() {
        lp.clickSubmit();
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
//        Assert.assertEquals("Guru99 Bank Manager HomePage", BaseClass.driver.getTitle());
    }

    @And("User should see a welcome message")
    public void user_sees_welcome_message() {
        // Add assertion for welcome message if available
    }
}