package hw7.forms;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import hw7.entities.Data;
import hw7.enums.Vegetables;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JdiMetalAndColorsForm extends Form<Data> {
    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Droplist colorsDropdown;

    @XPath("//*[@id='elements-checklist']//label[contains(text(), '%s')]")
    private UIElement elementsElement;

    @JDropdown(root = "div[ui=combobox]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Droplist metalsDropdown;

    @JDropdown(root = "div[ui=droplist]",
            list = "li",
            expand = ".caret")
    private Droplist vegetablesDropdown;

    @FindBy(css = "#odds-selector > p")
    protected RadioButtons summaryOdd;
    @FindBy(css = "#even-selector > p")
    protected RadioButtons summaryEven;

    public void selectColors(List<String> colors) {
        for (String color : colors) {
            colorsDropdown.select(color);
        }
    }

    public void selectElements(List<String> elements) {
        for (String element : elements) {
            elementsElement.select(element);
        }
    }

    public void selectMetals(List<String> metals) {
        metalsDropdown.click();
        for (String metal : metals) {
            metalsDropdown.select(metal);
        }
    }

    public void selectSummary(List<String> summary) {
        summaryOdd.select(summary.get(0));
        summaryEven.select(summary.get(1));
    }

    public void selectVegetables(List<String> vegetables) {
        vegetablesDropdown.select(Vegetables.VEGETABLES.getValue());
        for (String vegetable : vegetables) {
            vegetablesDropdown.select(vegetable);
        }
    }
}
