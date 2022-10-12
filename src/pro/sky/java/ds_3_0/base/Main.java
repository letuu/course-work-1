package pro.sky.java.ds_3_0.base;

public class Main {
    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        // Программа по учету сотрудников

//        Employee ivanov = new Employee("Иванов Иван Иванович", 1, 10000, 5);
        addEmployee("Ivanov1 Ivan Ivanovich", 1, 9_000);
        addEmployee("Ivanov2 Ivan Ivanovich", 2, 9_000);
        addEmployee("Ivanov3 Ivan Ivanovich", 3, 30_000);
        addEmployee("Ivanov4 Ivan Ivanovich", 4, 110_000);
        addEmployee("Ivanov5 Ivan Ivanovich", 5, 50_000);
        addEmployee("Ivanov6 Ivan Ivanovich", 1, 110_000);
        addEmployee("Ivanov7 Ivan Ivanovich", 2, 9_000);

        System.out.println("Всего в штате " + Employee.counter + " сотрудников");
        System.out.println();
        printAllEmployees();  //Список всех сотрудников (вывод в консоль)
        System.out.println();
        printAllFullName();  //ФИО всех сотрудников (вывод в консоль)
        System.out.println();
        System.out.println("Сумма затрат на зарплаты в месяц составляет " + calcAmountSalaries() + " рублей");
        System.out.println();
        System.out.printf("Среднее значение зарплат составляет %.2f рублей", calcAverageSalary());
        System.out.println("\n");
        System.out.println(findEmployeeMinSalary());  //Сотрудники XX с минимальной зарплатой Y
        System.out.println();
        System.out.println(findEmployeeMaxSalary());  //Сотрудники XX с максимальной зарплатой Y
        System.out.println();

        //Проверка записи новых значений полей департамента и зарплаты
        Employee ivanov3 = employees[2];
        System.out.println(ivanov3);
        ivanov3.setDepartment(5);
        ivanov3.setSalary(70_000);
        System.out.println(ivanov3);
    }

    public static void addEmployee(String fullName, int department, int salary) {
        if (Employee.counter >= employees.length) {
            System.out.println("Штат сотрудников заполнен, запись новых сотрудников невозможна");
        }
        Employee newEmployee = new Employee(fullName, department, salary);
        employees[Employee.counter - 1] = newEmployee;
    }

    public static void printAllEmployees() {
        for (int i = 0; i < Employee.counter; i++) {
            Employee employee = employees[i];
            System.out.println(employee);
        }
    }

    public static void printAllFullName() {
        for (int i = 0; i < Employee.counter; i++) {
            System.out.println(employees[i].getFullName());
        }
    }

    public static int calcAmountSalaries() {
        int amountSalaries = 0;
        for (int i = 0; i < Employee.counter; i++) {
            amountSalaries = amountSalaries + employees[i].getSalary();
        }
        return amountSalaries;
    }

    public static double calcAverageSalary() {
        return  (double) calcAmountSalaries()/ Employee.counter;
    }

    public static String findEmployeeMinSalary() {
        int minSalary = employees[0].getSalary();
        String minSalaryFullName = employees[0].getFullName();
        for (int i = 1; i < Employee.counter; i++) {
            if (employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                minSalaryFullName = employees[i].getFullName();
                continue;
            }
            if (employees[i].getSalary() == minSalary) {
                minSalaryFullName = minSalaryFullName + "; " + employees[i].getFullName();
                //конкатенация + здесь в цикле работает, но в след. методе calcMaxSalary() заменил ее на StringBuilder
            }
        }
        return String.format("Сотрудники %s с минимальной зарплатой %s руб", minSalaryFullName, minSalary);
    }

    public static String findEmployeeMaxSalary() {
        int maxSalary = employees[0].getSalary();
        StringBuilder maxSalaryFullName = new StringBuilder(employees[0].getFullName());
        for (int i = 1; i < Employee.counter; i++) {
            if (employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                maxSalaryFullName = new StringBuilder(employees[i].getFullName());
                continue;
            }
            if (employees[i].getSalary() == maxSalary) {
                maxSalaryFullName.append("; ").append(employees[i].getFullName());
            }
        }
        return String.format("Сотрудники %s с максимальной зарплатой %s руб", maxSalaryFullName, maxSalary);
    }
}
