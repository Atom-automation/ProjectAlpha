package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.PropertyReader;
import pages.*;
import projectconstants.MenuItem;

public class Getgo_EditProfile {

    private static PageOTP otp=new PageOTP();
    private static PageEditProfile editprofile=new PageEditProfile();


    @Then("^I should see \"([^\"]*)\" page with \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" sections$")
    public void i_should_see_page_with_and_sections(String arg1, String arg2, String arg3, String arg4) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        //logic to verify the account again(two factor authentication)
        editprofile.verifyAccountLogicToConfirmtheUser(PropertyReader.testDataOf(Getgo_ChangePassword.passworddetails));


        editprofile.verifyManageProfilePageTitle(arg1);
        editprofile.verifyPagefields(arg2,arg3,arg4);
    }

    @When("^I click on edit link in the \"([^\"]*)\" section$")
    public void i_click_on_edit_link_in_the_section(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        editprofile.clickEditLink(arg1);
    }

    @Then("^\"([^\"]*)\" page should be displayed with a edit mobile textbox, \"([^\"]*)\" and \"([^\"]*)\" button$")
    public void page_should_be_displayed_with_a_edit_mobile_textbox_and_button(String arg1, String arg2, String arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        editprofile.verifyUpdateMobilePageTitle(arg1);
        editprofile.verifyUpdateMobilePageElements();
    }

    @When("^I enter new mobile number$")
    public void i_enter_new_mobile_number() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        editprofile.enterUpdateMobilenumber(PropertyReader.testDataOf("edit_mobilenumber"));
    }

    @When("^click next button$")
    public void click_next_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        editprofile.clickNextBtn();

    }

    @Then("^Mobile number should be updated and verified in \"([^\"]*)\" page$")
    public void mobile_number_should_be_updated_and_verified_in_page(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        editprofile.verifySuccessfullProfileUpdate();
        editprofile.clickGoToProfileBtn();
        //logic for vrification
        editprofile.verifyUpdatedValuesforEditMobilenumber(PropertyReader.testDataOf("edit_mobilenumber"));
    }

    @Then("^\"([^\"]*)\" page should be displayed with Country,State,City Combo Boxes,Edit House/Street textbox and \"([^\"]*)\" button$")
    public void page_should_be_displayed_with_Country_State_City_Combo_Boxes_Edit_House_Street_textbox_and_button(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        editprofile.verifyUpdateAddressPageTitle(arg1);
        editprofile.verifyUpdateAddressPageElements();
    }

    @When("^I click on SAVE button with updated address details$")
    public void i_click_on_SAVE_button_with_updated_address_details() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        editprofile.chooseNewCountry(PropertyReader.testDataOf("edit_country"));
        editprofile.chooseNewState(PropertyReader.testDataOf("edit_state"));
        editprofile.chooseNewCity(PropertyReader.testDataOf("edit_city"));
        editprofile.enterStreetDetails(PropertyReader.testDataOf("edit_addresss"));
        editprofile.clickSavebtnUpdateAddress();

    }

    @Then("^Address details should be updated and verified in \"([^\"]*)\" page$")
    public void address_details_should_be_updated_and_verified_in_page(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        editprofile.verifySuccessfullProfileUpdate();
        ///logic for verification
        editprofile.clickGoToProfileBtn();
        editprofile.verifyUpdatedValuesforEditAddress(PropertyReader.testDataOf("edit_addresss"));
    }

    @Then("^\"([^\"]*)\" page should be displayed$")
    public void page_should_be_displayed(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        editprofile.verifyUpdateOtherDetailsPageTitle(arg1);
        editprofile.verifyUpdateOtherDetailsPageElements();
    }

    @When("^I click on SAVE button with updated other details$")
    public void i_click_on_SAVE_button_with_updated_other_details() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    editprofile.ChooseandEnterIdentitydetails(PropertyReader.testDataOf("edit_identityType"),PropertyReader.testDataOf("edit_identityValue"));
        editprofile.ChooseSourceoffunds(PropertyReader.testDataOf("edit_sourceoffunds"));
        editprofile.ChooseAndEnterEmployerdetails(PropertyReader.testDataOf("edit_employertype"),PropertyReader.testDataOf("edit_employername"));
    editprofile.ClickTopSaveBtnUpdateOtherDetailsPage();

    }

    @Then("^Other details should be updated and verified in \"([^\"]*)\" page$")
    public void other_details_should_be_updated_and_verified_in_page(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        editprofile.verifySuccessfullProfileUpdate();
        editprofile.clickGoToProfileBtn();

        editprofile.verifyUpdatedValuesforEditOtherdetails(
                PropertyReader.testDataOf("edit_identityType"),
                PropertyReader.testDataOf("edit_identityValue"),
                PropertyReader.testDataOf("edit_sourceoffunds"),
                PropertyReader.testDataOf("edit_employertype"),
                PropertyReader.testDataOf("edit_employername")
                );
    }

}
