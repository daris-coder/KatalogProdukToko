package kelas.controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

/** Controller halaman daftar produk untuk FXML/Scene Builder. */
public final class DaftarController {
    @FXML private TableView<Produk> tabel;
    @FXML private TableColumn<Produk, String> kodeCol;
    @FXML private TableColumn<Produk, String> namaCol;
    @FXML private TableColumn<Produk, String> kategoriCol;
    @FXML private TableColumn<Produk, Double> hargaCol;
    @FXML private TextField cariField;
    @FXML private Label pesanLabel;
    private Navigator navigator;
    private DataProduk data;
    private final ObservableList<Produk> tampilan = FXCollections.observableArrayList();

    @FXML private void initialize() {
        kodeCol.setCellValueFactory(new PropertyValueFactory<>("kode"));
        namaCol.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kategoriCol.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        hargaCol.setCellValueFactory(new PropertyValueFactory<>("harga"));
        hargaCol.setCellFactory(kolom -> new javafx.scene.control.TableCell<>() {
            @Override protected void updateItem(Double nilai, boolean kosong) {
                super.updateItem(nilai, kosong);
                setText(kosong || nilai == null ? null : NumberFormat.getCurrencyInstance(new Locale("id", "ID")).format(nilai));
            }
        });
        tabel.setItems(tampilan);
        tabel.setPlaceholder(new Label("Belum ada produk."));
    }
    public void setKonteks(Navigator navigator, DataProduk data) { this.navigator = navigator; this.data = data; cari(); }
    @FXML private void cari() {
        if (data == null) return;
        String kata = cariField.getText().trim().toLowerCase(Locale.ROOT);
        tampilan.setAll(data.getDaftar().stream().filter(p -> p.getNama().toLowerCase(Locale.ROOT).contains(kata)).toList());
        pesanLabel.setText("Produk tampil: " + tampilan.size());
    }
    @FXML private void tambah() { try { navigator.bukaForm(); } catch (IOException e) { pesanLabel.setText("Form gagal dibuka."); } }
    @FXML private void detail() {
        Produk produk = tabel.getSelectionModel().getSelectedItem();
        if (produk == null) { pesanLabel.setText("Pilih satu produk terlebih dahulu."); return; }
        try { navigator.bukaDetail(produk); } catch (IOException e) { pesanLabel.setText("Detail gagal dibuka."); }
    }
}
