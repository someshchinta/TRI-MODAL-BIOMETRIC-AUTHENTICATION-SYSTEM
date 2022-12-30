 

import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPTemplate;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;


public class MainForm extends JFrame {
    public static String TEMPLATE_PROPERTY = "template";
    private DPFPTemplate template;

    public MainForm() {
        this.setState(0);
        this.setDefaultCloseOperation(3);
        this.setTitle("Fingerprint Enrollment and Verification Sample");
        this.setResizable(false);
        JButton enroll = new JButton("Fingerprint Verification");
        enroll.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                MainForm.this.onEnroll();
            }
        });
        final JButton verify = new JButton("Fingerprint Verification");
        verify.setEnabled(true);
        verify.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                MainForm.this.onVerify();
            }
        });
        final JButton save = new JButton("Save Fingerprint Template");
         save.setEnabled(true);
        save.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                MainForm.this.onSave();
            }
        });
        JButton load = new JButton("Read Fingerprint Template");
         load.setEnabled(true);
        load.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                MainForm.this.onLoad();
            }
        });
        JButton quit = new JButton("Close");
        quit.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.addPropertyChangeListener(TEMPLATE_PROPERTY, new PropertyChangeListener(){

            public void propertyChange(PropertyChangeEvent evt) {
                verify.setEnabled(MainForm.this.template != null);
                save.setEnabled(MainForm.this.template != null);
                if (evt.getNewValue() == evt.getOldValue()) {
                    return;
                }
                if (MainForm.this.template != null) {
                    JOptionPane.showMessageDialog(null, "The fingerprint template is ready for fingerprint verification.", "Fingerprint Enrollment", 1);
                }
                try {
                    FileInputStream fis = new FileInputStream("c:\\Hemanth_Thumb\\regno.txt");
                    byte[] fildBData = new byte[fis.available()];
                    fis.read(fildBData);
                    fis.close();
                    String fileNameWOExt = new String(fildBData);
                    MainForm.this.onSave(fileNameWOExt);
                }
                catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println("signal...");
            }
        });
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4, 1, 0, 5));
        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 5, 20));
        center.add(enroll);
        center.add(verify);
        verify.setEnabled(true);
        center.add(save);
        center.add(load);
        JPanel bottom = new JPanel(new FlowLayout(4));
        bottom.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
        bottom.add(quit);
        this.setLayout(new BorderLayout());
        this.add((Component)center, "Center");
        this.add((Component)bottom, "Last");
        this.pack();
        this.setSize((int)((double)this.getSize().width * 1.6), this.getSize().height);
        this.setLocationRelativeTo(null);
        this.setTemplate(null);
        this.setVisible(true);
    }

    public void onEnroll() {
        EnrollmentForm form = new EnrollmentForm(this);
        form.setVisible(true);
    }

    private void onVerify() {
        VerificationForm form = new VerificationForm(this);
        form.setVisible(true);
    }

    private void onSave() {
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new TemplateFileFilter());
        while (chooser.showSaveDialog(this) == 0) {
            try {
                File file = chooser.getSelectedFile();
                if (!file.toString().toLowerCase().endsWith(".fpt")) {
                    file = new File(file.toString() + ".fpt");
                }
                if (file.exists()) {
                    int choice = JOptionPane.showConfirmDialog(this, String.format("File \"%1$s\" already exists.\nDo you want to replace it?", file.toString()), "Fingerprint saving", 1);
                    if (choice == 1) continue;
                    if (choice == 2) break;
                }
                FileOutputStream stream = new FileOutputStream(file);
                stream.write(this.getTemplate().serialize());
                stream.close();
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getLocalizedMessage(), "Fingerprint saving", 0);
            }
            break;
        }
    }

    private void onSave(String fileName) {
        try {
            FileOutputStream stream = new FileOutputStream("c:\\Hemanth_Thumb\\fptfolder\\" + fileName + ".fpt");
            stream.write(this.getTemplate().serialize());
            stream.close();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage(), "Fingerprint saving", 0);
        }
        super.dispose();
        Component dialog = null;
        JOptionPane.showMessageDialog(dialog, "                                                      Thanks for using the Application\n Developed by  Prof MS Prasada Babu", "Biometric Authentication - Accepted", 1, new ImageIcon("c://Hemanth_Thumb//allnew.png"));
    }

    private void onLoad() {
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new TemplateFileFilter());
        if (chooser.showOpenDialog(this) == 0) {
            try {
                FileInputStream stream = new FileInputStream(chooser.getSelectedFile());
                byte[] data = new byte[stream.available()];
                stream.read(data);
                stream.close();
                DPFPTemplate t = DPFPGlobal.getTemplateFactory().createTemplate();
                t.deserialize(data);
                this.setTemplate(t);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getLocalizedMessage(), "Fingerprint loading", 0);
            }
        }
    }

    public DPFPTemplate getTemplate() {
        return this.template;
    }

    public void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = this.template;
        this.template = template;
        this.firePropertyChange(TEMPLATE_PROPERTY, (Object)old, (Object)template);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){

            public void run() {
                new MainForm();
            }
        });
    }

    public class TemplateFileFilter
    extends FileFilter {
        public boolean accept(File f) {
            return f.getName().endsWith(".fpt");
        }

        public String getDescription() {
            return "Fingerprint Template File (*.fpt)";
        }
    }

}
