package Model;

import Helpers.JSON.ObjectMapperSingleton;
import lombok.Getter;
import lombok.Setter;
import java.io.*;

@Getter
@Setter
public class EmailServerSettings {

    private String connectionType;
    private String from;
    private String emailUsername;
    private String emailPassword;
    private String HOST_TLS;
    private String HOST_SSL;
    private String SMTP_TLS;
    private String SMTP_SSL;
    private String PORT_TLS;
    private String PORT_SSL;
    private String SettingsFilePath = "src/main/resources/AppSettings/emailServerSettings.json";

    public void saveEmailSettingsToJSON(EmailServerSettings settings){

        try {
            ObjectMapperSingleton.getInstance().writeValue(new File(SettingsFilePath), settings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
