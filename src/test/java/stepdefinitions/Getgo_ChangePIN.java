package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.PropertyReader;
import org.junit.Assert;
import pages.PageChangePIN;
import pages.PageEditProfile;
import pages.PageOTP;

public class Getgo_ChangePIN {

    private String fromCurrency,toCurrency;
    private static PageOTP otp=new PageOTP();
    private static PageChangePIN changepin=new PageChangePIN();


    @Then("^I should see \"([^\"]*)\" page with \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" textboxes, close and Save buttons$")
    public void i_should_see_page_with_and_textboxes_close_and_Save_buttons(String arg1, String arg2, String arg3, String arg4) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        changepin.verifyChangePINPageTitle(arg1);
        changepin.verifyChangePINPageElements();
    }

    @When("^I Enter Current PIN, New PIN and Confirm PIN details$")
    public void i_Enter_Current_PIN_New_PIN_and_Confirm_PIN_details() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        changepin.enterPINDetailsToUpdate(
                PropertyReader.testDataOf("changePIN_old"),
                PropertyReader.testDataOf("changePIN_new"),
                PropertyReader.testDataOf("changePIN_confirm")
        );
    }

    @When("^click submit button in the update card PIN page$")
    public void click_submit_button_in_the_update_card_PIN_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        changepin.clicksubmit();
    }

    @When("^I Enter OTP details$")
    public void i_Enter_OTP_details() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    otp.enterOTP();
    }

    @Then("^PIN should be updated successfully$")
    public void pin_should_be_updated_successfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       // Assert.assertTrue(1==0);
    }
}