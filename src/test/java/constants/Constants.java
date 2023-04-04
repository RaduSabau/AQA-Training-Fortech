package constants;

import java.io.File;

public class Constants {
    public static final String MAIN_URL = "https://demoqa.com/";
    public static final String TEXT_SAMPLE = "This is a sample page";
    public static final String LONG_TEXT_SAMPLE = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
    public static final String PAGE_TITLE_CLASS_NAME = "main-header";
    public static final String FIRST_NAME = "John";
    public static final String LAST_NAME = "Doe";
    public static final String USER_EMAIL = "johndoe@gmail.com";
    public static final int USER_AGE = 35;
    public static final int USER_SALARY = 30000;
    public static final String DEPARTMENT = "Tech";
    public static final String FIRST_NAME_TO_DELETE = "Kierra";
    public static final String FIRST_NAME_TO_EDIT = "John";
    public static final int USER_NEW_SALARY = 20000;
    public static final String HOME_NODE = "home";
    public static final String DOCUMENTS_NODE = "documents";
    public static final String WORK_SPACE_NODE = "workspace";
    public static final String REACT_NODE = "react";
    public static final String ANGULAR_NODE = "angular";
    public static final String VEU_NODE = "veu";
    public static final String PARENT_FRAME_TEXT = "Parent frame";
    public static final String INNER_FRAME_TEXT = "Child Iframe";
    static String localDir = System.getProperty("user.dir");
    public static File employeesfile = new File(localDir + "/src/test/resources/testdata/testemployee" +
            "data.txt");
    public static File studentsfile = new File(localDir + "/src/test/resources/testdata/teststudentdata.txt");
}
