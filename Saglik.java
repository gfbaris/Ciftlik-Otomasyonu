import java.util.ArrayList;

public class Saglik {

    public static ArrayList<Integer> asiIdListesi = new ArrayList<>();
    public static ArrayList<String> asiAdiListesi = new ArrayList<>();
    public static ArrayList<Integer> asiYiliListesi = new ArrayList<>();

    public static ArrayList<Integer> tedaviIdListesi = new ArrayList<>();
    public static ArrayList<String> tedaviAdiListesi = new ArrayList<>();
    public static ArrayList<String> veterinerAdiListesi = new ArrayList<>();
    public static ArrayList<String> tedaviTarihiListesi = new ArrayList<>();

    public static void saglikMenusu() {
        System.out.println("--- SAĞLIK MENÜSÜ ---");
        System.out.println("1. Aşı Kaydı");
        System.out.println("2. Tedavi Kayıtları");
        System.out.println("3. Raporlama");
        System.out.println("4. Ana Menüye Dön");
        System.out.print("Bir seçenek seçin: ");
        int secim = Util.readInt();

        switch (secim) {
            case 1:
                asiKaydi();
                break;
            case 2:
                tedaviKaydi();
                break;
            case 3:
                raporlama();
                break;
            case 4:
                break;
            default:
                Util.EkranYokEtme();
                System.out.println("Geçersiz Seçim");
                saglikMenusu();
                break;
        }
    }

    private static void asiKaydi() {
        System.out.println("Aşı Kaydı Girmek İstediğiniz Hayvan Türünü Seçiniz");
        System.out.println("1) Büyükbaş Hayvan 2) Küçükbaş Hayvan 3) Kümes Hayvanları");
        int sonuc = Util.readInt();
        ArrayList<Integer> idListesi = null;

        switch (sonuc) {
            case 1:
                idListesi = Hayvanlar.buyukbasHayvanIdListesi;
                break;
            case 2:
                idListesi = Hayvanlar.kucukbasHayvanIdListesi;
                break;
            case 3:
                idListesi = Hayvanlar.kumesHayvanIdListesi;
                break;
            default:
                Util.EkranYokEtme();
                System.out.println("Geçersiz Seçim");
                asiKaydi();
                return;
        }

        System.out.println("Aşı Kaydı Girmek İstediğiniz Hayvanın ID'sini Giriniz :");
        int aranan = Util.readInt();
        if (idListesi.contains(aranan)) {
            asiIdListesi.add(aranan);

            System.out.println("Aşı İsmi :");
            String asiAdi = Util.readString();
            asiAdiListesi.add(asiAdi);

            System.out.println("Aşı Yılı :");
            int asiYili = Util.readInt();
            asiYiliListesi.add(asiYili);

            System.out.println("Bilgiler Başarıyla Eklenmiştir.");
        } else {
            System.out.println("Girilen ID ile Eşleşen Hayvan Bulunamadı");
        }
        saglikMenusu();
    }

    private static void tedaviKaydi() {
        System.out.println("Tedavi Kaydı Girmek İstediğiniz Hayvan Türünü Seçiniz");
        System.out.println("1) Büyükbaş Hayvan 2) Küçükbaş Hayvan 3) Kümes Hayvanları");
        int kayit = Util.readInt();
        ArrayList<Integer> idListesi = null;

        switch (kayit) {
            case 1:
                idListesi = Hayvanlar.buyukbasHayvanIdListesi;
                break;
            case 2:
                idListesi = Hayvanlar.kucukbasHayvanIdListesi;
                break;
            case 3:
                idListesi = Hayvanlar.kumesHayvanIdListesi;
                break;
            default:
                Util.EkranYokEtme();
                System.out.println("Geçersiz Seçim");
                tedaviKaydi();
                return;
        }

        System.out.println("Tedavi Kaydı Girmek İstediğiniz Hayvanın ID'sini Giriniz :");
        int aranan = Util.readInt();
        if (idListesi.contains(aranan)) {
            tedaviIdListesi.add(aranan);

            System.out.println("Tedavi İsmi :");
            String tedaviAdi = Util.readString();
            tedaviAdiListesi.add(tedaviAdi);

            System.out.println("Veteriner İsmi :");
            String veterinerAdi = Util.readString();
            veterinerAdiListesi.add(veterinerAdi);

            System.out.println("Tedavi Tarihi (GG-AA-YYYY) :");
            String tedaviTarihi = Util.readString();
            tedaviTarihiListesi.add(tedaviTarihi);

            System.out.println("Bilgiler Başarıyla Eklenmiştir.");
        } else {
            System.out.println("Girilen ID ile Eşleşen Hayvan Bulunamadı");
        }
        saglikMenusu();
    }

    private static void raporlama() {
        System.out.println("Raporlama İçin Hayvan ID'sini Giriniz:");
        int aranan = Util.readInt();

        System.out.println("1. Aşı Kayıtlarını Görüntüle");
        System.out.println("2. Tedavi Kayıtlarını Görüntüle");
        System.out.println("3. Tüm Kayıtları Görüntüle");
        int raporSecim = Util.readInt();

        switch (raporSecim) {
            case 1:
                System.out.println("--- AŞI KAYITLARI ---");
                for (int i = 0; i < asiIdListesi.size(); i++) {
                    if (asiIdListesi.get(i) == aranan) {
                        System.out.println("Aşı: " + asiAdiListesi.get(i) + " | Yıl: " + asiYiliListesi.get(i));
                    }
                }
                break;

            case 2:
                System.out.println("--- TEDAVİ KAYITLARI ---");
                for (int i = 0; i < tedaviIdListesi.size(); i++) {
                    if (tedaviIdListesi.get(i) == aranan) {
                        System.out.println("Tedavi: " + tedaviAdiListesi.get(i) + " | Veteriner: " + veterinerAdiListesi.get(i) + " | Tarih: " + tedaviTarihiListesi.get(i));
                    }
                }
                break;

            case 3:
                System.out.println("--- AŞI KAYITLARI ---");
                for (int i = 0; i < asiIdListesi.size(); i++) {
                    if (asiIdListesi.get(i) == aranan) {
                        System.out.println("Aşı: " + asiAdiListesi.get(i) + " | Yıl: " + asiYiliListesi.get(i));
                    }
                }
                System.out.println("\n--- TEDAVİ KAYITLARI ---");
                for (int i = 0; i < tedaviIdListesi.size(); i++) {
                    if (tedaviIdListesi.get(i) == aranan) {
                        System.out.println("Tedavi: " + tedaviAdiListesi.get(i) + " | Veteriner: " + veterinerAdiListesi.get(i) + " | Tarih: " + tedaviTarihiListesi.get(i));
                    }
                }
                break;

            default:
                System.out.println("Geçersiz Seçim");
                break;
        }

        saglikMenusu();
    }
}