package quanlytailieu;

public class Tailieu {
    private String maTaiLieu;
    private String nameNSx;
    private int sophathanh;
    public Tailieu(){}

    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(String maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public String getNameNSx() {
        return nameNSx;
    }

    public void setNameNSx(String nameNSx) {
        this.nameNSx = nameNSx;
    }

    public int getSophathanh() {
        return sophathanh;
    }

    public void setSophathanh(int sophathanh) {
        this.sophathanh = sophathanh;
    }

    public Tailieu(String maTaiLieu, String nameNSx, int sophathanh) {
        this.maTaiLieu = maTaiLieu;
        this.nameNSx = nameNSx;
        this.sophathanh = sophathanh;
    }
}