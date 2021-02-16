package printconsole;


	import java.io.File;
	import java.io.IOException;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
   

	 

	public class printconsole {

	    public static void main(String[] args) throws InterruptedException, IOException {
	        File file = new File("drivers/chromedriver_new.exe");
	        String filePath = file.getAbsolutePath();
	        System.out.println(filePath);
	        
	        
	        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	        
	        ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.addArguments("start-maximized");
	        WebDriver driver =  new ChromeDriver(chromeOptions);
	        driver.navigate().to("https://wordpress.com/?aff=58022&cid=8348279");
	        
	        
	        
	          System.out.println("Products");
	          driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[2]/button[1]")).click(); //Clicking Sub Menu
	          Thread.sleep(2000);
	          
	          for (int a=1;a<=6;a++) {
	             
	           String Result = driver.findElement(By.xpath("//body/div[@id='lpc-header-nav']/div[1]/div[1]/div[2]/div[4]/ul[1]/li["+a+"]/a[1]")).getText();
	            System.out.println(Result);
	          }
	          System.out.println();
	          Thread.sleep(2000);
	          System.out.println("Features");
	          driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/button[1]")).click();
	          for (int c=1;c<=4;c++) {
	                 
	               String Result1 = driver.findElement(By.xpath("//body/div[@id='lpc-header-nav']/div[1]/div[1]/div[2]/div[5]/ul[2]/li["+c+"]/a[1]")).getText();
	                System.out.println(Result1);
	              }
	          System.out.println();
	          System.out.println("Resources");
	          
	          driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[4]/button[1]")).click();
	          Thread.sleep(2000);
	          for (int b=1;b<=7;b++) {
	                 
	               String Result1 = driver.findElement(By.xpath("//body/div[@id='lpc-header-nav']/div[1]/div[1]/div[2]/div[6]/ul[1]/li["+b+"]/a[1]")).getText();
	                System.out.println(Result1);
	              }
	         
	        
	        driver.close();
	        
	    }

	 

	}
	 

