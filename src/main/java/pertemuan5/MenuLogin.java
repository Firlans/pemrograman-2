/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package pertemuan5;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mr_tech
 */
public class MenuLogin extends javax.swing.JInternalFrame {

    /**
     * Creates new form MenuLogin
     */
    private final PenjualanRumah jual;
    
    public MenuLogin(PenjualanRumah jual) {
        initComponents();
        this.jual = jual;
    }
    private void cekTable(String namaTable) throws SQLException{
        String sql = "CREATE TABLE "+namaTable+"("
                + "nama_pemesan char(255),"
                + "area char(25),"
                + "tipe varchar(30),"
                + "luas int(20),"
                + "harga int(20),"
                + "lama_cicilan int(20),"
                + "cicilan int(20)"
                + ");";
        DatabaseMetaData metadata = this.jual.connection.getMetaData();
        boolean resultSet = metadata.getTables(null, null, namaTable, null).next();
        if(!resultSet){
            this.jual.statement.executeUpdate(sql);
            System.out.println("tabel telah dibuat");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        user = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();

        setClosable(true);

        jLabel1.setText("User");

        jLabel2.setText("Password");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(loginButton)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {password, user});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(loginButton)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void status(String keterangan, boolean status){
        StatusLogin login = new StatusLogin(keterangan, status, this, this.jual);
        login.setVisible(true);
        jual.desktopPane.add(login);
    }
    
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        this.jual.user = user.getText();
        this.jual.password = password.getText();
        try {
            jual.connection = DriverManager.getConnection(jual.url, jual.user, this.jual.password);
            jual.statement = jual.connection.createStatement();

            try{
                jual.statement.executeUpdate("USE "+ jual.database);
                jual.dbExist = true;
            } catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
            if(!jual.dbExist){
                jual.statement.executeUpdate("CREATE DATABASE "+ jual.database);
                System.out.println("Database berhasil dibuat");
            }
            
            cekTable("rumah_terjual");
            
            status("Anda Berhasil Login", true);
            jual.aktifUser = true;
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(MenuPenjualanRumah.class.getName()).log(Level.SEVERE, null, ex);
            status("Harap masukkan User dan Password yang benar agar dapat Login", false);
            dispose();
        }finally {
            try {
                if (jual.statement != null) jual.statement.close();
                if (jual.connection != null) jual.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_loginButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
