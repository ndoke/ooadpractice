package com.guitarinventory;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class InventoryTest {
    private Inventory inventory = new Inventory();

    @Test
    public void test() {
        inventory.addGuitar("sr_101", 100, Builder.COLLINGS, "mod1", Type.ELECTRIC,
                Wood.BRAZILIAN_ROSEWOOD, Wood.ALDER, 12);
        inventory.addGuitar("sr_102", 225, Builder.FENDER, "mod2", Type.ACOUSTIC,
                Wood.CEDAR, Wood.MAPLE, 7);
        inventory.addGuitar("sr_103", 100, Builder.COLLINGS, "mod1", Type.ELECTRIC,
                Wood.BRAZILIAN_ROSEWOOD, Wood.ALDER, 7);
        inventory.addGuitar("sr_104", 100, Builder.COLLINGS, "mod1", Type.ELECTRIC,
                Wood.BRAZILIAN_ROSEWOOD, Wood.ALDER, 7);

        GuitarSpec guitarSpec = new GuitarSpec(Builder.FENDER, "mod1", Type.ELECTRIC,
                Wood.BRAZILIAN_ROSEWOOD, Wood.ALDER, 12);
        List<Guitar> matchingGuitars = inventory.search(guitarSpec);
        Assert.assertEquals(matchingGuitars.size(), 4);
        Assert.assertNull(inventory.getGuitar("sr_105"));
    }
}
