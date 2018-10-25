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
    private TextField basicLicenseKey;
    @FXML
    private TextField proLicenseKey;
    @FXML
    private TextField maxLicenseKey;

    LicenseManager licenseManager = new LicenseManager();

    public void activeateLicenseKeys(ActionEvent event) {
    }

    private void checkLicensesOnStartup(){
        licenseManager.validateBASIC(basicLicenseKey.getText());
        licenseManager.validatePRO(proLicenseKey.getText());
        licenseManager.validateMAX(maxLicenseKey.getText());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
