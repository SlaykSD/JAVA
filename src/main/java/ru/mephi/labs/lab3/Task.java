package ru.mephi.labs.lab3;


import java.util.List;

/**
 * The class implement's laboratory work 3.
 * In this lab my skills on working with streams, filters and pattern builder were showed.
 */

public class Task {
    private static final Accountant accountant = new Accountant();
    /**
     * As part of this function, a premium is given to girls
     */
    public static void task1(List<Employee> list){
        System.out.println("\nВыплата премии женщинам сотрудникам:");
        list.stream().filter(p -> p.getGender().equals(Gender.FEMALE)).forEach(accountant::payPremium);
    }

    /**
     * In this function, employees of a particular department receive a salary
     */
    public static void task2(List<Employee> list){
        System.out.println("\nВыплата зарплаты сотрудникам определенного департамента:");
        list.stream().filter(p -> p.getDept().equals("IT")).forEach(accountant::paySalary);
    }
    /**
     * This function pays a premium to employees over 30 who work in a particular department
     */
    public static void task3(List<Employee> list){
        System.out.println("\nВыплата премии сотрудникам старше 30, работающим в определенном департаменте:");
        list.stream().
                filter(p -> (p.getDept().equals("IT") && p.getAge()>30))
                .forEach(accountant::payPremium);
    }

    /**
     * This function pays the managers' salaries
     */
    public static void task4(List<Employee> list){
        System.out.println("\nВыплата зарплаты менеджерам:");
        list.stream().filter(p -> p.getRole().equals(Role.MANAGER)).forEach(accountant::paySalary);
    }

    /**
     * In this function, a premium is paid to the Staff
     */
    public static void task5(List<Employee> list){
        System.out.println("\nВыплата премии стаффу:");
        list.stream().filter(p -> p.getRole().equals(Role.STAFF)).forEach(accountant::payPremium);
    }

    public static void main(String[] args) {
        var list = Employee.createShortList();
        System.out.println(list);
        task1(list);
        task2(list);
        task3(list);
        task4(list);
        task5(list);
    }
}
