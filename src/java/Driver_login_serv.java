/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
@WebServlet(urlPatterns = {"/Driver_login_serv"})
public class Driver_login_serv extends HttpServlet {

    
  

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String Email = request.getParameter("email");
        String Password = request.getParameter("password");
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse_310_lab", "root", "root");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from driver where email='"+Email+"' and password='"+Password+"'");
            
            if(rs.next()){
                
                String name5 = rs.getString("name");
                String contact5 = rs.getString("contact");
                String plate = rs.getString("CarPlateNumber");
                
                
                String query6 = "delete from name_cont_driver ";
                PreparedStatement preparedStatement1 = con.prepareStatement(query6);
                preparedStatement1.executeUpdate();
         
                String query5 = "insert into name_cont_driver (name,contact,CarPlateNumber) values(?, ?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(query5);
                preparedStatement.setString(1,name5);
                preparedStatement.setString(2, contact5);
                preparedStatement.setString(3, plate);
                preparedStatement.executeUpdate();
                response.sendRedirect("Driver_L1.jsp");               
                
   
            }
            
            else{
                out.println("wrong email and password");
            }

            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    

}
