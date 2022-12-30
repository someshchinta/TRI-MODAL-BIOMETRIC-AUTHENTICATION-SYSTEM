/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  com.digitalpersona.onetouch.DPFPTemplate
 */
import com.digitalpersona.onetouch.DPFPTemplate;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyReader extends JFrame {

    private static final long serialVersionUID = 1L;
    final String[] info = new String[40];
    int flag1 = 0;
    int flag2 = 0;
    public static String TEMPLATE_PROPERTY = "template";
    private DPFPTemplate template;
    public DPFPTemplate t;
    public DPFPTemplate old;
    public String num = "";
    public String myFileName = "";
    private Object ki;
    private Object ph;
String userName = "root";
    String passWord = "";
    
   
    
         
    public void setTemplate(DPFPTemplate template) {
        this.old = this.template;
        this.template = template;
        this.firePropertyChange(TEMPLATE_PROPERTY, (Object)this.old, (Object)template);
    }

    public DPFPTemplate getTemplate() {
        return this.template;
    }

    public void mainFunction() {
        Component dialog = null;
        Object tim = null;
        String outtime = "";
        boolean flag = false;
        try {
                 Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fingerr", this.userName, this.passWord);
            Statement st = con.createStatement();
            this.num = FeaturesVerify.reserveno;
            String msg2 = "select * from studentprofiles where AdmnNo='" + this.num + "'";
            try {
                ResultSet rs = st.executeQuery(msg2);
                while (rs.next()) {
                    for (int i = 1; i <= 8; ++i) {
                        this.info[i - 1] = rs.getString(i);
                    }
                }
                con.close();
                st.close();
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Sheet with name StudentProfiles not found");
            }
            JOptionPane.showMessageDialog(dialog, "Name                           :    " + this.info[1] + "\nRegistration No         :    " + this.info[0] + "\nYear Of Study            :    " + this.info[3] + "\nDepartment of           :    " + this.info[4] + "\nHostel Block Code    :    " + this.info[6] + "\nRoom No                     :    " + this.info[5] + "", "GMR Institute Of Technology - Biometric Authentication Out Pass System", 1, new ImageIcon("student_pics//" + this.num + ".jpg"));
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getLocalizedMessage(), "Fingerprint loading", 0);
        }
    }

    public void print3() {
        int helloprint = 2;
        Date hema = new Date();
        boolean status = true;
        String tim = null;
        String timm = null;
        final String time = "" + hema.getHours() + ":" + hema.getMinutes() + ":" + hema.getSeconds();
        final String date = "" + hema.getDate() + "-" + (hema.getMonth() + 1) + "-" + (hema.getYear() + 1900);
        final String timeI = tim + ":" + timm;
        try {
            PrinterJob pjob = PrinterJob.getPrinterJob();
            pjob.setJobName("Graphics Printout");
            pjob.setCopies(1);
            pjob.setPrintable(new Printable(){

                @Override
                public int print(Graphics pg, PageFormat pf, int pageNum) {
                    if (pageNum > 0) {
                        return 1;
                    }
                    pg.drawString("GMR Institute Of Technology , Rajam ", 20, 85);
                    pg.drawString(" ( Hostler's Pink Pass  )", 50, 100);
                    if ("staff".equals(MyReader.this.info[3]) || MyReader.this.info[3] == "STAFF") {
                        pg.drawString("Date  :" + date + "", 35, 70);
                        pg.drawString("Time Out  :" + time + ", Expected Time In : " + " " + timeI, 35, 70);
                        pg.drawString("Name   : " + MyReader.this.info[1], 35, 90);
                        pg.drawString("Id         : " + MyReader.this.info[0], 35, 110);
                        pg.drawString("Desg    : " + MyReader.this.info[5], 35, 130);
                        pg.drawString("Branch : " + MyReader.this.info[4], 35, 150);
                        pg.drawString("Signature", 145, 190);
                    } else {
                        pg.drawString("Date  : " + date + "", 25, 120);
                        pg.drawString("Time Out  :" + time, 25, 140);
                        pg.drawString("Name : " + MyReader.this.info[1], 25, 160);
                        pg.drawString("No    : " + MyReader.this.info[0], 25, 180);
                        pg.drawString("Year         : " + MyReader.this.info[3], 25, 200);
                        pg.drawString("Branch     : " + MyReader.this.info[4], 25, 220);
                        pg.drawString("Room No : " + MyReader.this.info[5], 25, 240);
                        pg.drawString("Block        : " + MyReader.this.info[6], 25, 260);
                        pg.drawString(".", 145, 280);
                        pg.drawString("Signature", 145, 300);
                        pg.drawString(".", 145, 320);
                        pg.drawString("Parent Signature", 25, 340);
                    }
                    pg.drawString(".", 145, 330);
                    return 0;
                }
            });
            if (!pjob.printDialog()) {
                return;
            }
            pjob.print();
        }
        catch (PrinterException pe) {
            pe.printStackTrace();
        }
    }

    public void hemudb() {
        Object tim;
        
        Object inf = null;
        boolean status = true;
        Date hemu = new Date();
        String opdate = "" + hemu.getHours() + " : " + hemu.getMinutes() + " : " + hemu.getSeconds();
        String date = "" + hemu.getDate() + "-" + (hemu.getMonth() + 1) + "-" + (hemu.getYear() + 1900);
        Object timeI = tim = null;
        boolean flag = false;
        Object timm = null;
        String yr = "" + (hemu.getYear() + 1900);
        this.mainFunction();
        int n = this.info[2].indexOf("HS");
        boolean stop = false;
        Component dialog = null;
        if (n != -1) {
            if (!stop && this.info[2] != null) {
                Connection con;
                try {
                     Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fingerr", this.userName, this.passWord);
            Statement st = con.createStatement();
                }
                catch (Exception re) {
                    JOptionPane.showMessageDialog(null, "Problem while connecting to database source file of Outpass Register");
                }
                String time = "" + hemu.getHours() + ":" + hemu.getMinutes() + ":" + hemu.getSeconds();
                date = "" + hemu.getDate() + "-" + (hemu.getMonth() + 1) + "-" + (hemu.getYear() + 1900);
                try {
                    String name;
                    Date dt;
                    String str;
                    String text;
                    ResultSet rs1;
                    Statement st1;
                    
                    String ph;
                     Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fingerr", this.userName, this.passWord);
            Statement st = con.createStatement();
                    String msg3 = "select * from PinkPass where FirstName='" + this.info[1] + "'AND JNTUNO='" + this.info[0] + "'AND InTime is null";
                    ResultSet rs = st.executeQuery(msg3);
                    if (rs.next()) {
                        flag = true;
                        String string = rs.getString(8);
                    }
                    if (flag) {
                        try {
                           Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fingerr", this.userName, this.passWord);
             st = con.createStatement();
                            str = "select * from StudentProfiles1 where AdmnNo='" + this.info[0] + "'";
                            System.out.println("str" + str + "              7777777777777777                  ");
                            rs1 = st.executeQuery(str);
                            ph = "";
                            name = "";
                            if (rs1.next()) {
                                ph = rs1.getString(2);
                                name = rs1.getString(3);
                            }
                            System.out.println("no " + ph);
                            System.out.println("name" + name);
                         
                         Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fingerr", this.userName, this.passWord);
            st = con.createStatement();
                            String msg2 = "update PinkPass set InTime = '" + time + "' where FirstName='" + this.info[1] + "'AND JNTUNO='" + this.info[0] + "'";
                            st.executeUpdate(msg2);
                            msg2 = "update PinkPass set InDate = '" + date + "'  where FirstName='" + this.info[1] + "'AND JNTUNO='" + this.info[0] + "'";
                            st.executeUpdate(msg2);
                            JOptionPane.showMessageDialog(null, "Thanks " + this.info[1] + "\n         For Being Back to GMRIT");
                            status = true;
                        }
                        catch (ClassNotFoundException | SQLException | HeadlessException e) {
                            JOptionPane.showMessageDialog(null, "                The Student Details were not added in the Phone Numbers List\nWithout the Student Details in the Phone Numbers List You cannot Issue Pink Pass\n                                              Try Again By Adding Details");
                        }
                    }
                    if (!flag) {
                        try {
                            this.print3();
                             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fingerr", this.userName, this.passWord);
             st = con.createStatement();
                            str = "select * from StudentProfiles1 where AdmnNo='" + this.info[0] + "'";
                            rs1 = st.executeQuery(str);
                            ph = "";
                            name = "";
                            while (rs1.next()) {
                                ph = rs1.getString(2);
                                name = rs1.getString(3);
                                System.out.println("no " + ph);
                                System.out.println("name " + name);
                            }
                           
                            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fingerr", this.userName, this.passWord);
             st = con.createStatement();
                            int i = st.executeUpdate("insert into PINKPASS(FIRSTNAME,JNTUNO,AYEAR,BRANCH,ROOMNO,BLOCK,OUTDATE,OUTTIME) values('" + this.info[1] + "','" + this.info[0] + "','" + this.info[3] + "','" + this.info[4] + "','" + this.info[5] + "','" + this.info[6] + "','" + date + "','" + time + "')");
                            status = true;
                        }
                        catch (ClassNotFoundException | SQLException | HeadlessException e) {
                            JOptionPane.showMessageDialog(null, "                The Student Details were not added in the Phone Numbers List\nWithout the Student Details in the Phone Numbers List You cannot Issue Pink Pass\n                                      Try Again By adding Details");
                        }
                    }
                    con.close();
                    st.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Unauthorized to Issue Out Pass For a Day Scholar", "Severe Warning", 2);
            JOptionPane.showMessageDialog(null, "The Application Terminates now, Please Restart the Application", "Severe Warning", 0);
            System.exit(0);
        }
    }

    public void onVerify() {
        VerificationForm1 form = new VerificationForm1(this);
        form.setVisible(true);
        Component dialog = null;
        this.hemudb();
        if (this.flag1 == 1) {
            this.print3();
        }
        JOptionPane.showMessageDialog(dialog, "                                                      Thanks for using the Application\n Developed by Prof MS Prasada Babu", "Biometric Authentication - Accepted", 1, new ImageIcon("c://Hemanth_Thumb//allnew.png"));
    }

    public static void main(String[] args) {
        do {
            MyReader hemu = new MyReader();
            hemu.onVerify();
            hemu.setVisible(true);
	hemu.setSize(1024,500);
        } while (true);
    }

    public static void onNew() {
        MyReader hi = new MyReader();
        hi.onVerify();
    }

}

