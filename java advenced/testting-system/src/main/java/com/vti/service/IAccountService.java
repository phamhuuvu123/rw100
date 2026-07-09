package com.vti.service;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.form.AccountCreateForm;

import java.util.List;

public interface IAccountService {
    List<AccountDTO> findAll();

    AccountDTO findById(Integer id);

    void deleteById(Integer id);

    void create(AccountCreateForm account);

    void update(AccountCreateForm account, Integer id);
}
