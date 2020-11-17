package Member;

import Backdoor.*;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.sql.*; 
import java.util.ArrayList;

/**
 *
 * @author Annop Boonlieng
 */

public class FavoriteBook extends javax.swing.JFrame {
        
    
    public FavoriteBook() throws SQLException{
        initComponents();
        
        this.userId = UIVars.userID;
        noResult.setText("Your favorite books");
        updateUI();
    }
    
    String userId;
    String bookName;
    int pageCap;
    int n;
    int page = 1;
    
    public void HideFirstBar() {
        imageBook1.setVisible(false);
        bookName1.setVisible(false);
        typeAndAuthor1.setVisible(false);
        numberLeft1.setVisible(false);
        rate1.setVisible(false);
    }
    public void HideSecondBar() {
        imageBook2.setVisible(false);
        bookName2.setVisible(false);
        typeAndAuthor2.setVisible(false);
        numberLeft2.setVisible(false);
        rate2.setVisible(false);
    }
    public void HideThirdBar() {
        imageBook3.setVisible(false);
        bookName3.setVisible(false);
        typeAndAuthor3.setVisible(false);
        numberLeft3.setVisible(false);
        rate3.setVisible(false);
    }
    
    public void ShowFirstBar() {
        imageBook1.setVisible(true);
        bookName1.setVisible(true);
        typeAndAuthor1.setVisible(true);
        numberLeft1.setVisible(true);
        rate1.setVisible(true);
    }
    public void ShowSecondBar() {
        imageBook2.setVisible(true);
        bookName2.setVisible(true);
        typeAndAuthor2.setVisible(true);
        numberLeft2.setVisible(true);
        rate2.setVisible(true);
    }
    public void ShowThirdBar() {
        imageBook3.setVisible(true);
        bookName3.setVisible(true);
        typeAndAuthor3.setVisible(true);
        numberLeft3.setVisible(true);
        rate3.setVisible(true);
    }
    
    public void updateUI() throws SQLException{
        
        UserPickBook fav = new UserPickBook(UIVars.userID);
        pageCap = (int)Math.ceil(fav.getCount() / 3.0);
        pageCount.setText("Page " + page + " of " + pageCap);
        if (pageCap <= 0) {
            noResult.setText("You don't have any favorite books.");
            HideFirstBar();
            HideSecondBar();
            HideThirdBar();
        }
        else {
            
            ArrayList bookList = fav.getBookIDList();
            n = 0+( (page-1) * 3);
            
            PhysicalBook book1 = new PhysicalBook( bookList.get(n).toString() );
            
            bookName = book1.getName();
            imageBook1.setText(bookName);
            bookName1.setText(bookName);
            typeAndAuthor1.setText("Type: " + book1.getType() 
                    + " /  Author: " + book1.getAuthor());
            numberLeft1.setText("Remaining: " + book1.getRemaining());
            rate1.setText("Rating: [WIP]");
            
            n = 1+( (page-1) * 3);
            if (n < fav.getCount()) {
                ShowSecondBar();
                PhysicalBook book2 = new PhysicalBook( bookList.get(n).toString() );
                bookName = book2.getName();
                imageBook2.setText(bookName);
                bookName2.setText(bookName);
                typeAndAuthor2.setText("Type: " + book2.getType() 
                    + " /  Author: " + book2.getAuthor());
                numberLeft2.setText("Remaining: " + book2.getRemaining());
                rate2.setText("Rating: [WIP]");
            }
            else HideSecondBar();
            
            n = 2+( (page-1) * 3);
            if (n < fav.getCount()) {
                ShowThirdBar();
                 PhysicalBook book3 = new PhysicalBook( bookList.get(n).toString() );
                bookName = book3.getName();
                imageBook3.setText(bookName);
                bookName3.setText(bookName);
                typeAndAuthor3.setText("Type: " + book3.getType() 
                    + " /  Author: " + book3.getAuthor());
                numberLeft3.setText("Remaining: " + book3.getRemaining());
                rate3.setText("Rating: [WIP]");
            }
           else HideThirdBar();    
            
        }
    }
    
    public void gotoBookPage(String bookName) {
        if (!bookName.equals("-") && !bookName.equals("")) {
            BookPage bp = new BookPage(bookName);
            bp.setVisible(true);
            setVisible(false);
            dispose();
        }
        else {
            System.out.println("Empty book.");    
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        accountButton = new javax.swing.JButton();
        notifButton = new javax.swing.JButton();
        logo = new javax.swing.JButton();
        panel1 = new javax.swing.JPanel();
        backLine = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        imageBook1 = new javax.swing.JButton();
        bookName1 = new javax.swing.JLabel();
        typeAndAuthor1 = new javax.swing.JLabel();
        numberLeft1 = new javax.swing.JLabel();
        rate1 = new javax.swing.JLabel();
        noResult = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        imageBook2 = new javax.swing.JButton();
        numberLeft2 = new javax.swing.JLabel();
        typeAndAuthor2 = new javax.swing.JLabel();
        bookName2 = new javax.swing.JLabel();
        rate2 = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        imageBook3 = new javax.swing.JButton();
        rate3 = new javax.swing.JLabel();
        typeAndAuthor3 = new javax.swing.JLabel();
        numberLeft3 = new javax.swing.JLabel();
        bookName3 = new javax.swing.JLabel();
        prevButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        pageCount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library");
        setBackground(new java.awt.Color(255, 153, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        accountButton.setBackground(new java.awt.Color(255, 204, 153));
        accountButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/account.png"))); // NOI18N
        accountButton.setContentAreaFilled(false);
        accountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountButtonActionPerformed(evt);
            }
        });
        topPanel.add(accountButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 0, 50, 55));

