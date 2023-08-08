<%-- 
    Document   : Asignar aprendiz a una ficha
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


    </head>
    <body>
        <div class="container">
            <div class="descripcion" >
                <h1>aprendiz que no estan en la ficha ${fichaAct.getNficha()} </h1>

            </div>      
        </div>


        <div class="col-md-12 col-sm-12">
            <table class="table table-sm" id="datatable">
                <thead>
                    <tr class="bg-success">
                        <th>#</th>
                        <th>CEDULA</th>
                        <th>NOMBRE</th>
                        <th>APELLIDO</th>
                        <th>ROL</th>
                        <th>FICHA</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="AsAp" items="${AsignarAprendiz3}" varStatus="Ap">
                        <tr>
                            <td>${Ap.index+1}</td>
                            <td>${AsAp.getCedula()}</td>
                            <td>${AsAp.getNombre()}</td>    
                            <td>${AsAp.getApellido()}</td>
                            <td>${AsAp.getrol()}</td>
                            <td> 
                                ${fichaAct.getNficha()}

                            </td>
                            <td>
                                <form action="controlador?menu=AsignarAprendiz" method="POST">
                                    <input type="hidden" name="idPersona" value="${AsAp.getidAprendiz()}"/>
                                    <input type="hidden" name="fcha" value="${fichaAct.getId()}"/>
                                    <input type="submit" name="accion" value="Asignar" class="btn btn-warning btn-table">
                                </form>

                            </td>
                        </tr>
                    </c:forEach>
                    </form>


                </tbody>
            </table>

        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
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