/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels;

import com.itextpdf.text.DocumentException;
import dao.DataUserImpl;
import dao.InfoDaoImpl;
import domain.Info;
import firescenne.FireScenneStart;
import gui.Models.InfoTableModel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import util.ClassPDFRaport;
import util.EnumCardLayer;

/**
 *
 * @author viorel.cojocaru
 */
public class SarchedPanel extends JPanel {

    private static final Logger LOG = Logger.getLogger(SarchedPanel.class.getName());
    
    private InfoTableModel infoTableModel;
    private InfoDaoImpl infoDao;

    /**
     * Creates new form SarchedPanel
     */
    public SarchedPanel() {
        initComponents();


    }
    FireScenneStart jpanelParent;

    public SarchedPanel(FireScenneStart jpanelParent) {
        initComponents();
        this.jpanelParent = jpanelParent;
        //dimensiuniColoaneTable
        initModels();
    }

    public void enebleButtonEdit(Boolean eneb) {
        jButtonEdit.setEnabled(eneb);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonDelete = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonFind = new javax.swing.JButton();
        jButtonExport = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPaneListaScene = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jButtonDelete.setText("Sterge");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonEdit.setText("Editeaza");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonFind.setText("Cauta");
        jButtonFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFindActionPerformed(evt);
            }
        });

        jButtonExport.setText("Exporta");
        jButtonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonFind)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonExport))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonDelete, jButtonEdit, jButtonExport, jButtonFind});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonFind)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDelete)
                .addGap(35, 35, 35)
                .addComponent(jButtonExport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nr", "id", "Tags", "Time In", "Time Out", "Commentarii", "Nume Fisier", "Printare"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPaneListaScene.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneListaScene, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneListaScene, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        boolean oferaDrepturi;

        int m = jTable1.getRowCount();
        if (m != 0) {
            oferaDrepturi = oferaDrepturiAdmin();
            if (oferaDrepturi) {
                jpanelParent.showCard(EnumCardLayer.EDITABLE);
                int selectedRow = jTable1.getSelectedRow();
                String idStr = jTable1.getValueAt(selectedRow, 1).toString();
                jpanelParent.incarcaDateId(idStr);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Executaţi ''Căutarea''", "Mesaj de informare", JOptionPane.INFORMATION_MESSAGE);

        }


    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFindActionPerformed
        creazaFormaCauta();

    }//GEN-LAST:event_jButtonFindActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        boolean oferaDrepturi;
        int m = jTable1.getRowCount();
        if (m != 0) {
            oferaDrepturi = oferaDrepturiAdmin();
            if (oferaDrepturi) {
                int selectedRow = jTable1.getSelectedRow();
                String idStr = jTable1.getValueAt(selectedRow, 1).toString();
                int id = Integer.parseInt(idStr);
                infoDao.deleteInfo(id);
                deleteRow(selectedRow);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Executaţi ''Căutarea''", "Mesaj de informare", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    public void deleteRow(int rowIndex) {
        if (rowIndex < 0) {
            return;
        }
        TableModel temp = jTable1.getModel();
        DefaultTableModel tm = (DefaultTableModel) temp;
        tm.removeRow(rowIndex);
        jTable1.getTableHeader().resizeAndRepaint();
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int selectedRow = jTable1.getSelectedRow();
        String idStr = jTable1.getValueAt(selectedRow, 1).toString();
        int id = Integer.parseInt(idStr);
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            String filePath = infoDao.findById(id);
            LOG.info("filePath din selectare !!!" + filePath);
            String timeIn = jTable1.getValueAt(selectedRow, 3).toString();
            LOG.info("timeIn=" + timeIn);
            String timeOut = jTable1.getValueAt(selectedRow, 4).toString();
            LOG.info("timeout=" + timeOut);
            jpanelParent.pornesteClipul(filePath, timeIn, timeOut);
            LOG.info("AM PORNIT CLIPUL!!!");
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportActionPerformed

        adaudaTabela();
        Iterator it = listaCuCheckBox.iterator();
        while (it.hasNext()) {
            String value = (String) it.next();
            System.out.println("value " + value);
        }

        exportaPDF(listaCuCheckBox);
        listaCuCheckBox.clear();

    }//GEN-LAST:event_jButtonExportActionPerformed
    List<String> listaCuCheckBox;

 private void adaudaTabela() {
        listaCuCheckBox = new ArrayList<String>();

        StringBuffer sbColumnName = new StringBuffer();
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            sbColumnName.append(jTable1.getColumnName(i) + " | ");
        }
        listaCuCheckBox.add("" + sbColumnName);

        StringBuffer sb;
        int l = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            sb = new StringBuffer();

            if ((Boolean)jTable1.getValueAt(i, 8) == true) {
                ++l;
                LOG.info(" am gasit " + l + " | ");
                for (int col = 1; col < jTable1.getColumnCount() - 1; col++) {
                    LOG.info(jTable1.getValueAt(i, col) + " | ");
                    sb.append(jTable1.getValueAt(i, col) + " | ");
                }
                listaCuCheckBox.add("" + l + " | " + sb);

                LOG.info("\n");
            }
        }
        LOG.info("");

    }

    public String[] getTableData(String delim) {
        String[] data = new String[jTable1.getRowCount()];

        int colCount = jTable1.getColumnCount();
        int rowCount = jTable1.getRowCount();

        //get the row data
        StringBuffer currRow = new StringBuffer();
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount - 1; col++) {
                currRow.append(jTable1.getValueAt(row, col));
                currRow.append(delim);
            }
            data[row] = currRow.toString();
            currRow = new StringBuffer();
        }
        return data;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonExport;
    private javax.swing.JButton jButtonFind;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPaneListaScene;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void creazaFormaCauta() {
        String anotimp = "";
        String anotimpuri = "";
        String taguri = null;

        JLabel jlabelAnotimp = new JLabel("Anotimp");
        JLabel jlabelTags = new JLabel("Cuvint cheie");
        JTextField jTextfieldTags = new JTextField();
        JCheckBox jCheckBoxIarna = new JCheckBox("IARNA");
        JCheckBox jCheckBoxPrimarna = new JCheckBox("PRIMAVARA");
        JCheckBox jCheckBoxVara = new JCheckBox("VARA");
        JCheckBox jCheckBoxToamna = new JCheckBox("TOAMNA");
        jTextfieldTags.setToolTipText("Introduceţi cuvinte separate prin virgulă");

        Object[] ob = {jlabelAnotimp,
            jCheckBoxIarna, jCheckBoxPrimarna, jCheckBoxVara, jCheckBoxToamna,
            jlabelTags, jTextfieldTags};

        int result = JOptionPane.showConfirmDialog(null, ob, "Panou de Căutare ", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            if (jCheckBoxIarna.isSelected()) {
                anotimp = anotimp + jCheckBoxIarna.getText();
            }
            if (jCheckBoxPrimarna.isSelected()) {
                anotimp = anotimp + " , " + jCheckBoxPrimarna.getText();
            }
            if (jCheckBoxVara.isSelected()) {
                anotimp = anotimp + " , " + jCheckBoxVara.getText();
            }
            if (jCheckBoxToamna.isSelected()) {
                anotimp = anotimp + " , " + jCheckBoxToamna.getText();
            }
            anotimpuri = anotimp.trim();
            if (anotimpuri.length() == 0) {
                anotimpuri = "IARNA , PRIMAVARA , VARA , TOAMNA";
            }
            taguri = jTextfieldTags.getText().trim();

            if (taguri.length() != 0) {
                cautaTaguri(taguri, anotimpuri);
            } else {
                JOptionPane.showMessageDialog(null, "Date incorecte \nIntroduceţi date de căutare",
                        "Mesaj de informare", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void cautaTaguri(String taguri, String anotimpuri) {

        List<Info> listainfo = new ArrayList<Info>();
        infoDao = InfoDaoImpl.getInstance();

        LOG.info("\nanotimp=" + anotimpuri + "\n");
        String[] sirTaguri = taguri.split(",");
        String[] sirAnotimpuri = anotimpuri.split(",");

        for (int i = 0; i < sirTaguri.length; i++) {
            String verificTaguri = sirTaguri[i].trim();
            for (int j = 0; j < sirAnotimpuri.length; j++) {
                String verificAnotimp = sirAnotimpuri[j].trim();
                listainfo.addAll(infoDao.findByTag(verificTaguri, verificAnotimp));
                LOG.info("\n\n\n" + listainfo.toString());
            }
        }
        introduInTabela(listainfo);
    }

    private void initModels() {
        infoTableModel = new InfoTableModel();
        jTable1.setModel(infoTableModel);
    }

    @SuppressWarnings("empty-statement")
    private void introduInTabela(List<Info> listainfo) {

        infoTableModel.refreshModel(listainfo);
        dimensiuniColoaneTable();
    }

    private void dimensiuniColoaneTable() {
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(jTable1.getColumnName(0).length());
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(jTable1.getColumnName(1).length());
    }

    private void exportaPDF(List<String> listaCuCheckBox) {

        ClassPDFRaport demoPDF = new ClassPDFRaport();
        if (listaCuCheckBox.size() == 1) {
            System.out.println("listaCuCheckBox " + listaCuCheckBox);
            listaCuCheckBox.retainAll(listaCuCheckBox);
            JOptionPane.showMessageDialog(null, "Lista este goală "
                    + "\n Executaţi căutare", "Atenţie!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            demoPDF.introduVar(listaCuCheckBox);
            try {

                demoPDF.createPDF();

            } catch (DocumentException ex) {
                Logger.getLogger(ClassPDFRaport.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ClassPDFRaport.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ClassPDFRaport.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ClassPDFRaport.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private boolean oferaDrepturiAdmin() {
        DataUserImpl userDao = DataUserImpl.getInstance();
        boolean acord = false;
        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf, "Introdu Parola", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (okCxl == JOptionPane.OK_OPTION) {
            String password = new String(pf.getPassword());
            if (userDao.verifyUserData(1, password)) {
                acord = true;
                jpanelParent.accesAdmin();
            } else {
                acord = false;
            }
        }
        return acord;
    }
}