package com.dogdoors;

import java.util.*;

public class DogDoor {
    private boolean open;
    private boolean lock;
    private List<Bark> allowedBarks;

    public DogDoor() {
        this.open = false;
    }

    public boolean isLocked() {
        return lock;
    }

    public void lockDoor() {
        if (!this.lock) {
            this.lock = true;
            System.out.println("Door locked!");
        }
    }

    public void unlockDoor() {
        if (this.lock) {
            this.lock = false;
            System.out.println("Door unlocked!");
        }
    }

    public boolean isOpen() {
        return open;
    }

    public void open() {
        if (!isLocked()) {
            this.open = true;
            System.out.println("Dog door opens");
        }
        closeTheDoorAfterTimeout();
    }

    private void closeTheDoorAfterTimeout() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                close();
                timer.cancel();
            }
        }, 200);
    }

    public void close() {
        this.open = false;
        System.out.println("Dog door closes");
    }

    public void scratchPaws() {
        if (!isLocked()) {
            open();
        }
        closeTheDoorAfterTimeout();
    }

    public void hearBark(Bark bark) {
        System.out.println("Heard bark..");
        if (BarkRecognizer.recognizeBark(bark, getAllowedBarks())) {
            System.out.println("BarkRecognizer recognized..");
            System.out.println("Opening door..");
            if (!isLocked()) {
                open();
            }
            closeTheDoorAfterTimeout();
        }
    }

    public List<Bark> getAllowedBarks() {
        return allowedBarks;
    }

    public void setAllowedBarks(List<Bark> allowedBarks) {
        this.allowedBarks = allowedBarks;
    }
}
