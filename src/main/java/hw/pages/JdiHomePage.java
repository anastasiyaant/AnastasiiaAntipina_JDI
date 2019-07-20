package hw.pages;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Label;
import hw.entities.Users;
import hw.enums.Menu;
import hw.forms.JdiLoginForm;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;


public class JdiHomePage extends WebPage {

    private JdiLoginForm loginForm;

    @Css("#user-name")
    private Label userName;

    @Css(".profile-photo")
    private Button profilePhoto;

    @XPath("//*[@class='uui-navigation nav navbar-nav m-l8']")
    private UIElement headerMenu;

    public void login(Users user) {
        profilePhoto.click();
        loginForm.login(user);
    }

    public void checkLoggedin(Users user) {
        userName.shouldBe().text(Matchers.equalTo(user.getFullName()));
    }


    public void clickHeaderButton(Menu name) {
        headerMenu.find(By.xpath("//a[contains(text(), '" + name.getName() + "')]")).click();
    }


}