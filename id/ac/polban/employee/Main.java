package id.ac.polban.employee;

// Import semua package yang dibutuhkan
import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.*;

public class Main {
    public static void main(String[] args) {
        // 1. Buat Objek Department & Type (Independent Objects)
        Department deptIT = new Department("IT Department");
        Department deptHR = new Department("Human Resources");
        
        EmploymentType typeFullTime = new EmploymentType("Full-Time");
        EmploymentType typeContract = new EmploymentType("Contract");

        // 2. Buat Objek Employee (Menggabungkan/Aggregation objek di atas)
        Employee emp1 = new Employee(101, "Arya Nata", deptIT, typeFullTime, 5000000);
        Employee emp2 = new Employee(102, "Budi", deptHR, typeContract, 4000000);

        // 3. Masukkan ke Service
        EmployeeService service = new EmployeeService();
        service.addEmployee(emp1);
        service.addEmployee(emp2);

        System.out.println("=== DATA KARYAWAN AWAL ===");
        emp1.printInfo();
        emp2.printInfo();
        
        // Memanggil Static Method
        System.out.println("\nTotal Karyawan Terdaftar: " + Employee.getTotalEmployees());

        System.out.println("\n=== SIMULASI NAIK GAJI (10% untuk Arya) ===");
        service.raiseSalary(101, 10); // Naikkan gaji emp1 sebesar 10%
        
        service.getEmployee(101).printInfo(); // Print ulang data Arya
    }
}