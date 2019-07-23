package hw.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.common.Button;
import hw.entities.MetalAndColorsFormFieldsValuesData;
import hw.forms.JdiLogsForm;
import hw.forms.JdiMetalAndColorsForm;

// TODO This is completely prohibited to use raw Selenium calls in PO methods.
//fixed
public class JdiMetalAndColorsPage extends WebPage {

    private JdiMetalAndColorsForm metalAndColorsForm;
    private JdiLogsForm logsForm;

    @UI("#submit-button")
    public static Button submitButton;

    public void submitForm() {
        submitButton.click();
    }

    public void selectValues(MetalAndColorsFormFieldsValuesData data) {
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
    // fixed.
    public void checkValues(MetalAndColorsFormFieldsValuesData expectedData) {
        logsForm.checkColor(expectedData);
        logsForm.checkElements(expectedData);
        logsForm.checkMetal(expectedData);
        logsForm.checkSummary(expectedData);
        logsForm.checkVegetables(expectedData);
    }
}
