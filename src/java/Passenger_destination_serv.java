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
@WebServlet(urlPatterns = {"/Passenger_destination_serv"})
public class Passenger_destination_serv extends HttpServlet {

    

    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    String someName = (String)request.getAttribute("attributeName");
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String Destination = request.getParameter("destination");
        String Pickup = request.getParameter("pickup");
        String Time = request.getParameter("time");
        String Date = request.getParameter("date");
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse_310_lab", "root", "root");
            Statement stm = con.createStatement();
            
            String x = null,y=null;
            String sql = "select * from name_cont";
                    ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                x=rs.getString("name");
                y=rs.getString("contact");
            }
            
                String query = "insert into p_dest_test (destination, pickupLocation, PickupTime, PassengerName, PassengerContact, Date) values(?,?,?,?,?,?)";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                   
                    preparedStatement.setString(1, Destination);
                    preparedStatement.setString(2, Pickup);
                    preparedStatement.setString(3, Time);
                    preparedStatement.setString(4, x);
                    preparedStatement.setString(5, y);
                    preparedStatement.setString(6, Date);
                    preparedStatement.executeUpdate();
                    

            
            response.sendRedirect("Passenger_confirmation.jsp");
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
