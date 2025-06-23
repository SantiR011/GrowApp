
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Modelo.Usuario"%>
<%@page import = "Modelo.Desarrollador"%>
<%
    HttpSession sesion = request.getSession();
    Usuario usu = (Usuario) sesion.getAttribute("usuario");
    Desarrollador des = (Desarrollador) sesion.getAttribute("desarrollador");
    response.setHeader("Cache-Control","no-cache, no-store, must-revalidate" );
    

    
    if(usu!=null || des!=null){
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Portal Web</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #64F191;">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a style="margin-left: 20px; border: none; color: #000000;" class="btn btn-outline-light" href="Controlador?menu=PortalWeb&accion=Listar" target="_self">Portal Web</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 20px; border: none; color: #000000;" class="btn btn-outline-light" href="Controlador?menu=InformaciondeProyecto&accion=Listar" target="_self">Información del proyecto</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 20px; border: none; color: #000000;" class="btn btn-outline-light" href="Controlador?menu=FuentesdeConocimiento&accion=Listar" target="_self">Fuentes de conocimiento</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 20px; border: none; color: #000000;" class="btn btn-outline-light" href="Controlador?menu=Registro&accion=Listar" target="_self">Registro</a>                 
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 20px; border: none; color: #000000;" class="btn btn-outline-light" href="Controlador?menu=Validacion&accion=Listar" target="_self">Validación</a>                 
                    </li>

                </ul>
            </div>
            <div class="dropdown text-center">
                <button style="border: none; color: #000000" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${desarrollador.getNombre()}
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">
                        <img src="img/user.png" alt="60" width="60"/>
                    </a>
                    <a class="dropdown-item" href="#">${desarrollador.getCorreo()}</a>
                    <div class="dropdown-divider"></div>
                    <form action="Validar2" method="POST">
                        <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                    </form>
                </div>
            </div>
        </nav>


        <!-- 
        
        <div class="m-4" style="height: 550px;">
            <iframe name="myFrame" style="height: 107%; width: 100%; border: none"></iframe>
        </div>
        
        -->


        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>

<%
    }else{
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
%>