package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_53_Edit_Car_Info_Icons_Margie {
    @Test
    public void hovering() {
        VytrackUtils.loginAsDriver();

        //locate Fleet module
        WebElement Fleet = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        //locate vehicle under Fleet


        Actions actions = new Actions(Driver.getDriver());
        //Hover over the VehicleText
        BrowserUtils.sleep(2);
        actions.moveToElement(Fleet).perform();
        WebElement vehicle = Driver.getDriver().findElement(By.xpath("//span[.='Vehicles']"));
        vehicle.click();
        //locate "..." module
        WebElement dots = Driver.getDriver().findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]"));
        BrowserUtils.sleep(2);
        actions.moveToElement(dots).perform();

        WebElement dots1 = Driver.getDriver().findElement(By.xpath("(//tbody//td[@class='action-cell grid-cell grid-body-cell']//a[@class='dropdown-toggle'])[1]"));
        BrowserUtils.sleep(2);
        actions.moveToElement(dots1).perform();

        List<String> expectedOptions = new ArrayList<>(Arrays.asList("View", "Edit", "Delete"));
        List<WebElement> carInfo = Driver.getDriver().findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu__action-cell launchers-dropdown-menu']//li//ul//li//a"));
        List<String> actualOptions = new ArrayList<>();
        for (WebElement each : carInfo) {
            actualOptions.add(each.getAttribute("title"));
        }
        Assert.assertTrue(expectedOptions.containsAll(actualOptions));


    }


}
