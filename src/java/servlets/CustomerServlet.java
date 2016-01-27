/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.CustomerUtilities;

/**
 *
 * @author beer9_000
 */
@WebServlet(name = "CustomerServlet", urlPatterns = {"/CustomerServlet"})
public class CustomerServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Customer Infomation </title>");            
            out.println("</head>");
            
            out.println("<body>");
            request.setCharacterEncoding("UTF-8");
            String FirstName = request.getParameter("firstName");
            String LastName = request.getParameter("lastName");
            String Company = request.getParameter("company");
            String Mobile = request.getParameter("mobile");
            String Email = request.getParameter("email");
            String Address = request.getParameter("addr");
            
            Customer newCus = new Customer();
            
            newCus.getFname();
            newCus.getLname();
            newCus.getCompany();
            newCus.getEmail();
            newCus.getMobile();
            newCus.getAddr();
            
            CustomerUtilities Customer = new CustomerUtilities();
            Customer.init();
            
            int numOfRowEffected = Customer.insertCus(FirstName, LastName,Company,Mobile,Email,Address);
        
            if (numOfRowEffected == 1){
                System.out.println("Insert Successfully!!!");
            }
            
            
            
            out.println("<h1>Customer Information</h1>" +"<br>");
            out.println("<b>First Name: </b>" + FirstName + "<br>");
            out.println("<b>Last Name: </b>" + LastName + "<br>");
            out.println("<b>Company: </b>" + Company + "<br>");
            out.println("<b>Mobile: </b>" + Mobile + "<br>");
            out.println("<b>E-mail: </b>" + Email + "<br>");
            out.println("<b>Address: </b>" + Address + "<br>");
            
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
