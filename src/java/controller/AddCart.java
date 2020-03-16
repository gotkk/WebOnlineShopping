/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.scene.web.WebEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Products;
import model.ProductsTable;
import model.Shoppingcart;
import model.ShoppingcartTable;

/**
 *
 * @author KRuser
 */
public class AddCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    List<Shoppingcart> cartLists = new ArrayList<Shoppingcart>();
    int cartID;
    int ID;
    boolean AddCarted = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        List<Products> cartList = new ArrayList<Products>();
        cartID = Integer.parseInt(session.getAttribute("cartID").toString());
        
        if (!AddCarted) {
            ID = Integer.parseInt(session.getAttribute("ID").toString());
            AddCarted = true;
        } else {
            cartLists = (List<Shoppingcart>) session.getAttribute("cartLists");
        }
        
        if (request.getParameter("addCart1") != null) {
            cartList = (List<Products>) ProductsTable.findProductsByName("Harry Potter");
        }
        if (request.getParameter("addCart2") != null) {
            cartList = (List<Products>) ProductsTable.findProductsByName("Seven");
        }
        if (request.getParameter("addCart3") != null) {
            cartList = (List<Products>) ProductsTable.findProductsByName("Shrek 2");
        }
        
        Shoppingcart spc = new Shoppingcart();
        Products pro = null;
        Iterator<Products> itr = cartList.iterator();
        while (itr.hasNext()) {
            pro = itr.next();
            spc.setId(ID);
            spc.setCartid(cartID);
            spc.setMovie(pro.getMovie());
            spc.setPrice(pro.getPrice());
            spc.setRating(pro.getRating());
            spc.setYearcreate(pro.getYearcreate());
            spc.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            cartLists.add(spc);
            ID++;
            session.setAttribute("ID", ID);
        }
        
        session.setAttribute("cartLists", cartLists);
        
        request.getRequestDispatcher("showshoppingcart.jsp").include(request, response);
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
