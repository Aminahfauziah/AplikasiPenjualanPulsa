/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pulsa;

/**
 *
 * @author acer
 */
public class test {
    public String hitung(String hargaA, String SaldoA)
 {  
      String beli ,saldo;
      int hasil=0;
      beli = hargaA;
      saldo= SaldoA;
      int b = Integer.parseInt(beli);
      int s = Integer.parseInt(saldo);
      hasil = s-b;
      String hasill= Integer.toString(hasil);
      return hasill;
      
 }
}
