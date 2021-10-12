package ru.mephi.labs.lab3;


/**
 * The class implements laboratory work 3.
 * In this lab my skills on working with streams, filters and pattern builder were showed.
 */
public class Task {
    /**
     * As part of this function, a premium is given to girls
     */
    public static void Task1(){
        System.out.println("\nВыплата премии женщинам сотрудникам:");
        var list = Employee.createShortList();
        list.stream().filter(p -> p.getGender().equals(Gender.FEMALE)).forEach(employee -> new Accountant().payPremium(employee));
    }

    /**
     * In this function, employees of a particular department receive a salary
     */
    public static void Task2(){
        System.out.println("\nВыплата зарплаты сотрудникам определенного департамента:");
        var list = Employee.createShortList();
        list.stream().filter(p -> p.getDept().equals("IT")).forEach(employee -> new Accountant().paySalary(employee));
    }
    /**
     * This function pays a premium to employees over 30 who work in a particular department
     */
    public static void Task3(){
        System.out.println("\nВыплата премии сотрудникам старше 30, работающим в определенном департаменте:");
        var list = Employee.createShortList();
        list.stream().
                filter(p -> (p.getDept().equals("IT") && p.getAge()>30))
                .forEach(employee -> new Accountant().payPremium(employee));
    }

    /**
     * This function pays the managers' salaries
     */
    public static void Task4(){
        System.out.println("\nВыплата зарплаты менеджерам:");
        var list = Employee.createShortList();
        list.stream().filter(p -> p.getRole().equals(Role.MANAGER)).forEach(employee -> new Accountant().paySalary(employee));
    }

    /**
     * In this function, a premium is paid to the Staff
     */
    public static void Task5(){
        System.out.println("\nВыплата премии стаффу:");
        var list = Employee.createShortList();
        list.stream().filter(p -> p.getRole().equals(Role.STAFF)).forEach(employee -> new Accountant().payPremium(employee));
    }

    public static void main(String[] args) {
        Task1();
        Task2();
        Task3();
        Task4();
        Task5();
    }
}
