package org.flipkartProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.text.NumberFormatter;

import org.checkerframework.checker.units.qual.Length;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartIphoneTasks {

	public static void main(String[] args) throws AWTException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		// driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		WebElement searchBox = driver.findElement(By.name("q"));
		// driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		searchBox.sendKeys("i phone 14");
		//
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		List<WebElement> productList = driver.findElements(By.xpath("//div[@class='_4rR01T']"));

		List<WebElement> productPriceList = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		String productName;
		String productprices;
		int productPrice;
		List<Integer> prices = new ArrayList<Integer>();
		HashMap<Integer, String> hp = new HashMap<Integer, String>();

		for (int i = 0; i < productList.size(); i++) {
			productName = productList.get(i).getText();
			productprices = productPriceList.get(i).getText();
			productprices = productprices.substring(1, productprices.length());
			productprices = productprices.replace(",", "");

			int ib = Integer.parseInt(productprices);
			prices.add(ib);

			hp.put(ib, productName);

		}

		System.out.println(hp);

		System.out.println("all prices in low to high prices " + prices);

		System.out.println("maximum price of the searched i phones is " + Collections.max(prices));
		System.out.println("minimum price of the searched i phones is " + Collections.min(prices));

		// Collections.sort(prices);
		// Set<Integer> ai = hp.keySet();
		//
		// ArrayList<Integer>al=new ArrayList<Integer>(ai);
		// Collections.sort(al);
		// System.out.println(al);
		// Collections.sort(prices);
		//
		// Set<String> allvalues = hp.keySet();
		//
		// ArrayList<String>al=new ArrayList<String>(allvalues);
		//
		// Collections.sort(al);
		// System.out.println(al);
		// for (int i = 0; i < productList.size(); i++) {
		// productName=productList.get(i).getText();
		// productPrice = productPriceList.get(i).getText();
		// productPrice = productPrice.substring(1,productPrice.length());
		//
		// productPrice =productPrice.replace(",", "");
		//
		// int ic=Integer.parseInt(productPrice);
		// prices.add(ic);
		//
		//
		//// System.out.println(productPrice);
		// }
		//
		//
		// Collections.sort(prices);
		// Integer maxim = Collections.max(prices);
		//// System.out.println(productList);
		// System.out.println(prices);
		// System.out.println("maximum amount of price "+ maxim);
		// System.out.println("manimum amount of prices "+Collections.min(prices));
	}

}
