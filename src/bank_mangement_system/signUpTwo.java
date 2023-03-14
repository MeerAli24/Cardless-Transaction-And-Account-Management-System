
package bank_mangement_system;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class signUpTwo extends JFrame implements ActionListener
{
     
    JTextField adharTextField,panTextField  ;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion, valCat ,income,education,Occupation;
    String formno;
    
    signUpTwo(String formno)
	{
            this.formno=formno;
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
                setTitle("NEW ACCOUNT APPLICATION FORM - PART 2 ");
                
                
	
		
		JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
		additionalDetails.setBounds(290,80,400,30);
		add(additionalDetails);
		
		
		
		JLabel name = new JLabel("Religion");
		name.setFont(new Font("Raleway", Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		
                String valReligion[] = {"Hindu" ,"Muslim" , "Sikh", "Christian" , "other" };
		 religion = new JComboBox(valReligion);
                religion.setBounds(300,140,400,30);
                religion.setBackground(Color.white);
                add(religion);
		
		JLabel fname = new JLabel("Category");
		fname.setFont(new Font("Raleway", Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
                  String valCategory[] = {"General","OBC","SC","ST" , "other" };
		 valCat = new JComboBox(valCategory);
                valCat.setBounds(300,190,400,30);
                valCat.setBackground(Color.white);
                add(valCat);
		
		JLabel dob = new JLabel("Income");
		dob.setFont(new Font("Raleway", Font.BOLD,20));
		dob.setBounds(100,240,200,30);
		add(dob);
                
                     String incomeCategory[] = {"null" , "<50,000" , "<2,50,000" ,"<5,00,000","Upto 10,00,000" ,"> 10,00,000"};
		income = new JComboBox(incomeCategory);
                income.setBounds(300,240,400,30);
                income.setBackground(Color.white);
                add(income);
                
           
		
		JLabel gender = new JLabel("Educational");
		gender.setFont(new Font("Raleway", Font.BOLD,20));
		gender.setBounds(100,290,200,30);
		add(gender);
                
		JLabel email = new JLabel("Qualifications ");
		email.setFont(new Font("Raleway", Font.BOLD,20));
		email.setBounds(100,315,200,30);
		add(email);
		
                  String eduCategory[] = {"Non-Graduation" , "Graduate" , "Post-Graduation" ,"Doctrate" , "Other"};
              education = new JComboBox(eduCategory);
                education.setBounds(300,315,400,30);
                education.setBackground(Color.white);
                add(education);
             
		JLabel marital = new JLabel("Occupation");
		marital.setFont(new Font("Raleway", Font.BOLD,20));
		marital.setBounds(100,390,200,30);
		add(marital);
                
                
                 String occCategory[] = {"Salaried" , "Self-Employed" , "Bussiness" ,"Student" , "Retired ","Other"};
		 Occupation = new JComboBox(occCategory);
                Occupation.setBounds(300,390,400,30);
               Occupation.setBackground(Color.white);
                add(Occupation);

      
                
                
		JLabel address = new JLabel("Pan number");
		address.setFont(new Font("Raleway", Font.BOLD,20));
		address.setBounds(100,440,200,30);
		add(address);
		
		 panTextField = new JTextField();
		panTextField.setFont(new Font("Raleway", Font.BOLD,14));
		panTextField.setBounds(300,440,400,30);
		add(panTextField);
		
		JLabel city = new JLabel("Adhaar Number");
		city.setFont(new Font("Raleway", Font.BOLD,20));
		city.setBounds(100,490,200,30);
		add(city);
		
		 adharTextField = new JTextField();
		adharTextField.setFont(new Font("Raleway", Font.BOLD,14));
		adharTextField.setBounds(300,490,400,30);
		add(adharTextField);
		
		
		JLabel state = new JLabel("Senior Citizen");
		state.setFont(new Font("Raleway", Font.BOLD,20));
		state.setBounds(100,540,200,30);
		add(state);
		
                  syes = new JRadioButton("Yes");
                syes.setBounds(300,540,100,30);
                syes.setBackground(Color.white);
                add(syes);
                
                  sno = new JRadioButton("No");
                sno.setBounds(450,540,100,30);
                sno.setBackground(Color.white);
                add(sno);
                
                ButtonGroup seniorGroup = new ButtonGroup();
                seniorGroup.add(syes);
                seniorGroup.add(sno);
                
		
		
		JLabel pincode = new JLabel("Excisting Account");
		pincode.setFont(new Font("Raleway", Font.BOLD,20));
		pincode.setBounds(100,590,200,30);
		add(pincode);
		
                    eyes = new JRadioButton("Yes");
                eyes.setBounds(300,590,100,30);
                eyes.setBackground(Color.white);
                add(eyes);
                
                  eno = new JRadioButton("No");
                eno.setBounds(450,590,100,30);
                eno.setBackground(Color.white);
                add(eno);
                
                ButtonGroup excistGroup = new ButtonGroup();
                excistGroup.add(syes);
                excistGroup.add(sno);
                
		
                
                 next = new JButton("Next");
                        next.setBackground(Color.BLACK);
                        next.setForeground(Color.WHITE);
                        next.setFont(new Font("Raleway",Font.BOLD,14));
                        next.setBounds(620,660,80,30);
                        next.addActionListener(this);
                        add(next);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		setLocation(350,10);
		
	}
    
    
    
	public static void main(String[] args) 
	{
	new signUpTwo("").setVisible(true);
	}

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //lon value into string by cancating

        
        //down casting object  intio string
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)valCat.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String) Occupation.getSelectedItem();
        
     
        String seniorcitizen =null;
        if(syes.isSelected())
        {
        seniorcitizen ="Yes";
                }
        else if(sno.isSelected())
        {
            seniorcitizen ="no";
        }
        
        String excistingaccount =null;
        if(eyes.isSelected())
        {
        excistingaccount ="Yes";
                }
        else if(eno.isSelected())
        {
            excistingaccount ="no";
        }
        
        
        
        String pan = panTextField.getText();
        String aadhar =adharTextField.getText();
    
        
       
        //{
        //if(name.equals(""))
        //{
            //this is used to hop  up the message
          //  JOptionPane.showMessageDialog(null,"Name is required");
        //} else
        try{
            con c = new con();
            String query = "insert into signuptwo values('"+formno+"' , '"+sreligion+"' ,'"+scategory+"' ,'"+sincome+"' ,'"+seducation +"' ,'"+soccupation+"' ,'"+pan+"' ,'"+aadhar+"' ,'"+seniorcitizen+"' ,'"+excistingaccount+"' )" ;
            c.st.executeUpdate(query);
            
            setVisible(false);
            new signUpThree(formno).setVisible(true);
            //sign up 3
        } catch (Exception f){
            System.out.println(f);
        }
        
        
    }
}
