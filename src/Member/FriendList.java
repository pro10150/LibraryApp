package Member;

import javax.swing.JOptionPane;
import Backdoor.*;
import java.awt.event.KeyEvent;
import java.sql.*; 
/**
 *
 * @author Annop Boonlieng
 */
public class FriendList extends javax.swing.JFrame {

    public String bookNameLink;
    
    public FriendList(){
        initComponents();

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
        memberName = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        backLine = new javax.swing.JLabel();
        friend1 = new javax.swing.JButton();
        friend2 = new javax.swing.JButton();
        friend3 = new javax.swing.JButton();
        friend5 = new javax.swing.JButton();
        friend7 = new javax.swing.JButton();
        friend9 = new javax.swing.JButton();
        friend11 = new javax.swing.JButton();
        friend13 = new javax.swing.JButton();
        friend4 = new javax.swing.JButton();
        friend6 = new javax.swing.JButton();
        friend8 = new javax.swing.JButton();
        friend10 = new javax.swing.JButton();
        friend12 = new javax.swing.JButton();
        friend14 = new javax.swing.JButton();
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

        memberName.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        memberName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        memberName.setText("FRIEND LIST");

        back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        back.setText("<< Back");
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        backLine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backLine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backLine.png"))); // NOI18N

        friend1.setBackground(new java.awt.Color(206, 195, 164));
        friend1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        friend1.setText("Name XXXXXXXXXX Surname XXXXXXXXX Faculty XXXXXX");
        friend1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friend1ActionPerformed(evt);
            }
        });

        friend2.setBackground(new java.awt.Color(206, 195, 164));
        friend2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        friend2.setText("Name XXXXXXXXXX Surname XXXXXXXXX Faculty XXXXXX");
        friend2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friend2ActionPerformed(evt);
            }
        });

        friend3.setBackground(new java.awt.Color(206, 195, 164));
        friend3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        friend3.setText("Name XXXXXXXXXX Surname XXXXXXXXX Faculty XXXXXX");
        friend3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friend3ActionPerformed(evt);
            }
        });

        friend5.setBackground(new java.awt.Color(206, 195, 164));
        friend5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        friend5.setText("Name XXXXXXXXXX Surname XXXXXXXXX Faculty XXXXXX");
        friend5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friend5ActionPerformed(evt);
            }
        });

        friend7.setBackground(new java.awt.Color(206, 195, 164));
        friend7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        friend7.setText("Name XXXXXXXXXX Surname XXXXXXXXX Faculty XXXXXX");
        friend7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friend7ActionPerformed(evt);
            }
        });

        friend9.setBackground(new java.awt.Color(206, 195, 164));
        friend9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        friend9.setText("Name XXXXXXXXXX Surname XXXXXXXXX Faculty XXXXXX");
        friend9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friend9ActionPerformed(evt);
            }
        });

        friend11.setBackground(new java.awt.Color(206, 195, 164));
        friend11.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        friend11.setText("Name XXXXXXXXXX Surname XXXXXXXXX Faculty XXXXXX");
        friend11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friend11ActionPerformed(evt);
            }
        });

        friend13.setBackground(new java.awt.Color(206, 195, 164));
        friend13.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        friend13.setText("Name XXXXXXXXXX Surname XXXXXXXXX Faculty XXXXXX");
        friend13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friend13ActionPerformed(evt);
            }
        });

        friend4.setBackground(new java.awt.Color(206, 195, 164));
        friend4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        friend4.setText("Name XXXXXXXXXX Surname XXXXXXXXX Faculty XXXXXX");
        friend4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friend4ActionPerformed(evt);
            }
        });

        friend6.setBackground(new java.awt.Color(206, 195, 164));
        friend6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        friend6.setText("Name XXXXXXXXXX Surname XXXXXXXXX Faculty XXXXXX");
        friend6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friend6ActionPerformed(evt);
            }
        });

        friend8.setBackground(new java.awt.Color(206, 195, 164));
        friend8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        friend8.setText("Name XXXXXXXXXX Surname XXXXXXXXX Faculty XXXXXX");
        friend8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friend8ActionPerformed(evt);
            }
        });

        friend10.setBackground(new java.awt.Color(206, 195, 164));
        friend10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        friend10.setText("Name XXXXXXXXXX Surname XXXXXXXXX Faculty XXXXXX");
        friend10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friend10ActionPerformed(evt);
            }
        });

        friend12.setBackground(new java.awt.Color(206, 195, 164));
        friend12.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        friend12.setText("Name XXXXXXXXXX Surname XXXXXXXXX Faculty XXXXXX");
        friend12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friend12ActionPerformed(evt);
            }
        });

        friend14.setBackground(new java.awt.Color(206, 195, 164));
        friend14.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        friend14.setText("Name XXXXXXXXXX Surname XXXXXXXXX Faculty XXXXXX");
        friend14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friend14ActionPerformed(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(backGroundLayout.createSequentialGroup()
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(memberName, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backLine, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(backGroundLayout.createSequentialGroup()
                        .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(friend1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(friend3, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(friend5, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(friend7, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(friend9, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(friend11, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(friend13, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(friend14, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(friend12, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(friend10, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(friend8, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(friend6, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(friend4, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(friend2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pageCount, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(323, 323, 323))
        );
        backGroundLayout.setVerticalGroup(
            backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backLine)
                    .addComponent(back))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(memberName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(friend2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(friend3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(friend5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(friend7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(friend9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(friend11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(friend13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friend14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                        .addComponent(pageCount)
                        .addGap(11, 11, 11)))
                .addContainerGap())
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

    private void friend2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friend2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_friend2ActionPerformed

    private void logoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoActionPerformed
        Main menu = new Main();
        menu.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_logoActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Main menu = new Main();
        menu.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void friend1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friend1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_friend1ActionPerformed

    private void friend3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friend3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_friend3ActionPerformed

    private void friend5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friend5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_friend5ActionPerformed

    private void friend7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friend7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_friend7ActionPerformed

    private void friend9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friend9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_friend9ActionPerformed

    private void friend11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friend11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_friend11ActionPerformed

    private void friend13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friend13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_friend13ActionPerformed

    private void friend4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friend4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_friend4ActionPerformed

    private void friend6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friend6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_friend6ActionPerformed

    private void friend8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friend8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_friend8ActionPerformed

    private void friend10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friend10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_friend10ActionPerformed

    private void friend12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friend12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_friend12ActionPerformed

    private void friend14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friend14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_friend14ActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prevButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nextButtonActionPerformed

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
    private javax.swing.JButton back;
    private javax.swing.JPanel backGround;
    private javax.swing.JLabel backLine;
    private javax.swing.JButton friend1;
    private javax.swing.JButton friend10;
    private javax.swing.JButton friend11;
    private javax.swing.JButton friend12;
    private javax.swing.JButton friend13;
    private javax.swing.JButton friend14;
    private javax.swing.JButton friend2;
    private javax.swing.JButton friend3;
    private javax.swing.JButton friend4;
    private javax.swing.JButton friend5;
    private javax.swing.JButton friend6;
    private javax.swing.JButton friend7;
    private javax.swing.JButton friend8;
    private javax.swing.JButton friend9;
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
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
