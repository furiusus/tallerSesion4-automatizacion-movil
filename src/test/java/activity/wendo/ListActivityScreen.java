package activity.wendo;

import control.Button;
import control.Label;
import control.ListLabel;
import org.openqa.selenium.By;

public class ListActivityScreen {
    public Button idButtonAdd = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));
    public ListLabel xpathTitlesText = new ListLabel(By.xpath("//android.widget.TextView[@resource-id='com.vrproductiveapps.whendo:id/home_list_item_text']"));
    public ListLabel xpathNotesText = new ListLabel(By.xpath("//android.widget.TextView[@resource-id='com.vrproductiveapps.whendo:id/home_list_item_text2']"));
}
