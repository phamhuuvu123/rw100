package com.vti.Repository;

import com.vti.enitity.Account;

import java.util.List;

public interface IAccountRepository {
    List<Account> findAll();
    void cretea(Account account);
    void Update(Integer id,String fullname);
    void delete(Integer id);
}
