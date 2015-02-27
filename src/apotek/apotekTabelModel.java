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
public class apotekTabelModel extends AbstractTableModel{
    
    private ArrayList<apotek_a> data;
    
    public void setData(ArrayList<apotek_a> data) {
        this.data=data;
    }
    
    private String[] kolom ={"Id user","Id Karyawan","User","Pass","Sebagai"};

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
        apotek_a l = data.get(baris);
        switch(kolom) {
          
            case 0 : return l.getId();
            case 1 : return l.getIdKaryawan();
            case 2 : return l.getUser();
            case 3 : return l.getPass();
            case 4 : return l.getSebagai();
            default: return null;
                
        }
    }
    
    @Override
     public String getColumnName(int column) {
		return kolom[column];
	}
    
}
