
package bank_mangement_system;
import java.sql.*;
public class con 
{
    Connection c;
    Statement st;
    
    public con()
    {
        try
        {
            c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root","Meer");
            st =c.createStatement();
        
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
