package hw7;

import com.epam.jdi.light.driver.get.DriverData;
import hw7.entities.Data;
import hw7.entities.Users;
import hw7.enums.Menu;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;

public class JdiTest {
    @BeforeClass
    public void beforeClass() {
        DriverData.CHROME_OPTIONS = () -> {
            ChromeOptions cap = new ChromeOptions();
            cap.addArguments("--start-maximized");
            return cap;
        };
        initElements(JdiSite.class);
    }

    @Test
    public void metalAndColorsPageTest() {
        JdiSite.open();
        JdiSite.homePage.login(Users.PETER);
        JdiSite.homePage.checkLoggedin(Users.PETER);
        JdiSite.homePage.clickHeaderButton(Menu.METALS_AND_COLORS);
        JdiSite.metalAndColorsPage.isOpened();
        JdiSite.metalAndColorsPage.selectValues(Data.DATA1);
        JdiSite.metalAndColorsPage.submitForm();
        JdiSite.metalAndColorsPage.checkValues(Data.DATA1);
    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }
}