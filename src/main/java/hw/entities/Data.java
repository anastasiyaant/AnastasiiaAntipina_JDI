package hw.entities;

import hw.enums.Colors;
import hw.enums.Elements;
import hw.enums.Metals;
import hw.enums.Vegetables;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public class Data {
    public static Data DATA1 = new Data(Arrays.asList("3", "8"), Arrays.asList(Elements.WATER.getValue(), Elements.FIRE.getValue()),
            Colors.RED.getValue(), Metals.SELEN.getValue(),
            Arrays.asList(Vegetables.CUCUMBER.getValue(), Vegetables.TOMATO.getValue()));

    private final List<String> summary;
    private final List<String> elements;
    private final String color;
    private final String metals;
    private final List<String> vegetables;
}