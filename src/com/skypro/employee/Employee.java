package com.skypro.employee;

public class Employee {
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

}
