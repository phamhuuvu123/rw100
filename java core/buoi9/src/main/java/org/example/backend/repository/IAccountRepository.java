package org.example.backend.repository;

import org.example.entity.Account;
import org.example.entity.DePartment;
import org.example.entity.Position;

import java.util.List;

public interface IAccountRepository {
    List<Account> findAll();
    boolean createAccount(String Emailname,String username, String fullname
            , int idDE,int idPO);
    boolean deleteAccount(int id);
    boolean updateAccount(int id,String name);
    List<Account> findByID(int id);
    boolean check (String uesername, String fullname, String email, DePartment dePartment,Position position);
    boolean checkExitIdAndName(String name,Integer id);
    boolean checkId(int id);
}
