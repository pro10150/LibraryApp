package librarian;

import javax.swing.JOptionPane;
import Backdoor.*;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Image;

import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class add_book extends javax.swing.JFrame {

    /**
     * Creates new form add_book
     */
    
    public String book_ID, name, type, section;
    public int serial, remaining;
    private String addingImages = null;
   
    
    public add_book(){
        initComponents();
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
        addPicture = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        typeTextField = new javax.swing.JTextField();
        sectionTextField = new javax.swing.JTextField();
        Next = new javax.swing.JButton();
        remainingTextField = new javax.swing.JTextField();
        serialTextField = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        bookIDTextField = new javax.swing.JTextField();

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

        addPicture.setText("Add picture");
        addPicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPictureActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setText("Add book");

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

        Next.setBackground(new java.awt.Color(153, 102, 0));
        Next.setText("Next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

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

        Add.setBackground(new java.awt.Color(153, 102, 0));
        Add.setText("ADD");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        bookIDTextField.setText("Book ID");
        bookIDTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookIDTextFieldMouseClicked(evt);
            }
        });
        bookIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookIDTextFieldActionPerformed(evt);
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
                        .addGap(0, 172, Short.MAX_VALUE)
                        .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                                .addComponent(addPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(typeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bookIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(backGroundLayout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(remainingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sectionTextField)
                                            .addComponent(serialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(208, 208, 208))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(370, 370, 370))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(301, 301, 301))
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
                        .addComponent(jLabel4)
                        .addGap(44, 44, 44)
                        .addComponent(bookIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(backGroundLayout.createSequentialGroup()
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(typeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sectionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(serialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(remainingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(26, 26, 26)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
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
        librarian_profile profile = null;
        try {
            // TODO add your handling code here:
            profile = new librarian_profile();
        } catch (SQLException ex) {
            Logger.getLogger(add_book.class.getName()).log(Level.SEVERE, null, ex);
        }
        profile.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addPictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPictureActionPerformed
        // TODO add your handling code here:
        /*
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG Images", "jpg");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName());
        }*/
        
        FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
        dialog.setFilenameFilter(new FilenameFilter(){
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".jpg") || name.endsWith(".jpeg");
                }
            });
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String images = dialog.getFile();
        String file = dialog.getDirectory();
        System.out.println(images + " chosen.");
        addingImages = file + images;
        javax.swing.ImageIcon icon;
        
        //addingImages = chooser.getSelectedFile().getAbsolutePath();
        icon = new javax.swing.ImageIcon(addingImages);
        Image img = icon.getImage();
        Image modImg = img.getScaledInstance(128,140, Image.SCALE_SMOOTH);
        icon = new ImageIcon(modImg);
        addPicture.setIcon(icon);
        addPicture.setText("");
    }//GEN-LAST:event_addPictureActionPerformed

    
    
    
    private void typeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeTextFieldActionPerformed

    private void sectionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sectionTextFieldActionPerformed

    private void remainingTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remainingTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remainingTextFieldActionPerformed

    private void serialTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serialTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serialTextFieldActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void nameTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameTextFieldMouseClicked
        String x = nameTextField.getText();     
        if (x.equals("Name")) nameTextField.setText("");
    }//GEN-LAST:event_nameTextFieldMouseClicked

    private void typeTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_typeTextFieldMouseClicked
        String x = typeTextField.getText();     
        if (x.equals("Type")) typeTextField.setText("");
    }//GEN-LAST:event_typeTextFieldMouseClicked

    private void sectionTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sectionTextFieldMouseClicked
        // TODO add your handling code here:
        String x = sectionTextField.getText();     
        if (x.equals("Section")) sectionTextField.setText("");
    }//GEN-LAST:event_sectionTextFieldMouseClicked

    private void serialTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serialTextFieldMouseClicked
        // TODO add your handling code here:
        String x = serialTextField.getText();     
        if (x.equals("Serial")) serialTextField.setText("");
    }//GEN-LAST:event_serialTextFieldMouseClicked

    private void remainingTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remainingTextFieldMouseClicked
        // TODO add your handling code here:
        String x = remainingTextField.getText();     
        if (x.equals("Remaining")) remainingTextField.setText("");
    }//GEN-LAST:event_remainingTextFieldMouseClicked

    private void bookIDTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookIDTextFieldMouseClicked
        // TODO add your handling code here:
        String x = bookIDTextField.getText();     
        if (x.equals("Book ID")) bookIDTextField.setText("");
    }//GEN-LAST:event_bookIDTextFieldMouseClicked

    private void bookIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookIDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookIDTextFieldActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        String imagesName = null;
        if(addingImages != null){
                Writer output = null;
                String path = "src/bookCover";
                File file = new File(path);
                String dirName = file.getAbsolutePath();
                File dir = new File (dirName);
                Path source = Paths.get(addingImages);
                Path targetDir = Paths.get(dirName);
                imagesName = bookIDTextField.getText() + ".jpg";
                Path target = targetDir.resolve(imagesName);
            try {
                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                Logger.getLogger(add_book.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
       
        
            // TODO add your handling code here:d
            
            book_ID = bookIDTextField.getText();
            name = nameTextField.getText();
            type = typeTextField.getText();
            section = sectionTextField.getText();
            serial = (int)(Double.parseDouble(serialTextField.getText()));
            remaining = (int)(Double.parseDouble(remainingTextField.getText()));
            try {
                PhysicalBook physicalBook = new PhysicalBook(book_ID,name,type,section,serial,remaining);
                if(imagesName != null)physicalBook.setImageLocation("/bookCover/" + imagesName);
            } catch (SQLException ex) {
                Logger.getLogger(add_book.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Done");
            add_book ad = new add_book();
            ad.setVisible(true);
            dispose();
        
        
    }//GEN-LAST:event_AddActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        // TODO add your handling code here:
        String imagesName = null;
        if(addingImages != null){
                Writer output = null;
                String path = "src/bookCover";
                File file = new File(path);
                String dirName = file.getAbsolutePath();
                File dir = new File (dirName);
                Path source = Paths.get(addingImages);
                Path targetDir = Paths.get(dirName);
                imagesName = bookIDTextField.getText() + ".jpg";
                Path target = targetDir.resolve(imagesName);
            try {
                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                Logger.getLogger(add_book.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        book_ID = bookIDTextField.getText();
        name = nameTextField.getText();
        type = typeTextField.getText();
        section = sectionTextField.getText();
        serial = (int)(Double.parseDouble(serialTextField.getText()));
        remaining = (int)(Double.parseDouble(remainingTextField.getText()));
        try {
            Book physicalBook = new PhysicalBook(book_ID,name,type,section,serial,remaining);
        } catch (SQLException ex) {
            Logger.getLogger(add_book.class.getName()).log(Level.SEVERE, null, ex);
        }
        add_book_more ad = null;
        try {
            ad = new add_book_more(book_ID);
        } catch (SQLException ex) {
            Logger.getLogger(add_book.class.getName()).log(Level.SEVERE, null, ex);
        }
        ad.setVisible(true);
        dispose();
    }//GEN-LAST:event_NextActionPerformed

    private void logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseClicked
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(add_book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Add;
    private javax.swing.JButton Next;
    private javax.swing.JButton addPicture;
    private javax.swing.JPanel backGround;
    private javax.swing.JTextField bookIDTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField remainingTextField;
    private javax.swing.JTextField sectionTextField;
    private javax.swing.JTextField serialTextField;
    private javax.swing.JPanel topPanel;
    private javax.swing.JTextField typeTextField;
    // End of variables declaration//GEN-END:variables
}
