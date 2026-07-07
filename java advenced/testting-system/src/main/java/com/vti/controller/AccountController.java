package com.vti.controller;

import com.vti.entity.Account;
import com.vti.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;
    @GetMapping
    public ResponseEntity<List<Account>> findAll(){
        List<Account>  accounts = iAccountService.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @GetMapping("/{idAccount}")
    public ResponseEntity<Account> findById(@PathVariable(name="idAccount") Integer id){
        Account account = iAccountService.findById(id);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }
    @DeleteMapping("/{idDelete}")
    public ResponseEntity<String> deleteById(@PathVariable(name="idDelete")Integer id)
    {
        iAccountService.deleteById(id);
        return new ResponseEntity<>("xoa thanh cong",HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Account account)
    {
        iAccountService.create(account);
        return new ResponseEntity<>("tao moi thanh cong", HttpStatus.OK);
    }
    @PutMapping("/{idUpdate}")
    public ResponseEntity<String> update(@RequestBody Account account,
                                         @PathVariable(name="idUpdate")Integer id)
    {
        iAccountService.update(account,id);
        return new ResponseEntity<>("update thanh cong",HttpStatus.OK);
    }
}
