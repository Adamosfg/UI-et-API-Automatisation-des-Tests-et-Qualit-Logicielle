package com.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario3_Alerts {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.get("https://formy-project.herokuapp.com/switch-window");
            Thread.sleep(2000);
            
            driver.findElement(By.id("alert-button")).click();
        
            driver.switchTo().alert().accept();
            Thread.sleep(1000);

            driver.findElement(By.id("new-tab-button")).click();
            Thread.sleep(2000);
            
            System.out.println("✅ Scénario 3 PASS - Alertes et onglets gérés avec succès !");
            
        } catch (Exception e) {
            System.out.println("❌ Scénario 3 FAIL: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}