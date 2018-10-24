package Dialogs;

import javafx.scene.control.Alert;

public class SubjectMissingAlert {

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Brak tematu!");
        alert.setHeaderText("Temat rozmowy nie został wybrany!");
        alert.setContentText("Wróć do formularza i wybierz odpowiedni temat.");
        alert.showAndWait();
    }
}
