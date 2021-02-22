package pages_utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static io.appium.java_client.touch.offset.PointOption.point;
import static org.testng.FileAssert.fail;

public class ElementsActions {
    @Step("Click on element: [{by}]")
    public static void click(AndroidDriver<WebElement> driver, By by) {
        locatingElementStrategy(driver, by);

        try {

            // wait for the element to be clickable
            HelperPages.getExplicitWait(driver).until(ExpectedConditions.elementToBeClickable(by));
        } catch (TimeoutException toe) {
            Logger.logMessage("The element is not Clickable...." + toe.getMessage());
        } catch (Exception e) {
            Logger.logMessage(e.getMessage());
        }

        try {
            // Log element text if not empty. Else, log clicking
            if (!driver.findElement(by).getText().isEmpty()) {
                Logger.logMessage("Clicking on: " + driver.findElement(by).getText());
            } else {
                Logger.logMessage("Clicking on element:" + by);
            }
            driver.findElement(by).click();
        } catch (Exception exception) {
            Logger.logMessage(exception.getMessage());
            // Force fail the test case if couldn't perform the click
            fail("Couldn't click on the element", exception);


        }

    }


    @Step("Type data: [{data}] on element: [{by}]")
    public static void type(AndroidDriver<WebElement> driver, By by, String data, boolean clearBeforeTyping) {


        // Type here!
        try {
            // Clear before typing condition
            if (!driver.findElement(by).isSelected() && clearBeforeTyping) {
                Logger.logMessage("Clearing the data from element: " + by);
                driver.findElement(by).clear();
            }
            Logger.logMessage("Typing: " + data + " on element: " + by);
            driver.findElement(by).sendKeys(data);
        } catch (Exception e) {
            Logger.logMessage(e.getMessage());
        }


    }


    @Step("Send: [keyboard key] to element: [{by}]")
    public static void sendKeyBoardKey(AndroidDriver<WebElement> driver, By by, Keys key) {
        locatingElementStrategy(driver, by);

        try {
            Logger.logMessage("Clicking:" + key + " key] on element: " + by);
            driver.findElement(by).sendKeys(key);
        } catch (Exception e) {
            Logger.logMessage(e.getMessage());
        }

    }

    @Step("Get the Text of element: [{by}]")
    public static String getText(AndroidDriver<WebElement> driver, By by) {
        locatingElementStrategy(driver, by);

        try {
            String text = driver.findElement(by).getText();
            Logger.logMessage("Getting the Text of element: " + by + "; The Text is: " + text);
            return text;
        } catch (Exception e) {
            Logger.logMessage(e.getMessage());
        }
        return null;

    }

    public static void locatingElementStrategy(AndroidDriver<WebElement> driver, By by) {
        try {
            // Wait for the element to be visible
            HelperPages.getExplicitWait(driver).until(ExpectedConditions.visibilityOfElementLocated(by));
            // Check if the element is displayed
            driver.findElement(by).isDisplayed();
        } catch (TimeoutException toe) {
            Logger.logMessage("The element is not Visible...." + toe.getMessage());
        } catch (Exception e) {
            Logger.logMessage(e.getMessage());
        }
    }

    //Swipe by elements
    public static void swipeByElements(WebElement startElement, WebElement endElement, AndroidDriver<WebElement> driver) {
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        System.out.println("StartX" + startX);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
        System.out.println("startY" + startY);

        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        System.out.println("endX" + endX);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);
        System.out.println("endY" + endY);

        new TouchAction(driver)
                .press(point(startX, startY))
                .moveTo(point(endX, endY))
                .release().perform();
    }


    //------------------------------------------------------------------------------------------------

    public static void swipeByCoordinates(int startX, int startY, int endX, int endY, AndroidDriver<WebElement> driver) {
        new TouchAction(driver)
                .press(point(startX, startY))
                .moveTo(point(endX, endY))
                .release().perform();

    }
}
