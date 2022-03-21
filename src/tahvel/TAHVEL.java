/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahvel;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Jegor Bakunin
 */

public class TAHVEL {
    
    private static WebDriver driver = null;
    
    public static void main(String[] args) throws InterruptedException {
//        
//        char passwordArray[] = System.console().readPassword("Enter password: ");
        Scanner input = new Scanner(System.in);
        System.out.println("Введите личный код:");
        String pass = input.nextLine();


        
        System.setProperty
            (
                "webdriver.chrome.driver",
                "C:\\Users\\User\\Desktop\\chromedriver.exe"
            );
        driver = new ChromeDriver();
        driver.get
            (
                "https://tahvel.edu.ee/"
            );
        driver.manage().window().maximize();
        
        JavascriptExecutor js = (JavascriptExecutor) driver;  
        
        
        // Открывает логин через SMART-ID 
        driver.findElement
            (
                By.className
                    (
                        "user-section"
                    )
            ).click();
        Thread.sleep
            (
                1000
            );
        driver.findElement
            (
                By.xpath
                    (
                        "/html/body/div[3]/md-dialog/md-dialog-content/div/div/div/div[1]/button[2]"
                    )
            ).click();
        Thread.sleep
            (
                1000
            );
        driver.findElement
            (
                By.xpath
                    (
                        "/html/body/div[3]/md-dialog/md-dialog-content/div/md-content[4]/a"
                    )
            ).click();
        Thread.sleep
            (
                1000
            );
        driver.findElement(By.xpath("/html/body/div/div/div[3]/div[2]/nav/ul/li[3]/a/span")).click();
        Thread.sleep
            (
                1000
            );
        driver.findElement
            (
                By.xpath
                    (
                        "/html/body/div/div/div[3]/div[2]/main/div[3]/div/div[1]/div[2]/form/table/tbody/tr[1]/td[2]/div[1]/input"
                    )
            ).click();
        Thread.sleep
            (
                1000
            );
        // Вводит личный код и используая скрипт для шифврования его от лишних глаз
        WebElement password = driver.findElement
            (
                By.xpath
                    (
                        "/html/body/div/div/div[3]/div[2]/main/div[3]/div/div[1]/div[2]/form/table/tbody/tr[1]/td[2]/div[1]/input"
                    )
            );
        
        js.executeScript
            (
                    "document.getElementById('sid-personal-code').type='password';"
                    + " console.log('check')"
            );
        password.sendKeys
            (
                pass
            );
        
        
        driver.findElement
            (
                By.xpath
                    (
                        "/html/body/div/div/div[3]/div[2]/main/div[3]/div/div[1]/div[2]/form/table/tbody/tr[2]/td[2]/button"
                    )
            ).click();
        
        // Открывает дневника
//        WebDriverWait w = new WebDriverWait(driver,3);
//        w.until(ExpectedConditions.presenceOfElementLocated (By.xpath("/html/body/div/div/div[3]/div[2]/main/div[3]/div/div[1]/div[2]/form/table/tbody/tr[2]/td[2]/button")));
        Thread.sleep
            (
                15000
            );
        driver.navigate().to
            (
                "https://tahvel.edu.ee/#/students/journals"
            );   
                Thread.sleep
            (
                15000
            );
        driver.quit();
        
    }
    
}
