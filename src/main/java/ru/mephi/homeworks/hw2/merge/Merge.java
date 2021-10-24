package ru.mephi.homeworks.hw2.merge;

public class Merge<T extends Comparable<? super T>> extends List {
    public List<T> merge(List<T> list1,List<T> list2 ) {
        List<T> ptr1 = new List<>(list1);
        List<T> ptr2 = new List<>(list2);
        ptr2.head = merge(ptr1.head, ptr2.head);
        ptr2.size+= ptr1.size;
        return ptr2;
    }
    private Item<T> merge(Item<T> a, Item<T> b) {
        Item<T> tmp;
        Item<T> c;
        //Если какой-то из списков пустой, то просто возращаем другой
        if (a == null) {
            c = b;
            return c;
        }
        if (b == null) {
            c = a;
            return c;
        }

        /*
            Предполагается, что оба списка уже отсортированы по возрастанию .Поэтому
            по первым элментам списков определяется НАИМЕНЬШИЙ элемент
            он будет головой нового списка.
         */
        if (a.getValue().compareTo(b.getValue()) < 0) {
            c = a;
            a = a.next;
        } else {
            c = b;
            b = b.next;
        }
        // Сохраняем итоговый head списка
        tmp = c;
        //Склеиваем первую половину, включая все элементы одного из списков
        while (a != null && b != null) {
            if (a.getValue().compareTo(b.getValue()) < 0) {
                c.next = a;
                a = a.next;
            } else {
                c.next = b;
                b = b.next;
            }
            c = c.next;
        }

        //Склеиваем оставшийся список
        if (a != null) {
            c.next =a;
/*            while (a != null) {
                c.next = a;
                c = c.next;
                a = a.next;
            }*/
        }
        if (b != null) {
            c.next = b;
/*            while (b != null) {
                c.next = b;
                c = c.next;
                b = b.next;
            }*/
        }
        return tmp;
    }
    public static void main(String[] args) {
        List<Integer> list1 = new List<>();
        List<Double>  list2 = new List<>();
        List<Integer> list3 = new List<>();
        List<String> list4 = new List<>();
        List<Double> list5 = new List<>();
        List<String> list6 = new List<>();
        Merge<Integer> mergeInt = new Merge<>();
        Merge<Double> mergeDou = new Merge<>();
        Merge<String> mergeStr = new Merge<>();

        int size = 5;
        for(int i = 0;i<size;i++ )
            list1.add((int)  ((Math.random()*100)-50));
        for(int i = 0;i<size;i++ )
            list3.add((int) ((Math.random()*100)-50));
        for(int i = 0;i<size;i++ )
            list2.add(Math.random() *100);
        for(int i = 0;i<size;i++ )
            list5.add(Math.random() *100);
        for(int i = 0;i<size;i++ )
            list4.add( ((Integer)(int)(Math.random()*100)).toString());
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

        var listResult1 = mergeInt.merge(list1,list3);
        System.out.println("List 1 + List 3---");
        System.out.println(listResult1);


        var listResult2 =mergeDou.merge(list2,list2);
        System.out.println("List 2 + List 2---");
        System.out.println(listResult2);


        var listResult3 = mergeDou.merge(list2,list5);
        System.out.println("List 2 + List 5---");
       // System.out.println("");
        System.out.println(listResult3);

        var listResult4 = mergeStr.merge(list4,list6);
        System.out.println("List 4 + List 6---");
        System.out.println(listResult4);
    }
}
