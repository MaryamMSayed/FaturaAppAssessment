package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages_utils.ElementsActions;

public class Fatura_Cart_Page {
    private final AndroidDriver<WebElement> driver;

    public Fatura_Cart_Page(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    //Elements
    private final By paymentMethod = By.id("spinnerLinearLayout");
    private final By confirmPaymentMethod = By.id("changeTextView");
    private final By cashPaymentOption = By.id("cashImageView");
    private final By orderNow_btn = By.id("btn_order_now");
    private final By confirmOrderBtn = By.id("confirmButton");
    private final By dismissConfirmMessage=By.id("button1");

    @Step("Select Cash option as a payment method")
    public Fatura_Cart_Page selectPaymentMethod() {
        ElementsActions.click(driver,paymentMethod);
        ElementsActions.click(driver,cashPaymentOption);
        ElementsActions.click(driver,confirmPaymentMethod);
        return this;
    }
    @Step("Complete order and confirm cart items")
    public Fatura_Profile_Page openProfileAfterCompleteOrder()
    {
        ElementsActions.click(driver,orderNow_btn);
        ElementsActions.click(driver,confirmOrderBtn);
        ElementsActions.click(driver,dismissConfirmMessage);
        return new Fatura_Profile_Page(driver);
    }
}