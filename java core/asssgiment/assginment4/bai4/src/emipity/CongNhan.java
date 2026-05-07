package emipity;

import Enums.Gender;

public class CongNhan extends CanBo{
    private int bac;

    public CongNhan(String name, int age, Gender gioitinh, String hometown, int bac) {
        super(name, age, gioitinh, hometown);
        this.bac = bac;
    }

    public CongNhan(int bac) {
        this.bac = bac;
    }
    public String ToString()
    {
        return  "==công nhân== Họ+tên: " +super.getName()+",tuổi "+super.getAge()+
                ",giới tính "+super.getGioitinh()+",địa chỉ"+super.getHometown()+
                ",bậc "+this.bac;
    }
}
