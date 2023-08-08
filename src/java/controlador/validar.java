/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Personas;
import modelo.PersonasDAO;

/**
 *
 * @author jhoan
 */
public class validar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    PersonasDAO pdao = new PersonasDAO();
    Personas pm = new Personas();
    boolean session = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet validar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet validar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("ingresar")) {
            String User = request.getParameter("txtuser");
            String Pass = request.getParameter("txtpassword");
            pm = pdao.validar(User, Pass);
            if (pm.getUser() != null) {
                session = true;
            }
            if (pm.getUser() != null && session && pm.getrol().equals("1")) {

                System.out.println("session: " + session);
                System.out.println("adm: " + pm.getrol());
                request.setAttribute("usuario", pm);
                request.getRequestDispatcher("controlador?menu=principal").forward(request, response);
                //System.out.println("admin");

            }
            if (pm.getUser() != null && session && pm.getrol().equals("2")) {
                request.setAttribute("usuario", pm);
                //request.getRequestDispatcher("controlador?menu=HomeAprendiz").forward(request, response);
                request.getRequestDispatcher("viewAprendiz.jsp").forward(request, response);
                   // System.out.println("aprendiz");
            }
            else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
                                  //  System.out.println("nada");

            }

        }
        if (accion.equalsIgnoreCase("salir")) {
            session = false;
            pm = null;
            System.out.println("session: " + session);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
