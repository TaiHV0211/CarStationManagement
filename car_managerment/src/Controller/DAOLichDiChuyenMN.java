/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.LichDiChuyenMN;
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
public class DAOLichDiChuyenMN {
    private Connection conn;
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=CAR;user=sa;password=Hvt@02112001";
    public DAOLichDiChuyenMN(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public  ArrayList<LichDiChuyenMN> getListMT(){
        ArrayList<LichDiChuyenMN> ls = new ArrayList<>();
        String sql = "Select * from CarMNamCalendar";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            Statement st;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LichDiChuyenMN n = new LichDiChuyenMN();
                n.setIddc(rs.getInt("IDDC"));
                n.setTenHangdc(rs.getString("TENHANGDC"));
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
    
    public void AddCarCalendar(LichDiChuyenMN mt){
        String sql = "Insert into CarMNamCalendar(TENHANGDC,BIENSODC,TRANGTHAI,DITUDC,DENBENDC,NGAYVAODC) VALUES" 
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
        String sql = "Delete From CarMNamCalendar where IDDC=?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public ArrayList<LichDiChuyenMN> findbyName(String Name){
        ArrayList<LichDiChuyenMN> ls =new ArrayList<>();
        String sql = "Select * from CarMNamCalendar where TENHANGDC like ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"%" + Name +"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LichDiChuyenMN n = new LichDiChuyenMN();
                n.setIddc(rs.getInt("IDDC"));
                n.setTenHangdc(rs.getString("TENHANGDC"));
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
        new DAOLichDiChuyenMN();
    }
}
