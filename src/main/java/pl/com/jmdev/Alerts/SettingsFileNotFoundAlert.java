package pl.com.jmdev.Alerts;

import javafx.scene.control.Alert;

public class SettingsFileNotFoundAlert {

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Błąd podczas wczytywania ustawień programu");
        alert.setHeaderText("Wystąpił błąd podczas wczytywania ustawień programu!");
        alert.setContentText("Sprawdź lokalizajcę swoich plików konfiguracyjnych.");
        alert.showAndWait();
    }

}
