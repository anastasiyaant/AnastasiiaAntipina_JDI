package hw;

import com.epam.jdi.light.driver.get.DriverData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hw.entities.Data;
import hw.entities.Users;
import hw.enums.Menu;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;

public class JdiTest {
    private final static String DATA_PROVIDER_JSON_PATH = ".\\src\\test\\resources\\JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "fromJson")
    public Object[] getData() throws FileNotFoundException {
        BufferedReader root = new BufferedReader(new FileReader(DATA_PROVIDER_JSON_PATH));
        Map<String, Data> dataSets = new Gson().fromJson(root, new TypeToken<Map<String, Data>>() {
        }.getType());
        return dataSets.values().toArray();
    }


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
    public void metalAndColorsPageTestHomework1() {
        JdiSite.open();
        JdiSite.homePage.login(Users.PETER);
        JdiSite.homePage.checkLoggedin(Users.PETER);
        JdiSite.homePage.clickHeaderButton(Menu.METALS_AND_COLORS);
        JdiSite.metalAndColorsPage.isOpened();
        JdiSite.metalAndColorsPage.selectValues(Data.DATA1);
        JdiSite.metalAndColorsPage.submitForm();
        JdiSite.metalAndColorsPage.checkValues(Data.DATA1);
    }


    @Test(dataProvider = "fromJson")
    public void metalAndColorsPageTestHomework2(Data data) {
        JdiSite.open();
        JdiSite.homePage.login(Users.PETER);
        JdiSite.homePage.checkLoggedin(Users.PETER);
        JdiSite.homePage.clickHeaderButton(Menu.METALS_AND_COLORS);
        JdiSite.metalAndColorsPage.isOpened();
        JdiSite.metalAndColorsPage.selectValues(data);
        JdiSite.metalAndColorsPage.submitForm();
        JdiSite.metalAndColorsPage.checkValues(data);
    }

    @AfterMethod
    public void logout() {
        JdiSite.logout();
    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }
}