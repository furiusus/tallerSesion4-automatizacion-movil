package runner;

import activity.wendo.ListActivityScreen;
import activity.wendo.NewActivityFormScreen;
import dao.TaskWhendo;
import dao.TaskWhendoResult;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

public class WhendoTaskStepDefs {
    ListActivityScreen listActivityScreen = new ListActivityScreen();
    NewActivityFormScreen newActivityFormScreen = new NewActivityFormScreen();

    @Given("abro el aplicativo Whendo")
    public void abroElAplicativoWhendo() {

    }

    @And("presiono la opcion para agregar tarea")
    public void presionoLaOpcionParaAgregarTarea() {
        listActivityScreen.idButtonAdd.click();
    }

    @And("presiono mas opciones para tarea")
    public void presionoMasOpcionesParaTarea() {
        newActivityFormScreen.idBtnDateRemember.click();
    }

    @And("Agrego los siguientes datos a la tarea")
    public void agregoLosSiguientesDatosALaTarea(TaskWhendo taskWhendo) {
        String hour = taskWhendo.getTime().split(":")[0];
        String minute = taskWhendo.getTime().split(":")[1];
        newActivityFormScreen.idInputTextTitle.type(taskWhendo.getTitle());
        newActivityFormScreen.idInputTextNote.type(taskWhendo.getNotes());
        newActivityFormScreen.idBtnDate.click();
        newActivityFormScreen.xpathInputDate(taskWhendo.getDate());
        newActivityFormScreen.idBtnOk.click();
        newActivityFormScreen.idBtnHour.click();
        newActivityFormScreen.xpathInputHour(hour).click();
        newActivityFormScreen.xpathInputMinute(minute).click();
        newActivityFormScreen.idBtnOk.click();
        newActivityFormScreen.idBtnRemember.click();
        newActivityFormScreen.xpathInputRemember(taskWhendo.getRemember()).click();
        newActivityFormScreen.idBtnRepeat.click();
        newActivityFormScreen.xpathInputRepeat(taskWhendo.getRepeat()).click();
    }

    @When("guardo la tarea")
    public void guardoLaTarea() {
        newActivityFormScreen.idBtnSave.click();
    }

    @Then("valido los siguientes datos")
    public void validoLosSiguientesDatos(TaskWhendoResult taskWhendoResult) {
        List<String> titlesText = listActivityScreen.xpathTitlesText.getValues();
        List<String> notesText = listActivityScreen.xpathNotesText.getValues();

        boolean exist = false;
        for (int i = 0 ; i < titlesText.size() ; i++){
            if(titlesText.get(i).equals(taskWhendoResult.getTitle())
                    && notesText.get(i).equals(taskWhendoResult.getNotes())){
                exist = true;
                break;
            }
        }
        Assertions.assertTrue(exist);
    }

    @DataTableType
    public TaskWhendo taskWhendoConvert(Map<String,String> entity){
        TaskWhendo taskWhendo = new TaskWhendo();
        taskWhendo.setTitle(entity.get("title"));
        taskWhendo.setNotes(entity.get("notes"));
        taskWhendo.setDate(entity.get("due_date"));
        taskWhendo.setTime(entity.get("time"));
        taskWhendo.setRepeat(entity.get("repeat"));
        taskWhendo.setRemember(entity.get("remember"));
        return taskWhendo;
    }

    @DataTableType
    public TaskWhendoResult taskWhendoResultConvert(Map<String,String> entity){
        TaskWhendoResult taskWhendoResult = new TaskWhendoResult();
        taskWhendoResult.setTitle(entity.get("title"));
        taskWhendoResult.setNotes(entity.get("notes"));
        return taskWhendoResult;
    }
}
