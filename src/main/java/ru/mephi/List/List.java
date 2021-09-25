package ru.mephi.List;

public class List {
    private int len;
    private Item head;

    private class Item {
        private Object value;
        public Item next;

        public Item() {
            next = null;
        }

        public Item(Object value) {
            this.value = value;
            next = null;
        }

        @Override
        public String toString() {
            return " Item [" +
                    "value_=" + value +
                    ']';
        }
    }

    @Override
    public String toString() {
        return show();
    }

    public List() {
        len = 0;
        this.head = null;
    }

    public List(Object value) {
        this.head = new Item(value);
        len = 1;
    }

    public void add(Object value) {
        if (len > 0) {
            Item ptr = this.head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = new Item(value);
        } else {
            head = new Item(value);
        }
        len++;
    }

    public Object remove(int index) {
        if ( index > (this.len - 1) || index < 0) {
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
        len--;
        return res.value;
    }

    public void add(Object value, int index) {
        if (index > (this.len - 1) || index < 0) {
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
            len++;
        }
    }

    private Item findByIndex(int index) {
        if (index > (this.len - 1) || index < 0) {
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
        Object old = ptr.value;
        ptr.value = value;
        return old;
    }

    public Object get(int index) {
        Item res = findByIndex(index);
        return res == null ? null : res.value;
    }

    public int indexOf(Object value) {
        Item ptr = this.head;
        if (value == null) {
            for (int i = 0; i < len; ++i) {
                if (ptr.value == null)
                    return i;
                ptr = ptr.next;
            }
        } else {
            for (int i = 0; i < len; ++i) {
                if (value.equals(ptr.value))
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
        return len;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    private String show() {
        Item ptr = head;
        String res = new String();
        res += "List {";
        for (int i = 0; i < len; i++) {
            res += "\n";
            res += ptr.toString();
            ptr = ptr.next;
        }
        res += "}";
        res += "\n";
        return res;
    }

}