package kelas.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kelas.model.Produk;

/** Penyimpanan sementara selama aplikasi berjalan (tanpa database). */
public final class DataProduk {
    private final List<Produk> daftar = new ArrayList<>();

    public void tambah(Produk produk) {
        if (produk == null) throw new IllegalArgumentException("Produk tidak boleh kosong.");
        daftar.add(produk);
    }

    public List<Produk> getDaftar() { return Collections.unmodifiableList(daftar); }
}
