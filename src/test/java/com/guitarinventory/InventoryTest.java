package com.guitarinventory;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryTest {
    private Inventory inventory = new Inventory();

    @Test
    public void test() {
        /** Guitar test */
        Map<String, Object> props = new HashMap<>();
        props.put("instrumentType", InstrumentType.GUITAR);
        props.put("builder", Builder.COLLINGS);
        props.put("model", "mod1");
        props.put("type", Type.ELECTRIC);
        props.put("backWood", Wood.BRAZILIAN_ROSEWOOD);
        props.put("topWood", Wood.ALDER);
        props.put("numberOfStrings", 12);
        inventory.addInstrument("gr_101", 100, new InstrumentSpec(props));

        props = new HashMap<>();
        props.put("instrumentType", InstrumentType.GUITAR);
        props.put("builder", Builder.FENDER);
        props.put("model", "mod2");
        props.put("type", Type.ACOUSTIC);
        props.put("backWood", Wood.CEDAR);
        props.put("topWood", Wood.MAPLE);
        props.put("numberOfStrings", 7);
        inventory.addInstrument("gr_102", 225, new InstrumentSpec(props));

        props = new HashMap<>();
        props.put("instrumentType", InstrumentType.GUITAR);
        props.put("builder", Builder.COLLINGS);
        props.put("model", "mod1");
        props.put("type", Type.ELECTRIC);
        props.put("backWood", Wood.BRAZILIAN_ROSEWOOD);
        props.put("topWood", Wood.ALDER);
        props.put("numberOfStrings", 7);
        inventory.addInstrument("gr_103", 100, new InstrumentSpec(props));

        props = new HashMap<>();
        props.put("instrumentType", InstrumentType.GUITAR);
        props.put("builder", Builder.COLLINGS);
        props.put("model", "mod1");
        props.put("type", Type.ELECTRIC);
        props.put("backWood", Wood.BRAZILIAN_ROSEWOOD);
        props.put("topWood", Wood.ALDER);
        props.put("numberOfStrings", 7);
        inventory.addInstrument("gr_104", 100, new InstrumentSpec(props));

        props = new HashMap<>();
        props.put("instrumentType", InstrumentType.GUITAR);
        props.put("builder", Builder.FENDER);
        props.put("model", "mod1");
        props.put("type", Type.ELECTRIC);
        props.put("backWood", Wood.BRAZILIAN_ROSEWOOD);
        props.put("topWood", Wood.ALDER);
        props.put("numberOfStrings", 12);
        InstrumentSpec guitarSpec = new InstrumentSpec(props);

        List<Instrument> matchingGuitars = inventory.search(guitarSpec);
        Assert.assertEquals(matchingGuitars.size(), 4);
        Assert.assertNull(inventory.get("gr_105"));
        Assert.assertEquals(inventory.get("gr_104").getInstrumentSpec().getProperty("backWood"),
            Wood.BRAZILIAN_ROSEWOOD);

        /** Mandolin test */
        props = new HashMap<>();
        props.put("instrumentType", InstrumentType.MANDOLIN);
        props.put("builder", Builder.FENDER);
        props.put("model", "mod1");
        props.put("type", Type.ACOUSTIC);
        props.put("backWood", Wood.BRAZILIAN_ROSEWOOD);
        props.put("topWood", Wood.ALDER);
        props.put("style", Style.A);
        inventory.addInstrument("mn_101", 1000, new InstrumentSpec(props));

        props = new HashMap<>();
        props.put("instrumentType", InstrumentType.MANDOLIN);
        props.put("builder", Builder.COLLINGS);
        props.put("model", "mod2");
        props.put("type", Type.ELECTRIC);
        props.put("backWood", Wood.INDIAN_ROSEWOOD);
        props.put("topWood", Wood.COCOBOLO);
        props.put("style", Style.F);
        inventory.addInstrument("mn_102", 2500, new InstrumentSpec(props));

        props = new HashMap<>();
        props.put("instrumentType", InstrumentType.MANDOLIN);
        props.put("builder", Builder.COLLINGS);
        props.put("model", "mod2");
        props.put("type", Type.ELECTRIC);
        props.put("backWood", Wood.INDIAN_ROSEWOOD);
        props.put("topWood", Wood.COCOBOLO);
        props.put("style", Style.F);
        InstrumentSpec mandolinSpec = new InstrumentSpec(props);
        List<Instrument> matchingMandolins = inventory.search(mandolinSpec);
        Assert.assertEquals(matchingMandolins.size(), 1);

        /** Sitar test */
        props = new HashMap<>();
        props.put("instrumentType", InstrumentType.SITAR);
        props.put("builder", Builder.FENDER);
        props.put("model", "mod2");
        props.put("type", Type.ACOUSTIC);
        props.put("backWood", Wood.BRAZILIAN_ROSEWOOD);
        props.put("topWood", Wood.ALDER);
        props.put("sound", Sound.HIGH);
        inventory.addInstrument("mn_101", 1000, new InstrumentSpec(props));

        props = new HashMap<>();
        props.put("instrumentType", InstrumentType.SITAR);
        props.put("builder", Builder.COLLINGS);
        props.put("model", "mod3");
        props.put("type", Type.ELECTRIC);
        props.put("backWood", Wood.INDIAN_ROSEWOOD);
        props.put("topWood", Wood.COCOBOLO);
        props.put("sound", Sound.MID);
        inventory.addInstrument("mn_102", 2500, new InstrumentSpec(props));

        props = new HashMap<>();
        props.put("instrumentType", InstrumentType.SITAR);
        props.put("builder", Builder.COLLINGS);
        props.put("model", "mod3");
        props.put("type", Type.ELECTRIC);
        props.put("backWood", Wood.INDIAN_ROSEWOOD);
        props.put("topWood", Wood.COCOBOLO);
        props.put("sound", Sound.MID);
        InstrumentSpec sitarSpec = new InstrumentSpec(props);
        List<Instrument> matchingSitars = inventory.search(sitarSpec);
        Assert.assertEquals(matchingSitars.size(), 1);
    }
}
