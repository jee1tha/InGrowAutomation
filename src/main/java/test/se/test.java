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
	
	private static FirefoxDriver driver; // intializing firefoxdriver as a static variable so the tests can be run on the same window
	static WebElement element; // initializing webElement 
	
	public static void main(String[] args) {
        try{
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
	
	@Test
	
	public void test1Registration(){
		
		
		try {
			String FilePath = "RegisterInfo.xlt";
			FileInputStream fs;
			fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet("Sheet1"); // this is to get the access to Sheet1. 
			int r = sh.getRows();
			
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
			for(int s = 1; s<r; s++){
				
			
			String name = sh.getCell(0,s).getContents();
			String password = sh.getCell(1,s).getContents();
			String username = sh.getCell(2,s).getContents();
			String birthday = sh.getCell(3,s).getContents();
			String Nic = sh.getCell(4,s).getContents();
			String email = sh.getCell(5,s).getContents();
			String contact = sh.getCell(6,s).getContents();
			
			String skill1 = sh.getCell(7,s).getContents();
			String skill2 = sh.getCell(8,s).getContents();
			String skill3 = sh.getCell(9,s).getContents();
			String skill4 = sh.getCell(10,s).getContents();
			String skill5 = sh.getCell(11,s).getContents();
			String ExpCompany = sh.getCell(12,s).getContents();
			String ExpPost = sh.getCell(13,s).getContents();
			String ExpDuration = sh.getCell(14,s).getContents();
			String QuaInstitute = sh.getCell(15,s).getContents();
			String QUaName = sh.getCell(16,s).getContents();
			String QuaFinal = sh.getCell(17,s).getContents();
			
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
	try {
		Thread.sleep(500);
	} catch (Exception e) {
		// TODO: handle exception
	}
		Alert alert = driver.switchTo().alert();
		  alert.accept();
		  
		  		driver.get("http://localhost:8080/pl/login.jsp");
		        element = driver.findElement(By.id("txtUsername"));
				element.sendKeys(username);
				element = driver.findElement(By.id("txtPassword"));
		 		element.sendKeys(password);
		 	
				WebElement element10 = driver.findElement(By.xpath("//*[@type='submit']"));
				element10.click();
				
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				driver.get("http://localhost:8080/pl/jobs.jsp");
				WebElement element11 = driver.findElement(By.id("btnLogin"));
				element11.click();
				
				// Filling up skills
				
				WebElement element12 = driver.findElement(By.id("txtSkill1"));
				element12.sendKeys(skill1);
		        WebElement element13 = driver.findElement(By.id("txtSkill2"));
		        element13.sendKeys(skill2);
		        WebElement element14 = driver.findElement(By.id("txtSkill3"));
		        element14.sendKeys(skill3);
		        WebElement element15 = driver.findElement(By.id("txtSkill4"));
		        element15.sendKeys(skill4);
		        WebElement element16 = driver.findElement(By.id("txtSkill5"));
		        element16.sendKeys(skill5);
				
		    	// Filling up Experience information 
		        
				WebElement element17 = driver.findElement(By.id("txtOrganization"));
				element17.sendKeys(ExpCompany);
		        WebElement element18 = driver.findElement(By.id("txtPost"));
		        element18.sendKeys(ExpPost);
		        WebElement element19 = driver.findElement(By.id("txtDuration"));
		        element19.sendKeys(ExpDuration);
		        
		        // Filling up Qualifcation information 
		        
		        WebElement element20 = driver.findElement(By.id("txtInstitute"));
		        element20.sendKeys(QuaInstitute);
		        WebElement element21 = driver.findElement(By.id("txtQualification"));
		        element21.sendKeys(QUaName);
		        WebElement element22 = driver.findElement(By.id("txtClass"));
		        element22.sendKeys(QuaFinal);
		        
		        WebElement element23 = driver.findElement(By.id("btnSkills"));
		        element23.click();
		        
		        try {
		    		Thread.sleep(500);
		    	} catch (Exception e) {
		    		// TODO: handle exception
		    	}
				Alert alert4 = driver.switchTo().alert();
				alert4.accept();
				
			}
	
		
		String expResult = "http://localhost:8080/pl/index.jsp";
		String result = driver.getCurrentUrl();
	        assertEquals(expResult   , result);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
/*@Test
	
	public void test2Login(){
		
		driver.manage().window().maximize();
   
		
		
		test3logout();
		  String expResult = "http://localhost:8080/pl/index.jsp";
		  String result = driver.getCurrentUrl();
	        assertEquals(expResult, result);
	}

public void test3logout(){
	driver.findElement(By.cssSelector("a[href*='logout.jsp']")).click();
	 Alert alert = driver.switchTo().alert();
	  alert.accept();
	 Alert alert2 = driver.switchTo().alert();
	  alert.accept();
}*/

/*@Test

public void test3Applcation(){
	try {
		String FilePath = "RegisterInfo.xlt";
		FileInputStream fs;
		fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet("Sheet1"); // this is to get the access to Sheet1. 
		int r = sh.getRows();
		
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		for(int s = 0; s<r; s++){
			
		
		String name = sh.getCell(0,s).getContents();
		String password = sh.getCell(1,s).getContents();
		String username = sh.getCell(2,s).getContents();
		String birthday = sh.getCell(3,s).getContents();
		String Nic = sh.getCell(4,s).getContents();
		String email = sh.getCell(5,s).getContents();
		String contact = sh.getCell(6,s).getContents();
		
	
		
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
		}

	
	String expResult = "http://localhost:8080/pl/login.jsp";
	String result = driver.getCurrentUrl();
        assertEquals(expResult, result);
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}*/
}
