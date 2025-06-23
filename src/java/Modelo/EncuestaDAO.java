/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EncuestaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    //Operaciones CRUD
    
    public List listar(){
        String sql = "select * from validacion";
        List<Encuesta>lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Encuesta en = new Encuesta();
                en.setId(rs.getInt(1));
                en.setResp1(rs.getString(2));
                en.setResp2(rs.getString(3));
                en.setResp3(rs.getString(4));
                lista.add(en);
            }
        } catch (Exception e) {
            System.out.println("Error listarValidacionDAO "+e);
        }
        return lista;
    }
    
    public int crear(Encuesta en){
        String sql = "insert into validacion(respuesta1, respuesta2, respuesta3)values(?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, en.getResp1());
            ps.setString(2, en.getResp2());
            ps.setString(3,en.getResp3());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error agregarValidacionDAO "+e);
        }
        return r;
    }
    
    public Encuesta listarId(int id){
        Encuesta en = new Encuesta();
        String sql = "select * from validacion where IdEncuesta="+id;
        try {
            con =cn.Conexion(); 
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                en.setResp1(rs.getString(2));
                en.setResp2(rs.getString(3));
                en.setResp3(rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("Error listarIdValidacionDAO "+e);
        }
        return en;
    }
    
    public int actualizar(Encuesta en){
        String sql = "update validacion set respuesta1=?, respuesta2=?, respuesta3=? where IdEncuesta=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, en.getResp1());
            ps.setString(2, en.getResp2());
            ps.setString(3, en.getResp3());
            ps.setInt(4, en.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error actualizarValidacionDAO "+e);
        }
        return r;
    }
    
    public void eliminar(int id){
        String sql = "delete from validacion where IdEncuesta="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error deleteValidacionDAO "+e);
        }
    }
}
