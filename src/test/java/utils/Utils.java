package utils;

import entities.webtables.Employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static List<String> userList;
    public static List<Employee> employeeList;


    public List<String> readFileToList(File file) {
        try {
            return new BufferedReader(new FileReader(file)).lines().toList();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getListFromRow(String value) {
        return Arrays.asList(value.split(";"));
    }

}
