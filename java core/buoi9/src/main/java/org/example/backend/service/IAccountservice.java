package org.example.backend.service;

import org.example.entity.Account;

import java.util.List;

public interface IAccountservice {
    List<Account> findAll();
    boolean createAccount(String Emailname,String username, String fullname
            , int idDE,int idPO);
    boolean deleteAccount(int id);
    boolean updateAccount(int id, String name);
    List<Account> findById(int id);

}
