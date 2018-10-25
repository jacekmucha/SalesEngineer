package pl.com.jmdev.Alerts;

import javafx.scene.control.Alert;

public class MessageSuccessfulySendAlert {

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Powiadomienie wysłane!");
        alert.setHeaderText("Powiadomienie email zostało wysłane.");
        alert.setContentText("Zaznaczeni odbiorczy mogą już sprawdzić swoją skrzynkę email.");
        alert.showAndWait();
    }

}
