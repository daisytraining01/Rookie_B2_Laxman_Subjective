package webtable;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

public class Wextraction {
    
    public static void main (String[] args) {
    	
    }
    @Before
	public void beforeScenario(){
		System.setProperty("webdriver.chrome.driver",
				"D://chromedriver.exe");



		driver = new ChromeDriver();
    }

        WebDriver driver;
    	@Given("^the user on the Webtable form$")
    	public void open_guru99() throws Throwable {
    		driver.navigate().to("https://cosmocode.io/automation-practice-webtable/");

       
    	
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='countries']")));
        driver.findElement(By.xpath("//table/tbody/tr[1]/td"));
        driver.findElements(By.xpath("//table[@id='countries']/tbody/tr"));}
        
        @When("^user can select the capital$")
    	public void enter_valid_data(DataTable table) throws Throwable {
        List<WebElement> lstRowWebelements = driver.findElements(By.xpath("//tbody/tr[10]"));
        List<WebElement> lstColWebelements = driver.findElements(By.xpath("//td[contains(text(),'Canberra')]"));
        
        
       
        
        int rowCount = lstRowWebelements.size();
        int colCount = lstColWebelements.size();
        int row = 0; 
        int col=0;
        boolean brkFlag = false;
        for(row = 0;row<rowCount;row++) {
            for(col=0; col<colCount;col++) {
                String values = driver.findElement(By.xpath("//table[@id='countries']/tbody/tr["+(row+1)+"]/td["+(col+1)+"]")).getText();
                System.out.println(driver.findElement(By.xpath("//table[@id='countries']/tbody/tr["+(row+1)+"]/td["+(col+1)+"]")).getText());
                if(values.contains("Belarus")) {
                WebElement radio1 = driver.findElement(By.id("//tbody/tr[17]/td[1]/input[1]"));								
                radio1.click();	
                System.out.println("Radio Button Option 1 Selected");{
                    brkFlag =true;
                    break;
                }
            }
            if(brkFlag)
                break;
        }
        System.out.println("Row"+row);
        System.out.println("Col"+col);
        System.out.println();
        row = row+1;
        col= col+1;
        System.out.println(driver.findElement(By.xpath("//table[@id='countries']/tbody/tr["+row+"]/td["+(col+1)+"]")).getText());
        
        
    }

 

}
 
}


   
   