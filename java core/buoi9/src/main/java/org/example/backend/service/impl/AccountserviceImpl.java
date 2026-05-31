package org.example.backend.service.impl;

import org.example.backend.repository.IAccountRepository;
import org.example.backend.repository.impl.AccountRepository;
import org.example.backend.repository.impl.DepartmentRepositoryImpl;
import org.example.backend.repository.impl.PositionRepositoryImpl;
import org.example.backend.service.IAccountservice;
import org.example.dto.CSV.AccountCSV;
import org.example.dto.CSV.DepartmentCSV;
import org.example.dto.ImportErro;
import org.example.dto.context.AccountContext;
import org.example.dto.context.DepartmentContext;
import org.example.entity.Account;
import org.example.entity.DePartment;
import org.example.entity.Position;
import org.example.utlis.JBDcutils;
import org.example.utlis.ScannerUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;

public class AccountserviceImpl implements IAccountservice {
    private IAccountRepository accountRepository = new AccountRepository();

    @Override
    public List<Account> findAll() {
        List<Account> accounts = accountRepository.findAll();
        return accounts;
    }

    @Override
    public boolean createAccount(String Emailname, String username, String fullname, int idDE, int idPO) {
        boolean check = accountRepository.createAccount(Emailname, username, fullname, idDE, idPO);
        return check;
    }

    @Override
    public boolean deleteAccount(int id) {
        boolean check = accountRepository.deleteAccount(id);
        return check;
    }

    public boolean updateAccount(int id, String name) {
        boolean check = accountRepository.updateAccount(id, name);
        return check;
    }

    @Override
    public List<Account> findById(int id) {
        List<Account> accounts = accountRepository.findByID(id);
        return accounts;
    }

    @Override
    public boolean checkExitIdAndName(String name, Integer id) {
        return accountRepository.checkExitIdAndName(name, id);
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

        String pathError = "C:\\Users\\HP\\Desktop\\rw100\\csv\\output_erro_acconut.csv";
        Map<String, Account> mapByUesrname = accountRepository.mapByUesrname();
        Map<String, Account> mapByNamemail = accountRepository.mapByemail();
        AccountContext context = new AccountContext(mapByUesrname, mapByNamemail);
        String message = this.importFileCSV(pathname, context, pathError);
        return message;
    }
//


    @Override
    public void validation(String line, AccountContext Context, List<Account> entities, List<ImportErro<AccountCSV>> importErros) {
        Map<String, Account> mapbyemai = Context.getMapByemail();
        Map<String, Account> mapByuesrname = Context.getMapbyNameusername();
        List<String> erros = new ArrayList<>();
        String[] fileds = line.split(",");
        String username = fileds[0];
        if (Objects.isNull(username) || username.trim().isEmpty()) {
            erros.add("username không để trống");
        } else if (username.length() > 100) {
            erros.add("tên  quá dài");
        } else if (mapByuesrname.get(username) != null) {
            erros.add("tên uesrname đã tồn tại");
        }
        String fullname = fileds[1];
        if (Objects.isNull(fullname) || fullname.trim().isEmpty()) {
            erros.add("fullname không được để trống");
        } else if (fullname.length() > 100) {
            erros.add("fullname quá dài");
        }
        String email = fileds[2];
//        email =ScannerUtils.inputEmail();
        if (Objects.isNull(email) || email.trim().isEmpty()) {
            erros.add("email không được để trống");
        } else if (mapbyemai.get(email) != null) {
            erros.add("email đã tồn tại");
        }
        int departmentId = Integer.parseInt(fileds[3]);
        int positionId = Integer.parseInt(fileds[4]);
        DepartmentRepositoryImpl departmentRepository = new DepartmentRepositoryImpl();
        PositionRepositoryImpl positionRepository = new PositionRepositoryImpl();
        List<DePartment> dePartments = departmentRepository.findAll();
        boolean checkde = dePartments.stream().anyMatch(de -> de.getId() == departmentId);
        if (Objects.isNull(departmentId)) {
            erros.add("nhập lại id department không để trống");
        }
        DePartment department = new DePartment();
        if (checkde == false) {
            erros.add("phòng ban không tồn tại");
        } else {
            department = new DePartment(departmentId, null);
        }
        if (Objects.isNull(positionId)) {
            erros.add("nhập lại id không để trống");
        }
        List<Position> positions = positionRepository.findAll();
        boolean checkPO = positions.stream().anyMatch(po -> po.getId() == positionId);
        Position position = new Position();

        if (checkPO == false) {
            erros.add("chức vụ không tồn tại");
        } else {
            position = new Position(positionId, null);
        }
        if (erros.isEmpty()) {
            Account account1 = new Account(fullname, username, email, position, department);
            entities.add(account1);
            Context.getMapbyNameusername().put(email, account1);
            Context.getMapbyNameusername().put(username, account1);
        } else {
            AccountCSV csv = new AccountCSV(fullname, username, email, String.valueOf(positionId), String.valueOf(departmentId));
            ImportErro erro = new ImportErro(csv, erros);
            importErros.add(erro);
        }
    }

    @Override
    public void savsAll(List<Account> entites) {
        this.accountRepository.createlistAccount(entites);
    }

    @Override
    public void exportFileError(List<ImportErro<AccountCSV>> importErros, String partError) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(partError));
            bw.write("error_message");
            bw.newLine();
            for (ImportErro erros : importErros) {
                String ln = erros.getLine() + "," + String.join("|", erros.getMessage());
                bw.write(ln);
                bw.newLine();
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }
    }
}


