package org.example;

import org.example.backend.controller.Departmentcontroller;
import org.example.frontend.AccountFunction;
import org.example.frontend.DepartmentFunction;
import org.example.frontend.PositionFuncion;

import java.util.function.Function;

/**
 * Hello world!
 *
 */
public class App

{
    public static void main( String[] args ) throws ClassNotFoundException {
//     DepartmentFunction departmentFunction = new DepartmentFunction();
//     departmentFunction.run();
        AccountFunction function =new AccountFunction();
        function.run();
    }
}
