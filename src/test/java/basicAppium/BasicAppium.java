package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasicAppium {
    private AppiumDriver driver;

    @BeforeEach
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName","Pixel 3 XL API 28");
        capabilities.setCapability("appium:platformVersion","9");
        capabilities.setCapability("appium:appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appium:appActivity",".ui.HomeActivity");
        capabilities.setCapability("platformName","Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

    }

    @AfterEach
    public void cleanup(){
        driver.quit();
    }

    @Test
    public void testAddTask() throws InterruptedException {
        // inputs
        String title = "Titulo nuevo";
        String textNote = "Notas del task";
        String date = "22 March 2022";
        String hour = "10";
        String minute = "35";
        String timeRemember = "15 minutes before";
        String frequency = "Daily";

        // xpath and id
        String idButtonAdd = "com.vrproductiveapps.whendo:id/fab";
        String idInputTextTitle = "com.vrproductiveapps.whendo:id/noteTextTitle";
        String idInputTextNote = "com.vrproductiveapps.whendo:id/noteTextNotes";
        String idBtnDateRemember = "com.vrproductiveapps.whendo:id/note_item_reminder";
        String idBtnDate = "com.vrproductiveapps.whendo:id/due_date_layout";
        String xpathInputDate = "//android.view.View[@content-desc='"+date+"']";
        String idBtnOk = "android:id/button1";
        String idBtnHour = "com.vrproductiveapps.whendo:id/time";
        String xpathInputHour = "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='"+hour+"']";
        String xpathInputMinute = "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='"+minute+"']";
        String idBtnRemember = "com.vrproductiveapps.whendo:id/reminder";
        String xpathInputRemember = "//android.widget.RadioButton[@text='"+timeRemember+"']";
        String idBtnRepeat = "com.vrproductiveapps.whendo:id/repeat";
        String xpathInputRepeat = "//android.widget.RadioButton[@text='"+frequency+"']";
        String idBtnSave = "com.vrproductiveapps.whendo:id/saveItem";

        //Secuencia de pasos

        driver.findElement(By.id(idButtonAdd)).click();

        driver.findElement(By.id(idInputTextTitle)).sendKeys(title);
        driver.findElement(By.id(idInputTextNote)).sendKeys(textNote);

        driver.findElement(By.id(idBtnDateRemember)).click();

        driver.findElement(By.id(idBtnDate)).click();

        driver.findElement(By.xpath(xpathInputDate)).click();

        driver.findElement(By.id(idBtnOk)).click();

        driver.findElement(By.id(idBtnHour)).click();

        driver.findElement(By.xpath(xpathInputHour)).click();
        driver.findElement(By.xpath(xpathInputMinute)).click();

        driver.findElement(By.id(idBtnOk)).click();

        driver.findElement(By.id(idBtnRemember)).click();

        driver.findElement(By.xpath(xpathInputRemember)).click();

        driver.findElement(By.id(idBtnRepeat)).click();

        driver.findElement(By.xpath(xpathInputRepeat)).click();

        driver.findElement(By.id(idBtnSave)).click();

        Thread.sleep(4000);

        String xpathTitlesText = "//android.widget.TextView[@resource-id='com.vrproductiveapps.whendo:id/home_list_item_text']";
        String xpathNotesText = "//android.widget.TextView[@resource-id='com.vrproductiveapps.whendo:id/home_list_item_text2']";
        List<WebElement> titlesText = driver.findElements(By.xpath(xpathTitlesText));
        List<WebElement> notesText = driver.findElements(By.xpath(xpathNotesText));

        boolean exist = false;
        for (int i = 0 ; i < titlesText.size() ; i++){
            if(titlesText.get(i).getText().equals(title) && notesText.get(i).getText().equals(textNote)){
                exist = true;
                break;
            }
        }
        Assertions.assertTrue(exist);
    }
}
