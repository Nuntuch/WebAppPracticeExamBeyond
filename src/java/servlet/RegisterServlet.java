/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import jpa.controller.RegisterJpaController;
import jpa.controller.exceptions.RollbackFailureException;
import jpa.model.Register;

/**
 *
 * @author Nuntuch Thongyoo
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Resource
    UserTransaction utx;
    @PersistenceUnit(unitName = "WebAppPracticeExamBeyondPU")
    EntityManagerFactory emf;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, RollbackFailureException, Exception {
        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet RegisterServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }

        String key = request.getParameter("key");
        String email = request.getParameter("email");
        if (key != null && key.trim().length() > 0) {
            Register registerObj = new Register();
            registerObj.setEmail(email);
            registerObj.setEmail(key);

            RegisterJpaController registerJpaCtrl = new RegisterJpaController(utx, emf);

            List<Register> registerJpaCtrlList = registerJpaCtrl.findRegisterEntities();
            for (Register register : registerJpaCtrlList) {
                if (register.getEmail().equals(registerObj.getEmail())) {

                    if (register.getActivatekey().equals(registerObj.getActivatekey())) {
                        Date d = new Date();
                        register.setActivatedate(d);
                        registerJpaCtrl.edit(register);
                        getServletContext().getRequestDispatcher("/index.html").forward(request, response);
                        return;
                    }

                    request.setAttribute("Error", "You Key is Worng แนะนำให้copyมาแล้ววางใหม่ อิๆ");
                    getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);

                    return;
                }
            }
            request.setAttribute("Error", "You Key is Worng แนะนำให้copyมาแล้ววางใหม่ อิๆ");
            getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
        }
            getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);

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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
