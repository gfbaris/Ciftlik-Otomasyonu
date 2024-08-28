import java.util.ArrayList;
import java.io.*;


public class Hayvanlar {
    
    public static ArrayList<Integer> buyukbasHayvanIdListesi = new ArrayList<>();
    public static ArrayList<String> buyukbasHayvanTurListesi = new ArrayList<>();
    public static ArrayList<Integer> buyukbasHayvanYasListesi = new ArrayList<>();
    public static ArrayList<String> buyukbasHayvanSaglikListesi = new ArrayList<>();

    public static ArrayList<Integer> kucukbasHayvanIdListesi = new ArrayList<>();
    public static ArrayList<String> kucukbasHayvanTurListesi = new ArrayList<>();
    public static ArrayList<Integer> kucukbasHayvanYasListesi = new ArrayList<>();
    public static ArrayList<String> kucukbasHayvanSaglikListesi = new ArrayList<>();

    public static ArrayList<Integer> kumesHayvanIdListesi = new ArrayList<>();
    public static ArrayList<String> kumesHayvanTurListesi = new ArrayList<>();
    public static ArrayList<Integer> kumesHayvanYasListesi = new ArrayList<>();
    public static ArrayList<String> kumesHayvanSaglikListesi = new ArrayList<>();

    public static void hayvanMenusu() {
        System.out.println("--- HAYVAN MENÜSÜ ---");
        System.out.println("[1] Büyükbaş Hayvanlar");
        System.out.println("[2] Küçükbaş Hayvanlar");
        System.out.println("[3] Kümes Hayvanları");
        System.out.println("[4] Ana Menüye Dön");

        System.out.println("Yapacağınız İşlemi Seçiniz :");
        int secim = Util.readInt();

        switch (secim) {
            case 1:
                Util.EkranYokEtme();
                buyukbasHayvanMenusu();
                break;
            case 2:
                Util.EkranYokEtme();
                kucukbasHayvanMenusu();
                break;
            case 3:
                Util.EkranYokEtme();
                kumesHayvanMenusu();
                break;
            case 4:
                return;
            default:
                System.out.println("Geçersiz seçim.");
                hayvanMenusu();
        }
    }

    public static void buyukbasHayvanMenusu() {
        System.out.println("[1] Hayvan Ekleme");
        System.out.println("[2] Hayvan Düzenleme");
        System.out.println("[3] Hayvan Silme");
        System.out.println("[4] Hayvan Raporlama");
        System.out.println("[5] Ana Menüye Dön");
        System.out.println("Yapacağınız İşlemi Seçiniz :");
        int islem = Util.readInt();

        switch (islem) {
            case 1:
                buyukbasHayvanEkleme();
                break;
            case 2:
                buyukbasHayvanDuzenleme();
                break;
            case 3:
                buyukbasHayvanSilme();
                break;
            case 4:
                buyukbasHayvanRaporlama();
                break;
            case 5:
                hayvanMenusu();
                break;
            default:
                System.out.println("Geçersiz seçim. Menüye dönüyorsunuz...");
                buyukbasHayvanMenusu();
        }
    }

    private static void buyukbasHayvanEkleme() {
        char devam;
        String saglikDurumu;
        do {
            Util.EkranYokEtme();
        System.out.println("Büyükbaş Hayvanın ID Bilgisi :");
        int id = Util.readInt();
        Util.readString();

        while (buyukbasHayvanIdListesi.contains(id)) {
            System.out.println("Bu ID zaten mevcut. Lütfen tekrar deneyin.");
            id = Util.readInt();
            Util.readString();
        }
        buyukbasHayvanIdListesi.add(id);

        String tur = null;
        while (true) {
            System.out.println("Büyükbaş Hayvanın Türünü Giriniz :");
            tur = Util.readString().trim();
            if (tur.isEmpty()) {
                System.out.println("Tür bilgisi boş olamaz. Lütfen tekrar girin.");
            } else {
                break;
            }
        }
        buyukbasHayvanTurListesi.add(tur);

            int yas;
            while (true) {
                System.out.println("Büyükbaş Hayvanın Yaşını Giriniz :");
                yas = Util.readInt();
                if (yas > 0) {
                    break;
                } else {
                    System.out.println("Yaş geçersiz. Lütfen pozitif bir sayı girin.");
                }
            }
            buyukbasHayvanYasListesi.add(yas);

            System.out.println("Büyükbaş Hayvanın Sağlık Durumunu Seçiniz :");
            System.out.println("1- Sağlıklı 2- Hasta 3- Aşılı 4- Tedavi Görüyor 5- Karantinada");
            int secim = Util.readInt();
            switch (secim) {
                case 1:
                    saglikDurumu = "Sağlıklı";
                    break;
                case 2:
                    saglikDurumu = "Hasta";
                    break;
                case 3:
                    saglikDurumu = "Aşılı";
                    break;
                case 4:
                    saglikDurumu = "Tedavi Görüyor";
                    break;
                case 5:
                    saglikDurumu = "Karantinada";
                    break;
                default:
                    System.out.println("Geçersiz seçim yaptınız. Sağlık durumu 'Bilinmiyor' olarak ayarlanacaktır.");
                    saglikDurumu = "Bilinmiyor";
                    break;
            }
            buyukbasHayvanSaglikListesi.add(saglikDurumu);

            try (FileWriter writer = new FileWriter("D:\\Çiftlik\\Hayvanlar\\Büyükbaş.txt", true)) {
                writer.write("ID: " + id + "\n");
                writer.write("Tür: " + tur + "\n");
                writer.write("Yaş: " + yas + "\n");
                writer.write("Sağlık Durumu: " + saglikDurumu + "\n");
                writer.write("--------------------------\n");
                System.out.println("Bilgiler dosyaya başarıyla yazıldı.");
            } catch (IOException e) {
                System.out.println("Bilgiler dosyaya yazılırken bir hata oluştu: " + e.getMessage());
            }

            System.out.println("Büyükbaş Hayvan Eklemeye Devam Etmek İçin 'e' veya 'E' giriniz.");
            System.out.println("Çıkmak İçin Herhangi Bir Harf Giriniz.");
            devam = Util.readChar();
        } while (devam == 'e' || devam == 'E');
    }

