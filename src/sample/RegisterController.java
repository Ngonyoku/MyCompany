package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterController extends ScreenManager {
    @FXML
    public BorderPane borderPane;

    @FXML
    public TextField firstNameTF;

    @FXML
    public TextField lastNameTF;

    @FXML
    public Label feedbackLabel;

    @FXML
    public TextField userNameTF;

    @FXML
    public TextField passwordTF;

    @FXML
    public TextField confirmPasswordTF;

    @FXML
    public Button cancelBtn;

    @FXML
    public Button loginBtn;


    public void cancel() {
        exitWindow((Stage) borderPane.getScene().getWindow(), "Exit Application", "Are you sure you want to exit the application");
    }

    public void openLogIn() throws IOException {
        startController((Stage) loginBtn.getScene().getWindow(), "login.fxml");
    }

    public void createAccount() {
        if (!firstNameTF.getText().isEmpty() && !lastNameTF.getText().isEmpty() && !userNameTF.getText().isEmpty() && !passwordTF.getText().isEmpty() && !confirmPasswordTF.getText().isEmpty()) {
            if (passwordTF.getText().equals(confirmPasswordTF.getText())) {
                feedbackLabel.setText(null);
                registerUser(firstNameTF.getText(), lastNameTF.getText(), userNameTF.getText(), passwordTF.getText());
            } else {
                feedbackLabel.setText("Passwords don't match");
            }
        } else {
            feedbackLabel.setText("Please Fill in all the Fields");
        }
    }

    private void registerUser(String firstName, String lastName, String username, String password) {
        Database myDatabase = new Database();
        Connection connection = myDatabase.getConnection();

        String insertUserSQL = "INSERT INTO members(first_name,last_name,username,password)\n" +
                "VALUES('" + firstName + "','" + lastName + "','" + username + "','" + password + "');";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertUserSQL);
            feedbackLabel.setTextFill(Paint.valueOf("#00FF00"));
            feedbackLabel.setText("User has been Successfully Registered");

            openLogIn();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
