
package Controlador;

import Modelo.Desarrollador;
import Modelo.DesarrolladorDAO;
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
import java.util.Base64;

@WebServlet(name = "Validar2", urlPatterns = {"/Validar2"})
public class Validar2 extends HttpServlet {

    DesarrolladorDAO ddao = new DesarrolladorDAO();
    Desarrollador des = new Desarrollador();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        System.out.println("Accion : " + accion);
        if (accion.equalsIgnoreCase("Ingresar")) {
            System.out.println("txtcorreoo: " + request.getParameter("txtcorreoo"));
            String correo = request.getParameter("txtcorreoo");//recibe usuario
            //String pass = request.getParameter("txtpass");//recibe contraseña
            String pass = asegurarClave(request.getParameter("txtpasss"));//recibe contraseña
            Desarrollador item = new Desarrollador();
            item.setCorreo(correo);
            item.setCon(pass);//setcontraseña
            des = ddao.validar(item);//(item)
            if (des.getCorreo() != null) {
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                response.resetBuffer();
                response.reset();
                //response.setHeader("Pragma","no-cache" );
                HttpSession sesion = request.getSession();
                System.out.println("sesion numero: " + sesion.getId());
                sesion.setAttribute("desarrollador", des);
                //request.setAttribute("usuario", em);//enviar datos al principal para visualizar

                request.getRequestDispatcher("Controlador?menu=PortalWeb").forward(request, response);
            } else {
                //request.getRequestDispatcher("Controlador?accion=Principal").forward(request, response);
                //request.getRequestDispatcher("index.jsp").forward(request, response);
                request.getRequestDispatcher("Controlador?menu=PortalWeb").forward(request, response);
            }
        } else {
            request.setAttribute("mensaje", "¡Contraseña incorrecta! Por favor, inténtalo de nuevo.");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
        
        if (accion.equalsIgnoreCase("Salir")) {
            HttpSession sesion = request.getSession();
            sesion.removeAttribute("desarrollador");
            sesion.invalidate();
            //request.logout();
            response.resetBuffer();
            response.reset();
            request.getRequestDispatcher("Controlador?accion=PortalWeb").forward(request, response);
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
