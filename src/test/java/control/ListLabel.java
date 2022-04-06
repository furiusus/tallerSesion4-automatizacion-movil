package control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

import java.util.ArrayList;
import java.util.List;

public class ListLabel extends AppiumControl{
    protected List<WebElement> listControl;

    public ListLabel(By locator) {
        super(locator);
    }

    protected void findControls(){
        this.listControl = Session.getInstance().getDriver().findElements(this.locator);
    }

    public List<String> getValues(){
        this.findControls();
        List<String> listValue = new ArrayList<>();
        for (WebElement e:this.listControl){
            listValue.add(e.getText());
        }
        return listValue;
    }
}
