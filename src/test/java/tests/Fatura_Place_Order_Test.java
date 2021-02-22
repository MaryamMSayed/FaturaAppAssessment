package tests;

import data.ExcelFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Fatura_Login_Page;
import setup.TestBase;

import java.io.File;

public class Fatura_Place_Order_Test extends TestBase {
    ExcelFileManager spreadSheet;
    String phoneNumber,Password;
    @BeforeClass
    public void dataSetUp()
    {
        spreadSheet = new ExcelFileManager(
                new File("src/test/java/data/Fatura_Login_sheet.xlsx"));
        spreadSheet.switchToSheet("Sheet1");
    }
    @Test(description = "Place order and then Log out")
    @Description("User will be successfully Logged out after placing an order")
    @Story("Order")
    @Severity(SeverityLevel.CRITICAL)
    public void testUserCanLogOutAfterPlacingAnOrder()
    {
        phoneNumber=spreadSheet.getCellData("Phone number",2);
        Password=spreadSheet.getCellData("password",2);
String loginPageTitle=new Fatura_Login_Page(androidDriver).userLogin(phoneNumber,Password).openKashKolPage()
        .openSelectedCategoryPage()
        .addSpecProductToCart()
        .addSpecProductFromAnotherCategToCart()
        .clickOnMinAmountBtn().selectPaymentMethod()
        .openProfileAfterCompleteOrder()
        .userLogOut()
        .getLoginPageTitle();
        Assert.assertEquals(loginPageTitle,"أهلا بكم في برنامج فاتورة");
    }
}
