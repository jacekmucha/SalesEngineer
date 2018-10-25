package pl.com.jmdev.Controllers.Assisstant;

import pl.com.jmdev.Controllers.Main.LauncherController;
import pl.com.jmdev.Controllers.StageConfig.StageConfig;
import pl.com.jmdev.Launcher.Launcher;
import pl.com.jmdev.Utils.FXMLLoader.FXMLFilePaths;
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


