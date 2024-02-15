/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librasync;

/**
 *
 * @author jukir
 */
public class BorrowBook {
    private String transactionID;
    private String studentID;
    private int bookID;
    private String borrowDate;
    private String returnDate;
    private String actualReturnDate;
    private int issuedBy;
    
    public BorrowBook(String transactionID, String studentID, int bookID, String borrowDate, String returnDate, String actualReturnDate, int issuedBy) {
        this.transactionID = transactionID;
        this.studentID = studentID;
        this.bookID = bookID;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.actualReturnDate = actualReturnDate;
        this.issuedBy = issuedBy;
        
    }

    public String getTransactionID() {
        return transactionID;
    }

    public String getStudentID() {
        return studentID;
    }

    public int getBookID() {
        return bookID;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String getActualReturnDate() {
        return actualReturnDate;
    }

    public int getIssuedBy() {
        return issuedBy;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setActualReturnDate(String actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public void setIssuedBy(int issuedBy) {
        this.issuedBy = issuedBy;
    }
}
