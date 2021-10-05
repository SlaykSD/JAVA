package ru.mephi.labs.lab1.list;

/**
 *  Auxiliary class to develop the linked list.
 *  Item is a data cell with a pointer to the next element.
 * @author DenGer
 */
public class Item {
    /**
     * Some data
     */
    private Object value;
    /**
     * Pointer to the next data cell
     */
    public Item next;

    /**
     * Default empty constructor
     */
    public Item() {
        next = null;
    }

    /**
     * Initializing constructor
     * @param value is some information
     */
    public Item(Object value) {
        this.value = value;
        next = null;
    }

    /**
     * Default getter.
     * @return value of data cell.
     */
    Object getValue() {
        return value;
    }

    /**
     * Default setter.
     * @param value is some new information
     */
    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return " Item [" +
                "value_=" + value +
                ']';
    }
}

