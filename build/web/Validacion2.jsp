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
        <%@ include file="Principal2.jsp" %>
    <center><br><h1>Validación</h1></center><hr>
    <form action="Controlador?menu2=Validacion2" method="POST">
        <div class="d-flex justify-content-center">
            <div class="card col-sm-5">
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
                        <input type="submit" name="accion2" value="Agregar" class="btn bg-info">
                    </form>
                </div>
            </div>
            <div class="col-sm-5">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>RESPUESTA 1</th>
                            <th>RESPUESTA 2</th>
                            <th>RESPUESTA 3</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="en" items="${encuestas}">
                            <tr>
                                <td class="text-center">${en.getId()}</td>
                                <td class="text-center">${en.getResp1()}</td>
                                <td class="text-center">${en.getResp2()}</td>
                                <td class="text-center">${en.getResp3()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
    </form>
</body>
</html>
