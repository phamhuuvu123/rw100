package emipity;

import Enums.Gender;

public class KySu extends CanBo{
    private String Nganh;

    public String getNganh() {
        return Nganh;
    }

    public void setNganh(String nganh) {
        Nganh = nganh;
    }

    public KySu(String name, int age, Gender gioitinh, String hometown, String nganh) {
        super(name, age, gioitinh, hometown);
        Nganh = nganh;
    }

    public KySu(String nganh) {
        Nganh = nganh;
    }
    public String ToString()
    {
        return  "==kỹ sư== Họ+tên: " +super.getName()+",tuổi "+super.getAge()+
                ",giới tính "+super.getGioitinh()+",địa chỉ"+super.getHometown()+
                ",bậc "+this.getNganh();
    }
}