    private static void buyukbasHayvanDuzenleme() {
        System.out.println("Düzenlemek İstediğiniz Büyükbaş Hayvanın ID sini Giriniz");
        int id = Util.readInt();
        int index = -1;
    
        if (buyukbasHayvanIdListesi.contains(id)) {
            index = buyukbasHayvanIdListesi.indexOf(id);
    
            Util.scanner.nextLine();
    
            System.out.println("Büyükbaş Hayvanın Yeni Türü :");
            String tur = Util.readString();
            buyukbasHayvanTurListesi.set(index, tur); 
    
            System.out.println("Büyükbaş Hayvanın Yeni Yaşı :");
            int yas = Util.readInt(); 
            buyukbasHayvanYasListesi.set(index, yas);
    
            System.out.println("Büyükbaş Hayvanın Yeni Sağlık Durumu :");
            System.out.println("1- Sağlıklı 2- Hasta 3- Aşılı 4- Tedavi Görüyor 5- Karantinada");
            int secim = Util.readInt();
            String saglikDurumu;
    
            switch (secim) {
                case 1:
                    saglikDurumu = "Sağlıklı";
                    break;
                case 2:
                    saglikDurumu = "Hasta";
                    break;
                case 3:
                    saglikDurumu = "Aşılı";
                    break;
                case 4:
                    saglikDurumu = "Tedavi Görüyor";
                    break;
                case 5:
                    saglikDurumu = "Karantinada";
                    break;
                default:
                    System.out.println("Geçersiz seçim yaptınız. Sağlık durumu 'Bilinmiyor' olarak ayarlanacaktır.");
                    saglikDurumu = "Bilinmiyor";
                    break;
            }
            buyukbasHayvanSaglikListesi.set(index, saglikDurumu);
    
            try (FileWriter writer = new FileWriter("D:\\Çiftlik\\Hayvanlar\\Büyükbaş.txt", false)) {
                for (int i = 0; i < buyukbasHayvanIdListesi.size(); i++) {
                    writer.write("ID: " + buyukbasHayvanIdListesi.get(i) + "\n");
                    writer.write("Tür: " + buyukbasHayvanTurListesi.get(i) + "\n");
                    writer.write("Yaş: " + buyukbasHayvanYasListesi.get(i) + "\n");
                    writer.write("Sağlık Durumu: " + buyukbasHayvanSaglikListesi.get(i) + "\n");
                    writer.write("--------------------------\n");
                }
                System.out.println("Bilgiler dosyaya başarıyla yazıldı.");
            } catch (IOException e) {
                System.out.println("Bilgiler dosyaya yazılırken bir hata oluştu: " + e.getMessage());
            }
    
        } else {
            System.out.println("Girdiğiniz ID ile Eşleşen Hayvan Bulunamadı.");
            hayvanMenusu();
        }
    }
    
    

    private static void buyukbasHayvanSilme(){

        System.out.println("Silmek İstediğiniz Büyükbaş Hayvanın ID sini Giriniz");
        int id = Util.readInt();
        int index = -1;

        if(buyukbasHayvanIdListesi.contains(id))
        {
            index = buyukbasHayvanIdListesi.indexOf(id);
            buyukbasHayvanIdListesi.remove(index);
            buyukbasHayvanTurListesi.remove(index);
            buyukbasHayvanYasListesi.remove(index);
            buyukbasHayvanSaglikListesi.remove(index);

            try (FileWriter writer = new FileWriter("D:\\Çiftlik\\Hayvanlar\\Büyükbaş.txt", false)) {
                for (int i = 0; i < buyukbasHayvanIdListesi.size(); i++) {
                    writer.write("ID: " + buyukbasHayvanIdListesi.get(i) + "\n");
                    writer.write("Tür: " + buyukbasHayvanTurListesi.get(i) + "\n");
                    writer.write("Yaş: " + buyukbasHayvanYasListesi.get(i) + "\n");
                    writer.write("Sağlık Durumu: " + buyukbasHayvanSaglikListesi.get(i) + "\n");
                    writer.write("--------------------------\n");
                }
                System.out.println("Bilgiler dosyaya başarıyla yazıldı.");
            } catch (IOException e) {
                System.out.println("Bilgiler dosyaya yazılırken bir hata oluştu: " + e.getMessage());
            }
        }
        else
        {
            System.out.println("Girdiğiniz ID ile Eşleşen Hayvan Bulunamadı.");
            hayvanMenusu();
        }

    }

