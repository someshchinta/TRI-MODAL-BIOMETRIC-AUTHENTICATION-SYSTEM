/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  com.digitalpersona.onetouch.DPFPGlobal
 *  com.digitalpersona.onetouch.DPFPTemplate
 */
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPTemplate;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import javax.swing.JFrame;

public class FeaturesVerify
extends JFrame {
    private static DPFPTemplate template;
    public static String TEMPLATE_PROPERTY;
    public static String reserveno;

    public void ProcessFiles() throws Exception {
        File[] all;
        File f = new File("C:\\Hemanth_Thumb\\fptfolder");
        for (File fs : all = f.listFiles()) {
            System.out.println("File is " + fs.getName() + " Size is " + fs.length() + "Bytes");
            FileInputStream stream = new FileInputStream(fs.getAbsolutePath());
            byte[] data = new byte[stream.available()];
            stream.read(data);
            stream.close();
            DPFPTemplate t = DPFPGlobal.getTemplateFactory().createTemplate();
            t.deserialize(data);
            MyTemplate temp = new MyTemplate();
            temp.setTemplate(t);
            System.out.println("Object restored ");
        }
    }

    public void setTemplate(DPFPTemplate otemplate) {
        DPFPTemplate old = template;
        template = otemplate;
        this.firePropertyChange(TEMPLATE_PROPERTY, (Object)old, (Object)template);
    }

    public DPFPTemplate getTemplate() {
        return template;
    }

    static {
        TEMPLATE_PROPERTY = "template";
        reserveno = "";
    }
}

