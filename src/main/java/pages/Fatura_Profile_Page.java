package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages_utils.ElementsActions;

public class Fatura_Profile_Page {
    private final AndroidDriver<WebElement> driver;
    public Fatura_Profile_Page(AndroidDriver<WebElement> driver)
    {
        this.driver=driver;
    }
    //Elements
    private final By profileSectionBtn=By.xpath("//android.widget.FrameLayout[@content-desc=\"بياناتي\"]/android" +
            ".widget.ImageView");
    private final By logOutBtn=By.id("");

    public Fatura_Login_Page userLogOut()
    {
        ElementsActions.click(driver,profileSectionBtn);
        ElementsActions.swipeByCoordinates(117,1905,117,434,driver);
        ElementsActions.click(driver,logOutBtn);
        return new Fatura_Login_Page(driver);
    }

}
