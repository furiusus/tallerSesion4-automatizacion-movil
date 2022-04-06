package activity.wendo;

import control.Button;
import control.Input;
import org.openqa.selenium.By;

public class NewActivityFormScreen {

    public Input idInputTextTitle = new Input(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public Input idInputTextNote = new Input(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
    public Button idBtnDateRemember = new Button(By.id("com.vrproductiveapps.whendo:id/note_item_reminder"));
    public Button idBtnDate = new Button(By.id("com.vrproductiveapps.whendo:id/due_date_layout"));
    public Button idBtnOk = new Button(By.id("android:id/button1"));
    public Button idBtnHour = new Button(By.id("com.vrproductiveapps.whendo:id/time"));
    public Button idBtnRemember = new Button(By.id("com.vrproductiveapps.whendo:id/reminder"));
    public Button idBtnRepeat =  new Button(By.id("com.vrproductiveapps.whendo:id/repeat"));
    public Button idBtnSave = new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));

    public Input xpathInputDate(String date){
        return new Input(By.xpath("//android.view.View[@content-desc='"+date+"']"));
    }

    public Input xpathInputHour(String hour){
        return new Input(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='"+hour+"']"));
    }

    public Input xpathInputMinute(String minute){
        return new Input(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='"+minute+"']"));
    }

    public Input xpathInputRemember(String timeRemember){
        return new Input(By.xpath("//android.widget.RadioButton[@text='"+timeRemember+"']"));
    }

    public Input xpathInputRepeat(String frequency){
        return new Input(By.xpath("//android.widget.RadioButton[@text='"+frequency+"']"));
    }
}
