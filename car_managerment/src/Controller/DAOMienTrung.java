/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.MienTrung;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *  

    Statement st;
    ResultSet rs;
 * @author Hvt02
 */
public class DAOMienTrung {
    private Connection conn;
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=CAR;user=sa;password=Hvt@02112001";
    public DAOMienTrung(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  ArrayList<MienTrung> getListMT(){
        ArrayList<MienTrung> ls = new ArrayList<>();
        String sql = "Select * from CarMTrung";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            Statement st;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MienTrung n = new MienTrung();
                n.setId(rs.getInt("ID"));
                n.setTenHang(rs.getString("TENHANG"));
                n.setBienSo(rs.getString("BIENSO"));
                n.setBaiXe(rs.getString("BAIXE"));
                n.setDiTu(rs.getString("DITU"));
                n.setDenBen(rs.getString("DENBEN"));
                n.setNgayVao(rs.getString("NGAYVAO"));
                ls.add(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public void AddCar(MienTrung mt){
        String sql = "Insert into CarMTrung(TENHANG,BIENSO,BAIXE,DITU,DENBEN,NGAYVAO) VALUES" 
                + "(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mt.getTenHang());
            ps.setString(2, mt.getBienSo());
            ps.setString(3, mt.getBaiXe());
            ps.setString(4, mt.getDiTu());
            ps.setString(5, mt.getDenBen());
            ps.setString(6, mt.getNgayVao());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void DeleteCar(int id){
        String sql = "Delete From CarMTrung where ID=?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<MienTrung> findbyName(String Name){
        ArrayList<MienTrung> ls =new ArrayList<>();
        String sql = "Select * from CarMTrung where TENHANG like ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"%" + Name +"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MienTrung n = new MienTrung();
                n.setId(rs.getInt("ID"));
                n.setTenHang(rs.getString("TENHANG"));
                n.setBienSo(rs.getString("BIENSO"));
                n.setBaiXe(rs.getString("BAIXE"));
                n.setDiTu(rs.getString("DITU"));
                n.setDenBen(rs.getString("DENBEN"));
                n.setNgayVao(rs.getString("NGAYVAO"));
                ls.add(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    
     public ArrayList<MienTrung> findbyBaiXe(String BaiXe){
        ArrayList<MienTrung> ls =new ArrayList<>();
        String sql = "Select * from CarMTrung where BAIXE like ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"%" + BaiXe +"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MienTrung n = new MienTrung();
                n.setId(rs.getInt("ID"));
                n.setTenHang(rs.getString("TENHANG"));
                n.setBaiXe(rs.getString("BAIXE"));
                n.setNgayVao(rs.getString("NGAYVAO"));
                ls.add(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    public static void main(String[] args) {
        new DAOMienTrung();
    }
}
