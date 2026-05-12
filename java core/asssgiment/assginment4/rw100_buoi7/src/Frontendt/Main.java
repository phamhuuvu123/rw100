package Frontendt;

import Backend.QLDepartment;
import Backend.QlAccount;
import entity.DePartment;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Scanner scanner =new Scanner(System.in);
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       AccountFunction.run();
    }

}