/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tcw
 */
public class UploadServlet extends HttpServlet {

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

        try {

            try (PrintWriter out = response.getWriter()) {
                
                File initialFile = new File("C:\\Users\\tcw\\Desktop\\inputExcel1.csv");
            InputStream targetStream = new FileInputStream(initialFile);

            CSVReader csvr = null;

            csvr = new CSVReader(new InputStreamReader(targetStream));//read each record in the file

            Iterator<String[]> recordsIterator = csvr.iterator();

            int lineNumber = 1;
            
            ArrayList<String> headers = new ArrayList<>();


            if (recordsIterator.hasNext()) {//skip header
                String row[] = recordsIterator.next();
                for (String col : row){
                    headers.add(col);
                    out.println(col);
                }
                lineNumber++;
            }
            
            HashMap<String,HashMap<String,Integer>> requestList = new HashMap<>();
                
                while (recordsIterator.hasNext()) {
                    String row[] = recordsIterator.next();
                    String beneficiaryName = row[0];
                    
                    for (int i=1; i<row.length; i++){
                        
                        HashMap<String, Integer> foodEntries = new HashMap<>();
                        try {
                            out.println(row[i]);
                            foodEntries.put(headers.get(i), Integer.parseInt(row[i]));
                        } catch (Exception e) {
                            
                        }
                        
                        requestList.put(beneficiaryName, foodEntries);
                    }
                    out.println("<br>");
                }
                return;
//                Gson gs = new Gson();
//                out.println(gs.toJson(requestList));
                
//                return;
            }
            
//            List<Beneficiary> ranking = ProcessController.provideRanking();
//            
//            HashMap<String,Integer> inventory = new HashMap<>();
//            inventory.put("Baking Needs (pc)", 100);
//            inventory.put("Canned Drinks (300ml,pc)", 300);
//            inventory.put("Bottled Drinks (1L,pc)", 150);
//            
//
//            HashMap<String, HashMap<String, Integer>> recommendedList = ProcessController.allocate(inventory, requestList, ranking);
//            
//            System.out.println("HERE" + recommendedList);
            

        } catch (IOException e) {
            e.printStackTrace();
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
