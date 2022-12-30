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


public class Register extends JFrame implements ActionListener
{

   
//================



FileDialog fd=null;


 




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
       
       
       JTextField x,y,twm,t1,t2,t3,t4,t5,t6;
       JCheckBox LT,RT,C,LB,RB,copyr,auth;
       JRadioButton Selectpos, Fixed, textwm,imgwm;
       ButtonGroup radio,radio2;

       JLabel l1,l2,l3,l4,l5,l6,l7;
       BufferedImage bimg;

       File file1;
       String s="",str="";
      
       JButton insert1,insert2,insert3,insert4,insert5,insert6,insert7,insert8,insert9,insert10,insert11,insert12,extract;
       
       
	String t1_val="",t2_val="",t3_val="";
 
       Container con;
	
Connection con1=null;

       public Register()
       {
	super();
	
	this.setVisible(true);
	this.setSize(1024,500);


               setTitle("Enrollment Form");

               con=getContentPane();

               con.setLayout(null);
                              
               

              

              
		
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

               



 
               



               position=new JPanel();
               position.setLayout(null);



	

		insert1 = new JButton("INSERT");
               	position.add( insert1 );
               	insert1.addActionListener(this);
              	insert1.setBounds(300,310,180,35);

 


		


		insert7 = new JButton(" EXIT ");
               	position.add( insert7 );
               	insert7.addActionListener(this);
	        insert7.setBounds(520,310,180,35);

		


		l1=new JLabel("Enter Identification Number");
		position.add(l1);
                l1.setBounds(150,30,180,35);
		
		l2=new JLabel("Enter Name");
		position.add(l2);
                l2.setBounds(150,80,180,35);

		l3=new JLabel("Enter Address");
		position.add(l3);
                l3.setBounds(150,130,180,35);



		t1=new JTextField();
		position.add(t1);
                t1.setBounds(350,30,180,35);
		
		t2=new JTextField();
		position.add(t2);
                t2.setBounds(350,80,180,35);

		t3=new JTextField();
		position.add(t3);
                t3.setBounds(350,130,180,35);
		

















               panel3=new JPanel();



                

              panel4=new JPanel();
                




               position.setBorder(BorderFactory.createEtchedBorder());

               text = new JPanel();
               text.setLayout(null);








 





               text.setBorder(BorderFactory.createEtchedBorder());

               jtabbedpane2=new JTabbedPane();
               jtabbedpane2.addTab("Enrollment Form",position);
               

               position.add(panel3);
              panel3.setBounds(20,35,150,100);
   
  
               position.add(panel4);
               panel4.setBounds(180,35,150,100);
  
 
               panel1.add(jtabbedpane2);
              











tools.add(jtabbedpane2,BorderLayout.CENTER);
               tools.add(jtabbedpane2);

jtabbedpane2.setBounds(15,70,990,180);
 




              



 







 

 


          
              
               

             

               
              
               

              JLabel label = new JLabel("Enrollment Form",JLabel.CENTER);
              
              
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
System.exit(1);
}
else if(ae.getSource()==insert1)
{
t1_val = t1.getText();
t2_val = t2.getText();
t3_val = t3.getText();

System.out.println(t1_val+"\t"+t2_val+"\t"+t3_val);

insert_data(t1_val,t2_val,t3_val);



}

  
 

}

void insert_data(String t1_val,String t2_val,String t3_val)
{
System.out.println(t1_val+"\t"+t2_val+"\t"+t3_val);
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con1=DriverManager.getConnection("jdbc:odbc:biometric");
}
 catch(Exception e)
{
//e.printStackTrace();
System.err.println("Error: con1 " + e.getMessage());
}

try{

Statement st1=con1.createStatement();
String sql="insert into profiles values('"+t1_val+"','"+t2_val+"','"+t3_val+"')";
System.out.println(sql);
int i_1=st1.executeUpdate(sql);
if(i_1>0)
{
JOptionPane.showMessageDialog(null,"Your Personal details are Saved\n Please give the Thumb for Enrollment");
//MainForm mf=new MainForm();
 EnrollmentForm form = new EnrollmentForm(this);
        form.setVisible(true);
}

}
catch(Exception e)
{
//e.printStackTrace();
System.err.println("Error: con1 " + e.getMessage());
}



}
      
 
public static void main(String a[])
       {
	       Register app = new Register();
               //app.setDefaultCloseOperation(EXIT_ON_CLOSE);
               app.setSize(1024,500);
               app.setVisible(true);  
               app.setResizable(false);
		 
		 
       }

  


     
}//main STEP_NC_Gui class
