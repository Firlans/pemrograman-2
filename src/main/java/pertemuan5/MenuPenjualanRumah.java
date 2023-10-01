/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */

package pertemuan5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;

/**
 *
 * @author mr_tech
 */
public class MenuPenjualanRumah extends javax.swing.JInternalFrame {

    /** Creates new form MenuPenjualanRumah */
    
    PenjualanRumah jual;
    public MenuPenjualanRumah(PenjualanRumah jual){
        initComponents();
        this.jual = jual;
    }
    
    public void simpan(){
        try{
            this.jual.connection = DriverManager.getConnection(this.jual.url, this.jual.user, this.jual.password);
            this.jual.statement = this.jual.connection.createStatement();

            try{
                this.jual.statement.executeUpdate("USE "+ jual.database);
                this.jual.dbExist = true;
            } catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
            this.jual.statement = this.jual.connection.createStatement();
            String sql = "INSERT INTO rumah_terjual (nama_pemesan, area, tipe, luas, harga, lama_cicilan, cicilan)"
                    + "VALUES (?,?,?,?,?,?,?);";
            PreparedStatement statement = jual.connection.prepareStatement(sql);            
            
            if(complete()){
                statement.setString(1, namaPemesan.getText());
                statement.setString(2, (String) area.getSelectedItem());
                statement.setString(3, tipeRumah());
                statement.setString(4, luasTanahTersedia.getText());
                statement.setString(5, harga.getText());
                statement.setString(6, lamaCicilan.getText());
                statement.setString(7, cicilan.getText());
                
                statement.executeUpdate();
                System.out.println("data ditambahkan");
                dispose();
                StatusLogin peringatan = new StatusLogin("data berhasil tersimpan", false, this, this.jual);
                peringatan.setVisible(true);
                this.jual.desktopPane.add(peringatan);
            }else{
                dispose();
                StatusLogin peringatan = new StatusLogin("Harap Lengkapi data yang ada!!!", false, this, this.jual);
                peringatan.setVisible(true);
                this.jual.desktopPane.add(peringatan);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuPenjualanRumah.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private String tipeRumah(){
        if(jRadioButton1.isSelected()){
            return jRadioButton1.getText();
        }else if(jRadioButton2.isSelected()){
            return jRadioButton2.getText();
        }else if(jRadioButton3.isSelected()){
            return jRadioButton3.getText();
        }
        return null;
    }
    
    private boolean complete(){
        if(namaPemesan != null && area.getSelectedItem() != null && tipeRumah()!=null && luasTanahTersedia.getText() != null && harga.getText() != null && lamaCicilan.getText() != null && cicilan.getText() != null){
            return true;
        }
        return false;
    }
    
    private void clear(){
       namaPemesan.setText("");
       hargaTanahPerMeter.setText("");
       hargaBangunan.setText("");
       luasTanahAsli.setText("");
       luasTanahTersedia.setText("");
       harga.setText("");
       dp.setText("");
       lamaCicilan.setText("");
       pajak.setText("");
       cicilan.setText("");
       jRadioButton1.setSelected(false);
       jRadioButton2.setSelected(false);
       jRadioButton3.setSelected(false);
       persetujuan.setSelected(false);
       jRadioButton1.setSelected(false);
       jRadioButton2.setSelected(false);
       jRadioButton3.setSelected(false);
       simpanButton.setEnabled(false);
    }
    
    private void hargaPembelian(){
        int hargaBeli = Integer.parseInt(luasTanahTersedia.getText()) * Integer.parseInt(hargaTanahPerMeter.getText()) + Integer.parseInt(hargaBangunan.getText());
        harga.setText(Integer.toString(hargaBeli));
    }
    
    private String pajak(){
        int jumlahPajak = 10* Integer.parseInt(harga.getText()) /100;
        return Integer.toString(jumlahPajak);
    }
    
    private String cicilan(){
        int cicilanBulanan = (Integer.parseInt(harga.getText()) - Integer.parseInt(dp.getText())) / Integer.parseInt(lamaCicilan.getText());
        return Integer.toString(cicilanBulanan);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        namaPemesan = new javax.swing.JTextField();
        hargaTanahPerMeter = new javax.swing.JTextField();
        luasTanahTersedia = new javax.swing.JTextField();
        hargaBangunan = new javax.swing.JTextField();
        luasTanahAsli = new javax.swing.JTextField();
        cicilan = new javax.swing.JTextField();
        pajak = new javax.swing.JTextField();
        lamaCicilan = new javax.swing.JTextField();
        dp = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        area = new javax.swing.JComboBox<>();
        persetujuan = new javax.swing.JCheckBox();
        prosesButton = new javax.swing.JButton();
        simpanButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("Harga Bangunan");

        jLabel2.setText("Nama Pemesan");

        jLabel3.setText("Harga Tanah/m2");

        jLabel5.setText("Area");

        jLabel6.setText("Bulan");

        jLabel7.setText("Tipe Rumah");

        jLabel8.setText("Harga");

        jLabel9.setText("DP");

        jLabel10.setText("Lama Cicilan");

        jLabel11.setText("PPN(10%)");

        jLabel12.setText("Cicilan/bulan");

        jLabel13.setText("Luas Tanah Tersedia");

        jLabel14.setText("Luas Tanah Asli");

        hargaTanahPerMeter.setEditable(false);

        hargaBangunan.setEditable(false);

        luasTanahAsli.setEditable(false);

        cicilan.setEditable(false);

        pajak.setEditable(false);

        harga.setEditable(false);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Tipe-36");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Tipe-45");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Tipe-54");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        area.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bougenvile", "Melati", "Flamboyan" }));
        area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaActionPerformed(evt);
            }
        });

        persetujuan.setText("Setuju");
        persetujuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                persetujuanActionPerformed(evt);
            }
        });

        prosesButton.setText("Proses");
        prosesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prosesButtonActionPerformed(evt);
            }
        });

        simpanButton.setText("Simpan");
        simpanButton.setEnabled(false);
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaPemesan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hargaTanahPerMeter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14)
                    .addComponent(luasTanahTersedia, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaBangunan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(luasTanahAsli, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(persetujuan)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addComponent(prosesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(simpanButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cicilan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pajak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lamaCicilan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(dp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {area, hargaTanahPerMeter, namaPemesan});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cicilan, dp, harga, hargaBangunan, lamaCicilan, luasTanahAsli, luasTanahTersedia, pajak});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(namaPemesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaBangunan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(hargaTanahPerMeter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(luasTanahAsli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addGap(5, 5, 5)
                                .addComponent(luasTanahTersedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton3)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(dp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lamaCicilan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(pajak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cicilan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(persetujuan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prosesButton)
                    .addComponent(simpanButton)
                    .addComponent(clearButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void persetujuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_persetujuanActionPerformed
        // TODO add your handling code here:
        if(persetujuan.isSelected())simpanButton.setEnabled(true);
        else simpanButton.setEnabled(false);
    }//GEN-LAST:event_persetujuanActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaActionPerformed
        // TODO add your handling code here:
        int hargaPerMeter = 0;
        int bangunan = 0;
        switch(area.getSelectedIndex()){
            case 0:
                hargaPerMeter = 500000;
                bangunan = 90000000;
                break;
            case 1:
                hargaPerMeter = 600000;
                bangunan = 120000000;
                break;
            case 2:
                hargaPerMeter = 700000;
                bangunan = 150000000;
                break;
        }
        hargaTanahPerMeter.setText(Integer.toString(hargaPerMeter));
        hargaBangunan.setText(Integer.toString(bangunan));
    }//GEN-LAST:event_areaActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        luasTanahAsli.setText("90");            
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void prosesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prosesButtonActionPerformed
        // TODO add your handling code here:
        hargaPembelian();
        pajak.setText(pajak());
        cicilan.setText(cicilan());
    }//GEN-LAST:event_prosesButtonActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        luasTanahAsli.setText("120");
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        luasTanahAsli.setText("140");
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        Konfirmasi confirm = new Konfirmasi(this);
        confirm.setVisible(true);
        this.jual.desktopPane.add(confirm);
            
    }//GEN-LAST:event_simpanButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> area;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cicilan;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField dp;
    private javax.swing.JTextField harga;
    private javax.swing.JTextField hargaBangunan;
    private javax.swing.JTextField hargaTanahPerMeter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField lamaCicilan;
    private javax.swing.JTextField luasTanahAsli;
    private javax.swing.JTextField luasTanahTersedia;
    private javax.swing.JTextField namaPemesan;
    private javax.swing.JTextField pajak;
    private javax.swing.JCheckBox persetujuan;
    private javax.swing.JButton prosesButton;
    private javax.swing.JButton simpanButton;
    // End of variables declaration//GEN-END:variables

}
