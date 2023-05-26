package com.saucedemo.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class Utils {

    public Double getDoubleFromElement(WebElement element){
        return Double.parseDouble(element.getText().replaceAll("[^0-9\\.]",""));
    }
    public Double calculatePercentOfNumber(Double number, Double percent){
        return Math.ceil(number)*percent/100.00;
    }

    public String concatStringWithLine(String string) {
        String[] splitString = string.split(" ");
        StringBuilder stringB = new StringBuilder();
        for (String s : splitString) {
            stringB.append("-").append(s.toLowerCase());
        }
        return stringB.toString();
    }


}
