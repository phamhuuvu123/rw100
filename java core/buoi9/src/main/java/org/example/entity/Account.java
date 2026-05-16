package org.example.entity;

import org.example.entity.DePartment;
import org.example.entity.Position;

import java.time.LocalDate;

public class Account {
    private int id;
    private String fullName;
    private String Uesername;
    private String email;
    private Position positionname;
    private DePartment dePartmentname;
    private LocalDate ngayTao;
    public Account(int idAcc, String nameAcc, String nameEmail, Position positionnew, DePartment dePartmentnew, LocalDate date){};

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Position getPositionname() {
        return positionname;
    }

    public void setPositionname(Position positionname) {
        this.positionname = positionname;
    }

    public DePartment getDePartmentname() {
        return dePartmentname;
    }

    public void setDePartmentname(DePartment dePartmentname) {
        this.dePartmentname = dePartmentname;
    }

    public String getUesername() {
        return Uesername;
    }

    public void setUesername(String uesername) {
        Uesername = uesername;
    }

    public Account(int id, String fullName, String uesername, String email, Position positionname, DePartment dePartmentname) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.positionname = positionname;
        this.dePartmentname = dePartmentname;
        this.Uesername=uesername;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", positionname=" + positionname +
                ", dePartmentname=" + dePartmentname +
                ", ngayTao=" + ngayTao +
                '}';
    }
}
