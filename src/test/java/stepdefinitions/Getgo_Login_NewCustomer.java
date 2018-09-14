package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.PropertyReader;
import pages.PageLogin;
import pages.PageWelcome;

public class Getgo_Login_NewCustomer
{
	 private static PageWelcome welcomePage = new PageWelcome();
    private static PageLogin loginPage = new PageLogin();

    @When("^I enter password \"([^\"]*)\"$")
    public void i_enter_password(String password) throws Throwable
    {
        loginPage.enterPassword(PropertyReader.testDataOf(password));
    }

    @When("^I click login$")
    public void i_click_login() throws Throwable
    {
        loginPage.clickLogin();
    }

    @Then("^I should see my \"([^\"]*)\" account dashboard with my profile picture & my full name$")
    public void i_should_see_my_account_dashboard_with_my_profile_picture_my_full_name(String accountType) throws Throwable
    {
        loginPage.isLoginSuccess(PropertyReader.testDataOf(accountType + "_FullName"));
    }

    @Given("^I'm login into my \"([^\"]*)\" account with my \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iMLoginIntoMyAccountWithMyAnd(String accountType, String emailID, String password) throws Throwable {
        loginPage.login(PropertyReader.testDataOf(emailID),PropertyReader.testDataOf(password));
    }

    @Then("^System should through an invalid email error message$")
    public void systemShouldThroughAnInvalidEmailErrorMessage() throws Throwable {
        loginPage.userisNotEnrolled();
    }

    @Then("^System should through an invalid password message$")
    public void systemShouldThroughAnInvalidPasswordMessage() throws Throwable {
        loginPage.invalidLoginDetails();
    }
    
    
    @Given("^I'm on Getgo login page with \"([^\"]*)\"$")
    public void i_m_on_Getgo_login_page_with(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	 welcomePage.clickLogin();
    	 loginPage.enterEmail(PropertyReader.testDataOf(arg1));
    	 loginPage.clickNext();
    }

    @When("^I enter a \"([^\"]*)\" and click next$")
    public void i_enter_a_and_click_next(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	loginPage.enterPassword(PropertyReader.testDataOf(arg1));
    	loginPage.clickLogin();
    }
}
