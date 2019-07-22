package hw.pages;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.common.Button;
import hw.entities.Data;
import hw.enums.MetalAndColorsElements;
import hw.forms.JdiMetalAndColorsForm;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.core.StringContains.containsString;

// TODO This is completely prohibited to use raw Selenium calls in PO methods.
public class JdiMetalAndColorsPage extends WebPage {

    private JdiMetalAndColorsForm metalAndColorsForm;

    @UI("#submit-button")
    public static Button submitButton;

    @FindBy(css = "ul[class='panel-body-list results']")
    protected UIElement resultPanel;


    public void submitForm() {
        submitButton.click();
    }

    public void selectValues(Data data) {
        metalAndColorsForm.selectColors(data.getColor());
        metalAndColorsForm.selectElements(data.getElements());
        metalAndColorsForm.selectMetals(data.getMetals());
        metalAndColorsForm.selectSummary(data.getSummary());
        metalAndColorsForm.selectVegetables(data.getVegetables());
    }


    // TODO The certain sequence of log's rows doesn't matter in this case.
    // It will be easier to compare just two List<strings>
    // First list you can generate from MetalsAndColors instance
    // Second list can be generated from Log ui-element
    // TODO Pay attention on argument name.
    public void checkValues(Data data1) {
        if (data1.getSummary() != null) {
            int sum = 0;
            for (String summaryEx : data1.getSummary()) {
                sum += Integer.valueOf(summaryEx);
            }
            resultPanel.find(By.xpath(".//li[contains(string(),'" + MetalAndColorsElements.SUMMARY.getName() + "')]"))
                    .assertThat().text(containsString(String.valueOf(sum)));
        }

        if (data1.getElements() != null) {
            for (String element : data1.getElements()) {
                resultPanel.find(By.xpath(".//li[contains(string(),'" + MetalAndColorsElements.ELEMENTS.getName() + "')]"))
                        .assertThat().text(containsString(element));
            }
        }

        if (data1.getColor() != null) {
            resultPanel.find(By.xpath(".//li[contains(string(),'" + MetalAndColorsElements.COLOR.getName() + "')]"))
                    .assertThat().text(containsString(data1.getColor()));
        }

        if (data1.getMetals() != null) {
            resultPanel.find(By.xpath(".//li[contains(string(),'" + MetalAndColorsElements.METAL.getName() + "')]"))
                    .assertThat().text(containsString(data1.getMetals()));
        }

        if (data1.getVegetables() != null) {
            for (String vegetable : data1.getVegetables()) {
                resultPanel.find(By.xpath(".//li[contains(string(),'" + MetalAndColorsElements.VEGETABLES.getName() + "')]"))
                        .assertThat().text(containsString(vegetable));
            }
        }
    }
}
