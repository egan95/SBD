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
public class apotekTabelModelK extends AbstractTableModel{
    private ArrayList<apotek_k> data;
    
    public void setData(ArrayList<apotek_k> data) {
        this.data=data;
    }
    
    private String[] kolom ={"Id Pegawai","Nama","Alamat","No. Telp"};
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
        apotek_k l = data.get(baris);
        switch(kolom) {
          
            case 0 : return l.getId_karyawan();
            case 1 : return l.getNama();
            case 2 : return l.getAlamat();
            case 3 : return l.getNo_telp();
            default: return null;
                
        }
    }
    @Override
    public String getColumnName(int column) {
		return kolom[column];
	}
    
}
