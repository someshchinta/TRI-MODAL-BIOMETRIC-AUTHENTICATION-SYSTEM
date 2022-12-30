
import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.processing.DPFPTemplateStatus;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.JOptionPane;



public class EnrollmentForm extends CaptureForm {
    private DPFPEnrollment enroller = DPFPGlobal.getEnrollmentFactory().createEnrollment();

    EnrollmentForm(Frame owner) {
        super(owner);
    }

    protected void init() {
        super.init();
        this.setTitle("Developed by  Prof MS Prasada Babu");
        this.updateStatus();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void process(DPFPSample sample) {
        super.process(sample);
        DPFPFeatureSet features = this.extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
        if (features == null) return;
        try {
            try {
                this.makeReport("The fingerprint feature set was created.");
                this.enroller.addFeatures(features);
            }
            catch (DPFPImageQualityException ex) {
                Object var5_4 = null;
                this.updateStatus();
                switch (this.enroller.getTemplateStatus()) {
                    case TEMPLATE_STATUS_READY: {
                        this.stop();
                        ((MainForm)this.getOwner()).setTemplate(this.enroller.getTemplate());
                        this.setPrompt("Developed by  Prof MS Prasada Babu");
                        return;
                    }
                    case TEMPLATE_STATUS_FAILED: {
                        this.enroller.clear();
                        this.stop();
                        this.updateStatus();
                        ((MainForm)this.getOwner()).setTemplate(null);
                        JOptionPane.showMessageDialog(this, "The fingerprint template is not valid. Repeat fingerprint enrollment.", "Fingerprint Verification", 0);
                        this.start();
                    }
                }
                return;
            }
            Object var5_3 = null;
            this.updateStatus();
            switch (this.enroller.getTemplateStatus()) {
                case TEMPLATE_STATUS_READY: {
                    this.stop();
                    ((MainForm)this.getOwner()).setTemplate(this.enroller.getTemplate());
                    this.setPrompt("Developed by  Prof MS Prasada Babu");
                    return;
                }
                case TEMPLATE_STATUS_FAILED: {
                    this.enroller.clear();
                    this.stop();
                    this.updateStatus();
                    ((MainForm)this.getOwner()).setTemplate(null);
                    JOptionPane.showMessageDialog(this, "The fingerprint template is not valid. Repeat fingerprint enrollment.", "Fingerprint Verification", 0);
                    this.start();
                }
            }
            return;
        }
        catch (Throwable var4_7) {
            Object var5_5 = null;
            this.updateStatus();
            switch (this.enroller.getTemplateStatus()) {
                case TEMPLATE_STATUS_READY: {
                    this.stop();
                    ((MainForm)this.getOwner()).setTemplate(this.enroller.getTemplate());
                    this.setPrompt("Developed by  Prof MS Prasada Babu");
                    throw var4_7;
                }
                case TEMPLATE_STATUS_FAILED: {
                    this.enroller.clear();
                    this.stop();
                    this.updateStatus();
                    ((MainForm)this.getOwner()).setTemplate(null);
                    JOptionPane.showMessageDialog(this, "The fingerprint template is not valid. Repeat fingerprint enrollment.", "Fingerprint Verification", 0);
                    this.start();
                }
            }
            throw var4_7;
        }
    }

    private void updateStatus() {
        this.setStatus(String.format("Fingerprint samples needed: %1$s", this.enroller.getFeaturesNeeded()));
    }

}

