/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librasync;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Connect {
    Connection conn;
    
    public Connect(){
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/library", "admin123", "admin123");
            System.out.println("Succecssfully connected.");
        } catch(SQLException e) {
            System.out.println(e);
        }
    }
    
    public ArrayList displayAll() {
        ArrayList<Book> book = new ArrayList<>();
        Statement stmt;
        String sql = "SELECT * FROM book";
        ResultSet rs = null;
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Book b = new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                book.add(b);
            }
        } catch(SQLException e) {
            System.out.println(e.toString());
        }   
        return book;
    }
    
    public boolean addBook(Book b){
        Statement stmt;
        String sql;
        
        sql = "insert into book values ("+b.getBookID()+",'"+b.getTitle()+"',"+b.getYear()+",'"+b.getLanguage()+"',"
            +b.getCategoryID()+","+b.getCopiesActual()+","+b.getCopiesCurrent()+")";
        
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
            return true;
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
        
        return false;
    }
    
    public boolean deleteBook(int bookid){
        Statement stmt;
        String sql = "DELETE FROM book WHERE bookid=" + bookid;
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            return true;
            
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
        
        return false;
    }
    
    public boolean updateBook(Book b) {
        Statement stmt;
        String sql = "UPDATE book set bookTitle='"+ b.getTitle() +"', publicationYear="+ b.getYear() +", language='"+ b.getLanguage() 
                +"', categoryID="+ b.getCategoryID() +", copiesCountActual="+ b.getCopiesActual() +", copiesCountCurrent="+ b.getCopiesCurrent() 
                +" WHERE bookID="+ b.getBookID();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            return true;
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
        
        return false;
    }
    
    public boolean borrowBook(String studentID, int bookID, int staffID) {
        Date date = new Date();
        String transactID = "LIB"+new SimpleDateFormat("yyyyMMddHHmmss").format(date);
        
        String borrowDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        String returnDate = new SimpleDateFormat("yyyy-MM-dd").format(new GregorianCalendar(1970, Calendar.JANUARY, 1).getTime());
        String actualReturnDate ;
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, 7);
        
        actualReturnDate = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        
        Statement stmt;
        String sql;
        
        sql = "insert into BorrowBook values ('"+transactID+"', '"+studentID+"', "+bookID+", '"+borrowDate+
                "', '"+returnDate+"', '"+actualReturnDate+"', "+staffID+")";
        
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
            return true;
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
        
        return false;
    }
    
    public boolean returnBook(String transactionID) {
        String returnDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        
        Statement stmt;
        String sql = "UPDATE borrowbook set returnDate='"+returnDate+"' WHERE BORROWTRANSACTIONID='"+transactionID+"'";
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            return true;
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
        
        return false;
    }
    
    public ArrayList<BorrowBook> getUnreturnedBooks() {
        
        ArrayList<BorrowBook> book = new ArrayList<>();
        
        Statement stmt;
        String sql = "SELECT * FROM borrowbook WHERE returndate='1970-01-01'";
        ResultSet rs = null;
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                BorrowBook b = new BorrowBook(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                book.add(b);
            }
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
        
        return book;
    }
    
    public ArrayList<BorrowBook> getReturnedBooks() {
        ArrayList<BorrowBook> book = new ArrayList<>();
        
        Statement stmt;
        String sql = "SELECT * FROM borrowbook WHERE returndate NOT IN ('1970-01-01')";
        ResultSet rs = null;
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                BorrowBook b = new BorrowBook(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                book.add(b);
            }
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
        
        return book;
    }
}
