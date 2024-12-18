package E2ETesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC_005_DragDop {
	
	@Test
	public void DragDrop() {
		
		System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
		WebDriver driver =  new FirefoxDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement frame = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/iframe"));
		driver.switchTo().frame(frame);
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(source, destination).perform();
		driver.quit();
		
	}

}
