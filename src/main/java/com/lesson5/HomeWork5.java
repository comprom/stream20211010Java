package com.lesson5;

public class HomeWork5 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Ivan",  "Ivanov", "Engineer", "ivanov@galera.com", "892312323", 10000, 35);
        employees[1] = new Employee("Sergei",  "Sergeev", "CEO", "sergeev@galera.com", "892345678", 1000000, 55);
        employees[2] = new Employee("Oleg",  "Olegov", "CTO", "iolegov@galera.com", "892312345", 100000, 45);
        employees[3] = new Employee("Olga",  "Olgova", "HR", "olgova@galera.com", "892323456", 50000, 30);
        employees[4] = new Employee("Rita",  "Ritova", "Recruter", "ritova@galera.com", "892345667", 40000, 20);

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                employee.viewInformation();
            }
        }
    }
}
