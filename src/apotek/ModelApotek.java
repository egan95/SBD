/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek;

/**
 *
 * @author Compaq
 */
public class ModelApotek {
    private String id_barang;
    private String Nama_Barang;
    private String Satuan_Barang;
    private int Jumlah_Barang;
    private int Harga_Beli;
    private int Harga_Jual;
    private String Supplier;
    private String Detail_Barang;
    
    public void setid_barang(String idbar){
        id_barang = idbar;
    }
    public void setNama_Barang(String nabar){
        Nama_Barang = nabar;
    }
    public void setSatuan_Barang(String sabar){
        Satuan_Barang = sabar;
    }
    public void setJumlah_Barang(int jumbar){
        Jumlah_Barang = jumbar;
    }
    public void setHarga_Beli(int habel){
        Harga_Beli = habel;
    }
    public void setHarga_Jual(int hajul){
        Harga_Jual = hajul;
    }
    public void setSupplier(String supp){
        Supplier = supp;
    }
    public void setDetail_Barang(String debar){
        Detail_Barang = debar;
    }
    
    public String getid_barang(){
        return id_barang;
    }
    public String getNama_Barang(){
        return Nama_Barang;
    }
    public String getSatuan_Barang(){
        return Satuan_Barang;
    }
    public int getJumlah_Barang(){
        return Jumlah_Barang;
    }
    public int getHarga_Beli(){
        return Harga_Beli;
    }
    public int getHarga_Jual(){
        return Harga_Jual;
    }
    public String getSupplier(){
        return Supplier;
    }
    public String getDetail_Barang(){
        return Detail_Barang;
    }
    
    public ModelApotek(String idbar, String nabar, String sabar, int jumbar, int habel, int hajul, String supp, String debar){
        setid_barang(idbar);
        setNama_Barang(nabar);
        setSatuan_Barang(sabar);
        setJumlah_Barang(jumbar);
        setHarga_Beli(habel);
        setHarga_Jual(hajul);
        setSupplier(supp);
        setDetail_Barang(debar);
    }
    
}
