package weektest;
import java.io.File;
import java.util.List;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;



public class Registration {



	@Before
	public void beforeScenario(){
		System.setProperty("webdriver.chrome.driver",
				"D:/chromedriver.exe");



		driver = new ChromeDriver();
	} 
	WebDriver driver;
	@Given("^User in the registration form$")
	public void open_guru99() throws Throwable {
		driver.navigate().to("http://demo.guru99.com/test/newtours/register.php");



		System.out.println("Registration page of the application is opened.");
	}
	@When("^User enters required data$")
	public void enter_valid_data(DataTable table) throws Throwable {
		List<List<String>> data=table.raw();
		driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).sendKeys(data.get(1).get(1));
		driver.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]")).sendKeys(data.get(2).get(1));
		driver.findElement(By.xpath("//tbody/tr[4]/td[2]/input[1]")).sendKeys(data.get(3).get(1));
		driver.findElement(By.id("userName")).sendKeys(data.get(4).get(1));
		driver.findElement(By.xpath("//tbody/tr[7]/td[2]/input[1]")).sendKeys(data.get(5).get(1));
		driver.findElement(By.xpath("//tbody/tr[8]/td[2]/input[1]")).sendKeys(data.get(6).get(1));
		driver.findElement(By.xpath("//tbody/tr[9]/td[2]/input[1]")).sendKeys(data.get(7).get(1));
		driver.findElement(By.xpath("//tbody/tr[10]/td[2]/input[1]")).sendKeys(data.get(8).get(1));
		Select drpCountry = new Select(driver.findElement(By.xpath("//tbody/tr[11]/td[2]")));
		drpCountry.selectByVisibleText(data.get(9).get(1));
		driver.findElement(By.id("email")).sendKeys(data.get(6).get(1));
		driver.findElement(By.xpath("//tbody/tr[14]/td[2]/input[1]")).sendKeys(data.get(7).get(1));
		driver.findElement(By.xpath("//tbody/tr[15]/td[2]/input[1]")).sendKeys(data.get(8).get(1));



		driver.findElement(By.xpath("//tbody/tr[17]/td[1]/input[1]")).click();
		System.out.println("data entered in the application");



	}
	@Then("^Registration should be success$")
	public void successful_login() throws Throwable {
		driver.getTitle().contains("Title");
		System.out.println("Matching the title of the page after successful Registration.");
		boolean funcLogin ;
		if(driver.findElement(By.xpath("//tbody/tr[3]/td[1]/p[2]/font[1]")).isDisplayed())
		{
			funcLogin = true;
		}
		else {
			funcLogin = false;
		}
		if(funcLogin) {
			System.out.println("Successful Registration");
			TakesScreenshot ts =((TakesScreenshot)driver);
			File Src=ts.getScreenshotAs(OutputType.FILE);



			File Desti=new File("./target/Snaps/Regsuccess.png");



			FileUtils.copyFile(Src, Desti);




		}
		else {
			System.out.println("UnSuccessful Registration");
			TakesScreenshot ts =((TakesScreenshot)driver);
			File Src=ts.getScreenshotAs(OutputType.FILE);
			File Desti=new File("./target/Snaps/Regunsuccess.png");
			FileUtils.copyFile(Src, Desti);
		}




	}
	@After
	public void Close_the_browser() throws Throwable {



		driver.close();
		System.out.println("Closes the browser opened through selenium");



	}




}



