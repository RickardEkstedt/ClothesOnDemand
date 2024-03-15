package com.wigellkoncernen;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CEO implements PropertyChangeListener {

    private int id;
    private String name;

    public CEO() {
    }

    public CEO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("plagg tillverkas".equals(evt.getPropertyName())) {
            System.out.println("VD Notifiering: Plagg tillverkas");
        }

        if ("plagg klar".equals(evt.getPropertyName())) {
            System.out.println("VD Notifiering: Plagg är klart för leverans");
        }
    }
}
