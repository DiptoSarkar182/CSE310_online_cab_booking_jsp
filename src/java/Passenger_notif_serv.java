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
@WebServlet(urlPatterns = {"/Passenger_notif_serv"})
public class Passenger_notif_serv extends HttpServlet {

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String Serial = request.getParameter("serial");
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse_310_lab", "root", "root");
            Statement stm = con.createStatement();
            
            String x = null;
            String sql = "select * from name_cont";
                    ResultSet rs1 = stm.executeQuery(sql);
            if(rs1.next()){
                x=rs1.getString("contact");
                
            }
  
                //ResultSet resultSet = stm.executeQuery("select * from p_notf ");
                ResultSet resultSet = stm.executeQuery("select * from p_notf where passengerContact='"+x+"' ");
                out.println("<html>");
                out.println("<body style=\"background-color:D7B9B2\">");
                 out.println("<table style=\"border:1px solid black;width:50%;margin:0 auto\">");
                 out.println("<tr>");
                out.print("<th style=\"border:1px solid black\">Passenger Name</th>"+"<th style=\"border:1px solid black\">Driver Name</th>"+"<th style=\"border:1px solid black\">Driver Contact</th>"+"<th style=\"border:1px solid black\">Driver Plate Number</th>");
                out.println("</tr>");            
                if(resultSet.next()) {
                                out.println("<tr>");
                               
                                out.print("<td style=\"border:1px solid black\">"+resultSet.getString("passengerName")+"</td>");
                                //out.print("<td style=\"border:1px solid black\">"+resultSet.getInt("passengerContact")+"</td>");
                                out.print("<td style=\"border:1px solid black\">"+resultSet.getString("driverName")+"</td>");
                                out.print("<td style=\"border:1px solid black\">"+resultSet.getString("driverContact")+"</td>");
                                out.print("<td style=\"border:1px solid black\">"+resultSet.getString("driverPlateNumber")+"</td>");
                                
                                
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
