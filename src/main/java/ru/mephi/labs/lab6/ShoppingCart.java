package ru.mephi.labs.lab6;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/*
Задание №2
• Создать приложение, сереализующее объект класса ShoppingCart,
который представлен в виде ArrayList из Item
• Используйте ключевое слово transient для предотвращения сериализации общей суммы ShoppingCart.
 Это позволит правильно считать сумму.
• Используйте метод writeObject для сохранения сегодняшней даты
• Используйте метод readObject, чтобы пересчитать общую стоимость корзины после десериализации и напечатайте дату,
когда объект был сериализован
 */
public class ShoppingCart implements Serializable {
    private static final LocalDate date = LocalDate.now();
    private static transient long counterID =0;
    int cartID;
    ArrayList<Item> items;
    int itemCount;
    transient double cartTotal;
    public  ShoppingCart (){
        cartID = (int) ++counterID;
        itemCount = 0;
        items = new ArrayList<>();
        cartTotal = 0;
    }
    public  ShoppingCart (ArrayList<Item> list){
        cartID = (int) ++counterID;
        itemCount = 0;
        items = list;
        cartTotal = 0;
        list.forEach( x->{
            cartTotal+= x.cost;
            itemCount++;
        });
    }
    public static  ArrayList<Item> getShortArray(){
        ArrayList<Item> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,
                new Item((int) ++counterID,"BlackBacakrd",300.0),
                new Item((int) ++counterID,"Mitsubishi Outlander",142123124.0),
                new Item((int) ++counterID,"Сontik",23.0),
                new Item((int) ++counterID,"Chess",120.0),
                new Item((int) ++counterID,"Red coast",1000.0),
                new Item((int) ++counterID,"Russian national soccer team",0.0),
                new Item((int) ++counterID,"Pack of breadcrumbs",10.0),
                new Item((int) ++counterID,"Department 29 T-shirt",1500.0));
        return arrayList;
    }
    public  void addItem(Item item){
        items.add(item);
        itemCount++;
        cartTotal +=item.cost;
    }
    public  Item  removeItem(int i){
        itemCount --;
        return  items.remove(i);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartID=" + cartID +
                ", items=" + items +
                ", itemCount=" + itemCount +
                ", cartTotal=" + cartTotal +
                ", oldDate=" + date +
                '}';
    }

    public void serialize(String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(this);

        } catch (IOException exception){
            System.out.println("Exp: " + exception);
        }
    }

    public static  ShoppingCart deserialize(String filename) {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fis)) {
            //Делаем каст
            ShoppingCart cart = (ShoppingCart) in.readObject();
            for (int i = 0; i < cart.itemCount; i++) {
                //Подсчет суммы
                cart.cartTotal += cart.items.get(i).cost;
            }
            return cart;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Exp: " + e);
        }
        return null;
    }
}
