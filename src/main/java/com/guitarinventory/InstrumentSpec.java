package com.guitarinventory;

abstract public class InstrumentSpec {
    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood;
    private Wood topWood;

    InstrumentSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    Builder getBuilder() {
        return builder;
    }

    String getModel() {
        return model;
    }

    Type getType() {
        return type;
    }

    Wood getBackWood() {
        return backWood;
    }

    Wood getTopWood() {
        return topWood;
    }

    public boolean matches(InstrumentSpec otherSpec) {
        if (builder != otherSpec.builder) {
            return false;
        }
        if (model != null && !model.equals("") && !model.equals(otherSpec.model)) {
            return false;
        }
        if (type != otherSpec.type) {
            return false;
        }
        if (backWood != otherSpec.backWood) {
            return false;
        }
        if (topWood != otherSpec.topWood) {
            return false;
        }

        return true;
    }
}
