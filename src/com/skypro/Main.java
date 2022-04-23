package com.skypro;

import com.skypro.employee.Employee;

public class Main {
    //массив сотрудников
    static Employee [] db = new Employee[10];

    public static void main(String[] args) {
        //создаем объекта класса Employee
        Employee liza = new Employee("Чистякова Екатерина Андреевна", 1, 20000);
        Employee sasha = new Employee("Гненков Александр Игоревич", 1, 80000);
        Employee dima = new Employee("Кириллов Дмитрий Алексеевич", 2, 70000);
        Employee lola = new Employee("Лола Лига Легендовна", 5, 5000);
        Employee leo = new Employee("Лев Николаевич Толстой", 1, 100000);


        //записываем объекты в массив
        db[0] = liza;
        db[1] = dima;
        db[3] = lola;
        db[2] = leo;
        db[9] = sasha;

        //вызываем методы
        salaryIndexer(db, 10);
        sixMethods(db, 1, 10);
        compareSalary(db, 70000);
    }

    //метод выводит список всех сотрудников
    static void allEmployeeInfo(Employee [] arr) {
        arr.toString();
        for (Employee employee : arr) {
            if (employee != null) {
                System.out.println("ФИО = " + employee.getFullName());
                System.out.println("Отдел = " + employee.getDepartment());
                System.out.println("Зарплата = " + employee.getSalary());
                System.out.println("Id = " + employee.getId());
                System.out.println("----------------------------------");
            }
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

    //метод индексирует зарплату
    static void salaryIndexer(Employee [] arr, double index) {
        index /= 100;
        double indexedSalary = 0;

        for (Employee employee : arr) {
            if (employee != null) {
                indexedSalary = employee.getSalary() * index + employee.getSalary();
                employee.setSalary((int)indexedSalary);
            }
        }
    }

    //метод выводит мин и макс зп, сумму затрат на зп по отделу, средне значение зп по отделу,
    //индексирует зп отдела, выводит данные сотрудников отдела (кроме отдела)
    static void sixMethods(Employee [] arr, int depart, double index) {

        int lengthNewArr = 0;
        int counter = 0;

        //считаем количество сотрудников в отделе
        for (Employee employee : arr) {
            if (employee != null && depart == employee.getDepartment())
                lengthNewArr++;
        }

        //создаем массив с сотрудниками выбранного отдела
        Employee [] newArr = new Employee[lengthNewArr];

        //добавляем сотрудников в новый массив
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && depart == arr[i].getDepartment()) {
                newArr[counter] = arr[i];
                counter++;
            }
        }

        //сотрудник из одела depart с мин зп
        minSalaryEmployee(newArr);
        System.out.println("----------------------------------");


        //сотрудник из одела depart с макс зп
        maxSalaryEmployee(newArr);
        System.out.println("----------------------------------");


        //затраты на зп отдела
        salarySpending(newArr);
        System.out.println("----------------------------------");


        //средняя зп по отделу
        averageSalarySpending(newArr);

        //индексация зарплаты отдела
        salaryIndexer(newArr, index);
        System.out.println("----------------------------------");


        //вся информация о сотрудниках отдела
        for (Employee employee : newArr) {
            if (employee != null) {
                System.out.println("ФИО = " + employee.getFullName());
                System.out.println("Зарплата = " + employee.getSalary());
                System.out.println("Id = " + employee.getId());
                System.out.println("----------------------------------");
            }
        }

    }

    //метода выводит сотрудников с зарплатой меньше/больше(равно) заданного занчения
    static void compareSalary(Employee [] arr, int salary) {

        //зп меньше заданного значения
        System.out.printf("Сотрудники с зарплатой меньше - %s:\n", salary);
        for (Employee employee : arr) {
            if (employee != null && salary > employee.getSalary()) {
                System.out.printf("Id - %s \nФ.И.О - %s \nЗарплата - %s\n", employee.getId(), employee.getFullName(), employee.getSalary());
                System.out.println("----------------------------------");

            }
        }

        System.out.println();

        //зп больше(равно) заданного занчения
        System.out.printf("Сотрудники с зарплатой больше (равно) - %s:\n", salary);
        for (Employee employee : arr) {
            if (employee != null && salary <= employee.getSalary()){
                System.out.printf("Id - %s \nФ.И.О - %s\nЗарплата - %s\n", employee.getId(), employee.getFullName(), employee.getSalary());
                System.out.println("----------------------------------");
            }

        }

    }

}
