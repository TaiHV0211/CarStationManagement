/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Hvt02
 */


import Model.HangXeMT;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOHangXeMT {
    private Connection conn;
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=CAR;user=sa;password=Hvt@02112001";

    public DAOHangXeMT() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    public  ArrayList<HangXeMT> getListHangXeMT(){
        ArrayList<HangXeMT> ls = new ArrayList<>();
        String sql = "select * from TenHangXeMT";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            Statement st;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HangXeMT n = new HangXeMT();
                n.setID_hangxe(rs.getString("Id_hangxe"));
                n.setTenHangXe(rs.getString("TenHangXe"));
                ls.add(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    public void AddCar(HangXeMT hxmt){
        String sql = "Insert into TenHangXeMT(Id_hangxe,TenHangXe) VALUES" 
                + "(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hxmt.getID_hangxe());
            ps.setString(2, hxmt.getTenHangXe());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void DeleteCar(String id){
        String sql = "Delete From TenHangXeMT where Id_hangxe=?";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<HangXeMT> findbyName(String Name){
        ArrayList<HangXeMT> ls =new ArrayList<>();
        String sql = "Select * from TenHangXeMT where Id_hangxe like ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"%" + Name +"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HangXeMT n = new HangXeMT();
                n.setID_hangxe(rs.getString("Id_hangxe"));
                n.setTenHangXe(rs.getString("TenHangXe"));
                ls.add(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    
    public static void main(String[] args) {
        new DAOHangXeMT();
    }
}
