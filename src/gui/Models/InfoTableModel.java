/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Models;

import dao.InfoDaoImpl;
import dao.InfoDaoIntf;
import domain.Info;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author viorel.cojocaru
 */
public class InfoTableModel extends DefaultTableModel {

    InfoDaoIntf infoDao=InfoDaoImpl.getInstance();    
    
    String[] tableTitluri={"Nr","id", "Taguri", "Timp IN", "Timp OUT", 
                           "Commentarii", "Anotimp", "Nume fisier", 
                           "Selectat"};
    
    
    public InfoTableModel() {
        for (int i = 0; i < tableTitluri.length; i++) {
            super.addColumn(tableTitluri[i]);            
        }
    }
    
    public void refreshModel(List<Info> listainfo){        
        super.dataVector.clear();        
        int nr=0;
         
        for(Info info: listainfo){
            Vector rowData=new Vector();            
            rowData.add(++nr);            
            rowData.add(info.getId());
            rowData.add(info.getTags());
            rowData.add(info.getTimpIn());
            rowData.add(info.getTimpOut());
            rowData.add(info.getComments());
            rowData.add(info.getAnotimp());
            String numeleFisier=separaNumeleFisier(info.getFisierNume());
            LOG.info("numeleFisier in add row "+numeleFisier);
            rowData.add(numeleFisier);
            
            super.addRow(rowData);
        }
    }
   
    
   private String separaNumeleFisier(String fisierAdresa){
       
       int i=fisierAdresa.lastIndexOf(separator);
   String numele=fisierAdresa.substring(i+1);
   LOG.info("separator "+separator);
         LOG.info("numele din metoda "+numele);
         return numele;
     
       
    }
    @Override
    public int getRowCount() {
        return super.getRowCount();
    }

    @Override
    public int getColumnCount() {
        return super.getColumnCount();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return super.getColumnName(columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex==8) {
        return Boolean.class;
            
        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex>2) {//nr ordine si Id nu pot fi editate
            return true; 
        } 
        
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         return super.getValueAt(rowIndex, columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
    }
    public String getSelectedInfo(int selectedRow) {       
        String  filePath;     
        Vector v=(Vector)super.getDataVector().get(selectedRow);
        int id=(Integer)v.get(1);        
            filePath=infoDao.findById(id);        
        return filePath;        
    }
     {
        if (System.getProperty("os.name").startsWith("Windows")) {
        // includes: Windows 2000,  Windows 95, Windows 98, Windows NT, Windows Vista, Windows XP
            separator="\\";
    } else {
        // everything else
           separator="/"; 
    } 
    }
     private String separator;//System.getProperty("line.separator").toString();
    private static final Logger LOG = Logger.getLogger(InfoTableModel.class.getName());

}
    

