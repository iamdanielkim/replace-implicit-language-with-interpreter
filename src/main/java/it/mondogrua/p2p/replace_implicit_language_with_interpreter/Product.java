package it.mondogrua.p2p.replace_implicit_language_with_interpreter;

import java.awt.Color;

public class Product {

    private final String id;
    private String name;
    private Color color;
    private float price;
    private ProductSize size;

    public Product(String id, String name, Color color, float price,
            ProductSize size) {
                this.id = id;
                this.name = name;
                this.color = color;
                this.price = price;
                this.size = size;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductSize getSize() {
        return size;
    }

    public void setSize(ProductSize size) {
        this.size = size;
    }

}
