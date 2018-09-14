package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.PropertyReader;
import pages.PageLogin;
import pages.PageSignUp;
import pages.PageWelcome;


public class Getgo_ProductFeature
{
    private static PageWelcome welcomePage = new PageWelcome();


    @Given("^I'm on Getgo application with welcome page one content details,greeting image & next button$")
    public void i_m_on_Getgo_application_with_welcome_page_one_content_details_greeting_image_next_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        welcomePage.launchGetgo();
        welcomePage.welcomepageone();
    }

    @When("^I click on next button$")
    public void i_click_on_next_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        welcomePage.clickWelcomePageNextBtn();
    }

    @Then("^welcome page two should be displayed with contents,greeting image & next button$")
    public void welcome_page_two_should_be_displayed_with_contents_greeting_image_next_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        welcomePage.welcomepagetwo();

    }

    @Then("^welcome page three should be displayed with contents,greeting image & next button$")
    public void welcome_page_three_should_be_displayed_with_contents_greeting_image_next_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        welcomePage.welcomepagethree();

    }

    @Then("^welcome page four should be displayed with contents,greeting image & next button$")
    public void welcome_page_four_should_be_displayed_with_contents_greeting_image_next_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        welcomePage.welcomepagefour();

    }

    @Then("^welcome page five should be displayed with contents,greeting image & get Started button$")
    public void welcome_page_five_should_be_displayed_with_contents_greeting_image_get_Started_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        welcomePage.welcomepagefive();

    }

    @Then("^I click on Get Started button$")
    public void i_click_on_Get_Started_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        welcomePage.clickWelcomePageNextBtn();
    }

    @Then("^GetGo pay login/signup page should be displayed$")
    public void getgo_pay_login_signup_page_should_be_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        welcomePage.doesPageContains("LOG IN","SIGN UP","Now made easier. As simple as Ready, GetGo.");

    }
}
