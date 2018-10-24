package Dialogs;

import javafx.scene.control.Alert;


public class CustomerInfoMissingAlert {

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Dane kontaktowe niekompletne!");
        alert.setHeaderText("Brakuje danych kontaktowych Klienta!");
        alert.setContentText("Wróć do formularza i sprawdź puste pola w danych Klienta.");
        alert.showAndWait();
    }
}
