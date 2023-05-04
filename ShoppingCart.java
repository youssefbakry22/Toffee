
public class ShoppingCart {
    private Item[] items;

    public ShoppingCart() {

    }

    public void add_item(Item item) {
        // add item to cart
    }

    public void remove_item(String name) {
        // remove item from cart
    }

    public void display_items() {
        for (Item item : items) {
            System.out.println(item); // calls the toString() method of the class Item to print the item
                                      // it should be overridden in the Item class
        }
    }

    public double calc_total_price() {
        // calculate total price of items in cart
        return 0.0;
    }
}