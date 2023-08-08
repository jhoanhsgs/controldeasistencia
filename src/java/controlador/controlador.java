/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Asistencia;
import modelo.AsistenciaDAO;
import modelo.Ficha;
import modelo.FichaDAO;
import modelo.Personas;
import modelo.PersonasDAO;
import modelo.fichas;
import modelo.AsignarAprendiz;
import modelo.AsignarAprendizDAO;
import modelo.Programa;
import modelo.ProgramaDao;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import modelo.asignarInstructorDAO;
import modelo.asignarInstructor;
import paquete.CargarDatosXlsxAMySQL;

/**
 *
 * @author jhoan
 */
public class controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //personas
    Personas pm = new Personas();
    PersonasDAO pdao = new PersonasDAO();
    int ida;
    //ficha
    int idf;
    Ficha fc = new Ficha();
    FichaDAO fdao = new FichaDAO();
    Asistencia Am = new Asistencia();
    AsistenciaDAO Adao = new AsistenciaDAO();
    AsignarAprendiz AsAp = new AsignarAprendiz();
    AsignarAprendizDAO AsApdao = new AsignarAprendizDAO();
    Programa Pf = new Programa();
    ProgramaDao Pfdao = new ProgramaDao();
    int ids;
    List asistencia, registrados;
    String fichaActual = "0";
    asignarInstructorDAO AsInsDao = new asignarInstructorDAO();
    asignarInstructor AsIns = new asignarInstructor();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //este menu recibe y nos ejectura la accion de ver los datos en la tabla 
        //ni yo entendi lo que escribi pero se como es
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("principal")) {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        }
        if (menu.equals("HomeAprendiz")) {
            String id = request.getParameter("id");
            //System.out.println("id persona:"+id);
            Personas nper = pdao.listarId(Integer.parseInt(id));
            String inasistencias = Adao.Inasistencias(id);
            System.out.println("inasistencia:"+inasistencias);
            request.setAttribute("persona", nper);
            request.setAttribute("inasistencia", inasistencias);

            request.getRequestDispatcher("viwAhome.jsp").forward(request, response);
        }
        if (menu.equals("Reportes")) {
            
        }
        if (menu.equals("Ficha")) {
            switch (accion) {
                case "listarFicha":
                    List lista1 = fdao.listar();
                    List pmList = fdao.programas();
                    List pfList = Pfdao.programas();

                    request.setAttribute("fichas", lista1);
                    request.setAttribute("programas", pmList);
                    request.setAttribute("programasF", pfList);

                    break;
                case "butt":
                    request.getRequestDispatcher("controlador?menu=Personas&accion=Listar").forward(request, response);

                    break;
                case "Agregar":
                    Ficha nFicha = new Ficha();
                    System.out.println("Agregando ficha...");

                    String numFicha = request.getParameter("txtNFicha");
                    String fechaIni = request.getParameter("txtFechaIni");
                    String fechaFin = request.getParameter("txtFechaFin");
                    String programa = request.getParameter("program");

                    nFicha.setNficha(numFicha);
                    nFicha.setFechaI(fechaIni);
                    nFicha.setFechaF(fechaFin);
                    nFicha.setIdprogformacion(programa);

                    //String regex = "^[0-9]+$";
                    // Creamos un objeto Pattern
                    //Pattern pattern = Pattern.compile(regex);
                    // Creamos un objeto Matcher
                    // Matcher matcher = pattern.matcher(numFicha);
                    // Validamos si la cadena de texto contiene solo números
                    fdao.agregar(nFicha);
                    //   request.getRequestDispatcher("controlador?menu=Ficha&accion=listarFicha").forward(request, response);
                    response.setContentType("text/html");
                    response.setStatus(HttpServletResponse.SC_OK);
                    // if (!matcher.matches()) {
                    //response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

                    //    }
                    PrintWriter out = response.getWriter();
                    break;
                case "Editar":
                    String ida2 = request.getParameter("id");
                    Ficha e = fdao.listar(ida2);
                    request.setAttribute("ficha", e);
                    request.getRequestDispatcher("controlador?menu=Ficha&accion=listarFicha").forward(request, response);
                    System.out.println("controlador listar" + e);
                    break;
                case "Eliminar":
                    idf = Integer.parseInt(request.getParameter("id"));
                    System.out.println("este es el id f a dele" + idf);
                    try {
                        fdao.eliminar(idf);//ejecutamos el metodo eliminar dentro de la clase personasdao
                        request.getRequestDispatcher("controlador?menu=Ficha&accion=listarFicha").forward(request, response);

                    } catch (Exception ef) {
                        request.setAttribute("msje", "No se pudo acceder a la base de datos" + ef.getMessage());
                        System.out.println("no se pudo ctr ficha" + ef);
                    }

                    break;
                case "Actualizar":
                    String Nficha = request.getParameter("txtNFicha");
                    String FechaI = request.getParameter("txtFechaIni");
                    String FechaF = request.getParameter("txtFechaFin");
                    String program = request.getParameter("program");
                    String id = request.getParameter("idFicha");

                    fc.setNficha(Nficha);
                    fc.setFechaI(FechaI);
                    fc.setFechaF(FechaF);
                    fc.setIdprogformacion(program);
                    fc.setId(Integer.parseInt(id));
                    fdao.Actualizar(fc);
                    //request.getRequestDispatcher("controlador?menu=Ficha&accion=listarFicha").forward(request, response);
                    System.out.println("ctr" + idf);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Ficha.jsp").forward(request, response);
        }
        if (menu.equals("Personas")) {
            System.out.println(accion);
            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    List pmRol = pdao.rol();
                    request.setAttribute("aprendiz", lista);
                    request.setAttribute("RolPersona", pmRol);
                    request.setAttribute("cont", 0);

                    break;
                case "Agregar":
                    Personas nPersona = new Personas();

                    System.out.println("Agregando");

                    String cedula = request.getParameter("txtCedula");
                    String nombre = request.getParameter("txtNombre");
                    String apellido = request.getParameter("txtApellido");
                    String email = request.getParameter("txtEmail");
                    String IDRol = request.getParameter("rl");
                    String IDExcusa = request.getParameter("txtExcusa");

                    nPersona.setcedula(cedula);
                    nPersona.setNombre(nombre);
                    nPersona.setapellido(apellido);
                    nPersona.setemail(email);
                    nPersona.setIdrol(email);

                    nPersona.setIdrol(IDRol);
                    if (IDExcusa.length() > 0 && IDExcusa != null) {
                        pm.setIdexcusa(IDExcusa);
                    }

                    String regex = "^[0-9]+$";

                    // Creamos un objeto Pattern
                    Pattern pattern = Pattern.compile(regex);

                    // Creamos un objeto Matcher
                    Matcher matcher = pattern.matcher(cedula);

                    // Validamos si la cadena de texto contiene solo números
                    pdao.agregar(nPersona);

                    response.setContentType("text/html");
                    response.setStatus(HttpServletResponse.SC_OK);
                    if (!matcher.matches()) {
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

                    }
                    PrintWriter out = response.getWriter();

                    //request.getRequestDispatcher("controlador?menu=Personas&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ida = Integer.parseInt(request.getParameter("id"));
                    Personas e = pdao.listarId(ida);
                    request.setAttribute("Personas", e);
                    request.getRequestDispatcher("controlador?menu=Personas&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String Cedula1 = request.getParameter("txtCedula");
                    String Nombre1 = request.getParameter("txtNombre");
                    String Apellido1 = request.getParameter("txtApellido");
                    String Email1 = request.getParameter("txtEmail");
                    String id = request.getParameter("idPersona");
                    String IDRol1 = request.getParameter("rl");
                    System.out.println("idpersona" + id);
                    pm.setcedula(Cedula1);
                    pm.setNombre(Nombre1);
                    pm.setapellido(Apellido1);
                    pm.setemail(Email1);

                    pm.setIdrol(IDRol1);

                    pm.setId(Integer.parseInt(id));
                    pdao.Actualizar(pm);
                    //request.getRequestDispatcher("controlador?menu=Aprendiz&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    //System.out.println("eliminar");
                    ida = Integer.parseInt(request.getParameter("id"));//captura el id de la fila para todo
                    System.out.println("este es el id a eliminar:" + ida);
                    try {
                        pdao.eliminar(ida);
                        request.getRequestDispatcher("controlador?menu=Aprendiz&accion=Listar").forward(request, response);
                    } catch (Exception e1) {
                        request.setAttribute("msje", "No se pudo acceder a la base de datos" + e1.getMessage());
                    }
                    /*if (request.getParameter("cod")!=null) {
                            System.out.println("si trae");
                             pm.setId(Integer.parseInt(request.getParameter("cod")));
                         //    try {
                                pdao.eliminar(ida);
                         //   }catch(Exception e){}
                        }else{
                            request.setAttribute("msje", "No se puto borrar el usuario");
                            System.out.println("no se pudo");
                        }*/

                    // pdao.eliminar(ida);//ejecutamos el metodo eliminar dentro de la clase personasdao
                    //listar datos actualizados
                    break;
                /* case "BuscarPersona":
                        int id=Integer.parseInt(request.getParameter("BuscarPersona"));
                        pm=pdao.listarId(id);
                        request.setAttribute(nombre, e);
                        break;*/
                case "importar":
                    request.getRequestDispatcher("importar.jsp").forward(request, response);

                    break;
                    
                case "Cargar":

                    String excelName = request.getParameter("archivo");
                    
                    String route = System.getProperty("user.home")+"\\Downloads\\"+excelName;
                    
                    CargarDatosXlsxAMySQL cargar = new CargarDatosXlsxAMySQL(route);
                    
                    cargar.cargar();
                    
                    request.getRequestDispatcher("importar.jsp").forward(request, response);

                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Personas.jsp").forward(request, response);
        }
        if (menu.equals("Instructor")) {
            request.getRequestDispatcher("Instructor.jsp").forward(request, response);
        }
        if (menu.equals("R_Asistencia")) {
            switch (accion) {
                case "Asistencia":
                    asistencia = Adao.llenar(fichaActual);
                    //registrados = Adao.registradosHoy();

                    request.setAttribute("asistencia", asistencia);

                    request.setAttribute("registrados", registrados);

                    //request.setAttribute("RolPersona", fichas);

                    break;
                case "Enviar Asistencia":

                    String[] data = request.getParameter("data").split(";");
                    String date = request.getParameter("date");

                    if(date.length() > 0){
                    for (String user : data) {
                        String id = user.split("-")[0];
                        String asistencia = user.split("-")[1];
                        Adao.registrarAsistencia(id, asistencia, date);
                    }
                    
                    response.setContentType("text/html");
                    response.setStatus(HttpServletResponse.SC_OK);
                    }else{
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);                
                    }
                    //request.getRequestDispatcher("controlador?menu=R_asistencia&accion=Asistencia").forward(request, response);
                    //List asistencia2 = Adao.llenar();
                    //registrados = Adao.registradosHoy();
                    ///request.setAttribute("asistencia", asistencia);
                    //request.setAttribute("registrados", registrados);

                    //request.getRequestDispatcher("R_Asistencia.jsp").forward(request, response);
                    break;
                    case "Reporte":
                        Adao.generarReporte();
                    break;
            }
            request.getRequestDispatcher("R_Asistencia.jsp").forward(request, response);
        }
        if (menu.equals("Home")) {
            switch (accion) {
                case "card":
                    List lista1 = fdao.listar();
                    List pmList = fdao.programas();

                    request.setAttribute("fichas", lista1);
                    request.setAttribute("programas", pmList);
                    break;
                case "selectFicha":
                    fichaActual = request.getParameter("id");
                    request.getRequestDispatcher("controlador?menu=R_Asistencia&accion=Asistencia").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        }
        if (menu.equals("AsignarAprendiz")) {
            switch (accion) {
                case "AsignarAprendiz":
                    List AsignarAprendiz = AsApdao.ListarApendiz1(fichaActual);
                    List fichas = AsApdao.ficha();
                    Ficha fichaAct = fdao.listar(fichaActual);

                    //System.out.println(fichaAct.getNombre());
                    request.setAttribute("AsignarAprendiz3", AsignarAprendiz);
                    request.setAttribute("Fichas", fichas);
                    request.setAttribute("fichaAct", fichaAct);
                    System.out.println("controlador.controlador.processRequest()");

                    break;
                case "Asignar":
                    String idFicha = request.getParameter("fcha");
                    String idPersona = request.getParameter("idPersona");

                    System.out.println(idFicha + "---" + idPersona);

                    AsApdao.asignar(idFicha, idPersona);

                    request.getRequestDispatcher("controlador?menu=AsignarAprendiz&accion=AsignarAprendiz").forward(request, response);

                    break;
                case "GenerarAsistencia":

                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("AsignarAprendiz.jsp").forward(request, response);
        }
        if (menu.equals("ProgramaFormacion")) {
            switch (accion) {
                case "ListarPrograma":
                    List pfList = Pfdao.programas();
                    request.setAttribute("programasx", pfList);
                    break;
                case "AgregarPrograma":
                    Programa nPrograma = new Programa();

                    String nombreprog = request.getParameter("txtNombrePrograma");
                    String vigencia = request.getParameter("txtVigencia");
                    String version = request.getParameter("txtVersion");

                    nPrograma.setNombre(nombreprog);
                    nPrograma.setVigencia(vigencia);
                    nPrograma.setVersion(version);

                    Pfdao.agregar(nPrograma);
                    //  System.out.println("controlador");
                    response.setContentType("text/html");
                    response.setStatus(HttpServletResponse.SC_OK);
                    PrintWriter out = response.getWriter();

                    break;
                case "Editar":
                    ids = Integer.parseInt(request.getParameter("id"));
                    Programa j = Pfdao.listarId(ids);
                    request.setAttribute("progrm", j);
                    //request.getRequestDispatcher("controlador?menu=ProgramaFormacion&accion=ListarPrograma").forward(request, response);
                    break;
                case "Eliminar":
                    /*ids = Integer.parseInt(request.getParameter("id"));//captura el id de la fila para todo
                    try {
                        Pfdao.eliminar(ids);//ejecutamos el metodo eliminar dentro de la clase personasdao
                        //listar datos actualizados
                        request.getRequestDispatcher("controlador?menu=Ficha&accion=listarFicha").forward(request, response);
                        // System.out.println("eli11");
                    } catch (Exception e) {
                        request.setAttribute("msje", "No se pudo acceder a la base de datos" + e.getMessage());
                        System.out.println("no se pudo ctr ficha"+e);
                    }*/

                    ids = Integer.parseInt(request.getParameter("id"));
                    System.out.println("este es el id f a dele" + ids);
                    try {
                        Pfdao.eliminar(ids);//ejecutamos el metodo eliminar dentro de la clase personasdao
                        // request.getRequestDispatcher("controlador?menu=Ficha&accion=listarFicha").forward(request, response);  

                    } catch (Exception ef) {
                        request.setAttribute("msje", "No se pudo acceder a la base de datos" + ef.getMessage());
                        System.out.println("no se pudo ctr ficha" + ef);
                    }
                    break;
                case "Actualizar":
                    String nombre = request.getParameter("txtNombre");
                    String vigencia0 = request.getParameter("txtVigencia");
                    String version0 = request.getParameter("txtVersion");

                    String idP = request.getParameter("idProgram");

                    Pf.setNombre(nombre);
                    Pf.setVigencia(vigencia0);
                    Pf.setVersion(version0);
                    Pf.setId(idP);
                    Pfdao.Actualizar(Pf);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Programa.jsp").forward(request, response);
        }
        if (menu.equals("AsignarInstructor")) {
            switch (accion) {
                case "AsignarInstructor":
                    List AsignarInstructor = AsInsDao.ListInstruc(fichaActual);
                    List fichas = AsApdao.ficha();
                    Ficha fichaAct = fdao.listar(fichaActual);

                    //System.out.println(fichaAct.getNombre());
                    request.setAttribute("AsignarInstruct2", AsignarInstructor);
                    request.setAttribute("Fichas", fichas);
                    request.setAttribute("fichaAct", fichaAct);
                    System.out.println("controlador.controlador.processRequest()");

                    break;
                case "Asignar":
                    String idFicha = request.getParameter("fcha");
                    String idPersona = request.getParameter("idPersona");

                    AsApdao.asignar(idFicha, idPersona);

                    request.getRequestDispatcher("controlador?menu=AsignarInstructor&accion=AsignarInstructor").forward(request, response);

                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("AsignarInstructor.jsp").forward(request, response);
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
        processRequest(request, response);
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
