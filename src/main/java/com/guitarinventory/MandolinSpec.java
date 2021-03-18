package com.guitarinventory;

public class MandolinSpec extends InstrumentSpec {
    private Style style;

    MandolinSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood, Style style) {
        super(builder, model, type, backWood, topWood);
        this.style = style;
    }

    Style getStyle() {
        return style;
    }

    public boolean matches(InstrumentSpec otherSpec) {
        if (!super.matches(otherSpec)) {
            return false;
        }
        if (!(otherSpec instanceof MandolinSpec)) {
            return false;
        }
        MandolinSpec otherMandolinSpec = (MandolinSpec) otherSpec;
        if (style != otherMandolinSpec.getStyle()) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "MandolinSpec{" +
            "style=" + style +
            '}';
    }
}
