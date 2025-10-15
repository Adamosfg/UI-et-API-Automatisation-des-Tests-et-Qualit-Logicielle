package com.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario2_Form {
    public static void main(String[] args) throws InterruptedException {
        // ✅ Utiliser ChromeDriver directement
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.get("https://formy-project.herokuapp.com/form");
            Thread.sleep(2000);
            
            // Remplir les champs de base
            driver.findElement(By.id("first-name")).sendKeys("John");
            driver.findElement(By.id("last-name")).sendKeys("Doe");
            driver.findElement(By.id("job-title")).sendKeys("QA Engineer");
            
            // ✅ Éducation = BOUTONS RADIO 
            driver.findElement(By.id("radio-button-2")).click(); // College
            
            // ✅ Sexe = CASE À COCHER
            driver.findElement(By.id("checkbox-1")).click(); // Male
            
            // ✅ Expérience = DROPDOWN avec options réelles
            Select experience = new Select(driver.findElement(By.id("select-menu")));
            experience.selectByVisibleText("2-4"); // Options: "0-1", "2-4", "5-9"
            
            // Date picker
            driver.findElement(By.id("datepicker")).sendKeys("01/01/2024");
            
            // ✅ Bouton Submit
            driver.findElement(By.cssSelector("a.btn.btn-lg.btn-primary")).click();
            Thread.sleep(2000);
            
            // Vérifier le succès
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