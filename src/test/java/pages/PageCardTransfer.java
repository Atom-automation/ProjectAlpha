package pages;

import base.Keywords;
import base.Test;
import constants.Keys;
import constants.OS;
import exceptions.ApplicationException;
import io.appium.java_client.MobileBy;
import xpath.Matching;

public class PageCardTransfer extends Keywords
{
    private String keyTxtRecipientCard="Getgo.CardTransfer.TxtCard";
    private String keyTxtRecipientName="Getgo.CardTransfer.TxtRecipientName";
    private String keyTxtAmount="Getgo.CardTransfer.TxtAmount";
    private String keyBtnCalendar="Getgo.CardTransfer.BtnCalendar";
    private String keyBtnFrequencyDropdown="Getgo.CardTransfer.BtnFrequencyDropdown";
    private String keyTxtMessage="Getgo.CardTransfer.TxtMessage";
    private String keyBtnNext="Getgo.CardTransfer.BtnNext";
    private String keyLblAvailableBalance="Getgo.CardTransfer.LblAvailableBalance";
    private String keyBtnAddRecipient="Getgo.CardTransfer.BtnAddRecipient";
    private String keyBtnManageRecipientBottom="Getgo.CardTransfer.BtnManageRecipientBottom";
    private String keyLblPageTitle="Getgo.CardTransfer.LblPageTitle";
    private String keyBtnActivitiesBottom="Getgo.CardTransfer.BtnActivitiesBottom";

    private double beforeBalance;

    public void enterCardNumber(String cardNumber) throws ApplicationException {
        type.data(keyTxtRecipientCard,cardNumber);
    }

    public void enterRecipient(String recipient) throws ApplicationException {
        type.data(keyTxtRecipientName,recipient);
    }

    public void selectRecipientFromSavedList(String recipient) throws ApplicationException {
        click.elementBy(keyBtnAddRecipient);
        WAIT.forSeconds(3);
        swipe.scrollDownToText(recipient);
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID))
        {
            click.elementBy(xpathOf.textView(Matching.text(recipient)));
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS))
        {
            click.elementBy(MobileBy.AccessibilityId(recipient));
        }
    }

    public void enterAmount(double amount) throws ApplicationException {
        type.data(keyTxtAmount,Integer.toString((int) amount));
    }

    public void selectDate(String day,String month,String year) throws ApplicationException {
        click.elementBy(keyBtnCalendar);
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID))
        {
            // Code to select a specific date needs to be added for android
            click.elementBy("Getgo.CardTransfer.BtnAndroidDatePickerOk");
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS))
        {
            ios.datePicker(day,month,year);
        }
    }

    public void selectFrequency(String frequency) throws ApplicationException {
        click.elementBy(keyBtnFrequencyDropdown);
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID))
        {
            click.elementBy(xpathOf.textView(Matching.youDecide(frequency)));
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS))
        {
            ios.selectPicker(frequency);
        }
    }

    public void enterMessage(String message) throws ApplicationException {
        type.data(keyTxtMessage,message);
    }

    public void clickNext() throws ApplicationException {
        WAIT.forSeconds(10);
        beforeBalance= Double.parseDouble(get.elementText(keyLblAvailableBalance).replaceAll("\\u00A0","").replaceAll(",",""));
        click.elementBy(keyBtnNext);
    }

    public void clickAddRecipient() throws ApplicationException {
        WAIT.forSeconds(3);
        swipe.vertical(2,0.9,0.4,5);
        click.elementBy(keyBtnManageRecipientBottom);
    }


    public double getBeforeBalance()
    {
        return beforeBalance;
    }

    public void verifyPageTitle(String ititle) throws ApplicationException {
        WAIT.forSeconds(3);
        verify.elementTextMatching(keyLblPageTitle,ititle);
    }

    public void clickActivitiesOption() throws ApplicationException {
        swipe.vertical(2,0.8,0.5,3);
        click.elementBy(keyBtnActivitiesBottom);
        WAIT.forSeconds(5);
    }
}
