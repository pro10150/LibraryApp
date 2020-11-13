package Member;

import javax.swing.JOptionPane;
import Backdoor.*;
import java.awt.event.KeyEvent;
import java.sql.*; 
/**
 *
 * @author Annop Boonlieng
 */
public class MemberPage extends javax.swing.JFrame {

    public String bookNameLink;
    
    public MemberPage(){
        initComponents();

        try{
            Member member = new Member(UIVars.userID);
        
            memberName.setText(member.getFirstName() + "    " + member.getLastName());
            memberPoint.setText("Point: [WIP]"); // get user's point
        }catch (Exception e){System.out.println(e);}
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
        notifButton = new javax.swing.JButton();
        accountButton1 = new javax.swing.JButton();
        logo = new javax.swing.JButton();
        backGround = new javax.swing.JPanel();
        backLine = new javax.swing.JLabel();
        accountLogo = new javax.swing.JButton();
        memberName = new javax.swing.JLabel();
        memberPoint = new javax.swing.JLabel();
        findFriendButton = new javax.swing.JButton();
        bookReviewButton = new javax.swing.JButton();
        yourFeeButton = new javax.swing.JButton();
        rewardButton = new javax.swing.JButton();
        reservedBookButton = new javax.swing.JButton();
        bookRoomButton = new javax.swing.JButton();

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
        topPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        topPanel.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 11, 220, 34));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search.png"))); // NOI18N
        topPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 50, 50));

        notifButton.setBackground(new java.awt.Color(255, 204, 153));
        notifButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/notif.png"))); // NOI18N
        notifButton.setContentAreaFilled(false);
        notifButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notifButtonActionPerformed(evt);
            }
        });
        topPanel.add(notifButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 0, 56, -1));

        accountButton1.setBackground(new java.awt.Color(255, 204, 153));
        accountButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/account.png"))); // NOI18N
        accountButton1.setContentAreaFilled(false);
        accountButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountButton1ActionPerformed(evt);
            }
        });
        topPanel.add(accountButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 0, 50, 55));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LibraryLogoSmall_1.png"))); // NOI18N
        logo.setBorderPainted(false);
        logo.setContentAreaFilled(false);
        logo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoActionPerformed(evt);
            }
        });
        topPanel.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 4, 100, 50));

        backGround.setBackground(new java.awt.Color(255, 249, 217));

        backLine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backLine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backLine.png"))); // NOI18N

        accountLogo.setBackground(new java.awt.Color(255, 204, 153));
        accountLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accountLarge.png"))); // NOI18N
        accountLogo.setContentAreaFilled(false);

        memberName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        memberName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        memberName.setText("Name: [First Name] Surname: [Last Name]");

        memberPoint.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        memberPoint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        memberPoint.setText("Point: [Number]");

        findFriendButton.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        findFriendButton.setText("Find friend");
        findFriendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findFriendButtonActionPerformed(evt);
            }
        });

        bookReviewButton.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        bookReviewButton.setText("Your book review");
        bookReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookReviewButtonActionPerformed(evt);
            }
        });

        yourFeeButton.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        yourFeeButton.setText("Fee");
        yourFeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourFeeButtonActionPerformed(evt);
            }
        });

        rewardButton.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        rewardButton.setText("Rewards");
        rewardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rewardButtonActionPerformed(evt);
            }
        });

        reservedBookButton.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        reservedBookButton.setText("Reserved book");
        reservedBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservedBookButtonActionPerformed(evt);
            }
        });

        bookRoomButton.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        bookRoomButton.setText("Book a room");
        bookRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookRoomButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backGroundLayout = new javax.swing.GroupLayout(backGround);
        backGround.setLayout(backGroundLayout);
        backGroundLayout.setHorizontalGroup(
            backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                        .addComponent(accountLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(411, 411, 411))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                        .addComponent(findFriendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(337, 337, 337))
                    .addGroup(backGroundLayout.createSequentialGroup()
                        .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yourFeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rewardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reservedBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(337, 337, 337))))
            .addGroup(backGroundLayout.createSequentialGroup()
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backGroundLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(memberPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(memberName, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(backGroundLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(backLine, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        backGroundLayout.setVerticalGroup(
            backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backGroundLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(backLine, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accountLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(memberName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(memberPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(findFriendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bookReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(yourFeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rewardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reservedBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bookRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void notifButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notifButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notifButtonActionPerformed

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

    private void accountButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountButton1ActionPerformed
        MemberPage mp = new MemberPage();
        mp.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_accountButton1ActionPerformed

    private void findFriendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findFriendButtonActionPerformed
        // X
    }//GEN-LAST:event_findFriendButtonActionPerformed

    private void bookReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookReviewButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookReviewButtonActionPerformed

    private void yourFeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourFeeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yourFeeButtonActionPerformed

    private void rewardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rewardButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rewardButtonActionPerformed

    private void reservedBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservedBookButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reservedBookButtonActionPerformed

    private void bookRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookRoomButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookRoomButtonActionPerformed

    private void logoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoActionPerformed
        Main menu = new Main();
        menu.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_logoActionPerformed

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
    private javax.swing.JButton accountButton1;
    private javax.swing.JButton accountLogo;
    private javax.swing.JPanel backGround;
    private javax.swing.JLabel backLine;
    private javax.swing.JButton bookReviewButton;
    private javax.swing.JButton bookRoomButton;
    private javax.swing.JButton findFriendButton;
    private javax.swing.JButton imageA2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logo;
    private javax.swing.JLabel memberName;
    private javax.swing.JLabel memberPoint;
    private javax.swing.JButton notifButton;
    private javax.swing.JButton reservedBookButton;
    private javax.swing.JButton rewardButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel topPanel;
    private javax.swing.JButton yourFeeButton;
    // End of variables declaration//GEN-END:variables
}
