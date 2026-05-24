package org.example.backend.service.impl;

import org.example.backend.repository.IAccountRepository;
import org.example.backend.repository.impl.AccountRepository;
import org.example.backend.service.IAccountservice;
import org.example.entity.Account;
import org.example.entity.DePartment;
import org.example.entity.Position;
import org.example.utlis.JBDcutils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class AccountserviceImpl implements IAccountservice {
    private IAccountRepository accountRepository = new AccountRepository();
    @Override
    public List<Account> findAll() {
        List<Account> accounts = accountRepository.findAll();
        return  accounts;
    }

    @Override
    public boolean createAccount(String Emailname, String username, String fullname, int idDE, int idPO) {
       boolean check = accountRepository.createAccount(Emailname,username,fullname,idDE,idPO);
       return check;
    }

    @Override
    public boolean deleteAccount(int id) {
        boolean check = accountRepository.deleteAccount(id);
        return check;
    }
    public  boolean updateAccount(int id, String name){
        boolean check= accountRepository.updateAccount(id, name);
        return  check;
    }

    @Override
    public List<Account> findById(int id) {
        List<Account> accounts =accountRepository.findByID(id);
        return accounts;
    }

    @Override
    public boolean checkExitIdAndName(String name, Integer id) {
        return accountRepository.checkExitIdAndName(name,id);
    }
    @Override
    public boolean checkId(int id) {
        return accountRepository.checkId(id);
    }

    @Override
    public boolean checkusername(String uesername) {
        return accountRepository.checkusername(uesername);
    }

    @Override
    public boolean checkEmail(String email) {
        return accountRepository.checkEmail(email);
    }

    @Override
    public String importAccountFromCSV(String pathname) {
        if(!pathname.endsWith(".csv"))
        {
            return "định dạng không đúng";
        }
        boolean checkCrete=false;
        List<Account> accounts = getAccounts();
        try(BufferedReader br =new BufferedReader(new FileReader(pathname)))
        {
            String line= br.readLine();
            while ((line = br.readLine())!=null)
            {
                String[] fileds = line.split(",");
                String username =fileds[0];
                String fullname= fileds[1];
                String email= fileds[2];
                int departmentId = Integer.parseInt(fileds[3]);
                int positionId = Integer.parseInt(fileds[4]);
                DePartment department = new DePartment(departmentId, null);
                Position position = new Position(positionId, null);
                Account account1 = new Account(fullname,username,email,position,department);
                accounts.add(account1);
            }
            checkCrete = accountRepository.createlistAccount(accounts);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "Import thành công ";

    }

    private static List<Account> getAccounts() {
        List<Account> accounts =new ArrayList<>();
        return accounts;
    }



}
