
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Preguntas frecuentes</title>
    </head>
    <body>
        <%@ include file="Principal2.jsp" %>
        <font face="Arial, sans-serif">
        <h1>Preguntas frecuentes</h1><hr><hr>
  
        <div class="accordion" id="accordionExample">
            <div class="card">
                <div class="card-header" id="1">
                    <h2 class="mb-0">
                        <button style="color: #64F191" class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            ¿Qué es un cultivo hidropónico?
                        </button>
                    </h2>
                </div>
                <div id="collapseOne" class="collapse show" aria-labelledby="1" data-parent="#accordionExample">
                    <div class="card-body">
                        El cultivo hidropónico es un método de cultivo de plantas que no utiliza suelo, en su lugar, las raíces se desarrollan en una solución nutritiva que proporciona todos los nutrientes necesarios.
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header" id="2">
                    <h2 class="mb-0">
                        <button style="color: #64F191" class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            ¿Cómo funciona el sistema de monitoreo en el cultivo hidropónico?
                        </button>
                    </h2>
                </div>
                <div id="collapseTwo" class="collapse" aria-labelledby="2" data-parent="#accordionExample">
                    <div class="card-body">
                        El sistema de monitoreo recopila datos clave como pH del agua, temperatura y humedad, y los presenta de manera accesible a través de la aplicación web para que las personas usuarias del portal web puedan supervisar y optimizar las condiciones de crecimiento de las plantas.
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header" id="3">
                    <h2 class="mb-0">
                        <button style="color: #64F191" class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                            ¿Cuáles son los beneficios de utilizar un sistema de monitoreo en un cultivo hidropónico?
                        </button>
                    </h2>
                </div>
                <div id="collapseThree" class="collapse" aria-labelledby="3" data-parent="#accordionExample">
                    <div class="card-body">
                        Los beneficios incluyen un mayor control sobre las condiciones de crecimiento, detección temprana de problemas, optimización de los recursos y aumento de la productividad de los cultivos.
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header" id="4">
                    <h2 class="mb-0">
                        <button style="color: #64F191" class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                            ¿Qué tipo de datos puedo monitorear a través de la aplicación web?
                        </button>
                    </h2>
                </div>
                <div id="collapseFour" class="collapse" aria-labelledby="4" data-parent="#accordionExample">
                    <div class="card-body">
                        Los usuarios pueden monitorear datos como el pH del agua, la temperatura y la humedad de su cultivo.
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header" id="5">
                    <h2 class="mb-0">
                        <button style="color: #64F191" class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                            ¿Cómo se recopilan los datos del cultivo?
                        </button>
                    </h2>
                </div>
                <div id="collapseFive" class="collapse" aria-labelledby="5" data-parent="#accordionExample">
                    <div class="card-body">
                        Los datos se recopilan mediante sensores instalados en el sistema hidropónico que transmiten la información a la aplicación web a través de una conexión a internet (IoT).
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header" id="6">
                    <h2 class="mb-0">
                        <button style="color: #64F191" class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
                            ¿Qué es IoT?
                        </button>
                    </h2>
                </div>
                <div id="collapseSix" class="collapse" aria-labelledby="6" data-parent="#accordionExample">
                    <div class="card-body">
                        IoT, o Internet de las Cosas (Internet of Things en inglés), se refiere a la red de dispositivos físicos que están conectados entre sí y a internet, permitiéndoles recopilar y compartir datos. Estos dispositivos pueden ser desde electrodomésticos y dispositivos industriales hasta sensores y otros objetos cotidianos.
                        En el contexto de un sistema de monitoreo de cultivo hidropónico, el IoT podría involucrar sensores instalados en el sistema que recopilan datos como la temperatura, la humedad del aire, el nivel de nutrientes en el agua y otros parámetros relevantes para el cultivo. Estos datos se transmiten a través de una conexión a internet a una aplicación web o plataforma en la nube, donde los agricultores pueden monitorear y gestionar el cultivo en tiempo real. La integración de dispositivos IoT en sistemas agrícolas permite un monitoreo más preciso y eficiente, lo que puede conducir a un mejor rendimiento y una gestión más sostenible de los cultivos.
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header" id="7">
                    <h2 class="mb-0">
                        <button style="color: #64F191" class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
                            ¿Qué tan precisa es la información proporcionada por la aplicación?
                        </button>
                    </h2>
                </div>
                <div id="collapseSeven" class="collapse" aria-labelledby="7" data-parent="#accordionExample">
                    <div class="card-body">
                        La precisión de la información depende de la calidad de los sensores utilizados, pero en general, se esfuerza por proporcionar datos precisos y confiables.
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header" id="8">
                    <h2 class="mb-0">
                        <button style="color: #64F191" class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseEight" aria-expanded="false" aria-controls="collapseEight">
                            ¿Qué dispositivos son compatibles con la aplicación web?
                        </button>
                    </h2>
                </div>
                <div id="collapseEight" class="collapse" aria-labelledby="8" data-parent="#accordionExample">
                    <div class="card-body">
                        La aplicación web es compatible con una variedad de dispositivos, incluyendo computadoras de escritorio, portátiles, tabletas y teléfonos inteligentes.
                    </div>
                </div>
            </div>
        </div>
        </font>
    </body>
</html>
