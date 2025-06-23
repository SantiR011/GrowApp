package Controlador;

import Modelo.Desarrollador;
import Modelo.Fuentes;
import Modelo.FuentesDAO;
import Modelo.Progreso;
import Modelo.ProgresoDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Modelo.Encuesta;
import Modelo.EncuestaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})

public class Controlador extends HttpServlet {

    Usuario us = new Usuario();
    UsuarioDAO udao = new UsuarioDAO();
    Progreso pr = new Progreso();
    ProgresoDAO prdao = new ProgresoDAO();
    Fuentes fu = new Fuentes();
    FuentesDAO fudao = new FuentesDAO();
    Encuesta en = new Encuesta();
    EncuestaDAO endao = new EncuestaDAO();
    int ide;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String menu2 = request.getParameter("menu2");
        String accion = request.getParameter("accion");
        String accion2 = request.getParameter("accion2");
        System.out.println("Menu : " + menu);
        System.out.println("Menu2 : " + menu2);
        System.out.println("Accion : " + accion);
        System.out.println("Accion2 : " + accion2);
        //if (menu.equals("Principal")) {
        //request.getRequestDispatcher("Principal.jsp").forward(request, response);
        //}
        HttpSession sesion = request.getSession();
        Usuario usu = (Usuario) sesion.getAttribute("usuario");
        Desarrollador des = (Desarrollador) sesion.getAttribute("desarrollador");

        System.out.println("Desarrollador : " + des);
        System.out.println("Usuario : " + usu);

