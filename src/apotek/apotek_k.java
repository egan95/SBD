/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek;

import javax.swing.JTextField;

/**
 *
 * @author eg4n
 */
public class apotek_k {
    private String Id_karyawan;
    private String Nama;
    private String Alamat;
    private String No_telp;



    
    public void setId_karyawan(String id_karyawan) { Id_karyawan=id_karyawan; }
    public void setNama(String nama) { Nama=nama; }
    public void setAlamat(String alamat) {Alamat=alamat;}
    public void setNo_telp(String no_telp) { No_telp=no_telp; }

    public String getId_karyawan() {return Id_karyawan;}
    public String getNama() {return Nama;}
    public String getAlamat() {return Alamat;}
    public String getNo_telp() {return No_telp;}
    
    public apotek_k(String id_karyawan,String nama, String alamat, String no_telp) {
        setId_karyawan(id_karyawan);
        setNama(nama);
        setAlamat(alamat);
        setNo_telp(no_telp);
    }
    
}
