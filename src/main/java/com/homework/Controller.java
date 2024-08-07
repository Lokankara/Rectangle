package com.homework;

import java.util.Collections;
import java.util.List;

public class Controller {
    public static void sorting(List<Bottle> bottles, String string) {
        switch (string) {
            case "material":
                bottles.sort(new Bottle.SortByMaterial());
                break;
            case "drink":
                bottles.sort(new Bottle.SortByDrink());
                break;
            case "volume":
                bottles.sort(new Bottle.SortByVolume());
                break;
            default:
                Collections.sort(bottles);
        }
    }
}
