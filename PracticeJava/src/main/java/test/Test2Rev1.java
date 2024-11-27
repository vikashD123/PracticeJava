package test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2Rev1 {

	@Test(enabled=false)
	public void testradio() {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		List<WebElement> value=driver.findElements(By.xpath("//input[@type='radio' and @name='lang']"));
		
		for(int i=0;i<value.size();i++) {
			
			WebElement tst=value.get(i);
			
			String text=tst.getAttribute("id");
			
			System.out.println(text);
			
			if(text.equalsIgnoreCase("C#")) {
				
				tst.click();
				
				break;
			}
		}
		
	}
	
	@Test(enabled=false)
	public void testcheckbox() {
		
		System.setProperty("webdriver.chrome.driver","./Pathdriver/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		List<WebElement>value=driver.findElements(By.xpath("//input[@type='checkbox' and @name='lang']"));
		
		for(int i=0;i<value.size();i++) {
			
			WebElement tst=value.get(i);
			
			String text=tst.getAttribute("id");
			
			System.out.println(text);
			
			if(text.equalsIgnoreCase("Code")) {
				
				tst.click();
			}
		}
	}
	
	@Test(enabled=false)
	public void testDrop1() {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		Select daydrp=new Select(driver.findElement(By.id("day")));
		
		System.out.println("before selecting day------"+daydrp.getFirstSelectedOption().getText());
		
		daydrp.selectByIndex(3);
		
		System.out.println("after selecting day-------"+daydrp.getFirstSelectedOption().getText());
		
		Select monthdrp=new Select(driver.findElement(By.id("month")));
		
		System.out.println("before selecting month----"+monthdrp.getFirstSelectedOption().getText());
		
		monthdrp.selectByValue("8");
		
		System.out.println("after selecting month--------"+monthdrp.getFirstSelectedOption().getText());
		
		Select yeardrp=new Select(driver.findElement(By.id("year")));
		
		System.out.println("before selecting year------"+yeardrp.getFirstSelectedOption().getText());
		
		yeardrp.selectByVisibleText("2000");
		
		System.out.println("after selecting year------"+yeardrp.getFirstSelectedOption().getText());	
		
	}
	
	@Test(enabled=false)
	public void testdrop2() {
		
        WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.cssSelector("a[id*=u_0_0_]")).click();
		
		Select drp=new Select(driver.findElement(By.id("month")));
		
		List<WebElement> val=drp.getOptions();
		
		int count=val.size();
		
		System.out.println("total value====="+count);
		
		for(int i=0;i<count;i++) {
			
			WebElement drpval=val.get(i);
			
			String text=drpval.getText();
			
			System.out.println(text);
			
			if(text.equalsIgnoreCase("Aug")) {
				
				drpval.click();
				
				break;
			}
		}
		
	}
	@Test(enabled=false)
	public void testdrp3() {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		
		driver.findElement(By.cssSelector("[id='menu1']")).click();
		
		List<WebElement>val=driver.findElements(By.xpath("//ul[@role='menu']//following-sibling::li//a"));
		
		for(int i=0;i<val.size();i++) {
			
			WebElement tst=val.get(i);
			
			String text=tst.getText();
			
			System.out.println(text);
			
			if(text.equalsIgnoreCase("Javascript")) {
				
				tst.click();
				
				break;
			}
		}
	}
	
	@Test(enabled=false)
	public void testverifyTitlewithScreen() {
		
        WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get("https://login.yahoo.com/");
		
		driver.findElement(By.name("signin")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username-error")));
		
		String actual=driver.findElement(By.id("username-error")).getText();
		
		System.out.println(actual);
		
		String expected="Sorry, we don't recognize this email.";
		
		Assert.assertEquals(actual,expected);
		
		System.out.println("title verified");
		
		Capture.screen(driver,"Yahooerror");
	}
	
	@Test(enabled=false)
	public void testTitle() {
		
        WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get("https://accounts.google.com/");
		
		String title=driver.getTitle();
		
		System.out.println(title);
		
		Assert.assertTrue(title.contains("Sign in"),"title did not verified");
		
		System.out.println("title verified");
	}
	
	@Test(enabled=false)
	public void testalert() {
		
        WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://ksrtc.in/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		WebElement val=driver.findElement(By.id("submitSearch"));
		
		Actions act=new Actions(driver);
		
	    act.moveToElement(val).click().build().perform();
		
		Alert slt=driver.switchTo().alert();
		
		System.out.println(slt.getText());
		
		slt.accept();
		
	}
	@Test(enabled=false)
	public void testframe() {
		
        WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("file:///C:/Users/Vikas/OneDrive/Desktop/vk.html");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		List<WebElement>value=driver.findElements(By.tagName("iframe"));
		
		System.out.println(value.size());
		
		driver.switchTo().frame("selenium");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("scrollBy(0,300)");
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.partialLinkText("Click here ")).click();
		
	     System.out.println(driver.getCurrentUrl());
	}
	@Test(enabled=false)
	public void testwindow1() {
		
		 WebDriverManager.chromedriver().setup();
			
			WebDriver driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.get("https://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			
			String parent=driver.getWindowHandle();
			
			System.out.println("parent window id ----"+parent);
			
			driver.findElement(By.xpath("//a[@href='http://www.yahoo.com']")).click();
			
			Set<String>handle=driver.getWindowHandles();
			
			for(String child:handle) {
				
				if(!parent.equalsIgnoreCase(child)) {
					
					driver.switchTo().window(child);
					
					System.out.println("child window id----"+child);
					
					driver.findElement(By.id("ybar-sbq")).sendKeys("facebook");
					
					driver.close();
				}
			}
		driver.switchTo().window(parent);
		
		System.out.println(driver.getTitle());
		
		driver.quit();
	}
	@Test(enabled=false)
	public void testwindow2() {
		 WebDriverManager.chromedriver().setup();
			
		 WebDriver driver=new ChromeDriver();
			
		 driver.manage().window().maximize();
		 
		 driver.get("https://www.webroot.com/services/popuptester1.htm");
		 
		 String parent=driver.getWindowHandle();
		 
		 System.out.println("parent window id----"+parent);
		 
		 Set<String>handle=driver.getWindowHandles();
		 
		 for(String child:handle) {
			 
			 if(!parent.equalsIgnoreCase(child)) {
				 
				 driver.switchTo().window(child);
				 
				 System.out.println("child window id-----"+child);
				 
				 driver.close();
			 }
		 }
		 driver.switchTo().window(parent);
		 
		 System.out.println(driver.getTitle());
		 
		 driver.quit();
		 		 
	}
	@Test(enabled=false)
	public void testbootStrapLogin() {
		
		WebDriverManager.chromedriver().setup();
		
		 WebDriver driver=new ChromeDriver();
			
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
		 driver.get("https://seleniumpractise.blogspot.com/2016/11/handle-bootstrap-model-dialog-in.html");
		 
		 driver.findElement(By.xpath("//button[text()='Click here to Login']")).click();
		 
		 driver.findElement(By.xpath("//p[text()='This is a large modal.']//following::input[@type='text']")).sendKeys("Vikash");
		 
		 //driver.findElement(By.xpath("//button[text()='Close']")).click();
	}
	@Test(enabled=false)
	public void testexplicitwait() {
		
		WebDriverManager.chromedriver().setup();
		
		 WebDriver driver=new ChromeDriver();
			
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
		 driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		 
		 driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		 
		 WebElement val=driver.findElement(By.xpath("//p[text()='QTP']"));
		 
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		 
		 wait.until(ExpectedConditions.visibilityOf(val));
		 
		 if(val.isDisplayed()) {
		 
		 System.out.println("value is displayed");
	}
	else {
		System.out.println("value is not displayed");
	}
	}
	
	@Test(enabled=false)
	public void testActionRightClick() {
		
		WebDriverManager.chromedriver().setup();
		
		 WebDriver driver=new ChromeDriver();
			
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
		 driver.get("https://swisnl.github.io/jQuery-contextMenu/demo/accesskeys.html");
		 
		 WebElement val=driver.findElement(By.xpath("//span[text()='right click me']"));
		 
		 Actions act=new Actions(driver);
		 
		 act.contextClick(val).perform();
		 
		 driver.findElement(By.xpath("//span[text()='Quit']")).click();
		 
		 System.out.println(driver.switchTo().alert().getText());
		 
		 driver.switchTo().alert().accept();
			
	}
	@Test(enabled=false)
	public void testdoubleclick() {
		
		WebDriverManager.chromedriver().setup();
		
		 WebDriver driver=new ChromeDriver();
			
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
		driver.get("https://api.jquery.com/dblclick/");
		
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		
		WebElement val=driver.findElement(By.xpath("//span[text()='Double click the block']//preceding-sibling::div"));
		
		Actions act=new Actions(driver);
		
		act.doubleClick(val).perform();
		
	}
	
	@Test(enabled=false)
	public void testdraganddrop2() {
		
		WebDriverManager.chromedriver().setup();
		
		 WebDriver driver=new ChromeDriver();
			
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
		 driver.get("https://jqueryui.com/droppable/");
		 
		 driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		 
		 WebElement src=driver.findElement(By.id("draggable"));
		 
		 WebElement tgt=driver.findElement(By.cssSelector("#droppable"));
		 
		 Actions act=new Actions(driver);
		 
		 act.dragAndDrop(src, tgt).perform(); 
	}
	@Test(enabled=false)
	public void testdragable2() {
		
		WebDriverManager.chromedriver().setup();
		
		 WebDriver driver=new ChromeDriver();
			
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
		 driver.get("https://jqueryui.com/draggable/");
		 
		 driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		 
		 Actions act=new Actions(driver);
		 
		 act.dragAndDropBy(driver.findElement(By.id("draggable")),-40,20).perform();
		 
	}
	@Test
	public void testdrag3() {
		
		WebDriverManager.chromedriver().setup();
		
		 WebDriver driver=new ChromeDriver();
			
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
}
