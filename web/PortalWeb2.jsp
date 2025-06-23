<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Portal Web</title>
    </head>
    <body>
        <%@ include file="Principal2.jsp" %>
        <section>
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="img/1.jpg" class="d-block w-100" height="750">
                        <div class="carousel-caption d-none d-md-block">
                            <a type="button" href="Controlador?menu2=InformaciondeProyecto2&accion2=Listar" class="btn-lg" style="color:black; background-color: #64F191;">Información del proyecto</a>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="img/2.jpg" class="d-block w-100" height="750">
                        <div class="carousel-caption d-none d-md-block">
                            <a type="button" href="Controlador?menu2=FuentesdeConocimiento2&accion2=Listar" class="btn-lg" style="color:black; background-color: #64F191;">Fuentes de conocimiento</a>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="img/3.jpg" class="d-block w-100" height="750">
                        <div class="carousel-caption d-none d-md-block">
                            <a type="button" href="Controlador?menu2=Registro2&accion2=Listar" class="btn-lg" style="color:black; background-color: #64F191;">Registro</a>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="img/4.jpg" class="d-block w-100" height="750">
                        <div class="carousel-caption d-none d-md-block">
                            <a type="button" href="Controlador?menu2=Validacion2&accion2=Listar" class="btn-lg" style="color:black; background-color: #64F191;">Validación</a>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="img/5.jpg" class="d-block w-100" height="750">
                        <div class="carousel-caption d-none d-md-block">
                            <a type="button" href="Controlador?menu2=PreguntasFrecuentes2" class="btn-lg" style="color:black; background-color: #64F191;">Preguntas frecuentes</a>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </section>
    </body>
</html>
