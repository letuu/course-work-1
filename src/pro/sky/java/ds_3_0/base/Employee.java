package pro.sky.java.ds_3_0.base;

public class Employee {

    private final String fullName;
    private int department;
    public int salary;
    private final int id;

    public static int counter = 0;

    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Номер департамента некорректный");
        }
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return id + " : " + fullName + " : " + "dep. " + department + " : " + salary;
    }
}
