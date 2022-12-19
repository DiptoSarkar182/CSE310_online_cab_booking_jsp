<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Passenger select destination page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <center>Provide destination, pickup location and pickup time here</center>
        
        <center ><form action="Passenger_destination_serv" method="post">
                <table>
                    <tr>
                        <th>Destination:</th><th><input type="text" name="destination"/></th>
                    </tr>
                    <tr>
                        <th>Pickup Location:</th><th><input type="text" name="pickup"/></th>
                    </tr>
                    <tr>
                        <th>Pickup time:</th><th><input type="text" name="time"/></th>
                    </tr>
                    
                    <tr>
                        <th>Date:</th><th><input type="date" name="date" /></th>
                    </tr>
                    
                    <tr>
                        <th></th>
                        <th><input type="submit" value="Confirm"/></th>
                       
                      </tr>
                      
                      </table>
                
                
                </form>
            
        </center> 
    
    </body>
</html>
