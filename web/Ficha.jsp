<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
        <link href="swetalert/sweetalert.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
    </head>

    <body>
        <div  class="d-md-flex d-sm-flex-column">
            <div id="form_ficha" class="card col-md-4 col-sm-12">

                <form action="controlador?menu=Ficha" method="POST">
                    <h3>CREAR FICHA</h3>
                    <hr width="100%" color="black"/>
                    <div class="form-group">
                        <label>NUMERO DE FICHA</label>
                        <input type="text" value="${ficha.getNficha()}" name="txtNFicha" id="txtNFicha"class="form-control">
                    </div>

                    <div class="form-group">
                        <label>FECHA INICIO</label>

                        <input type="date" value="${ficha.getFechaI()}" name="txtFechaIni" id="txtFechaIni" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>FECHA FIN</label>
                        <input type="date" value="${ficha.getFechaF()}" name="txtFechaFin" id="txtFechaFin" class="form-control">
                    </div>
                    <div class="form-group">

                        <label>PROGRAMA DE FORMACIÓN</label>
                        <select name="program" class="custom-select js-example-basic-single form-control" id="program">
                            <c:forEach var="program" items="${programas}">
                                <option value="${program.getId()}">${program.getNombre()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <a id="agFicha" href="">
                       
                        <input id="guardar" type="submit" name="accion" value="Agregar" >
                        
                    </a>

                    <body>

                </form>



            </div>
       
        <hr width="100%" color="black"/>
            <div class="col-md-8 col-sm-8">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#CrearPrograma">
                CREAR PROGRAMA
            </button>
            <table class="table table-hover" id="datatable">
                <thead>
                    <tr class="bg-success">
                        <th>DNI</th>
                        <th>NUMERO DE FICHA</th>
                        <th>NOMBRE</th>
                        <th>FECHA INICIO</th>
                        <th>FECHA FIN</th>
                        <th>FECHA CREACION</th>
                        <th>ACCIONES</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="fc" items="${fichas}" varStatus="f">
                        <tr>
                            <td>${f.index+1}</td>
                            <td>${fc.getNficha()}</td>
                            <td>${fc.getNombre()}</td>
                            <td>${fc.getFechaI()}</td>
                            <td>${fc.getFechaF()}</td>
                            <td>${fc.getFechaC()}</td>
                            <td>
                                <a href=""  data-toggle="modal" data-target="#exampleModal${fc.getId()}" class="btn btn-warning "><i class=" fa-solid fa-file-pen fa-fade fa-lg" style="color: #080808;"></i>Editar</a>


                                <!--    <a  class="btn btn-warning btn-table"  data-toggle="modal" data-target="#exampleModal">Editar</a>-->
                                <input type="hidden" id="codigoF" value="${fc.getId()}">
                                <a id="deleteFicha" href=""><button type="button" class="btn btn-danger" data-toggle="tooltip"  title="Eliminar" data-original-title="Eliminar">
                                        <i class="fa-solid fa-trash fa-fade fa-lg"></i>Eliminar</button></a>
                            </td>
                        </tr>
                    </c:forEach>


                </tbody>
            </table>

        </div>
    </div>

<!-- Modal -->

<%-- <c:forEach var="programa" items="${programasF}">--%>

<div class="modal fade" id="CrearPrograma" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true" style="margin-top: none;">
    <div class="modal-dialog modal-xl">
        <div class="modal-content border-secundary">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="staticBackdropLabel" style="color: #707070;"><i class="bi bi-file-earmark-check p-1"></i>CREAR PROGRAMA</h1>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <div class="d-flex">
                    <div class="card col-sm-4">
                        <div>
                            <form action="controlador?menu=ProgramaFormacion" method="POST">

                                <div class="form-group">
                                    <label>NOMBRE DE PROGRAMA</label>
                                    <input type="text" value="${ficha.getNficha()}" name="txtNombrePrograma" id="txtNombrePrograma" class="form-control">
                                </div>

                                <div class="form-group">
                                    <label>VIGENCIA</label>

                                    <input type="text" value="${ficha.getFechaI()}" name="txtVigencia" id="txtVigencia" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>VERSION</label>
                                    <input type="text" value="${ficha.getFechaF()}" name="txtVersion"  class="form-control">
                                </div>

                                <a id="agProgram" href="">
                                    <input type="submit" name="accion" value="AgregarPrograma" class="btn btn-info">
                                </a>
                                <!--  <input type="submit" name="accion" value="Actualizar" class="btn btn-success">-->

                            </form>
                        </div>
                    </div>
                    <div class="col-sm-8">

                        <table class="table table-hover" id="datatable">
                            <thead>
                                <tr class="bg-success">
                                    <th>DNI</th>
                                    <th>PROGRAMA</th>
                                    <th>VIDENCIA</th>
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="programasF" items="${programasF}" varStatus="prg">
                                    <tr>
                                        <td>${prg.index+1}</td>
                                        <td>${programasF.getNombre()}</td>
                                        <td>${programasF.getVigencia()}</td>

                                        <td>
                                            <a class="btn btn-warning btn-table" data-toggle="modal" data-target="#programa${programasF.getId()}">Editar</a>

                                            <input type="hidden" id="codigoP" value="${programasF.getId()}">
                                            <a id="deleteProgram" href=""><button type="button" class="btn btn-danger" data-toggle="tooltip"  
                                                                                  title="Eliminar" data-original-title="Eliminar">
                                                    <i class="fa fa-trash"></i>Eliminar</button></a>

                                        </td>
                                    </tr> 



                                </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>                
        </div>
    </div>
</div>                                  
<%-- </c:forEach>--%>    
<!-- Modal actualizar programa de formacion -->
<c:forEach  var="programasF" items="${programasF}">          
    <div class="modal fade" id="programa${programasF.getId()}" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">

                    <h5 class="modal-title" id="exampleModalLabel">ACTUALIZAR</h5>
                </div>
                <form action="controlador?menu=ProgramaFormacion" method="POST">
                    <div class="container">
                        <div class="card col-sm-12">
                            <div>
                                <input type="hidden" name="idProgram" value="${programasF.getId()}"/>
                                <div class="form-group">
                                    <label>NOMBRE DE PROGRAMA</label>
                                    <input type="text" value="${programasF.getNombre()}" name="txtNombre" class="form-control">
                                </div>

                                <div class="form-group">
                                    <label>VIGENCIA</label>

                                    <input type="text" value="${programasF.getVigencia()}" name="txtVigencia" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>VERSION</label>
                                    <input type="text" value="${programasF.getVersion()}" name="txtVersion" class="form-control">
                                </div>

                            </div>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </div>
                </form>
            </div>
        </div>
    </div>
</c:forEach>  

<!-- Modal actualizar fichas -->
<c:forEach  var="fc" items="${fichas}">          
    <div class="modal fade" id="exampleModal${fc.getId()}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">

        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">

                    <h5 class="modal-title fs-5" id="staticBackdropLabel" style="color: #707070;" id="exampleModalLabel">ACTUALIZAR FICHA</h5>
                </div>
                <form action="controlador?menu=Ficha" method="POST">
                    <div class="container">
                        <div class="card col-sm-12">
                            <input type="hidden" name="idFicha" value="${fc.getId()}"/>
                            <div>
                                <div class="form-group">
                                    <label>NUMERO DE FICHA</label>
                                    <input type="text" value="${fc.getNficha()}" name="txtNFicha" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>FECHA INICIO</label>

                                    <input type="date" value="${fc.getFechaI()}" name="txtFechaIni" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>FECHA FIN</label>
                                    <input type="date" value="${fc.getFechaF()}" name="txtFechaFin" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>PROGRAMA DE FORMACIÓN</label>
                                    <select name="program" class="custom-select">
                                        <c:forEach var="program" items="${programas}">
                                            <option value="${program.getId()}">${program.getNombre()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">

                    </div>
                </form>
            </div>
        </div>
    </div>
</c:forEach>
<script
    src="https://code.jquery.com/jquery-3.3.1.min.js"
    integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>  
<script src="swetalert/sweetalert.js" type="text/javascript"></script>
<script src="js/funcionesFicha.js" type="text/javascript"></script>
<script src="js/funcionesPrograma.js" type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
<script src="js/select2.js" type="text/javascript"></script>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $('#datatable').DataTable(
                {
                    buttons: [
                        {
                            extend: 'pdf',
                            exportOptions: {
                                columns: [0, 1, 2, 3, 4]
                            },
                            title: 'Reporte',
                            customize: function (doc) {
                                doc.styles.tableHeader.alignment = 'left'; //giustifica a sinistra titoli colonne
                                doc.content[1].table.widths = [10, 150, 90, 60, 60];
                                doc.content[1].margin = [50, 0, 100, 0]
                            }
                        },
                    ],
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
</html>