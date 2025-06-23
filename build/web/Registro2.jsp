
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Modelo.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <%@ include file="Principal2.jsp"%>
    <center>
        <div class="d-flex justify-content-center">
            <div class="card col-sm-3">
                <div class="card" style="width: 18rem; display: flex; align-items: center;">
                    <img src="img/user.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Usuario</h5>
                        <p class="card-text">Sistema de monitoreo de cultivo hidropónico</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Nombre: ${usuario.getNombre()}</li>
                        <li class="list-group-item">Correo: ${usuario.getCorreo()}</li>
                    </ul>
                </div>
            </div>
            <div class="card col-sm-4" style="display: flex; justify-content: center;">
                <form action="Controlador?menu2=Registro2" method="POST">
                    <div class="form-group">
                        <label>Cambiar Contraseña</label>
                        <input type="text" value="${usuario.getId()}" name="txtId" class="form-control" style="width: 40px;" readonly>
                        <input type="password" value="${usuario.getCon()}" name="txtContra" class="form-control" style="width: 330px;">
                    </div>
                    
                    <input type="submit" name="accion2" value="Cambiar" class="btn bg-info">
                </form>
            </div>
        </div>
    </center>
</body> 
</html>
