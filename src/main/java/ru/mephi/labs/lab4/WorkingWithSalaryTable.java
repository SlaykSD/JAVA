package ru.mephi.labs.lab4;

import ru.mephi.homeworks.hw3.TableSalary;
import ru.mephi.labs.lab3.Employee;

import java.util.List;

public abstract class WorkingWithSalaryTable {
    protected  List<Employee> employeeList;
    public WorkingWithSalaryTable(List<Employee> employeeList) {
        this.employeeList = employeeList;
        createNewSalaryTable();
    }
    private void createNewSalaryTable(){
        TableSalary tableSalary = TableSalary.getInstance();
        tableSalary.initialisationTable(employeeList,TableSalary.getRandomSalary());
    }
    public abstract void doAction() throws InterruptedException;
}
