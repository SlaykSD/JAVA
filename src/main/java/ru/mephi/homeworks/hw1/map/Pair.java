package ru.mephi.homeworks.hw1.map;

public class Pair
{
    private Object key;
    private Object value;
    public Pair()
    {
        key = null;
        value  = null;
    }
    public  Pair(Object key, Object value)
    {
        this.key = key;
        this.value = value;
    }
    @Override
    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj instanceof Pair) {
            Pair pair= (Pair) obj;
            if(pair.key!=null && key !=null)
                flag = this.key.equals(pair.key);
            else
                flag = (pair.key == null && key== null);
        }
        return flag;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}