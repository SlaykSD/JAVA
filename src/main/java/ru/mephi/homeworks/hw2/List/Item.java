package ru.mephi.homeworks.hw2.List;

public class Item<T extends Comparable> {
    private T value;
    public Item<T> next;


    public Item() {
        next = null;
    }

    public Item(T value) {
        this.value = value;
        next = null;
    }
    T getValue(){
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return " Item [" +
                "value_=" + value +
                ']';
    }
}