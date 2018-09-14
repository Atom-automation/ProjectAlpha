package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.Device;
import helper.PropertyReader;
import pages.*;

public class Getgo_ForgotPassword
{
	 private static PageWelcome welcomePage = new PageWelcome();
    private static PageLogin loginPage = new PageLogin();
    private static PageAccountDashboard dasboard = new PageAccountDashboard();
    private static PageForgottenPassword forgotpassword = new PageForgottenPassword();
    private static PageVerificationLink verifyAccount=new PageVerificationLink();

    String emailaddress;


    @When("^I enter a \"([^\"]*)\" detail & click next$")
    public void i_enter_a_detail_click_next(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        emailaddress=arg1;
        if(Device.isAndroid())
        {
            loginPage.doesUserNameScreenContains(    "Login", "Enter your registered email address",  "Email address",  "Forgot your password?", "NEXT", "Don’t have an account? SIGN UP NOW!");
            loginPage.clickForgotPasswordLink();
        }

    }

    @Then("^A page should be displayed with password textbox, NEXT button and \"([^\"]*)\" link$")
    public void a_page_should_be_displayed_with_password_textbox_NEXT_button_and_link(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if(Device.isIOS()) {
            //loginPage.doesPasswordScreenContains("Login", "Enter your password", "Password", "Having problems with your account?", "LOGIN");
            try {
                loginPage.clickForgotPasswordLink();
            }
            catch(Exception ex)
            {
                loginPage.enterEmail(PropertyReader.testDataOf(emailaddress));
                loginPage.clickNext();
                loginPage.clickForgotPasswordLink();
            }
        }

    }

    @When("^I click on Forgot your password link$")
    public void i_click_on_Forgot_your_password_link() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^Enter email address & click submit$")
    public void enter_email_address_click_submit() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        forgotpassword.verifyPageTitle("Forgot Your Password?");
        forgotpassword.verifyForgotPasswordPageContents();
        forgotpassword.enterEmailandClickSubmit(PropertyReader.testDataOf(emailaddress));
    }

    @Then("^I should see a message We have sent you an email to reset your password in the Forgot your password page$")
    public void i_should_see_a_message_We_have_sent_you_an_email_to_reset_your_password_in_the_Forgot_your_password_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        forgotpassword.verifyPageTitleAfterSubmit("Forgot Your Password?");
        forgotpassword.verifyForgotPasswordPageContentsAfterSubmit();

        if(Device.isAndroid()) {
            forgotpassword.quittheApplication();
        }
    }

    @When("^I reset the password details through the Password Reset email & click submit$")
    public void i_reset_the_password_details_through_the_Password_Reset_email_click_submit() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if(Device.isAndroid()) {
            verifyAccount.openOutlook(PropertyReader.testDataOf("RegistrationEmailAddress"), PropertyReader.testDataOf("outlookpassword"));
            verifyAccount.openResetPasswordVerificationEmail();
        }

    }

    @Then("^I see an message as Your password has been successfully changed$")
    public void i_see_an_message_as_Your_password_has_been_successfully_changed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if(Device.isAndroid()) {
            verifyAccount.verifyandEnterReset(PropertyReader.testDataOf("forgotpassword_password"), PropertyReader.testDataOf("forgotpassword_confirmpassword"));
            verifyAccount.closebrowser();
        }

    }

    @When("^I login with reset password details$")
    public void i_login_with_reset_password_details() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if(Device.isAndroid()) {
            welcomePage.launchGetgoFresh();
            welcomePage.clickLogin();
            loginPage.enterEmail(PropertyReader.testDataOf(emailaddress));
            loginPage.clickNext();
            loginPage.enterPassword(PropertyReader.testDataOf("forgotpassword_password"));
            loginPage.clickLogin();
        }

    }

    @Then("^Login should be successfull and I should see Dashboard page$")
    public void login_should_be_successfull_and_I_should_see_Dashboard_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if(Device.isAndroid()) {
            dasboard.checkDashboardPageProfilePic();
        }
    }
}
