package Frontendt;

import Backend.QLDepartment;
import Backend.Qlposition;
import entity.DePartment;
import entity.Position;
import enums.Enums;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PositionFunction {
    private static Scanner scanner = new Scanner(System.in);
    public static void run() throws ClassNotFoundException {
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Xem danh sách chức vụ ");
            System.out.println("2. Thêm mới chức vụ ");
            System.out.println("3. Update chức vụ ");
            System.out.println("4. Xóa chức vụ");
            System.out.println("5. Tìm kiếm chức vụ");
            System.out.println("6. Thoát");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":

                    List<Position> positions = Qlposition.showPosition();
                        showPosition(positions);

                    break;
                case "2":
                    insertPosition();
                    break;
                case "3":
                    updatePosition();
                    break;
                case "4":
                    deletePositon();
                    break;
                case "5":
                    findPositionByNameAndId();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Chọn sai, chọn lại!");

            }
        }
    }
    public static void findPositionByNameAndId() throws ClassNotFoundException {
        System.out.println("Nhập tên phòng ban cần tìm: ");
        String name = scanner.nextLine();
        java.util.List<Position> positions = Qlposition.findByPositionName(name);
       showPosition (positions);
    }
    public static void updatePosition() throws ClassNotFoundException {
        System.out.println("Nhập ID chức vụ cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhập tên chức vụ cần sửa: ");
        String name = scanner.nextLine();
        boolean check = Qlposition.updatePosition(id, name);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update không thành công");
        }
    }
    public static void deletePositon() throws ClassNotFoundException {
        System.out.println("Nhập tên chức vụ cần xóa: ");
        String name = scanner.nextLine();
        boolean check = Qlposition.deletePosition(name);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa không thành công");
        }
    }
    public static void insertPosition() throws ClassNotFoundException {
        System.out.println("Nhập tên Chức vụ: ");
        String name = scanner.nextLine();
        boolean check = Qlposition.createPosition(name);
        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm không thành công");
        }
    }
    public static void showPosition(List<Position> positions) {
        System.out.println("+-----+--------------------+");
        System.out.printf("|%5s|%20s|\n", "ID", "Tên phòng ban");
        System.out.println("+-----+--------------------+");
        for (entity.Position position: positions) {
            System.out.printf("|%5s|%20s|\n", position.getId(), position.getName());
        }
        if (positions.size() == 0) {
            System.out.println("Không tìm thấy");
        }
        System.out.println("+-----+--------------------+");
    }
}
