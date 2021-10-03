package ru.mephi.labs.lab1.list;


    public class Item {
        private Object value;
        public Item next;


        public Item() {
            next = null;
        }

        public Item(Object value) {
            this.value = value;
            next = null;
        }
        Object getValue(){
            return value;
        }

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

