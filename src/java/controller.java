/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 34646
 */
@WebServlet(urlPatterns = {"/controller"})
public class controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    private List <String> data = new ArrayList<String>();
    
    String calcul (int mult,int bon) {
        return Integer.toString(bon*mult);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String action = request.getParameter("action");
        //int num = Integer.parseInt(request.getParameter("inp"));
        
        
        Bonus bn = new Bonus();
        Map<String,String[]> map = request.getParameterMap();
        List<String> mes = new ArrayList<String>();
        String str[][] = new String[3][1];
        int tot;
        
        
        //OBTENTION DES DONNÉES DE LA BASE DE DONNÉES
        ///////////////////////////////////////////////////////////////
        if(action.equals("add")) {
            int sel = 0;
            for (Map.Entry<String,String[]> entry : map.entrySet()) {
                if (sel == 0){
                    str[0] = entry.getValue();
                    sel++;
                }
                else if (sel == 1){
                    str[1] = entry.getValue();
                    sel++;
                }
                else {
                    str[2] = entry.getValue();
                    mes.add(str[0][0]); 
                    mes.add(str[1][0]);
                    mes.add(str[2][0]);
                    sel = 0;     
                }
            }
            //DONNÉES FORMULAIRE > BASE DE DONNÉES
            bn.set(mes);

            request.getRequestDispatcher("/menu.jsp").forward(request,response);
        }
        /////////////////////////////////////////////////////////////////////////////////////////
        //RÉSULTATS
        //mes.add("dfhias");
        else if(action.equals("show")){
            data = bn.get();
            tot = data.size()/3-1;
            request.setAttribute("bonus",data);
            request.setAttribute("num",Integer.toString(tot));
            request.getRequestDispatcher("/bonus.jsp").forward(request,response);
        }
        else if(action.equals("search")) {
            data = bn.get();
            String obj = request.getParameter("search");
            List<String> res = new ArrayList<String>();
            for (int i = 0; i < data.size(); i=i+3) {
                if (data.get(i).equals(obj)){
                    res.add(data.get(i));
                    res.add(data.get(i+1));
                    res.add(data.get(i+2));
                    }
            }
                request.setAttribute("bonus",res);
                request.setAttribute("num","0");
                request.getRequestDispatcher("/bonus.jsp").forward(request,response);
            
        }
        
        //DÉSTRUCTION DES ÉLÉMENTS DE LA BASE DE DONNÉES
        else if (action.equals("destroy")) {
            bn.dest();
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
        else if (action.equals("menu")) {
            request.getRequestDispatcher("/menu.jsp").forward(request,response);
        }
        else if (action.equals("index")) {
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            
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
