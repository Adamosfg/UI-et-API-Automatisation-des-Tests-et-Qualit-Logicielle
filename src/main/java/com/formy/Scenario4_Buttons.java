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
            
            // ✅ CORRECTION : Les VRAIS boutons sur la page Formy Buttons
            String[] buttonSelectors = {
                "//button[text()='Primary']",     // Primary button
                "//button[text()='Success']",     // Success button  
                "//button[text()='Info']",        // Info button
                "//button[text()='Warning']",     // Warning button
                "//button[text()='Danger']",      // Danger button
                "//button[text()='Left']",        // Left button
                "//button[text()='Middle']",      // Middle button  
                "//button[text()='Right']",       // Right button
                "//button[text()='1']",           // Button 1
                "//button[text()='2']",           // Button 2
                "//button[contains(@class, 'dropdown')]"  // Dropdown button
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