<%-- 
    Document   : RegistrarVenta
    Created on : 8/03/2023, 6:14:17 p. m.
    Author     : jhoan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Asistencia"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
        <link href="swetalert/sweetalert.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilosAsistencia.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
        <div class="container">
            <div class="descripcion" >
                <h1>POR FAVOR PROCEDA A REALIZAR SU ASISTENCIA DEL DIA DE  HOY ${fichaAct.getNficha()}
                </h1>
                <hr>
            </div>      
        </div>
        <%
            int cont = 0;
        %>

        <div class="container">
            <div class="row col-md-10">
                <div class="card-tablas">
                    <div class="tablas">
                        <table id="datatable" class="table table-bordered col-sm-12 col-md-12 col-lg-12 col-xl-12">
                            <thead class="table-">
                            <div class="col-3 offset-md ">
                                <h6>fecha de asistencia</h6>
                            
                            <input style="width: 10em" type="datetime-local" name="txtFecha"  class="form-control" required>
                            </div>
                            <tr class="bg-success">

                                <th scope="col">#</th>
                                <th scope="col">Identificacion</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">apellido</th>
                                <th scope="col">Asistencia</th>
                                <th scope="col">total Inasistencia</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody class="table-active">
                                <c:forEach var="Am" items="${asistencia}" varStatus="loop"> 
                                <form action="controlador?menu=R_Asistencia" method="POST">

                                    <tr>
                                        <td>${Am.getId()}</td>
                                        <td>${Am.getCedula()}</td>
                                        <td>${Am.getNombre()}</td>
                                        <td>${Am.getApellido()}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test='${registrados.contains(Am.getIdPersona().concat("-1"))}'>
                                                    <label>Asistio</label>
                                                </c:when>
                                                <c:when test='${registrados.contains(Am.getIdPersona().concat("-2"))}'>
                                                    <label>No Asistio</label>
                                                </c:when>
                                                <c:when test='${registrados.contains(Am.getIdPersona().concat("-3"))}'>
                                                    <label>Tiene excusa</label>
                                                </c:when>
                                                <c:otherwise>
                                                    <select class="form-control" name="select">
                                                        <option value="1" selected>Asistio</option>
                                                        <option value="2" >No asistio</option>
                                                        <option value="3" >Mando excusa</option>
                                                    </select>                                          
                                                </c:otherwise>
                                            </c:choose>


                                        </td>
                                        <td>${Am.getTotal_inasistencia()}</td>
                                        <td style="display:none;" name="idPersona">${Am.getIdPersona()}</td>
                                    </tr>
                                </form>

                            </c:forEach> 
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <button href="" name="registrarAsistencia"  value="Enviar Asistencia" class="btn btn-success">Enviar Asistencia</button>

        </div>

        <!--  <a href="controlador?menu=R_Asistencia&accion=Reporte" name="reporte"  value="generar reporte" class="btn btn-success">generar reporte</a> -->




        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
        <script src="js/funcionesAsistencia.js" type="text/javascript"></script>
        <script src="swetalert/sweetalert.js" type="text/javascript"></script>

        <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>   

        <script type="text/javascript">
            $(document).ready(function () {
                $('#datatable').DataTable(
                        {

                            "ordering": false,
                            "lengthMenu": [[5, 10, 25, 50, -1], [5, 10, 25, 50, "All"]],
                            "scrollCollapse": true,
                            "language": {
                                "sProcessing": "Procesando...",
                                "sLengthMenu": "Mostrar _MENU_ registros",
                                "sZeroRecords": "No se encontraron resultados",
                                "sEmptyTable": "Ningún dato disponible en esta tabla",
                                "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                                "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                                "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
                                "sInfoPostFix": "",
                                "sSearch": "Buscar:",
                                "sUrl": "",
                                "sInfoThousands": ",",
                                "sLoadingRecords": "Cargando...",
                                "oPaginate": {
                                    "sFirst": "Primero",
                                    "sLast": "Último",
                                    "sNext": "Siguiente",
                                    "sPrevious": "Anterior"
                                },
                                "oAria": {
                                    "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                                    "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                                }
                            }

                        });
            });

        </script>
    </body>
</html>

