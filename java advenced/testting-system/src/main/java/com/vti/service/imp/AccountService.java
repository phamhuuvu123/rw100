package com.vti.service.imp;

import com.vti.Reporisoty.IAccountRepository;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository iAccountRepository;
    @Override
    public List<Account> findAll() {
        List<Account> accountList = iAccountRepository.findAll();
        return accountList;
    }

    @Override
    public Account findById(Integer id) {
        Account account = iAccountRepository.findById(id).orElse(null);
        return account;
    }

    @Override
    public void deleteById(Integer id) {
        iAccountRepository.deleteById(id);
    }

    @Override
    public void create(Account account) {
        iAccountRepository.save(account);
    }

    @Override
    public void update(Account account, Integer id) {
       Account accountUpdate =iAccountRepository.findById(id).orElse(null);
        if(Objects.isNull(accountUpdate)){
            throw new RuntimeException("id not found");
        }else {
            if(account.getFullName()!=null){
                accountUpdate.setFullName(account.getFullName());
            }
           if(account.getEmail()!=null) {
               accountUpdate.setEmail(account.getEmail());
           }
           if(account.getDateTime()!=null){
               accountUpdate.setDateTime(account.getDateTime());
           }
            if(account.getPositionname()!=null)
            {
                accountUpdate.setPositionname(account.getPositionname());
            }
           if(account.getDepartment()!=null)
           {
               accountUpdate.setDepartment(account.getDepartment());
           }
           if(account.getUserName()!=null) {
               accountUpdate.setUserName(account.getUserName());
           }
            iAccountRepository.save(accountUpdate);
        }
    }
}
