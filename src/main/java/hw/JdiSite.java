package hw;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import hw.pages.JdiHomePage;
import hw.pages.JdiMetalAndColorsPage;
import org.openqa.selenium.support.FindBy;

@JSite("https://epam.github.io/JDI/")
public class JdiSite {

    @Css(".profile-photo")
    private static Button profilePhoto;
    @FindBy(css = ".logout")
    private static Button submit;

    @Url("index.html")
    @Title("Home Page")
    public static JdiHomePage homePage;

    @Url("metals-colors.html")
    @Title("Metal and Colors")
    public static JdiMetalAndColorsPage metalAndColorsPage;

    public static void open() {
        homePage.open();
    }


    public static void logout() {
        profilePhoto.click();
        submit.click();
    }


}