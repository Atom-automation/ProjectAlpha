package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.PropertyReader;
import pages.PageAccountDashboard;
import pages.PageFAQ;
import pages.PageLogin;
import pages.PageLogout;

public class Getgo_Logout {

    private static PageLogin login=new PageLogin();
    private static PageAccountDashboard dashboard=new PageAccountDashboard();
    private static PageLogout logout=new PageLogout();



    @When("^I choose logout option from the menu$")
    public void i_choose_logout_option_from_the_menu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        dashboard.clickMenu();
        dashboard.clicklogoutoptiononly();
    }

    @Then("^I should see a \"([^\"]*)\" popup window prompting you to logout from the current session$")
    public void i_should_see_a_popup_window_prompting_you_to_logout_from_the_current_session(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logout.verifyPageTitle(arg1);
        logout.verifyPagedetails();
    }

    @When("^I click yes$")
    public void i_click_yes() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        logout.clickYesToLogout();
    }

    @Then("^I should be logged out from the current session & redirected to signin page with logged \"([^\"]*)\"$")
    public void i_should_be_logged_out_from_the_current_session_redirected_to_signin_page_with_logged(String arg1) throws Throwable {
        login.isLogoutSuccess(PropertyReader.testDataOf(arg1));
    }

}
