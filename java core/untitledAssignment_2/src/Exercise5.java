import java.time.LocalDate;
import java.util.Scanner;

public class Exercise5 {
    public void question1() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {

            System.out.println("nhập số nguyên : " + (i + 1));
            int n = scanner.nextInt();
            System.out.println("số bạn vừa nhập là " + n);
            scanner.nextLine();
        }
    }

    public void question2() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {

            System.out.println("nhập số nguyên : " + (i + 1));
            float n = scanner.nextFloat();
            System.out.println("số bạn vừa nhập là " + n);
            scanner.nextLine();
        }
    }

    public void qustion3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" nhap ho và tên");
        String s1 = scanner.next();
        System.out.println(" ten của bạn " + s1);
    }

    public void question3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("mời nhập ngày sinh");
        System.out.println("nhập năm");
        int year = scanner.nextInt();
        System.out.println("nhập tháng");
        int mm = scanner.nextInt();
        System.out.println("nhập ngày");
        int date = scanner.nextInt();
        LocalDate ngaysinh = LocalDate.of(year, mm, date);
        System.out.println("ngày sinh vừa nhập " + ngaysinh);
    }

    public void question4() {
        Account acc = new Account();
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập id ");
        acc.id = sc.nextInt();
        System.out.println(" nhập email:");
        acc.email = sc.next();
        System.out.println(" nhap tên ");
        acc.username = sc.next();
        System.out.println("nhập posotion");
        int posid = sc.nextInt();
        switch (posid) {
            case 1:
                Position pos1 = new Position();
                pos1.Name = Position.PositionName.DEV;
                break;
            case 2:
                Position pos2 = new Position();
                pos2.Name = Position.PositionName.TEST;
                break;
            case 3:
                Position pos3 = new Position();
                pos3.Name = Position.PositionName.SCRUM_MASTER;
                break;
            case 4:
                Position pos4 = new Position();
                pos4.Name = Position.PositionName.PM;
                break;
            default:
                System.out.println("nhập lại số trong khoản 1- 4");
                break;
        }
    }

    public void question6() {
        Department dep = new Department();
        Scanner sc = new Scanner(System.in);
        System.out.println(" nhập id ");
        dep.id = sc.nextInt();
        System.out.println(" nhap ten ");
        dep.name = sc.next();
    }

    public void question7() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("nhâp số chẵn ");
            int a = sc.nextInt();
            if (a % 2 != 0) {
                System.out.println("nhập lại số chan ");
            } else {
                break;
            }
        }
    }

    public void question8() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("nhập 1 số ");
            int a = scanner.nextInt();
            if (a == 1) {
                Account acc = new Account();
                Scanner sc = new Scanner(System.in);
                System.out.println("nhập id ");
                acc.id = sc.nextInt();
                System.out.println(" nhập email:");
                acc.email = sc.next();
                System.out.println(" nhap tên ");
                acc.username = sc.next();
                System.out.println("nhập posotion");
                int posid = sc.nextInt();
                switch (posid) {
                    case 1:
                        Position pos1 = new Position();
                        pos1.Name = Position.PositionName.DEV;
                        break;
                    case 2:
                        Position pos2 = new Position();
                        pos2.Name = Position.PositionName.TEST;
                        break;
                    case 3:
                        Position pos3 = new Position();
                        pos3.Name = Position.PositionName.SCRUM_MASTER;
                        break;
                    case 4:
                        Position pos4 = new Position();
                        pos4.Name = Position.PositionName.PM;
                        break;
                    default:
                        System.out.println("nhập lại số trong khoản 1- 4");
                        break;

                }
                break;
            } else if (a == 2) {
                Department dep = new Department();
                Scanner scc = new Scanner(System.in);
                System.out.println(" nhập id ");
                dep.id = scc.nextInt();
                System.out.println(" nhap ten ");
                dep.name = scc.next();
                break;
            } else {
                System.out.println("mời banj nhập lại");
            }
        }
    }

    public void question9(Account[] accounts, Group[] groups) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" danh sach user có trong  account");
        for (var acc : accounts) {
            System.out.println(" ten: " + acc.username + "id của account" + acc.id);
        }
        System.out.println(" nhap vao user của account");
        String newuse = scanner.next();
        int indexaccount = -1;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].username.equals(newuse)) {
                System.out.println("đã có trong " + newuse);
                indexaccount = i;
            }
        }
        System.out.println(" danh sach group co trong accout ");
        for (var group : groups) {
            System.out.println(" ten: " + group.Name);
        }
        System.out.println(" nhap group can them");
        String newgroup = scanner.next();
        int indexgroup = -1;
        for (int i = 0; i < groups.length; i++) {
            if (groups[i].Name.equals(newgroup)) {
                System.out.println(" đã có trong group " + newgroup);
                indexgroup = i;
            }
        }

        if (indexgroup < 0 || indexaccount < 0) {
            System.out.println("uesename và group không có");
        } else {
            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i].username.equals(newuse)) {
                    Group[] gp = {groups[indexgroup]};
                    accounts[i].group = gp;
                }
            }
        }

    }
    public void question10()
    {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("nhập 1 số ");
            int a = scanner.nextInt();
            if (a == 1) {
                Account acc = new Account();
                Scanner sc = new Scanner(System.in);
                System.out.println("nhập id ");
                acc.id = sc.nextInt();
                System.out.println(" nhập email:");
                acc.email = sc.next();
                System.out.println(" nhap tên ");
                acc.username = sc.next();
                System.out.println("nhập posotion");
                int posid = sc.nextInt();
                switch (posid) {
                    case 1:
                        Position pos1 = new Position();
                        pos1.Name = Position.PositionName.DEV;
                        break;
                    case 2:
                        Position pos2 = new Position();
                        pos2.Name = Position.PositionName.TEST;
                        break;
                    case 3:
                        Position pos3 = new Position();
                        pos3.Name = Position.PositionName.SCRUM_MASTER;
                        break;
                    case 4:
                        Position pos4 = new Position();
                        pos4.Name = Position.PositionName.PM;
                        break;
                    default:
                        System.out.println("nhập lại số trong khoản 1- 4");
                        break;

                }
                break;
            } else if (a == 2) {
                Department dep = new Department();
                Scanner scc = new Scanner(System.in);
                System.out.println(" nhập id ");
                dep.id = scc.nextInt();
                System.out.println(" nhap ten ");
                dep.name = scc.next();
                break;
            } else if (a==3) {
                Account[] dsAcount ={};
                Group[] dsGroup={};
                question9(dsAcount,dsGroup);
            }
            else  {
                    System.out.println("mời ban nhập lại");
                }
            }
        }
 
}

