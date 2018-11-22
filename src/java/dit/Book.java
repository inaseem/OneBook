/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dit;

/**
 *
 * @author Naseem
 */
public class Book {
    private String title,author,description,image,isbn;
    private int id,cost;

    public Book(int id, String title, int cost, String author, String isbn, String description, String image) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.cost = cost;
        this.description = description;
        this.image = image;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getIsbn() {
        return isbn;
    }
    
    
    
}
