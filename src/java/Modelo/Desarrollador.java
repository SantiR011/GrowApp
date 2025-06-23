
package Modelo;

public class Desarrollador {
    int id;
    String nombre;
    String correo;
    String con;

    public Desarrollador() {
    }
    
    

    public Desarrollador(int id, String nombre, String correo, String con) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.con = con;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }
    
    
}
