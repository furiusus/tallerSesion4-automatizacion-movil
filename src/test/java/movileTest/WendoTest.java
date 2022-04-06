package movileTest;

import activity.wendo.ListActivityScreen;
import activity.wendo.NewActivityFormScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

import java.util.List;

public class WendoTest {
    ListActivityScreen listActivityScreen = new ListActivityScreen();
    NewActivityFormScreen newActivityFormScreen = new NewActivityFormScreen();

    @Test
    public void addTask(){

        String title = "ASGSKDHFGKSDGHF";
        String textNote = "1265254345";
        String date = "22 April 2022";
        String hour = "10";
        String minute = "35";
        String timeRemember = "15 minutes before";
        String frequency = "Daily";

        listActivityScreen.idButtonAdd.click();
        newActivityFormScreen.idInputTextTitle.type(title);
        newActivityFormScreen.idInputTextNote.type(textNote);
        newActivityFormScreen.idBtnDateRemember.click();
        newActivityFormScreen.idBtnDate.click();
        newActivityFormScreen.xpathInputDate(date);
        newActivityFormScreen.idBtnOk.click();
        newActivityFormScreen.idBtnHour.click();
        newActivityFormScreen.xpathInputHour(hour).click();
        newActivityFormScreen.xpathInputMinute(minute).click();
        newActivityFormScreen.idBtnOk.click();
        newActivityFormScreen.idBtnRemember.click();
        newActivityFormScreen.xpathInputRemember(timeRemember).click();
        newActivityFormScreen.idBtnRepeat.click();
        newActivityFormScreen.xpathInputRepeat(frequency).click();
        newActivityFormScreen.idBtnSave.click();

        List<String> titlesText = listActivityScreen.xpathTitlesText.getValues();
        List<String> notesText = listActivityScreen.xpathNotesText.getValues();

        boolean exist = false;
        for (int i = 0 ; i < titlesText.size() ; i++){
            if(titlesText.get(i).equals(title) && notesText.get(i).equals(textNote)){
                exist = true;
                break;
            }
        }
        Assertions.assertTrue(exist);
    }

    @AfterEach
    public void close(){
        Session.getInstance().closeApp();
    }
}
