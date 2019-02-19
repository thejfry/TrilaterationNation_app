package com.example.jeffreyplett.fragmenttutorialapp;

public class Anchor {
    private String name;
    private int id;
    private float x;
    private float y;

    public Anchor() {

    }

    public Anchor(String name, float x, float y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public float getAnchorX() {
        return x;
    }

    public float getAnchorY() {
        return y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnchorX(float x) {
        this.x = x;
    }

    public void setAnchorY(float y) {
        this.y = y;
    }
}
