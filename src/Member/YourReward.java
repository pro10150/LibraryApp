package Member;

import javax.swing.JOptionPane;
import Backdoor.*;

import java.awt.event.KeyEvent;
/**
 *
 * @author Annop Boonlieng
 */
public class YourReward extends javax.swing.JFrame {
    
    public YourReward() {
        initComponents();
        updateUI();
    }
    
    int pageCap = 2; // Placeholder
    int n;
    int page = 1;
    
    public void updateUI() {
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        imageA2 = new javax.swing.JButton();
        memberName = new javax.swing.JLabel();
        topPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        accountButton = new javax.swing.JButton();
        notifButton = new javax.swing.JButton();
        logo = new javax.swing.JButton();
        backGround = new javax.swing.JPanel();
        backLine = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        topLabel = new javax.swing.JLabel();
        reward1 = new javax.swing.JButton();
        reward2 = new javax.swing.JButton();
        reward3 = new javax.swing.JButton();
        reward4 = new javax.swing.JButton();
        reward5 = new javax.swing.JButton();
        reward6 = new javax.swing.JButton();
        prevButton = new javax.swing.JButton();
        pageCount = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("<< Back");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backLine.png"))); // NOI18N

        imageA2.setText("-");

        memberName.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        memberName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        memberName.setText("FRIEND LIST");

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

        topLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        topLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topLabel.setText("YOUR REWARDS");

        reward1.setBackground(new java.awt.Color(202, 180, 138));
        reward1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        reward1.setText("<html><p>[Reward name]</p>\n<p>[Redeem Date]</p></html>");
        reward1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reward1ActionPerformed(evt);
            }
        });

        reward2.setBackground(new java.awt.Color(202, 180, 138));
        reward2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        reward2.setText("<html><p>[Reward name]</p>\n<p>[Redeem Date]</p></html>");
        reward2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reward2ActionPerformed(evt);
            }
        });

        reward3.setBackground(new java.awt.Color(202, 180, 138));
        reward3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        reward3.setText("<html><p>[Reward name]</p>\n<p>[Redeem Date]</p></html>");
        reward3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reward3ActionPerformed(evt);
            }
        });

        reward4.setBackground(new java.awt.Color(202, 180, 138));
        reward4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        reward4.setText("<html><p>[Reward name]</p>\n<p>[Redeem Date]</p></html>");
        reward4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reward4ActionPerformed(evt);
            }
        });

        reward5.setBackground(new java.awt.Color(202, 180, 138));
        reward5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        reward5.setText("<html><p>[Reward name]</p>\n<p>[Redeem Date]</p></html>");
        reward5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reward5ActionPerformed(evt);
            }
        });

        reward6.setBackground(new java.awt.Color(202, 180, 138));
        reward6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        reward6.setText("<html><p>[Reward name]</p>\n<p>[Redeem Date]</p></html>");
        reward6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reward6ActionPerformed(evt);
            }
        });

        prevButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrowPrev.png"))); // NOI18N
        prevButton.setContentAreaFilled(false);
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        pageCount.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        pageCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pageCount.setText("Page 1 of 5");

        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrowNext.png"))); // NOI18N
        nextButton.setContentAreaFilled(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backGroundLayout = new javax.swing.GroupLayout(backGround);
        backGround.setLayout(backGroundLayout);
        backGroundLayout.setHorizontalGroup(
            backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backGroundLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(back)
                .addGap(9, 9, 9)
                .addComponent(backLine, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                        .addComponent(topLabel)
                        .addGap(296, 296, 296))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                        .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backGroundLayout.createSequentialGroup()
                                .addComponent(reward3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(reward4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backGroundLayout.createSequentialGroup()
                                .addComponent(reward1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(reward2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backGroundLayout.createSequentialGroup()
                                .addComponent(reward6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(reward5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(143, 143, 143))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                        .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pageCount, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(302, 302, 302))))
        );
        backGroundLayout.setVerticalGroup(
            backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backGroundLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backLine, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(topLabel)
                .addGap(18, 18, 18)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reward1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reward2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reward3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reward4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reward6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reward5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                        .addComponent(pageCount)
                        .addGap(11, 11, 11)))
                .addGap(21, 21, 21))
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
        Notification notif = new Notification();
        notif.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_notifButtonActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        RewardPage menu = new RewardPage();
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
    }//GEN-LAST:event_searchFieldKeyPressed

    private void logoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoActionPerformed
        Main menu = new Main();
        menu.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_logoActionPerformed

    private void reward1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reward1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reward1ActionPerformed

    private void reward2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reward2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reward2ActionPerformed

    private void reward3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reward3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reward3ActionPerformed

    private void reward4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reward4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reward4ActionPerformed

    private void reward5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reward5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reward5ActionPerformed

    private void reward6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reward6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reward6ActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        try {
            if (page > 1) {
                page--;
                //updateSearch(this.searchQuery);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_prevButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        try {
            if (page < pageCap) {
                page++;
                //updateSearch(this.searchQuery);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_nextButtonActionPerformed

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
    private javax.swing.JButton accountButton;
    private javax.swing.JButton back;
    private javax.swing.JPanel backGround;
    private javax.swing.JLabel backLine;
    private javax.swing.JButton imageA2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logo;
    private javax.swing.JLabel memberName;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton notifButton;
    private javax.swing.JLabel pageCount;
    private javax.swing.JButton prevButton;
    private javax.swing.JButton reward1;
    private javax.swing.JButton reward2;
    private javax.swing.JButton reward3;
    private javax.swing.JButton reward4;
    private javax.swing.JButton reward5;
    private javax.swing.JButton reward6;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel topLabel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
