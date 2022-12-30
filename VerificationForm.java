 
import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import java.awt.Frame;
import java.awt.Window;


public class VerificationForm extends CaptureForm {
    private DPFPVerification verificator = DPFPGlobal.getVerificationFactory().createVerification();

    VerificationForm(Frame owner) {
        super(owner);
        
    }

    protected void init() {
        super.init();
        this.setTitle("Fingerprint Verification");
        this.updateStatus(0);
    }

    protected void process(DPFPSample sample) {
        super.process(sample);
        DPFPFeatureSet features = this.extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
        if (features != null) {
            DPFPVerificationResult result = this.verificator.verify(features, ((MainForm)this.getOwner()).getTemplate());
            this.updateStatus(result.getFalseAcceptRate());
            if (result.isVerified()) {
                this.makeReport("The fingerprint was VERIFIED.");
            } else {
                this.makeReport("The fingerprint was NOT VERIFIED.");
            }
        }
    }

    private void updateStatus(int FAR) {
        this.setStatus(String.format("False Accept Rate (FAR) = %1$s", FAR));
    }
}

