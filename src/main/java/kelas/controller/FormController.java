package kelas.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

/** Controller form tambah produk. */
public final class FormController {
    @FXML private TextField kodeField;
    @FXML private TextField namaField;
    @FXML private ComboBox<String> kategoriBox;
    @FXML private TextField hargaField;
    @FXML private Label pesanLabel;
    private Navigator navigator;
    private DataProduk data;

    @FXML private void initialize() { kategoriBox.getItems().setAll("Makanan", "Minuman"); kategoriBox.setValue("Makanan"); }
    public void setKonteks(Navigator navigator, DataProduk data) { this.navigator = navigator; this.data = data; }
    @FXML private void simpan() {
        if (namaField.getText() == null || namaField.getText().isBlank()) { pesanLabel.setText("Nama produk wajib diisi."); return; }
        final double harga;
        try { harga = Double.parseDouble(hargaField.getText().trim()); }
        catch (NumberFormatException e) { pesanLabel.setText("Harga harus angka dan lebih dari 0."); return; }
        if (harga <= 0) { pesanLabel.setText("Harga harus lebih dari 0."); return; }
        try {
            Produk produk = new Produk(kodeField.getText(), namaField.getText(), kategoriBox.getValue(), harga);
            data.tambah(produk);
            navigator.bukaDetail(produk);
        } catch (IllegalArgumentException | IOException e) { pesanLabel.setText(e.getMessage()); }
    }
    @FXML private void bukaDaftar() { try { navigator.bukaDaftar(); } catch (IOException e) { pesanLabel.setText("Daftar gagal dibuka."); } }
}
