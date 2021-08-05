/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleado;
import modelo.EmpleadoModelo;

/**
 *
 * @author josema
 */
@WebServlet(name = "LogInControlador", urlPatterns = {"/login"})
public class LogInControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String email_empleado = request.getParameter("email");
            String clave_usuario = request.getParameter("clave");
            
            if(!email_empleado.equals(null) && !clave_usuario.equals(null)){
                EmpleadoModelo empleadomodelo = new EmpleadoModelo();
                try {
                    Empleado empleado = empleadomodelo.empleadoExiste(email_empleado, clave_usuario);
                    if(empleado != null){
                        request.getSession().setAttribute("email_empleado", empleado.getEmail_empleado());
                        request.getSession().setAttribute("nombre", empleado.getNombre());
                        response.sendRedirect("control-panel");
                    }else{
                        request.getSession().setAttribute("mensaje", "<div class='error'>Credenciales inválidos.</div>");
                        response.sendRedirect(request.getContextPath());
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LogInControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                response.sendRedirect(request.getContextPath()); 
            }
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
//        processRequest(request, response);
        //solo permitimos post
        request.getRequestDispatcher("mainpage.jsp").include(request, response);
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
