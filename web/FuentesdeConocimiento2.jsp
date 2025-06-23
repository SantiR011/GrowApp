<%-- 
    Document   : FuentesdeConocimiento
    Created on : 19/04/2024, 8:23:23 p. m.
    Author     : Usuario
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Fuentes de Conocimiento</title>
    </head>
    <body>
        <%@ include file="Principal2.jsp" %>
        <font face="Arial, sans-serif">
        <p></p>
    <center><h1>Fuentes de conocimiento</h1><hr></center>
        </font>

        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu2=FuentesdeConocimiento2" method="POST">
                        <div class="form-group">
                            <label>Buscar Fuente de conocimiento por ID:</label>
                            <input type="text" name="txtBuscar" class="form-control"><br>
                            <input type="submit" name="accion2" value="Buscar" class="btn btn-success">
                        </div>
                        <div class="form-group">
                            <label>Titulo</label>
                            <textarea name="txtTitulo" class="form-control" readonly style="height: 150px;">${fuente.getTitulo()}</textarea>
                        </div>
                        <div class="form-group">
                            <label>Descripcion</label>
                            <textarea name="txtDescripcion" class="form-control" readonly style="height: 350px;">${fuente.getDescripcion()}</textarea>
                        </div>
                        <div class="form-group">
                            <label>Archivo</label>
                            <textarea name="txtArchivo" class="form-control" readonly style="height: 160px;">${fuente.getArchivo()}</textarea>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th style="width: 190px;">TITULO</th>
                            <th style="width: 650px;">DESCRIPCION</th>
                            <th style="width: 100px;">ARCHIVO</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="fu" items="${fuentes}">
                        <tr>
                            <td>${fu.getId()}</td>
                            <td>${fu.getTitulo()}</td>
                            <td>${fu.getDescripcion()}</td>
                            <td>${fu.getArchivo()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
