import java.util.ArrayList;

public class UretimVeVerimlilik {

    private static ArrayList<Integer> gunlukSutUretimi = new ArrayList<>();
    private static ArrayList<Integer> haftalikSutUretimi = new ArrayList<>();
    private static ArrayList<Integer> aylikSutUretimi = new ArrayList<>();

   
    private static ArrayList<Integer> gunlukYumurtaUretimi = new ArrayList<>();
    private static ArrayList<Integer> haftalikYumurtaUretimi = new ArrayList<>();
    private static ArrayList<Integer> aylikYumurtaUretimi = new ArrayList<>();


    private static ArrayList<String> digerUrunlerListesi = new ArrayList<>();
    private static ArrayList<Integer> digerUrunlerUretimMiktari = new ArrayList<>();

    public static void uretimMenusu() {
        System.out.println("--- ÜRETİM VE VERİMLİLİK MENÜSÜ ---");
        System.out.println("1. Süt Üretimi");
        System.out.println("2. Yumurta Üretimi");
        System.out.println("3. Diğer Ürünler");
        System.out.println("4. Ana Menüye Dön");
        System.out.print("Bir seçenek seçin: ");
        int secim = Util.readInt();

        switch (secim) {
            case 1:
                sutUretimiIslemleri();
                break;
            case 2:
                yumurtaUretimiIslemleri();
                break;
            case 3:
                digerUrunlerIslemleri();
                break;
            case 4:
                return; 
            default:
                System.out.println("Geçersiz Seçim");
                uretimMenusu();
        }
    }

  
    private static void sutUretimiIslemleri() {
        System.out.println("Süt Üretimi Kayıtları");
        System.out.println("1. Günlük Üretim Kaydet");
        System.out.println("2. Haftalık Üretim Kaydet");
        System.out.println("3. Aylık Üretim Kaydet");
        System.out.println("4. Geri Dön");
        int secim = Util.readInt();

        switch (secim) {
            case 1:
                gunlukSutUretimi.add(Util.readInt());
                System.out.println("Günlük süt üretimi kaydedildi.");
                break;
            case 2:
                haftalikSutUretimi.add(Util.readInt());
                System.out.println("Haftalık süt üretimi kaydedildi.");
                break;
            case 3:
                aylikSutUretimi.add(Util.readInt());
                System.out.println("Aylık süt üretimi kaydedildi.");
                break;
            case 4:
                uretimMenusu();
                return;
            default:
                System.out.println("Geçersiz Seçim");
                sutUretimiIslemleri();
        }

        uretimMenusu();
    }


    private static void yumurtaUretimiIslemleri() {
        System.out.println("Yumurta Üretimi Kayıtları");
        System.out.println("1. Günlük Üretim Kaydet");
        System.out.println("2. Haftalık Üretim Kaydet");
        System.out.println("3. Aylık Üretim Kaydet");
        System.out.println("4. Geri Dön");
        int secim = Util.readInt();

        switch (secim) {
            case 1:
                gunlukYumurtaUretimi.add(Util.readInt());
                System.out.println("Günlük yumurta üretimi kaydedildi.");
                break;
            case 2:
                haftalikYumurtaUretimi.add(Util.readInt());
                System.out.println("Haftalık yumurta üretimi kaydedildi.");
                break;
            case 3:
                aylikYumurtaUretimi.add(Util.readInt());
                System.out.println("Aylık yumurta üretimi kaydedildi.");
                break;
            case 4:
                uretimMenusu();
                return;
            default:
                System.out.println("Geçersiz Seçim");
                yumurtaUretimiIslemleri();
        }

        uretimMenusu();
    }

    private static void digerUrunlerIslemleri() {
        System.out.println("Diğer Ürünler Kayıtları");
        System.out.println("1. Ürün Ekleyin");
        System.out.println("2. Üretim Miktarı Kaydedin");
        System.out.println("3. Geri Dön");
        int secim = Util.readInt();

        switch (secim) {
            case 1:
                System.out.print("Ürün Adı: ");
                digerUrunlerListesi.add(Util.readString());
                System.out.println("Ürün eklendi.");
                break;
            case 2:
                System.out.print("Üretim Miktarı: ");
                digerUrunlerUretimMiktari.add(Util.readInt());
                System.out.println("Üretim miktarı kaydedildi.");
                break;
            case 3:
                uretimMenusu();
                return;
            default:
                System.out.println("Geçersiz Seçim");
                digerUrunlerIslemleri();
        }

        uretimMenusu();
    }
}
