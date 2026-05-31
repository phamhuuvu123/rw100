package org.example.backend.service;

import org.example.dto.CSV.AccountCSV;
import org.example.dto.context.AccountContext;
import org.example.entity.Account;
import org.example.entity.DePartment;
import org.example.entity.Position;

import java.util.List;

public interface IAccountservice extends  ImportFileCsv<AccountContext,Account, AccountCSV> {
    List<Account> findAll();
    boolean createAccount(String Emailname,String username, String fullname
            , int idDE,int idPO);
    boolean deleteAccount(int id);
    boolean updateAccount(int id, String name);
    List<Account> findById(int id);
    boolean checkExitIdAndName(String name,Integer id);
    boolean checkId(int id);
    boolean checkusername (String uesername);
    boolean checkEmail(String email);
    String importAccountFromCSV(String pathname);

}