        notifButton.setBackground(new java.awt.Color(255, 204, 153));
        notifButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/notif.png"))); // NOI18N
        notifButton.setContentAreaFilled(false);
        notifButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notifButtonActionPerformed(evt);
            }
        });
        topPanel.add(notifButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 0, 56, -1));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LibraryLogoSmall_1.png"))); // NOI18N
        logo.setBorderPainted(false);
        logo.setContentAreaFilled(false);
        logo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoActionPerformed(evt);
            }
        });
        topPanel.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 4, 100, 50));

        getContentPane().add(topPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 945, -1));

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setPreferredSize(new java.awt.Dimension(920, 230));

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

        imageBook1.setText("-");
        imageBook1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageBook1ActionPerformed(evt);
            }
        });

        bookName1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        bookName1.setText("Book Name");

        typeAndAuthor1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        typeAndAuthor1.setText("Type+Author");

        numberLeft1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        numberLeft1.setText("Left");

        rate1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rate1.setText("Rate");

        noResult.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        noResult.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        noResult.setText("You don't have any favorite books.");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backLine, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(imageBook1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookName1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeAndAuthor1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rate1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(noResult, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(back)
                    .addComponent(backLine))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageBook1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(noResult)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bookName1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeAndAuthor1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numberLeft1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rate1)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 61, 945, -1));

        panel2.setBackground(new java.awt.Color(255, 249, 217));
        panel2.setPreferredSize(new java.awt.Dimension(172, 200));

        imageBook2.setText("-");
        imageBook2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageBook2ActionPerformed(evt);
            }
        });

        numberLeft2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        numberLeft2.setText("Left");

        typeAndAuthor2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        typeAndAuthor2.setText("Type+Author");

        bookName2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        bookName2.setText("Book Name");

        rate2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rate2.setText("Rate");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(imageBook2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bookName2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeAndAuthor2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberLeft2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rate2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(327, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageBook2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bookName2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeAndAuthor2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numberLeft2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rate2)
                .addGap(46, 46, 46))
        );

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 945, 190));

        panel3.setBackground(new java.awt.Color(255, 255, 255));
        panel3.setPreferredSize(new java.awt.Dimension(170, 200));

        imageBook3.setText("-");
        imageBook3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageBook3ActionPerformed(evt);
            }
        });

        rate3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rate3.setText("Rate");

        typeAndAuthor3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        typeAndAuthor3.setText("Type+Author");

        numberLeft3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        numberLeft3.setText("Left");

        bookName3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        bookName3.setText("Book Name");

        prevButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrowPrev.png"))); // NOI18N
        prevButton.setContentAreaFilled(false);
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrowNext.png"))); // NOI18N
        nextButton.setContentAreaFilled(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        pageCount.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        pageCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pageCount.setText("Page 1 of 5");

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(imageBook3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookName3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeAndAuthor3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberLeft3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rate3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pageCount, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(317, Short.MAX_VALUE))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imageBook3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(bookName3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeAndAuthor3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numberLeft3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rate3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                        .addComponent(pageCount)
                        .addGap(22, 22, 22))))
        );

        getContentPane().add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 945, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        MemberPage menu = new MemberPage();
        menu.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void imageBook2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageBook2ActionPerformed
        gotoBookPage(bookName2.getText());
    }//GEN-LAST:event_imageBook2ActionPerformed

    private void imageBook1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageBook1ActionPerformed
        gotoBookPage(bookName1.getText());
    }//GEN-LAST:event_imageBook1ActionPerformed

    private void imageBook3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageBook3ActionPerformed
        gotoBookPage(bookName3.getText());
    }//GEN-LAST:event_imageBook3ActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        try {
            if (page > 1) {
            page--;
            updateUI();
        }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_prevButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        try {
            if (page < pageCap) {
            page++;
            updateUI();
        }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_nextButtonActionPerformed

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

    private void searchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMouseClicked
        String x = searchField.getText();     
        if (x.equals("search")) searchField.setText("");
    }//GEN-LAST:event_searchFieldMouseClicked

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
    private javax.swing.JButton accountButton;
    private javax.swing.JButton back;
    private javax.swing.JLabel backLine;
    private javax.swing.JLabel bookName1;
    private javax.swing.JLabel bookName2;
    private javax.swing.JLabel bookName3;
    private javax.swing.JButton imageBook1;
    private javax.swing.JButton imageBook2;
    private javax.swing.JButton imageBook3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logo;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel noResult;
    private javax.swing.JButton notifButton;
    private javax.swing.JLabel numberLeft1;
    private javax.swing.JLabel numberLeft2;
    private javax.swing.JLabel numberLeft3;
    private javax.swing.JLabel pageCount;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JButton prevButton;
    private javax.swing.JLabel rate1;
    private javax.swing.JLabel rate2;
    private javax.swing.JLabel rate3;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel typeAndAuthor1;
    private javax.swing.JLabel typeAndAuthor2;
    private javax.swing.JLabel typeAndAuthor3;
    // End of variables declaration//GEN-END:variables
}
