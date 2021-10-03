package ru.mephi.homeworks.hw1.map;

import ru.mephi.labs.lab1.list.List;

/*
Реализовать словарь (map)
  Операции
  - Положить по ключу значение:          public void put(Object key, Object value);
  - Получить по ключу:                   public Object get(Object key);
  - Получить по ключу,                   public Object get(Object key, Object bydefault);
    если значение null, тогда надо
    вернуть значение по умолчанию,
    которое задается вторым параметром.
    Значение по умолчанию необходимо
    сохранить.
  - Удалить по ключу, возвращает текущее public Object remove(Object key);
    значение
  - Проверить наличие ключа:             public boolean keyContains(Object key);
  - Получить список ключей:              public List getKeys();
  - Получить список значений:            public List getValues();
  - Получить список пар: ключ, значение: public List getEntries();
  - Размер словаря:                      public int size();
  - Пустой или нет:                      public boolean isEmpty();
 */
public interface Map {
    /**
     * This function adds a key-value pair to the dictionary.
     * If it finds a duplicate key when inserted, it changes the contents of the pair.
     * @param key is a unique key.
     * @param value is some content.
     */
    public void put(Object key, Object value);

    /**
     * This function returns a value by key, including a null element.
     * If the search fails, it returns a null item.
     * @param key is a unique key.
     * @return some value or null.
     */
    public Object get(Object key);

    /**
     * This function returns a value by key or default value.
     * @param key is unique key.
     * @param byDefault is a random value.
     * @return a value by key or default value.
     */
    public Object get(Object key, Object byDefault);

    /**
     * Removes the key-value pair from the dictionary by key
     * and returns the current value in the pair.
     * @param key is a unique key
     * @return the current value in the pair.
     */
    public Object remove(Object key);

    /**
     * This function checks for a key.
     * @param key is a key that checks.
     * @return true if the key exists and false if otherwise.
     */
    public boolean keyContains(Object key);

    /**
     * This function returns a list of key.
     * @return key list.
     */
    public List getKeys();

    /**
     * This function returns a list of value.
     * @return value list.
     */
    public List getValues();

    /**
     * This function returns a list of key-value pairs.
     * @return list of key-value pairs.
     */
    public List getEntries();

    /**
     * Returns the size of the dictionary.
     * @return the size of the dictionary.
     */
    public int size();

    /**
     * Checks the dictionary for at least one item.
     * @return true if the dictionary is empty and false if otherwise
     */
    public boolean isEmpty();
}