    private static void buyukbasHayvanRaporlama() {
        System.out.println("[1] ID'e Göre");
        System.out.println("[2] Yaşa Göre");
        System.out.println("[3] Sağlık Durumuna Göre");
        System.out.println("[4] Tüm Büyükbaş Hayvanların Raporu");
        System.out.println("[5] Menü");
    
        System.out.println("Yapacağınız İşlemi Seçiniz :");
        int secim = Util.readInt();
    
        switch (secim) {
            case 1:
                Util.EkranYokEtme();
                System.out.println("Raporlamak İstediğiniz Büyükbaş Hayvanın ID'sini Giriniz :");
                int id = Util.readInt();
                if (buyukbasHayvanIdListesi.contains(id)) {
                    int index = buyukbasHayvanIdListesi.indexOf(id);
                    System.out.println("--- " + buyukbasHayvanIdListesi.get(index) + " ID'li Büyükbaş Hayvanın Raporları ---");
                    System.out.println("Tür: " + buyukbasHayvanTurListesi.get(index));
                    System.out.println("Yaş: " + buyukbasHayvanYasListesi.get(index));
                    System.out.println("Sağlık Durumu: " + buyukbasHayvanSaglikListesi.get(index));
                    hayvanMenusu();
                } else {
                    Util.EkranYokEtme();
                    System.out.println("Girilen ID ile Eşleşen Büyükbaş Hayvan Bulunamadı");
                    hayvanMenusu();

                }
                break;
            case 2:
                Util.EkranYokEtme();
                System.out.println("Raporlamak İstediğiniz Büyükbaş Hayvanın Yaşını Giriniz :");
                int yas = Util.readInt();
                int adet = 0;
                System.out.println("--- Girdiğiniz Yaştaki Hayvanların Raporları ---");
                for (int i = 0; i < buyukbasHayvanIdListesi.size(); i++) {
                    if (yas == buyukbasHayvanYasListesi.get(i)) {
                        System.out.println("ID: " + buyukbasHayvanIdListesi.get(i));
                        System.out.println("Tür: " + buyukbasHayvanTurListesi.get(i));
                        System.out.println("Yaş: " + buyukbasHayvanYasListesi.get(i));
                        System.out.println("Sağlık Durumu: " + buyukbasHayvanSaglikListesi.get(i));
                        adet++;
                    }
                }

                if (adet == 0) {
                    Util.EkranYokEtme();
                    System.out.println("Girdiğiniz Yaşta Sistemde Raporlanacak Bilgi Bulunamamıştır.");
                }
                hayvanMenusu();

                break;
            case 3:
                Util.EkranYokEtme();
                System.out.println("Raporlamak İstediğiniz Büyükbaş Hayvanın Sağlık Bilgilerini Seçiniz:");
                System.out.println("1- Sağlıklı 2- Hasta 3- Aşılı 4- Tedavi Görüyor 5- Karantinada");
                int saglikSecim = Util.readInt();
                String saglikDurumu = null;
                switch (saglikSecim) {
                    case 1:
                        saglikDurumu = "Sağlıklı";
                        break;
                    case 2:
                        saglikDurumu = "Hasta";
                        break;
                    case 3:
                        saglikDurumu = "Aşılı";
                        break;
                    case 4:
                        saglikDurumu = "Tedavi Görüyor";
                        break;
                    case 5:
                        saglikDurumu = "Karantinada";
                        break;
                    default:
                        System.out.println("Geçersiz seçim. Sağlık durumu 'Bilinmiyor' olarak ayarlanacak.");
                        saglikDurumu = "Bilinmiyor";
                        break;
                }
                int adet2 = 0;
                for (int i = 0; i < buyukbasHayvanIdListesi.size(); i++) {
                    if (buyukbasHayvanSaglikListesi.get(i).equals(saglikDurumu)) {
                        System.out.println("ID: " + buyukbasHayvanIdListesi.get(i));
                        System.out.println("Tür: " + buyukbasHayvanTurListesi.get(i));
                        System.out.println("Yaş: " + buyukbasHayvanYasListesi.get(i));
                        System.out.println("Sağlık Durumu: " + buyukbasHayvanSaglikListesi.get(i));
                        adet2++;
                    }
                }
                if (adet2 == 0) {
                    Util.EkranYokEtme();
                    System.out.println("Belirtilen sağlık durumunda hayvan bulunamadı.");
                }
                hayvanMenusu();

                break;
            case 4:
                Util.EkranYokEtme();
                System.out.println("--- Tüm Büyükbaş Hayvanların Raporları ---");
                for (int i = 0; i < buyukbasHayvanIdListesi.size(); i++) {
                    System.out.println("ID: " + buyukbasHayvanIdListesi.get(i));
                    System.out.println("Tür: " + buyukbasHayvanTurListesi.get(i));
                    System.out.println("Yaş: " + buyukbasHayvanYasListesi.get(i));
                    System.out.println("Sağlık Durumu: " + buyukbasHayvanSaglikListesi.get(i));
                    System.out.println("--------------------------");
                }
                hayvanMenusu();

                break;
            case 5:
                Util.EkranYokEtme();
                hayvanMenusu();
                break;
            default:
                System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                hayvanMenusu();
                break;
            }

    }

    public static void kucukbasHayvanMenusu() {
        System.out.println("[1] Hayvan Ekleme");
        System.out.println("[2] Hayvan Düzenleme");
        System.out.println("[3] Hayvan Silme");
        System.out.println("[4] Hayvan Raporlama");
        System.out.println("[5] Ana Menüye Dön");
        System.out.println("Yapacağınız İşlemi Seçiniz :");
        int islem = Util.readInt();

        switch (islem) {
            case 1:
                kucukbasHayvanEkleme();
                break;
            case 2:
                kucukbasHayvanDuzenleme();
                break;
            case 3:
                kucukbasHayvanSilme();
                break;
            case 4:
                kucukbasHayvanRaporlama();
                break;
            case 5:
                hayvanMenusu();
                break;
            default:
                System.out.println("Geçersiz seçim. Menüye dönüyorsunuz...");
                kucukbasHayvanMenusu();
        }
    }

