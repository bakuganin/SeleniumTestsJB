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
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://tahvel.edu.ee/");
        driver.manage().window().maximize();
        
        driver.findElement(By.className("user-section")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href='https://tahvel.edu.ee/hois_back/haridLogin']")).click();
        
        driver.findElement(By.className("input-email-field")).sendKeys("kafder97@gmail.com");;
        Thread.sleep(1000);
        driver.findElement(By.className("input-field")).sendKeys("5051Pines");
        Thread.sleep(1000);
        
        driver.findElement(By.className("btn-primary")).click();
        //Select se = new Select(driver.findElement(By.xpath("//*[@class='add-btns-group']")));
        //se.selectByValue("Logi sisse");
//      driver.findElement(By.className("btn btn-primary ml-lg-3")).click();
        Thread.sleep(2000);
        driver.navigate().to("https://tahvel.edu.ee/#/students/journals");   
        Thread.sleep(5000);
        driver.quit();
        
    }
    
}
