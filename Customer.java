/*
 *  Class Customer defines a registered customer. It keeps track of the customer's name and address. 
 *  A unique id is generated when when a new customer is created. 
 *  Implement the Comparable interface and compare two customers based on name
 */
public class Customer implements Comparable<Customer>
{
	private String id;  
	private String name;
	private String shippingAddress;
	private Cart cart;
	
	public Customer(String id)
	{
		this.id = id;
		this.name = "";
		this.shippingAddress = "";
		this.cart = new Cart();
	}
	
	public Customer(String id, String name, String address)
	{
		this.id = id;
		this.name = name;
		this.shippingAddress = address;
		this.cart = new Cart();
	}
	
	// Get the customer ID
	public String getId()
	{
		return id;
	}
	// Set the customer ID
	public void setId(String id)
	{
		this.id = id;
	}
	// Get the customer name
	public String getName()
	{
		return name;
	}
	// Set the customer name
	public void setName(String name)
	{
		this.name = name;
	}
	// Get the customer's shipping address
	public String getShippingAddress()
	{
		return shippingAddress;
	}
	// Set the customer's shippingg address
	public void setShippingAddress(String shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}
	// Print the information of the customer
	public void print()
	{
		System.out.printf("\nName: %-20s ID: %3s Address: %-35s", name, id, shippingAddress);
	}
	// Check if this customer is equal to the other customer
	public boolean equals(Object other)
	{
		Customer otherC = (Customer) other;
		return this.id.equals(otherC.id);
	}
	// Get method for Cart
	public Cart getCart()
	{
		return this.cart;
	}

	@Override
	// The comparable interface for customer class
	// Compares two customers by name and returns an int
	public int compareTo(Customer other) 
	{
		return this.getName().toUpperCase().compareTo(other.getName().toUpperCase());
	}
	
}
