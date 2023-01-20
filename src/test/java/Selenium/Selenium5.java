package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Selenium5 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://wordpress.com/");

        WebElement loginRedirect = driver.findElement(By.linkText("Log In"));
        loginRedirect.click();

        //Thread.sleep(3000);
        wdwait.until(ExpectedConditions.urlToBe("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F"));

        WebElement emailField = driver.findElement(By.id("usernameOrEmail"));
        String username = "dragoljubqa";
        emailField.sendKeys(username);

        WebElement continueButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        continueButton.click();

        //Thread.sleep(2000);
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("password"))));

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Swordfish123!@#");

        continueButton.click();

        //Thread.sleep(4000);
        wdwait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/dragoljubqa.wordpress.com"));

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

    }
}
