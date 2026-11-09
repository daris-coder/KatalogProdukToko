package kelas.model;

/** Model produk dengan seluruh properti bersifat private. */
public final class Produk {
    private final String kode;
    private final String nama;
    private final String kategori;
    private final double harga;

    public Produk(String kode, String nama, String kategori, double harga) {
        if (kode == null || kode.isBlank()) throw new IllegalArgumentException("Kode produk wajib diisi.");
        if (nama == null || nama.isBlank()) throw new IllegalArgumentException("Nama produk wajib diisi.");
        if (!"Makanan".equals(kategori) && !"Minuman".equals(kategori)) throw new IllegalArgumentException("Kategori harus Makanan atau Minuman.");
        if (!Double.isFinite(harga) || harga <= 0) throw new IllegalArgumentException("Harga harus lebih dari 0.");
        this.kode = kode.trim();
        this.nama = nama.trim();
        this.kategori = kategori;
        this.harga = harga;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public String getKategori() { return kategori; }
    public double getHarga() { return harga; }
}
