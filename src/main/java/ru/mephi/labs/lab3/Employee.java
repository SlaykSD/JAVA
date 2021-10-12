package ru.mephi.labs.lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Необходимо релизовать простого бота для выдачи зарплаты сотрудникам:
 class Employee с полями: givenName, surName, age, gender
 (enum MALE, FEMALE), role(enum STAFF, MANAGER, EXECUTIVE), dept, eMail,
 phone,	address, city, state (область), code (код области);
Реализовать паттерн builder (нельзя использовать lombok)
Переопределить toString()
Реализовать метод public static List<Employee> createShortList() - создает список сотрудников и заполняет
его различными сотрдниками не менее 7 (Экземплярами класса Employee). Значения полей должны быть разнообразны.

 */
//Вопрос про что такое код области что такое dept нужно ли их делать как стринг?
public class Employee {
    private String givenName;
    private String surName;
    private Integer age;
    private Gender gender;
    private Role role;
    private String dept;
    private String eMail;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String code;

    public static class Builder{
        private String givenName;
        private String surName;
        private Integer age = 0;
        private Gender gender ;
        private Role role;
        private String dept = "";
        private String eMail;
        private String phone;
        private String address = "Moscow";
        private String city = "Moscow";
        private String state ="";
        private String code ="";

        public Builder givenName(String val)
        {
            givenName=val;
            return  this;
        }
        public Builder surName (String val)
        {
            surName=val;
            return  this;
        }
        public Builder age (Integer val)
        {
            age=val;
            return  this;
        }
        public Builder gender (Gender val)
        {
            gender=val;
            return  this;
        }
        public Builder role (Role val)
        {
            role=val;
            return  this;
        }
        public Builder dept (String val)
        {
            dept=val;
            return  this;
        }
        public Builder eMail (String val)
        {
            eMail=val;
            return  this;
        }

        public Builder address (String val)
        {
            address=val;
            return  this;
        }
        public Builder city (String val)
        {
            city=val;
            return  this;
        }
        public Builder phone (String val)
        {
            phone=val;
            return  this;
        }
        public Builder state (String val)
        {
            state=val;
            return  this;
        }
        public Builder code (String val)
        {
            code=val;
            return  this;
        }
        public Employee build() {return new Employee(this);}

    }
    //На всякий если у нас
    //затестить если супер не вызвать сто будет с класом
    private Employee(){super();}
    private Employee(Builder builder)
    {
        givenName = builder.givenName;
        surName = builder.surName;
        age =builder.age ;
        gender=builder.gender;
        role=builder.role;
        dept=builder.dept;
        eMail=builder.eMail;
        phone=builder.phone;
        address=builder.address;
        city=builder.city;
        state=builder.state;
        code=builder.code;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getSurName() {
        return surName;
    }

    public Role getRole() {
        return role;
    }

    public String getDept() {
        return dept;
    }

    public String geteEMail() {
        return eMail;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCode() {
        return code;
    }
    public static List<Employee> createShortList()
    {
        List<Employee> list = new ArrayList<>();
        Collections.addAll(list,
                new Builder()
                        .givenName("Petya")
                        .surName("Krapinikov")
                        .age(18)
                        .gender(Gender.MALE)
                        .role(Role.STAFF)
                        .address("s.Pushkino h.Kaltuskino")
                        .city("Nevozmozhaysk")
                        .eMail("agent007@pupkin.com")
                        .code("0543")
                        .state("RU")
                        .dept("PA")
                        .phone("880553535")
                        .build()
                ,
                new Builder()
                        .givenName("Vasya")
                        .surName("Black")
                        .age(21)
                        .gender(Gender.MALE)
                        .role(Role.MANAGER)
                        .address("Yaroslavl")
                        .city("Yaroslavl")
                        .eMail("vasay@online.com")
                        .code("0223")
                        .state("RU")
                        .dept("PA")
                        .phone("880553536")
                        .build()
                ,
                new Builder()
                        .givenName("Germiona")
                        .surName("Grendger")
                        .age(20)
                        .gender(Gender.FEMALE)
                        .role(Role.MANAGER)
                        .address("United Kingdom")
                        .city("London")
                        .eMail("germionarulit@hogvards.com")
                        .code("8654")
                        .state("UK")
                        .dept("PA")
                        .phone("1365444335")
                        .build()
                ,
                new Builder()
                        .givenName("Conor")
                        .surName("McGregor")
                        .age(32)
                        .gender(Gender.MALE)
                        .role(Role.EXECUTIVE)
                        .address("USA, New York")
                        .city("New York")
                        .eMail("conor@ufc.com")
                        .code("1223")
                        .state("USA")
                        .dept("IT")
                        .phone("4805134652")
                        .build()
                ,
                new Builder()
                        .givenName("Korone")
                        .surName("Inugami")
                        .age(16)
                        .gender(Gender.FEMALE)
                        .role(Role.STAFF)
                        .address("Japan, Tokio")
                        .city("Japan")
                        .eMail("vasay@online.com")
                        .code("0223")
                        .state("JP")
                        .dept("IT")
                        .phone("2242463")
                        .build()
                ,
                new Builder()
                        .givenName("Gordon")
                        .surName("Friedman")
                        .age(50)
                        .gender(Gender.MALE)
                        .role(Role.EXECUTIVE)
                        .address("United Kingdom")
                        .city("Manchester")
                        .eMail("gordfree@gkoil.com")
                        .code("5742")
                        .state("UK")
                        .dept("IT")
                        .phone("125236346")
                        .build()
                ,
                new Builder()
                        .givenName("Georg")
                        .surName("Stalin")
                        .age(25)
                        .gender(Gender.MALE)
                        .role(Role.STAFF)
                        .eMail("georg@mehpi.cu")
                        .code("0235")
                        .state("RU")
                        .dept("IT")
                        .phone("8805563536")
                        .build()
                ,
                new Builder()
                        .givenName("Gura")
                        .surName("Gawr")
                        .age(9654)
                        .gender(Gender.FEMALE)
                        .role(Role.EXECUTIVE)
                        .address("Japan, Kyoto")
                        .city("Kyoto")
                        .eMail("gawrgura@shrimp.com")
                        .code("0003")
                        .state("JP")
                        .dept("Cooking shrimp")
                        .phone("266326")
                        .build()

        );
        return list;
    }

    @Override
    public String toString() {
        return "\n  Employee{" +
                "givenName='" + givenName + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", role=" + (role.getInterestRate()*100)+"%"+
                ", dept='" + dept + '\'' +
                ", eMail='" + eMail + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Employee e = new Builder()
                .age(123)
                .city("home")
                .code("asf")
                .build();

    }
}