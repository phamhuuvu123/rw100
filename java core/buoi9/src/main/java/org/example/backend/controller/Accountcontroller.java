package org.example.backend.controller;

import org.example.backend.service.IAccountservice;
import org.example.backend.service.impl.AccountserviceImpl;
import org.example.entity.Account;

import java.util.List;

public class Accountcontroller {
    private IAccountservice accountservice =  new AccountserviceImpl();
    public List<Account> findAll()
    {
        List<Account> accounts = new AccountserviceImpl().findAll();
        return accounts;
    }
    public boolean createAccount( String Emailname,String username, String fullname
            , int idDE,int idPO)
    {
        boolean check = accountservice.createAccount(Emailname,username,fullname,idDE,idPO);
        return check;
    };
    public boolean deleteAccount(int id)
    {
        boolean check = accountservice.deleteAccount(id);
        return check;
    }
    public  boolean updateAccount(int id, String name)
    {
        boolean check= accountservice.updateAccount(id, name);
        return check;
    }
    public  List<Account> findById(int id)
    {
        List<Account> accounts =accountservice.findById(id);
        return accounts;
    }
}