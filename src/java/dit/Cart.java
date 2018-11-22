/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dit;

import java.util.ArrayList;

/**
 *
 * @author Naseem
 */
public class Cart {

    private ArrayList<CartItem> items;
    private String total;

    public Cart(ArrayList<CartItem> items, String total) {
        this.items = items;
        this.total = total;
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public String getTotal() {
        return total;
    }

}
