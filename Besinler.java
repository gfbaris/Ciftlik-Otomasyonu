import java.util.ArrayList;
import java.io.*;

public class Besinler {

    public static ArrayList<String> yemİsimListesi = new ArrayList<>();
    public static ArrayList<Integer> yemMiktarListesi = new ArrayList<>();
    public static ArrayList<Integer> yemKoduListesi = new ArrayList<>();

    public static ArrayList<String> buyukbasYemBilgisiListesi = new ArrayList<>();
    public static ArrayList<Integer> buyukbasYemMiktarBilgisiListesi = new ArrayList<>();

    public static ArrayList<String> kucukbasYemBilgisiListesi = new ArrayList<>();
    public static ArrayList<Integer> kucukbasYemMiktarBilgisiListesi = new ArrayList<>();

    public static ArrayList<String> kumesYemBilgisiListesi = new ArrayList<>();
    public static ArrayList<Integer> kumesYemMiktarBilgisiListesi = new ArrayList<>();


    public static void besinMenusu() {
        System.out.println("--- BESINLER MENUSU ---");
        System.out.println("[1] Yeni Yem Ekleme");
        System.out.println("[2] Yem Bilgilerini Düzenleme");
        System.out.println("[3] Yem Dağıtımı");
        System.out.println("[4] Yem Dağıtımı Güncelleme");
        System.out.println("[5] Yem Raporlama");
        System.out.println("[6] Menü");

        System.out.println("Yapacağınız İşlemi Seçiniz :");
        int secim = Util.readInt();

        switch (secim) {
            case 1:
                Util.EkranYokEtme();
                yeniYemEkle();
                break;
            case 2:
                Util.EkranYokEtme();
                yemBilgileriDuzenle();
                break;
            case 3:
                Util.EkranYokEtme();
                yemDagitimi();
                break;
            case 4:
                Util.EkranYokEtme();
                yemDagitimiGuncelle();
                break;
            case 5:
                Util.EkranYokEtme();
                yemRaporla();
                break;
            case 6:
                Util.EkranYokEtme();
                besinMenusu();
                break;
            default:
                System.out.println("Geçersiz seçim.");
                besinMenusu();
        }
    }


    private static void yeniYemEkle() {
       char devam;
        do {
            System.out.println("Yeni Yem İsmi:");
            String isim = Util.readString();
            yemİsimListesi.add(isim);
            int kod;
            do {
                System.out.println("Yeni Yem Kodu:");
                kod = Util.readInt();

                if(yemKoduListesi.contains(kod))
                {
                    System.out.println("Girdiğiniz Kod Zaten Mevcut.");
                }
                else
                {
                    yemKoduListesi.add(kod);
                    break;
                }
                
            } while (true);
      
            System.out.println("Miktar (kg):");
            int miktar = Util.readInt();
            yemMiktarListesi.add(miktar);

            try (FileWriter writer = new FileWriter("D:\\Çiftlik\\Besinler\\YemBilgileri.txt", true)) {
                writer.write("Yem İsim: " + isim + "\n");
                writer.write("Yem Kodu: " + kod + "\n");
                writer.write("Yem Miktar: " + miktar + "\n");
                writer.write("--------------------------\n");
                System.out.println("Bilgiler dosyaya başarıyla yazıldı.");
            } catch (IOException e) {
                System.out.println("Bilgiler dosyaya yazılırken bir hata oluştu: " + e.getMessage());
            }

    
            System.out.println("Yem Eklemeye Devam Etmek İçin 'e' veya 'E' giriniz.");
            System.out.println("Çıkmak İçin Herhangi Bir Harf Giriniz.");
            devam = Util.readChar();
        } while (devam == 'e' || devam == 'E');

    }

    private static void yemBilgileriDuzenle(){
        System.out.println("Düzenlemek İstediğiniz Yem Kodunu Giriniz :");
        int kod = Util.readInt();
        int index = -1;

        if(yemKoduListesi.contains(kod))
        {
            index = yemKoduListesi.indexOf(kod);

            System.out.println("Yemin Yeni İsmi :");
            String isim = Util.readString();
            yemİsimListesi.set(index, isim);

            System.out.println("Yemin Yeni Miktarı (kg):");
            int miktar = Util.readInt();
            yemMiktarListesi.set(index, miktar);

            try (FileWriter writer = new FileWriter("D:\\Çiftlik\\Besinler\\YemBilgileri.txt", false)) {
               for (int i = 0; i < yemKoduListesi.size(); i++) {
                writer.write("Yem İsim: " + yemİsimListesi.get(i) + "\n");
                writer.write("Yem Kodu: " + yemKoduListesi.get(i) + "\n");
                writer.write("Yem Miktar: " + yemMiktarListesi.get(i) + "\n");
                writer.write("--------------------------\n");
               }
                System.out.println("Bilgiler dosyaya başarıyla yazıldı.");
            } catch (IOException e) {
                System.out.println("Bilgiler dosyaya yazılırken bir hata oluştu: " + e.getMessage());
            }

        }
        else
        {
            Util.EkranYokEtme();
            System.out.println("Girdiğiniz Kod İle Eşleşen Yem Bulunamadı");
            besinMenusu();
        }
    }

