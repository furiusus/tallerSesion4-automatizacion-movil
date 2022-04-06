package control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

import java.util.List;

public class AppiumControl {
    protected By locator;
    protected WebElement control;

    public AppiumControl(By locator){
        this.locator = locator;
    }

    protected void findControl(){
        this.control = Session.getInstance().getDriver().findElement(this.locator);
    }

    public void click(){
        this.findControl();
        this.control.click();
    }

    public void type(String text){
        this.findControl();
        this.control.sendKeys(text);
    }

    public void getValue(){
        this.findControl();
        this.control.getText();
    }

}
