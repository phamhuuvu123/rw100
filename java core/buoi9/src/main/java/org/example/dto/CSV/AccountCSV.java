package org.example.dto.CSV;

import org.example.entity.DePartment;
import org.example.entity.Position;

public class AccountCSV {
    private String fullName;
    private String Uesername;
    private String email;
    private String positionname;
    private String dePartmentname;

    public AccountCSV(String fullName, String uesername, String email, String positionname, String dePartmentname) {
        this.fullName = fullName;
        Uesername = uesername;
        this.email = email;
        this.positionname = positionname;
        this.dePartmentname = dePartmentname;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUesername() {
        return Uesername;
    }

    public void setUesername(String uesername) {
        Uesername = uesername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname;
    }

    public String getDePartmentname() {
        return dePartmentname;
    }

    public void setDePartmentname(String dePartmentname) {
        this.dePartmentname = dePartmentname;
    }
}
