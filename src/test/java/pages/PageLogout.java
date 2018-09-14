package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.Device;
import xpath.Matching;

public class PageLogout extends Keywords {

    private String keyLblPageTitle = "Getgo.Logout.LblPageTitle";
    private String keyLblPageContent = "Getgo.Logout.LblPageContent";
    private String keyBtnNo = "Getgo.Logout.BtnNo";
    private String keyBtnYes = "Getgo.Logout.BtnYes";



    public void verifyPageTitle(String ititle) throws ApplicationException {
        if(Device.isAndroid()) {
            WAIT.forSeconds(3);
            verify.elementTextContains(keyLblPageTitle, ititle);
        }
        else
        {
            WAIT.forSeconds(3);
            verify.elementTextContains(keyLblPageTitle, "Logout");
        }

    }

    public void verifyPagedetails() throws ApplicationException {
        if(Device.isAndroid()) {
            verify.elementTextContains(keyLblPageContent, "Do you want to log out?");
            verify.elementIsPresent(keyBtnNo);
            verify.elementIsPresent(keyBtnYes);
        }
        else
        {
            verify.elementTextContains(keyLblPageContent, "Are you sure you want to logout?");
            verify.elementIsPresent(keyBtnNo);
            verify.elementIsPresent(keyBtnYes);
        }
    }

    public void clickYesToLogout() throws ApplicationException {
        click.elementBy(keyBtnYes);
    }

    public void clickNoToStayIncurrentsession () throws ApplicationException {
        click.elementBy(keyBtnNo);
    }



}


