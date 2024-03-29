/*
 * class Product defines a product for sale by the system. 
 * A product belongs to one of the 5 categories below. 
 * Some products also have various options (e.g. size, color, format, style, ...). The options can affect
 * the stock count(s). In this generic class Product, product options are not used in get/set/reduce stockCount() methods  
 * Some products
 */
public class Product implements Comparable<Product> {
	public static enum Category {
		GENERAL, CLOTHING, BOOKS, FURNITURE, COMPUTERS
	};

	private String name;
	private String id;
	private Category category;
	private double price;
	private int stockCount;

	public Product() {
		this.name = "Product";
		this.id = "001";
		this.category = Category.GENERAL;
		this.stockCount = 0;
	}

	public Product(String id) {
		this("Product", id, 0, 0, Category.GENERAL);
	}

	public Product(String name, String id, double price, int stock, Category category) {
		this.name = name;
		this.id = id;
		this.price = price;
		this.stockCount = stock;
		this.category = category;
	}

	/*
	 * This method always returns true in class Product. In subclasses, this method
	 * will be overridden
	 * and will check to see if the options specified are valid for this product.
	 */
	public boolean validOptions(String productOptions) {
		// Changed original version to check productOptions
		// If productOptions is not null, object is being ordered
		// Through another method of order
		return (productOptions.equals(""));
	}

	// Get the category of the product
	public Category getCategory() {
		return category;
	}

	// Get the name of the product
	public String getName() {
		return name;
	}

	// Set the name of the product
	public void setName(String name) {
		this.name = name;
	}

	// Get the ID of the product
	public String getId() {
		return id;
	}

	// Set the ID of the product
	public void setId(String id) {
		this.id = id;
	}

	// Get the price of the product
	public double getPrice() {
		return price;
	}

	// Set the price of the product
	public void setPrice(double price) {
		this.price = price;
	}

	/*
	 * Return the number of items currently in stock for this product
	 * Note: in this general class, the productOptions parameter is not used. It may
	 * be used in subclasses.
	 */
	public int getStockCount(String productOptions) {
		return stockCount;
	}

	/*
	 * Set (or replenish) the number of items currently in stock for this product
	 * Note: in this general class, the productOptions parameter is not used. It may
	 * be used in subclasses.
	 */
	public void setStockCount(int stockCount, String productOptions) {
		this.stockCount = stockCount;
	}

	/*
	 * Reduce the number of items currently in stock for this product by 1 (called
	 * when a product has been ordered by a customer)
	 * Note: in this general class, the productOptions parameter is not used. It may
	 * be used in subclasses.
	 */
	public void reduceStockCount(String productOptions) {
		stockCount--;
	}

	// Print the product information
	public void print() {
		System.out.printf("\nId: %-5s Category: %-9s Name: %-20s Price: %7.1f", id, category, name, price);
	}

	/*
	 * Two products are equal if they have the same product Id.
	 * This method is inherited from superclass Object and overridden here
	 */
	public boolean equals(Object other) {
		Product otherP = (Product) other;
		return this.id.equals(otherP.id);
	}

	@Override
	// Used for sorting products by price
	public int compareTo(Product other) {
		if (this.getPrice() > other.getPrice()) {
			return 1;
		} else if (this.getPrice() < other.getPrice()) {
			return -1;
		}
		return 0; // Then they are equal
	}
}
