package id.ac.polban.employee.model;

public class Employee {
    private int id;
    private String name;
    private Department department; // Contoh relasi AGGREGATION
    private EmploymentType type;   // Contoh relasi AGGREGATION
    private double salary;

    // IMPLEMENTASI STATIC FIELD
    private static int totalEmployees = 0; 

    public Employee(int id, String name, Department department, EmploymentType type, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.type = type;
        this.salary = salary;
        
        totalEmployees++; // Setiap objek dibuat, total bertambah
    }

    // IMPLEMENTASI STATIC METHOD
    public static int getTotalEmployees() {
        return totalEmployees;
    }

    // Method tambahan untuk print info
    public void printInfo() {
        System.out.println("ID: " + id + " | Name: " + name + 
                           " | Dept: " + department.getName() + 
                           " | Type: " + type.getType() + 
                           " | Salary: Rp" + salary);
    }

    // Getter dan Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
    public EmploymentType getType() { return type; }
    public void setType(EmploymentType type) { this.type = type; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}