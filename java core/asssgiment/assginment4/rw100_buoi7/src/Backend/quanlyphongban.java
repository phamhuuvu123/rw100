package Backend;

import entity.Account;
import entity.DePartment;
import entity.Position;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class quanlyphongban {
    public static void qlpb()
    {
        List<DePartment> dePartments =new ArrayList<>();
        List<Position> positions = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();
        Scanner scanner= new Scanner(System.in);
        while (true){
        System.out.println("--mời nhập chức năng--");
        System.out.println("1: thêm phòng ban");
        System.out.println("2:thêm chức vụ");
        System.out.println("3: thêm account:");
        System.out.println("4:xem danh sách phong ban");
        System.out.println("5:xem chức vụ ");
        System.out.println("6:xem danh sách account ");
        System.out.println("7:tìm kiếm tên theo phòng ban");
        System.out.println("8:tìm kiếm tên theo chức vụ ");
        System.out.println("9:xoá account theo tên ");
        String choose= scanner.nextLine();
        switch (choose) {
            case "1":
                System.out.println("1: thêm phòng ban");
                System.out.println("mời nhập id phòng ban");
                int idDep=scanner.nextInt();
                scanner.nextLine();
                System.out.println("mời nhập tên phòng ban");
                String phongban= scanner.nextLine();
                DePartment dePartment = new DePartment(idDep,phongban);
                dePartments.add(dePartment);
                break;
            case "2":
                System.out.println("2:thêm chức vụ");
                System.out.println("mời nhập id chức vụ");
                int idPo= scanner.nextInt();;
                scanner.nextLine();
                System.out.println("mời nhập tên chức vụ");
                String chucvu=scanner.nextLine();
                Position position = new Position(idPo,chucvu);
                positions.add(position);
                break;
            case "3":

                System.out.println("3: thêm account:");
                System.out.println("nhập id phòng ban");
                int idAcc= scanner.nextInt();
                scanner.nextLine();
                System.out.println("nhập tên ");
                String nameAcc=scanner.nextLine();
                System.out.println("nhập email");
                String nameEmail=scanner.nextLine();
                System.out.println("Nhập tên phòng ban");
                String nameDep=scanner.nextLine();
                DePartment dePartmentnew = new DePartment();
                boolean checkDep =false;
                for (   DePartment dep :dePartments)
                {
                    if(dep.getName().equals(nameDep))
                    {
                        System.out.println("bạn đã thêm acccount vào phòng ban  "+nameDep);
                        checkDep=true;
                        dePartmentnew=dep;
                    }
                }
                if(!checkDep) System.out.println("khong có phòng ban nào tên "+nameDep);
                System.out.println("nhâp tên chức vụ");
                String namePo=scanner.nextLine();
                boolean checkPo=false;
                Position positionnew = new Position();
                for(Position po:positions)
                {
                    if(po.getName().equals(namePo))
                    {
                        System.out.println("bân đã thêm account vào phong ban"+namePo);
                        checkPo=true;
                        po=positionnew;
                    }
                }
                if(!checkPo) System.out.println("không có chức vụ nào tên "+namePo);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.println("mời bạn tạo nhập ngày tạo (dd//mm/yyyy) ");
                String dateString = scanner.nextLine();
                LocalDate date =LocalDate.parse(dateString,formatter);
                Account account = new Account (idAcc,nameAcc,nameEmail,positionnew,dePartmentnew,date);
                break;

            case "4":
                System.out.println("4:xem phòng ban ");
                for( DePartment dep:dePartments)
                {
                    System.out.println(dep.toString());
                }
                break;
            case "5":
                System.out.println("5:xem chức vụ ");
                for(Position po:positions)
                {
                    System.out.println(po.toString());
                }
                break;
            case "6":
                System.out.println("6:xem danh sách account ");
                for(Account acc:accounts)
                {
                    System.out.println(acc.toString());
                }
                break;

            case "7":
                System.out.println("7:tìm kiếm  account tên theo phòng ban");
                System.out.println("mời nhập tên phòng ban ");
                String nameDep1= scanner.nextLine();
                boolean checkAcc =false;
                for (Account acc :accounts)
                {
                   if(acc.getDePartmentname().equals(nameDep1))
                   {
                       System.out.println("accout cần tìm có phong ban là"+acc.getDePartmentname());
                       checkAcc=true;
                   }
                }
                if(checkAcc) System.out.println("không có chức năng nào tồn tại ");
                break;
            case "8":
                System.out.println("8:tìm kiếm tên theo chức vụ ");
                System.out.println("mời tên phòng ban ");
                String namepo= scanner.nextLine();
                for (Account acc :accounts)
                {
                    if(acc.getPositionname().equals(namepo))
                    {
                        System.out.println("account cần tìm có chức năng là "+acc.getPositionname());
                    }
                }
                break;
            case "9":
                System.out.println("9:xoá account theo tên ");
                System.out.println("nhập tên account cần xóa");
                String nameacc=scanner.nextLine();
                boolean checkacc2 = false;
                List<Account> deleteacc1 = new ArrayList<>();

                for (Account acc :accounts)
                {
                    if(acc.getFullName().equals(nameacc))
                    {
                        System.out.println("tên acc cần xóa là "+nameacc);
                        checkacc2=true;
                        deleteacc1.add(acc);
                    }
                }
                if(!checkacc2) System.out.println(" tên accoung không tồn tại");
                accounts.removeAll(deleteacc1);

                break;
            case"10":
                return;
            default:
                System.out.println("moi nhập lại số");
        }
        }
    }
}
