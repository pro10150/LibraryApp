/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarian;

import Backdoor.AudioBook;
import Backdoor.PhysicalBook;
import Member.AudioBookPage;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Image;
import java.io.File;
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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class AddAudioBook extends javax.swing.JFrame {
    
    private String book_ID;
    private String addingAudio = null;
    private String voiceActor;
    private Clip clip;
    private static boolean isPlaying = true;
    private static int flag = 0;
    private static long clipTimePosition = 0;
    /**
     * Creates new form AudioBook
     */
    public AddAudioBook() {
        initComponents();
        
        audioStatus.setText("");
    }
    
    public AddAudioBook(String book_ID) throws SQLException{
        initComponents();
        
        audioStatus.setText("");
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
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Add = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        voiceActorTextField = new javax.swing.JTextField();
        addAudio = new javax.swing.JButton();
        audioStatus = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        testButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        backButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backButton.setContentAreaFilled(false);
        backButton.setLabel("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backLine.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setText("Audio Book");

        Add.setBackground(new java.awt.Color(153, 102, 0));
        Add.setText("ADD");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Cancel.setBackground(new java.awt.Color(153, 102, 0));
        Cancel.setText("CANCEL");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        voiceActorTextField.setText("Voice actor");
        voiceActorTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voiceActorTextFieldMouseClicked(evt);
            }
        });
        voiceActorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voiceActorTextFieldActionPerformed(evt);
            }
        });

        addAudio.setText("ADD AUDIO");
        addAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAudioActionPerformed(evt);
            }
        });

        audioStatus.setText("jLabel2");

        resetButton.setText("RESET AUDIO");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        testButton.setText("TEST");
        testButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testButtonActionPerformed(evt);
            }
        });

        stopButton.setText("STOP");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backGroundLayout = new javax.swing.GroupLayout(backGround);
        backGround.setLayout(backGroundLayout);
        backGroundLayout.setHorizontalGroup(
            backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backGroundLayout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(Cancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(backGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backGroundLayout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(308, 308, 308))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                        .addComponent(voiceActorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                        .addComponent(testButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stopButton)
                        .addGap(32, 32, 32)
                        .addComponent(addAudio)
                        .addGap(29, 29, 29)
                        .addComponent(audioStatus)
                        .addGap(48, 48, 48)
                        .addComponent(resetButton)
                        .addGap(126, 126, 126))))
        );
        backGroundLayout.setVerticalGroup(
            backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backGroundLayout.createSequentialGroup()
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backGroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(55, 55, 55)
                .addComponent(voiceActorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addAudio)
                    .addComponent(audioStatus)
                    .addComponent(resetButton)
                    .addComponent(testButton)
                    .addComponent(stopButton))
                .addGap(17, 17, 17)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(backGround, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backGround, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseClicked
        clip.setMicrosecondPosition(0);
        clip.stop();
        flag = 0;
        librarian_profile menu = null;
        try {
            menu = new librarian_profile();
        } catch (SQLException ex) {
            Logger.getLogger(Edit.class.getName()).log(Level.SEVERE, null, ex);
        }
        menu.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_logoMouseClicked

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        try {
            PhysicalBook physicalBook = new PhysicalBook(book_ID);
            physicalBook.deletePhysicalBook();
            librarian_profile main = new librarian_profile();
            main.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(AddAudioBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        try {                                    
            PhysicalBook phBook = new PhysicalBook(book_ID);
            try {
                String audioName = null;
                if(addingAudio != null){
                    Writer output = null;
                    String path = "src/Audio";
                    File file = new File(path);
                    String dirName = file.getAbsolutePath();
                    File dir = new File (dirName);
                    Path source = Paths.get(addingAudio);
                    Path targetDir = Paths.get(dirName);
                    audioName = phBook.getBookID() + ".wav";
                    Path target = targetDir.resolve(audioName);
                    try {
                        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException ex) {
                        Logger.getLogger(add_book.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                voiceActor = voiceActorTextField.getText();
                AudioBook book = new AudioBook(book_ID,voiceActor);
                if(audioName != null)book.setAudio("/Audio/" + audioName);
            } catch (SQLException ex) {
                Logger.getLogger(AddAudioBook.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddAudioBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Done");
        add_book ad = new add_book();
        ad.setVisible(true);
        dispose();
    }//GEN-LAST:event_AddActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        clip.setMicrosecondPosition(0);
        clip.stop();
        flag = 0;
        try {
            PhysicalBook physicalBook = new PhysicalBook(book_ID);
            physicalBook.deletePhysicalBook();
            librarian_profile main = new librarian_profile();
            main.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(AddAudioBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_CancelActionPerformed

    private void voiceActorTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voiceActorTextFieldMouseClicked
        // TODO add your handling code here:
        String x = voiceActorTextField.getText();     
        if (x.equals("Voice actor")) voiceActorTextField.setText("");
    }//GEN-LAST:event_voiceActorTextFieldMouseClicked

    private void voiceActorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voiceActorTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_voiceActorTextFieldActionPerformed

    private void addAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAudioActionPerformed
        // TODO add your handling code here:
        FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
        dialog.setFilenameFilter(new FilenameFilter(){
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".wav") || name.endsWith(".wav");
                }
            });
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String audio = dialog.getFile();
        String file = dialog.getDirectory();
        System.out.println(audio + " chosen.");
        addingAudio = file + audio;        
        audioStatus.setText("Done!");
    }//GEN-LAST:event_addAudioActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        clip.setMicrosecondPosition(0);
        clip.stop();
        flag = 0;
        audioStatus.setText("");
        addingAudio = null;
    }//GEN-LAST:event_resetButtonActionPerformed

    private void testButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testButtonActionPerformed
        File filePath = new File(addingAudio);
        System.out.println(filePath);
        AudioInputStream audioInput;
        try {
            audioInput = AudioSystem.getAudioInputStream(filePath);
        
            try {
                clip = AudioSystem.getClip();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(AddAudioBook.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                clip.open(audioInput);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(AddAudioBook.class.getName()).log(Level.SEVERE, null, ex);
            }
} 
        catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(AddAudioBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddAudioBook.class.getName()).log(Level.SEVERE, null, ex);
        };
        
        
        
        clip.setMicrosecondPosition(0);
        clipTimePosition = 0;
        clip.start();
        flag = 1;
        
    }//GEN-LAST:event_testButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        // TODO add your handling code here:
        clipTimePosition = 0;
            clip.setMicrosecondPosition(0);
            clip.stop();
            flag = 0;
    }//GEN-LAST:event_stopButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddAudioBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAudioBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAudioBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAudioBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddAudioBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Add;
    public javax.swing.JButton Cancel;
    private javax.swing.JButton addAudio;
    private javax.swing.JLabel audioStatus;
    protected javax.swing.JButton backButton;
    private javax.swing.JPanel backGround;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel logo;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JButton testButton;
    private javax.swing.JPanel topPanel;
    private javax.swing.JTextField voiceActorTextField;
    // End of variables declaration//GEN-END:variables
}