    private static void yemDagitimi() {
        System.out.println("1) Büyükbaş Hayvanlar 2) Küçükbaş Hayvanlar 3) Kümes Hayvanları");
        System.out.println("Yem Bilgisini Girmek İstediğiniz Seçiminizi Yapınız");
        int secim = Util.readInt();
        int index = -1;
    
        switch (secim) {
            case 1:
                System.out.println("Yem Bilgisini Girmek İstediğiniz Büyükbaş Hayvanın ID'sini Giriniz.");
                int id = Util.readInt();
                if (Hayvanlar.buyukbasHayvanIdListesi.contains(id)) {
                    index = Hayvanlar.buyukbasHayvanIdListesi.indexOf(id);
                    System.out.println("Seçtiğiniz Hayvanın Yediği Yem İsmini Giriniz:");
                    String isim = Util.readString();
                    
                    if (index < buyukbasYemBilgisiListesi.size()) {
                        buyukbasYemBilgisiListesi.set(index, isim);
                    } else {
                        buyukbasYemBilgisiListesi.add(isim);
                    }
    
                    System.out.println("Yem Bilgisi Başarıyla Kaydedildi.");
    
                    System.out.println("Yem Miktarını Giriniz:");
                    int miktar = Util.readInt();
    
                    if (index < buyukbasYemMiktarBilgisiListesi.size()) {
                        buyukbasYemMiktarBilgisiListesi.set(index, miktar);
                    } else {
                        buyukbasYemMiktarBilgisiListesi.add(miktar);
                    }
    
                    System.out.println("Miktar Bilgisi Başarıyla Kaydedildi.");
    
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Çiftlik\\Besinler\\YemDagitimi.txt", true))) {
                        writer.write("Büyükbaş Hayvan ID: " + id + "\n");
                        writer.write("Yem İsmi: " + isim + "\n");
                        writer.write("Yem Miktarı: " + miktar + "\n");
                        writer.write("--------------------------\n");
                        System.out.println("Bilgiler dosyaya başarıyla yazıldı.");
                    } catch (IOException e) {
                        System.out.println("Bilgiler dosyaya yazılırken bir hata oluştu: " + e.getMessage());
                    }
                } else {
                    System.out.println("Girdiğiniz ID ile Eşleşen Hayvan Bulunamadı.");
                }
                break;
    
            case 2:

            System.out.println("Yem Bilgisini Girmek İstediğiniz Küçükbaş Hayvanın ID'sini Giriniz.");
            int id1 = Util.readInt();
            if (Hayvanlar.kucukbasHayvanIdListesi.contains(id1)) {
                index = Hayvanlar.kucukbasHayvanIdListesi.indexOf(id1);
                System.out.println("Seçtiğiniz Hayvanın Yediği Yem İsmini Giriniz:");
                String isim = Util.readString();
                
                if (index < kucukbasYemBilgisiListesi.size()) {
                    kucukbasYemBilgisiListesi.set(index, isim);
                } else {
                    kucukbasYemBilgisiListesi.add(isim);
                }

                System.out.println("Yem Bilgisi Başarıyla Kaydedildi.");

                System.out.println("Yem Miktarını Giriniz:");
                int miktar = Util.readInt();

                if (index < kucukbasYemMiktarBilgisiListesi.size()) {
                    kucukbasYemMiktarBilgisiListesi.set(index, miktar);
                } else {
                    kucukbasYemMiktarBilgisiListesi.add(miktar);
                }

                System.out.println("Miktar Bilgisi Başarıyla Kaydedildi.");

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Çiftlik\\Besinler\\YemDagitimi.txt", true))) {
                    writer.write("Büyükbaş Hayvan ID: " + id1 + "\n");
                    writer.write("Yem İsmi: " + isim + "\n");
                    writer.write("Yem Miktarı: " + miktar + "\n");
                    writer.write("--------------------------\n");
                    System.out.println("Bilgiler dosyaya başarıyla yazıldı.");
                } catch (IOException e) {
                    System.out.println("Bilgiler dosyaya yazılırken bir hata oluştu: " + e.getMessage());
                }
            } else {
                System.out.println("Girdiğiniz ID ile Eşleşen Hayvan Bulunamadı.");
            }

