import java.util.ArrayList;

/*
 * Class Cart defines the cart for each customer
 * Contains an ArrayList of CartItems and different 
 * Methods to interact with the List
 */
public class Cart {
    // Variables
    private ArrayList<CartItem> cartItems;

    // Main Cart Constructor
    public Cart()
    {
        cartItems = new ArrayList<CartItem>();
    }
    // Print the contents of the cart
    public void print()
    {
        // Loop through each item
        for (CartItem item : cartItems) 
        {
            item.print();
        }
    }
    // Add the item to the cart
    public void addToCart(CartItem item)
    {
        cartItems.add(item);
    }
    // Remove the item from the cart
    public void removeFromCart(CartItem item)
    {
        cartItems.remove(item);
    }
    // Get the Array List
    public ArrayList<CartItem> getList()
    {
        return cartItems;
    }
}
