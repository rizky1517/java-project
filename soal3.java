import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import util.Clear;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Clear.Screen();

        System.out.print("Input digit terakhir NPM Anda : ");
        int npm = keyboard.nextInt();

        int n = (npm % 2 == 0) ? 4 : 3;
        String a = (npm % 2 == 0) ? "NPM Genap mengisi 4 data" : "NPM Ganjil mengisi 3 data";
        System.out.println(a + "\n");

        String alamat = "D:\\kampus\\SEMESTER - (3)\\Pemrograman 3\\Tugas\\uts\\src\\util\\datauts.txt";

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(alamat);
            PrintStream printStream = new PrintStream(fileOutputStream);

            System.out.println("===================================================");
            for (int i = 0; i < n; i++) {

                String norek, nama, saldo;

                System.out.print("Nama Nasabah : ");
                nama = keyboard.nextLine();
                
                System.out.print("No Rekening  : ");
                norek = keyboard.next();

                System.out.print("Saldo Awal   : ");
                saldo = keyboard.next();

                System.out.println();

                String text = norek.concat("_").concat(saldo).concat("_").concat(nama);
                printStream.println(text);
            
            }
            System.out.println("===================================================");
            System.out.println("Selesai menulis ke File");
            printStream.close();
        } catch (Exception e) {
            // TODO: handle exception
        } finally{
            keyboard.close();
        }
    }
}
