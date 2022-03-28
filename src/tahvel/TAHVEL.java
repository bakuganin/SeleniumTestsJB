package tahvel;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tahvel.FileChooser;

/**
 *
 * @author Jegor Bakunin
 */

public class TAHVEL {
    
    private static WebDriver driver = null;
    
    //Создание переменной, которая хранит путь к файлу с персональными кодами.
    final String THE_FILE  = "C:\\Users\\user\\Documents\\NetBeansProjects\\SPTVR19\\jegor bakunin\\SeleniumTestsJB\\personal codes.txt";
    
    public class Saver implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            try {
                FileWriter fileWriter = new FileWriter("personal codes.txt");
                fileWriter.write(text.getText());
                fileWriter.close();
            } catch(Exception ex) {ex.printStackTrace();}
        }
    }

    
    public class Restore implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("Saved.ser"));
                StringBuffer stringBuffer = new StringBuffer();
                String currentLine;

                while ((currentLine = bufferedReader.readLine()) != null) {
                    stringBuffer.append(currentLine);
                }

                bufferedReader.close();
                text.getText(stringBuffer.toString());

            } catch(Exception ex) {ex.printStackTrace();}
        }
    }
    
    //Создание графического интерфейса
    public static void run() {
        //Создание окна и установка заголовока
        JFrame frame = new JFrame("Tahvel Test v-0.0.1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        
        //Создание навигационного меню и его компонентов
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("FILE");
        JMenu help = new JMenu("Help");
        menuBar.add(file);
        menuBar.add(help);
        JMenuItem open = new JMenuItem("Open");
        JMenuItem saveAs = new JMenuItem("Save as");
        file.add(open);
        file.add(saveAs);
        
        //Создание панели в низу графического интерфейса
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Personal Code");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);
        //Список
        JList ta = new JList();
        
        //Событие для кнопки "Open"
        open.addActionListener(new ActionListener() 
        {
             public void actionPerformed(ActionEvent e) 
             {
                //Действие
                String absolutePath = FileChooser.main(null);
                System.out.println(absolutePath);
             }
        });
        //Событие для кнопки "Save As"
        saveAs.addActionListener(new ActionListener() 
        {
             public void actionPerformed(ActionEvent e) 
             {
                //Действие
                String absolutePath = FileChooser.main(null);
                System.out.println(absolutePath);
             }
        });
        
        
        //Добавление компонентов в навигационное меню 
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        
        //Разместим программу по центру
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
    public static void main(String[] args) throws InterruptedException {

        run();

  
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
