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
	
WebDriver driver;
Properties prop = new Properties(); 

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

@Test
public void Testmethod1() throws InterruptedException, IOException{
	  FileInputStream excel = new FileInputStream(System.getProperty("user.dir")+"\\Books.xlsx");
	  XSSFWorkbook wb = new XSSFWorkbook(excel); //Open Excel Sheet
	  XSSFSheet sheet = wb.getSheet("Demoblaze");	
	
	
	XSSFRow row = sheet.getRow(1);
	XSSFCell col = row.getCell(1);
	
	XSSFRow row2 = sheet.getRow(1);
	XSSFCell col2 = row2.getCell(1);
	
	String uName=col.getStringCellValue();
	String uPwd=col2.getStringCellValue();
	
	wb.close();
	
	 String navlogin= prop.getProperty("login2");
	 WebElement clickable = driver.findElement(By.id(navlogin));
	 Actions action = new Actions(driver);
	 action.click(clickable).perform();
	 //action.release();
	
	 Thread.sleep(3000);
	
	 String usr= prop.getProperty("usrName");
	 WebElement username=driver.findElement(By.id(usr));
	 username.sendKeys(uName);
	 
	 String usrpwd = prop.getProperty("pwd");
	 WebElement password=driver.findElement(By.id(usrpwd));
	 password.sendKeys(uPwd); 
	
	 String loginBtnClick = prop.getProperty("btnLogin");
	 WebElement login=driver.findElement(By.xpath(loginBtnClick));
	 action.click(login).perform();
	 //action.release();
	 
	 Thread.sleep(3000);
	 String imgHyperlinkClick = prop.getProperty("ctnHyperLink");
	 WebElement link = driver.findElement(By.linkText(imgHyperlinkClick));
	 link.click();
	 
	 Thread.sleep(3000);
	 String btnAddToCart = prop.getProperty("btnCart");
	 WebElement add2cart = driver.findElement(By.linkText(btnAddToCart));
	 add2cart.click();
	 //action.release();
	 
	Alert alert= driver.switchTo().alert();
	Thread.sleep(3000);
	alert.accept();
	

}

}
