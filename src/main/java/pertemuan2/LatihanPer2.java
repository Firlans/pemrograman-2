/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan2;

import java.util.Scanner;

/**
 *
 * @author mr_tech
 */
public class LatihanPer2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String namaKasir, caraBayar, validation;
        DataBarang[] barang = new DataBarang[10];
        boolean jual = true;
        int index = 0;
        String[] metodePembayaran = {"Visa-Debit", "Debit", "Cash"};
        double jumlahBayar = 0, totalBayar = 0, diskon = 5, PPN = 10, visaMaster = 3;
        System.out.print("Nama Kasir \t: ");
        namaKasir = input.nextLine();
        
        do{
            int bayar;
            barang[index] = new DataBarang();
            System.out.println("barang "+ index+1);
            System.out.print("Kode Barang \t: ");
            barang[index].setKodeBarang(input.nextLine());
            System.out.print("Nama Barang \t: ");
            barang[index].setNamaBarang(input.nextLine());
            System.out.print("Jumlah Beli \t: ");
            barang[index].setJumlahBeli(input.nextInt());
            System.out.print("Harga Barang \t: ");
            barang[index].setHargaBarang(input.nextInt());
            bayar = barang[index].getHargaBarang() * barang[index].getJumlahBeli();
            barang[index].setBayar(bayar);
            
            index++;
            System.out.print("Tambah Lagi (Y/n) ?");
            input.nextLine();
            validation = input.nextLine();
            if ("n".equalsIgnoreCase(validation)) {
                break; // Keluar dari loop jika pengguna memilih "n" atau "N"
            }
        }while("Y".equalsIgnoreCase(validation));     
        
        for (int i=0; i<index; i++) {
            jumlahBayar += barang[i].getBayar();
        }
        
        if(jumlahBayar >= 500000){
            totalBayar = jumlahBayar - (jumlahBayar * diskon/100);
        }else{
            totalBayar = jumlahBayar;
        }
        
        
        totalBayar += (PPN*totalBayar/100);
        System.out.println("Visa-Master = 1\n"
                + "Debit = 2\n"
                + "Cash = 3\n"
                + "Tentukan Cara Bayar : ");
        caraBayar = input.next();
        if(caraBayar.equals("1")){
            totalBayar += visaMaster * totalBayar / 100;
        }
        
        
        System.out.println("DATA PENJUALAN BARANG\n PT \"PAMULANG TAMA\"\n "
                + "Nama Kasir:" + namaKasir);
        System.out.println("===============================================================================================");
        System.out.println("No.\t|Kode Barang\t|Nama Barang\t|Harga Barang\t|Jumlah Beli\t|Bayar");
        System.out.println("===============================================================================================");
        index = 0;
        for(DataBarang barangTerjual : barang ){
            if(barangTerjual != null){
                System.out.print(index+1 + "\t");
                System.out.print(barangTerjual.getKodeBarang()+"\t\t");
                System.out.print(barangTerjual.getNamaBarang()+"\t\t");
                System.out.print(barangTerjual.getHargaBarang()+"\t");
                System.out.print(barangTerjual.getJumlahBeli()+"\t\t");
                System.out.print(barangTerjual.getBayar()+"\t\n");
                index++;
            }
        }
        
        System.out.println("Jumlah Bayar \t: "+ jumlahBayar);
        System.out.println("diskon \t: " + diskon + "%");
        System.out.println("PPN \t: " + PPN*totalBayar/100);
        System.out.println("Cara Bayar \t: " + caraBayar);
        System.out.println("Total Bayar \t: " +  totalBayar);
    }
}
