package com.regresion.DemoBlaze;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.*; //com.regresion.DemoBlaze;
import java.util.*;

public class SetUp {
	
public WebDriver driver;
public Properties prop = new Properties(); 

@BeforeClass
public void Initialization() throws IOException
{
	driver = new ChromeDriver();
  FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Properties\\config.properties");
  prop.load(fis);
   
  String QAURL = prop.getProperty("QA_Url");
  driver.get(QAURL);
  
  driver.manage().window().maximize();
  System.out.println(driver.getCurrentUrl());
  
 

}
@AfterClass
public void CleanUp()
{
	//driver.quit();
	
}


}
