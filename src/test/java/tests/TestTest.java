package tests;

import bean.jsonstructurebuilder.Departments;
import bean.jsonstructurebuilder.JsonStructureBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;
import utils.Utils;


public class TestTest {

    JsonStructureBuilder jsonStructureBuilder = new JsonStructureBuilder();

    @Test
    public void testJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Departments departments = jsonStructureBuilder.departmentsGenerator(7);
        String jsonString = gson.toJson(departments);
        String rssPath = "src/test/resources/testdata/jsonData/";
        String fileName = "jsonGeneratedFile.json";
        Utils.writeFile(rssPath, fileName, jsonString);
        System.out.println(jsonString);
    }

}