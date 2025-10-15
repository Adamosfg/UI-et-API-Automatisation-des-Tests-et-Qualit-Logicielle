package com.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario4_Buttons {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.get("https://formy-project.herokuapp.com/buttons");
            Thread.sleep(2000);
            
            String[] buttonSelectors = {
                "//button[text()='Primary']",     
                "//button[text()='Success']",     
                "//button[text()='Info']",       
                "//button[text()='Warning']",     
                "//button[text()='Danger']",     
                "//button[text()='Left']",        
                "//button[text()='Middle']",       
                "//button[text()='Right']",       
                "//button[text()='1']",           
                "//button[text()='2']",           
                "//button[contains(@class, 'dropdown')]" 
            };
            
            for (String xpath : buttonSelectors) {
                driver.findElement(By.xpath(xpath)).click();
                Thread.sleep(300);
            }
            
            System.out.println("✅ Scénario 4 PASS - Tous les boutons fonctionnent !");
            
        } catch (Exception e) {
            System.out.println("❌ Scénario 4 FAIL: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}