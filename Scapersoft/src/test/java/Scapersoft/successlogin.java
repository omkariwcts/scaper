package Scapersoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class successlogin {

	public void success() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://app.scapersoft.com/signin");
        Thread.sleep(1500);
        
        driver.findElement(By.name("email")).sendKeys("omkar.patil@iwcts.com");//*[@name="employee_name"]
        Thread.sleep(1000);
		    
        driver.findElement(By.name("password")).sendKeys("P@assword123");
        Thread.sleep(1000);		    
 		 driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();

        Thread.sleep(3000);
        System.out.println("Login Successful");
	}

}
