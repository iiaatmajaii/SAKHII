package com.example.sakhii;

public class RestaurantModel {

    private int id;
    private String name;
    private String locality;
    private String staff;
    private boolean alcohol;
    private boolean safe;

    public RestaurantModel(int id, String name, String locality, String staff, boolean alcohol, boolean safe) {
        this.id = id;
        this.name = name;
        this.locality = locality;
        this.staff = staff;
        this.alcohol = alcohol;
        this.safe = safe;
    }

    @Override
    public String toString() {
        return "RestaurantModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", locality='" + locality + '\'' +
                ", staff='" + staff + '\'' +
                ", alcohol=" + alcohol +
                ", safe=" + safe +
                '}';
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

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public boolean isAlcohol() {
        return alcohol;
    }

    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }
}

