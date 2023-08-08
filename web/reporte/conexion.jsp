<%-- 
    Document   : reporte1
    Created on : May 10, 2023, 12:40:36 PM
    Author     : jhoan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="java.io.File" %>
<%@page import="java.sql.*" %>
<%@page import="config.conexion"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            //Variables a utilizar
           /*conexion cn = new conexion();
            Connection con;
            con = DriverManager.getConnection(url
            cn.getUrl());
            PreparedStatement ps;
            */
           Connection con = null;
           try {
                   Class.forName("com.mysql.jdbc.Driver");
                   con= (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/asistencia2","root","");
                   //System.out.println("Conexion ok");
                   //out.print("conexion yue");
               } catch (Exception e) {
               //System.out.println("Error: "+e.getMessage());
               }
            


        %>

    </body>
</html>
