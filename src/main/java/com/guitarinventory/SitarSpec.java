package com.guitarinventory;

public class SitarSpec extends InstrumentSpec {
    private Sound sound;

    SitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood, Sound sound) {
        super(builder, model, type, backWood, topWood);
        this.sound = sound;
    }

    Sound getSound() {
        return sound;
    }

    public boolean matches(InstrumentSpec otherSpec) {
        if (!super.matches(otherSpec)) {
            return false;
        }
        if (!(otherSpec instanceof MandolinSpec)) {
            return false;
        }
        SitarSpec otherMandolinSpec = (SitarSpec) otherSpec;
        if (sound != otherMandolinSpec.getSound()) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "MandolinSpec{" +
            "sound=" + sound +
            '}';
    }
}
