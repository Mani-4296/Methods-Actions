package com.dragdrop.jquery;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));

		WebElement frm = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frm);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop);
		act.build().perform();
		// getting background color of the element after draganddrop
		String color = drop.getCssValue("background-color");
		System.out.println(color);

		if (color.equals("rgba(255, 250, 144, 1)")) {
			System.out.println("Drag and drop completed");
		} else {
			System.err.println("Drag and drop failed");
		}

		String txt = drop.getText();
		System.out.println(txt);

		if (txt.equalsIgnoreCase("Dropped!")) {
			System.out.println("Drag and drop operation perfomed and content changed");
		} else {
			System.err.println("Drag and drop opertation failed");
		}

	}

}