        if (des == null && usu != null) {
            if (menu2.equals("PortalWeb2")) {
                request.getRequestDispatcher("PortalWeb2.jsp").forward(request, response);
            }
            if (menu2.equals("Validacion2")) {
                switch (accion2) {
                    case "Listar":
                        List lista = endao.listar();
                        request.setAttribute("encuestas", lista);
                        request.getRequestDispatcher("Validacion2.jsp").forward(request, response);
                        break;
                    case "Agregar":
                        String resp1 = request.getParameter("txtResp1");
                        String resp2 = request.getParameter("txtResp2");
                        String resp3 = request.getParameter("txtResp3");
                        en.setResp1(resp1);//se guardan en cada variable por medio de la clase usuario
                        en.setResp2(resp2);
                        en.setResp3(resp3);
                        endao.crear(en);//se gurdan datos de clase usuario en la bd por medio del metodo crear de usuarioDAO
                        request.getRequestDispatcher("Controlador?menu2=Validacion2&accion2=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                        break;
                    default:
                        throw new AssertionError();
                }
                //request.getRequestDispatcher("Validacion2.jsp").forward(request, response);
            }
            if (menu2.equals("InformaciondeProyecto2")) {
                switch (accion2) {
                    case "Listar":
                        List lista = prdao.listar();
                        request.setAttribute("progresos", lista);
                        request.getRequestDispatcher("InformaciondeProyecto2.jsp").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                //request.getRequestDispatcher("InformaciondeProyecto2.jsp").forward(request, response);
            }
            if (menu2.equals("FuentesdeConocimiento2")) {
                switch (accion2) {
                    case "Listar":
                        List lista = fudao.listar();
                        request.setAttribute("fuentes", lista);
                        request.getRequestDispatcher("FuentesdeConocimiento2.jsp").forward(request, response);
                        break;
                    case "Buscar":
                        ide = Integer.parseInt(request.getParameter("txtBuscar"));
                        System.out.println("ide= "+ ide);
                        Fuentes f = fudao.listarId(ide);
                        request.setAttribute("fuente", f);
                        request.getRequestDispatcher("Controlador?menu2=FuentesdeConocimiento2&accion2=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                //request.getRequestDispatcher("FuentesdeConocimiento2.jsp").forward(request, response);
            }
            if (menu2.equals("PreguntasFrecuentes2")) {
                request.getRequestDispatcher("PreguntasFrecuentes2.jsp").forward(request, response);
            }
            if (menu2.equals("Registro2")) {
                switch (accion2) {
                    case "Listar":
                        request.getRequestDispatcher("Registro2.jsp").forward(request, response);
                        break;
                    case "Cambiar":
                        ide = Integer.parseInt(request.getParameter("txtId"));
                        String con1 = asegurarClave(request.getParameter("txtContra"));
                        System.out.println("ide= "+ ide);
                        System.out.println("txt= "+ con1);
                        us.setId(ide);
                        us.setCon(con1);
                        udao.cambiarcontra(us);
                        request.getRequestDispatcher("Registro2.jsp").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                //request.getRequestDispatcher("Registro2.jsp").forward(request, response);
            }
        }

        if (usu == null && des != null) {
            if (menu.equals("PortalWeb")) {
                request.getRequestDispatcher("PortalWeb.jsp").forward(request, response);
            }

            if (menu.equals("Validacion")) {
                switch (accion) {
                    case "Listar":
                        List lista = endao.listar();
                        request.setAttribute("encuestas", lista);
                        request.getRequestDispatcher("Validacion.jsp").forward(request, response);
                        break;
                    case "Agregar":
                        String resp1 = request.getParameter("txtResp1");
                        String resp2 = request.getParameter("txtResp2");
                        String resp3 = request.getParameter("txtResp3");
                        en.setResp1(resp1);//se guardan en cada variable por medio de la clase usuario
                        en.setResp2(resp2);
                        en.setResp3(resp3);
                        endao.crear(en);//se gurdan datos de clase usuario en la bd por medio del metodo crear de usuarioDAO
                        request.getRequestDispatcher("Controlador?menu=Validacion&accion=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                        break;
                    case "Editar":
                        ide = Integer.parseInt(request.getParameter("id"));//guardando el id que llega del empleado.jsp
                        Encuesta e = endao.listarId(ide);
                        request.setAttribute("encuesta", e);//enaviar informacion al formulario Registro.jsp
                        request.getRequestDispatcher("Controlador?menu=Validacion&accion=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                        break;
                    case "Actualizar":
                        String resp11 = request.getParameter("txtResp1");
                        String resp22 = request.getParameter("txtResp2");
                        String resp33 = request.getParameter("txtResp3");
                        en.setResp1(resp11);//se guardan en cada variable por medio de la clase usuario
                        en.setResp2(resp22);
                        en.setResp3(resp33);
                        en.setId(ide);;
                        endao.actualizar(en);
                        request.getRequestDispatcher("Controlador?menu=Validacion&accion=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                        break;
                    case "Delete":
                        ide = Integer.parseInt(request.getParameter("id"));//guardando el id que llega del Registro.jsp
                        endao.eliminar(ide);
                        request.getRequestDispatcher("Controlador?menu=Validacion&accion=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                        break;
                    default:
                        throw new AssertionError();
                }
                //request.getRequestDispatcher("Encuesta.jsp").forward(request, response);
            }

            if (menu.equals("InformaciondeProyecto")) {
                switch (accion) {
                    case "Listar":
                        List lista = prdao.listar();
                        request.setAttribute("progresos", lista);
                        request.getRequestDispatcher("InformaciondeProyecto.jsp").forward(request, response);
                        break;
                    case "Editar":
                        ide = Integer.parseInt(request.getParameter("id"));//guardando el id que llega del empleado.jsp
                        Progreso p = prdao.listarId(ide);
                        request.setAttribute("progreso", p);//enaviar informacion al formulario Registro.jsp
                        request.getRequestDispatcher("Controlador?menu=InformaciondeProyecto&accion=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                        break;
                    case "Actualizar":
                        String porcentaje = request.getParameter("txtPorcentaje");//se obtiene datos de caja de texto
                        pr.setPorcentaje(porcentaje);//se guardan en cada variable por medio de la clase usuario
                        pr.setId(ide);
                        prdao.actualizar(pr);
                        request.getRequestDispatcher("Controlador?menu=InformaciondeProyecto&accion=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                        break;
                    default:
                        throw new AssertionError();
                    //request.getRequestDispatcher("InformaciondeProyecto.jsp").forward(request, response);
                }
            }

            if (menu.equals("FuentesdeConocimiento")) {
                switch (accion) {
                    case "Listar":
                        List lista = fudao.listar();
                        request.setAttribute("fuentes", lista);
                        request.getRequestDispatcher("FuentesdeConocimiento.jsp").forward(request, response);
                        break;
                    case "Agregar":
                        String titulo = request.getParameter("txtTitulo");
                        String descripcion = request.getParameter("txtDescripcion");
                        String archivo = request.getParameter("txtArchivo");
                        fu.setTitulo(titulo);//se guardan en cada variable por medio de la clase usuario
                        fu.setDescripcion(descripcion);
                        fu.setArchivo(archivo);
                        fudao.crear(fu);//se gurdan datos de clase usuario en la bd por medio del metodo crear de usuarioDAO
                        request.getRequestDispatcher("Controlador?menu=FuentesdeConocimiento&accion=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                        break;
                    case "Editar":
                        ide = Integer.parseInt(request.getParameter("id"));//guardando el id que llega del empleado.jsp
                        Fuentes f = fudao.listarId(ide);
                        request.setAttribute("fuente", f);//enaviar informacion al formulario Registro.jsp
                        request.getRequestDispatcher("Controlador?menu=FuentesdeConocimiento&accion=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                        break;
                    case "Actualizar":
                        String titulo1 = request.getParameter("txtTitulo");
                        String descripcion1 = request.getParameter("txtDescripcion");
                        String archivo1 = request.getParameter("txtArchivo");
                        fu.setTitulo(titulo1);
                        fu.setDescripcion(descripcion1);
                        fu.setId(ide);
                        fu.setArchivo(archivo1);
                        fudao.actualizar(fu);
                        request.getRequestDispatcher("Controlador?menu=FuentesdeConocimiento&accion=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                        break;
                    case "Delete":
                        ide = Integer.parseInt(request.getParameter("id"));//guardando el id que llega del Registro.jsp
                        fudao.eliminar(ide);
                        request.getRequestDispatcher("Controlador?menu=FuentesdeConocimiento&accion=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                        break;
                    default:
                        throw new AssertionError();
                }
                //request.getRequestDispatcher("FuentesdeConocimiento.jsp").forward(request, response);
            }

            if (menu.equals("PreguntasFrecuentes")) {
                request.getRequestDispatcher("PreguntasFrecuentes.jsp").forward(request, response);
            }

            if (menu.equals("Registro")) {
                switch (accion) {
                    case "Listar":
                        List lista = udao.listar();
                        request.setAttribute("usuarios", lista);
                        request.getRequestDispatcher("Registro.jsp").forward(request, response);
                        break;
                    case "Agregar":
                        String nom = request.getParameter("txtNombres");
                        String correo = request.getParameter("txtCorreo");
                        //String con = request.getParameter("txtPass");
                        System.out.println("txtNombre : " + request.getParameter("txtNombres"));
                        System.out.println("txtPass : " + request.getParameter("txtPass"));
                        String contraseña = asegurarClave(request.getParameter("txtPass"));
                        us.setNombre(nom);//se guardan en cada variable por medio de la clase usuario
                        us.setCorreo(correo);
                        us.setCon(contraseña);
                        udao.crear(us);//se gurdan datos de clase usuario en la bd por medio del metodo crear de usuarioDAO
                        request.getRequestDispatcher("Controlador?menu=Registro&accion=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                        break;
                    case "Editar":
                        ide = Integer.parseInt(request.getParameter("id"));//guardando el id que llega del empleado.jsp
                        Usuario u = udao.listarId(ide);
                        request.setAttribute("usuario", u);//enaviar informacion al formulario Registro.jsp
                        request.getRequestDispatcher("Controlador?menu=Registro&accion=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                        break;
                    case "Actualizar":
                        String nom1 = request.getParameter("txtNombres");//se obtiene datos de caja de texto
                        String correo1 = request.getParameter("txtCorreo");
                        //String con1 = request.getParameter("txtPass");
                        String con1 = asegurarClave(request.getParameter("txtPass"));
                        us.setNombre(nom1);//se guardan en cada variable por medio de la clase usuario
                        us.setCorreo(correo1);
                        us.setId(ide);
                        us.setCon(con1);
                        udao.actualizar(us);
                        request.getRequestDispatcher("Controlador?menu=Registro&accion=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                        break;
                    case "Delete":
                        ide = Integer.parseInt(request.getParameter("id"));//guardando el id que llega del Registro.jsp
                        udao.eliminar(ide);
                        request.getRequestDispatcher("Controlador?menu=Registro&accion=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                        break;
                    default:
                        throw new AssertionError();
                }
                //request.getRequestDispatcher("Registro.jsp").forward(request, response);
            }
        }
        if (des == null && usu == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private String asegurarClave(String textoClaro) {
        String claveSha = null;
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            sha256.update(textoClaro.getBytes());

            claveSha = Base64.getEncoder().encodeToString(sha256.digest());
            System.out.println("Clave sha es: " + claveSha);
            System.out.println("Longitud: " + claveSha.length());
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error en instanciar sha256 " + ex.getMessage());
        }
        return claveSha;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
