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
public class LichDiChuyenMN {
    private int iddc;
    private String TenHangdc, BienSodc,TrangThai,DiTudc,DenBendc,NgayVaodc;

    public LichDiChuyenMN() {
    }

    public LichDiChuyenMN(String TenHangdc, String BienSodc, String TrangThai, String DiTudc, String DenBendc, String NgayVaodc) {
        this.TenHangdc = TenHangdc;
        this.BienSodc = BienSodc;
        this.TrangThai = TrangThai;
        this.DiTudc = DiTudc;
        this.DenBendc = DenBendc;
        this.NgayVaodc = NgayVaodc;
    }

    public int getIddc() {
        return iddc;
    }

    public void setIddc(int iddc) {
        this.iddc = iddc;
    }

    public String getTenHangdc() {
        return TenHangdc;
    }

    public void setTenHangdc(String TenHangdc) {
        this.TenHangdc = TenHangdc;
    }

    public String getBienSodc() {
        return BienSodc;
    }

    public void setBienSodc(String BienSodc) {
        this.BienSodc = BienSodc;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getDiTudc() {
        return DiTudc;
    }

    public void setDiTudc(String DiTudc) {
        this.DiTudc = DiTudc;
    }

    public String getDenBendc() {
        return DenBendc;
    }

    public void setDenBendc(String DenBendc) {
        this.DenBendc = DenBendc;
    }

    public String getNgayVaodc() {
        return NgayVaodc;
    }

    public void setNgayVaodc(String NgayVaodc) {
        this.NgayVaodc = NgayVaodc;
    }
    
    
}
