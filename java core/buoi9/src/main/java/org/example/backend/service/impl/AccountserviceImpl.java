package org.example.backend.service.impl;

import org.example.backend.repository.IAccountRepository;
import org.example.backend.repository.impl.AccountRepository;
import org.example.backend.repository.impl.DepartmentRepositoryImpl;
import org.example.backend.repository.impl.PositionRepositoryImpl;
import org.example.backend.service.IAccountservice;
import org.example.dto.ImportErro;
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

    @Override
    public String importAccountFromCSV(String pathname) {
        File file  = new File(pathname);
        if(!file.exists())
        {
            System.out.println("file không tồn tại");
        }
        if(!pathname.endsWith(".csv"))
        {
            return "định dạng không đúng";
        }
        boolean checkCrete=false;
        List<ImportErro> importErro = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();
        Map<String,Account> mapByUserName =accountRepository.mapByUesrname();
        Map<String,Account> mapByEmail =accountRepository.mapByemail();
        try(BufferedReader br =new BufferedReader(new FileReader(pathname)))
        {
            String line= br.readLine();
            while ((line = br.readLine())!=null)
            {
                List<String> erros = new ArrayList<>();
                String[] fileds = line.split(",");
                String username =fileds[0];
                if(Objects.isNull(username)||username.trim().isEmpty())
                {
                    erros.add("username không để trống");
                }else if(username.length()>100){
                    erros.add("tên  quá dài");
                }else if(mapByUserName.get(username)!=null)
                {
                    erros.add("tên uesrname đã tồn tại");
                }
                String fullname= fileds[1];
                if(Objects.isNull(fullname)||fullname.trim().isEmpty())
                { erros.add("fullname không được để trống");
                }else if(fullname.length()>100)
                {
                    erros.add("fullname quá dài");
                }
                String email= fileds[2];
//                email =ScannerUtils.inputEmail();
                if(Objects.isNull(email)||email.trim().isEmpty())
                {
                    erros.add("email không được để trống");
                }else if(mapByEmail.get(email)!=null){
                        erros.add("email đã tồn tại");
                }
                int departmentId = Integer.parseInt(fileds[3]);
                int positionId = Integer.parseInt(fileds[4]);
                DepartmentRepositoryImpl departmentRepository = new DepartmentRepositoryImpl();
                PositionRepositoryImpl positionRepository = new PositionRepositoryImpl();
                List<DePartment> dePartments = departmentRepository.findAll();
                boolean checkde = false;
                if(Objects.isNull(departmentId)){
                    erros.add("nhập lại id department không để trống");
                }
                for(DePartment dep :dePartments)
                {
                    if(dep.getId()==departmentId)
                    {   checkde=true;
                        break;
                    }
                }
                DePartment department =new DePartment();
                if(checkde==false)
                {
                    erros.add("phòng ban không tồn tại");
                }else {
                 department =new DePartment(departmentId,null);
                }
                if(Objects.isNull(positionId)){
                    erros.add("nhập lại id không để trống");
                }
                List<Position> positions = positionRepository.findAll();
                boolean checkPO=false;
                for(Position po :positions)
                {
                    if(po.getId()==positionId)
                    {
                        checkPO=true;
                        break;
                    }
                }
                Position position = new Position();

                if(checkPO==false){
                  erros.add("chức vụ không tồn tại");
                }else {
                     position = new Position(positionId, null);
                }
            if(erros.isEmpty()){
                Account account1 = new Account(fullname,username,email,position,department);
                accounts.add(account1);
            }else {
                ImportErro erro =new ImportErro(line,erros);
                importErro.add(erro);
            }

            }
             accountRepository.createlistAccount(accounts);
            String patherro="C:\\Users\\HP\\Desktop\\rw100\\csv\\output_erro_account.csv";
            try {
                BufferedWriter bw= new BufferedWriter( new FileWriter(patherro));
                bw.write("email,username,full_name,department_id,position_id,error_message");
                bw.newLine();
                for(ImportErro erros:importErro)
                {
                    String ln= erros.getLine()+","+String.join("|",erros.getMessage());
                    bw.write(ln);
                    bw.newLine();
                }
                bw.flush();
            }catch (Exception e)
            {
                e.printStackTrace();;
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        String message ="";
        if(importErro.isEmpty() && !accounts.isEmpty())
        {
            message ="import thành công";
        }else  if (accounts.isEmpty()&&!importErro.isEmpty())
        {
            message="import không thành công đã xuất ra file lỗi:";
        }
        else if (!importErro.isEmpty()&&!accounts.isEmpty())
        {
            message="import thành công "+ accounts.size() +" ,account đã xuất ra ở lỗi file:\"C:\\Users\\HP\\Desktop\\rw100\\csv\\output_erro_account.csv\" ";
        }
        return message;

    }

    private static List<Account> getAccounts() {
        List<Account> accounts =new ArrayList<>();
        return accounts;
    }



}
