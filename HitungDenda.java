package com.rizmakiana;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class HitungDenda {
    public static void main(String[] args) throws ParseException {
        clearScreen();
        
        String nama = input("Nama Peminjam  ");
        String id = input("ID Peminjam    ");
        String tglPinjam = input("Tanggal Pinjam ");

        hitungDenda(nama, id, tglPinjam);

    }

    static final String format = "dd/MM/yyyy";
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
    static Scanner scanner;
    static final int maksHariPinjam = 10;
    static final int denda = 350_000;

    public static String input(String message) {
        scanner = new Scanner(System.in);

        System.out.print(message + " : ");
        return scanner.next();
    }

    public static void hitungDenda(String name, String id, String tanggal) throws ParseException {

        LocalDate tglPinjam = LocalDate.parse(tanggal, DateTimeFormatter.ofPattern(format));
        LocalDate tglHarusKembali = tglPinjam.plusDays(maksHariPinjam);
        LocalDate sekarang = LocalDate.now();

        long days = ChronoUnit.DAYS.between(tglHarusKembali, sekarang);
        long bedaHari = (days > 0) ? days : 0 ;

        clearScreen();
        System.out.println("Nama Peminjam       : " + name);
        System.out.println("ID Peminjam         : " + id);
        System.out.println("Tanggal Pinjam      : " + tglPinjam.format(formatter));
        System.out.println("Tanggal kembali     : " + tglHarusKembali.format(formatter));
        System.out.println("Tanggal dibalikan   : " + sekarang.format(formatter));

        System.out.println("\nSelisih Hari        : " + bedaHari);
        showCharge(bedaHari);

    }

    public static void showCharge(long days) {
        long charge = days * denda;
        if (days > 0) {
            System.out.println("Total denda         : " + idr(charge));
        }
    }

    public static String idr(long charges) {
        Locale localId = new Locale("in", "ID");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(localId);
        return formatter.format(charges);
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
