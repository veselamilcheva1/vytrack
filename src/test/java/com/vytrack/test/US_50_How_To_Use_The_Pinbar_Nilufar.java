package com.vytrack.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.VytrackUtils;

public class US_50_How_To_Use_The_Pinbar_Nilufar {

    @DataProvider(name = "LoginData")
    public String[][] dataProvier(){
        String driver = ConfigurationReader.getProperty("driver_username");
        String storeManager = ConfigurationReader.getProperty("store_manager_username");
        String salesManager = ConfigurationReader.getProperty("sales_manager_username");
        String password = ConfigurationReader.getProperty("password");

        String[][] credentials = {{"user7", "UserUser123"}, {"storemanager55","UserUser123"}, {"salesmanager105", "UserUser123"}};
        return  credentials;
    }
    @Test(dataProvider = "LoginData")
    public void LearnHowToUseThisSpace(String username, String password){

        //1 Users are on the homepage
        VytrackUtils.login(username, password);
        BrowserUtils.sleep(2);

        //2 Click the Learn how to use this space message
        WebElement learnHowToUseThisSpace = Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space']"));
        learnHowToUseThisSpace.click();
        BrowserUtils.sleep(2);

        //3 Verify the users see 2 messages:
        WebElement HowToUsePinbar= Driver.getDriver().findElement(By.xpath("//h3[.='How To Use Pinbar']"));
        String actualMessage1 = HowToUsePinbar.getText();
        System.out.println("actualMessage1 = " + actualMessage1);

        String expectedMessage1 = "How To Use Pinbar";
        System.out.println("expectedMessage1 = " + expectedMessage1);

        Assert.assertEquals(actualMessage1,expectedMessage1);

        // i need help with this locator
        WebElement UsePinIcon = Driver.getDriver().findElement(By.xpath("(//div[@class='clearfix'])[2]//p[1]"));
        String actualMessage2 = UsePinIcon.getText();
        System.out.println("actualMessage2 = " + actualMessage2);

        //Use pin icon on the right top corner of page to create fast access link in the pinbar.
        String expectedMessage2 = "Use pin icon on the right top corner of page to create fast access link in the pinbar.";
        System.out.println("expectedMessage2 = " + expectedMessage2);
        Assert.assertEquals(actualMessage2,expectedMessage2);

    }

    @Test(dataProvider = "LoginData")
    public void users_see_image_on_pinbar (String username, String password) {

        //1 Users are on the homepage
        VytrackUtils.login(username, password);
        BrowserUtils.sleep(2);

        //2 Click the Learn how to use this space message
        WebElement learnHowToUseThisSpace = Driver.getDriver().findElement(By.xpath("//a[.='Learn how to use this space']"));
        learnHowToUseThisSpace.click();
        BrowserUtils.sleep(2);

        //3 Verify users see an image(automation testing - verify image source)

        WebElement actualImage = Driver.getDriver().findElement(By.cssSelector("img[src='/bundles/oronavigation/images/pinbar-location.jpg']"));
        String expectedSrc = "/bundles/oronavigation/images/pinbar-location.jpg";
        String actualSrc = actualImage.getAttribute("src");
        Assert.assertTrue(actualSrc.contains(expectedSrc));
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }
}
