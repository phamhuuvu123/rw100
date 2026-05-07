package emipity;

import Enums.Gender;

public class NhanVien extends CanBo{
    private String congViec;

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    public NhanVien(String name, int age, Gender gioitinh, String hometown, String congViec) {
        super(name, age, gioitinh, hometown);
        this.congViec = congViec;
    }

    public NhanVien(String congViec) {
        this.congViec = congViec;
    }
    public String ToString()
    {
        return  "==Nhân viên== Họ+tên: " +super.getName()+",tuổi "+super.getAge()+
                ",giới tính "+super.getGioitinh()+",địa chỉ"+super.getHometown()+
                ",bậc "+this.congViec;
    }
}
