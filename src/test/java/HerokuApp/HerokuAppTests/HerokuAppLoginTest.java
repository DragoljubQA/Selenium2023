package HerokuApp.HerokuAppTests;

import HerokuApp.HerokuAppBase.HerokuAppBaseTest;
import HerokuApp.HerokuAppPages.HerokuAppLoginPage;
import HerokuApp.HerokuAppPages.HerokuAppLogoutPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HerokuAppLoginTest extends HerokuAppBaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(LoginURL);
        herokuAppLoginPage = new HerokuAppLoginPage();
        herokuAppLogoutPage = new HerokuAppLogoutPage();
    }

    @Test (priority = 10)
    public void userCanLogIn() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);

        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLogoutPage.getNotificationText(), "You logged into a secure area!\n" + "×");
    }

}
