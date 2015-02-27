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
public class apotek_o {
    private String Id_barang;
    private String Nama_barang;
    private String Satuan_barang;
    private int Jumlah_barang;
    private int Harga_beli;
    private int Harga_jual;
    private String Suplier;
    private String Detail_barang;

    
    public void setId_barang(String id_barang) { Id_barang=id_barang; }
    public void setNamabarang(String nama_barang) { Nama_barang=nama_barang; }
    public void setSatuan(String satuan_barang) {Satuan_barang=satuan_barang;}
    public void setJumlah_barang(int jumlah_barang) { Jumlah_barang=jumlah_barang; }
    public void setHarga_beli(int harga_beli) { Harga_beli=harga_beli; }
    public void setHarga_jual(int harga_jual) {Harga_jual=harga_jual ; }
    public void setSuplier(String suplier) { Suplier=suplier; }
    public void setDetail_barang(String detail_barang) { Detail_barang=detail_barang; }

    public String getId_barang() {return Id_barang;}
    public String getNamabarang() {return Nama_barang;}
    public String getSatuan_barang() {return Satuan_barang;}
    public int getJumlah_barang() {return Jumlah_barang;}
    public int getHarga_beli() {return Harga_beli;}
    public int getHarga_jual() {return Harga_jual;}
    public String getSuplier() {return Suplier;}
    public String getDetail_barang() {return Detail_barang;}
    
    public apotek_o(String id_barang,String nama_barang, String satuan_barang, int jumlah_barang, int harga_beli, int harga_jual, String suplier, String detail_barang) {
        setId_barang(id_barang);
        setNamabarang(nama_barang);
        setSatuan(satuan_barang);
        setJumlah_barang(jumlah_barang);
        setHarga_beli(harga_beli);
        setHarga_jual(harga_jual);
        setSuplier(suplier);
        setDetail_barang(detail_barang);
    }
}
