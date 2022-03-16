package com.vytrack.test;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.VytrackUtils;

public class US_51_accessTo_Vehicle_contracts_Vesela {


    @BeforeMethod
    public void setup() {
        Driver.getDriver();
    }

    @Test
    public void sales_managers_access_to_vehicle_contracts_page() {


        Driver.getDriver().get(ConfigurationReader.getProperty("env2"));
        VytrackUtils.loginAsSalesManager();
        WebElement fleet = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleet).perform();
        BrowserUtils.sleep(3);
        String vehicleContract = "//span[normalize-space()='Vehicle Contracts' and contains(@class, 'title title-level-2')]";
        WebElement vehiclesContract = Driver.getDriver().findElement(By.xpath(vehicleContract));
        vehiclesContract.click();
        BrowserUtils.sleep(3);
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract";
        Assert.assertEquals(actualURL, expectedURL);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";
        BrowserUtils.sleep(3);
        Assert.assertEquals(actualTitle, expectedTitle);
        Driver.closeDriver();
    }

    @Test
    public void store_manager_access_to_vehicle_contracts_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env2"));
        VytrackUtils.loginAsStoreManger();
        WebElement fleet = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]"));
        BrowserUtils.sleep(3);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleet).perform();
        BrowserUtils.sleep(3);
        String vehicleContract = "//span[normalize-space()='Vehicle Contracts' and contains(@class, 'title title-level-2')]";
        BrowserUtils.sleep(3);
        WebElement vehiclesContract = Driver.getDriver().findElement(By.xpath(vehicleContract));
        vehiclesContract.click();
        BrowserUtils.sleep(5);
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract";
        BrowserUtils.sleep(3);
        Assert.assertEquals(actualURL, expectedURL);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";
        System.out.println("expectedTitle = " + expectedTitle);
        System.out.println("actualTitle = " + actualTitle);
        BrowserUtils.sleep(3);
        Assert.assertEquals(actualTitle, expectedTitle);
        Driver.closeDriver();
    }

    @Test
    public void driver_can_not_access_vehicle_contracts() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env2"));
        VytrackUtils.loginAsDriver();
        WebElement fleet = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]"));
        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(3);
        actions.moveToElement(fleet).perform();
        String vehicleContract = "//span[normalize-space()='Vehicle Contracts' and contains(@class, 'title title-level-2')]";
        WebElement vehiclesContract = Driver.getDriver().findElement(By.xpath(vehicleContract));
        vehiclesContract.click();
        BrowserUtils.sleep(3);
        WebElement actualM = Driver.getDriver().findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));
        String actualMessage = actualM.getText();
        String expectedMessage = "You do not have permission to perform this action.";
        BrowserUtils.sleep(3);
        Assert.assertEquals(actualMessage, expectedMessage);
        Driver.closeDriver();
    }


    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }


}
