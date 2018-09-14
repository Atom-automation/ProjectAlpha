package pages;

import base.Keywords;
import base.Test;
import constants.Keys;
import constants.OS;
import exceptions.ApplicationException;
import helper.Device;
import helper.PropertyReader;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import xpath.Matching;

public class PageForgottenPassword extends Keywords {


    private String keyLblPageTitle="Getgo.ForgotPassword.LblPageTitle";
    private String keyBtnClose="Getgo.ForgotPassword.BtnClose";
    private String keyLblPageContent="Getgo.ForgotPassword.LblPageContent";
    private String keyTxtEmailAddress="Getgo.ForgotPassword.TxtEmailAddress";
    private String keyBtnSubmit="Getgo.ForgotPassword.BtnSubmit";

    private String keyAfterSubmitLblPageTitle="Getgo.ForgotPasswordAfterSubmit.LblPageTitle";
    private String keyAfterSubmitBtnClose="Getgo.ForgotPasswordAfterSubmit.BtnClose";
    private String keyAfterSubmitLblPageContent="Getgo.ForgotPasswordAfterSubmit.LblPageContent";
    private String keyAfterSubmitBtnLogin="Getgo.ForgotPasswordAfterSubmit.BtnLogin";

    public void verifyPageTitle(String ititle) throws ApplicationException {
        verify.elementTextMatching(keyLblPageTitle,ititle);
    }

    public void verifyForgotPasswordPageContents() throws ApplicationException {
        verify.elementIsPresent(keyBtnClose);
        verify.elementIsPresent(keyTxtEmailAddress);
        verify.elementIsPresent(keyBtnSubmit);
        verify.elementTextMatching(keyLblPageContent,"Enter your registered email address We'll send you an email to reset your password.");

    }

    public void enterEmailandClickSubmit(String idata) throws ApplicationException {
        type.data(keyTxtEmailAddress,idata);
        WAIT.forSeconds(2);
        click.elementBy(keyBtnSubmit);
        WAIT.forSeconds(2);
    }

    public void verifyPageTitleAfterSubmit(String ititle) throws ApplicationException {
        verify.elementTextMatching(keyAfterSubmitLblPageTitle,ititle);
    }


    public void verifyForgotPasswordPageContentsAfterSubmit() throws ApplicationException {
        if(Device.isAndroid()) {
            verify.elementIsPresent(keyAfterSubmitBtnClose);
            verify.elementIsPresent(keyAfterSubmitBtnLogin);
            verify.elementTextMatching(keyAfterSubmitLblPageContent, "We have sent you an email to reset your password.");
        }
        else
        {
            //no back button present in this page and need to confirm it
            //verify.elementIsPresent(keyAfterSubmitBtnClose);
            verify.elementIsPresent(keyAfterSubmitBtnLogin);
            verify.elementTextMatching(keyAfterSubmitLblPageContent, "We have send you an email to reset your password");

        }
    }

    public void quittheApplication()
    {
        Keywords.quitDriver();
    }




}