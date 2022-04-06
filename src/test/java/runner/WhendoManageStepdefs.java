package runner;

import activity.wendo.ListActivityScreen;
import activity.wendo.NewActivityFormScreen;
import dao.TaskWhendo;
import dao.TaskWhendoResult;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WhendoManageStepdefs {
    private AppiumDriver driver;

    @Given("^abro el aplicativo Whendo ant$")
    public void abroElAplicativoWhendo() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName","Pixel 3 XL API 28");
        capabilities.setCapability("appium:platformVersion","9");
        capabilities.setCapability("appium:appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appium:appActivity",".ui.HomeActivity");
        capabilities.setCapability("platformName","Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @And("^presiono la opcion para agregar tarea ant$")
    public void presionoLaOpcionParaAgregarTarea() {
            String idButtonAdd = "com.vrproductiveapps.whendo:id/fab";
        driver.findElement(By.id(idButtonAdd)).click();
    }

    @And("^presiono mas opciones para tarea ant$")
    public void presionoMasOpcionesParaTarea() {
        String idBtnDateRemember = "com.vrproductiveapps.whendo:id/note_item_reminder";
        driver.findElement(By.id(idBtnDateRemember)).click();
    }

    @And("^Agrego los siguientes datos a la tarea ant$")
    public void agregoLosSiguientesDatosALaTarea(TaskWhendo taskWhendo) {
        String hour = taskWhendo.getTime().split(":")[0];
        String minute = taskWhendo.getTime().split(":")[1];

        String idInputTextTitle = "com.vrproductiveapps.whendo:id/noteTextTitle";
        String idInputTextNote = "com.vrproductiveapps.whendo:id/noteTextNotes";
        String idBtnDate = "com.vrproductiveapps.whendo:id/due_date_layout";
        String xpathInputDate = "//android.view.View[@content-desc='"+taskWhendo.getDate()+"']";
        String idBtnOk = "android:id/button1";
        String idBtnHour = "com.vrproductiveapps.whendo:id/time";
        String xpathInputHour = "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='"+hour+"']";
        String xpathInputMinute = "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='"+minute+"']";
        String idBtnRemember = "com.vrproductiveapps.whendo:id/reminder";
        String xpathInputRemember = "//android.widget.RadioButton[@text='"+taskWhendo.getRemember()+"']";
        String idBtnRepeat = "com.vrproductiveapps.whendo:id/repeat";
        String xpathInputRepeat = "//android.widget.RadioButton[@text='"+taskWhendo.getRepeat()+"']";

        driver.findElement(By.id(idInputTextTitle)).sendKeys(taskWhendo.getTitle());
        driver.findElement(By.id(idInputTextNote)).sendKeys(taskWhendo.getNotes());

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
    }

    @When("^guardo la tarea ant$")
    public void guardoLaTarea() throws InterruptedException {
        String idBtnSave = "com.vrproductiveapps.whendo:id/saveItem";
        driver.findElement(By.id(idBtnSave)).click();
        Thread.sleep(2000);
    }

    @Then("^valido los siguientes datos ant$")
    public void validoLosSiguientesDatos(TaskWhendoResult taskWhendoResult) {
        String xpathTitlesText = "//android.widget.TextView[@resource-id='com.vrproductiveapps.whendo:id/home_list_item_text']";
        String xpathNotesText = "//android.widget.TextView[@resource-id='com.vrproductiveapps.whendo:id/home_list_item_text2']";
        List<WebElement> titlesText = driver.findElements(By.xpath(xpathTitlesText));
        List<WebElement> notesText = driver.findElements(By.xpath(xpathNotesText));
        boolean exist = false;
        for (int i = 0 ; i < titlesText.size() ; i++){
            if(titlesText.get(i).getText().equals(taskWhendoResult.getTitle())
                    && notesText.get(i).getText().equals(taskWhendoResult.getNotes())){
                exist = true;
                break;
            }
        }
        Assertions.assertTrue(exist);

        driver.quit();
    }

//    @DataTableType
//    public TaskWhendo taskWhendoConvert2(Map<String,String> entity){
//        TaskWhendo taskWhendo = new TaskWhendo();
//        taskWhendo.setTitle(entity.get("title"));
//        taskWhendo.setNotes(entity.get("notes"));
//        taskWhendo.setDate(entity.get("due_date"));
//        taskWhendo.setTime(entity.get("time"));
//        taskWhendo.setRepeat(entity.get("repeat"));
//        taskWhendo.setRemember(entity.get("remember"));
//        return taskWhendo;
//    }
//
//    @DataTableType
//    public TaskWhendoResult taskWhendoResultConvert2(Map<String,String> entity){
//        TaskWhendoResult taskWhendoResult = new TaskWhendoResult();
//        taskWhendoResult.setTitle(entity.get("title"));
//        taskWhendoResult.setNotes(entity.get("notes"));
//        return taskWhendoResult;
//    }
}
