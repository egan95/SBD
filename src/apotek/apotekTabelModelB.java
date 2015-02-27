/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author eg4n
 */
public class apotekTabelModelB extends AbstractTableModel{
    
    private ArrayList<apotek_o> data;
    
    public void setData(ArrayList<apotek_o> data) {
        this.data=data;
    }
    
    private String[] kolom ={"Id Barang","Nama Barang ","Satuan","Jumlah","Harga beli","Harga jual","Suplier","Detail barang"};
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        apotek_o l = data.get(baris);
        switch(kolom) {
          
            case 0 : return l.getId_barang();
            case 1 : return l.getNamabarang();
            case 2 : return l.getSatuan_barang();
            case 3 : return l.getJumlah_barang();
            case 4 : return l.getHarga_beli();
            case 5 : return l.getHarga_jual();
            case 6 : return l.getSuplier();
            case 7 : return l.getDetail_barang();
            default: return null;
                
        }
    }
    
    public String getColumnName(int column) {
        return kolom[column];
    }
    
}
