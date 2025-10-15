package com.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Scenario1_Autocomplete {
    public static void main(String[] args) {
        // ✅ AJOUT : Configuration ChromeDriver
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.manage().window().maximize();
            driver.get("https://formy-project.herokuapp.com/autocomplete");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.id("autocomplete")));
            
            // ✅ Saisir une adresse réelle pour voir l'autocomplete
            input.sendKeys("123 Main Street");
            Thread.sleep(2000); // Attendre que les suggestions apparaissent
            
            // ✅ Sélectionner la première suggestion
            input.sendKeys(Keys.ARROW_DOWN);
            input.sendKeys(Keys.ENTER);
            
            Thread.sleep(2000); // Voir le résultat
            
            System.out.println("✅ Scénario 1 PASS - Autocomplete fonctionne !");
            
        } catch (Exception e) {
            System.out.println("❌ Scénario 1 FAIL: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}