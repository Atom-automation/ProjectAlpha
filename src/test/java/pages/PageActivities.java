package pages;

import base.Keywords;
import base.Test;
import com.cucumber.listener.Reporter;
import constants.Keys;
import constants.OS;
import exceptions.ApplicationException;
import helper.Device;
import org.junit.Assert;
import xpath.Matching;

import java.text.ParseException;

public class PageActivities extends Keywords {

    private String keyLblTransactionReferenceNumber="Getgo.Activities.LblDetailsReferenceNumber";
    private String keyLblTransactionDate="Getgo.Activities.LblDetailsTransactionDate";
    private String keyLblDescription="Getgo.Activities.LblDetailsDescription";
    private String keyLblTransactionAmount="Getgo.Activities.LblDetailsTransactionAmount";
    private String keyLblEndingBalance="Getgo.Activities.LblDetailsEndingBalance";

    private String keyLblPageTitle="Getgo.Activities.LblPageTitle";
    private String keyBtnClose="Getgo.Activities.BtnClose";
    private String keyImgCurrency="Getgo.Activities.ImgCurrency";
    private String keyLblCurrencyType="Getgo.Activities.LblCurrencyType";
    private String keyLblAvailabelBalance="Getgo.Activities.LblAvailabelBalance";
    private String keyLblAvailabelBalanceAmountValue="Getgo.Activities.LblAvailabelBalanceAmountValue";
    private String keyLblListTransactionDate="Getgo.Activities.LblListTransactionDate";
    private String keyLblListTransactionDescription="Getgo.Activities.LblListTransactionDescription";
    private String keyLblListTransactionAmount="Getgo.Activities.LblListTransactionAmount";
    private String keyLblListTransactionReferenceNo="Getgo.Activities.LblListTransactionReferenceNo";
    private String keyLblListTransactionIndicator="Getgo.Activities.LblListTransactionIndicator";


    private String keyLblDetailsPagetitle="Getgo.Activities.LblDetailsPagetitle";
    private String keyBtnDetailsClose="Getgo.Activities.BtnDetailsClose";
    private String keyLblDetailsReferenceNumberTitle="Getgo.Activities.LblDetailsReferenceNumberTitle";
    private String keyLblDetailsTransactionDateTitle="Getgo.Activities.LblDetailsTransactionDateTitle";
    private String keyLblDetailsDescriptionTitle="Getgo.Activities.LblDetailsDescriptionTitle";
    private String keyLblDetailsTransactionAmountTitle="Getgo.Activities.LblDetailsTransactionAmountTitle";
    private String keyLblDetailsEndingBalanceTitle="Getgo.Activities.LblDetailsEndingBalanceTitle";


    String referencenumber,description,transactionamt,availabelBalance,endingBalance,transactiondate;

    public String getTransactionReferenceNumber() throws ApplicationException {
        referencenumber = get.elementText(keyLblTransactionReferenceNumber);

        Reporter.addStepLog("Transaction Reference Number is --> "+referencenumber);

        return referencenumber;
    }

