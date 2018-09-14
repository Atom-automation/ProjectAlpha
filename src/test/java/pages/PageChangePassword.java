package pages;

import base.Keywords;
import com.cucumber.listener.Reporter;
import exceptions.ApplicationException;
import gherkin.lexer.De;
import helper.Device;
import org.openqa.selenium.By;
import xpath.Matching;

import java.text.DecimalFormat;

    public class PageChangePassword extends Keywords {

        private String keyLblPageTitle = "Getgo.UpdatePassword.LblTitle";
        private String keyTxtBoxOldPwd = "Getgo.UpdatePassword.TxtOldpassword";
        private String keyTxtBoxNewPwd = "Getgo.UpdatePassword.TxtNewpassword";
        private String keyTxtBoxConfirmNewPwd = "Getgo.UpdatePassword.TxtConfirmpassword";
        private String keyBtnSubmit = "Getgo.UpdatePassword.BtnSubmit";
        private String keyLblSuccessPopUpTitle = "Getgo.UpdatePassword.LblSuccesspopuptilte";
        private String keyBtnSuccessPopUpOK = "Getgo.UpdatePassword.BtnSuccesspopupOK";

        public void verifyPageTitle(String ititle) throws ApplicationException {

                verify.elementTextContains(xpathOf.textView(Matching.youDecide("Update Password")), ititle);

        }

        public void enterPwdDetails(String oldpwd, String newpwd, String confirmpwd) throws ApplicationException {

           if (Device.isAndroid()) {

               //type.data(xpathOf.textView(Matching.youDecide("Enter Old password")), oldpwd);
               //type.data(xpathOf.textView(Matching.youDecide("Enter New password")), newpwd);
               //type.data(xpathOf.textView(Matching.youDecide("Confirm New password")), confirmpwd

               type.data(By.id("com.unionbankph.getgopay.qat:id/tietOldPassword"), oldpwd);
               type.data(By.id("com.unionbankph.getgopay.qat:id/tietNewPassword"), newpwd);
               type.data(By.id("com.unionbankph.getgopay.qat:id/tietConfirmPassword"), confirmpwd);
           }
           else
           {

               //type.data(By.xpath("//XCUIElementTypeSecureTextField[@value='Enter Old password']"), oldpwd);
               //type.data(By.xpath("//XCUIElementTypeSecureTextField[@value='Enter New password']"), newpwd);
               //type.data(By.xpath("//XCUIElementTypeSecureTextField[@value='Confirm New password']"), confirmpwd);


               type.sensitiveData(keyTxtBoxOldPwd, oldpwd);
               type.sensitiveData(keyTxtBoxNewPwd, newpwd);
               type.sensitiveData(keyTxtBoxConfirmNewPwd, confirmpwd);
               keyboard.hideIOS1();
           }
        }

        public void clickSubmitBtn() throws ApplicationException {
            if(Device.isAndroid()) {
                click.elementBy(xpathOf.textView(Matching.youDecide("SUBMIT")));
            }
            else
            {
                click.elementBy(By.xpath("//XCUIElementTypeButton[@name='SUBMIT']"));
            }

        }

        public void verifyPasswordIsSuccessfull(String ititleAndroid,String icongratsIOS,String imessageIOS) throws ApplicationException {
            if(Device.isAndroid()) {
                WAIT.forSeconds(6);
                verify.elementTextMatching(keyLblSuccessPopUpTitle, ititleAndroid);
            }
            else
            {
                verify.elementTextMatching(xpathOf.textView(Matching.youDecide("Congratulations!")),icongratsIOS);
                verify.elementTextMatching(xpathOf.textView(Matching.youDecide("You have successfully updated your password.")),imessageIOS);
                verify.elementIsPresent(xpathOf.button(Matching.youDecide("GO TO SETTINGS")));

            }

        }
        public void closeSuccessPwdUpdate() throws ApplicationException {
            if(Device.isAndroid()) {

                click.elementBy(keyBtnSuccessPopUpOK);
            }
            else
            {
                click.elementBy(xpathOf.button(Matching.youDecide("GO TO SETTINGS")));
            }

        }

        //*** IOS flow for change password on successfull attempt

        public void verifySuccessPwdIOSChange(String icongrats,String imessage) throws ApplicationException {
            verify.elementTextMatching(xpathOf.textView(Matching.youDecide("Congratulations!")),icongrats);
            verify.elementTextMatching(xpathOf.textView(Matching.youDecide("You have successfully updated your password.")),imessage);
            verify.elementIsPresent(xpathOf.textView(Matching.youDecide("GO TO SETTINGS")));
        }

        public void clickGoToSettingsBtn() throws ApplicationException {

            click.elementBy(xpathOf.textView(Matching.youDecide("GO TO SETTINGS")));
        }




    }


