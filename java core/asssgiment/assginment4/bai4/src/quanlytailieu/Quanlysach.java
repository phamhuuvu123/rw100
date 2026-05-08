package quanlytailieu;

public class Quanlysach extends Tailieu{
    private String nameTacgia;
    private int page;

    public Quanlysach(String nameTacgia, int page) {
        this.nameTacgia = nameTacgia;
        this.page = page;
    }

    public String getNameTacgia() {
        return nameTacgia;
    }

    public void setNameTacgia(String nameTacgia) {
        this.nameTacgia = nameTacgia;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Quanlysach(String maTaiLieu, String nameNSx, int sophathanh, String nameTacgia, int page) {
        super(maTaiLieu, nameNSx, sophathanh);
        this.nameTacgia = nameTacgia;
        this.page = page;
    }
}
