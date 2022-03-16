package com.vytrack.test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.VytrackUtils;

public class US_49_access_To_The_Oroinc_Documentation_Igor {
    @Test(dataProvider = "LoginCredentials")
    public void access_OroincDocPage(String username, String password){
        String expectedUrl = "https://doc.oroinc.com/";
        String expectedTitle = "Welcome to Oro Documentation";
        VytrackUtils.login(username, password);
        BrowserUtils.sleep(2);
        Driver.getDriver().findElement(By.xpath("//i[@class='fa-question-circle']")).click();
        BrowserUtils.sleep(3);
        BrowserUtils.switchWindow(Driver.getDriver(), expectedUrl);
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
}
