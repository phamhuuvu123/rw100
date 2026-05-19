package org.example.frontend;

import org.example.backend.controller.Accountcontroller;
import org.example.backend.controller.Departmentcontroller;
import org.example.backend.controller.Positioncontroller;
import org.example.entity.Account;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AccountFunction {
    private static Scanner scanner = new Scanner(System.in);
    private static  Accountcontroller accountcontroller = new Accountcontroller();
    private static Departmentcontroller departmentcontroller =new Departmentcontroller();
    private  static Positioncontroller positioncontroller = new Positioncontroller();
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
        String email = scanner.nextLine();
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
        while (true)
        {
            if(Objects.isNull(username)||username.trim().isEmpty())
            {
                System.out.println("nhập lại uesername ");
                continue;
            }
            if(accountcontroller.check(username,null,null,null,null))
            {
                System.out.println("nhập lại uesername");
                continue;
            }
            if(Objects.isNull(fullname)||fullname.trim().isEmpty())
            {
                System.out.println("nhập lại full name");
                continue;
            }
            if(accountcontroller.check(username,fullname,null,null,null))
            {
                System.out.println("nhập lại full name tên đã tồn tại ");
            }
            if(Objects.isNull(email)||email.trim().isEmpty())
            {
                System.out.println("nhập lại email");
                continue;
            }
            int index =email.indexOf('@');
            if(index!=-1)
            {
                System.out.println("email hợp lệ");
            }
            else {
                System.out.println("nhập lại email");
                continue;
            }
            if(accountcontroller.check(username,fullname,email,null,null))
            {
                System.out.println("email đã tồn tại nhập lại ");
                continue;
            }
            if(idDe<0|| departmentcontroller.checkExitsId(idDe) )
            {
                System.out.println("nhập lại Idde");
                continue;
            }
            if(idPo<0|| positioncontroller.checkExit(idPo))
            {
                System.out.println("nhập lại IdPo");
                continue;
            }
            break;
        }
        boolean check = accountcontroller.createAccount(email,username,fullname,idDe,idPo);
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
        String name ="";
        while (true)
        {
            name =scanner.nextLine();
            if(id<0)
            {
                System.out.println("nhập lại id không hợp lệ");
                continue;
            }
            if(accountcontroller.checkExitIdAndName(name,id))
            {
                System.out.println("tên này đã được su dung nhập lại ");
                continue;
            }
            break;
        }
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
        while ( true)
        {
            if(id<0)
            {
                System.out.println("id không phải được sô âm nhập lại");
                continue;
            }
            if(accountcontroller.checkId(id))
            {
                System.out.println("id không tồn tại");
                continue;
            }
            break;
        }
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
