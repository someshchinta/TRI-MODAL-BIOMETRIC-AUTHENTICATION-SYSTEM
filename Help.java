
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Help extends JPanel
{
       int select;

       String title = "BIOMETRIC AUTHENTICATION SYSTEM";
       String s1 = "BIOMETRIC AUTHENTICATION SYSTEM";
       String s2 = "";
       //String s0 = "# Image As Watermark";
       String s3 = "1. Enrollment.";
       String s4 = "2.  Authentication.";
       String s5 = "3.  Give the details for new Enrollment.";
       String s6 = "4.  Give the details for authentication.";
       String s7 = "5.  EXIT.";

       

       
       public Help()
       {
       }
       public void Display(int num)
       {
               select = num;
 
               repaint();
       }

       public void paintComponent(Graphics g)
       {
               super.paintComponent(g);
               g.drawRect(12,17,960,222);
               if( select == 1 )
               {
                       g.setFont( new Font( "Arial", Font.PLAIN, 16));
                       g.setColor(Color.blue);
                       g.drawString(title,50,130);
               }
               else if( select == 2 )
               {
                       g.setFont( new Font( "Arial", Font.PLAIN, 16));
                       g.setColor(Color.blue);
                       g.drawString(s1,85,50);
                       g.setColor(Color.darkGray);
                       g.drawLine(21,60,760,60);
                       g.setFont( new Font( "Arial", Font.ITALIC, 16));
                       g.setColor(Color.blue);
                       g.setFont( new Font( "Century gothic", Font.BOLD, 14));
                       g.setColor(Color.darkGray);
                       g.drawString(s3,60,100);
                       g.drawString(s4,60,130);
                       g.drawString(s5,60,160);
                       g.drawString(s6,60,190);
		g.drawString(s7,60,220);
               }
               else if( select ==3 )
               {
                       g.setFont( new Font( "Arial", Font.PLAIN, 16));
                       g.setColor(Color.blue);
                       g.drawString(s1,85,50);
                       g.setColor(Color.darkGray);
                       g.drawLine(21,60,760,60);
                       g.setFont( new Font( "Arial", Font.ITALIC, 16));
                       //g.setColor(Color.red);
                       //g.drawString(s2,45,80);
                       //g.setColor(Color.blue);
                      // g.drawString(s7,50,95);
                       /*g.setFont( new Font( "Century gothic", Font.BOLD, 14));
                       g.setColor(Color.darkGray);
                       g.drawString(s8,60,140);
                       g.drawString(s9,60,170);
                       g.drawString(s10,60,200);
                       g.drawString(s11,60,230);*/
               }
               
       }
   }
