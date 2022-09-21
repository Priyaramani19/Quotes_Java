package com.example.bestquotes.Screen.HomePage.Model;

public class Model_Quotes {

    String images,temp;

    public Model_Quotes(String images, String temp) {
        this.images = images;
        this.temp = temp;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getImage() {
        return images;
    }

    public void setImage(String images) {
        this.images = images;
    }
}
