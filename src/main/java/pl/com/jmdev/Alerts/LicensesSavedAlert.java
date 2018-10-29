package pl.com.jmdev.Alerts;

import javafx.scene.control.Alert;

public class LicensesSavedAlert {

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Licencja zapisana");
        alert.setHeaderText("Licencja została zapisana w pamieci programu.");
        alert.setContentText("Uruchom ponownie program, aby zweryfikować poprawność kluczy.");
        alert.showAndWait();
    }

}
