package Dialogs;

import Controllers.Main.LauncherController;
import Utils.AutoUpdate.AutoUpdate;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Dialogs {

    LauncherController launcherController = new LauncherController();

    public static boolean updateApp() {

        AutoUpdate.readCurrentVersionFromWeb();

        if (AutoUpdate.validateVersion()) {

            Alert infoAlert = new Alert(Alert.AlertType.CONFIRMATION);
            infoAlert.setTitle("Aktualizuj program");
            infoAlert.setHeaderText("Dnia " + AutoUpdate.LAST_RELEASE_DATE + " ukazała się nowsza wersja programu: " + AutoUpdate.UPDATE_VERSION);
            infoAlert.setContentText("Czy chcesz zakutalizować program teraz?\n\n");

            ButtonType downloadOnly = new ButtonType("Pobierz wersję " + AutoUpdate.UPDATE_VERSION);
            ButtonType cancel = new ButtonType("Anuluj", ButtonBar.ButtonData.CANCEL_CLOSE);
            infoAlert.getButtonTypes().setAll(downloadOnly, cancel);
            Optional<ButtonType> result = infoAlert.showAndWait();

            if (result.get() == downloadOnly) {
                AutoUpdate.downloadNewVersion();
                return true;
            }
            if (result.get() == cancel) {
                return true;
            }
            infoAlert.showAndWait();
            infoAlert.hide();
            infoAlert.close();
        }

        return false;
    }
}
