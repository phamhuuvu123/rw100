package com.vti.service.imp;

import com.vti.Reporisoty.IAccountRepository;
import com.vti.Reporisoty.IDepartmenRepository;
import com.vti.Reporisoty.IPositionRepository;
import com.vti.config.ModelMapperConfig;
import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.form.AccountCreateForm;
import com.vti.service.IAccountService;
import com.vti.service.IPositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IPositionRepository positionRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IAccountRepository iAccountRepository;
    @Autowired
    private IDepartmenRepository iDepartmenRepository;
    @Override
    public List<AccountDTO> findAll() {
        List<Account> accountList = iAccountRepository.findAll();
        List<AccountDTO> accountDTOList = new ArrayList<>();
        for(Account account:accountList)
        {
            AccountDTO dto= modelMapper.map(account, AccountDTO.class);
            accountDTOList.add(dto);
        }
        return accountDTOList;
    }

    @Override
    public AccountDTO findById(Integer id) {
        Account account = iAccountRepository.findById(id).orElse(null);
        AccountDTO dto= null;
        if(Objects.nonNull(account))
        {
          dto= modelMapper.map(account,AccountDTO.class);
        }
        return dto;
    }

    @Override
    public void deleteById(Integer id) {
        iAccountRepository.deleteById(id);
    }

    @Override
    public void create(AccountCreateForm form) {
        Account account= new Account();
        if(  iAccountRepository.existsByUsernameAndIdNot(form.getUsername(),null))
        {
            throw  new RuntimeException("UserName exists");
        }
        if(iAccountRepository.existsByEmailAndIdNot(form.getEmail(),null))
        {
            throw new RuntimeException("email exitst");
        }
        Department department = iDepartmenRepository.findById(form.getDepartmentId())
                .orElseThrow(()->new RuntimeException("Department not found"));
        Position position= positionRepository.findById(form.getPositionId())
                .orElseThrow(()->new RuntimeException("posiiont not found"));
        account.setUsername(form.getUsername());
        account.setFullName(form.getFullName());
        account.setEmail(form.getEmail());
        account.setDepartment(department);
        account.setPosition(position);
        iAccountRepository.save(account);
    }

    @Override
    public void update(AccountCreateForm form, Integer id) {
        Account account= new Account();
        if(  iAccountRepository.existsByUsernameAndIdNot(form.getUsername(),null))
        {
            throw  new RuntimeException("UserName exists");
        }
        if(iAccountRepository.existsByEmailAndIdNot(form.getEmail(),null))
        {
            throw new RuntimeException("email exitst");
        }
        Department department = iDepartmenRepository.findById(form.getDepartmentId())
                .orElseThrow(()->new RuntimeException("Department not found"));
        Position position= positionRepository.findById(form.getPositionId())
                .orElseThrow(()->new RuntimeException("posiiont not found"));
        account.setUsername(form.getUsername());
        account.setFullName(form.getFullName());
        account.setEmail(form.getEmail());
        account.setDepartment(department);
        account.setPosition(position);
        iAccountRepository.save(account);
        }
    }

