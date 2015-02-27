/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eg4n
 */
public class database {
    public final String driver = "com.mysql.jdbc.Driver";
    public final String url = "jdbc:mysql://localhost/db_apotek";
    public final String userName = "root";
    public final String passWord = "";
    public static int Tempo;
    public static String ad;
    public static String kas;
    public static String kas1;
    
    public void setUser(int tempo) {
        Tempo=tempo;
    }
    public static int getTemp() {
        return Tempo;
    }
   

    public boolean cari_login(String username, String password) {
   
        Boolean temp=false;
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userName, passWord);
            stmt = con.createStatement();
            String status="admin";
            String sql = "select * from user";
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next() && !temp) {
                    temp = username.equals(rs.getString("user")) && password.equals(rs.getString("pass")) && status.equals(rs.getString("Sebagai"));
                    int tempo=rs.getInt("id_user");
                    setUser(tempo);
                    ad=rs.getString("user");


                }
               
               
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.out.println("message "+e.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            } try {
                con.close();
            } catch (Exception e) {}
        }
        return temp;
    }

    public boolean cari_login_kasir(String username, String password) {

        Boolean temp1=false;
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userName, passWord);
            stmt = con.createStatement();
            String status="kasir";
            String sql = "select * from user";
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    temp1 = username.equals(rs.getString("user")) && password.equals(rs.getString("pass")) && status.equals(rs.getString("sebagai"));
                    kas=rs.getString("user");
                    kas1=String.valueOf(rs.getString("id_user"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.out.println("message "+e.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            } try {
                con.close();
            } catch (Exception e) {}
        }
        return temp1;
    }
    
   
    
    public ArrayList<apotek_a> tampil_data() {
        ArrayList<apotek_a> apo = new ArrayList<apotek_a>();
        Connection conn = null;
        Statement stm = null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url, userName, passWord);
            stm=conn.createStatement();
            String sql = "select * from user";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
               apo.add(new apotek_a(rs.getInt("id_user"),rs.getString("id_karyawan"),rs.getString("user"), rs.getString("pass"), rs.getString("sebagai")));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        } finally {
            try {stm.close();} catch (Exception e){};
            try {conn.close();} catch (Exception e){};
        }
        
        return apo;
    }
     public void update_apotek(apotek_a a) throws ClassNotFoundException, SQLException {
     Connection conn = null;
     Statement stm = null;
     
     try {
         Class.forName(driver);
         conn = DriverManager.getConnection(url, userName, passWord);
         stm=conn.createStatement();
         String sql="Update user set user='"+a.getUser()+"',pass='"+a.getPass()+"', sebagai='"+a.getSebagai()+"' where id_user="+a.getId()+"";
         stm.executeUpdate(sql);
     } catch (Exception e) {
            System.out.println("Error :"+e.getMessage());
        } finally {
            try {stm.close();}catch (Exception e){}
            try {conn.close();} catch (Exception e) {}
        }
   };
    
   public apotek_a pilih_1_user(int id) {
       apotek_a a =null;
       Connection conn = null;
       Statement stm = null;
       try {
           Class.forName(driver);
           conn = DriverManager.getConnection(url, userName, passWord);
           stm = conn.createStatement();
           String sql="select * from user where id_user="+id+"";
           ResultSet rs = stm.executeQuery(sql);
           if(rs.next()) {
               a = new apotek_a(rs.getInt("id_user"),rs.getString("id_karyawan"), rs.getString("user"), rs.getString("pass"), rs.getString("sebagai"));
               
           } else {
               a=null;
           }
           rs.close();
       }  catch (Exception e) {
            System.out.println("Error :"+e.getMessage());
        } finally {
            try {stm.close();}catch (Exception e){}
            try {conn.close();} catch (Exception e) {}
        }
       return a;
   }
   
   public void hapus_user(int id) throws ClassNotFoundException, SQLException {
       Connection conn=null;
       Statement stm=null;
       
       try {
           Class.forName(driver);
           conn=DriverManager.getConnection(url, userName, passWord);
           stm = conn.createStatement();
           String sql= "delete from user where id_user="+id+"";
           stm.executeUpdate(sql);
       } catch (Exception e) {
            System.out.println("Error :"+e.getMessage());
        } finally {
            try {stm.close();}catch (Exception e){}
            try {conn.close();} catch (Exception e) {}
        }
   };
   
   
   //untuk data karyawan
    public void simpan_data(apotek_k a) throws SQLException, ClassNotFoundException {
        Connection conn =null;
        Statement stm = null;
        
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url, userName, passWord);
            stm = conn.createStatement();
            String sql;
            sql = "insert into karyawan values('"+a.getId_karyawan()+"','"+a.getNama()+"','"+a.getAlamat()+"','"+a.getNo_telp()+"')";
            stm.executeUpdate(sql);
            
        } catch (Exception e) {System.out.println("Error :"+e.getMessage());}
        finally {
            try {stm.close();} catch (Exception e){}
            try {conn.close();} catch (Exception e){}
            
        }
    };
    
    public ArrayList<apotek_k> tampil_data_Karyawan() {
        ArrayList<apotek_k> apo = new ArrayList<apotek_k>();
        Connection conn = null;
        Statement stm = null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url, userName, passWord);
            stm=conn.createStatement();
            String sql = "select * from karyawan";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
               apo.add(new apotek_k(rs.getString("id_karyawan"), rs.getString("nama"), rs.getString("alamat"), rs.getString("no_telp")));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        } finally {
            try {stm.close();} catch (Exception e){};
            try {conn.close();} catch (Exception e){};
        }
        
        return apo;
    }
    
    public apotek_k pilih_1_karyawan(String id_karyawan) {
       apotek_k a =null;
       Connection conn = null;
       Statement stm = null;
       try {
           Class.forName(driver);
           conn = DriverManager.getConnection(url, userName, passWord);
           stm = conn.createStatement();
           String sql="select * from karyawan where id_karyawan='"+id_karyawan+"'";
           ResultSet rs = stm.executeQuery(sql);
           if(rs.next()) {
               a = new apotek_k(rs.getString("id_karyawan"), rs.getString("nama"),rs.getString("alamat"), rs.getString("no_telp"));
               
           } else {
               a=null;
           }
           rs.close();
       }  catch (Exception e) {
            System.out.println("Error :"+e.getMessage());
        } finally {
            try {stm.close();}catch (Exception e){}
            try {conn.close();} catch (Exception e) {}
        }
       return a;
   }
    
    public void update_karyawan(apotek_k a) throws ClassNotFoundException, SQLException {
     Connection conn = null;
     Statement stm = null;
     
     try {
         Class.forName(driver);
         conn = DriverManager.getConnection(url, userName, passWord);
         stm=conn.createStatement();
         String sql="Update karyawan set nama='"+a.getNama()+"',alamat='"+a.getAlamat()+"',no_telp='"+a.getNo_telp()+"' where id_karyawan='"+a.getId_karyawan()+"'";
         stm.executeUpdate(sql);
     } catch (Exception e) {
            System.out.println("Error :"+e.getMessage());
        } finally {
            try {stm.close();}catch (Exception e){}
            try {conn.close();} catch (Exception e) {}
        }
   };
    
    public void hapus_karyawan(String id) throws ClassNotFoundException, SQLException {
       Connection conn=null;
       Statement stm=null;
       
       try {
           Class.forName(driver);
           conn=DriverManager.getConnection(url, userName, passWord);
           stm = conn.createStatement();
           String sql= "delete from karyawan where id_karyawan='"+id+"'";
           stm.executeUpdate(sql);
       } catch (Exception e) {
            System.out.println("Error :"+e.getMessage());
        } finally {
            try {stm.close();}catch (Exception e){}
            try {conn.close();} catch (Exception e) {}
        }
   };
    //aksi membuat user
    public void simpan_data_user(apotek_a b) throws SQLException, ClassNotFoundException {
        Connection conn =null;
        Statement stm = null;
        
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url, userName, passWord);
            stm = conn.createStatement();
            String sql;
            sql = "insert into user values(null,'"+b.getIdKaryawan()+"','"+b.getUser()+"','"+b.getPass()+"','"+b.getSebagai()+"')";
            stm.executeUpdate(sql);
            
        } catch (Exception e) {System.out.println("Error :"+e.getMessage());}
        finally {
            try {stm.close();} catch (Exception e){}
            try {conn.close();} catch (Exception e){}
            
        }
    };
   
    //untuk barang
   public ArrayList<apotek_o> tampil_data_barang() {
        ArrayList<apotek_o> apo = new ArrayList<apotek_o>();
        Connection conn = null;
        Statement stm = null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url, userName, passWord);
            stm=conn.createStatement();
            String sql = "select * from barang";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
               apo.add(new apotek_o(rs.getString("id_barang"), rs.getString("nama_barang"), rs.getString("satuan_barang"), rs.getInt("jumlah_barang"), rs.getInt("harga_beli"), rs.getInt("harga_jual"),rs.getString("supplier"), rs.getString("detail_barang")));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        } finally {
            try {stm.close();} catch (Exception e){};
            try {conn.close();} catch (Exception e){};
        }
        
        return apo;
    }
   
    public apotek_o pilih_1_barang(String id_barang) {
       apotek_o a =null;
       Connection conn = null;
       Statement stm = null;
       try {
           Class.forName(driver);
           conn = DriverManager.getConnection(url, userName, passWord);
           stm = conn.createStatement();
           String sql="select * from barang where id_barang='"+id_barang+"'";
           ResultSet rs = stm.executeQuery(sql);
           if(rs.next()) {
               a = new apotek_o(rs.getString("id_barang"), rs.getString("nama_barang"), rs.getString("satuan_barang"), rs.getInt("jumlah_barang"), rs.getInt("harga_beli"), rs.getInt("harga_jual"),rs.getString("supplier"), rs.getString("detail_barang"));
               
           } else {
               a=null;
           }
           rs.close();
       }  catch (Exception e) {
            System.out.println("Error :"+e.getMessage());
        } finally {
            try {stm.close();}catch (Exception e){}
            try {conn.close();} catch (Exception e) {}
        }
       return a;
   }
    
    public void update_Barang(apotek_o a) throws ClassNotFoundException, SQLException {
     Connection conn = null;
     Statement stm = null;
     
     try {
         Class.forName(driver);
         conn = DriverManager.getConnection(url, userName, passWord);
         stm=conn.createStatement();
         String sql="Update barang set nama_barang='"+a.getNamabarang()+"',satuan_barang='"+a.getSatuan_barang()+"',jumlah_barang='"+a.getJumlah_barang()+"',harga_beli="+a.getHarga_beli()+",harga_jual="+a.getHarga_jual()+",supplier='"+a.getSuplier()+"',detail_barang='"+a.getDetail_barang()+"' where id_barang='"+a.getId_barang()+"'";
         stm.executeUpdate(sql);
     } catch (Exception e) {
            System.out.println("Error :"+e.getMessage());
        } finally {
            try {stm.close();}catch (Exception e){}
            try {conn.close();} catch (Exception e) {}
        }
   };
    
    public void simpan_data_barang(apotek_o a) throws SQLException, ClassNotFoundException {
        Connection conn =null;
        Statement stm = null;
        
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url, userName, passWord);
            stm = conn.createStatement();
            String sql;
            sql = "insert into barang values('"+a.getId_barang()+"','"+a.getNamabarang()+"','"+a.getSatuan_barang()+"',"+a.getJumlah_barang()+","+a.getHarga_beli()+","+a.getHarga_jual()+",'"+a.getSuplier()+"','"+a.getDetail_barang()+"')";
            stm.executeUpdate(sql);
            
        } catch (Exception e) {System.out.println("Error :"+e.getMessage());}
        finally {
            try {stm.close();} catch (Exception e){}
            try {conn.close();} catch (Exception e){}
            
        }
    };
    
     public void hapus_barang(String id) throws ClassNotFoundException, SQLException {
       Connection conn=null;
       Statement stm=null;
       
       try {
           Class.forName(driver);
           conn=DriverManager.getConnection(url, userName, passWord);
           stm = conn.createStatement();
           String sql= "delete from barang where id_barang='"+id+"'";
           stm.executeUpdate(sql);
       } catch (Exception e) {
            System.out.println("Error :"+e.getMessage());
        } finally {
            try {stm.close();}catch (Exception e){}
            try {conn.close();} catch (Exception e) {}
        }
   };
     
     //untuk histori barang
     public void simpan_histori_barang(apotek_barang_masuk a) throws SQLException, ClassNotFoundException {
        Connection conn =null;
        Statement stm = null;
        
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url, userName, passWord);
            stm = conn.createStatement();
            String sql;
            sql = "insert into barang_masuk values(null,'"+a.getIdbarang()+"',"+a.getIduser()+",'"+a.getTanggal()+"',"+a.getJml_barang_masuk()+")";
            stm.executeUpdate(sql);
            
        } catch (Exception e) {System.out.println("Error :"+e.getMessage());}
        finally {
            try {stm.close();} catch (Exception e){}
            try {conn.close();} catch (Exception e){}
            
        }
    };
     
     public ArrayList<apotek_barang_masuk> tampil_data_log() {
        ArrayList<apotek_barang_masuk> apo = new ArrayList<apotek_barang_masuk>();
        Connection conn = null;
        Statement stm = null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url, userName, passWord);
            stm=conn.createStatement();
            String sql = "select * from barang_masuk";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
               apo.add(new apotek_barang_masuk(rs.getInt("no_barangmasuk"), rs.getString("id_barang"), rs.getInt("id_user"), rs.getString("tanggal_barangmasuk"), rs.getInt("jumlah_barangmasuk")));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        } finally {
            try {stm.close();} catch (Exception e){};
            try {conn.close();} catch (Exception e){};
        }
        
        return apo;
    }
     
    public ArrayList<apotek_o> filter_Barang_id(String keyword) {
   
       ArrayList<apotek_o> listBarang = new ArrayList<apotek_o>();
       Connection conn = null;
       Statement stm = null;
       
       try {
           Class.forName(driver);
           conn = DriverManager.getConnection(url, userName, passWord);
           stm=conn.createStatement();
           String sql = "select * from barang where id_barang like '%"+keyword+"%'";
           ResultSet rs=stm.executeQuery(sql);
           while (rs.next()) {
               listBarang.add(new apotek_o(rs.getString("id_barang"), rs.getString("nama_barang"), rs.getString("satuan_barang"), rs.getInt("jumlah_barang"), rs.getInt("harga_beli"), rs.getInt("harga_jual"),rs.getString("supplier"), rs.getString("detail_barang")));
               
           }
           rs.close();
       }  catch (Exception e) {
            System.out.println("Error :"+e.getMessage());
        } finally {
            try {stm.close();}catch (Exception e){}
            try {conn.close();} catch (Exception e) {}
        }
       return listBarang;
   }
    
    public ArrayList<apotek_o> filter_Barang_nama(String keyword) {
   
       ArrayList<apotek_o> listBarang = new ArrayList<apotek_o>();
       Connection conn = null;
       Statement stm = null;
       
       try {
           Class.forName(driver);
           conn = DriverManager.getConnection(url, userName, passWord);
           stm=conn.createStatement();
           String sql = "select * from barang where nama_barang like '%"+keyword+"%'";
           ResultSet rs=stm.executeQuery(sql);
           while (rs.next()) {
               listBarang.add(new apotek_o(rs.getString("id_barang"), rs.getString("nama_barang"), rs.getString("satuan_barang"), rs.getInt("jumlah_barang"), rs.getInt("harga_beli"), rs.getInt("harga_jual"),rs.getString("supplier"), rs.getString("detail_barang")));
               
           }
           rs.close();
       }  catch (Exception e) {
            System.out.println("Error :"+e.getMessage());
        } finally {
            try {stm.close();}catch (Exception e){}
            try {conn.close();} catch (Exception e) {}
        }
       return listBarang;
   }
    
      public ArrayList<apotek_o> filter_Barang_suplier(String keyword) {
   
       ArrayList<apotek_o> listBarang = new ArrayList<apotek_o>();
       Connection conn = null;
       Statement stm = null;
       
       try {
           Class.forName(driver);
           conn = DriverManager.getConnection(url, userName, passWord);
           stm=conn.createStatement();
           String sql = "select * from barang where supplier like '%"+keyword+"%'";
           ResultSet rs=stm.executeQuery(sql);
           while (rs.next()) {
               listBarang.add(new apotek_o(rs.getString("id_barang"), rs.getString("nama_barang"), rs.getString("satuan_barang"), rs.getInt("jumlah_barang"), rs.getInt("harga_beli"), rs.getInt("harga_jual"),rs.getString("supplier"), rs.getString("detail_barang")));
               
           }
           rs.close();
       }  catch (Exception e) {
            System.out.println("Error :"+e.getMessage());
        } finally {
            try {stm.close();}catch (Exception e){}
            try {conn.close();} catch (Exception e) {}
        }
       return listBarang;
   }
}
