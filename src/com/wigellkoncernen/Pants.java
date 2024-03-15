package com.wigellkoncernen;



public class Pants  {
    private int id;
    private String name;
    private String size;
    private double price = 899.00;
    private String material;
    private String color;


    private String fit;
    private String length;

    public Pants() {

    }

    public Pants(int id, String name, String size, double price, String material, String color, String fit, String length) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.material = material;
        this.color = color;
        this.fit = fit;
        this.length = length;

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

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
    public String getDetails() {

        return "Byxor - Detaljer: " + price + " kr, " + size + ", " + material + ", " + color + ", " + fit + ", " + length;
    }
}
