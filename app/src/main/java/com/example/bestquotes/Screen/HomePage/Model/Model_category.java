package com.example.bestquotes.Screen.HomePage.Model;

public class Model_category {

    String category,image;

    public Model_category(String category, String image) {
        this.category = category;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
