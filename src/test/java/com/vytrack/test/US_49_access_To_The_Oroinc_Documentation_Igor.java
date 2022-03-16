package com.vytrack.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.VytrackUtils;

import java.util.Set;

public class US_49_access_To_The_Oroinc_Documentation_Igor {
    @Test(dataProvider = "LoginCredentials")
    public void access_OroincDocPage(String username, String password){
        String expectedUrl = "https://doc.oroinc.com/";
        String expectedTitle = "Welcome to Oro Documentation";
        VytrackUtils.login(username, password);
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//i[@class='fa-question-circle']")).click();
        BrowserUtils.sleep(3);
        switchWindow(Driver.getDriver(), expectedUrl);
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }
    @DataProvider(name = "LoginCredentials")
    public String[][] dataProvier(){
        String driver = ConfigurationReader.getProperty("driver_username");
        String storeManager = ConfigurationReader.getProperty("store_manager_username");
        String salesManager = ConfigurationReader.getProperty("sales_manager_username");
        String pasword = ConfigurationReader.getProperty("password");

        String[][] credentials = {{driver, pasword}, {storeManager,pasword}, {salesManager, pasword}};
        return  credentials;
    }


    public static void switchWindow(WebDriver driver, String expectedUrl) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String each : allWindows) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().contains(expectedUrl)) {
                break;
            }
        }
        System.out.println("Curent url = " + driver.getCurrentUrl());
        System.out.println("Curent Title = " + driver.getTitle());
        String title = driver.getTitle();
    }
}
