<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>JSP Page</title>
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>


</head>

<body>
   
<!-- Modal -->

<%-- <c:forEach var="programa" items="${programasF}">--%>

                <div class="modal-body">
                    <div class="d-flex">
                        <div class="card col-sm-4">
                            <div>
                                <form action="controlador?menu=ProgramaFormacion" method="POST">

                                    <div class="form-group">
                                        <label>NOMBRE DE PROGRAMA</label>
                                        <input type="text" value="${progrm.getNombre()}" name="txtNombrePrograma" class="form-control">
                                    </div>

                                    <div class="form-group">
                                        <label>VIGENCIA</label>

                                        <input type="text" value="${progrm.getVigencia()}" name="txtVigencia" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>VERSION</label>
                                        <input type="text" value="${progrm.getVersion()}" name="txtVersion" class="form-control">
                                    </div>

                                        <input type="submit" name="accion" value="AgregarPrograma" class="btn btn-info">
                                        <!--  <input type="submit" name="accion" value="Actualizar" class="btn btn-success">-->

                                </form>
                            </div>
                        </div>
                        <div class="col-sm-8">
                           
                                <table class="table table-hover">
                                    
                                <thead>
                                    <tr>
                                        <th>DNI</th>
                                        <th>PROGRAMA</th>
                                        <th>VIDENCIA</th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                     <c:forEach var="programasF" items="${programasx}">
                                        <tr>
                                            <td>${programasF.getId()}</td>
                                            <td>${programasF.getNombre()}</td>
                                            <td>${programasF.getVigencia()}</td>

                                            <td> 
                                                <a class="btn btn-warning btn-table" data-toggle="modal" data-target="#programa" href="controlador?menu=ProgramaFormacion&accion=Editar&id=${programasF.getId()}">Editar</a>

                                            </td>
                                        </tr> 
                                      </c:forEach>
                                </tbody>
                                
                            </table>
                          
                        </div>
                    </div>
            </div>                
                             
<%-- </c:forEach>--%>    
<!-- Modal actualizar programa de formacion -->

    <div class="modal fade" id="programa" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h5 class="modal-title" id="exampleModalLabel">ACTUALIZAR</h5>
            </div>

            <div class="container">
                <div class="card col-sm-12">
                    <div>
                        <form action="controlador?menu=Ficha" method="POST">

                             <div class="form-group">
                                <label>NOMBRE DE PROGRAMA</label>
                                <input type="text" value="${pg.getNombre()}" name="txtNFicha" class="form-control">
                            </div>

                            <div class="form-group">
                                <label>VIGENCIA</label>

                                <input type="date" value="${pg.getVigencia()}" name="txtFechaIni" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>VERCION</label>
                                <input type="date" value="${pg.getVersion()}" name="txtFechaFin" class="form-control">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
            </div>
        </div>
    </div>
</div>
      
<!-- Modal -->

        

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>