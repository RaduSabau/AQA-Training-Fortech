package com.saucedemo.pages;

import com.saucedemo.test.BasePage;
import com.saucedemo.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutOverviewPage extends BasePage {
    private final static String priceElement = "inventory_item_price";
    @FindBy(id="finish")
    private WebElement finishButton;
    @FindBy(className = "summary_subtotal_label")
    private WebElement subtotalSummary;
    @FindBy(className = "summary_tax_label")
    private WebElement tax;
    @FindBy(css = ".summary_info_label.summary_total_label")
    private WebElement totalSummary;

    Utils utils = new Utils();
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public double productPricesSum(){
        List<String> listOfProductPrices = getTitlesFromPageToList(priceElement);
        double sum=0;
        for(String price:listOfProductPrices){
            sum = sum + Double.parseDouble(price.substring(1));
        }
        return sum;
    }

    public double getTotalSummary(){
        return utils.getDoubleFromElement(totalSummary);
    }

    public double getSubTotalSummary(){
        return Double.parseDouble(readText(subtotalSummary).substring(13));
    }

    public double getTax(){
        return utils.getDoubleFromElement(tax);
    }

    public void clickFinishTransaction(){
        jsClick(finishButton);
    }

    public Double calculateTax(){
        return utils.calculatePercentOfNumber(productPricesSum(),8.00);
    }
}
