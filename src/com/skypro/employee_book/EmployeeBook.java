package com.skypro.employee_book;

import com.skypro.employee.Employee;
import java.util.Arrays;
import java.util.Comparator;

public class EmployeeBook {
    private Employee[] arr = new Employee[10];

    //метод добавляет нового сотрудника
    public void addEmployee (String fullName, int department, int salary) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = new Employee(fullName, department, salary);
                break;
            }
        }
    }

    //метод ищет сотрудника по имени и удаляет его их массива
    public void deleteEmployee(String fullName) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].getFullName().equals(fullName)) {
                arr[i] = null;
                break;
            }
        }
    }

    //метод изменяет зарплату сотрудника
    public void changeSalary(String fullName, int newSalary) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].getFullName().equals(fullName)) {
                arr[i].setSalary(newSalary);
                break;
            }
        }
    }
    
    //метод ищет сотрудника по имени и меняет номер отдела
    public void changeDepartment(String fullName, int newDepartment) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].getFullName().equals(fullName)) {
                arr[i].setDepartment(newDepartment);
                break;
            }
        }
    }

    //метод выводит в консоль всех сотрудников по отделам
    public void allEmployeePerDeparment() {
        //сортируем массив по null и по значению депортамента
        Arrays.sort(arr, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(o1 == null && o2 == null)
                    return 0;
                else if(o1 == null)
                    return 1;
                else if(o2 == null)
                    return -1;

                return o1.compareTo(o2);
            }
        });

        //выводит в консоль первый отдел
        System.out.println("Cотрудники отдела №" + arr[0].getDepartment());

        for (int i = 0; i < arr.length; i++) {

            if (arr[i + 1] == null) {
                System.out.println(arr[i].getFullName());
                break;
            }
            else if (arr[i].getDepartment() == arr[i + 1].getDepartment())
                System.out.println(arr[i].getFullName());
            else if (arr[i].getDepartment() != arr[i + 1].getDepartment() && arr[i + 1] != null) {
                System.out.println(arr[i].getFullName());
                System.out.println("Сотрудники отдела №" + arr[i + 1].getDepartment());
            }
        }
    }

    //метод выводит список всех сотрудников
    public void allEmployeeInfo() {
        for (Employee employee : arr) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
    }

    //метод выводит сумму затрат на зарплаты
    public void salarySpending(Employee [] arr) {
        int money = 0;

        for (Employee employee : arr) {
            if (employee == null)
                break;

            money += employee.getSalary();
        }

        System.out.println("Сумма затрат на зарплаты в  месяц составляет - " + money);
    }

    //метод выводит минимальную зп
    public void minSalaryEmployee(Employee [] arr) {
        int minSalary = arr[0].getSalary();

        for (Employee employee : arr) {

            if (employee != null && employee.getSalary() < minSalary)
                minSalary = employee.getSalary();

        }

        System.out.println("Минимальная зарплата составляет - " + minSalary);
    }

    //метод выводит максимальную зп
    public void maxSalaryEmployee(Employee [] arr) {
        int maxSalary = arr[0].getSalary();

        for (Employee employee : arr) {

            if (employee != null && employee.getSalary() > maxSalary)
                maxSalary = employee.getSalary();

        }

        System.out.println("Максимальная зарплата составляет - " + maxSalary);
    }

    //метод выводит среднее значение зп
    public void averageSalarySpending(Employee [] arr) {
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
    public void allEmployeeFullNames(Employee [] arr) {
        System.out.println("Имена сотрудников: ");

        for (Employee employee : arr) {
            if(employee != null)
                System.out.println(" - " + employee.getFullName());
        }
    }

    //метод индексирует зарплату
    public void salaryIndexer(Employee [] arr, double index) {
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
    public void sixMethods(Employee [] arr, int depart, double index) {

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
    public void compareSalary(Employee [] arr, int salary) {

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
