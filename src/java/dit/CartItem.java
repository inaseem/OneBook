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
public class CartItem {

    private int quantity;
    private Book book;

    public CartItem(int quantity, Book book) {
        this.quantity = quantity;
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public Book getBook() {
        return book;
    }

}
