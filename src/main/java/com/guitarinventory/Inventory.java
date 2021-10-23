package com.guitarinventory;

import java.util.ArrayList;
import java.util.List;

class Inventory {
    private List<Instrument> inventory;

    void addInstrument(String serialNumber, double price, InstrumentSpec instrumentSpec) {
        Instrument guitar = new Instrument(serialNumber, price, instrumentSpec);
        if (inventory == null) {
            inventory = new ArrayList<>();
        }
        inventory.add(guitar);
    }

    Instrument get(String serialNumber) {
        for (Instrument instrument : inventory) {
            if (instrument.getSerialNumber().equalsIgnoreCase(serialNumber)) {
                return instrument;
            }
        }
        return null;
    }

    List<Instrument> search(InstrumentSpec instrumentSpec) {
        List<Instrument> instrumentsMatchingSerachCriteria = new ArrayList<>();
        for (Instrument i : inventory) {
            if (instrumentFound(i, instrumentSpec)) {
                instrumentsMatchingSerachCriteria.add(i);
            }
        }

        return instrumentsMatchingSerachCriteria;
    }

    private boolean instrumentFound(Instrument i, InstrumentSpec instrumentSpec) {
        return i.getInstrumentSpec().matches(instrumentSpec);
    }
}