    private static void kucukbasHayvanEkleme(){

        char devam;
        String saglikDurumu;
        do {
            Util.EkranYokEtme();
            System.out.println("Küçükbaş Hayvanın ID Bilgisi :");
            int id = Util.readInt();
            Util.readString();

        while (kucukbasHayvanIdListesi.contains(id)) {
            System.out.println("Bu ID zaten mevcut. Lütfen tekrar deneyin.");
            id = Util.readInt();
            Util.readString();
        }
        kucukbasHayvanIdListesi.add(id);

        String tur = null;
        while (true) {
            System.out.println("Küçükbaş Hayvanın Türünü Giriniz :");
            tur = Util.readString().trim();
            if (tur.isEmpty()) {
                System.out.println("Tür bilgisi boş olamaz. Lütfen tekrar girin.");
            } else {
                break;
            }
        }
        kucukbasHayvanTurListesi.add(tur);

            int yas;
            while (true) {
                System.out.println("Küçükbaş Hayvanın Yaşını Giriniz :");
                yas = Util.readInt();
                if (yas > 0) {
                    break;
                } else {
                    System.out.println("Yaş geçersiz. Lütfen pozitif bir sayı girin.");
                }
            }
            kucukbasHayvanYasListesi.add(yas);

            System.out.println("Küçükbaş Hayvanın Sağlık Durumunu Seçiniz :");
            System.out.println("1- Sağlıklı 2- Hasta 3- Aşılı 4- Tedavi Görüyor 5- Karantinada");
            int secim = Util.readInt();
            switch (secim) {
                case 1:
                    saglikDurumu = "Sağlıklı";
                    break;
                case 2:
                    saglikDurumu = "Hasta";
                    break;
                case 3:
                    saglikDurumu = "Aşılı";
                    break;
                case 4:
                    saglikDurumu = "Tedavi Görüyor";
                    break;
                case 5:
                    saglikDurumu = "Karantinada";
                    break;
                default:
                    System.out.println("Geçersiz seçim yaptınız. Sağlık durumu 'Bilinmiyor' olarak ayarlanacaktır.");
                    saglikDurumu = "Bilinmiyor";
                    break;
            }
            kucukbasHayvanSaglikListesi.add(saglikDurumu);

            try (FileWriter writer = new FileWriter("D:\\Çiftlik\\Hayvanlar\\Küçükbaş.txt", true)) {
                writer.write("ID: " + id + "\n");
                writer.write("Tür: " + tur + "\n");
                writer.write("Yaş: " + yas + "\n");
                writer.write("Sağlık Durumu: " + saglikDurumu + "\n");
                writer.write("--------------------------\n");
                System.out.println("Bilgiler dosyaya başarıyla yazıldı.");
            } catch (IOException e) {
                System.out.println("Bilgiler dosyaya yazılırken bir hata oluştu: " + e.getMessage());
            }

            System.out.println("Küçükbaş Hayvan Eklemeye Devam Etmek İçin 'e' veya 'E' giriniz.");
            System.out.println("Çıkmak İçin Herhangi Bir Harf Giriniz.");
            devam = Util.readChar();
        } while (devam == 'e' || devam == 'E');

    }

    private static void kucukbasHayvanDuzenleme(){

        System.out.println("Düzenlemek İstediğiniz Küçükbaş Hayvanın ID sini Giriniz");
        int id = Util.readInt();
        int index = -1;

        if(kucukbasHayvanIdListesi.contains(id))
        {
            Util.scanner.nextLine();
            index = kucukbasHayvanIdListesi.indexOf(id);
            System.out.println("Küçükbaş Hayvanın Yeni Türü :");
            String tur = Util.readString();
            kucukbasHayvanTurListesi.set(index, tur);

            System.out.println("Küçükbaş Hayvanın Yeni Yaşı :");
            int yas = Util.readInt();
            kucukbasHayvanYasListesi.set(index, yas);

            System.out.println("Küçükbaş Hayvanın Yeni Sağlık Durumu :");
            System.out.println("1- Sağlıklı 2- Hasta 3- Aşılı 4- Tedavi Görüyor 5- Karantinada");
            int secim = Util.readInt();
            String saglikDurumu;

            switch (secim) {
                case 1:
                    saglikDurumu = "Sağlıklı";
                    break;
                case 2:
                    saglikDurumu = "Hasta";
                    break;
                case 3:
                    saglikDurumu = "Aşılı";
                    break;
                case 4:
                    saglikDurumu = "Tedavi Görüyor";
                    break;
                case 5:
                    saglikDurumu = "Karantinada";
                    break;
                default:
                    System.out.println("Geçersiz seçim yaptınız. Sağlık durumu 'Bilinmiyor' olarak ayarlanacaktır.");
                    saglikDurumu = "Bilinmiyor";
                    break;
            }
            kucukbasHayvanSaglikListesi.set(index, saglikDurumu);

            try (FileWriter writer = new FileWriter("D:\\Çiftlik\\Hayvanlar\\Küçükbaş.txt", false)) {
                for (int i = 0; i < kucukbasHayvanIdListesi.size(); i++) {
                    writer.write("ID: " + kucukbasHayvanIdListesi.get(i) + "\n");
                    writer.write("Tür: " + kucukbasHayvanTurListesi.get(i) + "\n");
                    writer.write("Yaş: " + kucukbasHayvanYasListesi.get(i) + "\n");
                    writer.write("Sağlık Durumu: " + kucukbasHayvanSaglikListesi.get(i) + "\n");
                    writer.write("--------------------------\n");
                }
                System.out.println("Bilgiler dosyaya başarıyla yazıldı.");
            } catch (IOException e) {
                System.out.println("Bilgiler dosyaya yazılırken bir hata oluştu: " + e.getMessage());
            }

        }
        else
        {
            System.out.println("Girdiğiniz ID ile Eşleşen Hayvan Bulunamadı.");
            hayvanMenusu();
        }

    }

