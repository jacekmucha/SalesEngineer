package pl.com.jmdev.Controllers.Settings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import pl.com.jmdev.Utils.LicenseManager.LicenseManager;
import java.net.URL;
import java.util.ResourceBundle;

public class LicenseController implements Initializable {

    @FXML
    private TextField ownerName;
    @FXML
    private TextField basicLicenseKey;
    @FXML
    private TextField proLicenseKey;
    @FXML
    private TextField maxLicenseKey;

    LicenseManager licenseManager = new LicenseManager();

    public void saveLicenseKeys(ActionEvent event) {
        licenseManager.saveMyLicense(
                ownerName.getText(), basicLicenseKey.getText(),
                proLicenseKey.getText(), maxLicenseKey.getText());
    }

    private void checkLicensesOnStartup(){

    }

    private void setKeys(){
        ownerName.setText(licenseManager.loadMyLicense().getOwnerName());
        basicLicenseKey.setText(licenseManager.loadMyLicense().getBASIC_KEY());
        proLicenseKey.setText(licenseManager.loadMyLicense().getPRO_KEY());
        maxLicenseKey.setText(licenseManager.loadMyLicense().getMAX_KEY());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setKeys();
        licenseManager.loadServerResources();

    }
}
