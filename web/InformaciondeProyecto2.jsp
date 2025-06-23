
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Informacion de proyecto</title>
    </head>
    <body style="overflow-x: hidden;">
        <%@ include file="Principal2.jsp" %>
        <font face="Arial, sans-serif">
        <p></p>
    <center>
        <h1>Información de proyecto</h1><hr><hr>
        <h2>Título: Sistema de monitoreo en un cultivo hidropónico de tomates</h2>
        <img src="img/cultivo2.jpg" alt="370" width="470"><hr>
        <h2>Objetivos general</h2>
        <h5>Diseñar, desarrollar e implementar un sistema de monitoreo para cultivos hidropónicos que permita optimizar el 
            crecimiento, la salud y el rendimiento de las plantas, mediante la recopilación, análisis y visualización de 
            datos en tiempo real, con el fin de mejorar la eficiencia del cultivo y garantizar una producción agrícola 
            sostenible</h5>
        <hr><h2>Objetivos especificos</h2>  
    </center>
    </font>

    <div class="card-deck">
        <div class="card" style="max-width: 21rem;">
            <img src="img/Obj1.png" class="card-img-top">
            <div class="card-body">
                <h5 class="card-title">Objetivo 1</h5>
                <p class="card-text">• Investigar y seleccionar los sensores adecuados para medir parámetros clave del cultivo hidropónico, como pH del agua, nivel de nutrientes, temperatura ambiente, humedad relativa y luminosidad</p>
            </div>
        </div>
        <div class="card" style="max-width: 21rem;">
            <img src="img/Obj2.png" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Objetivo 2</h5>
                <p class="card-text">• Diseñar e implementar un sistema de adquisición de datos que pueda recopilar información de los sensores de manera precisa y en tiempo real.</p>
            </div>
        </div>
        <div class="card" style="max-width: 21rem;">
            <img src="img/Obj3.png" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Objetivo 3</h5>
                <p class="card-text">• Crear una interfaz de usuario intuitiva y accesible que permita a los usuarios monitorear el estado del cultivo, recibir alertas sobre condiciones anormales y ajustar los parámetros según sea necesario.</p>
            </div>
        </div>
        <div class="card" style="max-width: 21rem;">
            <img src="img/Obj4.png" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Objetivo 4</h5>
                <p class="card-text">•	Documentar todo el proceso de desarrollo e implementación del sistema, incluyendo especificaciones técnicas, diagramas de flujo, código fuente y manuales de usuario, para facilitar su replicación y mantenimiento.</p>
            </div>
        </div>
    </div>

    <center>
        <hr><h2>Integrantes</h2><br>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="card border-success mb-3" style="max-width: 18rem;">
                        <div class="card-header">Integrante 1</div>
                        <div class="card-body text-success">
                            <h5 class="card-title">Santiago Hernandez</h5>
                            <p class="card-text">Estudiante de Tecnología en Sistematización de Datos de la Universidad Distrital Francisco José de Caldas.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card border-success mb-3" style="max-width: 18rem;">
                        <div class="card-header">Integrante 2</div>
                        <div class="card-body text-success">
                            <h5 class="card-title">Alejandra Milquez</h5>
                            <p class="card-text">Estudiante de Tecnología en Sistematización de Datos de la Universidad Distrital Francisco José de Caldas.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <center>
            <hr><hr><h2>Progreso</h2>
        </center>
        <div class="col-sm-3">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>MODULO</th>
                        <th>PORCENTAJE (%)</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pr" items="${progresos}">
                        <tr>
                            <td class="text-center">${pr.getId()}</td>
                            <td class="text-center">${pr.getPorcentaje()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
    </center>
    <div class="alert alert-success" role="alert">
        <center>
            Contacto<br>
            Santiago Hernandez : @udistrital.edu.co<br>
            Alejandra Milquez : alejarodriguezr@udistrital.edu.co
        </center>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
