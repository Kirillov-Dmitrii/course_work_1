package com.skypro;

import com.skypro.employee.Employee;

import java.awt.*;

public class Main {
    static Employee [] db = new Employee[10];

    public static void main(String[] args) {
        //создаем объекта класса Employee
        Employee liza = new Employee("Кириллова Елизавета Андреевна", 1, 2000);
        Employee dima = new Employee("Кириллов Дмитрий Алексеевич", 2, 70000);
        Employee lola = new Employee("Лола Лига Легендовна", 5, 5000);

        //записываем объекты в массив
        db[0] = liza;
        db[1] = dima;
        db[3] = lola;

        //вызываем методы
//        allEmployeeInfo(db);
//        salarySpending(db);
//        minSalaryEmployee(db);
//        maxSalaryEmployee(db);
//        averageSalarySpending(db);
        allEmployeeFullNames(db);
    }
    //метод выводит список всех сотрудников
    static void allEmployeeInfo(Employee [] arr) {
        arr.toString();
        for (Employee employee : arr) {
            System.out.println("ФИО = " + employee.getFullName());
            System.out.println("Отдел = " + employee.getDepartment());
            System.out.println("Зарплата = " + employee.getSalary());
            System.out.println("Id = " + employee.getId());
            System.out.println("----------------------------------");
        }
    }

    //метод выводит сумму затрат на зарплаты
    static void salarySpending(Employee [] arr) {
        int money = 0;

        for (Employee employee : arr) {
            if (employee == null)
                break;

            money += employee.getSalary();
        }

        System.out.println("Сумма затрат на зарплаты в  месяц составляет - " + money);
    }

    //метод выводит минимальную зп
    static void minSalaryEmployee(Employee [] arr) {
        int minSalary = arr[0].getSalary();

        for (Employee employee : arr) {

            if (employee != null && employee.getSalary() < minSalary)
                minSalary = employee.getSalary();

        }

        System.out.println("Минимальная зарплата составляет - " + minSalary);
    }

    //метод выводит максимальную зп
    static void maxSalaryEmployee(Employee [] arr) {
        int maxSalary = arr[0].getSalary();

        for (Employee employee : arr) {

            if (employee != null && employee.getSalary() > maxSalary)
                maxSalary = employee.getSalary();

        }

        System.out.println("Максимальная зарплата составляет - " + maxSalary);
    }

    //метод выводит среднее значение зп
    static void averageSalarySpending(Employee [] arr) {
        int money = 0;
        int counter = 0;
        int averageSalary;

        for (Employee employee : arr) {

            if (employee != null) {

                money += employee.getSalary();
                counter++;

            }

        }

        averageSalary = money / counter;

        System.out.println("Среднее значение зп - " + averageSalary);
    }

    //метод выводит все именв сотрудников
    static void allEmployeeFullNames(Employee [] arr) {
        System.out.println("Имена сотрудников: ");

        for (Employee employee : arr) {
            if(employee != null)
                System.out.println(" - " + employee.getFullName());
        }
    }

}