    private static void kucukbasHayvanSilme(){

        System.out.println("Silmek İstediğiniz Küçükbaş Hayvanın ID sini Giriniz");
        int id = Util.readInt();
        int index = -1;

        if(kucukbasHayvanIdListesi.contains(id))
        {
            index = kucukbasHayvanIdListesi.indexOf(id);
            kucukbasHayvanIdListesi.remove(index);
            kucukbasHayvanTurListesi.remove(index);
            kucukbasHayvanYasListesi.remove(index);
            kucukbasHayvanSaglikListesi.remove(index);

            try (FileWriter writer = new FileWriter("D:\\Çiftlik\\Hayvanlar\\Küçükbaş.txt", false)) {
                for (int i = 0; i < kucukbasHayvanIdListesi.size(); i++) {
                    writer.write("ID: " + kucukbasHayvanIdListesi.get(i) + "\n");
                    writer.write("Tür: " + kucukbasHayvanTurListesi.get(i) + "\n");
                    writer.write("Yaş: " + kucukbasHayvanYasListesi.get(i) + "\n");
                    writer.write("Sağlık Durumu: " + kucukbasHayvanSaglikListesi.get(i) + "\n");
                    writer.write("--------------------------\n");
                }
                System.out.println("Bilgiler dosyaya başarıyla yazıldı.");
            } catch (IOException e) {
                System.out.println("Bilgiler dosyaya yazılırken bir hata oluştu: " + e.getMessage());
            }
        }
        else
        {
            System.out.println("Girdiğiniz ID ile Eşleşen Hayvan Bulunamadı.");
            hayvanMenusu();
        }

    }

    private static void kucukbasHayvanRaporlama(){

        System.out.println("[1] ID'e Göre");
        System.out.println("[2] Yaşa Göre");
        System.out.println("[3] Sağlık Durumuna Göre");
        System.out.println("[4] Tüm Küçükbaş Hayvanların Raporu");
        System.out.println("[5] Menü");
    
        System.out.println("Yapacağınız İşlemi Seçiniz :");
        int secim = Util.readInt();
    
        switch (secim) {
            case 1:
                Util.EkranYokEtme();
                System.out.println("Raporlamak İstediğiniz Küçükbaş Hayvanın ID'sini Giriniz :");
                int id = Util.readInt();
                if (kucukbasHayvanIdListesi.contains(id)) {
                    int index = kucukbasHayvanIdListesi.indexOf(id);
                    System.out.println("--- " + kucukbasHayvanIdListesi.get(index) + " ID'li Küçükbaş Hayvanın Raporları ---");
                    System.out.println("Tür: " + kucukbasHayvanTurListesi.get(index));
                    System.out.println("Yaş: " + kucukbasHayvanYasListesi.get(index));
                    System.out.println("Sağlık Durumu: " + kucukbasHayvanSaglikListesi.get(index));
                    hayvanMenusu();
                } else {
                    Util.EkranYokEtme();
                    System.out.println("Girilen ID ile Eşleşen Küçükbaş Hayvan Bulunamadı");
                    hayvanMenusu();

                }
                break;
            case 2:
                Util.EkranYokEtme();
                System.out.println("Raporlamak İstediğiniz Küçükbaş Hayvanın Yaşını Giriniz :");
                int yas = Util.readInt();
                int adet = 0;
                System.out.println("--- Girdiğiniz Yaştaki Hayvanların Raporları ---");
                for (int i = 0; i < kucukbasHayvanIdListesi.size(); i++) {
                    if (yas == kucukbasHayvanYasListesi.get(i)) {
                        System.out.println("ID: " + kucukbasHayvanIdListesi.get(i));
                        System.out.println("Tür: " + kucukbasHayvanTurListesi.get(i));
                        System.out.println("Yaş: " + kucukbasHayvanYasListesi.get(i));
                        System.out.println("Sağlık Durumu: " + kucukbasHayvanSaglikListesi.get(i));
                        adet++;
                    }
                }

                if (adet == 0) {
                    Util.EkranYokEtme();
                    System.out.println("Girdiğiniz Yaşta Sistemde Raporlanacak Bilgi Bulunamamıştır.");
                }
                hayvanMenusu();

                break;
            case 3:
                Util.EkranYokEtme();
                System.out.println("Raporlamak İstediğiniz Küçükbaş Hayvanın Sağlık Bilgilerini Seçiniz:");
                System.out.println("1- Sağlıklı 2- Hasta 3- Aşılı 4- Tedavi Görüyor 5- Karantinada");
                int saglikSecim = Util.readInt();
                String saglikDurumu = null;
                switch (saglikSecim) {
                    case 1:
                        saglikDurumu = "Sağlıklı";
                        break;
                    case 2:
                        saglikDurumu = "Hasta";
                        break;
                    case 3:
                        saglikDurumu = "Aşılı";
                        break;
                    case 4:
                        saglikDurumu = "Tedavi Görüyor";
                        break;
                    case 5:
                        saglikDurumu = "Karantinada";
                        break;
                    default:
                        System.out.println("Geçersiz seçim. Sağlık durumu 'Bilinmiyor' olarak ayarlanacak.");
                        saglikDurumu = "Bilinmiyor";
                        break;
                }
                int adet2 = 0;
                for (int i = 0; i < kucukbasHayvanIdListesi.size(); i++) {
                    if (kucukbasHayvanSaglikListesi.get(i).equals(saglikDurumu)) {
                        System.out.println("ID: " + kucukbasHayvanIdListesi.get(i));
                        System.out.println("Tür: " + kucukbasHayvanTurListesi.get(i));
                        System.out.println("Yaş: " + kucukbasHayvanYasListesi.get(i));
                        System.out.println("Sağlık Durumu: " + kucukbasHayvanSaglikListesi.get(i));
                        adet2++;
                    }
                }
                if (adet2 == 0) {
                    Util.EkranYokEtme();
                    System.out.println("Belirtilen sağlık durumunda hayvan bulunamadı.");
                }
                hayvanMenusu();

                break;
            case 4:
                Util.EkranYokEtme();
                System.out.println("--- Tüm Küçükbaş Hayvanların Raporları ---");
                for (int i = 0; i < kucukbasHayvanIdListesi.size(); i++) {
                    System.out.println("ID: " + kucukbasHayvanIdListesi.get(i));
                    System.out.println("Tür: " + kucukbasHayvanTurListesi.get(i));
                    System.out.println("Yaş: " + kucukbasHayvanYasListesi.get(i));
                    System.out.println("Sağlık Durumu: " + kucukbasHayvanSaglikListesi.get(i));
                    System.out.println("--------------------------");
                }
                hayvanMenusu();

                break;
            case 5:
                Util.EkranYokEtme();
                hayvanMenusu();
                break;
            default:
                System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                hayvanMenusu();
                break;
            }
    }

