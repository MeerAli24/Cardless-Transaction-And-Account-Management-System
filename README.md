# Cardless-Transaction-And-Account-Management-System
• It is a desktop application which is developed using java.awt package and javax.swing package.
• The application interface is created using JFrame Swing top-level container) class.
• To maintain the transaction date and time, external libraries are added with the jar extension.
• ActionListener and ActionEvent are used to perform the Action as the user clicked on any of the 
  buttons (which is created using JButton).
• Created the connection class to connect with the database (JDBC). As soon as the user starts 
  the transaction the fetch query is executed and the amount present in the user account is 
  fetched, and casting is done and compared with the amount entered by the user and transaction 
  is done.
• After the transaction, the update query is executed automatically, and the amount is updated in 
  the account.
• Created multiple classes to handle each ActionEvent, as the Event is generated the object of the 
  respective class is generated and the class is executed by calling the constructor
  
