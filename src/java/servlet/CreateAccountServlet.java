/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.Entity;
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
public class CreateAccountServlet extends HttpServlet {

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

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email != null && email.trim().length() > 0
                && password != null && password.trim().length() > 0) {
            Register register = new Register();
            register.setEmail(email);
            register.setPassword(password);
            double key = Math.random() * ((999999999 - 100000000) + 1);
            String keyS = key + "";

            register.setActivatekey(keyS);
            request.setAttribute("key", keyS);

            RegisterJpaController registerJpaCtrl = new RegisterJpaController(utx, emf);

            List<Register> registersList = registerJpaCtrl.findRegisterEntities();

            for (Register register1 : registersList) {
                if (register1.getEmail().equals(register.getEmail())) {
                    String msg = register.getEmail() + " is Dupicate";
                    request.setAttribute("msg", msg);
                    getServletContext().getRequestDispatcher("/CreateAccount.jsp").forward(request, response);
                    break;
                }
//                else {
//                    registerJpaCtrl.create(register);
//
//                    getServletContext().getRequestDispatcher("/CreateSuccessfully.jsp").forward(request, response);
//                    break;
//                }

            }

            //////////////////////////////
//             getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
/////////////////////////
            registerJpaCtrl.create(register);

            getServletContext().getRequestDispatcher("/CreateSuccessfully.jsp").forward(request, response);
         
        } else {
            response.sendRedirect(getServletContext().getContextPath() + "/CreateAccount.jsp");
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CreateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CreateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
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
