package pl.com.jmdev.Controllers.Main;

import pl.com.jmdev.Controllers.Mediator.ControllerMediator;
import pl.com.jmdev.Controllers.StageConfig.StageConfig;
import pl.com.jmdev.Alerts.AutoUpdateAlert;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

@Setter
@Getter
public class LauncherController implements Initializable {

    @FXML
    private Label appUpdateStatus;
    @FXML
    private Button appUpdateButton;
    @FXML
    private TabPane wholeTabPane;
    @FXML
    private Tab waitingModeTab;
    @FXML
    private Tab newConversationTab;

    @FXML
    private WaitingModeController waitingModeFXMLController;
    @FXML
    private NewConversationController newConversationFXMLController;

    final String assisstantWindowName = "Asystent";


    @FXML
    public void checkForUpdate() {

        if (!netIsAvailable()) {
            appUpdateStatus.setText("brak dostępu do Internetu");
            appUpdateStatus.setTextFill(Color.web("#ff0000"));
            appUpdateButton.setDisable(true);
            return;
        }
        if (!AutoUpdateAlert.updateApp()) {
            appUpdateStatus.setText("aktualna");
            appUpdateStatus.setTextFill(Color.web("#008000"));
            appUpdateButton.setDisable(true);

        } else {
            appUpdateStatus.setText("dostępna nowa wersja");
            appUpdateStatus.setTextFill(Color.web("#ff8000"));
            appUpdateButton.setDisable(false);

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        checkForUpdate();
        ControllerMediator.getInstance().registerWaitingModeController(waitingModeFXMLController);
        ControllerMediator.getInstance().registerNewConversationController(newConversationFXMLController);
        StageConfig.setLauncherController(this);
    }

    public void openNewConverationTab(){
        wholeTabPane.getSelectionModel().select(newConversationTab);
    }

    public void openWaitingModeTab(){wholeTabPane.getSelectionModel().select(waitingModeTab);}
}
