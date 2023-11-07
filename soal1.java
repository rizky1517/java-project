import util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Clear.Screen();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Jumlah pasien : ");
        int n = scanner.nextInt();

        System.out.println();

        String[][] data = new String[n][5];

        for (int i = 0; i < n; i++) {
            System.out.print("ID Pasien     : ");
            data[i][0] = scanner.next();

            System.out.print("Nama Pasien   : ");
            data[i][1] = scanner.next();

            System.out.print("Kode Kamar    : ");
            data[i][2] = scanner.next();

            System.out.print("Lama Inap     : ");
            data[i][3] = scanner.next();

            int y = Integer.parseInt(data[i][3]);

            if (data[i][2].equals("1")) {
                data[i][4] = String.valueOf(y * 100_000);
            } else if (data[i][2].equals("2")) {
                data[i][4] = String.valueOf(y * 250_000);
            } else if (data[i][2].equals("3")) {
                data[i][4] = String.valueOf(y * 500_000);
            }

            System.out.println();
        }

        scanner.close();
        showReceipt(data, n);

    }

    public static void showReceipt(String[][] x, int y) {
        System.out.println("+=============================================================+");
        System.out.println("|                        RS. TUVWXYZ                          |");
        System.out.println("+=============================================================+");
        System.out.println("| ID Pas | Nama Pasien | Kode Kamar | Lama Inap | Total Biaya |");
        System.out.println("+=============================================================+");

        for (int i = 0; i < y; i++) {
            System.out.printf("| %6s | %11s | %10s | %9s | %8s,00 |\n", x[i][0], x[i][1], x[i][2], x[i][3], x[i][4]);
        }
        System.out.println("+=============================================================+");

    }
}
