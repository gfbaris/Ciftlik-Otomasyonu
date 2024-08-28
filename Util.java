import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.*;

public class Util {
    
    public static Scanner scanner = new Scanner(System.in);

   
    public static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Geçersiz giriş. Lütfen bir tam sayı girin.");
            scanner.next();
        }
        return scanner.nextInt();
    }

 
    public static String readString() {
        return scanner.nextLine();
    }

    public static char readChar() {
        return scanner.next().charAt(0);
    }

    public static double readDouble() {
        return scanner.nextDouble();
    }

    public static void klasorAc(String anaKlasorAdi, String altKlasorAdi) {
        File anaKlasor = new File("D:\\" + anaKlasorAdi);
        if (!anaKlasor.exists()) {
            anaKlasor.mkdir();
        }
        
        File altKlasor = new File(anaKlasor, altKlasorAdi);
        if (!altKlasor.exists()) {
            altKlasor.mkdir();
        }
    }

    public static void textDosyaOlustur(String anaKlasorAdi, String altKlasorAdi, String dosyaAdi) {
    
        klasorAc(anaKlasorAdi, altKlasorAdi);

        File dosya = new File("D:\\" + anaKlasorAdi + "\\" + altKlasorAdi + "\\" + dosyaAdi + ".txt");
        try {
           dosya.createNewFile();
        } catch (IOException e) {
            System.out.println("Dosya oluşturulurken bir hata oluştu: " + e.getMessage());
        }
    }

    public static ArrayList<String> textDosyaOku(String dosyaYolu) {
        ArrayList<String> satirlar = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaYolu))) {
            String satir;
            while ((satir = reader.readLine()) != null) {
                satirlar.add(satir);
            }
        } catch (IOException e) {
            System.out.println("Dosya okunurken bir hata oluştu: " + e.getMessage());
        }

        return satirlar;
    }

    public static void EkranYokEtme(){
        try {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
