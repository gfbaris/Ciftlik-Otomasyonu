import java.util.ArrayList;

public class Finans {

    
    private static ArrayList<HayvanIslem> hayvanIslemleri = new ArrayList<>();
    private static ArrayList<Yem> yemler = new ArrayList<>();
    private static ArrayList<SaglikGideri> saglikGiderleri = new ArrayList<>();
    private static ArrayList<Gelir> gelirler = new ArrayList<>();

    public static void finansMenusu() {
        System.out.println("--- FİNANS MENÜSÜ ---");
        System.out.println("1. Giderleri Yönet");
        System.out.println("2. Gelirleri Yönet");
        System.out.println("3. Kar-Zarar Hesapla");
        System.out.println("4. Ana Menüye Dön");
        System.out.print("Bir seçenek seçin: ");
        int secim = Util.readInt();

        switch (secim) {
            case 1:
                giderleriYonet();
                break;
            case 2:
                gelirleriYonet();
                break;
            case 3:
                karZararHesapla();
                break;
            case 4:
            
                break;
            default:
                System.out.println("Geçersiz Seçim");
                finansMenusu();
                break;
        }
    }

 
    private static void giderleriYonet() {
        System.out.println("--- GİDERLERİ YÖNET ---");
        System.out.println("1. Hayvan Alım/Satım Gideri Ekle");
        System.out.println("2. Yem Gideri Ekle");
        System.out.println("3. Sağlık Gideri Ekle");
        System.out.print("Bir seçenek seçin: ");
        int secim = Util.readInt();

        switch (secim) {
            case 1:
                hayvanGideriEkle();
                break;
            case 2:
                yemGideriEkle();
                break;
            case 3:
                saglikGideriEkle();
                break;
            default:
                System.out.println("Geçersiz Seçim");
                giderleriYonet();
                break;
        }
        System.out.println("Gider başarıyla eklendi.");
        finansMenusu();
    }

    private static void hayvanGideriEkle() {
        System.out.println("--- HAYVAN ALIM/SATIM GİDERİ EKLE ---");
        System.out.print("Hayvan Türü (Büyükbaş/Küçükbaş/Kümes): ");
        String tur = Util.readString();
        System.out.print("Hayvan ID: ");
        int id = Util.readInt();
        System.out.print("Alım/Tarım Tarihi (YYYY-MM-DD): ");
        String tarih = Util.readString();
        System.out.print("Miktar: ");
        int miktar = Util.readInt();
        System.out.print("Birim Fiyat: ");
        double birimFiyat = Util.readDouble();
        System.out.print("Toplam Fiyat: ");
        double toplamFiyat = Util.readDouble();

        hayvanIslemleri.add(new HayvanIslem(tur, id, tarih, miktar, birimFiyat, toplamFiyat));
    }


    private static void yemGideriEkle() {
        System.out.println("--- YEM GİDERİ EKLE ---");
        System.out.print("Yem Adı: ");
        String yemAdi = Util.readString();
        System.out.print("Yem Fiyatı: ");
        double yemFiyati = Util.readDouble();

        yemler.add(new Yem(yemAdi, yemFiyati));
    }

    private static void saglikGideriEkle() {
        System.out.println("--- SAĞLIK GİDERİ EKLE ---");
        System.out.print("Aşı/Tedavi İsmi: ");
        String isim = Util.readString();
        System.out.print("Ücret: ");
        double ucret = Util.readDouble();

        saglikGiderleri.add(new SaglikGideri(isim, ucret));
    }

