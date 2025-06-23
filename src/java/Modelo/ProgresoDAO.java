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

public class ProgresoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listar(){
        String sql = "select * from progreso";
        List<Progreso>lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Progreso pr = new Progreso();
                pr.setId(rs.getInt(1));
                pr.setPorcentaje(rs.getString(2));
                lista.add(pr);
            }
        } catch (Exception e) {
            System.out.println("Error listarProgresoDAO "+e);
        }
        return lista;
    }
    
    public Progreso listarId(int id){
        Progreso pr = new Progreso();
        String sql = "select * from progreso where idProgreso="+id;
        try {
            con =cn.Conexion(); 
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                pr.setId(Integer.parseInt(rs.getString(1)));
                pr.setPorcentaje(rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Error listarIdProgresoDAO "+e);
        }
        return pr;
    }
    
    public int actualizar(Progreso pr){
        String sql = "update progreso set porcentaje=? where idProgreso=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getPorcentaje());
            ps.setInt(2, pr.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error actualizarProgresoDAO "+e);
        }
        return r;
    }
}
