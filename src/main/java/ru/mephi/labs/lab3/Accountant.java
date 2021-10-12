package ru.mephi.labs.lab3;

public class Accountant {
    public void paySalary(Employee employee)
    {
        System.out.println("ЗП получил:" + employee);
    }
    public void payPremium(Employee employee)
    {
        System.out.println("Премию получил: "+ employee);
    }
}
