/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahvel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Jegor Bakunin
 */

public class TAHVEL {
    
    private static WebDriver driver = null;
    
    public static void main(String[] args) throws InterruptedException {
//        
//        char passwordArray[] = System.console().readPassword("Enter password: ");
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://tahvel.edu.ee/");
        driver.manage().window().maximize();
        
        
        // Логин 
        driver.findElement(By.className("user-section")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/md-dialog/md-dialog-content/div/div/div/div[1]/button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/md-dialog/md-dialog-content/div/md-content[4]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/nav/ul/li[3]/a/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/main/div[3]/div/div[1]/div[2]/form/table/tbody/tr[1]/td[2]/div[1]/input")).click();
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/main/div[3]/div/div[1]/div[2]/form/table/tbody/tr[1]/td[2]/div[1]/input"));
        password.sendKeys("50201233737");
        
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/main/div[3]/div/div[1]/div[2]/form/table/tbody/tr[2]/td[2]/button")).click();
        
        // Открытие дневника
        Thread.sleep(25000);
        driver.navigate().to("https://tahvel.edu.ee/#/students/journals");   
        Thread.sleep(5000);
        driver.quit();
        
    }
    
}
