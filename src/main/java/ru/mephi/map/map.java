package ru.mephi.map;

import ru.mephi.List.List;

public interface map {
    public void put(Object key, Object value);
    public Object get(Object key);
    public Object get(Object key, Object bydefault);
    public Object remove(Object key);
    public boolean keyContains(Object key);
    public List getKeys();
    public List getValues();
    public List getEntries();
    public int size();
    public boolean isEmpty();
}
