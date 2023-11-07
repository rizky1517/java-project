import java.io.*;

import util.Clear;

public class Main {
    public static void main(String[] args) {
        Clear.Screen();
        
        String alamat = "D:\\kampus\\SEMESTER - (3)\\Pemrograman 3\\Tugas\\uts\\src\\util\\datauts.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(alamat);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            System.out.println("+==================================================================+");
            System.out.println("| No Rek |  Nama Nasabah  | Saldo Awal |    Bunga    | Saldo Akhir |");
            System.out.println("+==================================================================+");

            while (dataInputStream.available() != 0) {
                String data = dataInputStream.readLine();

                String norek = data.substring(0,4);
                String nama = data.substring(13);
                int saldo = Integer.parseInt(data.substring(5, 12));
                double bunga = 0;

                if (saldo >= 5_000_000) {
                    bunga = 5 * saldo / 100;
                } else if (saldo >= 3_000_000){
                    bunga = 3 * saldo /100;
                } else if (saldo >= 1_000_000){
                    bunga = 1.5 * saldo /100;
                } else {
                    bunga = 0;
                }
                double saldoAkhir = saldo + bunga;
                System.out.printf("| %6s | %14s | %10d | %8.0f.00 | %8.0f.00 |\n",norek,nama,saldo,bunga,saldoAkhir);
                // System.out.printf("| %6s | %14s | %10d |\n",norek,nama,saldo);
            
            }
            System.out.println("+==================================================================+");


            dataInputStream.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Ada Kesalahan");
        }
    }
}
