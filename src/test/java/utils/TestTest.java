package utils;

import bean.jsonstructureobjbuilder.Departments;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;

import java.util.Random;


public class TestTest {

    JsonStructure jsonStructure = new JsonStructure();
    Utils utils = new Utils();
    Random random = new Random();


    @Test
    public void testJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Departments departments = jsonStructure.departmentsGenerator(3);
        String jsonString = gson.toJson(departments);
        String rssPath = "src/test/resources/testdata/jsonData/";
        String fileName = "jsonGeneratedFile.json";
        Utils.writeFile(rssPath, fileName, jsonString);
    }

}