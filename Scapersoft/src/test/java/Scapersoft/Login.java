package Scapersoft;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open website
        driver.get("https://app.scapersoft.com/signin");
        Thread.sleep(1500);

        // *******************************
        // TEST 1: Incorrect Password
        // *******************************
        System.out.println("===== Test 1: Incorrect Password =====");

        driver.findElement(By.name("email")).sendKeys("omkar.patil@iwcts.com");
        Thread.sleep(500);

        driver.findElement(By.name("password")).sendKeys("P@assword12"); // wrong password
        Thread.sleep(500);

        driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
        Thread.sleep(2000);

        System.out.println("Incorrect password flow - Passed");

        // Refresh for next test
        driver.navigate().refresh();
        Thread.sleep(2000);

        // *******************************
        // TEST 2: Account Not Found
        // *******************************
        System.out.println("===== Test 2: Account Not Found =====");

        driver.findElement(By.name("email")).sendKeys("omkar.patsssil@iwcts.com");
        Thread.sleep(500);

        driver.findElement(By.name("password")).sendKeys("P@assword12");
        Thread.sleep(500);

        driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
        Thread.sleep(2000);

     // Get error message
        String errorText = driver.findElement(By.xpath("//span[@class='error_text ']")).getText();
        System.out.println("Error Message: " + errorText);

        System.out.println("Account not found flow - Passed");
        
     // Refresh for next test
        driver.navigate().refresh();
        Thread.sleep(2000);
        
        System.out.println("===== Test 3: Valid Login ====");
  
         driver.findElement(By.name("email")).sendKeys("omkar.patil@iwcts.com");//*[@name="employee_name"]
         Thread.sleep(1000);
		    
         driver.findElement(By.name("password")).sendKeys("P@assword123");
         Thread.sleep(1000);		    
  		 driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
  		 

         Thread.sleep(3000);
         System.out.println("Login Successful");

      // Close browser
      //   driver.quit();
         
        
    }
}