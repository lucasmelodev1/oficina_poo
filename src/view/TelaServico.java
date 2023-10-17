package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaServico extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VE/tela_servico.fxml"));
        Scene cena = new Scene(root);

        stage.setTitle("Serviços");
        stage.setScene(cena);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

