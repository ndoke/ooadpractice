package com.guitarinventory;

public class Mandolin extends Instrument {
    Mandolin(String serialNumber, double price, MandolinSpec mandolinSpec) {
        super(serialNumber, price, mandolinSpec);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public MandolinSpec getInstrumentSpec() {
        return (MandolinSpec) instrumentSpec;
    }

    @Override
    public String toString() {
        return "Mandolin{" +
            "serialNumber='" + serialNumber + '\'' +
            ", price=" + price +
            ", mandolinSpec=" + instrumentSpec +
            '}';
    }
}
