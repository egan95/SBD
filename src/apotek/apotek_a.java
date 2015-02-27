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
public class apotek_a {
    private String User;
    private String Pass;
    private String Id_Karyawan;
    private int Id;
    private String Sebagai;
    
    public void setUser(String user) { User=user; }
    public void setPass(String pass) { Pass=pass; }
    public void setId(int id) {Id=id;}
    public void setIdKaryawan(String id_karyawan) { Id_Karyawan=id_karyawan; }
    public void setSebagai (String sebagai) {Sebagai=sebagai;}

    public int getId() {return Id;}
    public String getUser() {return User;}
    public String getPass() {return Pass;}
    public String getIdKaryawan() {return Id_Karyawan;}
    public String getSebagai() {return Sebagai;}
    
    public apotek_a(int id,String id_karyawan, String user, String pass, String sebagai) {
        setId(id);
        setIdKaryawan(id_karyawan);
        setUser(user);
        setPass(pass);
        setSebagai(sebagai);
    }
    
}
