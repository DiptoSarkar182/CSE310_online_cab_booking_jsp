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
@WebServlet(urlPatterns = {"/Take_D_Serial_serv"})
public class Take_D_Serial_serv extends HttpServlet {

    

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
            
            String x = null,y=null,z=null;
            String sql = "select * from name_cont_driver";
                    ResultSet rs1 = stm.executeQuery(sql);
            if(rs1.next()){
                x=rs1.getString("name");
                y=rs1.getString("contact");
                z=rs1.getString("CarPlateNumber");
            }
  
                ResultSet rs = stm.executeQuery("select * from p_dest_test where Serial='"+Serial+"'");
            if(rs.next()){
                String namea = rs.getString("PassengerName");
                String nameb = rs.getString("PassengerContact");
                String query = "insert into p_notf (passengerName,passengerContact,driverName,  driverContact, driverPlateNumber) values(?,?, ?, ?,?)";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    preparedStatement.setString(1,namea);
                    preparedStatement.setString(2, nameb);
                    preparedStatement.setString(3, x);
                    preparedStatement.setString(4, y);
                    preparedStatement.setString(5, z);
                    preparedStatement.executeUpdate();
                
            }
            
            String query6 = "delete from p_dest_test where Serial='"+Serial+"'";
                PreparedStatement preparedStatement1 = con.prepareStatement(query6);
                preparedStatement1.executeUpdate();
            
            response.sendRedirect("AfterDriverTakeJob.jsp");
            
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
