package DemoQA.DemoQATests;

import DemoQA.DemoQABase.DemoQABaseTest;
import DemoQA.DemoQAPages.HomePage;
import DemoQA.DemoQAPages.ProfilePage;
import DemoQA.DemoQAPages.SidebarPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoQABookstore extends DemoQABaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        homePage = new HomePage(driver);
        sidebarPage = new SidebarPage(driver);
        profilePage = new ProfilePage(driver);
    }

    public void logIn() {
        Cookie userID = new Cookie("userID", "362c8c84-7846-4bcd-9625-ef0df047ff54");
        Cookie username = new Cookie("userName", "dragoljubqa");
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImRyYWdvbGp1YnFhIiwicGFzc3dvcmQiOiJRd2VydHkxMjMhQCMiLCJpYXQiOjE2NzM5MDIxMTh9.ANWhSfME__ZjZkor8DsrtLeTsGaJLc0JnV80EIEQWeU");
        Cookie expires = new Cookie("expires", "2023-01-23T20%3A48%3A38.913Z");
        driver.manage().addCookie(userID);
        driver.manage().addCookie(username);
        driver.manage().addCookie(token);
        driver.manage().addCookie(expires);
        driver.navigate().refresh();
    }

    @Test
    public void test1() throws InterruptedException {
        scrollIntoView(homePage.getCards().get(5));
        homePage.clickOnBookstore();
        logIn();
        scrollIntoView(sidebarPage.getButtons().get(sidebarPage.getButtons().size()-1));
        sidebarPage.clickOnButton("Profile");
        Thread.sleep(2000);

        if (profilePage.getDeleteButton().isDisplayed()) {
            for (int i = 0; i < 1; i++) {

            }
        }

        //Assert.assertFalse(isDisplayed(profilePage.getDeleteButton()));
        boolean element = false;
        try {
            element = profilePage.getDeleteButton().isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(element);
        scrollIntoView(sidebarPage.getButtons().get(sidebarPage.getButtons().size()-1));
        sidebarPage.clickOnButton("Book Store");
    }
}
