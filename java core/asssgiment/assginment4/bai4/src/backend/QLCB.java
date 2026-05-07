package backend;

import Enums.Gender;
import emipity.CanBo;
import emipity.CongNhan;
import emipity.KySu;
import emipity.NhanVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLCB {
    public static void qlcb()
    {
        Scanner scanner = new Scanner(System.in);
        List<CanBo> Canbos = new ArrayList<>();
        while (true)
        {
            System.out.println("==mời chọn chức năng==");
            System.out.println("1.thêm mới cán bộ");
            System.out.println("2.tìm kiếm theo tên cán bộ");
            System.out.println("3.hiển thị thông tin danh sách cán bộ");
            System.out.println("4.nhập vào tên cán bộ và delete cán bộ");
            System.out.println("5.thoat khỏi chương trình");
            String choose = scanner.nextLine();
            switch (choose)
            {
                case"1":
                    System.out.println("1.thêm mới cán bộ");
                    System.out.println("nhập họ tên ");
                    String fullname =scanner.nextLine();
                    System.out.println("nhap tuổi");
                    int age= scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("nhập địa chỉ");
                    String diachi = scanner.nextLine();
                    System.out.println("mời bạn nhập giới tính 1: nữ , 2 Nam ,3 khác");
                    String gender= scanner.nextLine();
                    Gender gioitinh;
                    switch (gender)
                    {
                        case "1 ": gioitinh=Gender.NU;
                        break;
                        case"2": gioitinh=Gender.NAM;
                        default:
                            gioitinh=Gender.KHAC;
                    }
                    System.out.println("==mời chọn cán bộ==");
                    System.out.println("1.công nhân");
                    System.out.println("2.kỹ sư");
                    System.out.println("3.nhân viên");
                    String CanboChoose =scanner.nextLine();
                    switch (CanboChoose)
                    {
                        case"1":
                            System.out.println("nhâp bâc :");
                            int bac= scanner.nextInt();
                            scanner.nextLine();
                            CanBo CongNhan = new CongNhan(fullname,age,gioitinh,diachi,bac);
                            Canbos.add(CongNhan);
                            System.out.println("da tao thành công");

                            break;
                        case"2":
                            System.out.println("thêm nganh");
                            String nganh=scanner.nextLine();
                            CanBo Kysu = new KySu(fullname,age,gioitinh,diachi,nganh);
                            System.out.println(" đã tạo kỹ sư thành cong");
                            break;
                        case"3":
                            System.out.println("công việc");
                            String congviec=scanner.nextLine();
                            CanBo  Nhanvien=new NhanVien(fullname,age,gioitinh,diachi,congviec);
                            System.out.println("đã tọa nhân viên thành công");
                            break;

                    }
                    break;
                case"2":
                    System.out.println("2.tìm kiếm theo tên cán bộ");
                    String name=scanner.nextLine();
                    boolean checkExist =false;
                    for(CanBo c:Canbos.toArray(new CanBo[0]))
                    {

                        if(c.getName().equals(name)) {
                            checkExist = true;
                            System.out.println(c.getName());
                        }
                    }
                    if(!checkExist)
                    {
                        System.out.println("tên này không có trong hệ thống");
                    }
                    break;
                case"3":
                    System.out.println("3.hiển thị thông tin danh sách cán bộ");
                    for (CanBo c: Canbos)
                {
                    System.out.println(c.toString());
                }
                    break;
                case"4":
                    List<CanBo> deletes=new ArrayList<>();

                    System.out.println("2.tìm kiếm theo tên cán bộ");
                    String deletename=scanner.nextLine();
                    for(CanBo c:Canbos)
                    {

                        if(c.getName().equals(deletename)) {
                            deletes.add(c);
                        }
                    }

                  boolean checkDelete =  Canbos.removeAll(deletes);
                    System.out.println("đã xóa thành công !!");
                    break;
                case"5":
                    System.out.println("5.thoat khỏi chương trình");
                    break;
                default:
            }
        }
    }
}
