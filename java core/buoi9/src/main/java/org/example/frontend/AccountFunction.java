package org.example.frontend;

import org.example.backend.controller.Accountcontroller;
import org.example.entity.Account;

import java.util.List;
import java.util.Scanner;

public class AccountFunction {
    private static Scanner scanner = new Scanner(System.in);
    private static  Accountcontroller accountcontroller = new Accountcontroller();
    public  void run()  {
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Xem danh sach Account");
            System.out.println("2. Thêm mới account");
            System.out.println("3. Update Account ");
            System.out.println("4. Xóa Account");
            System.out.println("5. Tìm kiếm Account ");
            System.out.println("6. Thoát");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    List<Account> accounts  =accountcontroller.findAll();
                   this.showAccount(accounts);
                    break;
                case "2":
                    insertAccout();
                    break;
                case "3":
                    updateaccount();
                    break;
                case "4":
                    deleteAccount();
                    break;
                case "5":
                   findAccoutById();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Chọn sai, chọn lại!");

            }
        }
    }
    public void showAccount(List<Account> Acount) {

        for (Account accounts : Acount) {
            System.out.printf("|%5s|%20s|\n", accounts.getId(),accounts.getUesername(), accounts.getEmail(),accounts.getFullName()
                    ,accounts.getDePartmentname(),accounts.getPositionname());
        }
        if (Acount.size() == 0) {
            System.out.println("Không tìm thấy");
        }

    }
    public  void insertAccout()  {
        System.out.println("Nhập tên Email: ");
        String Email = scanner.nextLine();
        System.out.println(" nhập fullname ");
        String fullname= scanner.nextLine();
        System.out.println("nhập username");
        String username=scanner.nextLine();
        System.out.println("nhâp iD department");
        int idDe=scanner.nextInt();
        scanner.nextLine();
        System.out.println("nhập Id position ");
        int idPo= scanner.nextInt();
        scanner.nextLine();
        boolean check = accountcontroller.createAccount(Email,username,fullname,idDe,idPo);
        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm không thành công");
        }
    }
    public  void updateaccount()  {
        System.out.println("Nhập ID acount cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhập tên username cần sửa: ");
        String name = scanner.nextLine();
        boolean check = accountcontroller.updateAccount(id,name);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update không thành công");
        }
    }
    public void deleteAccount()  {
        System.out.println("Nhập ID Account cần xóa: ");
        int id= scanner.nextInt();
        scanner.nextLine();
        boolean check = accountcontroller.deleteAccount(id);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa không thành công");
        }
    }
    public  void findAccoutById()  {
        System.out.println("Nhập ID cần tìm: ");
        int  id= scanner.nextInt();
        scanner.nextLine();

        List<Account> accounts = accountcontroller.findById(id);
       showAccount(accounts);
    }
}
