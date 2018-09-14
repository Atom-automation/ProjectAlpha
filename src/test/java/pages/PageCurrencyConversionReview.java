package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.Device;

public class PageCurrencyConversionReview extends Keywords {

    private String keyLblTransferFrom="Getgo.CurrencyConversionReview.LblTransferFrom";
    private String keyLblTransferFromcard="Getgo.CurrencyConversionReview.LblTransferFromCard";
    private String keyLblTransferAmount="Getgo.CurrencyConversionReview.LblConvertCurrencyFrom";
    private String keyLblConvertedAmount="Getgo.CurrencyConversionReview.LblConvertCurrencyTo";
    private String keyLblConversionRate="Getgo.CurrencyConversionReview.LblConversionExchangeRate";
    private String keyBtnConvert="Getgo.CurrencyConversionReview.BtnTransfer";

    public void transferFrom(String username, String userCard) throws ApplicationException {
        if(Device.isAndroid()) {
            verify.elementTextContains(keyLblTransferFrom, username);
            WAIT.forSeconds(2);
            verify.elementTextContains(keyLblTransferFromcard, userCard);
        }
        else
        {
            verify.elementTextContains(keyLblTransferFrom, username);
            WAIT.forSeconds(2);
            verify.elementTextContains(keyLblTransferFromcard, userCard);
        }
    }

    public void transferAmount(String amount) throws ApplicationException {
        verify.elementTextMatching(keyLblTransferAmount,amount);
    }

    public void convertedAmount(String amount) throws ApplicationException {
        verify.elementTextMatching(keyLblConvertedAmount,amount);
    }

    public void conversionRate(String rate) throws ApplicationException {
        verify.elementTextMatching(keyLblConversionRate,rate);
    }

    public void clickConvert() throws ApplicationException {
        WAIT.forSeconds(2);
        click.elementBy(keyBtnConvert);
        WAIT.forSeconds(2);

    }
}
