import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {

	@Test(dataProvider= "getTestData")
	public void loginToApplication(String username, String password)
	{
		System.setProperty("webdriver.chrome.driver", "G:\\ChromeWebDriver\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@DataProvider
	public Object [][] getTestData()
	{
		Object [][] data= new Object [2][2];
		data [0][0]= "Admin";
		data [0][1]= "admin123";
		data [1][0]= "superAdmin";
		data [1][1]= "test@123";
		return data;
		
	}
}
