package ru.mephi.labs.lab1.list;

public class List {
    private int size;
    private Item head;

    @Override
    public String toString() {
        return show();
    }

    public List() {
        size = 0;
        this.head = null;
    }

    public List(Object value) {
        this.head = new Item(value);
        size = 1;
    }

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

    public Object set(int index, Object value) {

        Item ptr = this.findByIndex(index);
        if (ptr == null)
            return null;
        Object old = ptr.getValue();
        ptr.setValue(value);
        return old;
    }

    public Object get(int index) {
        Item res = findByIndex(index);
        return res == null ? null : res.getValue();
    }

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

    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

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