package Week_2.Soal_1;

public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant();

        // Menambahkan menu makanan (Tidak perlu panggil nextId manual lagi)
        menu.tambahMenuMakanan("Pizza", 250000, 20);
        menu.tambahMenuMakanan("Spaghetti", 80000, 20);
        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30);
        menu.tambahMenuMakanan("Chicken Steak", 45000, 30);
        
        // Uji coba validasi: Input stok negatif (Harus memunculkan pesan error)
        menu.tambahMenuMakanan("Burger", 35000, -5); 

        System.out.println("\n=== DAFTAR MENU AWAL ===");
        menu.tampilMenuMakanan();

        System.out.println("\n=== SIMULASI PEMESANAN ===");
        // Skenario 1: Pemesanan sukses (stok cukup)
        menu.pesanMenu("Pizza", 5); 
        
        // Skenario 2: Pemesanan ditolak (stok tidak cukup)
        menu.pesanMenu("Spaghetti", 25); 
        
        // Skenario 3: Pemesanan ditolak (menu tidak terdaftar)
        menu.pesanMenu("Nasi Goreng", 2); 

        System.out.println("\n=== DAFTAR MENU SETELAH PEMESANAN ===");
        // Menampilkan sisa stok (Stok Pizza harusnya sisa 15)
        menu.tampilMenuMakanan();
    }
}