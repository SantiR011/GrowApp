<%-- 
    Document   : Validacion
    Created on : 19/04/2024, 8:23:35 p. m.
    Author     : Usuario
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validación</title>
    </head>
    <body>
        <%@ include file="Principal.jsp" %>
    <center><h1>Validación</h1><hr></center>

    <div class="d-flex justify-content-center">
        <div class="card col-sm-4">
            <div class="card-body">
                <form action="Controlador?menu=Validacion" method="POST">
                    <div class="form-group">
                        <label>En una escala del 1 al 5</label>
                        <label>¿Qué tan intuitiva encontraste la interfaz de la aplicación?</label>
                        <input type="text" value="${encuesta.getResp1()}" name="txtResp1" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>¿Qué tan fácil fue para ti navegar por las diferentes secciones de la aplicación?</label>
                        <input type="text" value="${encuesta.getResp2()}" name="txtResp2" class="form-control">
                    </div>
                    <div class="form-group">
                        <label> ¿Qué tan útil te resultó la información proporcionada por la aplicación para el cuidado de tus cultivos de tomate?</label>
                        <input type="text" value="${encuesta.getResp3()}" name="txtResp3" class="form-control">
                    </div>
                    <input type="submit" name="accion" value="Agregar" class="btn bg-info">
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                </form>
            </div>
        </div>
        <div class="col-sm-6">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">RESPUESTA 1</th>
                        <th class="text-center">RESPUESTA 2</th>
                        <th class="text-center">RESPUESTA 3</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="en" items="${encuestas}">
                        <tr>
                            <td class="text-center">${en.getId()}</td>
                            <td class="text-center">${en.getResp1()}</td>
                            <td class="text-center">${en.getResp2()}</td>
                            <td class="text-center">${en.getResp3()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Validacion&accion=Editar&id=${en.getId()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Validacion&accion=Delete&id=${en.getId()}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</body>
</html>
