package kelas;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kelas.controller.DaftarController;
import kelas.controller.DetailController;
import kelas.controller.FormController;
import kelas.data.DataProduk;
import kelas.model.Produk;

/** Memuat halaman FXML yang dapat dibuka di Scene Builder. */
public final class Navigator {
    private final Stage stage;
    private final DataProduk data;
    private Scene scene;

    public Navigator(Stage stage, DataProduk data) { this.stage = stage; this.data = data; }
    private FXMLLoader loader(String halaman) { return new FXMLLoader(getClass().getResource("/kelas/" + halaman + ".fxml")); }
    private void tampil(Parent root) {
        if (scene == null) {
            scene = new Scene(root, 880, 560);
            scene.getStylesheets().add(getClass().getResource("/kelas/styles/app.css").toExternalForm());
            stage.setScene(scene); stage.setTitle("Katalog Produk Toko"); stage.setMinWidth(640); stage.setMinHeight(450);
        } else scene.setRoot(root);
        stage.show();
    }
    public void bukaForm() throws IOException { FXMLLoader l = loader("form"); Parent root = l.load(); l.<FormController>getController().setKonteks(this, data); tampil(root); }
    public void bukaDaftar() throws IOException { FXMLLoader l = loader("daftar"); Parent root = l.load(); l.<DaftarController>getController().setKonteks(this, data); tampil(root); }
    /** Produk terpilih dikirim langsung sebagai objek ke controller detail. */
    public void bukaDetail(Produk produk) throws IOException { FXMLLoader l = loader("detail"); Parent root = l.load(); l.<DetailController>getController().setData(this, produk); tampil(root); }
}
