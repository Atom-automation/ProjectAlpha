package pages;

import base.Keywords;
import exceptions.ApplicationException;

public class PageCurrencyConversionSuccess extends Keywords {

    private String keyImgGetgoLogo="Getgo.CurrencyConversionSuccess.ImgGetgoLogo";
    private String keyLblCongrats="Getgo.CurrencyConversionSuccess.LblCongrats";
    private String keyLblMessage="Getgo.CurrencyConversionSuccess.LblMessage";
    private String keyBtnDashboard="Getgo.CurrencyConversionSuccess.BtnDashboard";
    private String keyBtnViewDetails="Getgo.CurrencyConversionSuccess.BtnViewDetails";

    private String congrats="Congratulations!";
    private String message="You have successfully converted currency";

    private void doesPageContains() throws ApplicationException {
        verify.elementIsPresent(keyImgGetgoLogo);
    }

    public void isConversionSuccess() throws ApplicationException {
        WAIT.forSeconds(5);
        verify.elementTextMatching(keyLblCongrats,congrats);
        verify.elementTextMatching(keyLblMessage,message);
    }

    public void gotoDashboard() throws ApplicationException {
        click.elementBy(keyBtnDashboard);
        WAIT.forSeconds(3);
    }

    public void gotoDetails() throws ApplicationException {
        click.elementBy(keyBtnViewDetails);
        WAIT.forSeconds(3);
    }
}
