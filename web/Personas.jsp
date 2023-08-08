<%-- 
    Document   : Personas
    Created on : 8/03/2023, 6:17:15 p. m.
    Author     : jhoan
--%>

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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
    </head>
    <body>
        <div class="d-md-flex d-sm-flex-column">
            <div class="card col-md-4 col-sm-12">
                <div>
                    <form action="controlador?menu=Personas" method="POST">
                        <h3>CREAR PERSONA</h3>
                    <hr width="100%" color="black"/>
                        <div class="form-group">
                            <label>Cedula</label>
                            <input type="text" value="${Personas.getcedula()}" name="txtCedula" id="txtCedula"class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${Personas.getNombre()}" name="txtNombre" id="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Apellido</label>
                            <input type="text" value="${Personas.getapellido()}" name="txtApellido" id="txtApellido" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="text" value="${Personas.getemail()}" name="txtEmail" id="txtEmail" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>IDRol</label>
                            <select name="rl" class="custom-select" id="rl">
                                <c:forEach var="rl" items="${RolPersona}">
                                    <option value="${rl.getIdrol()}">${rl.getprivilegio()}</option>
                                </c:forEach>
                            </select>

                        </div>
                        <div class="form-group">
                            <label>IDExcusa</label>
                            <input type="text" value="${Personas.getIdexcusa()}" name="txtExcusa" id="txtExcusa" class="form-control">
                        </div>
                        <a id="agUser" href="">
                            <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        </a>
                    </form>
                </div>
            </div>
                         <hr width="100%" color="black"/>
            <div class="col-md-8 col-sm-8">
                <table class="table table-sm" id="datatable">
                    <thead>
                        <tr class="bg-success">
                            <th>DNI</th>
                            <th>CEDULA</th>
                            <th>NOMBRE</th>
                            <th>APELLIDO</th>
                            <th>EMAIL</th>
                            <th>USUARIO</th>
                            <th>ROL</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pm" items="${aprendiz}" varStatus="p">
                            <tr >
                                <td>${p.index+1}</td>
                                <td>${pm.getcedula()}</td>
                                <td>${pm.getNombre()}</td>
                                <td>${pm.getapellido()}</td>
                                <td>${pm.getemail()}</td>
                                <td>${pm.getUser()}</td>
                                <td>${pm.getrol()}</td>
                                <td>
                                    <a href=""  data-toggle="modal" data-target="#exampleModal${pm.getId()}" class="btn btn-warning "><i class=" fa-solid fa-file-pen fa-fade fa-lg" style="color: #080808;"></i>Editar</a>


                                    <!-- <a class="btn btn-warning btn-table" href="controlador?menu=Personas&accion=Editar&id=${pm.getId()}">Editar</a> -->

                                    <!-- ELIMINAR USUARIOS --> 
                                    <input type="hidden" id="codigo" value="${pm.getId()}">
                                    <a id="deleteUser" href=""><button type="button" class="btn btn-danger" data-toggle="tooltip"  title="Eliminar" data-original-title="Eliminar">
                                            <i class="fa-solid fa-trash fa-fade fa-lg"></i>Eliminar</button></a>
                   <!-- <a class="btn btn-danger btn-table" href="controlador?menu=Personas&accion=Eliminar&id=${pm.getId()}">Eliminar</a>-->
                                </td>
                            </tr>
                        </c:forEach>


                    </tbody>
                </table>

            </div>
        </div>
        <!-- Modal actualizar persona-->
        <c:forEach  var="Personas" items="${aprendiz}">          
            <div class="modal fade" id="exampleModal${Personas.getId()}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">

                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">

                            <h5 class="modal-title fs-5" id="staticBackdropLabel" style="color: #707070;" id="exampleModalLabel">ACTUALIZAR FICHA</h5>
                        </div>
                        <form action="controlador?menu=Personas" method="POST">
                            <div class="container">
                                <div class="card col-sm-12">
                                    <input type="hidden" name="idPersona" value="${Personas.getId()}"/>
                                    <div>
                                        <div class="form-group">
                                            <label>Cedula</label>
                                            <input type="text" value="${Personas.getcedula()}" name="txtCedula" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>Nombre</label>
                                            <input type="text" value="${Personas.getNombre()}" name="txtNombre"  class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>Apellido</label>
                                            <input type="text" value="${Personas.getapellido()}" name="txtApellido" i class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>Email</label>
                                            <input type="text" value="${Personas.getemail()}" name="txtEmail" class="form-control">
                                        </div>
                                        <div class="form-group">
                                    <label>IDRol</label>
                                    <select name="rl" class="custom-select" >
                                        <c:forEach var="rl" items="${RolPersona}">
                                            <option value="${rl.getIdrol()}">${rl.getprivilegio()}</option>
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
        <script src="js/funcionesUsuario.js" type="text/javascript"></script>
    </body>
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

</html>
<!-- <%@ include file="commons/footer.jspf"%> -->