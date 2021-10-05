package ru.mephi.labs.lab1.list;

/**
 * Implementation of a list that stores non-unique null-defined items.
 * @author DenGer
 */
public class List {

    /**
     * Contains a size of list.
     */
    private int size;
    /**
     * This field contains a reference to the head of list.
     */
    private Item head;

    @Override
    public String toString() {
        return show();
    }

    /**
     * Default constructor.
     */
    public List() {
        size = 0;
        this.head = null;
    }

    /**
     * Initializing constructor.
     * @param value is some information.
     */
    public List(Object value) {
        this.head = new Item(value);
        size = 1;
    }

    /**
     * Adds a new item to the end of the list.
     * @param value is some information.
     */
    public void add(Object value) {
        if (size > 0) {
            Item ptr = this.head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = new Item(value);
        } else {
            head = new Item(value);
        }
        size++;
    }

    /**
     * Deletes an item from the list by index,
     * returns a reference to the deleted object.
     * @param index is an item number in the list
     * @return a reference to the deleted object
     */
    public Object remove(int index) {
        if ( index > (this.size - 1) || index < 0) {
            System.out.println("Incorrect index");
            return null;
        }
        Item res;
        if (index == 0) {
            res = this.head;
            this.head = head.next == null ? null : this.head.next;
            res.next = null;
        } else {
            Item ptr = this.head;
            while (index != 1) {
                ptr = ptr.next;
                index--;
            }
            res = ptr.next;
            ptr.next = ptr.next.next;
        }
        size--;
        return res.getValue();
    }

    /**
     * Adds a new item to the place which is defined by index.
     * @param value is some information.
     * @param index is a number where you want to add
     */
    public void add(Object value, int index) {
        if (index > (this.size - 1) || index < 0) {
            System.out.println("Incorrect index");
        } else {
            Item res;
            if (index > 0) {
                Item ptr = this.head;
                while (index != 1) {
                    ptr = ptr.next;
                    index--;
                }
                res = new Item(value);
                res.next = ptr.next;
                ptr.next = res;
            } else {
                res = this.head;
                this.head = new Item(value);
                this.head.next = res;
            }
            size++;
        }
    }

    /**
     * This function search element by index and
     * return result. If search incorrect index, then return null.
     * @param index is an item number in the list
     * @return data cell or null
     */
    private Item findByIndex(int index) {
        if (index > (this.size - 1) || index < 0) {
            System.out.println("Incorrect index");
            return null;
        }
        Item ptr = this.head;
        while (index != 0) {
            ptr = ptr.next;
            index--;
        }
        return ptr;
    }

    /**
     * Changes the element by the index to the value passed to the function.
     * @param index is an item number in the list.
     * @param value is a new value.
     * @return the old value.
     */
    public Object set(int index, Object value) {

        Item ptr = this.findByIndex(index);
        if (ptr == null)
            return null;
        Object old = ptr.getValue();
        ptr.setValue(value);
        return old;
    }

    /**
     * Returns the data by index .
     * @param index is an item number in the list.
     * @return information by index
     */
    public Object get(int index) {
        Item res = findByIndex(index);
        return res == null ? null : res.getValue();
    }

    /**
     * This function determines the index by the value of
     * @param value the value whose index we want to know
     * @return Index if the search is successful and -1 if not
     */
    public int indexOf(Object value) {
        Item ptr = this.head;
        if (value == null) {
            for (int i = 0; i < size; ++i) {
                if (ptr.getValue() == null)
                    return i;
                ptr = ptr.next;
            }
        } else {
            for (int i = 0; i < size; ++i) {
                if (value.equals(ptr.getValue()))
                    return i;
                ptr = ptr.next;
            }
        }
        return -1;
    }

    /**
     * Checks if there is information in the list
     * @param value the value, which would be checked
     * @return if value exists then true else false
     */
    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    /**
     * @return size of vector
     */
    public int size() {
        return size;
    }

    /**
     * Checks the list for at least one item.
     * @return true if the list is empty and false if otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Generates a string describing the state of the class
     * @return string that contains information about the class
     */
    private String show() {
        Item ptr = head;
        StringBuilder res = new StringBuilder();
        res.append("List {");
        for (int i = 0; i < size; i++) {
            res.append("\n");
            res.append(ptr.toString());
            ptr = ptr.next;
        }
        res.append("}");
        res.append("\n");
        return res.toString();
    }

}