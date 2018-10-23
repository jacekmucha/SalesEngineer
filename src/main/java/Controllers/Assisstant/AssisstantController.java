package Controllers.Assisstant;

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
    public void openMainWindow(ActionEvent event) throws IOException {
        Parent assisstantParent = FXMLLoader.load(getClass().getResource(FXMLFilePaths.LAUNCHER_FXML));
        Scene assisstantScene = new Scene(assisstantParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(assisstantScene);
        window.show();
    }

    @FXML
    public void goToNewConversation(ActionEvent actionEvent) {

    }



}


