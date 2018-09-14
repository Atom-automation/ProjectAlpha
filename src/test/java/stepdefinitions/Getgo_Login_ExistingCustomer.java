package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.Device;
import pages.PageAccountDashboard;
import pages.PageExistingUser;
import pages.PageLogin;

public class Getgo_Login_ExistingCustomer {

    PageLogin login=new PageLogin();
    PageExistingUser existinguser=new PageExistingUser();
    private static PageAccountDashboard dashboard=new PageAccountDashboard();

    String email,password;

    @When("^Enter \"([^\"]*)\"$")
    public void enter(String arg1) throws Throwable {
        email=arg1.trim();
        // Write code here that turns the phrase above into concrete actions
    login.enterEmail(arg1.trim());
    login.clickNext();

    }
    @When("^Enter virtual/physical \"([^\"]*)\" card details - \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\"$")
    public void enter_virtual_physical_card_details(String arg1, String arg2, String arg3, String arg4) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        existinguser.verifyEnterCardDetailsPageTitle("Register Card");
        if(arg1.trim().toLowerCase().contains("peso")) {
            existinguser.doesEnterCardDetailsPageContains("GetGo Peso Plus Prepaid Account", "It seems that you have an existing GetGo Peso Plus Prepaid Card Account. Please input the card details and start updating your account.");

        }
        else if(arg1.trim().toLowerCase().contains("virtual"))
        {
            existinguser.doesEnterCardDetailsPageContains("GetGo Peso Plus Virtual Account", "It seems that you have an existing GetGo Peso Plus Virtual Account. Please input the following card details and start updating your account.");

        }

        existinguser.EnterCardDetails(arg2,arg4,arg3);
        existinguser.clickEnterCardDetailsNextButton();

    }

    @When("^Nominate \"([^\"]*)\" and \"([^\"]*)\" & click Next$")
    public void nominate_and_click_Next(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        password=arg1;
        //need tro check the heaer section contents in the chnage password page
        existinguser.doesEnterPasswordDetailsPageContains("Enter your registered email address","Be a minimum of eight (8) characters in length. Curabitur lobortis id lorem id bibendum. Ut id consectetur magna. Quisque volutpat augue enim,");
        existinguser.EnterPasswordDetails(arg1.trim(),arg2.trim());
        existinguser.clickEnterPasswordDetailsNextButton();
    }

    @Then("^User will see dashboard page$")
    public void user_will_see_dashboard_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        dashboard.checkDashboardPageProfilePic();
        dashboard.clickMenu();
        dashboard.logout();
        if(Device.isAndroid()) {
            login.isAndroidLoginFlow(email, password);
        }
        else
        {
            login.iOSLoginFlow(email,password);
        }
        dashboard.checkDashboardPageProfilePic();
        Thread.sleep(2000);
    }



}
