package utils;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import lombok.Cleanup;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class Utils {
    Faker faker = new Faker();
    Random random = new Random();

    //    public List<String> readFileToList(String fileName) {
//        String content;
//        try {
//            content = IOUtils.toString(Paths.get(fileName).toUri(), StandardCharsets.UTF_8);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return content.lines().toList();
//    }
    private static void writeFile(String location, String fileName, String data) {
        try {
            FileWriter fileWriter = new FileWriter(location + fileName);
            @Cleanup
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    public void jsonGenerator() {
//        Gson gson = new Gson();
//        Employees employees = employeesGenerator(7);
//        String jsonString = gson.toJson(employees);
//        String fileName = "test1.json";
//        writeFile(rssPath, fileName, jsonString);
//    }
//    public Employees employeesGenerator(int nrOfUsers) {
//        List<Employee> employees = new ArrayList<>();
//        for (int i = 0; i < nrOfUsers; i++) {
//            employees.add(Employee.builder()
//                    .withFirstName(getFromMap("firstName").get(random.nextInt(getFromMap("firstName").size())))
//                    .withLastName(RandomStringUtils.randomAlphabetic(5))
//                    .withEmail(RandomStringUtils.randomAlphabetic(10) + "@example.com")
//                    .withAge((int) (Math.random() * (60 - 22) + 22))
//                    .withSalary((50000 + i * 10000))
//                    .withDepartment("IT")
//                    .build());
//        }
//        return Employees.builder().withEmployees(employees).build();
//    }

    private List<String> getFromMap(String key) {
        Map<String, List<String>> map = new HashMap<>() {{
            put("firstName", Arrays.asList("John", "Johnny", "Johnathan"));
            put("lastName", Arrays.asList("Malkovish", "Doe", "Yes"));
        }};
        return map.get(key);
    }

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

    public String readFileToString(String fileName) {
        String content;
        try {
            content = IOUtils.toString(Paths.get(fileName).toUri(), StandardCharsets.UTF_8);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content;
    }

    public Name getName() {
        return faker.name();
    }

    public LocalDate getDateOfBirth() {
        LocalDate start = LocalDate.of(1970, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2003, Month.JANUARY, 1);
        long days = ChronoUnit.DAYS.between(start, end);
        return start.plusDays(random.nextInt((int) days + 1));
    }

    public List<String> getRoleAndSeniority(String key) {
        Map<String, List<String>> map = new HashMap<>() {{
            put("role", Arrays.asList("Technician", "Engineer", "HR", "PM", "Accountant"));
            put("seniority", Arrays.asList("Junior", "Mid", "Senior", "Expert"));
            put("gender", Arrays.asList("Male", "Female"));
        }};
        return map.get(key);
    }

    public int getSalary() {
        return (random.nextInt(120 - 50) + 50)*1000;
    }
    public int getBonusPercent(){
        return (random.nextInt(100 - 1) + 1);
    }

}