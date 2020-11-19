/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarian;

import Backdoor.Book;
import Backdoor.PhysicalBook;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Edit extends javax.swing.JFrame {
    private String bookID;
    
    /**
     * Creates new form Edit
     */
    public Edit(){
        
    }
    public Edit(String bookID) throws SQLException {
        initComponents();
        this.bookID = bookID;
        PhysicalBook book = new PhysicalBook(this.bookID);
        nameTextField.setText(book.getName());
        typeTextField.setText(book.getType());
        sectionTextField.setText(book.getSection());
        serialTextField.setText(Integer.toString(book.getSerial()));
        remainingTextField.setText(Integer.toString(book.getRemaining()));
        yearTextField.setText(Integer.toString(book.getYear()));
        authorTextField.setText(book.getAuthor());
        descriptionTextField.setText(book.getDescription());
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
        logo = new javax.swing.JButton();
        backGround = new javax.swing.JPanel();
        backLine = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        sendReview = new javax.swing.JButton();
        bookImage = new javax.swing.JButton();
        nameTextField = new javax.swing.JTextField();
        typeTextField = new javax.swing.JTextField();
        sectionTextField = new javax.swing.JTextField();
        serialTextField = new javax.swing.JTextField();
        remainingTextField = new javax.swing.JTextField();
        descriptionTextField = new javax.swing.JTextField();
        yearTextField = new javax.swing.JTextField();
        authorTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        topPanel.setBackground(new java.awt.Color(255, 204, 153));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LibraryLogoSmall_1.png"))); // NOI18N
        logo.setBorderPainted(false);
        logo.setContentAreaFilled(false);
        logo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(440, 440, 440)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(394, 394, 394))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        backGround.setBackground(new java.awt.Color(255, 249, 217));
        backGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backLine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backLine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backLine.png"))); // NOI18N
        backGround.add(backLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 11, 790, 48));

        back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        back.setText("<< Back");
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        backGround.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 40));

        sendReview.setBackground(new java.awt.Color(202, 180, 138));
        sendReview.setText("Submit");
        sendReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendReviewActionPerformed(evt);
            }
        });
        backGround.add(sendReview, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 510, 130, 34));

        bookImage.setText("BOOK");
        bookImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookImageActionPerformed(evt);
            }
        });
        backGround.add(bookImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 130, 160));

        nameTextField.setText("Name");
        nameTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameTextFieldMouseClicked(evt);
            }
        });
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        backGround.add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 380, 30));

        typeTextField.setText("Type");
        typeTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                typeTextFieldMouseClicked(evt);
            }
        });
        typeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeTextFieldActionPerformed(evt);
            }
        });
        backGround.add(typeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 380, 30));

        sectionTextField.setText("Section");
        sectionTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sectionTextFieldMouseClicked(evt);
            }
        });
        sectionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionTextFieldActionPerformed(evt);
            }
        });
        backGround.add(sectionTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 380, 30));

        serialTextField.setText("Serial");
        serialTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serialTextFieldMouseClicked(evt);
            }
        });
        serialTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serialTextFieldActionPerformed(evt);
            }
        });
        backGround.add(serialTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 380, 30));

        remainingTextField.setText("Remaining");
        remainingTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                remainingTextFieldMouseClicked(evt);
            }
        });
        remainingTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remainingTextFieldActionPerformed(evt);
            }
        });
        backGround.add(remainingTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 380, 30));

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
        backGround.add(descriptionTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 380, 110));

        yearTextField.setText("Year");
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
        backGround.add(yearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 380, 30));

        authorTextField.setText("Author");
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
        backGround.add(authorTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 380, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(backGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backGround, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoActionPerformed
        librarian_profile menu = null;
        try {
            menu = new librarian_profile();
        } catch (SQLException ex) {
            Logger.getLogger(Edit.class.getName()).log(Level.SEVERE, null, ex);
        }
        menu.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_logoActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
            LibrarianSearchBook menu = new LibrarianSearchBook();
            menu.setVisible(true);
            setVisible(false);
            dispose();
    }//GEN-LAST:event_backActionPerformed

    private void sendReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendReviewActionPerformed

        String name = nameTextField.getText();
        String type = typeTextField.getText();
        String section = sectionTextField.getText();
        int serial = (int)(Double.parseDouble(serialTextField.getText()));
        int remaining = (int)(Double.parseDouble(remainingTextField.getText()));
        int year = (int)(Double.parseDouble(yearTextField.getText()));
        String author = authorTextField.getText();
        String description = descriptionTextField.getText();  
         try {
            PhysicalBook physicalBook = new PhysicalBook(bookID);
        } catch (SQLException ex) {
            Logger.getLogger(Edit.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Done");
        LibrarianSearchBook LSB = new LibrarianSearchBook();
        LSB.setVisible(true);
        dispose();
    }//GEN-LAST:event_sendReviewActionPerformed

    private void bookImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookImageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookImageActionPerformed

    private void nameTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameTextFieldMouseClicked
        String x = nameTextField.getText();
        if (x.equals("Name")) nameTextField.setText("");
    }//GEN-LAST:event_nameTextFieldMouseClicked

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void typeTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_typeTextFieldMouseClicked
        String x = typeTextField.getText();
        if (x.equals("Type")) typeTextField.setText("");
    }//GEN-LAST:event_typeTextFieldMouseClicked

    private void typeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeTextFieldActionPerformed

    private void sectionTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sectionTextFieldMouseClicked
        // TODO add your handling code here:
        String x = sectionTextField.getText();
        if (x.equals("Section")) sectionTextField.setText("");
    }//GEN-LAST:event_sectionTextFieldMouseClicked

    private void sectionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sectionTextFieldActionPerformed

    private void serialTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serialTextFieldMouseClicked
        // TODO add your handling code here:
        String x = serialTextField.getText();
        if (x.equals("Serial")) serialTextField.setText("");
    }//GEN-LAST:event_serialTextFieldMouseClicked

    private void serialTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serialTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serialTextFieldActionPerformed

    private void remainingTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remainingTextFieldMouseClicked
        // TODO add your handling code here:
        String x = remainingTextField.getText();
        if (x.equals("Remaining")) remainingTextField.setText("");
    }//GEN-LAST:event_remainingTextFieldMouseClicked

    private void remainingTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remainingTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remainingTextFieldActionPerformed

    private void descriptionTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descriptionTextFieldMouseClicked
        // TODO add your handling code here:
        String x = descriptionTextField.getText();
        if (x.equals("Description")) descriptionTextField.setText("");
    }//GEN-LAST:event_descriptionTextFieldMouseClicked

    private void descriptionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionTextFieldActionPerformed

    }//GEN-LAST:event_descriptionTextFieldActionPerformed

    private void yearTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yearTextFieldMouseClicked
        String x = yearTextField.getText();
        if (x.equals("Year")) yearTextField.setText("");
    }//GEN-LAST:event_yearTextFieldMouseClicked

    private void yearTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearTextFieldActionPerformed

    private void authorTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_authorTextFieldMouseClicked
        // TODO add your handling code here:
        String x = authorTextField.getText();
        if (x.equals("Author")) authorTextField.setText("");
    }//GEN-LAST:event_authorTextFieldMouseClicked

    private void authorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authorTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField authorTextField;
    private javax.swing.JButton back;
    private javax.swing.JPanel backGround;
    private javax.swing.JLabel backLine;
    private javax.swing.JButton bookImage;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JButton logo;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField remainingTextField;
    private javax.swing.JTextField sectionTextField;
    private javax.swing.JButton sendReview;
    private javax.swing.JTextField serialTextField;
    private javax.swing.JPanel topPanel;
    private javax.swing.JTextField typeTextField;
    private javax.swing.JTextField yearTextField;
    // End of variables declaration//GEN-END:variables
}
