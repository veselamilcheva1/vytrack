package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_61_manageFilters_On_Vehicles_CostPage {

    @Test(dataProvider = "LoginCredentials")
    public void manageFiltersOnVehicleCost(String username, String password){
        VytrackUtils.login(username, password);
        WebElement fleetModule = Driver.getDriver().findElement(By.xpath("(//span[contains(text(),'Fleet')])[1]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetModule).perform();
        BrowserUtils.sleep(2);
        WebElement vehicleCostModule = Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Costs']"));
        BrowserUtils.sleep(1);
        actions.moveToElement(vehicleCostModule).perform();
        vehicleCostModule.click();
        BrowserUtils.sleep(2);

        int index = 0;
        List<WebElement> actualColumns = Driver.getDriver().findElements(By.xpath("(//tr[@class='grid-header-row'])[1]//span[@class='grid-header-cell__label']"));
        List<String> expectedColumns = new ArrayList<>(Arrays.asList("TYPE", "TOTAL PRICE", "DATE"));
        for (String each : expectedColumns) {
            Assert.assertEquals(each,actualColumns.get(index++).getText());
        }
    }

    @Test(dataProvider = "LoginCredentials")
    public void checkAllVehicleCost_checkBoxes(String username, String password){
        VytrackUtils.login(username, password);
        WebElement fleetModule = Driver.getDriver().findElement(By.xpath("(//span[contains(text(),'Fleet')])[1]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetModule).perform();
        BrowserUtils.sleep(2);
        WebElement vehicleCostModule = Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Costs']"));
        BrowserUtils.sleep(1);
        actions.moveToElement(vehicleCostModule).perform();
        vehicleCostModule.click();
        BrowserUtils.sleep(2);
        //locate checkBox
        Driver.getDriver().findElement(By.xpath("(//button//input[@type='checkbox'])[1]")).click();
        //locate all checkboxes inside table
        List<WebElement> checkBoxList = Driver.getDriver().findElements(By.xpath("//input[@tabindex='-1']"));
        int index = 0;
        for (WebElement eachCheckBox : checkBoxList) {
            Assert.assertTrue(eachCheckBox.isSelected());
            index++;
        }
        System.out.println("Total CheckBoxes: " + checkBoxList.size());
        System.out.println("Total CheckBoxes selected: " + index);
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
