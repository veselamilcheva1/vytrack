package com.vytrack.test;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.testng.annotations.Test;

public class US_53_Edit_Car_Info_Icons_Margie {

 @Test
 public void hovering(){

  //go to  https://qa2.vytrack.com/user/login
  Driver.getDriver().get(ConfigurationReader.getProperty("user.login.url"));

  //click the Vehicle under the Fleet
 }
}
