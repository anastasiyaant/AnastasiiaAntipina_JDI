package hw7.entities;

import hw7.enums.Colors;
import hw7.enums.Elements;
import hw7.enums.Metals;
import hw7.enums.Vegetables;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum Data {
    DATA1(Arrays.asList("3", "8"), Arrays.asList(Elements.WATER.getValue(), Elements.FIRE.getValue()),
            Arrays.asList(Colors.RED.getValue()), Arrays.asList(Metals.SELEN.getValue()),
            Arrays.asList(Vegetables.CUCUMBER.getValue(), Vegetables.TOMATO.getValue()));

    private final List<String> summary;
    private final List<String> elements;
    private final List<String> colors;
    private final List<String> metals;
    private final List<String> vegetables;
}
