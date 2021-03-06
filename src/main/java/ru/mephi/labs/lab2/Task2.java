package ru.mephi.labs.lab2;

import ru.mephi.homeworks.hw1.map.MyMap;
import ru.mephi.labs.lab1.list.List;

import java.util.ArrayList;
import java.util.Collections;

public class Task2 {
    public  static void main(String...args) {
        ArrayList<String> arr = new ArrayList<String>();
        MyMap map = new MyMap();
        Collections.addAll(arr, "a", "b", "ab", "a", "b", "c", "cc", "ab", null, null, null, null);
        for (String o : arr) {
            map.put(o, Collections.frequency(arr, o));
        }
        List res = map.getKeys();
        int size = res.size();
        System.out.println("---");
        for (int i = 0; i < size; ++i)
            System.out.print(res.get(i) + " ");
    }
}
