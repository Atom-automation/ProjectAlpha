package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exceptions.ApplicationException;
import helper.Device;
import helper.PropertyReader;
import io.appium.java_client.MobileBy;
import pages.*;
import projectconstants.MenuItem;

public class Getgo_ChangePassword {

    /*
        Pages ~
     */
    private static PageWelcome welcome=new PageWelcome();
    private static PageLogin login=new PageLogin();
    private static PageAccountDashboard dashboard=new PageAccountDashboard();
    private static PageSettings settings=new PageSettings();
    private static PageOTP otp=new PageOTP();
    private static PageChangePassword changepassword=new PageChangePassword();

    public static String passworddetails;

    @Given("^I'm on \"([^\"]*)\" page of GetGo pay with valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_m_on_page_of_GetGo_pay_with_valid_and(String arg1, String arg2, String arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        passworddetails=arg3;
       if(Device.isAndroid()) {
           welcome.clickLogin();
           login.enterEmail(PropertyReader.testDataOf(arg2));
           login.clickNext();
           login.enterPassword(PropertyReader.testDataOf(arg3));
           login.clickLogin();
           //dashboard.
       }
       else
       {
           login.iOSLoginFlow(PropertyReader.testDataOf(arg2),PropertyReader.testDataOf(arg3));
       }

    }

    @When("^I choose Settings option from the menu$")
    public void i_choose_Settings_option_from_the_menu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        dashboard.clickMenu();
        dashboard.clickSettingsMenuOptions();
    }

    @Then("^I should see \"([^\"]*)\" page$")
    public void i_should_see_page(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        settings.verifyPageTitle(arg1);


    }

    @When("^I choose \"([^\"]*)\" option from settings page$")
    public void i_choose_option_from_settings_page(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        settings.clickOption(arg1);
    }

    @Then("^I should see \"([^\"]*)\" page with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and  \"([^\"]*)\" button$")
    public void i_should_see_page_with_and_button(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        changepassword.verifyPageTitle(arg1);
    }
    @When("^I Enter old password, Nominate and confirm new password$")
    public void i_Enter_old_password_Nominate_and_confirm_new_password() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        changepassword.enterPwdDetails(PropertyReader.testDataOf("change_password"),PropertyReader.testDataOf("new_Password"),PropertyReader.testDataOf("new_Password"));
    }

    /*@When("^I  Enter old password\\. Nominate and confirm new password$")
    public void i_Enter_old_password_Nominate_and_confirm_new_password() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        changepassword.enterPwdDetails(PropertyReader.testDataOf("change_password"),PropertyReader.testDataOf("new_Password"),PropertyReader.testDataOf("new_Password"));
    }*/

    @When("^click submit button$")
    public void click_submit_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        changepassword.clickSubmitBtn();
    }

    @When("^I should see One Time Password page$")
    public void i_should_see_One_Time_Password_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //otp.
    }

    @When("^Enter OTP details$")
    public void enter_OTP_details() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        otp.enterOTP();
    }

    @Then("^Password should be updated$")
    public void password_should_be_updated() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        changepassword.verifyPasswordIsSuccessfull("Success","Congratulations!","You have successfully updated your password.");
        changepassword.closeSuccessPwdUpdate();
    }

    @When("^I logout and login with updated password$")
    public void i_logout_and_login_with_updated_password() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        if(Device.isAndroid())
        {
        settings.clickMenu();
        dashboard.logout();
          login.isAndroidLoginFlow(PropertyReader.testDataOf("change_username"), PropertyReader.testDataOf("new_Password"));
        }
        else {
            dashboard.clickMenu();
            dashboard.logout();

            login.iOSLoginFlow(PropertyReader.testDataOf("change_username"), PropertyReader.testDataOf("new_Password"));
        }
    }

    @Then("^Login should be successfull and Dashboard page should be displayed$")
    public void login_should_be_successfull_and_Dashboard_page_should_be_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        dashboard.checkDashboardPageProfilePic();
}

}
