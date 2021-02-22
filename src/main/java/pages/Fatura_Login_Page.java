package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages_utils.ElementsActions;
import pages_utils.Logger;

public class Fatura_Login_Page {
    private final AndroidDriver<WebElement> driver;
    private final By login_page_title = By.id("toolbar_title");
    private final By phoneNumber_txt_Field = By.id("textinput_placeholder");
    private final By password_txt_Field = By.id("password_TextInputEditText");
    private final By signin_submit_btn = By.id("btn_signin");
    private final By errorMessageTxt = By.id("");
    public Fatura_Login_Page(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }
    //Methods

    @Step("User Login with Phone number and Password credentials")
    public Fatura_Home_Page userLogin(String phoneNumber, String password) {

        sendEmailCredentials(phoneNumber);
        sendPasswordCredentials(password);
        clickOnSignInButton();
        return new Fatura_Home_Page(driver);
    }

    @Step("User Login with invalid Phone number and Password credentials")
    public Fatura_Login_Page userInvalidLogin(String phoneNumber, String password) {

        sendEmailCredentials(phoneNumber);
        sendPasswordCredentials(password);
        clickOnSignInButton();
        return this;
    }


    @Step("Get The login page title")
    public String getLoginPageTitle() {
        driver.navigate().back();
        String title = ElementsActions.getText(driver, login_page_title);
        Logger.logMessage("The Home page title is" + title);
        return title;
    }

    @Step("Send Phone number credentials to email text field")
    public void sendEmailCredentials(String phoneNumber) {
        ElementsActions.type(driver, phoneNumber_txt_Field, phoneNumber, true);
    }

    @Step("Send password credentials to password text field")
    public void sendPasswordCredentials(String password) {
        ElementsActions.type(driver, password_txt_Field, password, true);
    }

    @Step("Click on Sign in button")
    public void clickOnSignInButton() {
        ElementsActions.click(driver, signin_submit_btn);
    }

    @Step("Get error message text")
    public String getErrorMessageTxt() {
        String errorTxt = ElementsActions.getText(driver, errorMessageTxt);
        Logger.logMessage("The Error message error is" + errorTxt);
        return errorTxt;
    }

}
