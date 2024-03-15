package com.wigellkoncernen;

public class Skirt {
    private int id;
    private String name;
    private String size;
    private double price = 499.00;
    private String material;
    private String color;
    private String waistline;
    private String pattern;

    public Skirt() {

    }
    public Skirt(int id, String name, String size, double price, String material, String color, String waistline, String pattern) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.material = material;
        this.color = color;
        this.waistline = waistline;
        this.pattern = pattern;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWaistline() {
        return waistline;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getDetails() {
        return "Kjol - Detaljer: " + price + " kr, " + size + ", " + material + ", " + color + ", " + waistline + ", " + pattern;
    }
}