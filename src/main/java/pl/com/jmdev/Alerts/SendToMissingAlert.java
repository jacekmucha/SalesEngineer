package pl.com.jmdev.Alerts;

import javafx.scene.control.Alert;

public class SendToMissingAlert {

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Brak odbiorcy powiadomienia!");
        alert.setHeaderText("Nie wiem do kogo wysłać wiadomość!");
        alert.setContentText("Wróć do formularza i wybierz osoby, które należy powiadomić przez email.");
        alert.showAndWait();
    }
}
