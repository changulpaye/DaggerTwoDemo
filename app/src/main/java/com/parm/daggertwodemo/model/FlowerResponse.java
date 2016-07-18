package com.parm.daggertwodemo.model;

import com.google.gson.annotations.Expose;

/**
 * Created by pchangul on 7/18/2016.
 */
public class FlowerResponse {

    @Expose
    private String category;
    @Expose
    private Float price;
    @Expose
    private String instructions;
    @Expose
    private String photo;
    @Expose
    private String name;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Expose
    private int productId;

}
