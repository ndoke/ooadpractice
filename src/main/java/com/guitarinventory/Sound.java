package com.guitarinventory;

enum Sound {
    LOW, MID, HIGH;

    public String toString() {
        switch (this) {
            case LOW:
                return "LOW";
            case MID:
                return "MID";
            case HIGH:
                return "HIGH";
        }
        return null;
    }
}
