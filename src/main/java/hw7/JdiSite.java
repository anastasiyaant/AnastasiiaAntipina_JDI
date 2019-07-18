package hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw7.pages.JdiHomePage;
import hw7.pages.JdiMetalAndColorsPage;

@JSite("https://epam.github.io/JDI/")
public class JdiSite {
    @Url("index.html")
    @Title("Home Page")
    public static JdiHomePage homePage;

    @Url("metals-colors.html")
    @Title("Metal and Colors")
    public static JdiMetalAndColorsPage metalAndColorsPage;

    public static void open() {
        homePage.open();
    }


}