package Launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static final String APP_NAME = "Inżynier sprzedaży";
    final String LAUNCHER_FXML = "/fxml/Launcher/Launcher.fxml";
    public static Double AppVersion = 1.1;

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource(LAUNCHER_FXML));
        Pane pane = loader.load();
        Scene sceneMain = new Scene(pane);
        primaryStage.setScene(sceneMain);
        primaryStage.setTitle(APP_NAME);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
