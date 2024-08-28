public class Gelir {
    private String gelirTuru;
    private String urunAdi;
    private int id;
    private String tarih;
    private int miktar;
    private double birimFiyat;
    private double toplamGelir;

    public Gelir(String gelirTuru, String urunAdi, int id, String tarih, int miktar, double birimFiyat, double toplamGelir) {
        this.gelirTuru = gelirTuru;
        this.urunAdi = urunAdi;
        this.id = id;
        this.tarih = tarih;
        this.miktar = miktar;
        this.birimFiyat = birimFiyat;
        this.toplamGelir = toplamGelir;
    }

    public double getToplamGelir() {
        return toplamGelir;
    }
}
