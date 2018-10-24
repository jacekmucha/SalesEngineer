package Dialogs;

import javafx.scene.control.Alert;

public class EmailErrorAlert {

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Błąd podczas wysyłania emaila!");
        alert.setHeaderText("Wystąpił błąd podczas wysyłania powiadomień email!");
        alert.setContentText("Sprawdź, czy na pewno masz dostęp do Internetu!");
        alert.showAndWait();
    }
}
