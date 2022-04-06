package runner;

import io.cucumber.java.*;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import session.Session;

@RunWith(Cucumber.class)
public class Runner {

    @Before
    public void before(){

    }

    @After
    public void after(){
        Session.getInstance().closeApp();
    }

    @AfterStep
    public void afterStep(Scenario scenario){
        byte[] screen=Session.getInstance().getDriver().getScreenshotAs(OutputType.BYTES);
        scenario.attach(screen,"image/png","afterStep"+scenario.getName());
    }

    @BeforeStep
    public void beforeStep(Scenario scenario){
        byte[] screen=Session.getInstance().getDriver().getScreenshotAs(OutputType.BYTES);
        scenario.attach(screen,"image/png","beforeStep"+scenario.getName());
    }
}
