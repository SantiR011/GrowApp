
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Modelo.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Inicio Sesion</title>
    </head>
    <body>
        <div class="container mt-3 col-lg-6">
            <div class="card col-sm-10">
                <div class="card-body">
                    <form class="form-sign" action="Validar" method="POST">
                        <div class="form-group text-center">
                            <p style="font-family: Arial, sans-serif; font-size: 50px;">Login</p>
                            <p style="font-family: Arial, sans-serif; font-size: 20px;">Usuario</p>
                            <img src="img/cultivo.jpg" alt="370" width="370"/>
                            <p style="font-family: Arial, sans-serif; font-size: 20px;">Bienvenido al Sistema</p>
                        </div>
                        
                        <div class="form-group">
                            <label>Correo:</label>
                            <input type="text" name="txtcorreo" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Password:</label>
                            <input type="password" name="txtpass" class="form-control">
                        </div>
                        
                        <input type="submit" name="accion2" value="Ingresar" class="btn btn-danger btn-block">
                        <input type="submit" name="accion2" value="Desarrollador" class="btn btn-primary btn-block">
                        
                        <% 
                            String mensaje = (String) request.getAttribute("mensaje");
                            System.out.println("Mensaje1 : " + mensaje);
                            if (mensaje != null && !mensaje.isEmpty()) { 
                        %>
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            <%= mensaje %>
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <% } %>
                        
                    </form>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
