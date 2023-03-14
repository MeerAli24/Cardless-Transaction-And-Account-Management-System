
package bank_mangement_system;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener
{

	//  to  use globally 
	JButton login,signup,clear;
	JTextField cardTextField;
	JPasswordField pinTextField ;
	
	
	
	Login()
	{
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// title of frame
		setTitle("AUTOMATED TELLER MACHINE");
		
		// set layout null
		setLayout(null);
		
		// image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		// to size image
		Image i2 =i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		//Image cannot be added into the JLabel so we need to again convert the image into image icn
			ImageIcon i3 = new ImageIcon(i2);
		//  we can't add image directly on jFrame , so we need to  use JLabel
		JLabel label = new JLabel(i3);
		
		// change the location of  image  left , top, width ,height
		label.setBounds(70,10,100,100);
		add(label);
		
		// welcome to atm
		JLabel text = new JLabel("welcome to ATM");
		text.setFont(new Font("osward",Font.BOLD,38));
		text.setBounds(200,40,400,40);
		add(text);
		
		
		JLabel cardno = new JLabel("Card No : ");
		cardno.setFont(new Font("Raleway",Font.BOLD,28));
		cardno.setBounds(120,150,150,30);
		add(cardno);
		
		// text field of card
		cardTextField = new JTextField();
		cardTextField.setBounds(300,150,230,30);
		
		// change the font of data entered
		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(cardTextField);
		
		JLabel pin = new JLabel("PIN : ");
		pin.setFont(new Font("Raleway",Font.BOLD,28));
		pin.setBounds(120,220,150,30);
		add(pin);
		
		
		 pinTextField = new JPasswordField();
		pinTextField.setBounds(300,220,230,30);
		pinTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinTextField);
		
		// button
		
		login = new JButton("SIGN IN");
		login.setBounds(300,300,100,30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		//actionlistener
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("clear");
		clear.setBounds(430,300,100,30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		//actionlistener
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(300,350,230,30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		//actionlistener
		signup.addActionListener(this);
		add(signup);
		
		// background getContentpane() is used to  select the whole  fuction
		getContentPane().setBackground(Color.WHITE);
		
		//frame size length and height
		setSize(800,480);
		//set left and top
		setLocation(350,200);
		
	}
	
	
	
	public static void main(String[] args) 
	{
		new Login().setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()== clear)
		{
			cardTextField.setText("");
			pinTextField.setText("");
			
		}else if(e.getSource()== login)
		{
                    con c = new con();
                    String cardnumber = cardTextField.getText();
                    
                    //pin is a password so strick
                    String pinnumber = pinTextField.getText();
                    String query = " select * from login where cardnumber = '"+cardnumber+"' and pin ='"+pinnumber+"' " ;
                    
                            try{
                                ResultSet rs= c.st.executeQuery(query);
                                if(rs.next())
                                {
                                    setVisible(false);
                                    new Transactions(pinnumber).setVisible(true);
       
                                } else {
                                JOptionPane.showMessageDialog(null, "incorrect card number or pin");
                                }
                            } catch(Exception f){
                                System.out.println(f);
                            }
                            
                            
                            
                            
                            
		}else if(e.getSource()== signup)
		{
                    setVisible(false);
                   new signInOne().setVisible(true); 
		}
                
		
	}    
}
