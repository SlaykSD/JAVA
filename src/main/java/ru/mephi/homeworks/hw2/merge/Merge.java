package ru.mephi.homeworks.hw2.merge;

public class Merge {
    public static void main(String[] args) {
        List<Integer> list1 = new List<>();
        List<Double>  list2 = new List<>();
        List<Integer> list3 = new List<>();
        List<String> list4 = new List<>();
        List<Double> list5 = new List<>();
        List<String> list6 = new List<>();


        int size = 100;
        for(int i = 0;i<size;i++ )
            list1.add((int)  ((Math.random()*100)-50));
        size = 10;
        for(int i = 0;i<size;i++ )
            list3.add((int) ((Math.random()*100)-50));

        size = 111;
        for(int i = 0;i<size;i++ )
            list2.add((Double) Math.random()*100);
        size = 25;
        for(int i = 0;i<size;i++ )
            list5.add((Double) Math.random()*100);
        size = 25;
        for(int i = 0;i<size;i++ )
            list4.add( ((Integer)(int)(Math.random()*100)).toString());
        size = 25;
        for(int i = 0;i<size;i++ )
            list6.add( ((Integer)(int)(Math.random()*100)).toString());
        System.out.println("INTEGER---");
        System.out.println(list1);
        System.out.println("DOUBLE---");
        System.out.println(list2);
        System.out.println("INTEGER---");
        System.out.println(list3);
        System.out.println("STRING---");
        System.out.println(list4);
        System.out.println("DOUBLE---");
        System.out.println(list5);
        System.out.println("STRING---");
        System.out.println(list6);

        list1 = list1.merge(list3);
        var listResult1 = list1.merge(list3);;
        System.out.println("List 1 + List 3---");
        System.out.println(listResult1);
        list2.mergeSort();
        list2.mergeSort();
        var listResult2 = list2.merge(list2);
        System.out.println("List 2 + List 2---");
        System.out.println(listResult2);

        System.out.println("DOUBLE-LIST2-Before second sorting-");
        System.out.println(list2);
        list2.mergeSort();
        System.out.println("DOUBLE-LIST2-After sorting-");
        System.out.println(list2);

        var listResult3 = list2.merge(list5);
        System.out.println("List 2 + List 5---");
       // System.out.println("");
        System.out.println(listResult3);

        var listResult4 = list4.merge(list6);
        System.out.println("List 4 + List 6---");
        System.out.println(listResult4);
    }
}
