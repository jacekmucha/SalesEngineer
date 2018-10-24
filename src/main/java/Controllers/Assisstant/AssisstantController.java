package Controllers.Assisstant;

import Controllers.Main.LauncherController;
import Launcher.Launcher;
import Utils.FXMLLoader.FXMLFilePaths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AssisstantController {

    @FXML
    private Button maxWindowButton;
    @FXML
    private Button goToNewConversationButton;


    @FXML
    public void openMainWindowV2(ActionEvent event) throws IOException {
        Parent assisstantParent = FXMLLoader.load(getClass().getResource(FXMLFilePaths.LAUNCHER_FXML));
        Scene assisstantScene = new Scene(assisstantParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(assisstantScene);
        window.show();
    }


    @FXML
    public void openMainWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        Launcher.getMainStage().setIconified(false);
    }


    @FXML
    public void goToNewConversation(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLFilePaths.LAUNCHER_FXML));
        LauncherController controller = (LauncherController) loader.getController();
        controller.openNewConverationTab();
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        Launcher.getMainStage().setIconified(false);

    }


}


