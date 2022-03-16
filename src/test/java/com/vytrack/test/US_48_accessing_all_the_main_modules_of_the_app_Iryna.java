package com.vytrack.test;


import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_48_accessing_all_the_main_modules_of_the_app_Iryna {


    @Test (priority = 1)
    public void verifyingModulesAsSalesManager() {
        VytrackUtils.loginAsSalesManager();
        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
        List<String> actualModuleText = new ArrayList<>();
        List<String> expected = new ArrayList<>(Arrays.asList("Dashboards", "Fleet", "Customers", "Sales", "Activities", "Marketing", "Reports & Segments", "System"));
        int index = 0;
        for (WebElement eachModuleElement : moduleElements) {
            String moduleElementText = eachModuleElement.getText();
            actualModuleText.add(moduleElementText);
           // System.out.println("eachModuleElement.getText() = " + eachModuleElement.getText());
        }
        for (String each : actualModuleText) {
           // System.out.println("each.equals(expected.get(index++)) = " + each.equals(expected.get(index++)));
            Assert.assertTrue(each.equals(expected.get(index++)), "Test is FAILED!!!");

        }
//        moduleElements.forEach(k->actualModuleText.add(k.getText()));
        System.out.println(actualModuleText);
    }

    @Test (priority = 2)
    public void verifyingModulesAsStoreManager() {
        VytrackUtils.loginAsStoreManger();
        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
        List<String> actualModuleText = new ArrayList<>();
        List<String> expected = new ArrayList<>(Arrays.asList("Dashboards", "Fleet", "Customers", "Sales", "Activities", "Marketing", "Reports & Segments", "System"));
        int index = 0;
        for (WebElement eachModuleElement : moduleElements) {
            String moduleElementText = eachModuleElement.getText();
            actualModuleText.add(moduleElementText);
            // System.out.println("eachModuleElement.getText() = " + eachModuleElement.getText());
        }
        for (String each : actualModuleText) {
            // System.out.println("each.equals(expected.get(index++)) = " + each.equals(expected.get(index++)));
            Assert.assertTrue(each.equals(expected.get(index++)), "Test is FAILED!!!");

        }
//        moduleElements.forEach(k->actualModuleText.add(k.getText()));
        System.out.println(actualModuleText);
    }


//    @Test (priority = 3)
//    public void verifyingModulesAsDriver() {
//        VytrackUtils.loginAsDriver();
//        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//ul[@class='nav-multilevel main-menu']/li"));
//        List<String> actualModuleText = new ArrayList<>();
//        List<String> expected = new ArrayList<>(Arrays.asList("Fleet", "Customers", "Activities", "System"));
//        int index = 0;
//        for (WebElement eachModuleElement : moduleElements) {
//            String moduleElementText = eachModuleElement.getText();
//            actualModuleText.add(moduleElementText);
//            System.out.println("eachModuleElement.getText() = " + moduleElementText);
//        }
//     //   Assert.assertTrue(actualModuleText.containsAll(expected));
//        for (String each : actualModuleText) {
//          //  System.out.println("each.equals(expected.get(index++)) = " + each.equals(expected.get(index++)));
//            Assert.assertTrue(each.contains(expected.get(index++)), "Test is FAILED!!!");
//
//        }
////        moduleElements.forEach(k->actualModuleText.add(k.getText()));
//        System.out.println(actualModuleText);
//    }

    @Test
    public void test1() {
        VytrackUtils.loginAsDriver();
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
        List<String> expectedElements = new ArrayList<>(Arrays.asList("Fleet", "Customers", "Activities", "System"));
        List<String> actualElements = new ArrayList<>();
        for (WebElement each : list) {
            actualElements.add(each.getText());
            System.out.println("each.getText() = " + each.getText());
        }
        Assert.assertTrue(expectedElements.containsAll(actualElements));

    }
}