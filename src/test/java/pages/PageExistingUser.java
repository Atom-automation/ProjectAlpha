package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.Device;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import xpath.Matching;

public class PageExistingUser extends Keywords {

    private String keyLblPageTitle = "Getgo.ExistingUserRegistration.LblPageTitle";
    private String keyBtnClose = "Getgo.ExistingUserRegistration.BtnClose";
    private String keyBtnNext = "Getgo.ExistingUserRegistration.BtnNext";
    private String keyLblPageHeader = "Getgo.ExistingUserRegistration.LblPageHeader";
    private String keyLblPageContent = "Getgo.ExistingUserRegistration.LblPageContent";
    private String keyTxtCardNumber = "Getgo.ExistingUserRegistration.TxtCardNumber";
    private String keyTxtCVV = "Getgo.ExistingUserRegistration.TxtCVV";
    private String keyTXTDOE = "Getgo.ExistingUserRegistration.TXTDOE";

    private String keyPasswordpageLblPageHeader = "Getgo.ExistingUserPassword.LblPageHeader";
    private String keyPasswordpageTxtNominatePassword = "Getgo.ExistingUserPassword.TxtNominatePassword";
    private String keyPasswordpageTxtConfirmPassword = "Getgo.ExistingUserPassword.TxtConfirmPassword";
    private String keyPasswordpageLblPageContents = "Getgo.ExistingUserPassword.LblPageContents";
    private String keyPasswordpageBtnNext = "Getgo.ExistingUserPassword.BtnNext";




    public void verifyEnterCardDetailsPageTitle(String ititle) throws ApplicationException {
        WAIT.forSeconds(5);
            verify.elementTextContains(keyLblPageTitle, ititle);

    }

    public void doesEnterCardDetailsPageContains(String iheader,String icontent) throws ApplicationException {
        WAIT.forSeconds(1);
        verify.elementIsPresent(keyTxtCardNumber);
        verify.elementIsPresent(keyTxtCVV);
        verify.elementIsPresent(keyTXTDOE);
        verify.elementIsPresent(keyBtnClose);
        verify.elementIsPresent(keyBtnNext);
        verify.elementTextMatching(keyLblPageHeader,iheader);
        verify.elementTextMatching(keyLblPageContent,icontent);

    }


    public void EnterCardDetails(String icard,String iDOE,String iCVV) throws ApplicationException {
        type.sensitiveData(keyTxtCardNumber,icard);
        type.data(keyTXTDOE,iDOE);
        type.data(keyTxtCVV,iCVV);

    }

    public void clickEnterCardDetailsNextButton() throws ApplicationException {
        WAIT.forSeconds(2);
        click.elementBy(keyBtnNext);
    }



    public void doesEnterPasswordDetailsPageContains(String iheader,String icontent) throws ApplicationException {
        WAIT.forSeconds(1);
        if(Device.isAndroid()) {
            verify.elementIsPresent(keyPasswordpageTxtNominatePassword);
            verify.elementIsPresent(keyPasswordpageTxtConfirmPassword);
            verify.elementIsPresent(keyPasswordpageBtnNext);
            verify.elementTextMatching(keyPasswordpageLblPageHeader, iheader);
            verify.elementTextMatching(keyPasswordpageLblPageContents, icontent);
        }
        else
        {
            //title for ios only
            verify.elementTextContains(xpathOf.textView(Matching.youDecide("Update Account")), "Update Account");
            verify.elementIsPresent(keyPasswordpageTxtNominatePassword);
            verify.elementIsPresent(keyPasswordpageTxtConfirmPassword);
            verify.elementIsPresent(keyPasswordpageBtnNext);
            verify.elementTextMatching(keyPasswordpageLblPageHeader, "We are changing our password policy to ensure your account remains secure. Please nominate a new password");
            verify.elementTextMatching(xpathOf.textView(Matching.youDecide("Password should not be blank")),"Password should not be blank");
            verify.elementTextMatching(xpathOf.textView(Matching.youDecide("Password should be 8 - 30 characters")),"Password should be 8 - 30 characters");
            verify.elementTextMatching(xpathOf.textView(Matching.youDecide("Password should contain an alphabetical character")),"Password should contain an alphabetical character");
            verify.elementTextMatching(xpathOf.textView(Matching.youDecide("Password should contain a numeric character")),"Password should contain a numeric character");
            verify.elementTextMatching(xpathOf.textView(Matching.youDecide("Password should contain a symbol character")),"Password should contain a symbol character");

        }

    }


    public void EnterPasswordDetails(String inewpwd,String iconfirmpwd) throws ApplicationException {
        type.sensitiveData(keyPasswordpageTxtNominatePassword,inewpwd);
        type.sensitiveData(keyPasswordpageTxtConfirmPassword,iconfirmpwd);


    }

    public void clickEnterPasswordDetailsNextButton() throws ApplicationException {
        WAIT.forSeconds(2);
        click.elementBy(keyPasswordpageBtnNext);
    }



}


