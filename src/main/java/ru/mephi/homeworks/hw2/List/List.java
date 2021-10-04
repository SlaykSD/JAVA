package ru.mephi.homeworks.hw2.List;

//Пояснение почему <? super T>
//
public class List<T extends Comparable<? super T>> {
    private int size;
    private Item<T> head;

    @Override
    public String toString() {
        return show();
    }

    public List() {
        size = 0;
        this.head = null;
    }

    public List(T value) {
        this.head = new Item<>(value);
        size = 1;
    }
    public List(List<T> oldList)
    {
        size = oldList.size;
        Item<T>ptr = oldList.head;
        head = new Item<>(ptr.getValue());
        Item<T>ptr2 = head;
        ptr = ptr.next;
        for(int i= 0;i< size-1; ++i)
        {
            ptr2.next = new Item<>(ptr.getValue());
            ptr2= ptr2.next;
            ptr = ptr.next;
        }
    }

    //sort by order
    private Item<T> mergeSort(Item<T> ptr ,int size)
    {
        Item<T> low; //Первая половина
        Item<T> high ; //Вторая половина
        if(ptr == null || ptr.next == null)
            return null;

        int[] sizes = new int[2];
        sizes[0]= size/2;
        sizes[1]= size - sizes[0];
        Item<T> curr = ptr;
        for(int i =0; i< sizes[0]-1; ++i)
            curr = curr.next;
        low = ptr;
        high = curr.next;
        curr.next =null;

        Item<T> res = mergeSort(low, sizes[0]);
        if(res != null)
            low = res;
        res = mergeSort(high,sizes[1]);
        if(res != null)
            high = res;
        return merge(low,high);
    }

    /*
      Слияние отсортированных связанных списков - задача для тех, кто в 1 лабе реализовывал мапу
    Необходимо реализовать функцию merge:
    • на вход функция получает head 2х связанных списков;
    • внутри функции произвести слияние списков, сохраняя порядок;
    • порядок в каждом из связанных списков от меньшего к большему;
    • функция должна вернуть head нового связанного списка.
    • желательно реализовать на своем списке, сменив Object на int
     */

    public void mergeSort()
    {
        head = mergeSort(head,size);
    }
    public List<T> merge(List<T> ptr)
    {
        List<T> ptr2 = new List<T>(ptr);
        ptr2.mergeSort();
        ptr2.size += size;
        ptr2.head = merge(ptr2.head, head);
        return  ptr2;
    }
    private  Item<T> merge(Item<T> a,Item<T> b)
    {
        Item<T> tmp ;
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
            Предполагается, что оба списка уже отсортированы по убыванию.Поэтому
            по первым элментам списков определяется НАИМЕНЬШИЙ элемент
            он будет головой нового списка.
         */
        if (a.getValue().compareTo(b.getValue())<0) {
         c = a;
            a = a.next;
        } else {
          c = b;
            b = b.next;
        }
        // Сохраняем итоговый head списка
        tmp = c;
        //Склеиваем первую половину, включая все элементы одного из списков
        while (a!=null && b!=null) {
            if (a.getValue().compareTo(b.getValue())<0) {
                c.next = a;
                a = a.next;
            } else {
                c.next = b;
                b = b.next;
            }
            c =c.next;
        }

        //Склеиваем оставгшийся список
        if (a!= null) {
            while (a!=null) {
                c.next = a;
                c = c.next;
                a = a.next;
            }
        }
        if (b!=null) {
            while (b!=null) {
                c.next = b;
                c=c.next;
                b = b.next;
            }
        }
        return tmp;
    }

    public void add(T value) {
        if (size > 0) {
            Item<T> ptr = this.head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = new Item<>(value);
        } else {
            head = new Item<>(value);
        }
        size++;
    }
    public void addSort(T value) {
        if (size > 0) {
            Item<T> ptr = this.head;
            if(ptr.getValue().compareTo(value)< 0)
            {
                //Значит введеное значение больше, чем знаечние списка, мы сортируем по возрастанию - наибольшее в конец списка
                Item<T>  prev = null;
                while(ptr != null && ptr.getValue().compareTo(value) < 0)
                {
                    prev = ptr;
                    ptr = ptr.next;
                }

                if(ptr == null)
                {
                    prev.next = new Item<>(value);
                }
                    else
                {
                    var newItem = new Item<>(value);
                    assert prev != null;
                    newItem.next = prev.next;
                    prev.next = newItem;
                }
            }
            else
            {
                head = new Item<>(value);
                head.next = ptr;
            }
        } else {
            head = new Item<>(value);
        }
        size++;
    }
    /*  private void  find (T value, Item<T> prev, Item<T> curr)
    {
        //Передается какой-то элемент списка и предыдущий элемент
        //Охватывает 3 ситуации
        while(curr.next!= null && curr.getValue().compareTo(value) < 0)
        {
            prev = curr;
            curr = curr.next;
        }
    }*/
    public T remove(int index) {
        if ( index > (this.size - 1) || index < 0) {
            System.out.println("Incorrect index");
            return null;
        }
        Item<T> res;
        if (index == 0) {
            res = this.head;
            this.head = head.next == null ? null : this.head.next;
            res.next = null;
        } else {
            Item<T> ptr = this.head;
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

    public void add(T value, int index) {
        if (index > (this.size - 1) || index < 0) {
            System.out.println("Incorrect index");
        } else {
            Item<T> res;
            if (index > 0) {
                Item<T> ptr = this.head;
                while (index != 1) {
                    ptr = ptr.next;
                    index--;
                }
                res = new Item<>(value);
                res.next = ptr.next;
                ptr.next = res;
            } else {
                res = this.head;
                this.head = new Item<>(value);
                this.head.next = res;
            }
            size++;
        }
    }

    private Item<T> findByIndex(int index) {
        if (index > (this.size - 1) || index < 0) {
            System.out.println("Incorrect index");
            return null;
        }
        Item<T> ptr = this.head;
        while (index != 0) {
            ptr = ptr.next;
            index--;
        }
        return ptr;
    }

    public T set(int index, T value) {

        Item<T> ptr = this.findByIndex(index);
        if (ptr == null)
            return null;
        T old = ptr.getValue();
        ptr.setValue(value);
        return old;
    }

    public T get(int index) {
        Item<T> res = findByIndex(index);
        return res == null ? null : res.getValue();
    }

    public int indexOf(T value) {
        Item<T> ptr = this.head;
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

    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private String show() {
        Item<T> ptr = head;
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

    public static void main(String[] args) {
        List<Integer> list = new List<>();
        list.add(0);
        list.add(3);
        list.add(2);
        list.add(123);
        list.add(-123);
        list.mergeSort();
        Item<Integer> head1 = new Item<>();
        head1.setValue(23);
        Item<Integer> head2 = new Item<>();
        head2.setValue(2123);
        Item<Integer> head3 = new Item<>();
        head3.setValue(-13);
        Item<Integer> head4 = new Item<>();
        head4.setValue(0);

        head1.next = head2;
        head3.next = head1;
        head4.next = null;
        Item<Integer> res = list.merge(head3,head4);
        Item<Integer>info = res;
        while (info!= null)
        {
            System.out.println(info);
            info = info.next;
        }
        System.out.println(list);

        List<Integer> list1 = new List<>();
        list1.add(123);
        list1.add(37);
        list1.add(0);
        list1.add(572);
        list1.add(-17835);
        var list2 = list.merge(list1);
        System.out.println(list2);
    }
}