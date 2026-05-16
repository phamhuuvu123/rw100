package org.example.frontend;
import org.example.backend.controller.Positioncontroller;
import org.example.entity.Position;

import java.util.List;
import java.util.Scanner;

public class PositionFuncion {
    private static Scanner scanner = new Scanner(System.in);
    private static Positioncontroller positioncontroller = new Positioncontroller();
    public void run()  {

        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Xem ds chức vụ");
            System.out.println("2. Thêm mới chức vụ");
            System.out.println("3. Update chức vụ");
            System.out.println("4. Xóa chức vụ");
            System.out.println("5. Tìm kiếm chức vụ");
            System.out.println("6. Thoát");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    List<Position> positions = positioncontroller.findAll();
                    this.showPosition(positions);
                    break;
                case "2":
                    createPosition();
                    break;
                case "3":
                    updatePosition();
                    break;
                case "4":
                    deletePositon();
                    break;
                case "5":
                    findPositionById();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Chọn sai, chọn lại!");

            }
        }
    }
    public  void findPositionById()  {
        System.out.println("Nhập Id phòng ban cần tìm: ");
        int id = scanner.nextInt();
        scanner.nextLine();
     List<Position> positions =  positioncontroller.findById(id);
        showPosition (positions);
    }
    public  void updatePosition()  {
        System.out.println("Nhập ID chức vụ cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhập tên chức vụ cần sửa: ");
        String name = scanner.nextLine();
        boolean check = positioncontroller.updatePosition(id,name);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update không thành công");
        }
    }
    public void deletePositon()  {
        System.out.println("Nhập Id chức vụ cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean check = positioncontroller.deletePosition(id);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa không thành công");
        }
    }
    public void createPosition()  {
        System.out.println("Nhập tên Chức vụ: ");
        String name = scanner.nextLine();
        boolean check = positioncontroller.createPosition(name);
        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm không thành công");
        }
    }
    public  void showPosition(List<Position> positions) {
        System.out.println("+-----+--------------------+");
        System.out.printf("|%5s|%20s|\n", "ID", "Tên phòng ban");
        System.out.println("+-----+--------------------+");
        for (Position position: positions) {
            System.out.printf("|%5s|%20s|\n",position.getId(),position.getName());
        }

        if (positions.size() == 0) {
            System.out.println("Không tìm thấy");
        }
        System.out.println("+-----+--------------------+");
    }
}
