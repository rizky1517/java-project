import java.util.Scanner;
import util.*;

public class Main {
    public static void main(String[] args) {
        Clear.Screen();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukan jari-jari bola : ");
        double jari2 = scanner.nextDouble();
        scanner.close();

        double hasil = (4 * Math.PI * Math.pow(jari2, 3) / 3);
        System.out.printf("\nVolume Bola dengan jari-jari %.2f adalah %.2f cm2",jari2,hasil);
        
    }
    
}
