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
// TODO You should not name classes like just a "Data".
// It will be better to name it with relation to its purpose.
public class Data {
    // TODO Pay attention on code convention and maximum line length.
    public static Data DATA1 = new Data(Arrays.asList("3", "8"), Arrays.asList(Elements.WATER.getValue(), Elements.FIRE.getValue()),
            Colors.RED.getValue(), Metals.SELEN.getValue(),
            Arrays.asList(Vegetables.CUCUMBER.getValue(), Vegetables.TOMATO.getValue()));

    private final List<String> summary;
    private final List<String> elements;
    private final String color;
    private final String metals;
    private final List<String> vegetables;
}
