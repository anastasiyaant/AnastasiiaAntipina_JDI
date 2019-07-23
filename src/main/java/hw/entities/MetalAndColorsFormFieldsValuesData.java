package hw.entities;

import hw.enums.Colors;
import hw.enums.Elements;
import hw.enums.Metals;
import hw.enums.Vegetables;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
// TODO You should not name classes like just a "Data".
// It will be better to name it with relation to its purpose.
// Fixed.
public class MetalAndColorsFormFieldsValuesData {
    // TODO Pay attention on code convention and maximum line length.
    // fixed
    public final static List<String> summaryHW1 = Arrays.asList("3", "8");
    public final static List<String> elementsHW1 = Arrays.asList(
            Elements.WATER.getValue(), Elements.FIRE.getValue());
    private final static String colorHW1 = Colors.RED.getValue();
    private final static String metalsHW1 = Metals.SELEN.getValue();
    private final static List<String> vegetablesHW1 = Arrays.asList(
            Vegetables.CUCUMBER.getValue(), Vegetables.TOMATO.getValue());
    public static MetalAndColorsFormFieldsValuesData HW1 =
            new MetalAndColorsFormFieldsValuesData(summaryHW1, elementsHW1,
                    colorHW1, metalsHW1, vegetablesHW1);

    private final List<String> summary;
    private final List<String> elements;
    private final String color;
    private final String metals;
    private final List<String> vegetables;
}
