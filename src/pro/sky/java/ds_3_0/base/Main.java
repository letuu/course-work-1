package pro.sky.java.ds_3_0.base;

public class Main {
    static int staff;
    static  Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        // Программа по учету сотрудников

//        Employee ivanov = new Employee("Иванов Иван Иванович", 1, 10000, 5);
        addEmployee("Ivanov1 Ivan Ivanovich", 1, 10_000);
        addEmployee("Ivanov2 Ivan Ivanovich", 2, 9_000);
        addEmployee("Ivanov3 Ivan Ivanovich", 3, 30_000);
        addEmployee("Ivanov4 Ivan Ivanovich", 4, 110_000);
        addEmployee("Ivanov5 Ivan Ivanovich", 5, 50_000);
        addEmployee("Ivanov6 Ivan Ivanovich", 1, 110_000);
        addEmployee("Ivanov7 Ivan Ivanovich", 2, 9_000);

        System.out.println("Всего в штате " + staff + " сотрудников");
        System.out.println();
        printAllEmployees();  //Список всех сотрудников
        System.out.println();
        printAllFullName();  //ФИО всех сотрудников
        System.out.println();
        System.out.println("Сумма затрат на зарплаты в месяц составляет " + calcAmountSalaries() + " рублей"); //возвращает сумму
        System.out.println();
        System.out.println(calcAverageSalary());  //В методе сформирована строка со средней зарплатой для печати
        System.out.println();
        System.out.println(calcMinSalary());  //В методе сформирована строка с сотрудниками с минимальной зарплатой
        System.out.println();
        System.out.println(calcMaxSalary());  //В методе сформирована строка с сотрудниками с максимальной зарплатой
        System.out.println();

        Employee ivanov3 = employees[2];
        System.out.println(ivanov3);
        ivanov3.setDepartment(5);
        ivanov3.setSalary(70_000);
        System.out.println(ivanov3);
    }

    public static void addEmployee(String fullName, int department, int salary) {
        if (staff >= employees.length) {
            System.out.println("Штат сотрудников заполнен, запись новых сотрудников невозможна");
        }
        Employee newEmployee = new Employee(fullName, department, salary, staff + 1);
        employees[staff++] = newEmployee;
    }

    public static void printAllEmployees() {
        for (int i = 0; i < staff; i++) {
            Employee employee = employees[i];
            System.out.println(employee);
        }
    }

    public static void printAllFullName() {
        for (int i = 0; i < staff; i++) {
            System.out.println(employees[i].getFullName());
        }
    }

    public static int calcAmountSalaries() {
        int amountSalaries = 0;
        for (int i = 0; i < staff; i++) {
            amountSalaries = amountSalaries + employees[i].getSalary();
        }
        return amountSalaries;
    }

    public static String calcAverageSalary() {
//        String averageSalary = String.format("%.2f", (double) calcAmountSalaries()/ staff);
        double averageSalary = (double) calcAmountSalaries()/ staff;
        return String.format("Среднее значение зарплат составляет %.2f рублей", averageSalary);
    }

    public static String calcMinSalary() {
        int minSalary = -1;
        String minSalaryFullName = null;
        for (int i = 0; i < staff; i++) {
            if (minSalary == -1) {
                minSalary = employees[i].getSalary();
                minSalaryFullName = employees[i].getFullName();
            }
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
        String printMinSalary = String.format("Минимальная зарплата %s у сотрудников: %s", minSalary, minSalaryFullName);
        System.out.println(minSalaryFullName);
        return printMinSalary;
    }

    public static String calcMaxSalary() {
        int maxSalary = -1;
        StringBuilder maxSalaryFullName = null;
        for (int i = 0; i < staff; i++) {
            if (maxSalary == -1) {
                maxSalary = employees[i].getSalary();
                maxSalaryFullName = new StringBuilder(employees[i].getFullName());
            }
            if (employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                maxSalaryFullName = new StringBuilder(employees[i].getFullName());
                continue;
            }
            if (employees[i].getSalary() == maxSalary) {
                maxSalaryFullName.append("; ").append(employees[i].getFullName());
            }
        }
        String printMaxSalary = String.format("Максимальная зарплата %s у сотрудников: %s", maxSalary, maxSalaryFullName);
        System.out.println(maxSalaryFullName);
        return printMaxSalary;
    }
}
