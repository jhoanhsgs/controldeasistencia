<%-- 
    Document   : Home
    Created on : 26/03/2023, 8:35:08 p. m.
    Author     : jhoan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <link href="css/navb.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"/>
    </head>
    <body>
        <div class="container">
            
            <div class="" >
                <h1>BIENVENIDOS A NUESTRO PANEL PRICIPAL POR FAVOR 
                    SELECCIONE LA FICHA  A LA CUAL TIENE EL DIA DE HOY
                </h1>
                <hr>
            </div> 

        </div>

        <div class="container">
            <div class="row mt-5 ">
                <!-- <%@page import="modelo.FichaDAO" %>
                <%@page import="modelo.Ficha" %>
                <% Ficha fc = new Ficha();
                    FichaDAO fdao = new FichaDAO();
                    
                    List lista1 = fdao.listar();
                    request.setAttribute("fichas", lista1);
                %> -->
                <c:forEach  var="f" items="${fichas}">
                    <div class="col-12  col-md-6 col-lg-3  ">
                        <div class="card mg-900spx">
                            <div class="card-body ">
                                <h5 class="card-title">${f.getNficha()}</h5>
                                <p class="card-text">${f.getNombre()}</p>
                                <a href="controlador?menu=Home&accion=selectFicha&id=${f.getId()}" <i class="fa-solid fa-right-to-bracket fa-beat fa-2xl" style="color: #000000;"></i></a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>


        </div>


        <footer class="pie-pagina">
            <h3>Complejo Tecnologico Agroindustrial Pecuario y Turistico  (SENA)</h3>
            <div class="grupo-2">
                <small>&copy; 2023 <b>(SENA)</b> - Todos los Derechos Reservados.</small>
            </div>




        </footer>


        <script src="https://kit.fontawesome.com/eb496ab1a0.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    </body>
</html>
