package com.guitarinventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Instrument> inventory;

    public void addInstrument(String serialNumber, double price, InstrumentSpec instrumentSpec) {
        if (instrumentSpec instanceof GuitarSpec) {
            GuitarSpec guitarSpec = (GuitarSpec) instrumentSpec;
            Guitar guitar = new Guitar(serialNumber, price, guitarSpec);
            if (inventory == null) {
                inventory = new ArrayList<>();
            }
            inventory.add(guitar);
        } else if (instrumentSpec instanceof MandolinSpec) {
            MandolinSpec mandolinSpec = (MandolinSpec) instrumentSpec;
            Mandolin mandolin = new Mandolin(serialNumber, price, mandolinSpec);
            if (inventory == null) {
                inventory = new ArrayList<>();
            }
            inventory.add(mandolin);
        }
    }

    public Instrument get(String serialNumber) {
        for (Instrument instrument : inventory) {
            if (instrument.getSerialNumber().equalsIgnoreCase(serialNumber)) {
                return instrument;
            }
        }
        return null;
    }

    public List<Guitar> search(GuitarSpec guitarSpec) {
        List<Guitar> guitarsMatchingSerachCriteria = new ArrayList<>();
        for (Instrument i : inventory) {
            if (i instanceof Guitar && guitarFound((Guitar) i, guitarSpec)) {
                guitarsMatchingSerachCriteria.add((Guitar) i);
            }
        }
        return guitarsMatchingSerachCriteria;
    }

    public List<Mandolin> search(MandolinSpec mandolinSpec) {
        List<Mandolin> mandolinsMatchingSerachCriteria = new ArrayList<>();
        for (Instrument i : inventory) {
            if (i instanceof Mandolin && mandolinFound((Mandolin) i, mandolinSpec)) {
                mandolinsMatchingSerachCriteria.add((Mandolin) i);
            }
        }
        return mandolinsMatchingSerachCriteria;
    }

    private boolean mandolinFound(Mandolin availableMandolin, MandolinSpec requestedMandolinSpec) {
        MandolinSpec availableMandolinSpec = availableMandolin.getInstrumentSpec();
        return availableMandolinSpec.getBackWood() == requestedMandolinSpec.getBackWood() ||
            availableMandolinSpec.getBuilder() == requestedMandolinSpec.getBuilder() ||
            availableMandolinSpec.getModel().equalsIgnoreCase(requestedMandolinSpec.getModel()) ||
            availableMandolinSpec.getTopWood() == requestedMandolinSpec.getTopWood() ||
            availableMandolinSpec.getStyle() == requestedMandolinSpec.getStyle() ||
            availableMandolinSpec.getType() == requestedMandolinSpec.getType();
    }

    private boolean guitarFound(Guitar availableGuitar, GuitarSpec requestedSpec) {
        GuitarSpec availableGuitarSpec = availableGuitar.getInstrumentSpec();
        return availableGuitarSpec.getBackWood() == requestedSpec.getBackWood() ||
            availableGuitarSpec.getBuilder() == requestedSpec.getBuilder() ||
            availableGuitarSpec.getModel().equalsIgnoreCase(requestedSpec.getModel()) ||
            availableGuitarSpec.getTopWood() == requestedSpec.getTopWood() ||
            availableGuitarSpec.getType() == requestedSpec.getType();
    }
}
