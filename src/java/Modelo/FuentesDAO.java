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

public class FuentesDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    //Operaciones CRUD
    
    public List listar(){
        String sql = "select * from fuente";
        List<Fuentes>lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Fuentes fu = new Fuentes();
                fu.setId(rs.getInt(1));
                fu.setTitulo(rs.getString(2));
                fu.setDescripcion(rs.getString(3));
                fu.setArchivo(rs.getString(4));
                lista.add(fu);
            }
        } catch (Exception e) {
            System.out.println("Error listarFuentesDAO "+e);
        }
        return lista;
    }
    
    public int crear(Fuentes fu){
        String sql = "insert into fuente(titulo, descripcion, archivo)values(?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, fu.getTitulo());
            ps.setString(2, fu.getDescripcion());
            ps.setString(3,fu.getArchivo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error agregarFuenteDAO "+e);
        }
        return r;
    }
    
    public Fuentes listarId(int id){
        Fuentes fu = new Fuentes();
        String sql = "select * from fuente where IdFuente="+id;
        try {
            con =cn.Conexion(); 
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                fu.setTitulo(rs.getString(2));
                fu.setDescripcion(rs.getString(3));
                fu.setArchivo(rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("Error listarIdFuenteDAO "+e);
        }
        return fu;
    }
    
    public int actualizar(Fuentes fu){
        String sql = "update fuente set titulo=?, descripcion=?, archivo=? where IdFuente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, fu.getTitulo());
            ps.setString(2, fu.getDescripcion());
            ps.setString(3, fu.getArchivo());
            ps.setInt(4, fu.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error actualizarFuenteDAO "+e);
        }
        return r;
    }
    
    
    public void eliminar(int id){
        String sql = "delete from fuente where IdFuente="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error deleteFuenteDAO "+e);
        }
    }
    
}
