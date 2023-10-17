package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aplicacao extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        Label msg = new Label();
        Button botao = new Button("ok");
        msg.setText("Famoso Hello world em JavaFX");
        HBox root = new HBox();
        VBox root2 = new VBox();
        root.getChildren().add(msg);
        root.getChildren().add(botao);

        Scene cena = new Scene(root, 500, 300);
        stage.setTitle("title");
        stage.setScene(cena);
        stage.show();
    }

    public static void main(String args[]) {
        launch();
    }
}
