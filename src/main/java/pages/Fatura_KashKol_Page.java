package pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages_utils.ElementsActions;

public class Fatura_KashKol_Page {
    private final AndroidDriver<WebElement> driver;
    public Fatura_KashKol_Page(AndroidDriver<WebElement> driver)
    {
        this.driver=driver;
    }
    //Elements
    private final By selectCategory=By.name("حاجة ساقعة");
    //Methods
    @Step("Navigate to the selected category Page")
    public Fatura_Category_Page openSelectedCategoryPage()
    {
        clickOnSelectCategory();
        return new Fatura_Category_Page(driver);
    }
    @Step("Click on a specific Categor")
    public void clickOnSelectCategory()
    {
        ElementsActions.click(driver,selectCategory);
    }

}
