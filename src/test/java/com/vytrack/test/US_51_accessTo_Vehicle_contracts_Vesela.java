package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.vytrack.utilities.VytrackUtils;

public class US_51_accessTo_Vehicle_contracts_Vesela {


    @Test(priority = 1)
    public void store_manager_access_to_vehicle_contracts_page() {


        Driver.getDriver().get(ConfigurationReader.getProperty("env2"));
        VytrackUtils.loginAsStoreManger();
        WebElement fleet = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]"));
        BrowserUtils.sleep(3);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleet).perform();
//    Verify managers can access the Vehicle contracts page
        String vehicleContract = "//span[normalize-space()='Vehicle Contracts' and contains(@class, 'title title-level-2')]";
        BrowserUtils.sleep(3);
        WebElement vehiclesContract = Driver.getDriver().findElement(By.xpath(vehicleContract));
        vehiclesContract.click();
        BrowserUtils.sleep(5);
        //    Expected URL: https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract";
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

    @Test(priority = 2)
    public void sales_managers_access_to_vehicle_contracts_page() {

//    AC1: Store managers and Sales managers access the Vehicle contracts page.
        Driver.getDriver().get(ConfigurationReader.getProperty("env2"));
        VytrackUtils.loginAsSalesManager();
//    Click the Vehicle contracts under the Fleet
        WebElement fleet = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]"));
        BrowserUtils.sleep(3);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleet).perform();
        BrowserUtils.sleep(3);
//    Verify managers can access the Vehicle contracts page
        String vehicleContract = "//span[normalize-space()='Vehicle Contracts' and contains(@class, 'title title-level-2')]";

        BrowserUtils.sleep(3);
        WebElement vehiclesContract = Driver.getDriver().findElement(By.xpath(vehicleContract));
        vehiclesContract.click();
        BrowserUtils.sleep(5);
        //    Expected URL: https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract";
        BrowserUtils.sleep(3);
        Assert.assertEquals(actualURL, expectedURL);
//        System.out.println("expectedURL = " + expectedURL);
//        System.out.println("actualURL = " + actualURL);
        //    Expected title: All - Vehicle Contract - Entities - System - Car - Entities - System
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";
//        System.out.println("expectedTitle = " + expectedTitle);
//        System.out.println("actualTitle = " + actualTitle);
        BrowserUtils.sleep(3);
        Assert.assertEquals(actualTitle, expectedTitle);
        Driver.closeDriver();
    }

    @Test(priority = 3)
    public void driver_can_not_access_vehicle_contracts() {
//        Test cases #2
//        Description: Drivers can NOT access the Vehicle contracts page
//        Environment: https://qa2.vytrack.com/user/login
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
//        Steps:
//        Login as drivers
        VytrackUtils.loginAsDriver();
//        Click the Vehicle contracts under the Fleet

        WebElement fleet = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]"));
        BrowserUtils.sleep(3);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleet).perform();
        BrowserUtils.sleep(3);
//    Verify driver see an error message: “You do not have permission to perform this action.”
        String vehicleContract = "//span[normalize-space()='Vehicle Contracts' and contains(@class, 'title title-level-2')]";

        BrowserUtils.sleep(3);
        WebElement vehiclesContract = Driver.getDriver().findElement(By.xpath(vehicleContract));
        vehiclesContract.click();
        BrowserUtils.sleep(5);
        WebElement actualM = Driver.getDriver().findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));
        String actualMessage = actualM.getText();
        String expectedMessage = "You do not have permission to perform this action.";
        BrowserUtils.sleep(3);
        Assert.assertEquals(actualMessage, expectedMessage);
        Driver.getDriver().close();
//
    }
}
