package sample;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.Scene;

public class AlertDialog {

    public static void show(Stage stage, String title, String message) {
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
                    Platform.exit();
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
