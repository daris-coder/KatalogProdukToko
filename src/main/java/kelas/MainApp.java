package kelas;

import javafx.application.Application;
import javafx.stage.Stage;
import kelas.data.DataProduk;

/** Titik masuk aplikasi JavaFX; tampilan FXML dapat diedit di Scene Builder. */
public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        new Navigator(stage, new DataProduk()).bukaDaftar();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
