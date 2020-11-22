package Member;

import Backdoor.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.sql.*; 
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import librarian.check_fee;

/**
 *
 * @author Annop Boonlieng
 */

public class Main extends javax.swing.JFrame {
    
    int rowLimit = 100;
    
    String[] featuredBook = new String[rowLimit];
    
    String[] featAudioBook = new String[rowLimit];
    
    String[] recommendedBook = new String[rowLimit];

    int featuredIDCount;
    int featAudioBookIDCount;
    int recommendedIDCount;
    String [] featutatedBookCover;
    javax.swing.ImageIcon icon;
    Image img;
    Image modImg;
    
    int page1 = 0;
    int page2 = 0;
    int page3 = 0;
    
    int pageCap1 = (featuredIDCount-1) / 7;
    int pageCap2;
    int pageCap3;
        
    public Main(){
        initComponents();
        // Tab 1
        try{
          Search sc = new Search("rating");
          sc.searchBook(null);
          pageCap1 = (sc.getIDCount() - 1) / 7;
          int i = 0;
          PhysicalBook bookfav;
          while (i < sc.getIDCount()) {
              bookfav = new PhysicalBook( sc.getnthID(i));
              featuredBook[i] = bookfav.getBookID();
              i++;
          } 
          featuredIDCount = sc.getIDCount();
        } catch (Exception e) {System.out.println(e);} 
        updateRecommended();
        // Tab 2
        try{
            UserPickBook fav = new UserPickBook(UIVars.userID);
            int i = 0;
            int bookAudioCount = 0;
            AudioBook bookAudio;
            ArrayList bookList = fav.getBookIDList();
            PhysicalBook bookfav;
            
            while (i < fav.getCount()) {
                bookfav = new PhysicalBook( bookList.get(i).toString() );
                bookAudio = new AudioBook(bookfav.getName());
                if (bookAudio.getBookExisting() == true) {
                    featAudioBook[bookAudioCount] = bookAudio.getBookID();
                    bookAudioCount++;
                }

                i++;
            }
            pageCap2 = (bookAudioCount -1 ) / 7;

            featAudioBookIDCount = bookAudioCount;
            updateAudioBook();
            } catch (SQLException ex) {
                  Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }
        // Tab 3
         try{
            UserPickBook fav = new UserPickBook(UIVars.userID);
            pageCap3 = (fav.getCount() -1 ) / 7;
            ArrayList bookList = fav.getBookIDList();
            PhysicalBook bookfav;
            
            int i = 0;
            while (i < fav.getCount() && i < rowLimit) {
                bookfav = new PhysicalBook( bookList.get(i).toString() );
                recommendedBook[i] = bookfav.getBookID();
                //featutatedBookCover [i] = bookfav.getImageLocation();
                
                /*javax.swing.ImageIcon icon;
                if(bookfav.getImageLocation() == null){
                    icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
                }
                else{
                    icon = new javax.swing.ImageIcon(getClass().getResource(bookfav.getImageLocation()));
                }
                Image img = icon.getImage();
                Image modImg = img.getScaledInstance(101,101, Image.SCALE_SMOOTH);
                icon = new ImageIcon(modImg);
                imageC1.setIcon(icon);
                imageC1.setText("");*/
                i++;
            }
            recommendedIDCount = fav.getCount();
            updateFavorite();
            } catch (Exception e) {System.out.println(e);} 
        
    }
    // The update list methods are long so I have to
    // fold the methods.
    // <editor-fold defaultstate="collapsed" desc="update methods">
    int ptr;
    public void updateRecommended() {
        ptr = 0+7*page1;      
        if (ptr < featuredIDCount) {
            if (getBookImage(featuredBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(featuredBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageA1.setIcon(icon);
            //imageA1.setBounds(ptr, ptr, 95, 95);
            //imageC1.setVisible(true);
            //imageC1.setText(getBookImage(recommendedBook[ptr]));
            //imageA1.setVisible(true);
            bookNameA1.setText(getName(featuredBook[ptr]));
            //imageA1.setSize(80,95);
            imageA1.setText("");
            imageA1.setVisible(true);
            bookNameA1.setSize(101,101);
            bookNameA1.setVisible(true);
        }
        else {
            imageA1.setVisible(false);
            bookNameA1.setVisible(false);
        }
        ptr++;
        if (ptr < featuredIDCount) {
            if (getBookImage(featuredBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(featuredBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageA2.setIcon(icon);
            //imageC1.setVisible(true);
            //imageC1.setText(getBookImage(recommendedBook[ptr]));
            //imageA1.setVisible(true);
            bookNameA2.setText(getName(featuredBook[ptr]));
            bookA2.setSize(95, 95);
            imageA2.setSize(101,101);
            imageA2.setText("");
            imageA2.setVisible(true);
            bookNameA2.setVisible(true);
        }
        else {
            imageA2.setVisible(false);
            bookNameA2.setVisible(false);
        }
        ptr++;
        if (ptr < featuredIDCount) {
            if (getBookImage(featuredBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(featuredBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageA3.setIcon(icon);
            //imageC1.setVisible(true);
            //imageC1.setText(getBookImage(recommendedBook[ptr]));
            //imageA1.setVisible(true);
            bookNameA3.setText(getName(featuredBook[ptr]));
            imageA3.setSize(101,101);
            imageA3.setText("");
            imageA3.setVisible(true);
            bookNameA3.setVisible(true);
        }
        else {
            imageA3.setVisible(false);
            bookNameA3.setVisible(false);
        }
        ptr++;
        if (ptr < featuredIDCount) {
            if (getBookImage(featuredBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(featuredBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageA4.setIcon(icon);
            //imageC1.setVisible(true);
            //imageC1.setText(getBookImage(recommendedBook[ptr]));
            //imageA1.setVisible(true);
            bookNameA4.setText(getName(featuredBook[ptr]));
            imageA4.setSize(101,101);
            imageA4.setText("");
            imageA4.setVisible(true);
            bookNameA4.setVisible(true);
        }
        else {
            imageA4.setVisible(false);
            bookNameA4.setVisible(false);
        }
        ptr++;
        if (ptr < featuredIDCount) {
            if (getBookImage(featuredBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(featuredBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageA5.setIcon(icon);
            //imageC1.setVisible(true);
            //imageC1.setText(getBookImage(recommendedBook[ptr]));
            //imageA1.setVisible(true);
            bookNameA5.setText(getName(featuredBook[ptr]));
            imageA5.setSize(101,101);
            imageA5.setText("");
            imageA5.setVisible(true);
            bookNameA5.setVisible(true);
        }
        else {
            imageA5.setVisible(false);
            bookNameA5.setVisible(false);
        }
        ptr++;
        if (ptr < featuredIDCount) {
            if (getBookImage(featuredBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(featuredBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageA6.setIcon(icon);
            //imageC1.setVisible(true);
            //imageC1.setText(getBookImage(recommendedBook[ptr]));
            //imageA1.setVisible(true);
            bookNameA6.setText(getName(featuredBook[ptr]));
            imageA6.setSize(101,101);
            imageA6.setText("");
            imageA6.setVisible(true);
            bookNameA6.setVisible(true);
        }
        else {
            imageA6.setVisible(false);
            bookNameA6.setVisible(false);
        }
        ptr++;
        if (ptr < featuredIDCount) {
            if (getBookImage(featuredBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(featuredBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageA7.setIcon(icon);
            //imageC1.setVisible(true);
            //imageC1.setText(getBookImage(recommendedBook[ptr]));
            //imageA1.setVisible(true);
            bookNameA7.setText(getName(featuredBook[ptr]));
            imageA7.setSize(101,101);
            imageA7.setText("");
            imageA7.setVisible(true);
            bookNameA7.setVisible(true);
        }
        else {
            imageA7.setVisible(false);
            bookNameA7.setVisible(false);
        }
    }
    public void updateAudioBook() {
        ptr = 0+7*page2;      
        if (ptr < featAudioBookIDCount) {
            if (getBookImage(featAudioBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(featAudioBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageB1.setIcon(icon);
            //imageC1.setVisible(true);
            //imageC1.setText(getBookImage(recommendedBook[ptr]));
            //imageA1.setVisible(true);
            bookNameB1.setText(getName(featAudioBook[ptr]));
            imageB1.setSize(101,101);
            imageB1.setText("");
            imageB1.setVisible(true);
            bookNameB1.setVisible(true);
            imageB1.setVisible(true);
            bookNameB1.setVisible(true);
        }
        else {
            imageB1.setVisible(false);
            bookNameB1.setVisible(false);
        }
        ptr++;
        if (ptr < featAudioBookIDCount) {
            imageB2.setText(getBookImage(featAudioBook[ptr]));
            bookNameB2.setText(getName(featAudioBook[ptr]));
            if (getBookImage(featAudioBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(featAudioBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageB2.setIcon(icon);
            //imageC1.setVisible(true);
            //imageC1.setText(getBookImage(recommendedBook[ptr]));
            //imageA1.setVisible(true);
            bookNameB2.setText(getName(featAudioBook[ptr]));
            imageB2.setSize(101,101);
            imageB2.setText("");
            imageB2.setVisible(true);
            bookNameB1.setVisible(true);
            imageB2.setVisible(true);
            bookNameB2.setVisible(true);
        }
        else {
            imageB2.setVisible(false);
            bookNameB2.setVisible(false);
        }
        ptr++;
        if (ptr < featAudioBookIDCount) {
            imageB3.setText(getBookImage(featAudioBook[ptr]));
            bookNameB3.setText(getName(featAudioBook[ptr]));
            if (getBookImage(featAudioBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(featAudioBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageB3.setIcon(icon);
            //imageC1.setVisible(true);
            //imageC1.setText(getBookImage(recommendedBook[ptr]));
            //imageA1.setVisible(true);
            bookNameB3.setText(getName(featAudioBook[ptr]));
            imageB3.setSize(101,101);
            imageB3.setText("");
            imageB3.setVisible(true);
            bookNameB3.setVisible(true);
            imageB3.setVisible(true);
            bookNameB3.setVisible(true);
        }
        else {
            imageB3.setVisible(false);
            bookNameB3.setVisible(false);
        }
        ptr++;
        if (ptr < featAudioBookIDCount) {
            if (getBookImage(featAudioBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(featAudioBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageB4.setIcon(icon);
            //imageC1.setVisible(true);
            //imageC1.setText(getBookImage(recommendedBook[ptr]));
            //imageA1.setVisible(true);
            bookNameB4.setText(getName(featAudioBook[ptr]));
            imageB4.setSize(101,101);
            imageB4.setText("");
            imageB4.setVisible(true);
            bookNameB4.setVisible(true);
            imageB4.setVisible(true);
            bookNameB4.setVisible(true);
        }
        else {
            imageB4.setVisible(false);
            bookNameB4.setVisible(false);
        }
        ptr++;
        if (ptr < featAudioBookIDCount) {
            if (getBookImage(featAudioBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(featAudioBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageB5.setIcon(icon);
            bookNameB5.setText(getName(featAudioBook[ptr]));
            imageB5.setSize(101,101);
            imageB5.setText("");
            imageB5.setVisible(true);
            bookNameB5.setVisible(true);
            imageB5.setVisible(true);
            bookNameB5.setVisible(true);
        }
        else {
            imageB5.setVisible(false);
            bookNameB5.setVisible(false);
        }
        ptr++;
        if (ptr < featAudioBookIDCount) {
            if (getBookImage(featAudioBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(featAudioBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageB6.setIcon(icon);
            bookNameB6.setText(getName(featAudioBook[ptr]));
            imageB6.setSize(101,101);
            imageB6.setText("");
            imageB6.setVisible(true);
            bookNameB6.setVisible(true);
            imageB6.setVisible(true);
            bookNameB6.setVisible(true);
        }
        else {
            imageB6.setVisible(false);
            bookNameB6.setVisible(false);
        }
        ptr++;
        if (ptr < featAudioBookIDCount) {
            if (getBookImage(featAudioBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(featAudioBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageB7.setIcon(icon);
            bookNameB7.setText(getName(featAudioBook[ptr]));
            imageB7.setSize(101,101);
            imageB7.setText("");
            imageB7.setVisible(true);
            bookNameB7.setVisible(true);
            imageB7.setVisible(true);
            bookNameB7.setVisible(true);
        }
        else {
            imageB7.setVisible(false);
            bookNameB7.setVisible(false);
        }
    }
    public void updateFavorite() {
        ptr = 0+7*page3;      
        if (ptr < recommendedIDCount) {
            if (getBookImage(recommendedBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(recommendedBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageC1.setIcon(icon);
            bookNameC1.setText(getName(recommendedBook[ptr]));
            imageC1.setSize(101,101);
            imageC1.setText("");
            imageC1.setVisible(true);
            bookNameC1.setVisible(true);
            imageC1.setVisible(true);
            bookNameC1.setVisible(true);/*
            if(featutatedBookCover[ptr] == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(featutatedBookCover[ptr]));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(101,101, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageC1.setIcon(icon);
            imageC1.setVisible(true);*/
        }
        else {
            imageC1.setVisible(false);
            bookNameC1.setVisible(false);
        }
        ptr++;
        if (ptr < recommendedIDCount) {
            if (getBookImage(recommendedBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(recommendedBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageC2.setIcon(icon);
            bookNameC2.setText(getName(recommendedBook[ptr]));
            imageC2.setSize(101,101);
            imageC2.setText("");
            imageC2.setVisible(true);
            bookNameC2.setVisible(true);
            imageC2.setVisible(true);
            bookNameC2.setVisible(true);
            
        }
        
        else {
            imageC2.setVisible(false);
            bookNameC2.setVisible(false);
        }
        ptr++;
        if (ptr < recommendedIDCount) {
            if (getBookImage(recommendedBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(recommendedBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageC3.setIcon(icon);
            bookNameC3.setText(getName(recommendedBook[ptr]));
            imageC3.setSize(101,101);
            imageC3.setText("");
            imageC3.setVisible(true);
            bookNameC3.setVisible(true);
            imageC3.setVisible(true);
            bookNameC3.setVisible(true);
            
        }
        else {
            imageC3.setVisible(false);
            bookNameC3.setVisible(false);
        }
        ptr++;
        if (ptr < recommendedIDCount) {
            if (getBookImage(recommendedBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(recommendedBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageC4.setIcon(icon);
            bookNameC4.setText(getName(recommendedBook[ptr]));
            imageC4.setSize(101,101);
            imageC4.setText("");
            imageC4.setVisible(true);
            bookNameC4.setVisible(true);
            imageC4.setVisible(true);
            bookNameC4.setVisible(true);
            
        }else {
            imageC4.setVisible(false);
            bookNameC4.setVisible(false);
        }
        ptr++;
        if (ptr < recommendedIDCount) {
            if (getBookImage(recommendedBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(recommendedBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageC5.setIcon(icon);
            bookNameC5.setText(getName(recommendedBook[ptr]));
            imageC5.setSize(101,101);
            imageC5.setText("");
            imageC5.setVisible(true);
            bookNameC5.setVisible(true);
            imageC5.setVisible(true);
            bookNameC5.setVisible(true);
            
        }
        else {
            imageC5.setVisible(false);
            bookNameC5.setVisible(false);
        }
        ptr++;
        if (ptr < recommendedIDCount) {
            if (getBookImage(recommendedBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(recommendedBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageC6.setIcon(icon);
            bookNameC6.setText(getName(recommendedBook[ptr]));
            imageC6.setSize(101,101);
            imageC6.setText("");
            imageC6.setVisible(true);
            bookNameC6.setVisible(true);
            imageC6.setVisible(true);
            bookNameC6.setVisible(true);
            
        }
        else {
            imageC6.setVisible(false);
            bookNameC6.setVisible(false);
        }
        ptr++;
        if (ptr < recommendedIDCount) {
            if (getBookImage(recommendedBook[ptr]) == null){
                icon = new javax.swing.ImageIcon(getClass().getResource("/bookCover/Untitled.jpg"));
            }
            else{
                icon = new javax.swing.ImageIcon(getClass().getResource(getBookImage(recommendedBook[ptr])));
            }
            img = icon.getImage();
            modImg = img.getScaledInstance(80,95, Image.SCALE_SMOOTH);
            icon = new ImageIcon(modImg);
            imageC7.setIcon(icon);
            bookNameC7.setText(getName(recommendedBook[ptr]));
            imageC7.setSize(101,101);
            imageC7.setText("");
            imageC7.setVisible(true);
            bookNameC7.setVisible(true);
            imageC7.setVisible(true);
            bookNameC7.setVisible(true);
            
        }
        else {
            imageC7.setVisible(false);
            bookNameC7.setVisible(false);
        }
    }
    // </editor-fold>
    //
    public static String getBookImage(String bookName) {
        String result = null;
        try{
            PhysicalBook book = new PhysicalBook(bookName);
            result = book.getImageLocation();
            } catch (Exception e) {System.out.println(e);} 
        return result;
    }
    
    public static String getName(String bookName) {
        String result = null;
        try{
            Book book = new PhysicalBook(bookName);
            result = book.getName();
            } catch (Exception e) {System.out.println(e);} 
        return result;
    }
    
    public void gotoBookPage(String bookName) {
        BookPage bp = new BookPage(bookName);
        bp.setVisible(true);
        setVisible(false);
        dispose();
    }
    
    public void gotoAudioBookPage(String bookName) {
            AudioBookPage bp = new AudioBookPage(bookName);
            bp.setVisible(true);
            setVisible(false);
            dispose();
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
        recommended = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        bookA1 = new javax.swing.JPanel();
        imageA1 = new javax.swing.JButton();
        bookNameA1 = new javax.swing.JLabel();
        bookA2 = new javax.swing.JPanel();
        bookNameA2 = new javax.swing.JLabel();
        imageA2 = new javax.swing.JButton();
        bookA3 = new javax.swing.JPanel();
        imageA3 = new javax.swing.JButton();
        bookNameA3 = new javax.swing.JLabel();
        bookA4 = new javax.swing.JPanel();
        bookNameA4 = new javax.swing.JLabel();
        imageA4 = new javax.swing.JButton();
        bookA5 = new javax.swing.JPanel();
        imageA5 = new javax.swing.JButton();
        bookNameA5 = new javax.swing.JLabel();
        bookA6 = new javax.swing.JPanel();
        bookNameA6 = new javax.swing.JLabel();
        imageA6 = new javax.swing.JButton();
        bookA7 = new javax.swing.JPanel();
        imageA7 = new javax.swing.JButton();
        bookNameA7 = new javax.swing.JLabel();
        nextButtonA = new javax.swing.JButton();
        prevButtonA = new javax.swing.JButton();
        yourAudiobook = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        bookB1 = new javax.swing.JPanel();
        imageB1 = new javax.swing.JButton();
        bookNameB1 = new javax.swing.JLabel();
        bookB2 = new javax.swing.JPanel();
        bookNameB2 = new javax.swing.JLabel();
        imageB2 = new javax.swing.JButton();
        bookB3 = new javax.swing.JPanel();
        imageB3 = new javax.swing.JButton();
        bookNameB3 = new javax.swing.JLabel();
        bookB4 = new javax.swing.JPanel();
        bookNameB4 = new javax.swing.JLabel();
        imageB4 = new javax.swing.JButton();
        bookB5 = new javax.swing.JPanel();
        imageB5 = new javax.swing.JButton();
        bookNameB5 = new javax.swing.JLabel();
        bookB6 = new javax.swing.JPanel();
        bookNameB6 = new javax.swing.JLabel();
        imageB6 = new javax.swing.JButton();
        bookB7 = new javax.swing.JPanel();
        imageB7 = new javax.swing.JButton();
        bookNameB7 = new javax.swing.JLabel();
        nextButtonB = new javax.swing.JButton();
        prevButtonB = new javax.swing.JButton();
        favorite = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        bookC1 = new javax.swing.JPanel();
        imageC1 = new javax.swing.JButton();
        bookNameC1 = new javax.swing.JLabel();
        bookC2 = new javax.swing.JPanel();
        bookNameC2 = new javax.swing.JLabel();
        imageC2 = new javax.swing.JButton();
        bookC3 = new javax.swing.JPanel();
        imageC3 = new javax.swing.JButton();
        bookNameC3 = new javax.swing.JLabel();
        bookC4 = new javax.swing.JPanel();
        bookNameC4 = new javax.swing.JLabel();
        imageC4 = new javax.swing.JButton();
        bookC5 = new javax.swing.JPanel();
        imageC5 = new javax.swing.JButton();
        bookNameC5 = new javax.swing.JLabel();
        bookC6 = new javax.swing.JPanel();
        bookNameC6 = new javax.swing.JLabel();
        imageC6 = new javax.swing.JButton();
        bookC7 = new javax.swing.JPanel();
        imageC7 = new javax.swing.JButton();
        bookNameC7 = new javax.swing.JLabel();
        nextButtonC = new javax.swing.JButton();
        prevButtonC = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library");
        setBackground(new java.awt.Color(255, 153, 102));

        topPanel.setBackground(new java.awt.Color(255, 204, 153));
        topPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchField.setText("search");
        searchField.setToolTipText("");
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

        recommended.setBackground(new java.awt.Color(255, 255, 255));
        recommended.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Recommended");
        recommended.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 214, 30));

        bookA1.setBackground(new java.awt.Color(102, 102, 102));

        imageA1.setText("-");
        imageA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageA1ActionPerformed(evt);
            }
        });

        bookNameA1.setForeground(new java.awt.Color(255, 255, 255));
        bookNameA1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameA1.setText("XXXXX");

        javax.swing.GroupLayout bookA1Layout = new javax.swing.GroupLayout(bookA1);
        bookA1.setLayout(bookA1Layout);
        bookA1Layout.setHorizontalGroup(
            bookA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageA1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
            .addComponent(bookNameA1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bookA1Layout.setVerticalGroup(
            bookA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookA1Layout.createSequentialGroup()
                .addComponent(imageA1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameA1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        recommended.add(bookA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 36, -1, -1));

        bookA2.setBackground(new java.awt.Color(102, 102, 102));

        bookNameA2.setForeground(new java.awt.Color(255, 255, 255));
        bookNameA2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameA2.setText("XXXXX");

        imageA2.setText("-");
        imageA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageA2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bookA2Layout = new javax.swing.GroupLayout(bookA2);
        bookA2.setLayout(bookA2Layout);
        bookA2Layout.setHorizontalGroup(
            bookA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookNameA2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(imageA2, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );
        bookA2Layout.setVerticalGroup(
            bookA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookA2Layout.createSequentialGroup()
                .addComponent(imageA2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameA2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        recommended.add(bookA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 36, -1, -1));

        bookA3.setBackground(new java.awt.Color(102, 102, 102));

        imageA3.setText("-");
        imageA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageA3ActionPerformed(evt);
            }
        });

        bookNameA3.setForeground(new java.awt.Color(255, 255, 255));
        bookNameA3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameA3.setText("XXXXX");

        javax.swing.GroupLayout bookA3Layout = new javax.swing.GroupLayout(bookA3);
        bookA3.setLayout(bookA3Layout);
        bookA3Layout.setHorizontalGroup(
            bookA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageA3, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
            .addComponent(bookNameA3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bookA3Layout.setVerticalGroup(
            bookA3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookA3Layout.createSequentialGroup()
                .addComponent(imageA3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameA3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        recommended.add(bookA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 36, -1, -1));

        bookA4.setBackground(new java.awt.Color(102, 102, 102));

        bookNameA4.setForeground(new java.awt.Color(255, 255, 255));
        bookNameA4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameA4.setText("XXXXX");

        imageA4.setText("-");
        imageA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageA4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bookA4Layout = new javax.swing.GroupLayout(bookA4);
        bookA4.setLayout(bookA4Layout);
        bookA4Layout.setHorizontalGroup(
            bookA4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookNameA4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(imageA4, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );
        bookA4Layout.setVerticalGroup(
            bookA4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookA4Layout.createSequentialGroup()
                .addComponent(imageA4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameA4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        recommended.add(bookA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 36, -1, -1));

        bookA5.setBackground(new java.awt.Color(102, 102, 102));

        imageA5.setText("-");
        imageA5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageA5ActionPerformed(evt);
            }
        });

        bookNameA5.setForeground(new java.awt.Color(255, 255, 255));
        bookNameA5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameA5.setText("XXXXX");

        javax.swing.GroupLayout bookA5Layout = new javax.swing.GroupLayout(bookA5);
        bookA5.setLayout(bookA5Layout);
        bookA5Layout.setHorizontalGroup(
            bookA5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageA5, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
            .addComponent(bookNameA5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bookA5Layout.setVerticalGroup(
            bookA5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookA5Layout.createSequentialGroup()
                .addComponent(imageA5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameA5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        recommended.add(bookA5, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 36, -1, -1));

        bookA6.setBackground(new java.awt.Color(102, 102, 102));

        bookNameA6.setForeground(new java.awt.Color(255, 255, 255));
        bookNameA6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameA6.setText("XXXXX");

        imageA6.setText("-");
        imageA6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageA6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bookA6Layout = new javax.swing.GroupLayout(bookA6);
        bookA6.setLayout(bookA6Layout);
        bookA6Layout.setHorizontalGroup(
            bookA6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookNameA6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(imageA6, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );
        bookA6Layout.setVerticalGroup(
            bookA6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookA6Layout.createSequentialGroup()
                .addComponent(imageA6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameA6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        recommended.add(bookA6, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 36, -1, -1));

        bookA7.setBackground(new java.awt.Color(102, 102, 102));

        imageA7.setText("-");
        imageA7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageA7ActionPerformed(evt);
            }
        });

        bookNameA7.setForeground(new java.awt.Color(255, 255, 255));
        bookNameA7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameA7.setText("XXXXX");

        javax.swing.GroupLayout bookA7Layout = new javax.swing.GroupLayout(bookA7);
        bookA7.setLayout(bookA7Layout);
        bookA7Layout.setHorizontalGroup(
            bookA7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageA7, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
            .addComponent(bookNameA7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bookA7Layout.setVerticalGroup(
            bookA7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookA7Layout.createSequentialGroup()
                .addComponent(imageA7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameA7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        recommended.add(bookA7, new org.netbeans.lib.awtextra.AbsoluteConstraints(784, 36, -1, -1));

        nextButtonA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrowNext.png"))); // NOI18N
        nextButtonA.setContentAreaFilled(false);
        nextButtonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonAActionPerformed(evt);
            }
        });
        recommended.add(nextButtonA, new org.netbeans.lib.awtextra.AbsoluteConstraints(895, 71, 40, 40));

        prevButtonA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrowPrev.png"))); // NOI18N
        prevButtonA.setContentAreaFilled(false);
        prevButtonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonAActionPerformed(evt);
            }
        });
        recommended.add(prevButtonA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 75, 40, 40));

        yourAudiobook.setBackground(new java.awt.Color(255, 249, 217));
        yourAudiobook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Your Audiobook");
        yourAudiobook.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 214, 30));

        bookB1.setBackground(new java.awt.Color(102, 102, 102));

        imageB1.setText("-");
        imageB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageB1ActionPerformed(evt);
            }
        });

        bookNameB1.setForeground(new java.awt.Color(255, 255, 255));
        bookNameB1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameB1.setText("XXXXX");

        javax.swing.GroupLayout bookB1Layout = new javax.swing.GroupLayout(bookB1);
        bookB1.setLayout(bookB1Layout);
        bookB1Layout.setHorizontalGroup(
            bookB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageB1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
            .addComponent(bookNameB1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bookB1Layout.setVerticalGroup(
            bookB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookB1Layout.createSequentialGroup()
                .addComponent(imageB1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameB1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        yourAudiobook.add(bookB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 36, -1, -1));

        bookB2.setBackground(new java.awt.Color(102, 102, 102));

        bookNameB2.setForeground(new java.awt.Color(255, 255, 255));
        bookNameB2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameB2.setText("XXXXX");

        imageB2.setText("-");
        imageB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageB2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bookB2Layout = new javax.swing.GroupLayout(bookB2);
        bookB2.setLayout(bookB2Layout);
        bookB2Layout.setHorizontalGroup(
            bookB2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookNameB2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(imageB2, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );
        bookB2Layout.setVerticalGroup(
            bookB2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookB2Layout.createSequentialGroup()
                .addComponent(imageB2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameB2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        yourAudiobook.add(bookB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 36, -1, -1));

        bookB3.setBackground(new java.awt.Color(102, 102, 102));

        imageB3.setText("-");
        imageB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageB3ActionPerformed(evt);
            }
        });

        bookNameB3.setForeground(new java.awt.Color(255, 255, 255));
        bookNameB3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameB3.setText("XXXXX");

        javax.swing.GroupLayout bookB3Layout = new javax.swing.GroupLayout(bookB3);
        bookB3.setLayout(bookB3Layout);
        bookB3Layout.setHorizontalGroup(
            bookB3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageB3, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
            .addComponent(bookNameB3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bookB3Layout.setVerticalGroup(
            bookB3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookB3Layout.createSequentialGroup()
                .addComponent(imageB3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameB3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        yourAudiobook.add(bookB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 36, -1, -1));

        bookB4.setBackground(new java.awt.Color(102, 102, 102));

        bookNameB4.setForeground(new java.awt.Color(255, 255, 255));
        bookNameB4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameB4.setText("XXXXX");

        imageB4.setText("-");
        imageB4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageB4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bookB4Layout = new javax.swing.GroupLayout(bookB4);
        bookB4.setLayout(bookB4Layout);
        bookB4Layout.setHorizontalGroup(
            bookB4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookNameB4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(imageB4, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );
        bookB4Layout.setVerticalGroup(
            bookB4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookB4Layout.createSequentialGroup()
                .addComponent(imageB4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameB4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        yourAudiobook.add(bookB4, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 36, -1, -1));

        bookB5.setBackground(new java.awt.Color(102, 102, 102));

        imageB5.setText("-");
        imageB5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageB5ActionPerformed(evt);
            }
        });

        bookNameB5.setForeground(new java.awt.Color(255, 255, 255));
        bookNameB5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameB5.setText("XXXXX");

        javax.swing.GroupLayout bookB5Layout = new javax.swing.GroupLayout(bookB5);
        bookB5.setLayout(bookB5Layout);
        bookB5Layout.setHorizontalGroup(
            bookB5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageB5, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
            .addComponent(bookNameB5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bookB5Layout.setVerticalGroup(
            bookB5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookB5Layout.createSequentialGroup()
                .addComponent(imageB5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameB5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        yourAudiobook.add(bookB5, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 36, -1, -1));

        bookB6.setBackground(new java.awt.Color(102, 102, 102));

        bookNameB6.setForeground(new java.awt.Color(255, 255, 255));
        bookNameB6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameB6.setText("XXXXX");

        imageB6.setText("-");
        imageB6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageB6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bookB6Layout = new javax.swing.GroupLayout(bookB6);
        bookB6.setLayout(bookB6Layout);
        bookB6Layout.setHorizontalGroup(
            bookB6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookNameB6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(imageB6, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );
        bookB6Layout.setVerticalGroup(
            bookB6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookB6Layout.createSequentialGroup()
                .addComponent(imageB6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameB6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        yourAudiobook.add(bookB6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 36, -1, -1));

        bookB7.setBackground(new java.awt.Color(102, 102, 102));

        imageB7.setText("-");
        imageB7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageB7ActionPerformed(evt);
            }
        });

        bookNameB7.setForeground(new java.awt.Color(255, 255, 255));
        bookNameB7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameB7.setText("XXXXX");

        javax.swing.GroupLayout bookB7Layout = new javax.swing.GroupLayout(bookB7);
        bookB7.setLayout(bookB7Layout);
        bookB7Layout.setHorizontalGroup(
            bookB7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageB7, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
            .addComponent(bookNameB7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bookB7Layout.setVerticalGroup(
            bookB7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookB7Layout.createSequentialGroup()
                .addComponent(imageB7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameB7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        yourAudiobook.add(bookB7, new org.netbeans.lib.awtextra.AbsoluteConstraints(789, 36, -1, -1));

        nextButtonB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrowNext.png"))); // NOI18N
        nextButtonB.setContentAreaFilled(false);
        nextButtonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonBActionPerformed(evt);
            }
        });
        yourAudiobook.add(nextButtonB, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 73, 40, 40));

        prevButtonB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrowPrev.png"))); // NOI18N
        prevButtonB.setContentAreaFilled(false);
        prevButtonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonBActionPerformed(evt);
            }
        });
        yourAudiobook.add(prevButtonB, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 74, 40, 40));

        favorite.setBackground(new java.awt.Color(255, 255, 255));
        favorite.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Your Favorites");
        favorite.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 214, 30));

        bookC1.setBackground(new java.awt.Color(102, 102, 102));

        imageC1.setText("-");
        imageC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageC1ActionPerformed(evt);
            }
        });

        bookNameC1.setForeground(new java.awt.Color(255, 255, 255));
        bookNameC1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameC1.setText("XXXXX");

        javax.swing.GroupLayout bookC1Layout = new javax.swing.GroupLayout(bookC1);
        bookC1.setLayout(bookC1Layout);
        bookC1Layout.setHorizontalGroup(
            bookC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageC1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
            .addComponent(bookNameC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bookC1Layout.setVerticalGroup(
            bookC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookC1Layout.createSequentialGroup()
                .addComponent(imageC1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        favorite.add(bookC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 36, -1, -1));

        bookC2.setBackground(new java.awt.Color(102, 102, 102));

        bookNameC2.setForeground(new java.awt.Color(255, 255, 255));
        bookNameC2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameC2.setText("XXXXX");

        imageC2.setText("-");
        imageC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageC2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bookC2Layout = new javax.swing.GroupLayout(bookC2);
        bookC2.setLayout(bookC2Layout);
        bookC2Layout.setHorizontalGroup(
            bookC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookNameC2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(imageC2, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );
        bookC2Layout.setVerticalGroup(
            bookC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookC2Layout.createSequentialGroup()
                .addComponent(imageC2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameC2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        favorite.add(bookC2, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 36, -1, -1));

        bookC3.setBackground(new java.awt.Color(102, 102, 102));

        imageC3.setText("-");
        imageC3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageC3ActionPerformed(evt);
            }
        });

        bookNameC3.setForeground(new java.awt.Color(255, 255, 255));
        bookNameC3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameC3.setText("XXXXX");

        javax.swing.GroupLayout bookC3Layout = new javax.swing.GroupLayout(bookC3);
        bookC3.setLayout(bookC3Layout);
        bookC3Layout.setHorizontalGroup(
            bookC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageC3, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
            .addComponent(bookNameC3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bookC3Layout.setVerticalGroup(
            bookC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookC3Layout.createSequentialGroup()
                .addComponent(imageC3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameC3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        favorite.add(bookC3, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 36, -1, -1));

        bookC4.setBackground(new java.awt.Color(102, 102, 102));

        bookNameC4.setForeground(new java.awt.Color(255, 255, 255));
        bookNameC4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameC4.setText("XXXXX");

        imageC4.setText("-");
        imageC4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageC4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bookC4Layout = new javax.swing.GroupLayout(bookC4);
        bookC4.setLayout(bookC4Layout);
        bookC4Layout.setHorizontalGroup(
            bookC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookNameC4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(imageC4, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );
        bookC4Layout.setVerticalGroup(
            bookC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookC4Layout.createSequentialGroup()
                .addComponent(imageC4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameC4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        favorite.add(bookC4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 36, -1, -1));

        bookC5.setBackground(new java.awt.Color(102, 102, 102));

        imageC5.setText("-");
        imageC5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageC5ActionPerformed(evt);
            }
        });

        bookNameC5.setForeground(new java.awt.Color(255, 255, 255));
        bookNameC5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameC5.setText("XXXXX");

        javax.swing.GroupLayout bookC5Layout = new javax.swing.GroupLayout(bookC5);
        bookC5.setLayout(bookC5Layout);
        bookC5Layout.setHorizontalGroup(
            bookC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageC5, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
            .addComponent(bookNameC5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bookC5Layout.setVerticalGroup(
            bookC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookC5Layout.createSequentialGroup()
                .addComponent(imageC5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameC5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        favorite.add(bookC5, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 36, -1, -1));

        bookC6.setBackground(new java.awt.Color(102, 102, 102));

        bookNameC6.setForeground(new java.awt.Color(255, 255, 255));
        bookNameC6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameC6.setText("XXXXX");

        imageC6.setText("-");
        imageC6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageC6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bookC6Layout = new javax.swing.GroupLayout(bookC6);
        bookC6.setLayout(bookC6Layout);
        bookC6Layout.setHorizontalGroup(
            bookC6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookNameC6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(imageC6, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );
        bookC6Layout.setVerticalGroup(
            bookC6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookC6Layout.createSequentialGroup()
                .addComponent(imageC6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameC6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        favorite.add(bookC6, new org.netbeans.lib.awtextra.AbsoluteConstraints(668, 36, -1, -1));

        bookC7.setBackground(new java.awt.Color(102, 102, 102));

        imageC7.setText("-");
        imageC7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageC7ActionPerformed(evt);
            }
        });

        bookNameC7.setForeground(new java.awt.Color(255, 255, 255));
        bookNameC7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookNameC7.setText("XXXXX");

        javax.swing.GroupLayout bookC7Layout = new javax.swing.GroupLayout(bookC7);
        bookC7.setLayout(bookC7Layout);
        bookC7Layout.setHorizontalGroup(
            bookC7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageC7, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
            .addComponent(bookNameC7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bookC7Layout.setVerticalGroup(
            bookC7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookC7Layout.createSequentialGroup()
                .addComponent(imageC7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookNameC7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        favorite.add(bookC7, new org.netbeans.lib.awtextra.AbsoluteConstraints(787, 36, -1, -1));

        nextButtonC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrowNext.png"))); // NOI18N
        nextButtonC.setContentAreaFilled(false);
        nextButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonCActionPerformed(evt);
            }
        });
        favorite.add(nextButtonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(894, 74, 40, 40));

        prevButtonC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrowPrev.png"))); // NOI18N
        prevButtonC.setContentAreaFilled(false);
        prevButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonCActionPerformed(evt);
            }
        });
        favorite.add(prevButtonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 75, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(recommended, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(yourAudiobook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 945, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(favorite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(recommended, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yourAudiobook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(favorite, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
        );

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

    }//GEN-LAST:event_searchFieldActionPerformed

    private void imageA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageA1ActionPerformed
        gotoBookPage(bookNameA1.getText());
    }//GEN-LAST:event_imageA1ActionPerformed

    private void imageA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageA2ActionPerformed
        gotoBookPage(bookNameA2.getText());
    }//GEN-LAST:event_imageA2ActionPerformed

    private void imageA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageA3ActionPerformed
        gotoBookPage(bookNameA3.getText());
    }//GEN-LAST:event_imageA3ActionPerformed

    private void imageA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageA4ActionPerformed
        gotoBookPage(bookNameA4.getText());
    }//GEN-LAST:event_imageA4ActionPerformed

    private void imageA5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageA5ActionPerformed
        gotoBookPage(bookNameA5.getText());
    }//GEN-LAST:event_imageA5ActionPerformed

    private void imageA6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageA6ActionPerformed
        gotoBookPage(bookNameA6.getText());
    }//GEN-LAST:event_imageA6ActionPerformed

    private void imageB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageB1ActionPerformed
        gotoAudioBookPage(bookNameB1.getText());
    }//GEN-LAST:event_imageB1ActionPerformed

    private void imageB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageB2ActionPerformed
        gotoAudioBookPage(bookNameB2.getText());
    }//GEN-LAST:event_imageB2ActionPerformed

    private void imageB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageB3ActionPerformed
        gotoAudioBookPage(bookNameB3.getText());
    }//GEN-LAST:event_imageB3ActionPerformed

    private void imageB4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageB4ActionPerformed
        gotoAudioBookPage(bookNameB4.getText());
    }//GEN-LAST:event_imageB4ActionPerformed

    private void imageB5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageB5ActionPerformed
        gotoAudioBookPage(bookNameB5.getText());
    }//GEN-LAST:event_imageB5ActionPerformed

    private void imageB6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageB6ActionPerformed
        gotoAudioBookPage(bookNameB6.getText());
    }//GEN-LAST:event_imageB6ActionPerformed

    private void imageB7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageB7ActionPerformed
        gotoAudioBookPage(bookNameB7.getText());
    }//GEN-LAST:event_imageB7ActionPerformed

    private void imageC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageC1ActionPerformed
        gotoBookPage(bookNameC1.getText());
    }//GEN-LAST:event_imageC1ActionPerformed

    private void imageC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageC2ActionPerformed
        gotoBookPage(bookNameC2.getText());
    }//GEN-LAST:event_imageC2ActionPerformed

    private void imageC3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageC3ActionPerformed
        gotoBookPage(bookNameC3.getText());
    }//GEN-LAST:event_imageC3ActionPerformed

    private void imageC4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageC4ActionPerformed
        gotoBookPage(bookNameC4.getText());
    }//GEN-LAST:event_imageC4ActionPerformed

    private void imageC5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageC5ActionPerformed
        gotoBookPage(bookNameC5.getText());
    }//GEN-LAST:event_imageC5ActionPerformed

    private void imageC6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageC6ActionPerformed
        gotoBookPage(bookNameC6.getText());
    }//GEN-LAST:event_imageC6ActionPerformed

    private void imageC7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageC7ActionPerformed
        gotoBookPage(bookNameC7.getText());
    }//GEN-LAST:event_imageC7ActionPerformed

    private void prevButtonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonAActionPerformed
        if (page1 > 0) {
            page1--;
            updateRecommended();
        }
    }//GEN-LAST:event_prevButtonAActionPerformed

    private void nextButtonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonAActionPerformed
        if (page1 < pageCap1) {
            page1++;
            updateRecommended();
        }
    }//GEN-LAST:event_nextButtonAActionPerformed

    private void prevButtonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonBActionPerformed
        if (page2 > 0) {
            page2--;
            updateAudioBook();
        }
    }//GEN-LAST:event_prevButtonBActionPerformed

    private void nextButtonBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonBActionPerformed
        if (page2 < pageCap2) {
            page2++;
            updateAudioBook();
        }
    }//GEN-LAST:event_nextButtonBActionPerformed

    private void prevButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonCActionPerformed
        if (page3 > 0) {
            page3--;
            updateFavorite();
        }
    }//GEN-LAST:event_prevButtonCActionPerformed

    private void nextButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonCActionPerformed
        if (page3 < pageCap3) {
            page3++;
            updateFavorite();
        }
    }//GEN-LAST:event_nextButtonCActionPerformed

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

    private void imageA7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageA7ActionPerformed
        gotoBookPage(bookNameA7.getText());
    }//GEN-LAST:event_imageA7ActionPerformed
    
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
    private javax.swing.JPanel bookA1;
    private javax.swing.JPanel bookA2;
    private javax.swing.JPanel bookA3;
    private javax.swing.JPanel bookA4;
    private javax.swing.JPanel bookA5;
    private javax.swing.JPanel bookA6;
    private javax.swing.JPanel bookA7;
    private javax.swing.JPanel bookB1;
    private javax.swing.JPanel bookB2;
    private javax.swing.JPanel bookB3;
    private javax.swing.JPanel bookB4;
    private javax.swing.JPanel bookB5;
    private javax.swing.JPanel bookB6;
    private javax.swing.JPanel bookB7;
    private javax.swing.JPanel bookC1;
    private javax.swing.JPanel bookC2;
    private javax.swing.JPanel bookC3;
    private javax.swing.JPanel bookC4;
    private javax.swing.JPanel bookC5;
    private javax.swing.JPanel bookC6;
    private javax.swing.JPanel bookC7;
    private javax.swing.JLabel bookNameA1;
    private javax.swing.JLabel bookNameA2;
    private javax.swing.JLabel bookNameA3;
    private javax.swing.JLabel bookNameA4;
    private javax.swing.JLabel bookNameA5;
    private javax.swing.JLabel bookNameA6;
    private javax.swing.JLabel bookNameA7;
    private javax.swing.JLabel bookNameB1;
    private javax.swing.JLabel bookNameB2;
    private javax.swing.JLabel bookNameB3;
    private javax.swing.JLabel bookNameB4;
    private javax.swing.JLabel bookNameB5;
    private javax.swing.JLabel bookNameB6;
    private javax.swing.JLabel bookNameB7;
    private javax.swing.JLabel bookNameC1;
    private javax.swing.JLabel bookNameC2;
    private javax.swing.JLabel bookNameC3;
    private javax.swing.JLabel bookNameC4;
    private javax.swing.JLabel bookNameC5;
    private javax.swing.JLabel bookNameC6;
    private javax.swing.JLabel bookNameC7;
    private javax.swing.JPanel favorite;
    private javax.swing.JButton imageA1;
    private javax.swing.JButton imageA2;
    private javax.swing.JButton imageA3;
    private javax.swing.JButton imageA4;
    private javax.swing.JButton imageA5;
    private javax.swing.JButton imageA6;
    private javax.swing.JButton imageA7;
    private javax.swing.JButton imageB1;
    private javax.swing.JButton imageB2;
    private javax.swing.JButton imageB3;
    private javax.swing.JButton imageB4;
    private javax.swing.JButton imageB5;
    private javax.swing.JButton imageB6;
    private javax.swing.JButton imageB7;
    private javax.swing.JButton imageC1;
    private javax.swing.JButton imageC2;
    private javax.swing.JButton imageC3;
    private javax.swing.JButton imageC4;
    private javax.swing.JButton imageC5;
    private javax.swing.JButton imageC6;
    private javax.swing.JButton imageC7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton logo;
    private javax.swing.JButton nextButtonA;
    private javax.swing.JButton nextButtonB;
    private javax.swing.JButton nextButtonC;
    private javax.swing.JButton notifButton;
    private javax.swing.JButton prevButtonA;
    private javax.swing.JButton prevButtonB;
    private javax.swing.JButton prevButtonC;
    private javax.swing.JPanel recommended;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel topPanel;
    private javax.swing.JPanel yourAudiobook;
    // End of variables declaration//GEN-END:variables
}
