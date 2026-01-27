package com.webtablepractice.com;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTablePractice {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
		WebElement loc_WebTable=driver.findElement(By.xpath("//div[@class='site-content']"));
		List<WebElement> countries  = driver.findElements(
			    By.xpath("//table[@id='countries']/tbody/tr[position()>1]/td[2]//strong")
			);
		List<WebElement> checkBoxes   = driver.findElements(
			    By.xpath("//table[@id='countries']/tbody/tr[position()>1]/td[1]/input[@type='checkbox']")
			);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", loc_WebTable);
		 System.out.println("scrolling into down");
		for(int i=0;i<countries.size();i++)
		{
			String countryName=countries.get(i).getText();
			 WebElement checkBox=checkBoxes.get(i);
			 System.out.println(countryName);
			 if (countryName.equalsIgnoreCase("Belgium")) {
	                checkBox.click();
	                break;
	            }
			
		}

			
		}

	}


