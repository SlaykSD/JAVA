package ru.mephi.labs.lab6;

import java.io.Serializable;


public class Item implements Serializable {
    int id;
    String description;
    double  cost;
    Item(int id, String description, double cost) {
        this.id = id;
        this.cost = cost;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
