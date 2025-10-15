package com.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario5_Navigation {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.get("https://formy-project.herokuapp.com/");
            driver.findElement(By.linkText("Components")).click();
            Thread.sleep(1000);
            driver.findElement(By.linkText("Form")).click();
            System.out.println("✅ Scénario 5 PASS - Navigation OK");
        } catch (Exception e) {
            System.out.println("❌ Scénario 5 FAIL: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}