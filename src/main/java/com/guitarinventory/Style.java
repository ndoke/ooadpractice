package com.guitarinventory;

public enum Style {
    A, F;

    public String toString() {
        switch (this) {
            case A:
                return "A";
            case F:
                return "F";
        }
        return null;
    }
}
