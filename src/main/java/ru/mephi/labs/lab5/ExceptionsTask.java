package ru.mephi.labs.lab5;

import java.io.*;
import java.util.Arrays;

public class ExceptionsTask {

    public static void testIndexOutException(int number)throws ArrayIndexOutOfBoundsException{
        String[][] transactions=new String[8][8];
        transactions[1][number] = "273 EU SWAP";
    }
    public static void testFileException(String fileName) throws FileNotFoundException {
        //Попытаемся открыть файл, которого нет или он запрещен
        BufferedReader rd = new BufferedReader(new FileReader(fileName));

    }

    /*
    NPE может произойти в трёх случаях:
    Его кинули с помощью throw
    Кто-то кинул null с помощью throw
    Кто-то пытается обратиться по null-ссылке
     */
    public static void testNullException() throws NullPointerException {
        PriceRepository priceRepository = new PriceRepository();
        priceRepository.getPriceList().forEach((elem)->{
            System.out.println(String.valueOf(elem));
            System.out.println("\n\n"+ String.valueOf(elem.getValue()));//Не кидает NPE
            System.out.println(elem.getValue());//Может выбросить NPE
        });
    }
    /*
    IoExeption
    ВЫ ЧИТАЛИ СЕТЕВОЙ ФАЙЛ И БЫЛИ ОТКЛЮЧЕНЫ.
    ЧТЕНИЕ ЛОКАЛЬНОГО ФАЙЛА, КОТОРЫЙ БОЛЬШЕ НЕДОСТУПЕН.
    ИСПОЛЬЗУЕТСЯ КАКОЙ-ТО ПОТОК ДЛЯ ЧТЕНИЯ ДАННЫХ, И КАКОЙ-ТО ДРУГОЙ ПРОЦЕСС ЗАКРЫВАЕТ ЭТОТ ПОТОК.
    ВЫ ПЫТАЕТЕСЬ ПРОЧИТАТЬ/ЗАПИСАТЬ ФАЙЛ И НЕ ИМЕЕТЕ НА ЭТО РАЗРЕШЕНИЯ
    ВЫ ЗАПИСЫВАЛИ ФАЙЛ, А МЕСТО НА ДИСКЕ УЖЕ НЕДОСТУПНО
    Пример
        */
    public static void testIOException(String fileName) throws IOException {
        //Попытаемся открыть файл, которого нет или
        BufferedReader rd = new BufferedReader(new FileReader(fileName));
        //Читаем файл построчно
        String s;
        while((s = rd.readLine())!=null){

            System.out.println(s);
        }
    }
    /*
    ClassCastException – это непроверенное исключение ,
    которое сигнализирует о том, что код попытался привести ссылку
    на тип, к которому он не является подтипом.
    */
    public static void  testClassCastException() throws ClassCastException
    {
        Object primitives = new int[1];
        Integer[] integers = (Integer[]) primitives;
    }


    /*
    Арифметическое
     */
    private static void simpleDivision(int a, int b) throws ArithmeticException{
        int res = a/b;
        System.out.println("Division has been successfully done");
        System.out.println("Value after division: "+res);
    }
    public static void testArithmeticException()throws ArithmeticException{
        //Попробуем поделить на 0
        simpleDivision(21430,0);
    }
    //Error memory
    public static void outOfMemoryExample() throws OutOfMemoryError
    {
        Integer[] myArray = new Integer[1000 * 1000 * 1000 * 10000];
    }

    /*
    StackOverflowError -Переплнение стека
    -Наиболее распространенной причиной, по которой JVM сталкивается с этой ситуацией, является unterminated/бесконечная рекурси
    -наличие огромного количества локальных переменных внутри метода .
    -вызывать методы из методов до тех пор, пока стек не будет исчерпан
    */
    public static int calculateFactorial(int number) throws StackOverflowError{
        return number * calculateFactorial(number - 1);
    }
    /*
    Пример зацикливания :
    Можно создание класса зациклить
     */
    public static void main(String[] args) {
        //-----------Test Index Out Exception
        try {
            System.out.println("\n-----------Test Index Out Exception");
            testIndexOutException(12);
        }catch (ArrayIndexOutOfBoundsException exception)
        {
            System.out.println("You left the area of array");
            System.out.println( exception.getMessage());
        }

        //-----------Test FileNoFoundException
        try {
            System.out.println("\n-----------Test FileNoFoundException");

            testFileException("src\\main\\java\\ru\\mephi\\labs\\lab5\\BlackList.js");
            testFileException("src\\main\\java\\ru\\mephi\\labs\\lab5\\EvilScript.py");
        }
        catch (FileNotFoundException exception){

            System.out.println(exception.getMessage());
        }
        try {
            System.out.println("\n-----------Test FileNoFoundException");
            testFileException("src\\main\\java\\ru\\mephi\\labs\\lab5\\BlackList1.js");
        }
        catch (FileNotFoundException exception){

            System.out.println(exception.getMessage());
        }
        //-----------Test NPE
        try {
            System.out.println("\n-----------Test NPE");
            testNullException();
        }catch (NullPointerException exception)
        {
            System.out.println("Was declared null element");
           System.out.println(exception.getMessage());
        }

        //------------Test IOExсpetion
        try {
            System.out.println("\n-----------Test IOException");
            testIOException("src\\main\\java\\ru\\mephi\\labs\\lab6\\some.js");
            testIOException("src\\main\\java\\ru\\mephi\\labs\\lab5\\BlackList.js");
            testIOException("src\\main\\java\\ru\\mephi\\labs\\lab5\\EvilScript.py");
        } catch (IOException e){
            System.out.println("Was detected IO exception");
            System.out.println(e.getMessage());
        }

        //------------Test ClassCastException
        try {
            System.out.println("\n-----------Test ClassCastException");
            testClassCastException();
        } catch (ClassCastException e){
            System.out.println("Was detected CCE exception");
            System.out.println(e.getMessage());
        }

        //------------Test ArithmeticException
        try {
            System.out.println("\n-----------Test ArithmeticException");
            testArithmeticException();
        } catch (ArithmeticException e){
            System.out.println("Was detected ArithmeticException exception");
            System.out.println(e.getMessage());
        }

        //------------Test Out of memory exp
        try {
            System.out.println("\n-----------Test Out of memory exp");
            outOfMemoryExample();
        } catch (OutOfMemoryError oome) {
        System.err.println("Array size too large");
        System.err.println("Max JVM memory: " + Runtime.getRuntime().maxMemory());
        }

        //------------Test stack overflow error
        try {
            System.out.println("\n-----------Test stack overflow error");
            System.out.println(calculateFactorial(124325));
        } catch (StackOverflowError sofe) {
            System.err.println("Stack is overflow");
            System.err.println(Arrays.toString(sofe.getStackTrace()));
        }
    }
}
