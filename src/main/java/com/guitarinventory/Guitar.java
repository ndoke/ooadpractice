package com.guitarinventory;

public class Guitar extends Instrument {
    Guitar(String serialNumber, double price, GuitarSpec guitarSpec) {
        super(serialNumber, price, guitarSpec);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public GuitarSpec getInstrumentSpec() {
        return (GuitarSpec) instrumentSpec;
    }

    @Override
    public String toString() {
        return "Guitar{" +
            "serialNumber='" + serialNumber + '\'' +
            ", price=" + price +
            ", guitarSpec=" + instrumentSpec +
            '}';
    }
}
