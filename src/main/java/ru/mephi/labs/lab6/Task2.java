package ru.mephi.labs.lab6;


import java.util.ArrayList;

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
public class Task2 {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart(ShoppingCart.getShortArray());
        System.out.println(shoppingCart);
        shoppingCart.serialize("src\\main\\java\\ru\\mephi\\labs\\lab6\\someIn.txt");
        shoppingCart.serialize("src\\main\\java\\ru\\mephi\\labs\\lab6\\someOut.txt");
        ShoppingCart serShoppingCart = ShoppingCart.deserialize("src\\main\\java\\ru\\mephi\\labs\\lab6\\someOut.txt");
        assert serShoppingCart != null;
        System.out.println("Result:\n"+ serShoppingCart.toString());
    }
}
