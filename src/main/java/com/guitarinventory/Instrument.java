package com.guitarinventory;

public class Instrument {
    String serialNumber;
    double price;
    InstrumentSpec instrumentSpec;

    Instrument(String serialNumber, double price, InstrumentSpec instrumentSpec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.instrumentSpec = instrumentSpec;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public InstrumentSpec getInstrumentSpec() {
        return instrumentSpec;
    }

    @Override
    public String toString() {
        return "Instrument{" +
            "serialNumber='" + serialNumber + '\'' +
            ", price=" + price +
            ", instrumentSpec=" + instrumentSpec +
            '}';
    }
}
