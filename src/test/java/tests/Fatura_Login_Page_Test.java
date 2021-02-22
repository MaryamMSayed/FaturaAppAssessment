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

public class Fatura_Login_Page_Test extends TestBase {
    ExcelFileManager spreadSheet;
String phoneNumber,Password;
@BeforeClass
    public void dataSetUp()
{
    spreadSheet = new ExcelFileManager(
            new File("src/test/java/data/Fatura_Login_sheet.xlsx"));
    spreadSheet.switchToSheet("Sheet1");
}
    @Test(description = "Valid User Login")
    @Description("When I login with an already signed up user, Then I should login successfully")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    public void userCanLoginWithValidData()
    {
        phoneNumber=spreadSheet.getCellData("Phone number",2);
        Password=spreadSheet.getCellData("password",2);
        String loginPageTitle=new Fatura_Login_Page(androidDriver).getLoginPageTitle();
        Assert.assertEquals(loginPageTitle,"أهلا بكم في برنامج فاتورة");
        String homePageTitle=new Fatura_Login_Page(androidDriver).userLogin(phoneNumber,Password).getIntroHomeText();
        Assert.assertEquals(homePageTitle,"هتعمل فاتورتك منين انهاردة؟");
    }

    @Test(description = "inValid User Login")
    @Description("When I login with invalid credentials, Then I should not be able to login successfully")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    public void userCanNotLoginWithInValidData()
    {
        phoneNumber=spreadSheet.getCellData("Phone number",3);
        Password=spreadSheet.getCellData("password",3);
        String loginPageTitle=new Fatura_Login_Page(androidDriver).getLoginPageTitle();
        Assert.assertEquals(loginPageTitle,"أهلا بكم في برنامج فاتورة");
        String errorMessageTxt=new Fatura_Login_Page(androidDriver).userInvalidLogin(phoneNumber,Password).getErrorMessageTxt();
        Assert.assertEquals(errorMessageTxt,"من فضلك ادخل رقم هاتف صحيح");
    }
}
