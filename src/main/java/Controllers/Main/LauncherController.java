package Controllers.Main;

import Dialogs.Dialogs;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Setter
@Getter
public class LauncherController {

    @FXML
    private Label appUpdateStatus;


    @FXML
    void initialize(){
        checkForUpdate();
    }


    @FXML
    public void checkForUpdate() {

        if(!netIsAvailable()){
            appUpdateStatus.setText("brak dostępu do Internetu");
            appUpdateStatus.setTextFill(Color.web("#ff0000"));
            return;
        }
        if(!Dialogs.updateApp()){
            appUpdateStatus.setText("aktualna");
            appUpdateStatus.setTextFill(Color.web("#008000"));
        } else {
            appUpdateStatus.setText("dostępna nowa wersja");
            appUpdateStatus.setTextFill(Color.web("#ff8000"));
        }
    }

    private static boolean netIsAvailable() {
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return false;
        }
    }

}
