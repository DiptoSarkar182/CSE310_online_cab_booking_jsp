/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import static java.lang.System.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
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
@WebServlet(urlPatterns = {"/Driver_joblist"})
public class Driver_joblist extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse_310_lab", "root", "root");
            Statement stm = con.createStatement();
            
            
           
                ResultSet resultSet = stm.executeQuery("select * from p_dest_test");
                out.println("<html>");
                out.println("<body style=\"background-color:D7B9B2\">");
                 out.println("<table style=\"border:1px solid black;width:50%;margin:0 auto\">");
                 out.println("<tr>");
                out.print("<th style=\"border:1px solid black\">Serial</th>"+"<th style=\"border:1px solid black\">Destination</th>"+"<th style=\"border:1px solid black\">Pickup Location</th>"+"<th style=\"border:1px solid black\">Pickup Time</th>"+"<th style=\"border:1px solid black\">Passenger Name</th>"+"<th style=\"border:1px solid black\">Passenger Contact</th>"+"<th style=\"border:1px solid black\">Date</th>");
                out.println("</tr>");            
                while(resultSet.next()) {
                                out.println("<tr>");
                               
                                out.print("<td style=\"border:1px solid black\">"+resultSet.getInt("Serial")+"</td>");
                                out.print("<td style=\"border:1px solid black\">"+resultSet.getString("destination")+"</td>");
                                out.print("<td style=\"border:1px solid black\">"+resultSet.getString("pickupLocation")+"</td>");
                                out.print("<td style=\"border:1px solid black\">"+resultSet.getString("PickupTime")+"</td>");
                                out.print("<td style=\"border:1px solid black\">"+resultSet.getString("PassengerName")+"</td>");
                                out.print("<td style=\"border:1px solid black\">"+resultSet.getString("PassengerContact")+"</td>");
                                out.print("<td style=\"border:1px solid black\">"+resultSet.getString("Date")+"</td>");
                                
                                out.println("</tr>");
                            }
                
                    
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            
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
