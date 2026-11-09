package kelas.controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import kelas.Navigator;
import kelas.model.Produk;

/** Menerima objek Produk yang dipilih dan menampilkan propertinya. */
public final class DetailController {
    @FXML private Label kodeLabel;
    @FXML private Label namaLabel;
    @FXML private Label kategoriLabel;
    @FXML private Label hargaLabel;
    @FXML private Label pesanLabel;
    private Navigator navigator;
    public void setData(Navigator navigator, Produk produk) {
        this.navigator = navigator;
        kodeLabel.setText(produk.getKode()); namaLabel.setText(produk.getNama()); kategoriLabel.setText(produk.getKategori());
        hargaLabel.setText(NumberFormat.getCurrencyInstance(new Locale("id", "ID")).format(produk.getHarga()));
    }
    @FXML private void bukaDaftar() { try { navigator.bukaDaftar(); } catch (IOException e) { pesanLabel.setText("Daftar gagal dibuka."); } }
    @FXML private void tambahLagi() { try { navigator.bukaForm(); } catch (IOException e) { pesanLabel.setText("Form gagal dibuka."); } }
}
