package ru.mephi.labs.lab4;

import ru.mephi.homeworks.hw3.TableSalary;
import ru.mephi.labs.lab3.Employee;
import ru.mephi.labs.lab3.Gender;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;


public class Task extends WorkingWithSalaryTable {

    /**
     * Контруктор по умолчанию
     * @param employeeList лист рабочих, с котором будет произведена работа, передача в коснтруктор абстрактного класса
     */
    public Task(List<Employee> employeeList) {
        super(employeeList);
    }

    /**
     * Расчитывает полное количесто средств ,которое нужно выплатить сотрудникам.
     */
    private void totalFounds()
    {
        System.out.println("\nРасчет суммы зарплат всех сотрудников");
        TableSalary tableSalary = TableSalary.getInstance();//Получаем таблицу зарплат
        //инициализируем функцию для расчета полной зарплаты(фактически ФИ для map( Employee -> Double))
        Function<Employee,Double> getFullSalary = x-> tableSalary.getSalary(x) +
                TableSalary.premium * (1+x.getRole().getInterestRate());
        ToDoubleFunction<Employee> getDoubleFullSalary = x-> tableSalary.getSalary(x) +
                TableSalary.premium * (1+x.getRole().getInterestRate());


        //Реализация подсчета полной зарплаты через стримы и map и peek
        AtomicInteger count = new AtomicInteger(0); //переменная чисто для показа индекса перменных (хотим увидеть как параллельно производятся вычисления в потоках)
        AtomicReference<Double> result = new AtomicReference<>(0.0);
        Runnable generatorTotalSum =()->{
            result.set(employeeList.stream().map(getFullSalary).peek(x -> {
                count.getAndIncrement();
                System.out.println("Salary [" + count.get() + "] :" + x);
            }).reduce(Double::sum).orElse(-1.0));
       };
       //Просто для теста
        AtomicReference<Double> sum = new AtomicReference<>(0.0);
        Runnable anotherGeneratorTotalSum =()->{
            var lits = employeeList.stream().map(getFullSalary).peek(x->{
                count.getAndIncrement();
                System.out.println("Salary [" + count.get() + "] :" + x);
            }).toList();
            for (var a: lits)
                sum.updateAndGet(v-> v + a);
        };
        StopWatch.checkTime(generatorTotalSum,"расчет полной суммы");
        System.out.println("Результат расчета в основной функции: "+result.get());
        count.set(0);
        StopWatch.checkTime(anotherGeneratorTotalSum,"расчет полной суммы не в стриме");
        System.out.println("Сумма расчета другим методом: "+sum.get());
        System.out.println("Результат сравнения двух расчетов: "+sum.get().equals( result.get()));
        if(sum.get().equals(result.get())) {
            System.out.println("Сумма расчета другим методом: "+sum.get());
        }
        //Test


    }

    /**
     * Расчитывает среднюю зарплату рабочих
     */
    private void averageSalary()
    {
        System.out.println("\nРасчет средней зарплаты сотрудников");
        TableSalary tableSalary = TableSalary.getInstance();//Получаем таблицу зарплат
        ToDoubleFunction<Employee> getDoubleFullSalary = x-> tableSalary.getSalary(x) +
                TableSalary.premium * (1+x.getRole().getInterestRate());

        AtomicInteger count = new AtomicInteger(0); //переменная чисто для показа индекса перменных (хотим увидеть как параллельно производятся вычисления в потоках)
        AtomicReference<Double> result = new AtomicReference<>(0.0);
        Runnable generatorTotalSum =()->{
            result.set(employeeList.parallelStream().mapToDouble(getDoubleFullSalary).peek(x -> {
                System.out.println("Thread: "+ Thread.currentThread().getId());
                count.getAndIncrement();
                System.out.println("Salary [" + count.get() + "] :" + x);
            }).average().orElse(-1.0));
        };


        StopWatch.checkTime(generatorTotalSum,"расчет средней зп");
        System.out.println("Результат расчета срейдней зарплаты(+ параллельный поток): "+ result.get());
    }

