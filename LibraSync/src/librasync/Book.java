/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librasync;

/**
 *
 * @author Carlo
 */

public class Book {
    private int bookID;
    private String title;
    private int year;
    private String language;
    private int categoryID;
    private int copiesActual;
    private int copiesCurrent;

    public Book(){}
    
    public Book(int bookid, String title, int year, String language, int categoryID, int copiesActual, int copiesCurrent){
        this.bookID = bookid;
        this.title = title;
        this.year = year;
        this.language = language;
        this.categoryID = categoryID;
        this.copiesActual = copiesActual;
        this.copiesCurrent = copiesCurrent;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getLanguage() {
        return language;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public int getCopiesActual() {
        return copiesActual;
    }

    public int getCopiesCurrent() {
        return copiesCurrent;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public void setCopiesActual(int copiesActual) {
        this.copiesActual = copiesActual;
    }

    public void setCopiesCurrent(int copiesCurrent) {
        this.copiesCurrent = copiesCurrent;
    }
}
