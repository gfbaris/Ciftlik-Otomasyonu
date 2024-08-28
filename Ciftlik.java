public class Ciftlik {

    public static void main(String[] args) {
        Util.klasorAc("Çiftlik","Hayvanlar");
        Util.klasorAc("Çiftlik","Besinler");
        Util.klasorAc("Çiftlik","Saglik");
        Util.klasorAc("Çiftlik","UretimVeVerimlilik");
        Util.klasorAc("Çiftlik","Finans");
        Util.textDosyaOlustur("Çiftlik","Hayvanlar","Büyükbaş");
        Util.textDosyaOlustur("Çiftlik","Hayvanlar","Küçükbaş");
        Util.textDosyaOlustur("Çiftlik","Hayvanlar","Kümes");
        Util.textDosyaOlustur("Çiftlik","Besinler", "YemBilgileri");
        Util.textDosyaOlustur("Çiftilk", "Besinler", "YemDağıtımı");

        Hayvanlar.verileriYukle();

        Util.EkranYokEtme();
        while (true) {
            Util.EkranYokEtme();
            System.out.println("--- ANA MENU ---");
            System.out.println("[1] Hayvanlar");
            System.out.println("[2] Besinler");
            System.out.println("[3] Sağlık");
            System.out.println("[4] Üretim ve Verimlilik");
            System.out.println("[5] Finans");
            System.out.println("[6] Çıkış");

            System.out.println("Yapacağınız İşlemi Seçiniz :");
            int secim = Util.readInt();

            switch (secim) {
                case 1:
                    Util.EkranYokEtme();
                    Hayvanlar.hayvanMenusu();
                    break;
                case 2:
                    Util.EkranYokEtme();
                    Besinler.besinMenusu();
                    break;
                case 3:
                    Util.EkranYokEtme();
                    Saglik.saglikMenusu();
                    break;
                case 4:
                    Util.EkranYokEtme();
                    UretimVeVerimlilik.uretimMenusu();
                    break;
                case 5:
                    Util.EkranYokEtme();
                    Finans.finansMenusu();
                    break;
                case 6:
                    Util.EkranYokEtme();
                    System.out.println("Çıkış yapılıyor...");
                    return;
                default:
                    Util.EkranYokEtme();
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }

    
    
}
