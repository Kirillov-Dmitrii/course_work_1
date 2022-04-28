package com.skypro.employee;

//имплементируем интерфейс Comperable для реализации функционала сравнения полей объектов
public class Employee implements Comparable {
    private String fullName;
    private int department;
    private int salary;
    private int id;
    private static int couter = 0;


    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = couter++;
    }

    public String getFullName() {
        return fullName;
    }


    public void setDepartment(int department) {
        this.department = department;
    }

    public int getDepartment() {
        return department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public static int getCouter() {
        return couter;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }

    //перезагружаем метод
    @Override
    public int compareTo(Object obj) {
        Employee emp = (Employee) obj;
        if (this.department < emp.department) {
            //текущее значение меньше полученного
            return -1;
        }
        else if (this.department > emp.department) {
            //текущее занчение больше полученного
            return 1;
        }
        //текущее значение равно полученному
        return 0;
    }

}
