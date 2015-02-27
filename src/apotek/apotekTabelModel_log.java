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
public class apotekTabelModel_log extends AbstractTableModel{
    private ArrayList<apotek_barang_masuk> data;
    
    public void setData(ArrayList<apotek_barang_masuk> data) {
        this.data=data;
    }

     private String[] kolom ={"Id barang masuk","Id barang","Id_user","Tanggal masuk","Jumlah barang"};
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
       apotek_barang_masuk l = data.get(baris);
        switch(kolom) {
          
            case 0 : return l.getId_barangmasuk();
            case 1 : return l.getIdbarang();
            case 2 : return l.getIduser();
            case 3 : return l.getTanggal();
            case 4 : return l.getJml_barang_masuk();
            default: return null;
                
        }
    }
    
    public String getColumnName(int column) {
		return kolom[column];
	}
    
}
