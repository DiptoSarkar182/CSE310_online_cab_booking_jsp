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
@WebServlet(urlPatterns = {"/Driver_rating_serv"})
public class Driver_rating_serv extends HttpServlet {

    

    
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String rate = request.getParameter("rate");
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse_310_lab", "root", "root");
            Statement stm = con.createStatement();
            
            String x = null,y=null,a = null,b=null;
            String sql2  = "select * from name_cont ";
            ResultSet rs2 = stm.executeQuery(sql2);
            
            if(rs2.next()){
                x=rs2.getString("name");
                y=rs2.getString("contact");
            }
            
            
            String sql = "select * from p_notf where passengerName='"+x+"' and passengerContact='"+y+"'";
                    ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                a=rs.getString("driverName");
                b=rs.getString("driverContact");
            }
            
                String query = "insert into p_dest_test (destination, pickupLocation, PickupTime, PassengerName, PassengerContact, Date) values(?,?,?,?,?,?)";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                   
//                    preparedStatement.setString(1, Destination);
//                    preparedStatement.setString(2, Pickup);
//                    preparedStatement.setString(3, Time);
//                    preparedStatement.setString(4, x);
//                    preparedStatement.setString(5, y);
//                    preparedStatement.setString(6, Date);
//                    preparedStatement.executeUpdate();
                    

            
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
