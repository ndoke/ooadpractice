package com.guitarinventory;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class InventoryTest {
    private Inventory inventory = new Inventory();

    @Test
    public void test() {
        inventory.addInstrument("gr_101", 100, new GuitarSpec(Builder.COLLINGS,
            "mod1", Type.ELECTRIC, Wood.BRAZILIAN_ROSEWOOD, Wood.ALDER, 12));
        inventory.addInstrument("gr_102", 225, new GuitarSpec(Builder.FENDER,
            "mod2", Type.ACOUSTIC, Wood.CEDAR, Wood.MAPLE, 7));
        inventory.addInstrument("gr_103", 100, new GuitarSpec(Builder.COLLINGS,
            "mod1", Type.ELECTRIC, Wood.BRAZILIAN_ROSEWOOD, Wood.ALDER, 7));
        inventory.addInstrument("gr_104", 100, new GuitarSpec(Builder.COLLINGS,
            "mod1", Type.ELECTRIC, Wood.BRAZILIAN_ROSEWOOD, Wood.ALDER, 7));

        GuitarSpec guitarSpec = new GuitarSpec(Builder.FENDER, "mod1", Type.ELECTRIC,
                Wood.BRAZILIAN_ROSEWOOD, Wood.ALDER, 12);
        List<Guitar> matchingGuitars = inventory.search(guitarSpec);
        Assert.assertEquals(matchingGuitars.size(), 4);
        Assert.assertNull(inventory.get("gr_105"));
        Assert.assertEquals(inventory.get("gr_104").getInstrumentSpec().getBackWood(),
            Wood.BRAZILIAN_ROSEWOOD);

        inventory.addInstrument("mn_101", 1000, new MandolinSpec(Builder.FENDER,
            "mod2", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.ALDER, Style.A));
        inventory.addInstrument("mn_102", 2500, new MandolinSpec(Builder.COLLINGS,
            "mod1", Type.ELECTRIC, Wood.INDIAN_ROSEWOOD, Wood.COCOBOLO, Style.F));

        MandolinSpec mandolinSpec = new MandolinSpec(Builder.COLLINGS,
            "mod1", Type.ELECTRIC, Wood.INDIAN_ROSEWOOD, Wood.COCOBOLO, Style.F);
        List<Mandolin> matchingMandolins = inventory.search(mandolinSpec);
        Assert.assertEquals(matchingMandolins.size(), 1);
    }
}
