package test.se;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.Sheet;
import jxl.Workbook;

public class test {
	static WebElement element; 
	//Initialize WebElement variable which included in Selenium package
	private static FirefoxDriver driver;
	public static void main(String[] args) {
        try{
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
	
	@Test
	
	public void test2(){
		
		
		try {
			String FilePath = "RegisterInfo.xlt";
			FileInputStream fs;
			fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet("Sheet1"); // this is to get the access to Sheet1. 
			String name = sh.getCell(0,0).getContents();
			String password = sh.getCell(1,0).getContents();
			String username = sh.getCell(2,0).getContents();
			String birthday = sh.getCell(3,0).getContents();
			String Nic = sh.getCell(4,0).getContents();
			String email = sh.getCell(5,0).getContents();
			String contact = sh.getCell(6,0).getContents();
			
		
			driver= new FirefoxDriver();
		driver.manage().window().maximize();
        driver.get("http://localhost:8080/pl/register.jsp");
        
        WebElement element1 = driver.findElement(By.id("txtUsername"));
        element1.sendKeys(username);
        WebElement element2 = driver.findElement(By.id("txtPassword"));
        element2.sendKeys(password);
        WebElement element3 = driver.findElement(By.id("txtPasswordConfirm"));
        element3.sendKeys(password);
        WebElement element4 = driver.findElement(By.id("txtName"));
        element4.sendKeys(name);
        WebElement element5 = driver.findElement(By.id("txtbday"));
        element5.sendKeys(birthday);
        WebElement element6 = driver.findElement(By.id("txtNICNo"));
        element6.sendKeys(Nic);
        WebElement element7 = driver.findElement(By.id("txtEmail"));
        element7.sendKeys(email);
        WebElement element8 = driver.findElement(By.id("txtContactNo"));
        element8.sendKeys(contact);
        
        
		WebElement element9 = driver.findElement(By.id("btnLogin"));
		element9.click();
		Alert alert = driver.switchTo().alert();
		                               alert.accept();
		String expResult = "http://localhost:8080/pl/login.jsp";
		String result = driver.getCurrentUrl();
	        assertEquals(expResult, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
@Test
	
	public void test3(){
		
		driver.manage().window().maximize();
        driver.get("http://localhost:8080/pl/login.jsp");
        element = driver.findElement(By.id("txtUsername"));
		element.sendKeys("master");
		element = driver.findElement(By.id("txtPassword"));
 		element.sendKeys("master");
		WebElement element2 = driver.findElement(By.xpath("//*[@type='submit']"));
		element2.click();
		
		  String expResult = "http://localhost:8080/pl/index.jsp";
		  String result = driver.getCurrentUrl();
	        assertEquals(expResult, result);
	}
}
