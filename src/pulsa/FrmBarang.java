
package pulsa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class FrmBarang extends javax.swing.JFrame {          
Connection con;
Statement stmt;
ResultSet rs;
DefaultTableModel datasource = new DefaultTableModel(
            new String [][]{{null,null, null, null, null}},
            new String [] {"ID","Nama Operator", "Nominal Pulsa", "Harga Beli", "Harga Jual"}
            );
    public FrmBarang() {
        initComponents();
        openConnection();
        opentable();
        lbl_bantuan1.setText("simpan");
        lbl_bantuan1.setVisible(false);
    }
    
    public void openConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://" +
                    "localhost:3306/Pulsa","root","");
            System.out.println("koneksi berhasil");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch(SQLException sqle){
            sqle.printStackTrace();

        }

    }
 private void refresh(){
     datasource.getDataVector().removeAllElements();
     tbl_laporan.setModel(datasource);
 }
  public void opentable()
{
refresh();

 try{

            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * from tbl_barang");

            while(rs.next())
            {
                datasource.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5)});
            }

         }catch(SQLException ex)
        {

            ex.printStackTrace();
        }
        try {
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(FrmSaldo.class.getName()).log(Level.SEVERE, null, ex);
        }

}
  public void click()
{
    txt_ID.setEditable(false);
    txt_op.setEditable(false);
    txt_nominal.setEditable(false);
    txt_beli.setEditable(false);
    txt_jual.setEditable(false);
    int baris = tbl_laporan.getSelectedRow();
    System.out.print(baris);
    String ID = tbl_laporan.getValueAt(baris,0).toString();
    String op = tbl_laporan.getValueAt(baris,1).toString();
    String nominal = tbl_laporan.getValueAt(baris,2).toString();
    String beli =tbl_laporan.getValueAt(baris,3).toString();
    String jual =tbl_laporan.getValueAt(baris,4).toString();
    
    txt_ID.setText(ID);
    txt_op.setText(op);
    txt_nominal.setText(nominal);
    txt_beli.setText(beli);
    txt_jual.setText(jual);
    btnubah.setEnabled(true);
    
}
  private void simpanBarang() {
        try {
            stmt = (Statement) this.con.createStatement(ResultSet.FETCH_FORWARD,
                    ResultSet.TYPE_SCROLL_SENSITIVE);

            int jml = stmt.executeUpdate("insert into tbl_barang values("+"'"+txt_ID.getText()+"',"
                    + "'"+txt_op.getText()+"',"
                    + "'"+txt_nominal.getText()+"',"
                    + "'"+txt_beli.getText()+"',"
                    + "'"+txt_jual.getText()+"')");
            System.out.println("input data berhasil");
        } catch(SQLException se) {
            se.printStackTrace();
        } //To change body of generated methods, choose Tools | Templates.
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
        txt_ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_op = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_nominal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_beli = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_jual = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_laporan = new javax.swing.JTable();
        btntambah = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();
        btnKmbl = new javax.swing.JButton();
        lbl_bantuan1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID");

        txt_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama Operator");

        jLabel3.setText("Nominal Pulsa");

        txt_nominal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nominalActionPerformed(evt);
            }
        });

        jLabel4.setText("Harga Beli");

        jLabel5.setText("Harga Jual");

        txt_jual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jualActionPerformed(evt);
            }
        });

        tbl_laporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Operator", "Nominal Pulsa", "Harga Beli", "Harga Jual"
            }
        ));
        tbl_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_laporanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_laporan);

        btntambah.setText("Simpan");
        btntambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntambahMouseClicked(evt);
            }
        });
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        btnubah.setText("Edit");
        btnubah.setEnabled(false);
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
            }
        });

        btnKmbl.setText("Kembali");
        btnKmbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKmblActionPerformed(evt);
            }
        });

        lbl_bantuan1.setText("jLabel1");
        lbl_bantuan1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_bantuan1FocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt_op, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_jual, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(157, 157, 157))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_beli, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_bantuan1))
                            .addComponent(txt_nominal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnubah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKmbl)
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_op, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txt_jual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txt_beli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntambah)
                    .addComponent(btnubah)
                    .addComponent(btnKmbl)
                    .addComponent(lbl_bantuan1))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_jualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jualActionPerformed

    private void txt_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDActionPerformed

    private void btntambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntambahMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btntambahMouseClicked

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
        btntambah.setEnabled(false);
        if(lbl_bantuan1.getText()== "simpan")
        {
            simpanBarang();
        }
        else if(lbl_bantuan1.getText()== "ubah")
        {

        }

        opentable();
        txt_ID.setText("");
        txt_op.setText("");
        txt_nominal.setText("");
        txt_beli.setText("");
        txt_jual.setText("");
        btnubah.setEnabled(true);
    
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
        // TODO add your handling code here:
        txt_ID.setEditable(true);
        txt_op.setEditable(true);
        txt_nominal.setEditable(true);
        txt_beli.setEditable(true);
        txt_jual.setEditable(true);
        lbl_bantuan1.setText("ubah");
        btnubah.setEnabled(false);
        btntambah.setEnabled(true);
    }//GEN-LAST:event_btnubahActionPerformed

    private void btnKmblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKmblActionPerformed
        FrmMenu fm= new FrmMenu();
        fm.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnKmblActionPerformed

    private void lbl_bantuan1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_bantuan1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_bantuan1FocusLost

    private void txt_nominalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nominalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nominalActionPerformed

    private void tbl_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_laporanMouseClicked
        click();
    }//GEN-LAST:event_tbl_laporanMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKmbl;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton btnubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_bantuan1;
    private javax.swing.JTable tbl_laporan;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_beli;
    private javax.swing.JTextField txt_jual;
    private javax.swing.JTextField txt_nominal;
    private javax.swing.JTextField txt_op;
    // End of variables declaration//GEN-END:variables
}
