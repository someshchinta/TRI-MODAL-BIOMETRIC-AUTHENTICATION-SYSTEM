import  java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.*;
 
import java.lang.String;
import java.sql.*;




import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.event.*;
import java.io.FileReader;
import java.awt.geom.*;
import javax.imageio.*;
import java.awt.image.*;





//========
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//========


public class BIOMETRIC_AUTHENTICATION_INTERFACE extends JFrame implements ActionListener
{

   
//================



FileDialog fd=null;


 

Connection con2;
int check_val=0;
String id,name,address;

//===============
  
       int i,xcoord,ycoord,v=0,fiw,fih,len;
char c;


JScrollPane jScrollPane1 = new JScrollPane();
JScrollPane jScrollPane2 = new JScrollPane();
JScrollPane jScrollPane3 = new JScrollPane();
JScrollPane jScrollPane4 = new JScrollPane();
JScrollPane jScrollPane5 = new JScrollPane();
JScrollPane jScrollPane6 = new JScrollPane();


JTextArea jTextArea1 = new JTextArea();
JTextArea jTextArea2 = new JTextArea();
public static JTextArea jTextArea3 = new JTextArea();
JTextArea jTextArea4 = new JTextArea();
JTextArea jTextArea5 = new JTextArea();
JTextArea jTextArea6 = new JTextArea();




       JMenuBar menuBar;
       JMenu file,edit,Watermarking,help;
       JMenuItem open,save,saveas,close,openwm,insrting1,insrting2,extracting,copyrighting,Authentic,organisation,university,wm,ewm;

       JPanel tools,panel1,panel2,panel3,panel4,panel5,position,select,slider,Bpanel1,Bpanel2,Rpanel,text,Rpanel2;
       JTabbedPane jtabbedpane1,jtabbedpane2;
       
       
       JTextField x,y,twm;
       JCheckBox LT,RT,C,LB,RB,copyr,auth;
       JRadioButton Selectpos, Fixed, textwm,imgwm;
       ButtonGroup radio,radio2;

       JLabel l1,l2,l7;
       BufferedImage bimg;

       File file1;
       String s="",str="";
      
       JButton insert1,insert2,insert3,insert4,insert5,insert6,insert7,insert8,insert9,insert10,insert11,insert12,extract;
       
       

       Help hdesk;

       Container con;
	

       public BIOMETRIC_AUTHENTICATION_INTERFACE()
       {
		
               setTitle("BIOMETRIC AUTHENTICATION INTERFACE");

               con=getContentPane();

               con.setLayout(null);
                              
               

               hdesk = new Help();

               hdesk.Display(2);

              
		
               tools=new JPanel();
               tools.setBorder(BorderFactory.createRaisedBevelBorder());
               tools.setLayout(new BorderLayout());
               con.add(tools);
               
tools.setBounds(0,10,990,420);

               select=new JPanel();
               select.setBorder(BorderFactory.createEtchedBorder());
               tools.add(select,BorderLayout.NORTH);

               panel1=new JPanel();
               panel2=new JPanel();

               panel1.setLayout(null);
               panel2.setLayout(null);

               panel1.setBorder(BorderFactory.createEtchedBorder());
               panel2.setBorder(BorderFactory.createEtchedBorder());

               



try{
              
               
               
 
               
                
          
               hdesk.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),"Help"));

               }
               catch(Exception e){}
               



               position=new JPanel();
               position.setLayout(null);



	insert1 = new JButton("Enrollment");
               	position.add( insert1 );
               	insert1.addActionListener(this);
              	insert1.setBounds(30,10,180,35);

insert2 = new JButton("Authentication");
               	position.add( insert2 );
               	insert2.addActionListener(this);
	        insert2.setBounds(30,60,180,35);
	//insert2.setEnabled(false);


		


insert7 = new JButton(" EXIT ");
               	position.add( insert7 );
               	insert7.addActionListener(this);
	        insert7.setBounds(30,310,180,35);

		






	
		

















               panel3=new JPanel();



                

              panel4=new JPanel();
                




               position.setBorder(BorderFactory.createEtchedBorder());

               text = new JPanel();
               text.setLayout(null);








 





               text.setBorder(BorderFactory.createEtchedBorder());

               jtabbedpane2=new JTabbedPane();
               jtabbedpane2.addTab("BIOMETRIC-AUTHENTICATION-SYSTEM",position);
               

               position.add(panel3);
              panel3.setBounds(20,35,150,100);
   
  
               position.add(panel4);
               panel4.setBounds(180,35,150,100);
  
 
               panel1.add(jtabbedpane2);
              











tools.add(jtabbedpane2,BorderLayout.CENTER);
               tools.add(jtabbedpane2);

jtabbedpane2.setBounds(15,70,990,180);
 




              



 







 

 


          
              
               

               con.add(hdesk);
               hdesk.setBounds(5,430,990,250);

               
              
               

              JLabel label = new JLabel("BIOMETRIC AUTHENTICATION SYSTEM",JLabel.CENTER);
              
              
              label.setFont(new Font("Arial", Font.BOLD, 17));
              
              label.setForeground(Color.blue);

              select.add(label);

 	
             







		
               

               
               jtabbedpane2.setVisible(true);
       }
 

       public void actionPerformed(ActionEvent ae)
       {
              
     //For Close

       
if( ae.getSource()==insert7)
{
System.exit(0);
}
else if(ae.getSource()==insert1)
{
   JOptionPane.showMessageDialog(null,"Please Give the Personal details for Enrollment"); 
Register r1=new Register();
}

 else if(ae.getSource()==insert2)
{
    String num = JOptionPane.showInputDialog(this, "Please Enter the Enrollment Number", "Enrollment Number", -1);
    if(num!=null)
    {
    System.out.println(num);
    check_enrollment_details(num);
    if(check_val==1)
    {
       Enrollment_Details_Display edd=new Enrollment_Details_Display(id,name,address);
    }
    else
      JOptionPane.showMessageDialog(null,"Your Entered Details Not matched");  
    }
    
    else
    {
        
      JOptionPane.showMessageDialog(null,"Please Enter the Enrollment Number");   
    }
}
 

}
      
void check_enrollment_details(String num)
{
    try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con2=DriverManager.getConnection("jdbc:odbc:biometric");
}
 catch(ClassNotFoundException | SQLException e1)
{
//e.printStackTrace();
System.err.println("Error: con2 " + e1.getMessage());
}

try{

Statement st2=con2.createStatement();
String sql2="select * from profiles where id='"+num+"'";
System.out.println(sql2);
ResultSet rs2=st2.executeQuery(sql2);
while(rs2.next())
{
id=rs2.getString(1);
name=rs2.getString(2);
address=rs2.getString(3);
check_val=1;
}
}
catch(Exception e2)
{
   System.err.println(e2); 
}

}
public static void main(String a[])
       {
	       BIOMETRIC_AUTHENTICATION_INTERFACE app = new BIOMETRIC_AUTHENTICATION_INTERFACE();
               app.setDefaultCloseOperation(EXIT_ON_CLOSE);
               app.setSize(1024,768);
               app.setVisible(true);  
               app.setResizable(false);
       }
     
}//main STEP_NC_Gui class





