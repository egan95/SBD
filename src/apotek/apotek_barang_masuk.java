/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek;

/**
 *
 * @author eg4n
 */
public class apotek_barang_masuk {
    private String Id_barang;
    private int Id_user;
    private int Jml_barang_masuk;
    private int Id_barang_masuk;
    private String Tanggal;
    
    public void setIdBarangmasuk(int id_barang_masuk) { Id_barang_masuk=id_barang_masuk; }
    public void setIduser(int id_user) { Id_user=id_user; }
    public void setJumlah(int jumlah) {Jml_barang_masuk=jumlah;}
    public void setIdbarang(String id_barang) { Id_barang=id_barang; }
    public void setTanggal (String tanggal) {Tanggal=tanggal;}

    public int getId_barangmasuk() {return Id_barang_masuk;}
    public String getIdbarang() {return Id_barang;}
    public int getIduser() {return Id_user;}
    public String getTanggal() {return Tanggal;}
    public int getJml_barang_masuk() {return Jml_barang_masuk;}
    
    public apotek_barang_masuk(int id_barang_masuk,String id_barang, int id_user, String tanggal, int jml_barang_masuk) {
        setIdBarangmasuk(id_barang_masuk);
        setIdbarang(id_barang);
        setIduser(id_user);
        setTanggal(tanggal);
        setJumlah(jml_barang_masuk);
    }
    
}
