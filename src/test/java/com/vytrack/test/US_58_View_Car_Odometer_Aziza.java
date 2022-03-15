package com.vytrack.test;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class US_58_View_Car_Odometer_Aziza {
    @BeforeTest
    public void setUp() {
        Driver.getDriver();
    }

   @Test
    public void test() {
        VytrackUtils.loginAsDriver();
      WebElement fleetButton = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetButton.click();
       WebElement vehicleOdometerButton= Driver.getDriver().findElement(By.xpath("//span[text()='Vehicle Odometer']"));
       vehicleOdometerButton.click();
      WebElement numberOfPageShownDefault= Driver.getDriver().findElement(By.xpath("//input[@type='number']"));
      String actualNumberOfPageShown =numberOfPageShownDefault.getAttribute("value");
      String expectedNumberOfPageShown="1";
        Assert.assertEquals(actualNumberOfPageShown,expectedNumberOfPageShown);
        WebElement viewPerPage = Driver.getDriver().findElement(By.xpath("//button[@class='btn dropdown-toggle ']"));
        String expectedViewPerPage ="25";
        String actualViewPerPage=viewPerPage.getText();
        Assert.assertEquals(expectedViewPerPage,actualViewPerPage);
       Driver.closeDriver();
    }

    @Test
    public void test2() {
        VytrackUtils.loginAsSalesManager();
        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("(//li[@class='dropdown dropdown-level-1'])[1]"));
        BrowserUtils.sleep(6);
        Actions actions =new Actions(Driver.getDriver());
        actions.moveToElement(fleetButton).click().perform();
        WebElement vehicleOdometerButton= Driver.getDriver().findElement(By.xpath("//span[text()='Vehicle Odometer']"));
        actions.moveToElement(vehicleOdometerButton).click().build().perform();
         String expectedMessage ="You do not have permission to perform this action.";
        String actualMessage=Driver.getDriver().findElement(By.xpath("//div[text()='You do not have permission to perform this action.']")).getText();
        Assert.assertTrue(actualMessage.equals(expectedMessage));
        Driver.closeDriver();
    }
}
