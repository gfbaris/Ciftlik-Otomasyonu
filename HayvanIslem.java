public class HayvanIslem {
    private String tur;
    private int id;
    private String tarih;
    private int miktar;
    private double birimFiyat;
    private double toplamFiyat;

    public HayvanIslem(String tur, int id, String tarih, int miktar, double birimFiyat, double toplamFiyat) {
        this.tur = tur;
        this.id = id;
        this.tarih = tarih;
        this.miktar = miktar;
        this.birimFiyat = birimFiyat;
        this.toplamFiyat = toplamFiyat;
    }

    public double getToplamFiyat() {
        return toplamFiyat;
    }
}
