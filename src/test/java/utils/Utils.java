package utils;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import lombok.Cleanup;
import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Utils {
    Faker faker = new Faker();
    Random random = new Random();

    public static void writeFile(String location, String fileName, String data) {
        try {
            FileWriter fileWriter = new FileWriter(location + fileName);
            @Cleanup PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public Name getRandomName() {
        return faker.name();
    }

    public LocalDate getRandomDate(int startYear, int startDay, int endYear, int endDay) {
        LocalDate start = LocalDate.of(startYear, Month.JANUARY, startDay);
        LocalDate end = LocalDate.of(endYear, Month.JANUARY, endDay);
        long days = ChronoUnit.DAYS.between(start, end);
        return start.plusDays(random.nextInt((int) days + 1));
    }
}