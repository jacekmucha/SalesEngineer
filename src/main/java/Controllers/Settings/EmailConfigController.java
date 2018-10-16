package Controllers.Settings;

import Helpers.JSON.JSONFilePaths;
import Model.EmailServerSettings;
import Helpers.EmailServerSettings.EmailServerSettingsSingleton;
import Helpers.JSON.ObjectMapperSingleton;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lombok.Getter;
import lombok.Setter;
import java.io.File;
import java.io.IOException;

@Setter
@Getter
public class EmailConfigController {

    @FXML
    private ToggleGroup connectionTypeToggleGroup;
    @FXML
    private RadioButton connectionTypeAsTLS;
    @FXML
    private RadioButton connectionTypeAsSSL;
    @FXML
    private TextField fromTextField;
    @FXML
    private TextField emailLoginTextField;
    @FXML
    private TextField emailPassPassField;
    @FXML
    private TextField hostAddressTLS;
    @FXML
    private TextField PORT_TLS;
    @FXML
    private TextField hostAddressSSL;
    @FXML
    private TextField PORT_SSL;

    private String settingsFilePath;
    private String connectionType;


    @FXML
    public void initialize() {
        connectionTypeAsTLS.setSelected(true);
        loadEmailSettings();
        setTypeOfConnection();
    }

    public String chosenTypeOfConnection() {
        if (connectionTypeAsTLS.isSelected()) {
            return connectionTypeAsTLS.getText();
        } else return connectionTypeAsSSL.getText();
    }

    public void setTypeOfConnection() {
        if (connectionType.equals(connectionTypeAsTLS.getText())) {
            connectionTypeAsTLS.setSelected(true);
            connectionTypeAsSSL.setSelected(false);
        } else {
            connectionTypeAsTLS.setSelected(false);
            connectionTypeAsSSL.setSelected(true);
        }
    }


    public void saveEmailServerSettings() {
        EmailServerSettings emailServerSettings = EmailServerSettingsSingleton.getInstance();
        emailServerSettings.setConnectionType(chosenTypeOfConnection());
        emailServerSettings.setFrom(fromTextField.getText());
        emailServerSettings.setEmailUsername(emailLoginTextField.getText());
        emailServerSettings.setEmailPassword(emailPassPassField.getText());
        emailServerSettings.setHOST_TLS(hostAddressTLS.getText());
        emailServerSettings.setPORT_TLS(PORT_TLS.getText());
        emailServerSettings.setHOST_SSL(hostAddressSSL.getText());
        emailServerSettings.setPORT_SSL(PORT_SSL.getText());
        emailServerSettings.setSettingsFilePath(JSONFilePaths.mySettingsFilePath);
        emailServerSettings.saveEmailSettingsToJSON(emailServerSettings);
    }

    public void loadEmailSettings() {
        EmailServerSettings settings = null;
        try {
            settings = ObjectMapperSingleton.getInstance().readValue(new File(JSONFilePaths.mySettingsFilePath), EmailServerSettings.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        connectionType = JSONFilePaths.mySettingsFilePath;
        fromTextField.setText(settings.getFrom());
        emailLoginTextField.setText(settings.getEmailUsername());
        emailPassPassField.setText(settings.getEmailPassword());
        hostAddressTLS.setText(settings.getHOST_TLS());
        PORT_TLS.setText(settings.getPORT_TLS());
        hostAddressSSL.setText(settings.getHOST_SSL());
        PORT_SSL.setText(settings.getPORT_SSL());
        settingsFilePath = JSONFilePaths.mySettingsFilePath;
    }




}