    /**
     * Пример работы lazy and findFirst
     * @throws InterruptedException может вылететь в результате сна основного потока
     */
    private void findFirstFemaleParallel() throws InterruptedException {
        System.out.println("\nВывод определенного первого сотрудника женщину в парраллельной обработке");
        var stream = employeeList.parallelStream().filter(x-> x.getGender().equals(Gender.FEMALE)).peek(x->{
            System.out.println("Name victim: " + x.getGivenName());
        });


        //Как видно в консоли это сообщение будет первым из-за lazy стримов
        System.out.println("...Now we can see the victim....");

        //Следующая фильтровка
        var optname = stream.filter(x-> x.getGivenName().contains("G") || x.getGivenName().contains("a")|| x.getGivenName().length()> 3).peek(x-> {
            System.out.println("Name victim after second filter: " + x.getGivenName());
        }).findFirst();
        if(optname.isPresent())
        {
            System.out.println("Name of victim is ..........");
            Thread.sleep(2000);
            System.out.println(optname.get().getGivenName() +" "+ optname.get().getSurName());
        }
    }
    private void findFirstFemaleDefault() throws InterruptedException {
        System.out.println("\nВывод определенного первого сотрудника женщину в одном потоке");
        var stream = employeeList.stream().filter(x-> x.getGender().equals(Gender.FEMALE)).peek(x->{
            System.out.println("Name victim: " + x.getGivenName());
        });


        //Как видно в консоли это сообщение будет первым из-за lazy стримов
        System.out.println("...Now we can see the victim....");

        //Следующая фильтровка
        var optname = stream.filter(x-> x.getGivenName().contains("K") && x.getGivenName().contains("o")).peek(x-> {
            System.out.println("Name victim after second filter: " + x.getGivenName());
        }).findFirst();
        if(optname.isPresent())
        {
            System.out.println("Name of victim is ..........");
            Thread.sleep(2000);
            System.out.println(optname.get().getGivenName() +" "+ optname.get().getSurName());
        }
    }
    private void sortByAge()
    {
        System.out.println("\n---Finds the oldest and youngest employee---");
        employeeList.stream().max(Comparator.comparingInt(Employee::getAge)).ifPresent(System.out::println);
        employeeList.stream().min(Comparator.comparingInt(Employee::getAge)).ifPresent(System.out::println);
    }
    @Override
    public void doAction() throws InterruptedException {
        totalFounds();
        averageSalary();
        findFirstFemaleDefault();
        findFirstFemaleParallel();
        sortByAge();
    }


    public static void main(String[] args) throws InterruptedException {
        List<Employee> employeeList = Employee.createShortList();
        Task task = new Task(employeeList);
        task.doAction();

    }




}
/*
В данной лабораторной работе я понял, как можно преобразовывать типы данных в потоке:
Если мы хотим перевсти колеекцию тип в поток приметивов int
можно использовать .mapToInt(что преобразовать (референс))
например  .mapToInt(String::length) что тоже самое, что .mapToInt(x-> x.length())
Если хотим собрать из какого-либо типа список классов Integer,
То в случае, если мы перевили в IntStream использовать boxed() он переводит обратно в Stream
И использовать либо Collector  в collect либо .toList()
ВОПРОС 1
Хотим получить список классов типа Double или Integer как лучше:
1) (Произвольная коллекция из произвольных типов).stream.map(преобразования типа в  Integer или Double).ToList();
2) (Произвольная коллекция из произвольных типов).stream.mapToInt или .mapToDouble(преобразования типа в  Integer или Double).boxed().ToList();
ВОПРОС 2
Это тоже самое пос скорости работе или какой-то вариант лучше?
1) var list3 =list2.stream().map(Object::toString).map(x-> x+ ".ru").toList();
2) var list4 = list2.stream().map(x-> x+ ".ru").toList();


 */


 /* var result = employeeList.stream().map(getFullSalary).peek(x->{
            count.getAndIncrement();
            System.out.println("Salary [" +count.get()+ "] :" + x);
        }).reduce(Double::sum).orElse(-1.0);*/


//just for check
        /*Double sum = 0.0;
        var lits = employeeList.stream().map(getFullSalary).toList();
        for (var a: lits)
            sum += a;*/


    /*var stream = IntStream.builder()
            .add(13)
            .add(214)
            .add(210124)
            .add(392)
            .build();
    var list2  = stream.boxed().toList();
    Stream<int> stream2 = Stream.of(1,34,346,457,45,7);
    *//*HashSet<Integer> set = new HashSet<>();
    TreeMap<String,Integer> treeMap = new TreeMap<>();*//*
    var list3 =list2.stream().map(Object::toString).map(x-> x+ ".ru").toList();
    var list4 = list2.stream().map(x-> x+ ".ru").toList();
        System.out.println(list3);
                System.out.println("----------------");
                Integer i = 123;
                System.out.println(i+ "ru");*/