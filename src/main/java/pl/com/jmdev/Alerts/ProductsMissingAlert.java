package pl.com.jmdev.Alerts;

import javafx.scene.control.Alert;

public class ProductsMissingAlert {

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Brak produktów!");
        alert.setHeaderText("Żaden produkt/usługa nie został wybrany!");
        alert.setContentText("Wróć do formularza i wybierz odpowiednie produkty.");
        alert.showAndWait();
    }

}
