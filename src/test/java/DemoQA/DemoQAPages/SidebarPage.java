package DemoQA.DemoQAPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SidebarPage {
    public WebDriver driver;
    List<WebElement> buttons;

    public SidebarPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getButtons() {
        return driver.findElements(By.className("text"));
    }

    //-------------------------------

    public void clickOnButton(String name) {
        for (int i = 0; i < getButtons().size(); i++) {
            if (getButtons().get(i).getText().equals(name)) {
                getButtons().get(i).click();
                break;
            }
        }
    }

}
