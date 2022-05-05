package com.skypro;

import com.skypro.employee.Employee;
import com.skypro.employee_book.EmployeeBook;

public class Main {
    //массив сотрудников


    public static void main(String[] args) {

        EmployeeBook db = new EmployeeBook();

        //записываем объекты в массив
        db.addEmployee("Чистякова Екатерина Андреевна", 1, 20000);
        db.addEmployee("Чистякова Екатерина Андреевна", 1, 20000);
        db.addEmployee("Гненков Александр Игоревич", 2, 70000);
        db.addEmployee("Гненков Александр Игоревич", 2, 70000);
        db.addEmployee("Лола Лига Легендовна", 3, 5000);
        db.addEmployee("Лола Лига Легендовна", 3, 5000);
        db.addEmployee("Мистер Андерсон", 4, 5000);
        db.addEmployee("Мистер Смит", 5, 5000);
        db.addEmployee("Мистер Смит", 5, 5000);

        //вызываем методы
        db.allEmployeePerDeparment();
//        db.allEmployeeInfo();

    }



}
