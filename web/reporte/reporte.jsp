 <%-- 
    Document   : reporte
    Created on : May 10, 2023, 3:05:56 PM
    Author     : jhoan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>

<%@page import="net.sf.jasperreports.engine.*" %>
<%@page import="net.sf.jasperreports.view.JasperDesignViewer" %>

<%@page import="javax.servlet.ServletResponse" %>
<%@include file="conexion.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>reporte</title>
    </head>
    <body>
        <%
            File reportfile = new File (application.getRealPath("reporte/personas/report1.jasper"));
            Map<String, Object> parameter = new HashMap<String,Object>();
            
            byte[] bytes= JasperRunManager.runReportToPdf(reportfile.getPath(), parameter,con);
            
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes,0,bytes.length);
            

            outputStream.flush();
            outputStream.close();
        
        %>
    </body>
</html>
