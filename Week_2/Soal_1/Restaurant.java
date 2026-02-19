package Week_2.Soal_1;

public class Restaurant {
    // 1. Semua attribute bersifat private (Encapsulation)
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    // Constructor
    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    // 2. Akses data dilakukan melalui getter dan setter
    public String getNamaMakanan(int id) {
        return nama_makanan[id];
    }

    public void setNamaMakanan(int id, String nama) {
        this.nama_makanan[id] = nama;
    }

    public double getHargaMakanan(int id) {
        return harga_makanan[id];
    }

    public void setHargaMakanan(int id, double harga) {
        this.harga_makanan[id] = harga;
    }

    public int getStok(int id) {
        return stok[id];
    }

    // 3. Validasi stok (stok tidak boleh negatif)
    public void setStok(int id, int stok) {
        if (stok >= 0) {
            this.stok[id] = stok;
        } else {
            System.out.println("Error: Stok tidak boleh negatif!");
        }
    }

    // Method untuk menambah menu
    public void tambahMenuMakanan(String nama, double harga, int stok) {
        // Validasi awal saat input menu baru
        if (stok < 0) {
            System.out.println("Gagal menambah " + nama + ": Stok awal tidak boleh negatif.");
            return;
        }
        
        // Menggunakan setter agar tersimpan dengan aman
        setNamaMakanan(id, nama);
        setHargaMakanan(id, harga);
        setStok(id, stok);
        nextId(); // id dinaikkan secara otomatis dari dalam class
    }

    public void tampilMenuMakanan() {
        for (int i = 0; i < id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(
                    getNamaMakanan(i) + " [" + getStok(i) + "]" + "\tRp. " + getHargaMakanan(i)
                );
            }
        }
    }

    public boolean isOutOfStock(int id) {
        return getStok(id) == 0;
    }

    // Method dibuat private karena hanya dipakai secara internal
    private static void nextId() {
        id++;
    }

    // 4. Pengembangan Fitur: Pemesanan menu
    public void pesanMenu(String nama, int jumlahPesanan) {
        if (jumlahPesanan <= 0) {
            System.out.println("Jumlah pesanan tidak valid.");
            return;
        }

        boolean menuDitemukan = false;

        for (int i = 0; i < id; i++) {
            // Mengabaikan huruf besar/kecil saat pencarian nama menu
            if (nama.equalsIgnoreCase(getNamaMakanan(i))) {
                menuDitemukan = true;
                
                // Pesan ditolak jika stok tidak mencukupi
                if (getStok(i) >= jumlahPesanan) {
                    // Stok otomatis berkurang setelah pemesanan
                    setStok(i, getStok(i) - jumlahPesanan); 
                    System.out.println("Pesanan berhasil: " + jumlahPesanan + " porsi " + nama + ".");
                } else {
                    System.out.println("Pesanan ditolak: Stok " + nama + " tidak mencukupi. Sisa stok: " + getStok(i));
                }
                break; // Hentikan pencarian jika menu sudah ketemu
            }
        }

        if (!menuDitemukan) {
            System.out.println("Pesanan ditolak: Menu '" + nama + "' tidak ditemukan.");
        }
    }
}