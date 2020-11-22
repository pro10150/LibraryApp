package librarian;

import Backdoor.*;
import Member.BookPage;
import Member.LoginScreen;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.sql.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class LibrarianSearchBook extends javax.swing.JFrame {
        
    public LibrarianSearchBook() {
        initComponents();
        
    }
    
    Search sc;
    
    public LibrarianSearchBook(String searchQuery) throws SQLException{
        initComponents();
        
        this.searchQuery = searchQuery;
        noResult.setText("Search result");
        updateSearch(searchQuery);
    }
    
    String searchQuery;
    String bookName,bookID1,bookID2,bookID3;
    int pageCap;
    int n;
    int page = 1;
    
    public void HideFirstBar() {
        imageBook1.setVisible(false);
        bookName1.setVisible(false);
        typeAndAuthor1.setVisible(false);
        numberLeft1.setVisible(false);
        rate1.setVisible(false);
        Edit1.setVisible(false);
        Delete1.setVisible(false);
    }
    public void HideSecondBar() {
        imageBook2.setVisible(false);
        bookName2.setVisible(false);
        typeAndAuthor2.setVisible(false);
        numberLeft2.setVisible(false);
        rate2.setVisible(false);
        Edit2.setVisible(false);
        Delete2.setVisible(false);
    }
    public void HideThirdBar() {
        imageBook3.setVisible(false);
        bookName3.setVisible(false);
        typeAndAuthor3.setVisible(false);
        numberLeft3.setVisible(false);
        rate3.setVisible(false);
        Edit3.setVisible(false);
        Delete3.setVisible(false);
    }
    
    public void ShowFirstBar() {
        imageBook1.setVisible(true);
        bookName1.setVisible(true);
        typeAndAuthor1.setVisible(true);
        numberLeft1.setVisible(true);
        rate1.setVisible(true);
        Edit1.setVisible(true);
        Delete1.setVisible(true);
    }
    public void ShowSecondBar() {
        imageBook2.setVisible(true);
        bookName2.setVisible(true);
        typeAndAuthor2.setVisible(true);
        numberLeft2.setVisible(true);
        rate2.setVisible(true);
        Edit2.setVisible(true);
        Delete2.setVisible(true);
    }
    public void ShowThirdBar() {
        imageBook3.setVisible(true);
        bookName3.setVisible(true);
        typeAndAuthor3.setVisible(true);
        numberLeft3.setVisible(true);
        rate3.setVisible(true);
        Edit3.setVisible(true);
        Delete3.setVisible(true);
    }
    
    public void updateSearch(String searchQuery) throws SQLException{
        
        Search sc = new Search();
        sc.searchBook(searchQuery);
        pageCap = (int)Math.ceil(sc.getIDCount() / 3.0);
        pageCount.setText("Page " + page + " of " + pageCap);
        if (pageCap <= 0) {
            noResult.setText("There are no results.");
            HideFirstBar();
            HideSecondBar();
            HideThirdBar();
        }
        else {
            n = 0+( (page-1) * 3);
            PhysicalBook book1 = new PhysicalBook(sc.getnthID(n));
            bookName = book1.getName();
            bookID1 = book1.getBookID();
            imageBook1.setText(bookName);
            bookName1.setText(bookName);
            typeAndAuthor1.setText("Type: " + book1.getType() 
                    + " /  Author: " + book1.getAuthor());
            numberLeft1.setText("Remaining: " + book1.getRemaining());
            rate1.setText("Rating: [WIP]");
            javax.swing.ImageIcon icon1;
            if(book1.getImageLocation() == null){
                icon1 = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon1 = new javax.swing.ImageIcon(getClass().getResource(book1.getImageLocation()));
            }
            Image img1 = icon1.getImage();
            Image modImg1 = img1.getScaledInstance(120,156, Image.SCALE_SMOOTH);
            icon1 = new ImageIcon(modImg1);
            imageBook1.setIcon(icon1);
            imageBook1.setText("");
            
            n = 1+( (page-1) * 3);
            PhysicalBook book2 = new PhysicalBook(sc.getnthID(n));
            bookName = book2.getName();
            bookID2 = book2.getBookID();
            imageBook2.setText(bookName);
            bookName2.setText(bookName);
            if (bookName2.getText() == null) {
                 HideSecondBar();
            }
            else ShowSecondBar();
            typeAndAuthor2.setText("Type: " + book2.getType() 
                    + " /  Author: " + book2.getAuthor());
            numberLeft2.setText("Remaining: " + book2.getRemaining());
            rate2.setText("Rating: [WIP]");
            javax.swing.ImageIcon icon2;
            if(book2.getImageLocation() == null){
                icon2 = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon2 = new javax.swing.ImageIcon(getClass().getResource(book2.getImageLocation()));
            }
            Image img2 = icon2.getImage();
            Image modImg2 = img2.getScaledInstance(120,157, Image.SCALE_SMOOTH);
            icon2 = new ImageIcon(modImg2);
            imageBook2.setIcon(icon2);
            imageBook2.setText("");
            
            n = 2+( (page-1) * 3);
            PhysicalBook book3 = new PhysicalBook(sc.getnthID(n));
            bookName = book3.getName();
            bookID3 = book3.getBookID();
            imageBook3.setText(bookName);
            bookName3.setText(bookName);
            if (bookName3.getText() == null) {
                 HideThirdBar();
            }
            else ShowThirdBar();
            typeAndAuthor3.setText("Type: " + book3.getType() 
                    + " /  Author: " + book3.getAuthor());
            numberLeft3.setText("Remaining: " + book3.getRemaining());
            rate3.setText("Rating: [WIP]");
            javax.swing.ImageIcon icon3;
            if(book3.getImageLocation() == null){
                icon3 = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon3 = new javax.swing.ImageIcon(getClass().getResource(book3.getImageLocation()));
            }
            Image img3 = icon3.getImage();
            Image modImg3 = img3.getScaledInstance(120,156, Image.SCALE_SMOOTH);
            icon3 = new ImageIcon(modImg3);
            imageBook3.setIcon(icon3);
            imageBook3.setText("");
            
        }
    }
    
    public void gotoBookPage(String bookName) {
        if (!bookName.equals("-") && !bookName.equals("")) {
            LibrarianBookPage bp = new LibrarianBookPage(bookName,searchQuery);
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
        Edit1 = new javax.swing.JButton();
        Delete1 = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        imageBook2 = new javax.swing.JButton();
        numberLeft2 = new javax.swing.JLabel();
        typeAndAuthor2 = new javax.swing.JLabel();
        bookName2 = new javax.swing.JLabel();
        rate2 = new javax.swing.JLabel();
        Edit2 = new javax.swing.JButton();
        Delete2 = new javax.swing.JButton();
        panel3 = new javax.swing.JPanel();
        imageBook3 = new javax.swing.JButton();
        rate3 = new javax.swing.JLabel();
        typeAndAuthor3 = new javax.swing.JLabel();
        numberLeft3 = new javax.swing.JLabel();
        bookName3 = new javax.swing.JLabel();
        prevButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        pageCount = new javax.swing.JLabel();
        Edit3 = new javax.swing.JButton();
        Delete3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library");
        setBackground(new java.awt.Color(255, 153, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topPanel.setBackground(new java.awt.Color(255, 204, 153));
        topPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        noResult.setText("There are no results.");

        Edit1.setText("Edit");
        Edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit1ActionPerformed(evt);
            }
        });

        Delete1.setText("Delete");
        Delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backLine, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(imageBook1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bookName1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(typeAndAuthor1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numberLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rate1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(499, 499, 499)
                                .addComponent(Edit1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Delete1)
                        .addGap(122, 122, 122))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(noResult, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))))
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
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(typeAndAuthor1)
                            .addComponent(Edit1)
                            .addComponent(Delete1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numberLeft1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rate1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        Edit2.setText("Edit");
        Edit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit2ActionPerformed(evt);
            }
        });

        Delete2.setText("Delete");
        Delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete2ActionPerformed(evt);
            }
        });

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
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(typeAndAuthor2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(Edit2)
                        .addGap(49, 49, 49)
                        .addComponent(Delete2))
                    .addComponent(numberLeft2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rate2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
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
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Delete2)
                    .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(typeAndAuthor2)
                        .addComponent(Edit2)))
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

        Edit3.setText("Edit");
        Edit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit3ActionPerformed(evt);
            }
        });

        Delete3.setText("Delete");
        Delete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete3ActionPerformed(evt);
            }
        });

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
                            .addComponent(numberLeft3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rate3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bookName3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addComponent(typeAndAuthor3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(Edit3)))
                                .addGap(48, 48, 48)
                                .addComponent(Delete3))))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pageCount, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(120, Short.MAX_VALUE))
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
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(bookName3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(typeAndAuthor3))
                            .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Edit3)
                                .addComponent(Delete3)))
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

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        findpage menu = new findpage();
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
            updateSearch(this.searchQuery);
        }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_prevButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        try {
            if (page < pageCap) {
            page++;
            updateSearch(this.searchQuery);
        }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void logoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoActionPerformed
        librarian_profile menu = null;
        try {
            menu = new librarian_profile();
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianSearchBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        menu.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_logoActionPerformed

    private void Delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete1ActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Do you want to remove the book?", "Confirmation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (input == 0) { // Yes
            PhysicalBook book = null;
            try {
                // TODO add your handling code here:
                book = new PhysicalBook(bookID1);
            } catch (SQLException ex) {
                Logger.getLogger(LibrarianSearchBook.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                book.deletePhysicalBook();
            } catch (SQLException ex) {
                Logger.getLogger(LibrarianSearchBook.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Done");
            findpage fp = new findpage();
            fp.setVisible(true);
            setVisible(false);
            dispose();
        }
    }//GEN-LAST:event_Delete1ActionPerformed

    private void Delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete2ActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Do you want to remove the book?", "Confirmation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (input == 0) { // Yes
            PhysicalBook book = null;
            try {
                // TODO add your handling code here:
                book = new PhysicalBook(bookID2);
            } catch (SQLException ex) {
                Logger.getLogger(LibrarianSearchBook.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                book.deletePhysicalBook();
            } catch (SQLException ex) {
                Logger.getLogger(LibrarianSearchBook.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Done");
            findpage fp = new findpage();
            fp.setVisible(true);
            setVisible(false);
            dispose();
        }
    }//GEN-LAST:event_Delete2ActionPerformed

    private void Delete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete3ActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Do you want to remove the book?", "Confirmation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (input == 0) { // Yes {
        PhysicalBook book = null;
        try {
            // TODO add your handling code here:
            book = new PhysicalBook(bookID1);
            book.deleteBorrowedBook();
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianSearchBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            book.deletePhysicalBook();
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianSearchBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(null, "Done");
        findpage fp = new findpage();
        fp.setVisible(true);
        setVisible(false);
        dispose();
        }
    }//GEN-LAST:event_Delete3ActionPerformed

    private void Edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit1ActionPerformed
        // TODO add your handling code here:
        Edit edit1 = null;
        try{
            edit1 = new Edit (bookID1);
        }catch (SQLException ex) {
            Logger.getLogger(LibrarianSearchBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        edit1.setVisible(true);
        setVisible(false);
        dispose();
        
    }//GEN-LAST:event_Edit1ActionPerformed

    private void Edit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit2ActionPerformed
        // TODO add your handling code here:
        Edit edit2 = null;
        try{
            edit2 = new Edit (bookID1);
        }catch (SQLException ex) {
            Logger.getLogger(LibrarianSearchBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        edit2.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_Edit2ActionPerformed

    private void Edit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit3ActionPerformed
        // TODO add your handling code here:
        Edit edit3 = null;
        try{
            edit3 = new Edit (bookID1);
        }catch (SQLException ex) {
            Logger.getLogger(LibrarianSearchBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        edit3.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_Edit3ActionPerformed

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
    private javax.swing.JButton Delete1;
    private javax.swing.JButton Delete2;
    private javax.swing.JButton Delete3;
    private javax.swing.JButton Edit1;
    private javax.swing.JButton Edit2;
    private javax.swing.JButton Edit3;
    private javax.swing.JButton back;
    private javax.swing.JLabel backLine;
    private javax.swing.JLabel bookName1;
    private javax.swing.JLabel bookName2;
    private javax.swing.JLabel bookName3;
    private javax.swing.JButton imageBook1;
    private javax.swing.JButton imageBook2;
    private javax.swing.JButton imageBook3;
    private javax.swing.JButton logo;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel noResult;
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
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel typeAndAuthor1;
    private javax.swing.JLabel typeAndAuthor2;
    private javax.swing.JLabel typeAndAuthor3;
    // End of variables declaration//GEN-END:variables
}
