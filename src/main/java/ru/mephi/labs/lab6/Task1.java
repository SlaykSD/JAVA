package ru.mephi.labs.lab6;
/*
Задание №1
• Написать основной класс, который принмает имя файла в качестве аргумента
• Используя консольный ввод, определить искомую в файле строку
• Используя связанные потоки, считать данные из файла и определить количество вхождений искомой строки


 */

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner("src\\main\\java\\ru\\mephi\\labs\\lab6\\some.js");


        //По заданию 1(Часть 1)
        //Проверяем работу поика строски в файле
        if(args.length>0)
        {
            System.out.println("Take the parameters");
            Scanner scanner1 = new Scanner(args[0]);
            var answer = "";
            while(!(answer = scanner1.mainDialog()).isEmpty()) {
                System.out.println("The task was completed with the result: " + answer);
            }
        }else{
        var answer = "";
       while(!(answer = scanner.mainDialog()).isEmpty()) {
           System.out.println("The task was completed with the result: " + answer);
       }
        }
    }
}
