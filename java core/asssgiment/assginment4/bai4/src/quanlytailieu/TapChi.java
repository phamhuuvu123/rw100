package quanlytailieu;

public class TapChi extends Tailieu {
    private int sophathanh;
    private int thangphathanh;
    public TapChi(){}

    public TapChi(int sophathanh, int thangphathanh) {
        this.sophathanh = sophathanh;
        this.thangphathanh = thangphathanh;
    }

    @Override
    public int getSophathanh() {
        return sophathanh;
    }

    @Override
    public void setSophathanh(int sophathanh) {
        this.sophathanh = sophathanh;
    }

    public int getThangphathanh() {
        return thangphathanh;
    }

    public void setThangphathanh(int thangphathanh) {
        this.thangphathanh = thangphathanh;
    }

    public TapChi(String maTaiLieu, String nameNSx, int sophathanh, int sophathanh1, int thangphathanh) {
        super(maTaiLieu, nameNSx, sophathanh);
        this.sophathanh = sophathanh1;
        this.thangphathanh = thangphathanh;
    }
}
