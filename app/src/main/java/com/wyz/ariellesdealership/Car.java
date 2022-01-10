package com.wyz.ariellesdealership;

import java.io.Serializable;

public class Car implements Serializable{

    // Car Attributes
    private int Image;
    private String Brand;
    private String Model;
    private String Year;
    private String Price;

    // Get Image
    public int getImage() {
        return Image;
    }

    // Get Brand
    public String getBrand() {
        return Brand;
    }

    // Get Model
    public String getModel() {
        return Model;
    }

    // Get Year
    public String getYear() {
        return Year;
    }

    // Get Price
    public String getPrice() {
        return Price;
    }

    public Car(int image, String brand, String model, String year, String price)
    {
        this.Image = image;
        this.Brand = brand;
        this.Model = model;
        this.Year = year;
        this.Price = price;
    }

}
