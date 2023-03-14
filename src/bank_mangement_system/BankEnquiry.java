
package bank_mangement_system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.ResultSet;


public class BankEnquiry extends JFrame implements ActionListener
       
{
    String pinnumber;
    JButton back;
    
    
    
    
    
    BankEnquiry(String pinnumber)
    {
    
            this.pinnumber=pinnumber;
       setLayout(null);
     
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT );
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);
    
       back = new JButton("back");
       back.setBounds(355,520,150,30);
       back.addActionListener(this);
       image.add(back);
       
       con c = new con();
       
        int balance =0;
       try
       {
       ResultSet rs = c.st.executeQuery("select * from bank where pin = '"+pinnumber+"'");
       
      
       while(rs.next())
       {
       if( !rs.getString("type").equals("+Deposit+"))
       {
           balance +=  Integer.parseInt(rs.getString("amount"));
       }else {
           balance -=  Integer.parseInt(rs.getString("amount"));
       }
     
       }
    
       }catch(SQLException j)
      {
        System.out.println(j);
      }
       
       JLabel text = new JLabel("Your Current Account balance is Rs " + balance);
       text.setForeground(Color.white);
       text.setBounds(170,300,400,30);
       image.add(text);
       
       
       
       
       
       
       
       
        setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    public static void main(String[] args) {
        new BankEnquiry("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
     setVisible(false);
     new Transactions(pinnumber).setVisible(true);
        
        
        
        
        
        
        
    }
}
