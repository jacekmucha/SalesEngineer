package pl.com.jmdev.Alerts;

import javafx.scene.control.Alert;

public class NoConnectionToLicenseServerAlert {

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Brak połączenia do serwera licencji!");
        alert.setHeaderText("Wystąpił błąd podczas połączenia z serwerem licencji! Funkcje programu są zablokowane.");
        alert.setContentText("Sprawdź, czy na pewno masz dostęp do Internetu! Jeżeli tak, skontaktuj się z producentem programu.");
        alert.showAndWait();

}
}
