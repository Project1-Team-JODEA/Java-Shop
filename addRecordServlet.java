/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.Patient;
import business.User;
import business.Vaccine;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexs
 */
public class addRecordServlet extends HttpServlet {

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
        String URL = "";
        String msg = "", sql = "";
        String dbURL = "jdbc:mysql://localhost:3306/movax";
        String dbUSER = "root";
        String dbPWD = "sesame";
        Boolean updatePatient = false;
        Boolean updateVaccine = false;
        Boolean updateUser = false;
        try{        
            Connection conn = DriverManager.getConnection(dbURL, dbUSER, dbPWD);
            if(updatePatient == true){
                // needs: get patient info from form
                Patient p = new Patient();
                // needs: validate p
                sql = "UPDATE patienttbl SET " +
                        "RecipientID = ?, " +
                        "SocSecNum = ?, " +
                        "FirstName = ?, " +
                        "MiddleName = ?, " +
                        "LastName = ?, " +
                        "DateOfBirth = ?, " +
                        "Vaccine1 = ?, " +
                        "Vaccine2 = ?, " +
                        "Vaccine3 = ?, " +
                        "Vaccine4 = ? ";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, p.getRid());
                ps.setString(2, p.getSsn());
                ps.setString(3, p.getFname());
                ps.setString(4, p.getMname());
                ps.setString(5, p.getLname());
                ps.setString(6, p.getDob());
                ps.setString(7, p.getVac1().getVid());
                ps.setString(8, p.getVac2().getVid());
                ps.setString(9, p.getVac3().getVid());
                ps.setString(10, p.getVac4().getVid());
                int rc = ps.executeUpdate();
                if (rc == 0){
                    msg += "Patient not updated. <br>";
                } else if (rc == 1){
                    msg += "Patient updated. <br>";
                } else {
                    msg += "Warning: multiple records updated. <br>";
                }
                updatePatient = false;
            }
            if (updateVaccine == true){
                // needs: get vaccine info from form
                Vaccine v = new Vaccine();
                // needs: validate v
                sql = "UPDATE vaccinetbl SET " +
                        "VaccineID = ?, " +
                        "Date = ?, " +
                        "Manufactuerer = ?, " +
                        "LotNumber = ?, " +
                        "Location = ?, " +
                        "LocationType = ?, " +
                        "Nurse = ?, ";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, v.getVid());
                ps.setString(2, v.getDate());
                ps.setString(3, v.getManufacturer());
                ps.setString(4, v.getLotnum());
                ps.setString(5, v.getLocation());
                ps.setString(6, v.getLocatype());
                ps.setString(7, v.getNurse());
                int rc = ps.executeUpdate();
                if (rc == 0){
                    msg += "Vaccine not updated. <br>";
                } else if (rc == 1){
                    msg += "Vaccine updated. <br>";
                } else {
                    msg += "Warning: multiple records updated. <br>";
                }
                updateVaccine = false;
            }
            if (updateUser == true){
                // needs: get user info from form
                User u = new User();
                // needs: validate u
                sql = "UPDATE usertbl SET " +
                        "Username = ?, " +
                        "Password = ?, " +
                        "FirstName = ?, " +
                        "MiddleName = ?, " +
                        "LastName = ?, " +
                        "Location = ?, " +
                        "Role = ?, ";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, u.getUsername());
                ps.setString(2, u.getPassword());
                ps.setString(3, u.getFname());
                ps.setString(4, u.getMname());
                ps.setString(5, u.getLname());
                ps.setString(6, u.getLocation());
                ps.setString(7, u.getRole());
                int rc = ps.executeUpdate();
                if (rc == 0){
                    msg += "Vaccine not updated. <br>";
                } else if (rc == 1){
                    msg += "Vaccine updated. <br>";
                } else {
                    msg += "Warning: multiple records updated. <br>";
                }
                updateUser = false;
            }
            conn.close();
        } catch (Exception e){
            msg += e.getMessage();
        }
        request.setAttribute("msg", msg);
        RequestDispatcher disp = getServletContext().getRequestDispatcher(URL);
        disp.forward(request, response);
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
