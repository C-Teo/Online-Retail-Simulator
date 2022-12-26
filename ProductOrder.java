/*
 * Class ProductOrder defines an order of a specific product by a customer
 * The order number is generated by the system when a ProductOrder object is created.
 * Also stores any product options chosen by this customer (e.g. paperback book, certain size of a product etc)
 */
public class ProductOrder
{
	private String 		orderNumber;
	private Product 	product;
	private String    	productOptions;
	private Customer 	customer;
	
	public ProductOrder(String orderNumber, Product product, Customer customer, String productOptions)
	{
		this.orderNumber = orderNumber;
		this.product = product;
		this.customer = customer;
		this.productOptions = productOptions;
	}

	// Get the order number
	public String getOrderNumber()
	{
		return orderNumber;
	}

	// Set the order number
	public void setOrderNumber(String orderNumber)
	{
		this.orderNumber = orderNumber;
	}
	
	// Get the product of the order
	public Product getProduct()
	{
		return product;
	}

	// Set the product of the order
	public void setProduct(Product product)
	{
		this.product = product;
	}

	// Get the customer of the order
	public Customer getCustomer()
	{
		return customer;
	}

	// Set the customer of the order
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	// Print the order information
	public void print() {
		System.out.printf("\nOrder # %3s Customer Id: %3s Product Id: %3s Product Name: %12s Options: %8s", 
		orderNumber, customer.getId(), product.getId(), product.getName(), productOptions);
	}

	/*
	 * Two ProductOrder objects are equal if they have the same order number string.
	 */
	public boolean equals(Object other) {
		// Compare two ProductOrder objects based on their orderNumber strings
		// Replace the line below (Hint: look at class Product equals())
		ProductOrder otherPO = (ProductOrder) other;
		// If their order number is the same, return True
		return (this.orderNumber.equals(otherPO.getOrderNumber()));
	}
}
