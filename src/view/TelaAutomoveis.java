package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaAutomoveis extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VE/tela_automoveis.fxml"));
        Scene cena = new Scene(root);

        stage.setTitle("Clientes");
        stage.setScene(cena);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
