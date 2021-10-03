package ru.mephi.labs.lab2;


import java.util.ArrayList;
import java.util.Collections;
import ru.mephi.homeworks.hw1.map.MyMap;
import ru.mephi.labs.lab1.list.List;


public class Task1 {
    public  static void main(String...args) {
        ArrayList<String> arr = new ArrayList<String>();
        MyMap map = new MyMap();
        Collections.addAll(arr, "a", "b", "ab", "a", "b", "c", "cc", "ab", null, null, null, null);
        for (String o : arr) {
            map.put(o, Collections.frequency(arr, o));
        }
        System.out.println(map);
    }
}
