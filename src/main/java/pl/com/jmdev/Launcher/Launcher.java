package pl.com.jmdev.Launcher;

import javafx.scene.image.Image;
import pl.com.jmdev.Utils.FXMLLoader.FXMLFilePaths;
import pl.com.jmdev.Utils.FXMLLoader.FXMLLoaderSingleton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static final String APP_NAME = "Inżynier sprzedaży";

    public static Double AppVersion = 1.1;
    private static Stage mainStage;

    public static Stage getMainStage() {
        return mainStage;
    }
    public void openMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        openMainStage(primaryStage);
        FXMLLoader loadMainScene = FXMLLoaderSingleton.getInstance().getLoader();
        loadMainScene.setLocation(this.getClass().getResource(FXMLFilePaths.LAUNCHER_FXML));
        Pane mainScenePane = loadMainScene.load();
        Scene mainScene = new Scene(mainScenePane);

        primaryStage.setScene(mainScene);
        primaryStage.setTitle(APP_NAME);
        primaryStage.getIcons().add(
                new Image(getClass().getResourceAsStream( "/SalesEngineer.ico")));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
