
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DesarrolladorDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    public Desarrollador validar(Desarrollador item){//validar desarrollador, (Desarrollador item)
        Desarrollador des = new Desarrollador();
        String sql = "select * from desarrollador where Correo=? and Contraseña=?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, item.getCorreo());//item.getCorreo
            ps.setString(2, item.getCon());//item.getContraseña
            rs = ps.executeQuery();
            
            while(rs.next()){
                des.setId(rs.getInt("IdDesarrollador"));
                des.setCorreo(rs.getString("Correo"));
                des.setNombre(rs.getNString("Nombre"));
                des.setCon(rs.getString("Contraseña"));
            }
        }catch(Exception e){
            System.out.println("Error validardesarrolladorDAO"+ e);
        }
        return des;
    }
    
    
    //Operaciones CRUD
    
    public List listar(){
        String sql = "select * from desarrollador";
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
            System.out.println("Error listarEmpleadoDAO "+e);
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
