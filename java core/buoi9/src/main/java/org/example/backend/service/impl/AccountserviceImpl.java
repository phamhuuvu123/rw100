package org.example.backend.service.impl;

import org.example.backend.repository.IAccountRepository;
import org.example.backend.repository.impl.AccountRepository;
import org.example.backend.service.IAccountservice;
import org.example.entity.Account;
import org.example.entity.DePartment;
import org.example.entity.Position;

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

}
