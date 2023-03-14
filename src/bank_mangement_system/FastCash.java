
package bank_mangement_system;
import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener
{
     JButton deposit, withdrawal, ministatement, exit, balanceequiry,fastcash,pinchange;
    String pinnumber;
    
    FastCash(String pinnumber)
   {
       
       this.pinnumber=pinnumber;
       setLayout(null);
       
       
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT );
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);
       
       JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
       text.setBounds(210,300,700,35);
       text.setForeground(Color.white);
       text.setFont(new Font("System" , Font.BOLD,16));
       // we much add with the help of image if not then the image will be above the text so text is not visible
       image.add(text);
       
       
        deposit = new JButton("RS 100");
       deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
       image.add(deposit);
       
        withdrawal = new JButton("RS 500");
       withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
       image.add(withdrawal);
       
        fastcash = new JButton("RS 1000");
       fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
       image.add(fastcash);
       
        ministatement = new JButton("RS 2000");
       ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
       image.add(ministatement);
       
       pinchange = new JButton("RS 5000");
       pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
       image.add(pinchange);
       
        balanceequiry = new JButton("RS 10000");
       balanceequiry.setBounds(355,485,150,30);
        balanceequiry.addActionListener(this);
       image.add(balanceequiry);
       
        exit = new JButton("BACK");
       exit.setBounds(355,520,150,30);
       exit.addActionListener(this);
       image.add(exit);
       
       
       
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
   }
    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
    if(e.getSource()==exit)
    {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
        
    }else
    {
     String amount =   ((JButton)e.getSource()).getText().substring(3);
     con cs= new con();
     try{
         
         //String query ="select * from bank where pin = '"+pinnumber+"'";
         ResultSet rs =  cs.st.executeQuery("select * from bank where pin = '"+pinnumber+"'");
        int balance =0;
        
        while(rs.next())
        {
        if(rs.getString("type").equals("Deposit"))
        {
            balance += Integer.parseInt((String) rs.getString("amount"));
        
        }else{
            balance -= Integer.parseInt((String) rs.getString("amount"));
        
        }
        }
        
        if(e.getSource() != exit && balance <Integer.parseInt(amount))
        {
            JOptionPane.showMessageDialog(null, "Insufficient Balance");
            return;
        }
        
        Date date = new  Date();
        String quert ="insert into bank values('"+pinnumber+"' , '"+date+"' , 'Withdrawal' , '"+amount+"'  )";
        
        cs.st.executeUpdate(quert);
        
        JOptionPane.showMessageDialog(null, "successfully");
        
        
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
        
        
        
        
        
     } catch(Exception z)
     {
         System.out.println(z);
     }
    
    }
    
    }
}
