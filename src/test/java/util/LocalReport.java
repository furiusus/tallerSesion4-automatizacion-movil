package util;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LocalReport {
    public static void main(String[] args) {
        String ruta=new File("").getAbsolutePath()+"/build/reports/cucumber/";
        File reportFolder= new File(ruta+"ReportesCucumber");

        List<String> jsonList= new ArrayList<>();
        jsonList.add(ruta+"report.json");

        Configuration configuration= new Configuration(reportFolder,"AppiumTraining");
        configuration.setBuildNumber("000010");
        configuration.addClassifications("branch","develop");
        configuration.addClassifications("OS","Android");
        configuration.addClassifications("report","local");
        configuration.addClassifications("owner","Ronny");

        ReportBuilder reportBuilder= new ReportBuilder(jsonList,configuration);
        reportBuilder.generateReports();
    }
}
