package Member;

import javax.swing.JOptionPane;
import Backdoor.*;

import java.awt.event.KeyEvent;
/**
 *
 * @author Annop Boonlieng
 */
public class BookReview extends javax.swing.JFrame {

    public String bookNameLink;
    public int ratingStars;
    
    public BookReview() {
        initComponents();
    }
    public BookReview(String bookName) {
        initComponents();
        
        bookNameLink = bookName;
        
        this.bookImage.setText("<html>"+bookName+"</html>");
        try{
            PhysicalBook book = new PhysicalBook(bookName);
            this.AuthorName.setText(book.getAuthor());
        }catch (Exception e){System.out.println(e);}
        
    }
    
    
    public void updateStars() {
        star1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staron.png")));
        if (ratingStars >= 2)
            star2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staron.png")));
        else
            star2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staroff.png")));
        if (ratingStars >= 3)
            star3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staron.png")));
        else
            star3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staroff.png")));
        if (ratingStars >= 4)
            star4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staron.png")));
        else
            star4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staroff.png")));
        if (ratingStars == 5)
            star5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staron.png")));
        else
            star5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staroff.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        imageA2 = new javax.swing.JButton();
        topPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        accountButton = new javax.swing.JButton();
        notifButton = new javax.swing.JButton();
        logo = new javax.swing.JButton();
        backGround = new javax.swing.JPanel();
        backLine = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        sendReview = new javax.swing.JButton();
        bookImage = new javax.swing.JButton();
        AuthorName = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        star1 = new javax.swing.JButton();
        star2 = new javax.swing.JButton();
        star3 = new javax.swing.JButton();
        star4 = new javax.swing.JButton();
        star5 = new javax.swing.JButton();
        descLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reviewTextArea = new javax.swing.JTextArea();

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("<< Back");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backLine.png"))); // NOI18N

        imageA2.setText("-");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library");
        setBackground(new java.awt.Color(255, 153, 102));

        topPanel.setBackground(new java.awt.Color(255, 204, 153));

        searchField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchField.setText("search");
        searchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchFieldMouseClicked(evt);
            }
        });
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search.png"))); // NOI18N

        accountButton.setBackground(new java.awt.Color(255, 204, 153));
        accountButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/account.png"))); // NOI18N
        accountButton.setContentAreaFilled(false);
        accountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountButtonActionPerformed(evt);
            }
        });

        notifButton.setBackground(new java.awt.Color(255, 204, 153));
        notifButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/notif.png"))); // NOI18N
        notifButton.setContentAreaFilled(false);
        notifButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notifButtonActionPerformed(evt);
            }
        });

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
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208)
                .addComponent(notifButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(accountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(notifButton)
            .addComponent(accountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        backGround.setBackground(new java.awt.Color(255, 249, 217));

        backLine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backLine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backLine.png"))); // NOI18N

        back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        back.setText("<< Back");
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        sendReview.setText("Submit");
        sendReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendReviewActionPerformed(evt);
            }
        });

        bookImage.setText("BOOK");
        bookImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookImageActionPerformed(evt);
            }
        });

        AuthorName.setBackground(new java.awt.Color(102, 102, 102));
        AuthorName.setForeground(new java.awt.Color(255, 255, 255));
        AuthorName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AuthorName.setText("[Type] + [Author]");
        AuthorName.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(195, 172, 148));

        star1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staroff.png"))); // NOI18N
        star1.setContentAreaFilled(false);
        star1.setOpaque(false);
        star1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star1ActionPerformed(evt);
            }
        });

        star2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staroff.png"))); // NOI18N
        star2.setContentAreaFilled(false);
        star2.setOpaque(false);
        star2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star2ActionPerformed(evt);
            }
        });

        star3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staroff.png"))); // NOI18N
        star3.setContentAreaFilled(false);
        star3.setOpaque(false);
        star3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star3ActionPerformed(evt);
            }
        });

        star4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staroff.png"))); // NOI18N
        star4.setContentAreaFilled(false);
        star4.setOpaque(false);
        star4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star4ActionPerformed(evt);
            }
        });

        star5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staroff.png"))); // NOI18N
        star5.setContentAreaFilled(false);
        star5.setOpaque(false);
        star5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star5ActionPerformed(evt);
            }
        });

        descLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        descLabel.setForeground(new java.awt.Color(255, 255, 255));
        descLabel.setText("Desc:");

        jScrollPane1.setToolTipText("");

        reviewTextArea.setColumns(20);
        reviewTextArea.setRows(5);
        jScrollPane1.setViewportView(reviewTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(descLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(star1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(star2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(star3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(star4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(star5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(334, 334, 334))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(descLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(star5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(star1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(star2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(star4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(star3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout backGroundLayout = new javax.swing.GroupLayout(backGround);
        backGround.setLayout(backGroundLayout);
        backGroundLayout.setHorizontalGroup(
            backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backGroundLayout.createSequentialGroup()
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backGroundLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(back)
                        .addGap(9, 9, 9)
                        .addComponent(backLine, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(backGroundLayout.createSequentialGroup()
                .addGap(427, 427, 427)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bookImage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendReview, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AuthorName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backGroundLayout.setVerticalGroup(
            backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backGroundLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backLine, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookImage, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AuthorName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sendReview, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
                .addGap(4, 4, 4)
                .addComponent(backGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void accountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountButtonActionPerformed
        MemberPage mp = new MemberPage();
        mp.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_accountButtonActionPerformed

    private void notifButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notifButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notifButtonActionPerformed

    private void sendReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendReviewActionPerformed
        String review = reviewTextArea.getText();
        
        System.out.println(review);
        // Do some review sending thing
        JOptionPane.showMessageDialog(null, "Review sent.");
        Main menu = new Main();
        menu.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_sendReviewActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        BookPage menu = new BookPage(bookNameLink);
        menu.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void searchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMouseClicked
        String x = searchField.getText();     
        if (x.equals("search")) searchField.setText("");
    }//GEN-LAST:event_searchFieldMouseClicked

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
    try {
            if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
                String query = searchField.getText();
                if (!query.equals("")) {
                    SearchBook sp = new SearchBook(query);
                    sp.setVisible(true);
                    setVisible(false);
                    dispose();
                }
                else {
                    System.out.println("Invalid search input.");    
                }
        }
        } catch (Exception e) {System.out.println(e); }
                // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldKeyPressed

    private void logoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoActionPerformed
        Main menu = new Main();
        menu.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_logoActionPerformed

    private void bookImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookImageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookImageActionPerformed

    private void star1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_star1ActionPerformed
        ratingStars = 1;
        updateStars();
    }//GEN-LAST:event_star1ActionPerformed

    private void star2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_star2ActionPerformed
        ratingStars = 2;
        updateStars();
    }//GEN-LAST:event_star2ActionPerformed

    private void star3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_star3ActionPerformed
        ratingStars = 3;
        updateStars();
    }//GEN-LAST:event_star3ActionPerformed

    private void star4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_star4ActionPerformed
        ratingStars = 4;
        updateStars();
    }//GEN-LAST:event_star4ActionPerformed

    private void star5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_star5ActionPerformed
        ratingStars = 5;
        updateStars();
    }//GEN-LAST:event_star5ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AuthorName;
    private javax.swing.JButton accountButton;
    private javax.swing.JButton back;
    private javax.swing.JPanel backGround;
    private javax.swing.JLabel backLine;
    private javax.swing.JButton bookImage;
    private javax.swing.JLabel descLabel;
    private javax.swing.JButton imageA2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logo;
    private javax.swing.JButton notifButton;
    private javax.swing.JTextArea reviewTextArea;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton sendReview;
    private javax.swing.JButton star1;
    private javax.swing.JButton star2;
    private javax.swing.JButton star3;
    private javax.swing.JButton star4;
    private javax.swing.JButton star5;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
