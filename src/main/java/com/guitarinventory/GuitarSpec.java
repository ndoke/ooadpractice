package com.guitarinventory;

public class GuitarSpec extends InstrumentSpec {
    private int numberOfStrings;

    GuitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood, int numberOfStrings) {
        super(builder, model, type, backWood, topWood);
        this.numberOfStrings = numberOfStrings;
    }

    int getNumberOfStrings() {
        return numberOfStrings;
    }

    public boolean matches(InstrumentSpec otherSpec) {
        if (!super.matches(otherSpec)) {
            return false;
        }
        if (!(otherSpec instanceof GuitarSpec)) {
            return false;
        }
        GuitarSpec otherGuitarSpec = (GuitarSpec) otherSpec;
        if (numberOfStrings != otherGuitarSpec.getNumberOfStrings()) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "GuitarSpec{" +
            "numberOfStrings=" + numberOfStrings +
            '}';
    }
}
