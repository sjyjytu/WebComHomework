package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Container {
    static private int count = 0;
    static private List<Item> container = new ArrayList<>();
    static final private int threshold = 4;
    static final private int timeout = 30 * 1000;

    static private List<Item> getContainer() {
        return container;
    }
    static public List<Item> produce() {
        count++;
        container.add(new Item(new Date(), count));
        return getContainer();
    }
    static public List<Item> consume() {
        if (container.isEmpty()) {
            return getContainer();
        }
        if (container.size() >= threshold) {
            container.remove(container.size() - 1);
        } else {
            container.remove(0);
        }
        return getContainer();
    }

    static public void removeTimeoutItem() {
        while (true) {
            if (container.isEmpty()) {
                break;
            }
            if (new Date().getTime() - container.get(0).getAddTime().getTime() < timeout) {
                break;
            }
            container.remove(0);
        }
    }

    static public boolean isEmpty() {
        return container.isEmpty();
    }
}
