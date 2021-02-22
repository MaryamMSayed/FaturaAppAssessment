package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages_utils.ElementsActions;
import pages_utils.Logger;

public class Fatura_Home_Page {
    private AndroidDriver<WebElement> driver;
    public Fatura_Home_Page(AndroidDriver<WebElement> driver)
    {
        this.driver=driver;
    }
    public final By home_page_title=By.id("intorText");
    private final By kashkol_Seller_Image=By.id("wholesalerImage");
    @Step("Get the intro home page text")
    public String getIntroHomeText()
    {
        String title=ElementsActions.getText(driver,home_page_title);
        Logger.logMessage("The Home page title is" + title);
        return title;
    }
    @Step("Open kaskol mogma3 page")
    public Fatura_KashKol_Page openKashKolPage()
    {
        ElementsActions.click(driver,kashkol_Seller_Image);
        return new Fatura_KashKol_Page(driver);
    }
}
