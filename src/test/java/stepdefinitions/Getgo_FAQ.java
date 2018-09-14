package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.PageAccountDashboard;
import pages.PageFAQ;
import pages.PageMore;
import pages.PageTermsandConditions;

public class Getgo_FAQ {

    private static PageFAQ faq=new PageFAQ();

    @Then("^Frequently Asked Questions page should be displayed with three frequently asked questions \"([^\"]*)\",\"([^\"]*)\" & \"([^\"]*)\"$")
    public void frequently_Asked_Questions_page_should_be_displayed_with_three_frequently_asked_questions(String arg1, String arg2, String arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        faq.verifyPageTitle("Frequently Asked Question");
        faq.doespagecontainsquestions();
        faq.verifyfirstquestion();
        faq.verifysecondquestion();
        faq.verifythirdquestion();
    }

}
