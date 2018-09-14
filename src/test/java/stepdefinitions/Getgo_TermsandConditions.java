package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.PageAccountDashboard;
import pages.PageMore;
import pages.PageTermsandConditions;

public class Getgo_TermsandConditions {

    private static PageAccountDashboard dashboard=new PageAccountDashboard();
    private static PageMore more=new PageMore();
    private static PageTermsandConditions tc=new PageTermsandConditions();


    String lastlevel="THE TERMS AND CONDITIONS IN THIS AGREEMENT ARE ACCEPTED AND BINDING ON ME.";

    String content1="Your privacy is of great concern to us at UnionBank. The information we collect on this site is only used for its stated purpose. We do not sell or share any of the confidential information we collect with any third parties.";
    String content2="We collect information from our existing customers when they transact through our on-line banking facility. This is done so we can confirm they are an existing customer. We collect information from potential new customers who choose to apply for our various products and services through our on-line application forms. We need this information to see if you meet our customer requirements.";
    String content3="We collect Internet access information about all visitors to our site. This information is limited to that needed to adequately log access through the Internet. We use this information to help us design a better site for all our site visitors.";


    @When("^I choose More menu options from the GetGopay dashboard page$")
    public void i_choose_More_menu_options_from_the_GetGopay_dashboard_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        dashboard.checkDashboardPageProfilePic();
        dashboard.clickMenu();
        dashboard.navigateTo("More");
    }

    @Then("^More page should be displayed with the options \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\" & \"([^\"]*)\"$")
    public void more_page_should_be_displayed_with_the_options(String arg1, String arg2, String arg3, String arg4) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    more.verifyPageTitle("More");
    more.verifyMorePageContents();
    }

    @When("^I click on \"([^\"]*)\" option$")
    public void i_click_on_option(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        more.clickoptions(arg1);
    }

    @Then("^Terms & Conditions page should be displayed with two sections \"([^\"]*)\" and \"([^\"]*)\" & verify the contents$")
    public void terms_Conditions_page_should_be_displayed_with_two_sections_and_verify_the_contents(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    tc.verifyPageTitle("Terms & Conditions");
    tc.verifyPageContents();

    tc.verifyPageTermsandConditionsLastelement(lastlevel);
    tc.Movetosection("PRIVACY POLICY");
    tc.verifyPagePrivacyPolicysectionelement(content1,content2,content3);
    }
}
