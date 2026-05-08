package quanlytailieu;

import java.time.LocalDate;

public class Bao extends Tailieu{
    private LocalDate ngayphathanh;

    public Bao(LocalDate ngayphathanh) {
        this.ngayphathanh = ngayphathanh;
    }

    public Bao(String maTaiLieu, String nameNSx, int sophathanh, LocalDate ngayphathanh) {
        super(maTaiLieu, nameNSx, sophathanh);
        this.ngayphathanh = ngayphathanh;
    }

    public LocalDate getNgayphathanh() {
        return ngayphathanh;
    }

    public void setNgayphathanh(LocalDate ngayphathanh) {
        this.ngayphathanh = ngayphathanh;
    }
}
