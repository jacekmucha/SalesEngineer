package pl.com.jmdev.Controllers.Settings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import pl.com.jmdev.Alerts.LicensesSavedAlert;
import pl.com.jmdev.Utils.LicenseManager.LicenseManager;
import java.net.URL;
import java.util.ResourceBundle;

public class LicenseController implements Initializable {

    @FXML
    private TextField basicLicenseKey;
    @FXML
    private TextField proLicenseKey;
    @FXML
    private TextField maxLicenseKey;

    LicenseManager licenseManager = new LicenseManager();
    LicensesSavedAlert licensesSavedAlert = new LicensesSavedAlert();

    public void saveMyLicenseKeys(ActionEvent event) {
        licenseManager.saveMyLicense(basicLicenseKey.getText(), proLicenseKey.getText(), maxLicenseKey.getText());
        licensesSavedAlert.showAlert();
    }

    private void loadMyLicenseKeys(){
        basicLicenseKey.setText(licenseManager.loadMyLicense().getBASIC_KEY());
        proLicenseKey.setText(licenseManager.loadMyLicense().getPRO_KEY());
        maxLicenseKey.setText(licenseManager.loadMyLicense().getMAX_KEY());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadMyLicenseKeys();
        licenseManager.validateLicense();
    }
}
