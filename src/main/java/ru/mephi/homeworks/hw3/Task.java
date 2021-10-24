package ru.mephi.homeworks.hw3;

import ru.mephi.labs.lab3.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.function.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Для своих реализованных классов Employee в лабораторной работе:
Создать и использовать Consumer Lambda Expression
Создать и использовать Function Lambda Expression
Создать и использовать Supplier Lambda Expression
Создать и использовать BiPredicate Lambda Expression
Кейсы необходимо придумать самостоятельно, главное, чтобы были реализованы данные функциональные интерфейсы
 */
public class Task {
    //1
    public static void changeState(List<Employee> employeeList, String newState) {
        //Interface Consumer gives you an opportunity to realize function void someDo(T)
        Consumer<Employee> changeState = x ->
            x.setState(newState);
        for (var a : employeeList) {
            changeState.accept(a);
        }

    }
    //2
    public static HashMap<String,Double> payroll(List<Employee> list) {
        TableSalary tableSalary = TableSalary.getInstance();

        ToDoubleFunction<Employee> giveAllSalary = x-> tableSalary.getSalary(x) +
                TableSalary.award * (1+x.getRole().getInterestRate());
        Function<Employee,Double> giveSalary= tableSalary::getSalary;

        HashMap<String,Double> payList = new HashMap<>();
        for (var a: list)
        {
            Double award = giveAllSalary.applyAsDouble(a);
            payList.put("\nFull Name: "+ a.getGivenName()+" "+ " "+ a.getSurName()+
                            " Award= "+ (award - giveSalary.apply(a))
                            +", Full Salary",
                    giveAllSalary.applyAsDouble(a) );
        }
        return payList;
    }
    public static boolean checkEmail(String str)
    {
        String pattern = "^[A-Za-z0-9+_.%-]+@(.+)$";
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(str);

        return  matcher.matches();
    }
    //Реализация BiPredicate Lambda Expression
    public static Predicate<Employee> filterByRightEmail() {
        String regex = "^[A-Za-z0-9+_.%-]+@(.+)$";
        BiPredicate<String,String> filterByStrings = (x,y) ->
        {
            //x - word, y - regex
            Pattern pattern = Pattern.compile(y);
            Matcher matcher = pattern.matcher(x);
            return  matcher.matches();
        };
        return  x-> !(filterByStrings.test(x.getEMail(),regex));
    }
    //Реализация Supplier
    public static Supplier<Double> getRandomSalary() {
        return () -> {
            var salary = TableSalary.maxSalary;
            return TableSalary.minSalary + (Math.random() * (salary - TableSalary.minSalary));
        };
    }

    public static void main(String[] args) {
        List<Employee> list = Employee.createShortList();
        TableSalary tableSalary = TableSalary.getInstance();
        tableSalary.initialisationTable(list,getRandomSalary());

        //Check List
        for (var a : list)
            System.out.println(a);
        //Check work consumer
        changeState(list.stream().filter(x -> x.getAge() > 20).toList(), "РА СИ Я");
        System.out.println('\n');
        for (var a : list)
            System.out.println(a);
        //Check work function and supplier
        var payList = payroll(tableSalary.getEmployees());
        System.out.println(payList);

        //Check work BiPredicate
        var filter = filterByRightEmail();
        System.out.println(list.stream().filter(filter).toList());
    }
}
/*
    Function<Employee,Double> getSalary= x->
            salary * (1+ x.getRole().getInterestRate());
    ToDoubleFunction<Employee> getSalaryFix= x->
            salary * (1+ x.getRole().getInterestRate());
    CheckTime(getSalary,getSalaryFix,employee) ;
    double res = getSalaryFix.applyAsDouble(employee);
        return  res;*/
/*
private static void checkTime(Function<Employee,Double> func1, ToDoubleFunction<Employee> func2,  Employee employee)
{
    long start,finish;
    double res;
    start = System.nanoTime();
    res = func2.applyAsDouble(employee);
    finish  = System.nanoTime();
    System.out.println("Time of work 2th function :");
    System.out.println(finish - start);
    start =0;
    finish = 0;
    start = System.nanoTime();
    res = func1.apply(employee);
    finish  = System.nanoTime();
    System.out.println("Time of work 1th function :");
    System.out.println(finish - start);
}*/
