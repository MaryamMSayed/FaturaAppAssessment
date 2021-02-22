package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages_utils.ElementsActions;
import pages_utils.Logger;

public class Fatura_Category_Page {
    private final AndroidDriver<WebElement> driver;
    public Fatura_Category_Page( AndroidDriver<WebElement> driver)
    {
        this.driver=driver;
    }
    //Elements
    private final By addCashBtn= By.id("addCash");
    private final By selectSubCateg=By.xpath("//android.widget.LinearLayout[@content-desc=\"مشروب طاقة\"]");
    private final By minm_Btn=By.id("min_layout");
    //Methods
    @Step("Open Cart Page")
    public Fatura_Cart_Page openCart()
    {
        clickOnMinAmountBtn();
        return new Fatura_Cart_Page(driver);
    }
    @Step("Click on total price to open Cart page")
    public Fatura_Cart_Page clickOnMinAmountBtn()
    {
        ElementsActions.click(driver,minm_Btn);
        String totalAmount=ElementsActions.getText(driver,minm_Btn);
        Logger.logMessage("Total amount is : " + totalAmount);
        return new Fatura_Cart_Page(driver);
    }
    @Step("Select a product from a subCateg")
    public Fatura_Category_Page addSpecProductToCart()
    {
        addProductToCart();
        return this;
    }
    @Step("Select a product from a  different subCategory")
    public Fatura_Category_Page addSpecProductFromAnotherCategToCart()
    {
        clickOnSubCateg();
        addProductToCart();
        return this;
    }
    @Step("Add a spec Product to the cart for x numbers ")
    public void addProductToCart()
    {
        for (int i=0;i<=50;i++)
        {
            ElementsActions.click(driver,addCashBtn);
        }
    }
    @Step("Choose another sub-Category")
    public void clickOnSubCateg()
    {
        ElementsActions.click(driver,selectSubCateg);
    }

}
