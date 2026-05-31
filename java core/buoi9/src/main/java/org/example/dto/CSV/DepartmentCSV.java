package org.example.dto.CSV;

public class DepartmentCSV {
    private String departmentname;

    public DepartmentCSV(){}

    public String getDepartmentname() {
        return departmentname;
    }

    @Override
    public String toString() {
        return "DepartmentCSV{" +
                "departmentname='" + departmentname + '\'' +
                '}';
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public DepartmentCSV(String departmentname) {
        this.departmentname = departmentname;
    }
}
