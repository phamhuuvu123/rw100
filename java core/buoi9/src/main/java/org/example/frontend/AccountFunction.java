package org.example.frontend;

import org.example.backend.controller.Accountcontroller;
import org.example.backend.controller.Departmentcontroller;
import org.example.backend.controller.Positioncontroller;
import org.example.entity.Account;
import org.example.entity.DePartment;
import org.example.entity.Position;
import org.example.utlis.ScannerUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class    AccountFunction {
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
            System.out.println("6. import tu file ");
            System.out.println("7. Thoát");

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
                 this.impotrAccountFromCSV();
                    break;
                case "7":
                    return;
                default:
                    System.out.println("Chọn sai, chọn lại!");
            }
        }
    }
    public  void impotrAccountFromCSV()
    {
        System.out.println("===import file CSV===");
        System.out.println("nhâp đường dẫn file ");
        String pathname=scanner.nextLine();
        String mesege = accountcontroller.importAccountFromCSV(pathname);
        //C:\Users\HP\Desktop\rw100\csv\input_account.cvs.csv
        System.out.println(mesege);

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
        String fullname;
        String username;
        String email ;
        int idDe;
        int idPo;

           while (true)
            {
            System.out.println(" nhập username ");
                username= ScannerUtils.inputstring();
            if (accountcontroller.checkUsername(username)) {
                System.out.println("nhập lại uesername");
                continue;
            } break;
            }
            while (true) {
                System.out.println(" nhập fullname ");
                fullname = ScannerUtils.inputstring();
                break;
            }
            while (true) {
                System.out.println("Nhập tên Email: ");
                email =ScannerUtils.inputEmail();
                if (accountcontroller.checkEmail(email)) {
                    System.out.println("email đã tồn tại nhập lại ");
                    continue;
                }
                break;
            }
            List<DePartment> dePartments = departmentcontroller.findAll();

            while (true) {
                for(DePartment dep :dePartments)
                {
                    System.out.println(dep.getId() +"  "+dep.getName());;
                }
                System.out.println("nhâp iD department");
                idDe = ScannerUtils.inputInt();

                if ( !departmentcontroller.checkExitsId(idDe)) {
                    System.out.println("nhập lại Idde");
                    continue;
                }break;
            }
            List<Position> positions =positioncontroller.findAll();

            while (true)
            {   for (Position position:positions)
            {
                System.out.println(position.getId()+"  "+position.getName().name());
            }
                System.out.println("nhập Id position ");
                idPo=ScannerUtils.inputInt();
            if(! positioncontroller.checkExit(idPo))
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

        int id ;
        String name ;
        while (true)

        {    System.out.println("Nhập ID acount cần sửa: ");
            id=ScannerUtils.inputIntgreatThenZero();
            System.out.println("Nhập tên username cần sửa: ");
            name =ScannerUtils.inputstring();
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
        int id;
        while ( true)
        {
            System.out.println("Nhập ID Account cần xóa: ");
         id=ScannerUtils.inputIntgreatThenZero();
            if(!accountcontroller.checkId(id))
            {
                System.out.println("id không tồn tại");
            }else {
                break;
            }
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