    public static void kumesHayvanMenusu() {
        System.out.println("[1] Hayvan Ekleme");
        System.out.println("[2] Hayvan Düzenleme");
        System.out.println("[3] Hayvan Silme");
        System.out.println("[4] Hayvan Raporlama");
        System.out.println("[5] Ana Menüye Dön");
        System.out.println("Yapacağınız İşlemi Seçiniz :");
        int islem = Util.readInt();

        switch (islem) {
            case 1:
                kumesHayvanEkleme();
                break;
            case 2:
                kumesHayvanDuzenleme();
                break;
            case 3:
                kumesHayvanSilme();
                break;
            case 4:
                kumesHayvanRaporlama();
                break;
            case 5:
                hayvanMenusu();
                break;
            default:
                System.out.println("Geçersiz seçim. Menüye dönüyorsunuz...");
                kumesHayvanMenusu();
        }
    }

    private static void kumesHayvanEkleme(){

        char devam;
        String saglikDurumu;
        do {
            Util.EkranYokEtme();
            System.out.println("Kümes Hayvanın ID Bilgisi :");
            int id = Util.readInt();
            Util.readString();

        while (kumesHayvanIdListesi.contains(id)) {
            System.out.println("Bu ID zaten mevcut. Lütfen tekrar deneyin.");
            id = Util.readInt();
            Util.readString();
        }
        kumesHayvanIdListesi.add(id);

        String tur = null;
        while (true) {
            System.out.println("Kümes Hayvanın Türünü Giriniz :");
            tur = Util.readString().trim();
            if (tur.isEmpty()) {
                System.out.println("Tür bilgisi boş olamaz. Lütfen tekrar girin.");
            } else {
                break;
            }
        }
        kumesHayvanTurListesi.add(tur);

            int yas;
            while (true) {
                System.out.println("Kümes Hayvanın Yaşını Giriniz :");
                yas = Util.readInt();
                if (yas > 0) {
                    break;
                } else {
                    System.out.println("Yaş geçersiz. Lütfen pozitif bir sayı girin.");
                }
            }
            kumesHayvanYasListesi.add(yas);

            System.out.println("Kümes Hayvanın Sağlık Durumunu Seçiniz :");
            System.out.println("1- Sağlıklı 2- Hasta 3- Aşılı 4- Tedavi Görüyor 5- Karantinada");
            int secim = Util.readInt();
            switch (secim) {
                case 1:
                    saglikDurumu = "Sağlıklı";
                    break;
                case 2:
                    saglikDurumu = "Hasta";
                    break;
                case 3:
                    saglikDurumu = "Aşılı";
                    break;
                case 4:
                    saglikDurumu = "Tedavi Görüyor";
                    break;
                case 5:
                    saglikDurumu = "Karantinada";
                    break;
                default:
                    System.out.println("Geçersiz seçim yaptınız. Sağlık durumu 'Bilinmiyor' olarak ayarlanacaktır.");
                    saglikDurumu = "Bilinmiyor";
                    break;
            }
            kumesHayvanSaglikListesi.add(saglikDurumu);

            try (FileWriter writer = new FileWriter("D:\\Çiftlik\\Hayvanlar\\Kümes.txt", true)) {
                writer.write("ID: " + id + "\n");
                writer.write("Tür: " + tur + "\n");
                writer.write("Yaş: " + yas + "\n");
                writer.write("Sağlık Durumu: " + saglikDurumu + "\n");
                writer.write("--------------------------\n");
                System.out.println("Bilgiler dosyaya başarıyla yazıldı.");
            } catch (IOException e) {
                System.out.println("Bilgiler dosyaya yazılırken bir hata oluştu: " + e.getMessage());
            }

            System.out.println("Kümes Hayvan Eklemeye Devam Etmek İçin 'e' veya 'E' giriniz.");
            System.out.println("Çıkmak İçin Herhangi Bir Harf Giriniz.");
            devam = Util.readChar();
        } while (devam == 'e' || devam == 'E');
        
    }

