package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.Device;
import org.openqa.selenium.By;
import xpath.Matching;

public class PageMore extends Keywords {

    private String keyLblPageTitle = "Getgo.More.LblPageTitle";


    public void verifyPageTitle(String ititle) throws ApplicationException {
        WAIT.forSeconds(2);

            verify.elementTextContains(keyLblPageTitle, ititle);

    }

    public void verifyMorePageContents() throws ApplicationException {


            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("About the Cards")));
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Contact Us")));
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Frequently Asked Questions")));
            //need to check and its a issue
        if(Device.isAndroid()) {
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Terms & Conditions")));
        }
        else
        {
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("Terms and Conditions")));
        }


    }

    public void clickoptions(String option) throws ApplicationException {
        if(Device.isAndroid()) {
            click.elementBy(xpathOf.textView(Matching.youDecide(option)));
        }
        else
        {
            ////need to check this logicccccc abt terms condition '&'
            if(option.toLowerCase().contains("terms")) {
                click.elementBy(xpathOf.textView(Matching.youDecide("Terms and Conditions")));
            }
            else
            {
                click.elementBy(xpathOf.textView(Matching.youDecide(option)));
            }
        }

    }




}


