
package bank_mangement_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener
{
    
    JButton deposit, withdrawal, ministatement, exit, balanceequiry,fastcash,pinchange;
    String pinnumber;
    
    Transactions(String pinnumber)
   {
       
       this.pinnumber=pinnumber;
       setLayout(null);
       
       
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT );
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,900,900);
       add(image);
       
       JLabel text = new JLabel("please select your Transaction");
       text.setBounds(210,300,700,35);
       text.setForeground(Color.white);
       text.setFont(new Font("System" , Font.BOLD,16));
       // we much add with the help of image if not then the image will be above the text so text is not visible
       image.add(text);
       
       
        deposit = new JButton("Deposit");
       deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
       image.add(deposit);
       
        withdrawal = new JButton("Cash Withdrawal");
       withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
       image.add(withdrawal);
       
        fastcash = new JButton("Fast Cash");
       fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
       image.add(fastcash);
       
        ministatement = new JButton("Mini Statement");
       ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
       image.add(ministatement);
       
       pinchange = new JButton("Pin Change");
       pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
       image.add(pinchange);
       
        balanceequiry = new JButton("Balance Enquiry");
       balanceequiry.setBounds(355,485,150,30);
        balanceequiry.addActionListener(this);
       image.add(balanceequiry);
       
        exit = new JButton("Exit");
       exit.setBounds(355,520,150,30);
       exit.addActionListener(this);
       image.add(exit);
       
       
       
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
    
    
    
    
    
    }
    
    
    
    
    
    
    
    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
    if(e.getSource()==exit)
    {
        System.exit(0);
    }else if(e.getSource()==deposit)
    {
        setVisible(false);
        new Deposit(pinnumber).setVisible(true);
    
    }else if(e.getSource()==withdrawal)
    {
        setVisible(false);
        new Withdrawal(pinnumber).setVisible(true);
    }else if(e.getSource()==fastcash)
    {
        setVisible(false);
        new FastCash(pinnumber).setVisible(true);
    
    
    }else if(e.getSource()==pinchange)
    {
        setVisible(false);
    new PinChange(pinnumber).setVisible(true);
    
    }else if(e.getSource()== balanceequiry)
    {
        setVisible(false);
    new BankEnquiry(pinnumber).setVisible(true);
        
    }
    }
}
