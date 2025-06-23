
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
        <%@ include file="Principal.jsp"%>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Registro" method="POST">
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${usuario.getNombre()}" name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Correo</label>
                            <input type="text" value="${usuario.getCorreo()}" name="txtCorreo" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" value="${usuario.getCon()}" name="txtPass" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn bg-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOMBRES</th>
                            <th>CORREO</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="us" items="${usuarios}">
                        <tr>
                            <td>${us.getId()}</td>
                            <td>${us.getNombre()}</td>
                            <td>${us.getCorreo()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Registro&accion=Editar&id=${us.getId()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Registro&accion=Delete&id=${us.getId()}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
    </body>
</html>
