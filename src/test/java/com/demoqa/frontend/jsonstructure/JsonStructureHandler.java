package com.demoqa.frontend.jsonstructure;

import com.github.javafaker.Faker;
import com.demoqa.frontend.utils.Utils;

import java.time.LocalDate;
import java.util.*;

public class JsonStructureHandler {
    Utils utils = new Utils();
    Random random = new Random();
    Faker faker = new Faker();

    public LocalDate getDateOfBirth() {
        return utils.getRandomDate(1970, 1, 2003, 1);
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
        return (random.nextInt(120 - 50) + 50) * 1000;
    }

    public int getBonusPercent() {
        return (random.nextInt(100 - 1) + 1);
    }

    public LocalDate getLastUpdatedDate() {
        return utils.getRandomDate(2020, 1, 2023, 1);
    }

    public Integer getIdNumber() {
        return faker.number().numberBetween(1, 1400);
    }
}
