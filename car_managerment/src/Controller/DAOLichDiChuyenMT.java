/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.LichDiChuyenMT;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hvt02
 */
public class DAOLichDiChuyenMT {
    private Connection conn;
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=CAR;user=sa;password=Hvt@02112001";
    public DAOLichDiChuyenMT(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public  ArrayList<LichDiChuyenMT> getListMT(){
        ArrayList<LichDiChuyenMT> ls = new ArrayList<>();
        String sql = "Select * from CarMTrungCalendar";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            Statement st;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LichDiChuyenMT n = new LichDiChuyenMT();
                n.setIddc(rs.getInt("IDDC"));
                n.setTenHangdc(rs.getString("Id_hangxe"));
                n.setBienSodc(rs.getString("BIENSODC"));
                n.setTrangThai(rs.getString("TRANGTHAI"));
                n.setDiTudc(rs.getString("DITUDC"));
                n.setDenBendc(rs.getString("DENBENDC"));
                n.setNgayVaodc(rs.getString("NGAYVAODC"));
                ls.add(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public void AddCarCalendar(LichDiChuyenMT mt){
        String sql = "Insert into CarMTrungCalendar(Id_hangxe,BIENSODC,TRANGTHAI,DITUDC,DENBENDC,NGAYVAODC) VALUES" 
                + "(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mt.getTenHangdc());
            ps.setString(2, mt.getBienSodc());
            ps.setString(3, mt.getTrangThai());
            ps.setString(4, mt.getDiTudc());
            ps.setString(5, mt.getDenBendc());
            ps.setString(6, mt.getNgayVaodc());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void DeleteCarCalender(int id){
        String sql = "Delete From CarMTrungCalendar where IDDC=?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public ArrayList<LichDiChuyenMT> findbyName(String Name){
        ArrayList<LichDiChuyenMT> ls =new ArrayList<>();
        String sql = "Select * from CarMTrungCalendar where TENHANGDC like ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"%" + Name +"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LichDiChuyenMT n = new LichDiChuyenMT();
                n.setIddc(rs.getInt("IDDC"));
                n.setTenHangdc(rs.getString("Id_hangxe"));
                n.setBienSodc(rs.getString("BIENSODC"));
                n.setTrangThai(rs.getString("TRANGTHAI"));
                n.setDiTudc(rs.getString("DITUDC"));
                n.setDenBendc(rs.getString("DENBENDC"));
                n.setNgayVaodc(rs.getString("NGAYVAODC"));
                ls.add(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
   public static void main(String[] args) {
        new DAOLichDiChuyenMT();
    }
}