    private static void gelirleriYonet() {
        System.out.println("--- GELİRLERİ YÖNET ---");
        System.out.println("1. Hayvan Satış Geliri Ekle");
        System.out.println("2. Süt Satış Geliri Ekle");
        System.out.println("3. Yumurta Satış Geliri Ekle");
        System.out.println("4. Diğer Ürün Satış Geliri Ekle");
        System.out.print("Bir seçenek seçin: ");
        int secim = Util.readInt();

        switch (secim) {
            case 1:
                hayvanGeliriEkle();
                break;
            case 2:
                sutGeliriEkle();
                break;
            case 3:
                yumurtaGeliriEkle();
                break;
            case 4:
                digerUrunGeliriEkle();
                break;
            default:
                System.out.println("Geçersiz Seçim");
                gelirleriYonet();
                break;
        }
        System.out.println("Gelir başarıyla eklendi.");
        finansMenusu();
    }

    private static void hayvanGeliriEkle() {
        System.out.println("--- HAYVAN SATIŞ GELİRİ EKLE ---");
        System.out.print("Hayvan Türü (Büyükbaş/Küçükbaş/Kümes): ");
        String tur = Util.readString();
        System.out.print("Hayvan ID: ");
        int id = Util.readInt();
        System.out.print("Satış Tarihi (YYYY-MM-DD): ");
        String tarih = Util.readString();
        System.out.print("Miktar: ");
        int miktar = Util.readInt();
        System.out.print("Birim Fiyat: ");
        double birimFiyat = Util.readDouble();
        System.out.print("Toplam Gelir: ");
        double toplamGelir = Util.readDouble();

        gelirler.add(new Gelir("Hayvan Satış", tur, id, tarih, miktar, birimFiyat, toplamGelir));
    }

    private static void sutGeliriEkle() {
        System.out.println("--- SÜT SATIŞ GELİRİ EKLE ---");
        System.out.print("Süt Miktarı (litre): ");
        double miktar = Util.readDouble();
        System.out.print("Birim Fiyat: ");
        double birimFiyat = Util.readDouble();
        System.out.print("Toplam Gelir: ");
        double toplamGelir = Util.readDouble();

        gelirler.add(new Gelir("Süt Satış", "Süt", 0, "", (int) miktar, birimFiyat, toplamGelir));
    }

    private static void yumurtaGeliriEkle() {
        System.out.println("--- YUMURTA SATIŞ GELİRİ EKLE ---");
        System.out.print("Yumurta Miktarı (adet): ");
        int miktar = Util.readInt();
        System.out.print("Birim Fiyat: ");
        double birimFiyat = Util.readDouble();
        System.out.print("Toplam Gelir: ");
        double toplamGelir = Util.readDouble();

        gelirler.add(new Gelir("Yumurta Satış", "Yumurta", 0, "", miktar, birimFiyat, toplamGelir));
    }

    private static void digerUrunGeliriEkle() {
        System.out.println("--- DİĞER ÜRÜN SATIŞ GELİRİ EKLE ---");
        System.out.print("Ürün Adı: ");
        String urunAdi = Util.readString();
        System.out.print("Ürün Miktarı: ");
        double miktar = Util.readDouble();
        System.out.print("Birim Fiyat: ");
        double birimFiyat = Util.readDouble();
        System.out.print("Toplam Gelir: ");
        double toplamGelir = Util.readDouble();

        gelirler.add(new Gelir("Diğer Ürün Satış", urunAdi, 0, "", (int) miktar, birimFiyat, toplamGelir));
    }

    private static void karZararHesapla() {
        double toplamGider = 0;
        double toplamGelir = 0;

        for (HayvanIslem islem : hayvanIslemleri) toplamGider += islem.getToplamFiyat();
        for (Yem yem : yemler) toplamGider += yem.getYemFiyati();
        for (SaglikGideri gider : saglikGiderleri) toplamGider += gider.getUcret();

        for (Gelir gelir : gelirler) toplamGelir += gelir.getToplamGelir();

        double netKarZarar = toplamGelir - toplamGider;
        System.out.printf("Toplam Gider: %.2f TL\n", toplamGider);
        System.out.printf("Toplam Gelir: %.2f TL\n", toplamGelir);
        System.out.printf("Net Kar/Zarar: %.2f TL\n", netKarZarar);

        finansMenusu();
    }
}
