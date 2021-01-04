package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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

    @FXML
    public Label feedbackLabel;

    /*Exits the Window and the entire application*/
    public void cancel() {  
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void loginUser() {
        if (!usernameTF.getText().isEmpty() && !passwordTF.getText().isEmpty()) {
            validateLogin(usernameTF.getText(), passwordTF.getText());
        } else {    
            feedbackLabel.setText("Please Fill in all the Blanks");
        }
    }

    public void validateLogin(String username, String password) {
        Database myDatabase = new Database();
        Connection connection = myDatabase.getConnection();

        String verificationSQL = "SELECT COUNT(1) FROM members WHERE\n" +
                "username = '" + username + "' AND \n" +
                "password = '" + password + "';";

        try {
            Statement statement = connection.createStatement();
            ResultSet querySet = statement.executeQuery(verificationSQL);

            while (querySet.next()) {
                if (querySet.getInt(1) == 1) {
                    feedbackLabel.setTextFill(Paint.valueOf("#00FF00"));
                    feedbackLabel.setText("Successfully Logged In");
                } else {
                    feedbackLabel.setTextFill(Paint.valueOf("#FF0000"));
                    feedbackLabel.setText("Incorrect Username or Password");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openRegister() {

    }
}
