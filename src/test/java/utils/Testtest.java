package utils;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Testtest {

    @Test
    public void myTestClass() {

        By locato = By.xpath(locator.replace("$replaceMe$", "home"));

        System.out.println(locato);

    }

    static String locator = "//label[@for='tree-node-$replaceMe$']//preceding-sibling::button[@type='button']";
}
