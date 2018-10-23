package Launcher;

import Utils.FXMLLoader.FXMLFilePaths;
import Utils.FXMLLoader.FXMLLoaderSingleton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static final String APP_NAME = "Inżynier sprzedaży";

    public static Double AppVersion = 1.1;

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loadMainScene = FXMLLoaderSingleton.getInstance().getLoader();
        loadMainScene.setLocation(this.getClass().getResource(FXMLFilePaths.LAUNCHER_FXML));
        Pane mainScenePane = loadMainScene.load();
        Scene mainScene = new Scene(mainScenePane);

        primaryStage.setScene(mainScene);
        primaryStage.setTitle(APP_NAME);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
