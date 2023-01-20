package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.google.com");
        driver.navigate().to("https://www.google.com");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://www.youtube.com");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.quit();


        //Zadatak 1
        //Pokrenite browser, idite na Linkedin sajt, uradite refresh, idite na Joberty sajt
        //vratite se nazad i odstampajte poslednji URL na kom se nalazite
        //na kraju zatvorite driver



    }
}
