/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarian;

/**
 *
 * @author user
 */
import javax.swing.JOptionPane;
import Backdoor.*;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class add_book_more extends javax.swing.JFrame {

    /**
     * Creates new form add_book
     */
    
    public String description, published_location, author,book_ID, name, type, 
            section;
    private int year,remainig,serial;
   
    
    public add_book_more(){
        initComponents();
    }
    
    public add_book_more(String book_ID) throws SQLException{
        initComponents();
        PhysicalBook physicalBook = new PhysicalBook(book_ID);
        this.book_ID = physicalBook.getBookID();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        backGround = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        publishedLocationTextField = new javax.swing.JTextField();
        yearTextField = new javax.swing.JTextField();
        authorTextField = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        descriptionTextField = new javax.swing.JTextField();
        Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 102));
        setPreferredSize(new java.awt.Dimension(945, 581));

        topPanel.setBackground(new java.awt.Color(255, 204, 153));
        topPanel.setMinimumSize(new java.awt.Dimension(872, 55));
        topPanel.setPreferredSize(new java.awt.Dimension(872, 55));
        topPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LibraryLogoSmall_1.png"))); // NOI18N
        logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoMouseClicked(evt);
            }
        });
        topPanel.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, -1));

        backGround.setBackground(new java.awt.Color(255, 249, 217));
        backGround.setPreferredSize(new java.awt.Dimension(922, 495));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setLabel("<< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backLine.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setText("Add book");

        publishedLocationTextField.setText("Published location");
        publishedLocationTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                publishedLocationTextFieldMouseClicked(evt);
            }
        });
        publishedLocationTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publishedLocationTextFieldActionPerformed(evt);
            }
        });

        yearTextField.setText("year");
        yearTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yearTextFieldMouseClicked(evt);
            }
        });
        yearTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearTextFieldActionPerformed(evt);
            }
        });

        authorTextField.setText("author");
        authorTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                authorTextFieldMouseClicked(evt);
            }
        });
        authorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorTextFieldActionPerformed(evt);
            }
        });

        Add.setBackground(new java.awt.Color(153, 102, 0));
        Add.setText("ADD");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        descriptionTextField.setText("Description");
        descriptionTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        descriptionTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                descriptionTextFieldMouseClicked(evt);
            }
        });
        descriptionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionTextFieldActionPerformed(evt);
            }
        });

        Cancel.setBackground(new java.awt.Color(153, 102, 0));
        Cancel.setText("CANCEL");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backGroundLayout = new javax.swing.GroupLayout(backGround);
        backGround.setLayout(backGroundLayout);
        backGroundLayout.setHorizontalGroup(
            backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                        .addGap(0, 398, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(370, 370, 370))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                        .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(backGroundLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(yearTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(publishedLocationTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(authorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(backGroundLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                                .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(208, 208, 208))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(Cancel)
                .addGap(296, 296, 296))
        );
        backGroundLayout.setVerticalGroup(
            backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backGroundLayout.createSequentialGroup()
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backGroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addGap(44, 44, 44)
                .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(publishedLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(authorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
            .addComponent(backGround, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backGround, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("librarian");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void yearTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearTextFieldActionPerformed

    private void authorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authorTextFieldActionPerformed

    private void publishedLocationTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishedLocationTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_publishedLocationTextFieldActionPerformed

    private void publishedLocationTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_publishedLocationTextFieldMouseClicked
        String x = publishedLocationTextField.getText();     
        if (x.equals("Published location")) publishedLocationTextField.setText("");
    }//GEN-LAST:event_publishedLocationTextFieldMouseClicked

    private void yearTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yearTextFieldMouseClicked
        String x = yearTextField.getText();     
        if (x.equals("Year")) yearTextField.setText("");
    }//GEN-LAST:event_yearTextFieldMouseClicked

    private void authorTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_authorTextFieldMouseClicked
        // TODO add your handling code here:
        String x = authorTextField.getText();     
        if (x.equals("Author")) authorTextField.setText("");
    }//GEN-LAST:event_authorTextFieldMouseClicked

    private void descriptionTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descriptionTextFieldMouseClicked
        // TODO add your handling code here:
        String x = descriptionTextField.getText();     
        if (x.equals("Description")) descriptionTextField.setText("");
    }//GEN-LAST:event_descriptionTextFieldMouseClicked

    private void descriptionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionTextFieldActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:d
        description = descriptionTextField.getText();
        published_location = publishedLocationTextField.getText();
        year = (int)(Double.parseDouble(yearTextField.getText()));
        author = authorTextField.getText();
        
        PhysicalBook book = null; 
        try {
            book = new PhysicalBook(this.book_ID);
        } catch (SQLException ex) {
            Logger.getLogger(add_book_more.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            book.setDescription(description);
        } catch (SQLException ex) {
            Logger.getLogger(add_book_more.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            book.setPublished_location(published_location);
        } catch (SQLException ex) {
            Logger.getLogger(add_book_more.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            book.setYear(year);
        } catch (SQLException ex) {
            Logger.getLogger(add_book_more.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            book.setAuthor(author);
        } catch (SQLException ex) {
            Logger.getLogger(add_book_more.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Done");
        add_book ad = new add_book();
        ad.setVisible(true);
        dispose();
    }//GEN-LAST:event_AddActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        PhysicalBook book = null;
        try {
            // TODO add your handling code here:
            book = new PhysicalBook(this.book_ID);
        } catch (SQLException ex) {
            Logger.getLogger(add_book_more.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            book.deletePhysicalBook();
        } catch (SQLException ex) {
            Logger.getLogger(add_book_more.class.getName()).log(Level.SEVERE, null, ex);
        }
        add_book ad = new add_book();
        ad.setVisible(true);
        dispose();
    }//GEN-LAST:event_CancelActionPerformed

    private void logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseClicked
        // TODO add your handling code here:
        PhysicalBook book = null;
        try {
            // TODO add your handling code here:
            book = new PhysicalBook(this.book_ID);
        } catch (SQLException ex) {
            Logger.getLogger(add_book_more.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            book.deletePhysicalBook();
        } catch (SQLException ex) {
            Logger.getLogger(add_book_more.class.getName()).log(Level.SEVERE, null, ex);
        }
        librarian_profile menu = null;
        try {
            menu = new librarian_profile();
        } catch (SQLException ex) {
            Logger.getLogger(librarian_profile.class.getName()).log(Level.SEVERE, null, ex);
        }
        menu.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_logoMouseClicked

 
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
            java.util.logging.Logger.getLogger(add_book_more.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_book_more.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_book_more.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_book_more.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_book_more().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Add;
    public javax.swing.JButton Cancel;
    private javax.swing.JTextField authorTextField;
    private javax.swing.JPanel backGround;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField publishedLocationTextField;
    private javax.swing.JPanel topPanel;
    private javax.swing.JTextField yearTextField;
    // End of variables declaration//GEN-END:variables
}
