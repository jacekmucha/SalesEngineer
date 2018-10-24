package Controllers.Main;

import Utils.FXMLLoader.FXMLFilePaths;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class RightTopButtonsController {


    public void openAssisstantStage(ActionEvent event) {
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
        FXMLLoader loadWaitingWindow = new FXMLLoader(this.getClass().getResource(FXMLFilePaths.ASSISSTANT_FXML));
        Parent waitingWindow = null;

        try {
            javafx.geometry.Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            waitingWindow = (Parent) loadWaitingWindow.load();
            Stage waitingStage = new Stage();
            waitingStage.setTitle("Asystent");
            waitingStage.setScene(new Scene(waitingWindow));
            waitingStage.setAlwaysOnTop(true);
            waitingStage.initStyle(StageStyle.UNDECORATED);
            waitingStage.setX(primaryScreenBounds.getMaxX() - 500);
            waitingStage.setY(primaryScreenBounds.getMinY());
            waitingStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
