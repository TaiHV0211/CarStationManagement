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
public class HangXeMT {
    String ID_hangxe , TenHangXe;

    public HangXeMT() {
    }
    
    public HangXeMT(String ID_hangxe, String TenHangXe) {
        this.ID_hangxe = ID_hangxe;
        this.TenHangXe = TenHangXe;
    }

    public String getID_hangxe() {
        return ID_hangxe;
    }

    public void setID_hangxe(String ID_hangxe) {
        this.ID_hangxe = ID_hangxe;
    }

    public String getTenHangXe() {
        return TenHangXe;
    }

    public void setTenHangXe(String TenHangXe) {
        this.TenHangXe = TenHangXe;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
