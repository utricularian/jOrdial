package com.segfaultsoftware.jOrdial.models;

public class Critter {
    private final long id;
    private final String color;

    public Critter(long id, String color) {
        this.id = id;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

}