/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import model.Fruit;
import service.DatabaseConnection;
import service.FruitsServices;

/**
 *
 * @author Naser
 */
@WebServlet(name = "Control", urlPatterns = {"/Control"}, loadOnStartup = 1)
public class Control extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ArrayList<Fruit> fruits = null;
    String cmd = null;
    public static String path = null;
    
    @Override
    public void init() throws ServletException {
        super.init();
       // path = this.getServletContext().getRealPath("");
        Connection conn = DatabaseConnection.getConnection();
        
        fruits =DatabaseConnection.getData();
 
    }
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        cmd = request.getParameter("cmd");
        HttpSession ses = request.getSession();
        if (ses.isNew()) {
            ArrayList<Fruit> flTotake = new ArrayList<>();
            ses.setAttribute("flTotake", flTotake);
        }

        if (cmd == null) {
            cmd = "Fruits";
        }
        if (cmd.equals("Fruits")) {
                
            request.setAttribute("fList", fruits);
            this.getServletContext().getRequestDispatcher("/Jsp/fruitList.jsp").forward(request, response);
            
        } else if (cmd.equals("OneFruit")) {
            
            String idstr = request.getParameter("id");
            int id = Integer.parseInt(idstr);
            
            Fruit fruit = DatabaseConnection.getData(id);
            
            request.setAttribute("fruit",fruit);
            this.getServletContext().getRequestDispatcher("/Jsp/FruitDetails.jsp").forward(request, response);
            
        } else if (cmd.equals("FruitAS")) {
            
            String idstr = request.getParameter("id");
            int id = Integer.parseInt(idstr);
            
            Fruit f = DatabaseConnection.getData(id);
          
            ArrayList<Fruit> frs = (ArrayList<Fruit>) ses.getAttribute("flTotake");
            frs.add(f);
            
            request.setAttribute("fList", fruits);
            this.getServletContext().getRequestDispatcher("/Jsp/fruitList.jsp").forward(request, response);
            
        } else if (cmd.equals("FruitDS")) {

            String index = request.getParameter("id");
            int ind = Integer.parseInt(index);

            ArrayList<Fruit> fl = (ArrayList<Fruit>) ses.getAttribute("flTotake");
            fl.remove(ind - 1);

            request.setAttribute("fList", fruits);
            this.getServletContext().getRequestDispatcher("/Jsp/fruitList.jsp").forward(request, response);
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
        DatabaseConnection.closeConnection();
    }
}
