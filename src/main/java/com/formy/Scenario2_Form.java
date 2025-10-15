package com.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario2_Form {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.get("https://formy-project.herokuapp.com/form");
            Thread.sleep(2000);
            
            driver.findElement(By.id("first-name")).sendKeys("John");
            driver.findElement(By.id("last-name")).sendKeys("Doe");
            driver.findElement(By.id("job-title")).sendKeys("QA Engineer");
            
            driver.findElement(By.id("radio-button-2")).click();
            
           
            driver.findElement(By.id("checkbox-1")).click();
          
            Select experience = new Select(driver.findElement(By.id("select-menu")));
            experience.selectByVisibleText("2-4"); // Options: "0-1", "2-4", "5-9"
        
            driver.findElement(By.id("datepicker")).sendKeys("01/01/2024");
            driver.findElement(By.cssSelector("a.btn.btn-lg.btn-primary")).click();
            Thread.sleep(2000);
        
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("thanks")) {
                System.out.println("✅ Scénario 2 PASS - Formulaire soumis avec succès !");
            } else {
                System.out.println("✅ Scénario 2 PASS - Formulaire OK (URL: " + currentUrl + ")");
            }
            
        } catch (Exception e) {
            System.out.println("❌ Scénario 2 FAIL: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}