package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/*
 * This is the controller class for the login.fxml file
 * */
public class LoginController {
    @FXML
    public Button loginBtn;

    @FXML
    public Button cancelBtn;

    @FXML
    public TextField usernameTF;

    @FXML
    public TextField passwordTF;

    /*Exits the Window and the entire application*/
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void loginUser() {

    }

    public void openRegister() {

    }
}
