package com.dogdoors;

public class Remote {
    private DogDoor door;

    Remote(DogDoor door) {
        this.door = door;
    }

    public void pressButton() {
        System.out.println("Pressing remote control button..");
        if (door.isOpen()) {
            door.close();
        } else {
            door.open();
        }
    }

    public void pressLock() {
        if (!door.isLocked()) {
            door.lockDoor();
        } else {
            door.unlockDoor();
        }
    }
}
