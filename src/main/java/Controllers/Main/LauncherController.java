package Controllers.Main;

import Controllers.Assisstant.AssisstantController;
import Dialogs.Dialogs;
import Utils.FXMLLoader.FXMLFilePaths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    private Button toSmallWindowButton;
    @FXML
    private Tab waitingModeTab;
    @FXML
    private Tab newConversationTab;


    final String assisstantFXMLPath = "/fxml/Assisstant/Assisstant.fxml";
    final String mainWindow = "/fxml/Launcher/Launcher.fxml";
    final String assisstantWindowName = "Asystent";

    private AssisstantController assisstantController;


    @FXML
    public void checkForUpdate() {

        if (!netIsAvailable()) {
            appUpdateStatus.setText("brak dostępu do Internetu");
            appUpdateStatus.setTextFill(Color.web("#ff0000"));
            return;
        }
        if (!Dialogs.updateApp()) {
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

    @FXML
    public void openAssisstant(ActionEvent event) throws IOException {

        Parent assisstantParent = FXMLLoader.load(getClass().getResource(FXMLFilePaths.ASSISSTANT_FXML));
        Scene assisstantScene = new Scene(assisstantParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(assisstantScene);
//        javafx.geometry.Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
//        window.setAlwaysOnTop(true);
//        window.initStyle(StageStyle.UNDECORATED);
//        window.setX(primaryScreenBounds.getMaxX() - 500);
//        window.setY(primaryScreenBounds.getMinY());
        window.show();
    }


    private Stage prepareStage(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        return stage;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        checkForUpdate();
    }
}