    private static void kumesHayvanDuzenleme(){

        System.out.println("Düzenlemek İstediğiniz Kümes Hayvanın ID sini Giriniz");
        int id = Util.readInt();
        int index = -1;

        if(kumesHayvanIdListesi.contains(id))
        {
            Util.scanner.nextLine();
            index = kumesHayvanIdListesi.indexOf(id);
            System.out.println("Kümes Hayvanın Yeni Türü :");
            String tur = Util.readString();
            kumesHayvanTurListesi.set(index, tur);

            System.out.println("Kümes Hayvanın Yeni Yaşı :");
            int yas = Util.readInt();
            kumesHayvanYasListesi.set(index, yas);

            System.out.println("Kümes Hayvanın Yeni Sağlık Durumu :");
            System.out.println("1- Sağlıklı 2- Hasta 3- Aşılı 4- Tedavi Görüyor 5- Karantinada");
            int secim = Util.readInt();
            String saglikDurumu;

            switch (secim) {
                case 1:
                    saglikDurumu = "Sağlıklı";
                    break;
                case 2:
                    saglikDurumu = "Hasta";
                    break;
                case 3:
                    saglikDurumu = "Aşılı";
                    break;
                case 4:
                    saglikDurumu = "Tedavi Görüyor";
                    break;
                case 5:
                    saglikDurumu = "Karantinada";
                    break;
                default:
                    System.out.println("Geçersiz seçim yaptınız. Sağlık durumu 'Bilinmiyor' olarak ayarlanacaktır.");
                    saglikDurumu = "Bilinmiyor";
                    break;
            }
            kumesHayvanSaglikListesi.set(index, saglikDurumu);

            try (FileWriter writer = new FileWriter("D:\\Çiftlik\\Hayvanlar\\Kümes.txt", false)) {
                for (int i = 0; i < kumesHayvanIdListesi.size(); i++) {
                    writer.write("ID: " + kumesHayvanIdListesi.get(i) + "\n");
                    writer.write("Tür: " + kumesHayvanTurListesi.get(i) + "\n");
                    writer.write("Yaş: " + kumesHayvanYasListesi.get(i) + "\n");
                    writer.write("Sağlık Durumu: " + kumesHayvanSaglikListesi.get(i) + "\n");
                    writer.write("--------------------------\n");
                }
                System.out.println("Bilgiler dosyaya başarıyla yazıldı.");
            } catch (IOException e) {
                System.out.println("Bilgiler dosyaya yazılırken bir hata oluştu: " + e.getMessage());
            }

        }
        else
        {
            System.out.println("Girdiğiniz ID ile Eşleşen Hayvan Bulunamadı.");
            hayvanMenusu();
        }

    }

    private static void kumesHayvanSilme(){

        System.out.println("Silmek İstediğiniz Kümes Hayvanın ID sini Giriniz");
        int id = Util.readInt();
        int index = -1;

        if(kumesHayvanIdListesi.contains(id))
        {
            index = kumesHayvanIdListesi.indexOf(id);
            kumesHayvanIdListesi.remove(index);
            kumesHayvanTurListesi.remove(index);
            kumesHayvanYasListesi.remove(index);
            kumesHayvanSaglikListesi.remove(index);

            try (FileWriter writer = new FileWriter("D:\\Çiftlik\\Hayvanlar\\Kümes.txt", false)) {
                for (int i = 0; i < kumesHayvanIdListesi.size(); i++) {
                    writer.write("ID: " + kumesHayvanIdListesi.get(i) + "\n");
                    writer.write("Tür: " + kumesHayvanTurListesi.get(i) + "\n");
                    writer.write("Yaş: " + kumesHayvanYasListesi.get(i) + "\n");
                    writer.write("Sağlık Durumu: " + kumesHayvanSaglikListesi.get(i) + "\n");
                    writer.write("--------------------------\n");
                }
                System.out.println("Bilgiler dosyaya başarıyla yazıldı.");
            } catch (IOException e) {
                System.out.println("Bilgiler dosyaya yazılırken bir hata oluştu: " + e.getMessage());
            }
        }
        else
        {
            System.out.println("Girdiğiniz ID ile Eşleşen Hayvan Bulunamadı.");
            hayvanMenusu();
        }

    }

