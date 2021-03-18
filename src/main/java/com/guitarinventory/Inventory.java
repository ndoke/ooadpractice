package com.guitarinventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Guitar> guitarCatalogue;

    public void addGuitar(String serialNumber, double price, Builder builder, String model, Type type, Wood backWood,
                          Wood topWood, int numberOfStrings) {
        GuitarSpec guitarSpec = new GuitarSpec(builder, model, type, backWood, topWood, numberOfStrings);
        Guitar guitar = new Guitar(serialNumber, price, guitarSpec);
        guitar.setGuitarSpec(guitarSpec);
        if (guitarCatalogue == null) {
            guitarCatalogue = new ArrayList<>();
        }
        guitarCatalogue.add(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        for (Guitar guitar : guitarCatalogue) {
            if (guitar.getSerialNumber().equalsIgnoreCase(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

    public List<Guitar> search(GuitarSpec guitarSpec) {
        List<Guitar> guitarsMatchingSerachCriteria = new ArrayList<>();
        for (Guitar g : guitarCatalogue) {
            if (guitarFound(g, guitarSpec)) {
                guitarsMatchingSerachCriteria.add(g);
            }
        }
        return guitarsMatchingSerachCriteria;
    }

    private boolean guitarFound(Guitar availableGuitar, GuitarSpec requestedSpec) {
        GuitarSpec availableGuitarSpec = availableGuitar.getGuitarSpec();
        return availableGuitarSpec.getBackWood() == requestedSpec.getBackWood() ||
                availableGuitarSpec.getBuilder() == requestedSpec.getBuilder() ||
                availableGuitarSpec.getModel().equalsIgnoreCase(requestedSpec.getModel()) ||
                availableGuitarSpec.getTopWood() == requestedSpec.getTopWood() ||
                availableGuitarSpec.getType() == requestedSpec.getType();
    }
}
