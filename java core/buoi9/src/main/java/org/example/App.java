package org.example;

import org.example.backend.controller.Accountcontroller;
import org.example.backend.controller.Departmentcontroller;
import org.example.backend.repository.impl.AccountRepository;
import org.example.entity.Account;
import org.example.frontend.AccountFunction;
import org.example.frontend.DepartmentFunction;
import org.example.frontend.PositionFuncion;

import java.util.Map;
import java.util.function.Function;

/**
 * Hello world!
 *
 */
public class App

{
    public static void main( String[] args ) throws ClassNotFoundException {
 AccountFunction accountFunction = new AccountFunction();
 accountFunction.run();
    }
}
