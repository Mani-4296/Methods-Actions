package com.facebook.account;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));
		WebElement create = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		create.click();
		WebElement fname = driver.findElement(By.xpath("//input[@placeholder='First name']"));
		fname.sendKeys("Mani V");
		WebElement sname = driver.findElement(By.xpath("//input[@name='lastname']"));
		sname.sendKeys("_kandan");
		WebElement email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		email.sendKeys("testusernew416@gmail.com");
		WebElement cnfrmemail = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		cnfrmemail.sendKeys("testusernew416@gmail.com");
		WebElement pswrd = driver.findElement(By.xpath("//input[@id='password_step_input']"));
		pswrd.sendKeys("Password@444");
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		Select dropdown = new Select(day);
		dropdown.selectByIndex(10);
		WebElement month = driver.findElement(By.id("month"));
		Select dropdown2 = new Select(month);
		dropdown2.selectByVisibleText("May");
		WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select dropdown3 = new Select(year);
		dropdown3.selectByValue("1985");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		WebElement gender = driver.findElement(By.xpath("(//span[@class='_5k_2 _5dba'])[2]"));
		gender.click();
		WebElement cta = driver.findElement(By.name("websubmit"));
		cta.click();
		System.out.println("All details are filled");
		//Unable to verify registration success as it requires user to enter code received through email
	}

}
