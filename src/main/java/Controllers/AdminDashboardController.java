package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class AdminDashboardController {
    @FXML
    private Label adminNameLabel;

    public void initialize() {
        String name="Bienvenue Admin";
        adminNameLabel.setText(name);
    }

    public void goToNavigate(ActionEvent actionEvent) {
        RouterController.navigate("/fxml/AdminDashboard.fxml");
    }




    public void goToLogn(MouseEvent mouseEvent) {
    }

    public void goToDossiers(MouseEvent mouseEvent) {
        RouterController.navigate("/fxml/DossiersReclamationsCrud.fxml");
    }
}
