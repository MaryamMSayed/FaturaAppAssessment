package setup;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;


public class AndroidSetUp {
    protected AndroidDriver<WebElement> androidDriver;
    public  void prepareAndroidForSetUP() throws MalformedURLException {


        DesiredCapabilities Capability= new DesiredCapabilities();
        Capability.setCapability("platformName","Android");
        Capability.setCapability("platformVersion","10");
        Capability.setCapability("deviceName","SBX4C19319000512");
        Capability.setCapability("appActivity","com.faturaegypt.app.ui.MainActivity");
        Capability.setCapability("appPackage","com.faturaegypt.app");
        Capability.setCapability("--session-override",true);
        androidDriver=new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),Capability);
    }

}
