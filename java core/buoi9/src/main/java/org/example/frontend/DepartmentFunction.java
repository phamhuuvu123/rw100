package org.example.frontend;

import org.example.backend.controller.Departmentcontroller;
import org.example.entity.DePartment;

import java.util.List;
import java.util.Scanner;

public class DepartmentFunction {
    private static Scanner scanner =new Scanner(System.in);
    private Departmentcontroller departmentcontroller =new Departmentcontroller();
    public void run()  {

        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Xem ds phòng ban");
            System.out.println("2. Thêm mới phòng ban");
            System.out.println("3. Update phòng ban");
            System.out.println("4. Xóa phòng ban");
            System.out.println("5. Tìm kiếm phòng ban");
            System.out.println("6. Thoát");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    List<DePartment> departments = departmentcontroller.findAll();
                    this.showDepartment(departments);
                    break;
                case "2":
                    this.insertDepartment();
                    break;
                case "3":
                    this.updateDepartment();
                    break;
                case "4":
                    this.deleteDepartment();
                    break;
                case "5":

                    break;
                case "6":
                    return;
                default:
                    System.out.println("Chọn sai, chọn lại!");

            }
        }
    }
    public void showDepartment(List<DePartment> departments) {
        System.out.println("+-----+--------------------+");
        System.out.printf("|%5s|%20s|\n", "ID", "Tên phòng ban");
        System.out.println("+-----+--------------------+");
        for (DePartment department : departments) {
            System.out.printf("|%5s|%20s|\n", department.getId(), department.getName());
        }
        if (departments.size() == 0) {
            System.out.println("Không tìm thấy");
        }
        System.out.println("+-----+--------------------+");
    }
    public  void insertDepartment() {
        System.out.println("Nhập tên phòng ban: ");
        String name = scanner.nextLine();
    boolean check= departmentcontroller.insertDepartment(name);
        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm không thành công");
        }
    }
    public  void deleteDepartment()  {
        System.out.println("Nhập tên phòng ban cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean check = departmentcontroller.deleteDepartment(id);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa không thành công");
        }
    }
    public void updateDepartment() {
        System.out.println("Nhập ID phòng ban cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhập tên phòng ban cần sửa: ");
        String name = scanner.nextLine();
        boolean check = departmentcontroller.updateDepartmetn(id, name);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update không thành công");
        }
    }
}
