package com.guitarinventory;

public class Sitar extends Instrument {
    Sitar(String serialNumber, double price, InstrumentSpec instrumentSpec) {
        super(serialNumber, price, instrumentSpec);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public SitarSpec getInstrumentSpec() {
        return (SitarSpec) instrumentSpec;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
