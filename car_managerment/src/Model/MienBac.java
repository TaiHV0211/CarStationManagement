/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Hvt02
 */
public class MienBac {
    private int id;
    private String TenHang, BienSo,BaiXe,DiTu,DenBen,NgayVao;

    public MienBac() {
    }

    public MienBac(String TenHang, String BienSo, String BaiXe, String DiTu, String DenBen, String NgayVao) {
        this.TenHang = TenHang;
        this.BienSo = BienSo;
        this.BaiXe = BaiXe;
        this.DiTu = DiTu;
        this.DenBen = DenBen;
        this.NgayVao = NgayVao;
    }

    public MienBac(int id, String TenHang, String BienSo, String BaiXe, String DiTu, String DenBen, String NgayVao) {
        this.id = id;
        this.TenHang = TenHang;
        this.BienSo = BienSo;
        this.BaiXe = BaiXe;
        this.DiTu = DiTu;
        this.DenBen = DenBen;
        this.NgayVao = NgayVao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public String getBienSo() {
        return BienSo;
    }

    public void setBienSo(String BienSo) {
        this.BienSo = BienSo;
    }

    public String getBaiXe() {
        return BaiXe;
    }

    public void setBaiXe(String BaiXe) {
        this.BaiXe = BaiXe;
    }

    public String getDiTu() {
        return DiTu;
    }

    public void setDiTu(String DiTu) {
        this.DiTu = DiTu;
    }

    public String getDenBen() {
        return DenBen;
    }

    public void setDenBen(String DenBen) {
        this.DenBen = DenBen;
    }

    public String getNgayVao() {
        return NgayVao;
    }

    public void setNgayVao(String NgayVao) {
        this.NgayVao = NgayVao;
    }

    @Override
    public String toString() {
        return "MienTrung{" + "id=" + id + ", TenHang=" + TenHang + ", BienSo=" + BienSo + ", BaiXe=" + BaiXe + ", DiTu=" + DiTu + ", DenBen=" + DenBen + ", NgayVao=" + NgayVao + '}';
    }
    
    
    
}
