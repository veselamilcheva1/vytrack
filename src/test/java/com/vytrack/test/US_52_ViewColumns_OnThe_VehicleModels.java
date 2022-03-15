package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_52_ViewColumns_OnThe_VehicleModels {

    @Test
    public void VehicleModesPage_modules_as_sales_manager(){
        VytrackUtils.loginAsSalesManager();

        //Users click Fleet tab
        WebElement fleetClick = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        BrowserUtils.sleep(3);
        fleetClick.click();

        //Users click Vehicle Model tab
        WebElement vehiclesModel = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles Model']"));
        vehiclesModel.click();
        BrowserUtils.sleep(2);
        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='grid-header-cell__label']"));
        List<String> actualmoduleTexts = new ArrayList<>();

        for (WebElement moduleElement : moduleElements) {
            actualmoduleTexts.add(moduleElement.getText());
            if(moduleElement.getText().equals("VENDORS")){
                break;
            }

        }
        List<String> expectedmoduleTexts = new ArrayList<>(Arrays.asList("MODEL NAME",
                "MAKE",
                "CAN BE REQUESTED",
                "CVVI",
                "CO2 FEE (/MONTH)",
                "COST (DEPRECIATED)",
                "TOTAL COST (DEPRECIATED)",
                "CO2 EMISSIONS",
                "FUEL TYPE",
                "VENDORS"));

        Assert.assertEquals(actualmoduleTexts, expectedmoduleTexts);

        Assert.assertEquals(actualmoduleTexts.size(),expectedmoduleTexts.size());



    }
}
