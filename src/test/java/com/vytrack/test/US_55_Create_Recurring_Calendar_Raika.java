package com.vytrack.test;




import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utilities.Driver;
import utilities.VytrackUtils;


import javax.swing.*;

public class US_55_Create_Recurring_Calendar_Raika{

@Test
public void testCalendarDefault() throws InterruptedException {

    //Users are on the homepage
    VytrackUtils.loginAsSalesManager();
    Actions actions =new Actions(Driver.getDriver());


    //Click the “Calendar Events” under the Activities
    String activitiesTabElement = "//li[@class='dropdown dropdown-level-1'][4]";
    WebElement activitiesTab = Driver.getDriver().findElement(By.xpath(activitiesTabElement));
    actions.moveToElement(activitiesTab).perform();
    WebElement calendarEventsClick = Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']/../.."));
    calendarEventsClick.click();

    //Click the “Create Calendar Event” button
    Thread.sleep(3000);

    WebElement createCalendarEvent = Driver.getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
    createCalendarEvent.click();

    //Check the Repeat checkbox
    WebElement repeatCheckbox = Driver.getDriver().findElement(By.xpath("//input[@id='recurrence-repeat-view445']"));
    repeatCheckbox.click();

    //Verify the repeat number is 1
    WebElement repeatNumber = Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]"));

    Assert.assertTrue(repeatNumber.isDisplayed());
    Driver.closeDriver();

}

@Test
    public void verifying_error_message() throws InterruptedException {

    //Users are on the homepage
    VytrackUtils.loginAsSalesManager();
    Actions actions =new Actions(Driver.getDriver());

    //Click the “Calendar Events” under the Activities
    String activitiesTabElement = "//li[@class='dropdown dropdown-level-1'][4]";
    WebElement activitiesTab = Driver.getDriver().findElement(By.xpath(activitiesTabElement));
    actions.moveToElement(activitiesTab).perform();
    WebElement calendarEventsClick = Driver.getDriver().findElement(By.xpath("//span[.='Calendar Events']/../.."));
    calendarEventsClick.click();

    //Click the “Create Calendar Event” button
    Thread.sleep(3000);

    WebElement createCalendarEvent = Driver.getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
    createCalendarEvent.click();

    //Check the Repeat checkbox
    WebElement repeatCheckbox = Driver.getDriver().findElement(By.xpath("//input[@id='recurrence-repeat-view445']"));
    repeatCheckbox.click();

    //Clear(delete) the number 1
    Thread.sleep(3000);
    WebElement repeatNumber = Driver.getDriver().findElement(By.xpath("(//input[@class='recurrence-subview-control__number'])[1]"));
    repeatNumber.clear();

    //Verify the app displays “This value should not be blank.”

    WebElement errorMessage= Driver.getDriver().findElement(By.xpath("(//span[.='This value should not be blank.'])[3]"));
    Assert.assertTrue(errorMessage.isDisplayed());


}



}
