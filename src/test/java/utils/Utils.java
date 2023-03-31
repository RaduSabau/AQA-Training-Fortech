package utils;

import entities.Employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static List<String> userList;
    public static List<Employee> employeeList;
    static String localDir = System.getProperty("user.dir");
    static File file = new File(localDir + "/src/test/resources/testdata/testdata.txt");
    static BufferedReader br;

    public void readFile() {
        try {
            br = new BufferedReader(new FileReader(file));
            userList = br.lines().toList();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Employee getEmployee(int row) {
        return Employee.builder().withFirstName(getStringToList(row).get(0))
                .withLastName(getStringToList(row).get(1))
                .withEmail(getStringToList(row).get(2))
                .withAge(Integer.valueOf(getStringToList(row).get(3)))
                .withSalary(Integer.valueOf(getStringToList(row).get(4)))
                .withDepartment(getStringToList(row).get(5))
                .build();
    }

    public List<String> getStringToList(int row) {
        String[] str;
        try {
            str = userList.get(row).split(" ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Arrays.asList(str);
    }
}
