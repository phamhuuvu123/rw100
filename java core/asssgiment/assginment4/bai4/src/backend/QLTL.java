package backend;

import quanlytailieu.Quanlysach;
import quanlytailieu.Tailieu;
import quanlytailieu.TapChi;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLTL {
    public static void qltl()
    {
        List<Tailieu> tailieus =new ArrayList<>();
        Scanner scanner= new Scanner(System.in);
        System.out.println("mời nhập chức năng: ");
        System.out.println("1:thêm mới tài liệu: ");
        System.out.println("2:Xóa tài liệu theo mã");
        System.out.println("3: hiện thị thông tin về tài liệu");
        System.out.println("4:tìm kiếm tài liệu theo loại ");
        System.out.println("5:thoat khỏi chương trình");
        String choose1= scanner.nextLine();
        switch (choose1)
        {
            case"1":
                System.out.println("nhập mã tài liệu");
                String code=scanner.nextLine();
                System.out.println("tên nhà sản xuất ");
                String namensx= scanner.nextLine();
                System.out.println("số phat hành");
                int number= scanner.nextInt();
                scanner.nextLine();
                System.out.println("nhập loại tài liệu 1:sách , 2: tạp chí , 3: báo");
                String tailieu= scanner.nextLine();
                switch (tailieu)
                {
                    case"1" :
                        System.out.println(" nhập tên tác giả");
                        String nametacgia= scanner.nextLine();
                        System.out.println("nhập số trang");
                        int page=scanner.nextInt();
                        scanner.nextLine();
                        Tailieu Sach = new Quanlysach(code,namensx,number,nametacgia,page);
                        tailieus.add(Sach);
                    case"2":
                        System.out.println("nhập số phát hành");
                        int sophathanh= scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("nhập tháng phát hành");
                        int thangphathanh= scanner.nextInt();;
                        scanner.nextLine();
                        Tailieu Tapchi = new TapChi(code,namensx,number,sophathanh,thangphathanh);
                        tailieus.add(Tapchi);
                    case"3":
                        System.out.println("nhập ngày phát hành dd/mm//yyyy");
                        String date=scanner.nextLine();
                        DateTimeFormatter formatter=DateTimeFormatter.ofLocalizedDate()

                }
        }
    }
}