            break;
    
            case 3:
            System.out.println("Yem Bilgisini Girmek İstediğiniz Küçükbaş Hayvanın ID'sini Giriniz.");
            int id2 = Util.readInt();
            if (Hayvanlar.kumesHayvanIdListesi.contains(id2)) {
                index = Hayvanlar.kumesHayvanIdListesi.indexOf(id2);
                System.out.println("Seçtiğiniz Hayvanın Yediği Yem İsmini Giriniz:");
                String isim = Util.readString();
                
                if (index < kumesYemBilgisiListesi.size()) {
                    kumesYemBilgisiListesi.set(index, isim);
                } else {
                    kumesYemBilgisiListesi.add(isim);
                }

                System.out.println("Yem Bilgisi Başarıyla Kaydedildi.");

                System.out.println("Yem Miktarını Giriniz:");
                int miktar = Util.readInt();

                if (index < kumesYemMiktarBilgisiListesi.size()) {
                    kumesYemMiktarBilgisiListesi.set(index, miktar);
                } else {
                    kumesYemMiktarBilgisiListesi.add(miktar);
                }

                System.out.println("Miktar Bilgisi Başarıyla Kaydedildi.");

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Çiftlik\\Besinler\\YemDagitimi.txt", true))) {
                    writer.write("Büyükbaş Hayvan ID: " + id2 + "\n");
                    writer.write("Yem İsmi: " + isim + "\n");
                    writer.write("Yem Miktarı: " + miktar + "\n");
                    writer.write("--------------------------\n");
                    System.out.println("Bilgiler dosyaya başarıyla yazıldı.");
                } catch (IOException e) {
                    System.out.println("Bilgiler dosyaya yazılırken bir hata oluştu: " + e.getMessage());
                }
            } else {
                System.out.println("Girdiğiniz ID ile Eşleşen Hayvan Bulunamadı.");
            }

                break;
    
            default:
                System.out.println("Geçersiz Seçim.");
                break;
        }
    }

    private static void yemDagitimiGuncelle() {
        System.out.println("1) Büyükbaş Hayvanlar 2) Küçükbaş Hayvanlar 3) Kümes Hayvanları");
        System.out.println("Yem Bilgisini Güncellemek İstediğiniz Hayvan Türünü Seçiniz:");
        int secim = Util.readInt();
    
        switch (secim) {
            case 1:
                System.out.println("Yem Bilgisini Güncellemek İstediğiniz Büyükbaş Hayvanın ID'sini Giriniz.");
                int id = Util.readInt();
                if (Hayvanlar.buyukbasHayvanIdListesi.contains(id)) {
                    int index = Hayvanlar.buyukbasHayvanIdListesi.indexOf(id);
                    System.out.println("Yeni Yem İsmini Giriniz:");
                    String isim = Util.readString();
                    buyukbasYemBilgisiListesi.set(index, isim);
    
                    System.out.println("Yeni Yem Miktarını Giriniz:");
                    int miktar = Util.readInt();
                    buyukbasYemMiktarBilgisiListesi.set(index, miktar);
    
                    System.out.println("Bilgiler Başarıyla Güncellendi.");
                } else {
                    System.out.println("Girdiğiniz ID ile Eşleşen Hayvan Bulunamadı.");
                }
                break;
    
            case 2:
                System.out.println("Yem Bilgisini Güncellemek İstediğiniz Küçükbaş Hayvanın ID'sini Giriniz.");
                int id1 = Util.readInt();
                if (Hayvanlar.kucukbasHayvanIdListesi.contains(id1)) {
                    int index = Hayvanlar.kucukbasHayvanIdListesi.indexOf(id1);
                    System.out.println("Yeni Yem İsmini Giriniz:");
                    String isim = Util.readString();
                    kucukbasYemBilgisiListesi.set(index, isim);
    
                    System.out.println("Yeni Yem Miktarını Giriniz:");
                    int miktar = Util.readInt();
                    kucukbasYemMiktarBilgisiListesi.set(index, miktar);
    
                    System.out.println("Bilgiler Başarıyla Güncellendi.");
                } else {
                    System.out.println("Girdiğiniz ID ile Eşleşen Hayvan Bulunamadı.");
                }
                break;
    
            case 3:
                System.out.println("Yem Bilgisini Güncellemek İstediğiniz Kümes Hayvanının ID'sini Giriniz.");
                int id2 = Util.readInt();
                if (Hayvanlar.kumesHayvanIdListesi.contains(id2)) {
                    int index = Hayvanlar.kumesHayvanIdListesi.indexOf(id2);
                    System.out.println("Yeni Yem İsmini Giriniz:");
                    String isim = Util.readString();
                    kumesYemBilgisiListesi.set(index, isim);
    
                    System.out.println("Yeni Yem Miktarını Giriniz:");
                    int miktar = Util.readInt();
                    kumesYemMiktarBilgisiListesi.set(index, miktar);
    
                    System.out.println("Bilgiler Başarıyla Güncellendi.");
                } else {
                    System.out.println("Girdiğiniz ID ile Eşleşen Hayvan Bulunamadı.");
                }
                break;
    
            default:
                System.out.println("Geçersiz Seçim.");
                return;
        }
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Çiftlik\\Besinler\\YemDagitimi.txt", false))) {
            for (int i = 0; i < Hayvanlar.buyukbasHayvanIdListesi.size(); i++) {
                writer.write("Büyükbaş Hayvan ID: " + Hayvanlar.buyukbasHayvanIdListesi.get(i) + "\n");
                writer.write("Yem İsmi: " + buyukbasYemBilgisiListesi.get(i) + "\n");
                writer.write("Yem Miktarı: " + buyukbasYemMiktarBilgisiListesi.get(i) + "\n");
                writer.write("--------------------------\n");
            }
    
            for (int i = 0; i < Hayvanlar.kucukbasHayvanIdListesi.size(); i++) {
                writer.write("Küçükbaş Hayvan ID: " + Hayvanlar.kucukbasHayvanIdListesi.get(i) + "\n");
                writer.write("Yem İsmi: " + kucukbasYemBilgisiListesi.get(i) + "\n");
                writer.write("Yem Miktarı: " + kucukbasYemMiktarBilgisiListesi.get(i) + "\n");
                writer.write("--------------------------\n");
            }
    
            for (int i = 0; i < Hayvanlar.kumesHayvanIdListesi.size(); i++) {
                writer.write("Kümes Hayvan ID: " + Hayvanlar.kumesHayvanIdListesi.get(i) + "\n");
                writer.write("Yem İsmi: " + kumesYemBilgisiListesi.get(i) + "\n");
                writer.write("Yem Miktarı: " + kumesYemMiktarBilgisiListesi.get(i) + "\n");
                writer.write("--------------------------\n");
            }
            System.out.println("Bilgiler dosyaya başarıyla yazıldı.");
        } catch (IOException e) {
            System.out.println("Bilgiler dosyaya yazılırken bir hata oluştu: " + e.getMessage());
        }
    }

    private static void yemRaporla() {
        System.out.println("--- YEM RAPORLAMA ---");
        System.out.println("[1] Yem Miktar Raporu");
        System.out.println("[2] Hayvanlara Göre Yem Bilgisi");
        System.out.println("[3] Menüye Dön");
    
        System.out.println("Yapmak İstediğiniz Raporlama Türünü Seçiniz :");
        int secim = Util.readInt();
    
        switch (secim) {
            case 1:
                raporYemMiktar();
                break;
            case 2:
                raporHayvanYem();
                break;
            case 3:
                besinMenusu();
                break;
            default:
                System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                yemRaporla();
                break;
        }
    }
    
    private static void raporYemMiktar() {
        System.out.println("Yem Miktar Raporu:");
        
        System.out.println("Yem İsmi - Miktar (kg)");
        for (int i = 0; i < Besinler.yemİsimListesi.size(); i++) {
            System.out.println(Besinler.yemİsimListesi.get(i) + " - " + Besinler.yemMiktarListesi.get(i));
        }
    }
    
    private static void raporHayvanYem() {
        System.out.println("--- Hangi Tür Hayvanın Yem Tüketimi Raporunu Görmek İstersiniz? ---");
        System.out.println("[1] Büyükbaş Hayvanlar");
        System.out.println("[2] Küçükbaş Hayvanlar");
        System.out.println("[3] Kümes Hayvanları");
        System.out.println("[4] Menüye Dön");
    
        System.out.println("Seçiminizi Yapınız:");
        int secim = Util.readInt();
    
        switch (secim) {
            case 1:
                raporBuyukbasYem();
                break;
            case 2:
                raporKucukbasYem();
                break;
            case 3:
                raporKumesYem();
                break;
            case 4:
                yemRaporla();
                break;
            default:
                System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                raporHayvanYem();
                break;
        }
    }
    
    private static void raporBuyukbasYem() {
        System.out.println("Büyükbaş Hayvanlar için Yem Bilgisi:");
        for (int i = 0; i < Hayvanlar.buyukbasHayvanIdListesi.size(); i++) {
            int id = Hayvanlar.buyukbasHayvanIdListesi.get(i);
            String yem = Besinler.buyukbasYemBilgisiListesi.size() > i ? Besinler.buyukbasYemBilgisiListesi.get(i) : "Bilgi Yok";
            System.out.println("Büyükbaş Hayvan ID: " + id + " - Yediği Yem: " + yem);
        }
    }
    
    private static void raporKucukbasYem() {
        System.out.println("Küçükbaş Hayvanlar için Yem Bilgisi:");
        for (int i = 0; i < Hayvanlar.kucukbasHayvanIdListesi.size(); i++) {
            int id = Hayvanlar.kucukbasHayvanIdListesi.get(i);
            String yem = Besinler.kucukbasYemBilgisiListesi.size() > i ? Besinler.kucukbasYemBilgisiListesi.get(i) : "Bilgi Yok";
            System.out.println("Küçükbaş Hayvan ID: " + id + " - Yediği Yem: " + yem);
        }
    }
    
    private static void raporKumesYem() {
        System.out.println("Kümes Hayvanları için Yem Bilgisi:");
        for (int i = 0; i < Hayvanlar.kumesHayvanIdListesi.size(); i++) {
            int id = Hayvanlar.kumesHayvanIdListesi.get(i);
            String yem = Besinler.kumesYemBilgisiListesi.size() > i ? Besinler.kumesYemBilgisiListesi.get(i) : "Bilgi Yok";
            System.out.println("Kümes Hayvan ID: " + id + " - Yediği Yem: " + yem);
        }
    }

    public static void verileriYukle() {
    
        yukleYemBilgileri();
    
        yukleYemDagıtım();
    }
    
    private static void yukleYemBilgileri() {
        ArrayList<String> yemBilgileriVerileri = Util.textDosyaOku("D:\\Çiftlik\\Besinler\\YemBilgileri.txt");
    
        for (String satir : yemBilgileriVerileri) {
            if (satir.startsWith("Yem İsim: ")) {
                String isim = satir.substring(10).trim();
                yemİsimListesi.add(isim);
            } else if (satir.startsWith("Yem Kodu: ")) {
                int kod = Integer.parseInt(satir.substring(10).trim());
                yemKoduListesi.add(kod);
            } else if (satir.startsWith("Yem Miktar: ")) {
                int miktar = Integer.parseInt(satir.substring(12).trim());
                yemMiktarListesi.add(miktar);
            }
        }
    }
    
    private static void yukleYemDagıtım() {
        ArrayList<String> yemDagıtımVerileri = Util.textDosyaOku("D:\\Çiftlik\\Besinler\\YemDagıtım.txt");
    
        for (String satir : yemDagıtımVerileri) {
            if (satir.startsWith("Büyükbaş Hayvan ID: ")) {
                int id = Integer.parseInt(satir.substring(21).trim());
                Hayvanlar.buyukbasHayvanIdListesi.add(id);
            } else if (satir.startsWith("Küçükbaş Hayvan ID: ")) {
                int id = Integer.parseInt(satir.substring(21).trim());
                Hayvanlar.kucukbasHayvanIdListesi.add(id);
            } else if (satir.startsWith("Kümes Hayvan ID: ")) {
                int id = Integer.parseInt(satir.substring(16).trim());
                Hayvanlar.kumesHayvanIdListesi.add(id);
            } else if (satir.startsWith("Yem İsim: ")) {
                String isim = satir.substring(10).trim();
                yemİsimListesi.add(isim);
            } else if (satir.startsWith("Yem Kodu: ")) {
                int kod = Integer.parseInt(satir.substring(10).trim());
                yemKoduListesi.add(kod);
            } else if (satir.startsWith("Yem Miktar: ")) {
                int miktar = Integer.parseInt(satir.substring(12).trim());
                yemMiktarListesi.add(miktar);
            }
        }
    }
    
    
}