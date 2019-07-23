package hw.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.common.Label;
import com.epam.jdi.light.ui.html.common.Text;
import hw.entities.MetalAndColorsFormFieldsValuesData;
import org.hamcrest.Matchers;

public class JdiLogsForm extends Form<MetalAndColorsFormFieldsValuesData> {
    @FindBy(xpath = "//*[@class='summ-res']")
    private Label summaryLogRow;

    @FindBy(xpath = "//*[@class='elem-res']")
    private Text elementsLogRow;

    @FindBy(xpath = "//*[@class='col-res']")
    private Text colorLogRow;

    @FindBy(xpath = "//*[@class='met-res']")
    private Text metalLogRow;

    @FindBy(xpath = "//*[@class='sal-res']")
    private Text vegetablesLogRow;


    public void checkSummary(MetalAndColorsFormFieldsValuesData expectedValue) {
        int expectedSummary = Integer.parseInt(expectedValue.getSummary().get(0))
                + Integer.parseInt(expectedValue.getSummary().get(1));
        summaryLogRow.shouldBe().text(Matchers.containsString(String.valueOf(expectedSummary)));
    }

    public void checkElements(MetalAndColorsFormFieldsValuesData expectedValue) {
        for (String element : expectedValue.getElements()) {
            elementsLogRow.shouldBe().text(Matchers.containsString(element));
        }
    }

    public void checkColor(MetalAndColorsFormFieldsValuesData expectedValue) {
        colorLogRow.shouldBe().text(Matchers.containsString(expectedValue.getColor()));
    }

    public void checkMetal(MetalAndColorsFormFieldsValuesData expectedValue) {
        metalLogRow.shouldBe().text(Matchers.containsString(expectedValue.getMetals()));
    }

    public void checkVegetables(MetalAndColorsFormFieldsValuesData expectedValue) {
        for (String vegetable : expectedValue.getVegetables()) {
            vegetablesLogRow.shouldBe().text(Matchers.containsString(vegetable));
        }
    }
}
