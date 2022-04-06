package deviceFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidCloudDevice implements DeviceFactoryImpl{

    @Override
    public AppiumDriver create() {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "ronnydanielherre1");
        caps.setCapability("browserstack.key", "PXFxghzeEpPkKLTMNyDA");

        // Set URL of the application under test
        caps.setCapability("app", "bs://1700e197b84ee723151d68a0e7ac0468c7cdc9b4");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "TAREA");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = null;
        try {
            driver = new AndroidDriver<AndroidElement>(
                    new URL("http://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        // Write your test case statements here

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        return driver;
    }
}
