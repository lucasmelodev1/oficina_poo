package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaLogin extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VE/tela_login.fxml"));
        Scene cena = new Scene(root);

        stage.setTitle("Login");
        stage.setScene(cena);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