    public String reviewTransactionDate(String day,String month,String year) throws ParseException, ApplicationException {
        String transferDate=null;
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID))
        {
            transferDate = Test.tools.getDateInFormat(day,month,year,"MMMM dd, YYYY");
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS))
        {
            transferDate = Test.tools.getDateInFormat(day,month,year,"MMM dd, YYYY");
        }
        verify.elementTextContains(keyLblTransactionDate,Test.tools.DisplayMonthFully(transferDate));
        return transactiondate = get.elementText(keyLblTransactionDate);
    }

    public String reviewDescription(String description) throws ApplicationException {
        verify.elementTextContains(keyLblDescription,description);
        return description = get.elementText(keyLblDescription);
    }

    public String verifyTransactionAmount(double transactionAmount) throws ApplicationException {
        verify.isMatching(Test.tools.pesoAmount(transactionAmount).replaceAll("-",""), Test.tools.fixAmountIssue(get.elementBy(keyLblTransactionAmount).getText().replaceAll("-","")));
        return transactionamt = get.elementText(keyLblTransactionAmount);
    }

    public String verifyEndingBalance(double amount,double beforeBalance) throws ApplicationException {
        double expectedBalance= beforeBalance-amount;
        Assert.assertEquals(Test.tools.REMOVE_MULTIPLE_SPACES_AND_NEW_LINES("PHP "+Double.toString(expectedBalance)),Test.tools.REMOVE_MULTIPLE_SPACES_AND_NEW_LINES(Test.tools.fixAmountIssue(get.elementBy(keyLblEndingBalance).getText())));
        return endingBalance = get.elementText(keyLblEndingBalance);
    }


    public void verifyActivityPageTitle(String ititle) throws ApplicationException {
        WAIT.forSeconds(30);
        verify.elementTextContains(keyLblPageTitle,ititle);
    }

    public void verifyActivityPageContents() throws ApplicationException {

        if(Device.isAndroid()) {
            verify.elementIsPresent(keyBtnClose);
            verify.elementIsPresent(keyImgCurrency);
            verify.elementIsPresent(keyLblCurrencyType);
            verify.elementTextMatching(keyLblAvailabelBalance, "Available Balance");
            verify.elementIsPresent(keyLblAvailabelBalanceAmountValue);
            verify.elementIsPresent(keyLblListTransactionDate);
            verify.elementIsPresent(keyLblListTransactionDescription);
            verify.elementIsPresent(keyLblListTransactionAmount);
            verify.elementIsPresent(keyLblListTransactionReferenceNo);
            verify.elementIsPresent(keyLblListTransactionIndicator);


            availabelBalance = get.elementText(keyLblAvailabelBalanceAmountValue);
            description = get.elementText(keyLblListTransactionDescription);
            transactionamt = get.elementText(keyLblListTransactionAmount);
            referencenumber = get.elementText(keyLblListTransactionReferenceNo);
            if (transactionamt.contains("-")) {
                endingBalance = Double.toString(Double.parseDouble(availabelBalance) + Double.parseDouble(transactionamt.substring(4)));

            } else {
                endingBalance = Double.toString(Double.parseDouble(availabelBalance) - Double.parseDouble(transactionamt.substring(4)));

            }
        }
        else
        {
            verify.elementIsPresent(keyBtnClose);
            verify.elementIsPresent(keyImgCurrency);
            verify.elementIsPresent(keyLblCurrencyType);
            verify.elementIsPresent(keyLblAvailabelBalance);
            verify.elementIsPresent(keyLblAvailabelBalanceAmountValue);
            verify.elementIsPresent(keyLblListTransactionDate);
            verify.elementIsPresent(keyLblListTransactionDescription);
            verify.elementIsPresent(keyLblListTransactionAmount);
            verify.elementIsPresent(keyLblListTransactionReferenceNo);
            //no locator identifcation for ios---need to check
            ////verify.elementIsPresent(keyLblListTransactionIndicator);


            availabelBalance=Test.tools.nbspRemove(get.elementText(keyLblAvailabelBalanceAmountValue));
            description=get.elementText(keyLblListTransactionDescription);
            transactionamt=Test.tools.nbspRemove(get.elementText(keyLblListTransactionAmount));
            referencenumber=get.elementText(keyLblListTransactionReferenceNo);
           /* if(transactionamt.contains("-"))
            {
                endingBalance=Double.toString(Double.parseDouble(availabelBalance)+Double.parseDouble(transactionamt.substring(4)));

            }
            else
            {
                endingBalance=Double.toString(Double.parseDouble(availabelBalance)-Double.parseDouble(transactionamt.substring(4)));

            }*/

        }

    }

    public void navigateToActivityDetailsPage() throws ApplicationException {
        click.elementBy(keyLblListTransactionDescription);
        WAIT.forSeconds(5);
    }

    public void verifyActivityDetailsPageTitle(String ititle) throws ApplicationException {
        WAIT.forSeconds(2);
        ///need to check the logic for partial verififcation
        verify.elementTextContains(keyLblDetailsPagetitle,ititle);
    }

    public void verifyDetailsActivityPageContents() throws ApplicationException {
        //need to check the colon : for Android-> Description label and for IOS -> Ending Balance
    if(Device.isAndroid()) {
        verify.elementIsPresent(keyBtnDetailsClose);
        verify.elementTextMatching(keyLblDetailsReferenceNumberTitle, "Reference No.:");
        verify.elementTextMatching(keyLblDetailsTransactionDateTitle, "Transaction Date:");
        //
        verify.elementTextMatching(keyLblDetailsDescriptionTitle, "Description");
        verify.elementTextMatching(keyLblDetailsTransactionAmountTitle, "Transaction Amount:");
        verify.elementTextMatching(keyLblDetailsEndingBalanceTitle, "Ending Balance:");
        verify.elementIsPresent(keyLblTransactionReferenceNumber);
        verify.elementIsPresent(keyLblTransactionDate);
        verify.elementIsPresent(keyLblDescription);
        verify.elementIsPresent(keyLblTransactionAmount);
        verify.elementIsPresent(keyLblEndingBalance);

        verify.elementTextMatching(keyLblTransactionReferenceNumber, referencenumber.substring(5));
        //verify.elementTextMatching(keyLblTransactionDate);
        verify.elementTextContains(keyLblDescription, description.substring(26));
        verify.elementTextMatching(keyLblTransactionAmount, transactionamt);
        verify.elementTextContains(keyLblEndingBalance, "PHP ₱ " + availabelBalance);
    }
    else
    {
        verify.elementIsPresent(keyBtnDetailsClose);
        verify.elementTextMatching(keyLblDetailsReferenceNumberTitle,"Reference No.:");
        verify.elementTextMatching(keyLblDetailsTransactionDateTitle,"Transaction Date:");
        verify.elementTextMatching(keyLblDetailsDescriptionTitle,"Description:");
        verify.elementTextMatching(keyLblDetailsTransactionAmountTitle,"Transaction Amount:");
        //
        verify.elementTextMatching(keyLblDetailsEndingBalanceTitle,"Ending Balance");
        verify.elementIsPresent(keyLblTransactionReferenceNumber);
        verify.elementIsPresent(keyLblTransactionDate);
        verify.elementIsPresent(keyLblDescription);
        verify.elementIsPresent(keyLblTransactionAmount);
        verify.elementIsPresent(keyLblEndingBalance);

        verify.elementTextMatching(keyLblTransactionReferenceNumber,referencenumber.substring(5));
        //verify.elementTextMatching(keyLblTransactionDate);
        verify.elementTextContains(keyLblDescription,description.substring(26));
        verify.elementTextMatching(keyLblTransactionAmount,transactionamt);
        //
        verify.elementTextContains(keyLblEndingBalance,"PHP "+availabelBalance);
    }

    }

    public void closeActivityDetailedPage() throws ApplicationException {
        click.elementBy(keyBtnDetailsClose);
        WAIT.forSeconds(2);
    }

    public void closeActivityPage() throws ApplicationException {
        click.elementBy(keyBtnClose);
        WAIT.forSeconds(2);
    }

    public void selectActivityByReferneceNo(String data) throws ApplicationException {
        if(Device.isAndroid())
        {
    // need logiccc
        }
        else
            {
            click.elementBy(xpathOf.textView(Matching.value("Ref: "+data)));
        }

    }

    public void verifyFundTransferDetailsActivityPage(String refno,String date,String desc,String tranamt,String endingbalance) throws ApplicationException {
        //need to check the colon : for Android-> Description label and for IOS -> Ending Balance
        if(Device.isAndroid()) {
            verify.elementIsPresent(keyBtnDetailsClose);
            verify.elementTextMatching(keyLblDetailsReferenceNumberTitle, "Reference No.:");
            verify.elementTextMatching(keyLblDetailsTransactionDateTitle, "Transaction Date:");
            //
            verify.elementTextMatching(keyLblDetailsDescriptionTitle, "Description");
            verify.elementTextMatching(keyLblDetailsTransactionAmountTitle, "Transaction Amount:");
            verify.elementTextMatching(keyLblDetailsEndingBalanceTitle, "Ending Balance:");


            verify.elementTextMatching(keyLblTransactionReferenceNumber, refno);
            verify.elementTextContains(keyLblTransactionDate,date);
            verify.elementTextMatching(keyLblDescription,desc);
            verify.elementTextMatching(keyLblTransactionAmount, tranamt);
            verify.elementTextContains(keyLblEndingBalance, "PHP ₱ " + endingbalance.substring(4));
        }
        else
        {
            verify.elementIsPresent(keyBtnDetailsClose);
            verify.elementTextMatching(keyLblDetailsReferenceNumberTitle,"Reference No.:");
            verify.elementTextMatching(keyLblDetailsTransactionDateTitle,"Transaction Date:");
            verify.elementTextMatching(keyLblDetailsDescriptionTitle,"Description:");
            verify.elementTextMatching(keyLblDetailsTransactionAmountTitle,"Transaction Amount:");
            //
            verify.elementTextMatching(keyLblDetailsEndingBalanceTitle,"Ending Balance");
            verify.elementIsPresent(keyLblTransactionReferenceNumber);
            verify.elementIsPresent(keyLblTransactionDate);
            verify.elementIsPresent(keyLblDescription);
            verify.elementIsPresent(keyLblTransactionAmount);
            verify.elementIsPresent(keyLblEndingBalance);

            verify.elementTextMatching(keyLblTransactionReferenceNumber,refno);
            verify.elementTextContains(keyLblTransactionDate,date);
            verify.elementTextMatching(keyLblDescription,desc);
            verify.elementTextMatching(keyLblTransactionAmount,Test.tools.REMOVE_MULTIPLE_SPACES_AND_NEW_LINES(tranamt));
            //
            verify.elementTextContains(keyLblEndingBalance,Test.tools.REMOVE_MULTIPLE_SPACES_AND_NEW_LINES("PHP "+endingbalance.substring(4)));
        }

    }



}