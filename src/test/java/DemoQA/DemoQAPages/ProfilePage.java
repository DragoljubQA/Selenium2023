package DemoQA.DemoQAPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    public WebDriver driver;
    WebElement deleteButton;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDeleteButton() {
        return driver.findElement(By.id("delete-record-undefined"));
    }

    //--------------------------



}
