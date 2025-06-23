
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    public Usuario validar(Usuario item){//validar usuario, (Usuario item)
        Usuario us = new Usuario();
        String sql = "select * from usuario where Correo=? and Contraseña=?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, item.getCorreo());//item.getCorreo
            ps.setString(2, item.getCon());//item.getContraseña
            rs = ps.executeQuery();
            
            while(rs.next()){
                us.setId(rs.getInt("IdUsuario"));
                us.setCorreo(rs.getString("Correo"));
                us.setNombre(rs.getNString("Nombre"));
                us.setCon(rs.getString("Contraseña"));
            }
        }catch(Exception e){
            System.out.println("Error validarusuarioDAO"+ e);
        }
        return us;
    }
    
    
    //Operaciones CRUD
    
    public List listar(){
        String sql = "select * from usuario";
        List<Usuario>lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario us = new Usuario();
                us.setId(rs.getInt(1));
                us.setNombre(rs.getString(2));
                us.setCorreo(rs.getString(3));
                us.setCon(rs.getString(4));
                lista.add(us);
            }
        } catch (Exception e) {
            System.out.println("Error listarUsuarioDAO "+e);
        }
        return lista;
    }
    
    public int crear(Usuario us){
        String sql = "insert into usuario(Nombre, Correo, Contraseña)values(?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getCorreo());
            ps.setString(3,us.getCon());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error agregarUsuarioDAO "+e);
        }
        return r;
    }
    
    public Usuario listarId(int id){
        Usuario us = new Usuario();
        String sql = "select * from usuario where IdUsuario="+id;
        try {
            con =cn.Conexion(); 
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                us.setNombre(rs.getString(2));
                us.setCorreo(rs.getString(3));
                us.setCon(rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("Error listarIdUsuarioDAO "+e);
        }
        return us;
    }
    
    public int actualizar(Usuario us){
        String sql = "update usuario set Nombre=?, Correo=?, Contraseña=? where IdUsuario=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getCorreo());
            ps.setString(3, us.getCon());
            ps.setInt(4, us.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error actualizarUsuarioDAO "+e);
        }
        return r;
    }
    
    public int cambiarcontra(Usuario us){
        String sql = "update usuario set Contraseña=? where IdUsuario=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getCon());
            ps.setInt(2, us.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error cambiarcontraUsuarioDAO "+e);
        }
        return r;
    }
    
    public void eliminar(int id){
        String sql = "delete from usuario where IdUsuario="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error deleteUsuarioDAO "+e);
        }
    }
}
