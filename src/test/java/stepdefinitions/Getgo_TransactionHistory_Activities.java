package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.Device;
import helper.PropertyReader;
import pages.*;

public class Getgo_TransactionHistory_Activities {

    private static PageWelcome welcome=new PageWelcome();
    private static PageLogin login=new PageLogin();
    private static PageAccountDashboard dashboard=new PageAccountDashboard();
    private static PageCardTransfer transfer=new PageCardTransfer();
    private static PageActivities activities=new PageActivities();

    public static String cardtransferpagetitle=null;


    @When("^I click on the Availabel Balance Amount field in the Dasboard page$")
    public void i_click_on_the_Availabel_Balance_Amount_field_in_the_Dasboard_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
         dashboard.clickAvailableBalance();
    }

    @Then("^Transaction History/Activities for the logged user should be displayed$")
    public void transaction_History_Activities_for_the_logged_user_should_be_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //Activities -*5506
         activities.verifyActivityPageTitle("Activities");
    }

    @When("^I verify all the details present in the Transaction History/Activities page$")
    public void i_verify_all_the_details_present_in_the_Transaction_History_Activities_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        activities.verifyActivityPageContents();
    }

    @When("^Click any one transaction list$")
    public void click_any_one_transaction_list() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        activities.navigateToActivityDetailsPage();
    }

    @Then("^I should see the Transaction History/Activities details page with Reference No,Transaction Date,Description,Transaction Amount & Ending Balance$")
    public void i_should_see_the_Transaction_History_Activities_details_page_with_Reference_No_Transaction_Date_Description_Transaction_Amount_Ending_Balance() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //Activities -*5506
        activities.verifyActivityDetailsPageTitle("Activities");
        activities.verifyDetailsActivityPageContents();
        activities.closeActivityDetailedPage();
        activities.closeActivityPage();
        dashboard.checkDashboardPageProfilePic();

    }

    @Given("^I'm on \"([^\"]*)\" page of GetGo pay with valid \"([^\"]*)\" and \"([^\"]*)\" details$")
    public void i_m_on_page_of_GetGo_pay_with_valid_and_details(String arg1, String arg2, String arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        cardtransferpagetitle=arg1.trim();
        if(Device.isAndroid()) {
            welcome.clickLogin();
            login.enterEmail(PropertyReader.testDataOf(arg2));
            login.clickNext();
            login.enterPassword(PropertyReader.testDataOf(arg3));
            login.clickLogin();
            dashboard.checkDashboardPageProfilePic();
            dashboard.clickMenu();
            dashboard.navigateTo("Card transfer");
            transfer.verifyPageTitle(arg1.trim());
        }
        else
        {
            login.iOSLoginFlow(PropertyReader.testDataOf(arg2),PropertyReader.testDataOf(arg3));
            dashboard.checkDashboardPageProfilePic();
            dashboard.clickMenu();
            dashboard.navigateTo("Card Transfer");
            transfer.verifyPageTitle(arg1.trim());
        }

    }

    @When("^I click on the Activities option from the bottom of the fund transfer page$")
    public void i_click_on_the_Activities_option_from_the_bottom_of_the_fund_transfer_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        transfer.clickActivitiesOption();
    }

    @Then("^I should see the Transaction History/Activities details page with Reference No,Transaction Date,Description,Transaction Amount and Ending Balance$")
    public void i_should_see_the_Transaction_History_Activities_details_page_with_Reference_No_Transaction_Date_Description_Transaction_Amount_and_Ending_Balance() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //Activities -*5506
        activities.verifyActivityDetailsPageTitle("Activities");
        activities.verifyDetailsActivityPageContents();
        activities.closeActivityDetailedPage();
        activities.closeActivityPage();
        transfer.verifyPageTitle(cardtransferpagetitle);
    }


}
