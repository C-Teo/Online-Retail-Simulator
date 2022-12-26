import java.util.Scanner;

/*
 * This is the main file of the Ecommerce Package.
 * It utilizes the other files to create the pre-defined Ecom System,
 * Products, and Customers.
 */
public class ECommerceUserInterface
{
	public static void main(String[] args)
	{
		// Create the system
		ECommerceSystem ecomsys = new ECommerceSystem();

		Scanner scanner = new Scanner(System.in);
		System.out.print(">");
		
		// Process keyboard actions
		while (scanner.hasNextLine()) {
			String action = scanner.nextLine();
			if (action == null || action.equals("")) 
			{
				System.out.print("\n>");
				continue;
			}
			else if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT")) {
				return;
			}	
			else if (action.equalsIgnoreCase("PRODS"))	// List all products for sale
			{
				ecomsys.printAllProducts(); 
			}
			else if (action.equalsIgnoreCase("BOOKS"))	// List all books for sale
			{
				ecomsys.printAllBooks(); 
			}
			else if (action.equalsIgnoreCase("CUSTS")) 	// List all registered customers
			{
				ecomsys.printCustomers();	
			}
			else if (action.equalsIgnoreCase("ORDERS")) // List all current product orders
			{
				ecomsys.printAllOrders();	
			}
			else if (action.equalsIgnoreCase("SHIPPED"))	// List all orders that have been shipped
			{
				ecomsys.printAllShippedOrders();	
			}
			else if (action.equalsIgnoreCase("NEWCUST"))	// Create a new registered customer
			{
				String name = "";
				String address = "";
				
				System.out.print("Name: ");
				if (scanner.hasNextLine())
					name = scanner.nextLine();
				
				System.out.print("\nAddress: ");
				if (scanner.hasNextLine())
					address = scanner.nextLine();
				
				try {
					ecomsys.createCustomer(name, address);
				}
				catch (Exception error)
				{
					System.out.println(error.getMessage());
				}
			}
			// Ship an order to a customer
			else if (action.equalsIgnoreCase("SHIP"))	
			{
				String orderNumber = "";
        
				System.out.print("Order Number: ");
				// Get order number from scanner
				orderNumber = scanner.nextLine();
				
				// Ship order to customer (see ECommerceSystem for the correct method to use
				// If order not found throw error
				try 
				{
					ecomsys.shipOrder(orderNumber);
				}
				catch (Exception error)
				{
					System.out.println(error.getMessage());
				}
			}
			// List all the current orders and shipped orders for this customer id
			else if (action.equalsIgnoreCase("CUSTORDERS")) 
			{
				String customerId = "";

				System.out.print("Customer Id: ");
				// Get customer Id from scanner
				customerId = scanner.nextLine();

				// Print all current orders and all shipped orders for this customer, check for error
				try
				{
				ecomsys.printOrderHistory(customerId);
				}
				catch (Exception error)
				{
					// Print out error
					System.out.println(error.getMessage());
				}
			}
			// Order a product for a certain customer
			else if (action.equalsIgnoreCase("ORDER")) 
			{
				String productId = "";
				String customerId = "";

				System.out.print("Product Id: ");
			  	// Get product Id from scanner
				productId = scanner.nextLine();
				
				System.out.print("\nCustomer Id: ");
			  	// Get customer Id from scanner
				customerId = scanner.nextLine(); 
				
				// Order the product. Check for error
				try
				{
					// Print Order Number string 
					System.out.println("Order Number: " + ecomsys.orderProduct(productId, customerId, ""));
				}
				catch (Exception error)
				{
					System.out.println(error.getMessage());
				}
				
			}
			// Order a book for a customer, provide a format (Paperback, Hardcover or EBook)
			else if (action.equalsIgnoreCase("ORDERBOOK")) 
			{
				String productId = "";
				String customerId = "";
				String options = "";

				System.out.print("Product Id: ");
				// get product id
				productId = scanner.nextLine();

				System.out.print("\nCustomer Id: ");
				// get customer id
				customerId = scanner.nextLine();

				System.out.print("\nFormat [Paperback Hardcover EBook]: ");
				// get book forma and store in options string
				options = scanner.nextLine();

				if (options.equals(""))
				{
					options = " "; // This is to prevent people from ordering other products with orderbook
				}

				// Order the Book. Check for error
				try
				{
					// Print Order Number string 
					System.out.println("Order Number: " + ecomsys.orderProduct(productId, customerId, options));
				}
				catch (Exception error)
				{
					System.out.println(error.getMessage());
				}
			}
			// Order shoes for a customer, provide size and color 
			else if (action.equalsIgnoreCase("ORDERSHOES")) 
			{
				String productId = "";
				String customerId = "";
				String options = "";
				
				System.out.print("Product Id: ");
				// Get product id
				productId = scanner.nextLine();

				System.out.print("\nCustomer Id: ");
				// Get customer id
				customerId = scanner.nextLine();
				
				System.out.print("\nSize: \"6\" \"7\" \"8\" \"9\" \"10\": ");
				// Get shoe size and store in options	
				options = scanner.nextLine() + "/";
				
				System.out.print("\nColor: \"Black\" \"Brown\": ");
				// Get shoe color and append to options
				options += scanner.nextLine();
				
				// Order the Shoes. Check for error
				try
				{
					// Print Order Number string 
					System.out.println("Order Number: " + ecomsys.orderProduct(productId, customerId, options));
				}
				catch (Exception error)
				{
					System.out.println(error.getMessage());
				}
			}
			
			else if (action.equalsIgnoreCase("CANCEL")) // Cancel an existing order
			{
				String orderNumber = "";

				System.out.print("Order Number: ");
				// Get order number from scanner
				orderNumber = scanner.nextLine();
				
				// Cancel order. Check for error
				try
				{
					ecomsys.cancelOrder(orderNumber);
					System.out.println("Order #" + orderNumber + " Cancelled");
				}
				catch (Exception error)
				{
					System.out.println(error.getMessage());
				}
			}
			else if (action.equalsIgnoreCase("PRINTBYPRICE")) // Sort products by price
			{
				ecomsys.sortByPrice();
			}
			else if (action.equalsIgnoreCase("PRINTBYNAME")) // Sort products by name (alphabetic)
			{
				ecomsys.sortByName();
			}
			else if (action.equalsIgnoreCase("SORTCUSTS")) // Sort customers by name (alphabetic)
			{
				ecomsys.sortCustomersByName();
			}
			else if (action.equalsIgnoreCase("BOOKSBYAUTHOR")) // Print books for an author sorted by year published
			{
				// Variable used later
				String author;

				System.out.print("Author Name: ");
				// Get the author from the user
				author = scanner.nextLine();

				System.out.println("Books by: " + author);
				ecomsys.booksByAuthor(author);
			}
			else if (action.equalsIgnoreCase("ADDTOCART")) // Add a product to a customers cart
			{
				// Variables to be used later on
				String productId;
				String customerId;
				String productOptions;

				System.out.print("Product Id: ");
				// Get product id
				productId = scanner.nextLine();

				System.out.print("\nCustomer Id: ");
				// Get customer id
				customerId = scanner.nextLine();

				System.out.print("\nFormat [Paperback Hardcover EBook]: ");
				// Get book forma and store in options string
				productOptions = scanner.nextLine();

				try {
					ecomsys.addProduct(productId, customerId, productOptions);
					System.out.println("Product added to Cart!");
				}
				catch (Exception error)
				{
					System.out.println(error.getMessage());
				}

			}
			// Remove a product from a customers cart
			else if (action.equalsIgnoreCase("REMCARTITEM")) 
			{
				// Variables to be used later on
				String productId;
				String customerId;

				System.out.print("Product Id: ");
				// Get product id
				productId = scanner.nextLine();

				System.out.print("\nCustomer Id: ");
				// Get customer id
				customerId = scanner.nextLine();

				try 
				{ 
					ecomsys.removeItem(productId, customerId);
					System.out.println("Product removed from Cart!");
				}
				catch (Exception error)
				{
					System.out.println(error.getMessage());
				}
			}
			// Print the products in a customers cart
			else if (action.equalsIgnoreCase("PRINTCART")) 
			{
				// Variables to be used later on
				String customerId;

				System.out.print("\nCustomer Id: ");
				// Get customer id
				customerId = scanner.nextLine();

				try 
				{ 
					System.out.println("Customer Cart:");
					ecomsys.printCart(customerId);
				}
				catch (Exception error)
				{
					System.out.println(error.getMessage());
				}
			}
			// Create a product order for each product in the customers cart
			else if (action.equalsIgnoreCase("ORDERITEMS")) 
			{
				// Variables to be used later on
				String customerId;	
				
				System.out.print("\nCustomer Id: ");
				// Get customer id
				customerId = scanner.nextLine();

				try 
				{ 
					ecomsys.orderItems(customerId);
					System.out.println("Items ordered!");
				}
				catch (Exception error)
				{
					System.out.println(error.getMessage());
				}
			}
			// Print Product Order Statistics
			else if (action.equalsIgnoreCase("STATS")) 
			{
				System.out.println("Product Order Statistics:");
				ecomsys.printStats();
			}
			else if (action.equalsIgnoreCase("RATE"))
			{
				String productId;
				int rating;

				System.out.print("\nProduct Id: ");
				// Get product id
				productId = scanner.nextLine();

				System.out.print("\nRating: ");
				// Get user rating

				try 
				{
					rating = Integer.parseInt(scanner.nextLine());
					// Register rating
					ecomsys.rateProduct(productId, rating);

					System.out.println("Product " + productId + " has been rated a " + rating + " star(s)!");
				}
				catch (NumberFormatException error) // Non value inputted
				{	
					System.out.println("The inputted rating is not a number!");
				}
				catch (Exception error) // Error from the rateProduct method
				{
					System.out.println(error.getMessage());
				}

			}
			else if (action.equalsIgnoreCase("PRODRATING"))
			{
				String productId;

				System.out.print("\nProduct Id: ");
				// Get product id
				productId = scanner.nextLine();

				try
				{
					ecomsys.prodRating(productId);
				}
				catch (Exception error) // Error from the prodRating method
				{
					System.out.println(error.getMessage());
				}
			}
			else if (action.equalsIgnoreCase("PRODSBYRATING"))
			{
				String category;
				double ratingAverage;

				System.out.print("\nCategory: ");
				// get product id
				category = scanner.nextLine();

				System.out.print("\nSort by what Rating: ");
				// get user rating average

				try
				{
					ratingAverage = Double.parseDouble(scanner.nextLine());
					ecomsys.printByRating(category, ratingAverage);
				}
				catch (NumberFormatException error)
				{
					System.out.println("The inputted rating is not a number!");
				}
				catch (Exception error)
				{
					System.out.println(error.getMessage());
				}	
			}
			System.out.print("\n>");
		}
		scanner.close();
	}
}
