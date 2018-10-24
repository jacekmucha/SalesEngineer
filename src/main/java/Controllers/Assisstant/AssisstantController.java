package Controllers.Assisstant;

import Controllers.Main.LauncherController;
import Controllers.StageConfig.StageConfig;
import Launcher.Launcher;
import Utils.FXMLLoader.FXMLFilePaths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AssisstantController {


    @FXML
    public void openMainWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        Launcher.getMainStage().setIconified(false);
        StageConfig.getLauncherController().openWaitingModeTab();

    }


    @FXML
    public void goToNewConversation(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLFilePaths.LAUNCHER_FXML));
        LauncherController controller = (LauncherController) loader.getController();
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        Launcher.getMainStage().setIconified(false);
        StageConfig.getLauncherController().openNewConverationTab();
    }

}


