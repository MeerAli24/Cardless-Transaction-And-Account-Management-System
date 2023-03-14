
package bank_mangement_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener
{
      JPasswordField pin , repin;
        JButton change,back;
    
    String pinnumber;

    public PinChange(String pinnumber) 
    {
      
        this.pinnumber=pinnumber;
        
        
        setLayout(null);
        
 
           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT );
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);
       
        setSize(900,900);
        setLocation(300,0);
        
         JLabel text = new JLabel("Change your pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,   16));
        text.setBounds(250,280,500,35);
        image.add(text);
    
    
            JLabel pintext = new JLabel("NEW PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD,   16));
        pintext.setBounds(165,320,100,25);
        image.add(pintext);
        
         pin = new   JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD , 25));
        pin.setBounds(330,320,180,25);
        image.add(pin);
        
        
                JLabel repintext = new JLabel("Re-Enter NEW PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD,   16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);
        
          repin = new   JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD , 25));
        repin.setBounds(330,360,180,25);
        image.add(repin);
        
        
         change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        image.add(change);
        change.addActionListener(this);
        
      
         back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        image.add(back);
        back.addActionListener(this);
        
        
        
    }
    
    
    
    
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   if(e.getSource()==change)
   {
        try{
        String npin = pin.getText();
        String renpin = repin.getText();
        
        if(!npin.equals(renpin))
        {
        JOptionPane.showMessageDialog(null, "entered message doesn't match");
        return;
        }
        if(npin.equals(""))
            {
        JOptionPane.showMessageDialog(null, "please enter new pin");
        return;
        }  
               if(renpin.equals(""))
            {
        JOptionPane.showMessageDialog(null, "please re-enter new pin");
        return;
        }  
        
               con con = new con();
               String query1 = "update bank set pin = '"+renpin+"' where pin = '"+pinnumber+"'";
          String query2 = "update login set pin = '"+renpin+"' where pin = '"+pinnumber+"'";
           String query3 = "update signupthree set pin = '"+renpin+"' where pin = '"+pinnumber+"'";
           
           con.st.executeUpdate(query1);
              con.st.executeUpdate(query2);
                 con.st.executeUpdate(query3);
            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
           
           
           
        } catch (Exception l)
        {
        System.out.println(l);
        }     
        }else
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
             
                }
        
      
        
        
        
        
        
        
        
        
        
        
    }
    
}