    private static void kumesHayvanRaporlama(){

        System.out.println("[1] ID'e Göre");
        System.out.println("[2] Yaşa Göre");
        System.out.println("[3] Sağlık Durumuna Göre");
        System.out.println("[4] Tüm Kümes Hayvanların Raporu");
        System.out.println("[5] Menü");
    
        System.out.println("Yapacağınız İşlemi Seçiniz :");
        int secim = Util.readInt();
    
        switch (secim) {
            case 1:
                Util.EkranYokEtme();
                System.out.println("Raporlamak İstediğiniz Kümes Hayvanın ID'sini Giriniz :");
                int id = Util.readInt();
                if (kumesHayvanIdListesi.contains(id)) {
                    int index = kumesHayvanIdListesi.indexOf(id);
                    System.out.println("--- " + kumesHayvanIdListesi.get(index) + " ID'li Kümes Hayvanın Raporları ---");
                    System.out.println("Tür: " + kumesHayvanTurListesi.get(index));
                    System.out.println("Yaş: " + kumesHayvanYasListesi.get(index));
                    System.out.println("Sağlık Durumu: " + kumesHayvanSaglikListesi.get(index));
                    hayvanMenusu();
                } else {
                    Util.EkranYokEtme();
                    System.out.println("Girilen ID ile Eşleşen Kümes Hayvan Bulunamadı");
                    hayvanMenusu();

                }
                break;
            case 2:
                Util.EkranYokEtme();
                System.out.println("Raporlamak İstediğiniz Kümes Hayvanın Yaşını Giriniz :");
                int yas = Util.readInt();
                int adet = 0;
                System.out.println("--- Girdiğiniz Yaştaki Hayvanların Raporları ---");
                for (int i = 0; i < kumesHayvanIdListesi.size(); i++) {
                    if (yas == kumesHayvanYasListesi.get(i)) {
                        System.out.println("ID: " + kumesHayvanIdListesi.get(i));
                        System.out.println("Tür: " + kumesHayvanTurListesi.get(i));
                        System.out.println("Yaş: " + kumesHayvanYasListesi.get(i));
                        System.out.println("Sağlık Durumu: " + kumesHayvanSaglikListesi.get(i));
                        adet++;
                    }
                }

                if (adet == 0) {
                    Util.EkranYokEtme();
                    System.out.println("Girdiğiniz Yaşta Sistemde Raporlanacak Bilgi Bulunamamıştır.");
                }
                hayvanMenusu();

                break;
            case 3:
                Util.EkranYokEtme();
                System.out.println("Raporlamak İstediğiniz Kümes Hayvanın Sağlık Bilgilerini Seçiniz:");
                System.out.println("1- Sağlıklı 2- Hasta 3- Aşılı 4- Tedavi Görüyor 5- Karantinada");
                int saglikSecim = Util.readInt();
                String saglikDurumu = null;
                switch (saglikSecim) {
                    case 1:
                        saglikDurumu = "Sağlıklı";
                        break;
                    case 2:
                        saglikDurumu = "Hasta";
                        break;
                    case 3:
                        saglikDurumu = "Aşılı";
                        break;
                    case 4:
                        saglikDurumu = "Tedavi Görüyor";
                        break;
                    case 5:
                        saglikDurumu = "Karantinada";
                        break;
                    default:
                        System.out.println("Geçersiz seçim. Sağlık durumu 'Bilinmiyor' olarak ayarlanacak.");
                        saglikDurumu = "Bilinmiyor";
                        break;
                }
                int adet2 = 0;
                for (int i = 0; i < kumesHayvanIdListesi.size(); i++) {
                    if (kumesHayvanSaglikListesi.get(i).equals(saglikDurumu)) {
                        System.out.println("ID: " + kumesHayvanIdListesi.get(i));
                        System.out.println("Tür: " + kumesHayvanTurListesi.get(i));
                        System.out.println("Yaş: " + kumesHayvanYasListesi.get(i));
                        System.out.println("Sağlık Durumu: " + kumesHayvanSaglikListesi.get(i));
                        adet2++;
                    }
                }
                if (adet2 == 0) {
                    Util.EkranYokEtme();
                    System.out.println("Belirtilen sağlık durumunda hayvan bulunamadı.");
                }
                hayvanMenusu();

                break;
            case 4:
                Util.EkranYokEtme();
                System.out.println("--- Tüm Kümes Hayvanların Raporları ---");
                for (int i = 0; i < kumesHayvanIdListesi.size(); i++) {
                    System.out.println("ID: " + kumesHayvanIdListesi.get(i));
                    System.out.println("Tür: " + kumesHayvanTurListesi.get(i));
                    System.out.println("Yaş: " + kumesHayvanYasListesi.get(i));
                    System.out.println("Sağlık Durumu: " + kumesHayvanSaglikListesi.get(i));
                    System.out.println("--------------------------");
                }
                hayvanMenusu();

                break;
            case 5:
                Util.EkranYokEtme();
                hayvanMenusu();
                break;
            default:
                System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                hayvanMenusu();
                break;
            }
    }

    
    public static void verileriYukle() {

        ArrayList<String> buyukbasVerileri = Util.textDosyaOku("D:\\Çiftlik\\Hayvanlar\\Büyükbaş.txt");

        for (String satir : buyukbasVerileri) {
            if (satir.startsWith("ID: ")) {
                int id = Integer.parseInt(satir.substring(4));
                buyukbasHayvanIdListesi.add(id);
            } else if (satir.startsWith("Tür: ")) {
                String tur = satir.substring(5);
                buyukbasHayvanTurListesi.add(tur);
            } else if (satir.startsWith("Yaş: ")) {
                int yas = Integer.parseInt(satir.substring(5));
                buyukbasHayvanYasListesi.add(yas);
            } else if (satir.startsWith("Sağlık Durumu: ")) {
                String saglikDurumu = satir.substring(15);
                buyukbasHayvanSaglikListesi.add(saglikDurumu);
            }
        }


        ArrayList<String> kucukbasVerileri = Util.textDosyaOku("D:\\Çiftlik\\Hayvanlar\\Küçükbaş.txt");

        for (String satir : kucukbasVerileri) {
            if (satir.startsWith("ID: ")) {
                int id = Integer.parseInt(satir.substring(4));
                kucukbasHayvanIdListesi.add(id);
            } else if (satir.startsWith("Tür: ")) {
                String tur = satir.substring(5);
                kucukbasHayvanTurListesi.add(tur);
            } else if (satir.startsWith("Yaş: ")) {
                int yas = Integer.parseInt(satir.substring(5));
                kucukbasHayvanYasListesi.add(yas);
            } else if (satir.startsWith("Sağlık Durumu: ")) {
                String saglikDurumu = satir.substring(15);
                kucukbasHayvanSaglikListesi.add(saglikDurumu);
            }
        }

    
        ArrayList<String> kumesVerileri = Util.textDosyaOku("D:\\Çiftlik\\Hayvanlar\\Kümes.txt");

        for (String satir : kumesVerileri) {
            if (satir.startsWith("ID: ")) {
                int id = Integer.parseInt(satir.substring(4));
                kumesHayvanIdListesi.add(id);
            } else if (satir.startsWith("Tür: ")) {
                String tur = satir.substring(5);
                kumesHayvanTurListesi.add(tur);
            } else if (satir.startsWith("Yaş: ")) {
                int yas = Integer.parseInt(satir.substring(5));
                kumesHayvanYasListesi.add(yas);
            } else if (satir.startsWith("Sağlık Durumu: ")) {
                String saglikDurumu = satir.substring(15);
                kumesHayvanSaglikListesi.add(saglikDurumu);
            }
        }
    }
}
