package com.dogdoors;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class DogDoorTest {
    private Remote remote;

    @Test
    public void test() throws InterruptedException {
        DogDoor dogDoor = new DogDoor();
        dogDoor.setAllowedBarks(Arrays.asList(Bark.GROWL, Bark.SHRIEK));
        remote = new Remote(dogDoor);

        Assert.assertFalse(dogDoor.isOpen());

        // open the door
        remote.pressButton();

        // dog goes out
        // dog comes back
        Thread.sleep(300);
        Assert.assertFalse(dogDoor.isOpen());

        // open door
        remote.pressButton();

        // dog goes out
        Thread.sleep(300);
        Assert.assertFalse(dogDoor.isOpen());
        // dog gets locked out
        // starts barking

        // open door
        remote.pressButton();

        Thread.sleep(300);
        Assert.assertFalse(dogDoor.isOpen());

        // press lock
        remote.pressLock();
        remote.pressButton();
        Assert.assertFalse(dogDoor.isOpen());

        // unlock door
        remote.pressLock();
        Assert.assertFalse(dogDoor.isOpen());

        dogDoor.scratchPaws();
        Assert.assertTrue(dogDoor.isOpen());
        remote.pressButton();
        Assert.assertFalse(dogDoor.isOpen());

        dogDoor.hearBark(Bark.GROWL);
        Assert.assertTrue(dogDoor.isOpen());
        Thread.sleep(300);
        Assert.assertFalse(dogDoor.isOpen());

        dogDoor.hearBark(Bark.SCREECH);
        Assert.assertFalse(dogDoor.isOpen());
    }
}
