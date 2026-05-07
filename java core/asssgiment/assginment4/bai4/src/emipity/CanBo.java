package emipity;
import Enums.Gender;
public class CanBo {
    private String name;
    private int age;
    private  Gender gioitinh;
    private String hometown;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Gender gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public CanBo(String name, int age, Gender gioitinh, String hometown) {
        this.name = name;
        this.age = age;
        this.gioitinh = gioitinh;
        this.hometown = hometown;
    }

    @Override
    public String toString() {
        return "CanBo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gioitinh=" + gioitinh +
                ", hometown='" + hometown + '\'' +
                '}';
    }

    public CanBo(){}
}
