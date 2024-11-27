package test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Capture {

	
	
	public static void screen(WebDriver driver,String name) {
		
		try {
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src,new File("./Screen/"+" "+name+".png"));
		
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
}

