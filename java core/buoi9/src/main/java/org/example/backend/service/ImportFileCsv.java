package org.example.backend.service;

import org.example.dto.ImportErro;
import org.example.entity.DePartment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ImportFileCsv<T,K,E> {
    void validation(String line,T Context, List<K> entities, List<ImportErro<E>>importErros);
    void savsAll(List<K>entites);
    void exportFileError(List<ImportErro<E>> importErros, String partError);
    default String importFileCSV(String pathName,T context,String partError) {
        File filea = new File(pathName);
        if (!filea.exists()) {
            System.out.println("file không tồn tài");
        }
        if (!pathName.endsWith(".csv")) {
            return "định dạng không đúng";
        }
        List<K> entities = new ArrayList<>();
        List<ImportErro<E>> importErros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {
            String line = "";
            br.readLine();
            while ((line = br.readLine()) != null) {
                this.validation(line, context, entities, importErros);
            }
            this.savsAll(entities);
            this.exportFileError(importErros,partError);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String message ="";
        if(importErros.isEmpty())
        {
            message="Import thành công";
        }
        if(entities.isEmpty())
        {
            message="Import không thành công,đã xuất file lỗi //C:\\Users\\HP\\Desktop\\rw100\\csv\\output_error_department.csv";
        }
        if(!importErros.isEmpty()&&!entities.isEmpty())
        {
            message="import thành công " +entities.size()+", phòng ban "+ "đã xuất ra lỗi ở file//\"C:\\Users\\HP\\Desktop\\rw100\\csv\\output_erros_department\"";
        }
        return message;
    }
}
