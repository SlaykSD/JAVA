package ru.mephi.homeworks.hw3;

import ru.mephi.labs.lab3.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

public final class TableSalary {
    private static  TableSalary instance;
    private final HashMap<Employee,Double> table;
    public static final int minSalary = 12792; //minimum wage in Russia
    public static final int maxSalary = 70000; //max wage in this company
    public static final int premium = 10000; //award company
    private  TableSalary(){
        table = new HashMap<>();
    }
    private TableSalary(HashMap<Employee,Double> table)
    {
       this.table = table;
    }
    public void addEmployee(Employee employee, Double value)
    {
        if(!table.containsKey(employee))
        {
            table.put(employee,value);
        }
    }
    public void removeEmployee(Employee employee)
    {
        table.remove(employee);
    }
    public void changeSalary(Employee employee, Double value)
    {
        if(!table.containsKey(employee))
        {
            table.put(employee,value);
        }
    }
    public void resetSalary()
    {
        table.forEach((x,y)->y = 0.0 );
    }
    public void upSalary(Employee employee, Double value)
    {
        if(!table.containsKey(employee))
        {
            table.put(employee,table.get(employee) + value);
        }
    }
    public static TableSalary getInstance() {
        if (instance == null) {
            instance = new TableSalary();
        }
        return instance;
    }
    public Double getSalary(Employee employee)
    {
        var res= table.get(employee);
        return  res==null?0:res;
    }
    public List<Employee> getEmployees()
    {
        return table.keySet().stream().toList();
    }

    public static Supplier<Double> getRandomSalary() {
        return () -> {
            return TableSalary.minSalary + (Math.random() * (TableSalary.maxSalary - TableSalary.minSalary));
        };
    }

    public void initialisationTable(List<Employee> list, Supplier<Double> randomGenerator){
        for (var a: list)
            addEmployee(a,randomGenerator.get());
    }
}



 /*   private Supplier<Double> getRandomSalary(Employee employee) {
        return () -> {
            var salary = TableSalary.maxSalary;
            salary /= switch (employee.getRole())
                    {
                        case STAFF -> 3;
                        case MANAGER -> 2;
                        case EXECUTIVE -> 1;
                    };
            return TableSalary.minSalary + (Math.random() * (salary - TableSalary.minSalary));
        };
    }*/
