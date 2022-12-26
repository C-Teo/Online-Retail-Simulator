/*
 * Class CartItem item to be put in Customer cart
 * Contains a product and its saved ProductOption
 */
public class CartItem {
    // Variables
    private Product product;
    private String productOptions;

    // Main CartItem Constructor
    public CartItem(Product product, String productOptions) {
        this.product = product;
        this.productOptions = productOptions;
    }

    // Print method for the CartItem
    public void print()
	{
        product.print();
		System.out.print(" Product Options: " + productOptions);
	}
    // Get method for Product
    public Product getProduct()
    {
        return this.product;
    }
    // Get method for productOptions
    public String getOption()
    {
        return this.productOptions;
    }
}
