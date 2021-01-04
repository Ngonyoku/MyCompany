package sample;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ScreenManager {

    public void startController(Stage window, String destination) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(destination));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
        window.close();
    }

    public void startController(String destination) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(destination));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void exitWindow(Stage stage, String title, String message) {
        Stage dialogBox = new Stage();
        Label label = new Label();

        dialogBox.initModality(Modality.APPLICATION_MODAL); //User interaction with other windows is not allowed
        dialogBox.setTitle(title);
        dialogBox.setMaxWidth(250);

        label.setText(message);
        Button positive = new Button("YES");
        positive.setOnAction(
                event -> {
                    dialogBox.close();
                    stage.close();
                }
        );

        Button negative = new Button("NO");
        negative.setOnAction(event -> dialogBox.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, positive, negative);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 200);

        dialogBox.setScene(scene);
        dialogBox.showAndWait();
    }
}
