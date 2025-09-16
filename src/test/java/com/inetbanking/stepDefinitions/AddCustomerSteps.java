package com.inetbanking.stepDefinitions;

import org.junit.Assert;
import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.testCases.BaseClass;
import com.inetbanking.utilities.ReadConfig;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCustomerSteps {
    LoginPage lp;
    AddCustomerPage addcust;
    ReadConfig config = new ReadConfig();

    @Given("the user is logged into the application")
    public void the_user_is_logged_into_the_application() throws InterruptedException {
    	
    	BaseClass.driver.get(config.getApplicationURL());
        lp = new LoginPage(BaseClass.driver);
        lp.setUserName(config.getUsername());
        lp.setPassword(config.getPassword()); // Replace with actual password
        lp.clickSubmit();
        Thread.sleep(3000);
    }

    @When("the user navigates to the Add New Customer page")
    public void the_user_navigates_to_add_new_customer_page() {
        addcust = new AddCustomerPage(BaseClass.driver);
        addcust.clickAddNewCustomer();
    }

    @And("the user enters customer name as {string}")
    public void the_user_enters_customer_name(String name) {
        addcust.custName(name);
    }

    @And("the user selects gender as {string}")
    public void the_user_selects_gender(String gender) {
        addcust.custgender(gender);
    }

    @And("the user enters date of birth as {string}, {string}, {string}")
    public void the_user_enters_dob(String mm, String dd, String yyyy) throws InterruptedException {
        addcust.custdob(mm, dd, yyyy);
        Thread.sleep(5000);
    }

    @And("the user enters address as {string}")
    public void the_user_enters_address(String address) {
        addcust.custaddress(address);
    }

    @And("the user enters city as {string}")
    public void the_user_enters_city(String city) {
        addcust.custcity(city);
    }

    @And("the user enters state as {string}")
    public void the_user_enters_state(String state) {
        addcust.custstate(state);
    }

    @And("the user enters pin number as {string}")
    public void the_user_enters_pin(String pin) {
        addcust.custpinno(pin);
    }

    @And("the user enters telephone number as {string}")
    public void the_user_enters_telephone(String phone) {
        addcust.custtelephoneno(phone);
    }

    @And("the user enters a unique email address")
    public void the_user_enters_unique_email() {
        String email = "pavan" + System.currentTimeMillis() + "@gmail.com";
        addcust.custemailid(email);
    }

    @And("the user enters password as {string}")
    public void the_user_enters_password(String password) {
        addcust.custpassword(password);
    }

    @And("the user submits the customer form")
    public void the_user_submits_customer_form() throws InterruptedException {
        addcust.custsubmit();
        Thread.sleep(3000);
    }

    @Then("the user should see a confirmation message {string}")
    public void the_user_should_see_confirmation_message(String message) {
        Assert.assertTrue(BaseClass.driver.getPageSource().contains(message));
    }
}