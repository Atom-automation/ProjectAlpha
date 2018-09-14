package actions;

import java.util.HashMap;

public class CurrencyLocator {

    HashMap<String,String> currencymap=new HashMap<>();

    public String locator(String cvalue){


        currencymap.put("PHP","(//XCUIElementTypeStaticText[@name='dashboard-wallets-currency'])[1]");
        currencymap.put("AUD","(//XCUIElementTypeStaticText[@name='dashboard-wallets-currency'])[2]");
        currencymap.put("HKD","(//XCUIElementTypeStaticText[@name='dashboard-wallets-currency'])[3]");
        currencymap.put("SGD","(//XCUIElementTypeStaticText[@name='dashboard-wallets-currency'])[4]");
        currencymap.put("EUR","(//XCUIElementTypeStaticText[@name='dashboard-wallets-currency'])[5]");
        currencymap.put("GBP","(//XCUIElementTypeStaticText[@name='dashboard-wallets-currency'])[6]");
        currencymap.put("JPY","(//XCUIElementTypeStaticText[@name='dashboard-wallets-currency'])[7]");
        currencymap.put("USD","(//XCUIElementTypeStaticText[@name='dashboard-wallets-currency'])[8]");
        currencymap.put("CAD","(//XCUIElementTypeStaticText[@name='dashboard-wallets-currency'])[9]");

    return currencymap.get(cvalue);

    }

    public String AmountLocator(String cvalue){


        currencymap.put("PHP","(//XCUIElementTypeStaticText[@name='dashboard-wallets-amount'])[1]");
        currencymap.put("AUD","(//XCUIElementTypeStaticText[@name='dashboard-wallets-amount'])[2]");
        currencymap.put("HKD","(//XCUIElementTypeStaticText[@name='dashboard-wallets-amount'])[3]");
        currencymap.put("SGD","(//XCUIElementTypeStaticText[@name='dashboard-wallets-amount'])[4]");
        currencymap.put("EUR","(//XCUIElementTypeStaticText[@name='dashboard-wallets-amount'])[5]");
        currencymap.put("GBP","(//XCUIElementTypeStaticText[@name='dashboard-wallets-amount'])[6]");
        currencymap.put("JPY","(//XCUIElementTypeStaticText[@name='dashboard-wallets-amount'])[7]");
        currencymap.put("USD","(//XCUIElementTypeStaticText[@name='dashboard-wallets-amount'])[8]");
        currencymap.put("CAD","(//XCUIElementTypeStaticText[@name='dashboard-wallets-amount'])[9]");

        return currencymap.get(cvalue);

    }
}
