package fortest;

import com.demoqa.frontend.dto.jsonstructurebuilder.Departments;
import com.demoqa.frontend.dto.jsonstructurebuilder.JsonStructureBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.saucedemo.dto.userbuilderjson.Users;
import com.saucedemo.dto.userbuilderjson.UsersBuilder;
import org.testng.annotations.Test;
import com.demoqa.frontend.utils.Utils;


public class TestTest {

    JsonStructureBuilder jsonStructureBuilder = new JsonStructureBuilder();
    UsersBuilder usersBuilder = new UsersBuilder();

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
    @Test
    public void testWriteJsonFile(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Users users = usersBuilder.userGenerator();
        String userJsonString = gson.toJson(users);
        String rssPath = "src/test/resources/testdata/jsonData/";
        String fileName = "usersJsonGeneratedFile.json";
        Utils.writeFile(rssPath,fileName,userJsonString);

    }

}