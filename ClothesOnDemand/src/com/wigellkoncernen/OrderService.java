package com.wigellkoncernen;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Object> orders;
    private PropertyChangeSupport pcs;

    private static OrderService instance;

    private OrderService() {
        this.orders = new ArrayList<>();
        this.pcs = new PropertyChangeSupport(this);
    }

    public static synchronized OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    public void placeOrder(Object item, boolean isManufacturingComplete, boolean isReadyForDelivery) {
        if (!orders.contains(item)) {
            orders.add(item);
            System.out.println("Beställning: " + item.toString());

            if (item instanceof Pants || item instanceof TShirt || item instanceof Skirt) {
                notifyObservers("plagg tillverkas", isManufacturingComplete);
                notifyObservers("plagg klar", isReadyForDelivery);
            }
        }
    }

    public void addObserver(PropertyChangeListener observer) {
        pcs.addPropertyChangeListener(observer);
    }

    private void notifyObservers(String eventName, boolean value) {
        pcs.firePropertyChange(eventName, null, value);
    }

    public void displayOrders() {
        System.out.println("Aktuell beställning:");
        for (Object order : orders) {
            System.out.println(order.toString());
        }
    }
}