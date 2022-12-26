import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * Models a simple ECommerce system. Keeps track of products for sale, registered customers, product orders and
 * orders that have been shipped to a customer
 */
public class ECommerceSystem
{
    // private ArrayList<Product>  products = new ArrayList<Product>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();	
    private ArrayList<ProductOrder> orders   = new ArrayList<ProductOrder>();
    private ArrayList<ProductOrder> shippedOrders   = new ArrayList<ProductOrder>();
    private TreeMap<String, Product> products = new TreeMap<String, Product>(); // New TreeMap
    private HashMap<String, Integer> STATS = new HashMap<String, Integer>();
    private HashMap<String, int[]> ratings = new HashMap<String, int[]>();
    
    // These variables are used to generate order numbers, customer id's, product id's 
    private int orderNumber = 500;
    private int customerId = 900;
    private int productId = 700;
    
    // General variable used to store an error message when something is invalid (e.g. customer id does not exist)  
    String errMsg = null;
    
    // Random number generator
    Random random = new Random();
    
    public ECommerceSystem()
    {
      // *Commented out products to allow for IO

    	// products.add(new Product("Acer Laptop", generateProductId(), 989.0, 99, Product.Category.COMPUTERS));
    	// products.add(new Product("Apex Desk", generateProductId(), 1378.0, 12, Product.Category.FURNITURE));
    	// products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "Ahm Gonna Make You Learn", "Mr. Professor", 2000));
    	// products.add(new Product("DadBod Jeans", generateProductId(), 24.0, 50, Product.Category.CLOTHING));
    	// products.add(new Product("Polo High Socks", generateProductId(), 5.0, 199, Product.Category.CLOTHING));
    	// products.add(new Product("Tightie Whities", generateProductId(), 15.0, 99, Product.Category.CLOTHING));
    	// products.add(new Book("Book", generateProductId(), 35.0, 4, 2, "How to Fool Your Prof", "D. Umbast", 1950));
    	// products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "How to Escape from Prison", "A. Fugitive", 2003));
    	// products.add(new Book("Book", generateProductId(), 44.0, 14, 12, "Ahm Gonna Make You Learn More", "Mr. Professor", 2022));
    	// products.add(new Product("Rock Hammer", generateProductId(), 10.0, 0, Product.Category.GENERAL));
      
    	// *Create some customers. Notice how generateCustomerId() method is used
      customers.add(new Customer(generateCustomerId(),"Inigo Montoya", "1 SwordMaker Lane, Florin"));
      customers.add(new Customer(generateCustomerId(),"Prince Humperdinck", "The Castle, Florin"));
      customers.add(new Customer(generateCustomerId(),"Andy Dufresne", "Shawshank Prison, Maine"));
      customers.add(new Customer(generateCustomerId(),"Ferris Bueller", "4160 Country Club Drive, Long Beach"));

      // *Create new shoe products.
      // products.add(new Shoes("Nike Shoes", generateProductId(), 300.0, new int[] {2,2,2,2,2}, new int[] {2,2,2,2,2}));
      // products.add(new Shoes("Adidas Shoes", generateProductId(), 259.0, new int[] {0,0,0,0,0}, new int[] {0,0,0,0,0}));
      // products.add(new Shoes("Puma Shoes", generateProductId(), 153.0, new int[] {2,0,4,0,8}, new int[] {2,0,4,0,8}));

      // *More Books to test Bonus Function
      // products.add(new Book("Book", generateProductId(), 35.0, 4, 2, "Harry Potter", "J. K. Rowling", 1997));
    	// products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "The Lord of the Rings", "Tolkien", 1995));
    	// products.add(new Book("Book", generateProductId(), 44.0, 14, 12, "Testing Oriented Programming", "Mr. Professor", 2005));
      // products.add(new Book("Book", generateProductId(), 35.0, 4, 2, "The Hobbit", "Tolkien", 1937));
    	// products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "The Silmarillion", "Tolkien", 1977));
    	// products.add(new Book("Book", generateProductId(), 44.0, 14, 12, "Testing 101", "Mr. Professor", 2012));  
      
      // Read from the file with the txt file enterted into the parameter
      try {
        readFile("products.txt");
      }
      catch (Exception error) // If another error but IO happened.
      {
        System.out.println("File was not formatted properly, closing.");
      }
    }
    // Method for reading the file
    private void readFile(String filename)
    {
      File file = new File(filename); // Create file
      try
      {
        String input;
        Scanner scan = new Scanner(file); // Scanner reads it

        while (scan.hasNextLine())
        {
          input = scan.nextLine(); // Check what Category the new product coming in is

          if (input.equalsIgnoreCase("FURNITURE") || input.equalsIgnoreCase("COMPUTERS") || input.equalsIgnoreCase("CLOTHING") || input.equalsIgnoreCase("GENERAL")) {
            // Save down all important information
            String name = scan.nextLine();
            double price = Double.parseDouble(scan.nextLine());
            int stock = Integer.parseInt(scan.nextLine());
            String id = generateProductId();
            scan.nextLine();
            // Create product with new information and add it to database
            // Also save it to the stats and rating map

            products.put(id, new Product(name, id, price, stock, Product.Category.valueOf(input.toUpperCase())));
            STATS.put(id, 0);
            ratings.put(id, new int[] {0,0,0,0,0,0});

          } else if (input.equalsIgnoreCase("BOOKS")) {
            // Save down all important information
            String name = scan.nextLine();
            double price = Double.parseDouble(scan.nextLine());
            String[] stock = scan.nextLine().split(" "); // Multiple Stocks
            String[] info = scan.nextLine().split(":"); // Multiple Info in one Line
            String id = generateProductId();
            // Create product with new information and add it to database
            // Also save it to the stats and rating map

            products.put(id, new Book(name, id, price, Integer.parseInt(stock[0]), Integer.parseInt(stock[1]), info[0], info[1], Integer.parseInt(info[2])));
            STATS.put(id, 0);
            ratings.put(id, new int[] {0,0,0,0,0,0});

          }
        }
      }
      catch (IOException error)
      {
        System.out.println("File not found!");
      }
    }

    // Generate a Order Number
    private String generateOrderNumber() { return "" + orderNumber++; }

    // Generate a Customer Id
    private String generateCustomerId() { return "" + customerId++; }
    
    // Generate a Product Id
    private String generateProductId() { return "" + productId++; }
    
    // Get the current Error Message
    public String getErrorMessage() { return errMsg; }
    
    // Print all Products
    public void printAllProducts() {
      for (String key : products.keySet())
        products.get(key).print();
    }
    
    // Print all products that are books. See getCategory() method in class Product
    public void printAllBooks() {
      for (String key : products.keySet()) {
        Product prod = products.get(key);
        // If the Product is a book
        if (prod.getCategory().equals(Product.Category.BOOKS)) {
          prod.print();
        }
      }
    }
    
    // Print all current orders
    public void printAllOrders() {
      for (ProductOrder order : orders) {
        order.print();
      }
    }

    // Print all shipped orders
    public void printAllShippedOrders() {
      for (ProductOrder order : shippedOrders) {
        order.print();
      }
    }
    
    // Print all customers
    public void printCustomers() {
      for (Customer cust : customers) {
        cust.print();
      }
    }

    /*
     * Given a customer id, print all the current orders and shipped orders for them (if any)
     */
    public void printOrderHistory(String customerId) {
      // Make sure customer exists - check using customerId
    	// If customer does not exist, set errMsg String and return false
      boolean customerExists = false;

      for (Customer cust : customers) {
        if (cust.getId().equals(customerId)) {
          customerExists = true;
          break;
        }
      }

      if (!customerExists) // If customer was not found raise error
      {
        throw new UnknownCustomerException("Customer " + customerId + " Not Found");
      }

    	// Print current orders of this customer 
      System.out.println("Current Orders of Customer " + customerId);
    	// enter code here
      for (ProductOrder order : orders) {
        // If the order is from the customer then print
        if (order.getCustomer().getId().equals(customerId)) {
          order.print();
        }
      }
      
    	// Print shipped orders of this customer 
      System.out.println("\nShipped Orders of Customer " + customerId);
    	//enter code here
      for (ProductOrder order : shippedOrders) {
        // If the order is from the customer then print
        if (order.getCustomer().getId().equals(customerId)) {
          order.print();
        }
      }
    }
    
    public String orderProduct(String productId, String customerId, String productOptions) {
    	// First check to see if customer object with customerId exists in list customers
    	// if it does not, throw error, else get the Customer object

      Customer orderCust = null;

      // Loop through all customers checking for Id and save them
    	for (Customer cust : customers) {
        if (cust.getId().equals(customerId)) {
          orderCust = cust;
          break;
        }
      }

      // Check if we found the customer
      if (orderCust == null)
      {
        // If we didn't change the error message and return null
        throw new UnknownCustomerException("Customer " + customerId + " Not Found");
      }

    	// Check to see if product object with productId exists in map of products
    	// if it does not, throw error
    	// else get the Product object 
      Product orderProd = null;

      // Loop through all products checking for Id and save it
      orderProd = products.get(productId);

      // Check if we found the product
      if (orderProd == null)
      {
        // If we didn't change the error message and return null
        throw new UnknownProductException("Product " + productId + " Not Found");
      }
    	
    	// Check if the options are valid for this product 
      // e.g. Paperback or Hardcover or EBook for Book product)
    	// If options are not valid, throw error
      if (!orderProd.validOptions(productOptions))
      {
        throw new InvalidOptionException("Product " + orderProd.getName() + " ProductId " + orderProd.getId() 
        + " Invalid Options: " + productOptions);
      }
    	
    	// Check if the product has stock available (i.e. not 0)
    	// If no stock available, throw error
    	if (orderProd.getStockCount(productOptions) <= 0)
      {
        throw new ProductStockException("Product " + orderProd.getName() + " ProductId " + orderProd.getId() 
        + " Invalid Stock: " + productOptions);
      }

      // Create a ProductOrder, reduce stock count of product by 1
    	// Add to orders list and return order number string
      ProductOrder newOrder = new ProductOrder(generateOrderNumber(), orderProd, orderCust, productOptions);
      STATS.put(orderProd.getId(), STATS.get(orderProd.getId())+1); // Update frequency ordered
      orders.add(newOrder);

      // Reduce the count of product
      orderProd.reduceStockCount(productOptions);

      // Return the order number string
      return newOrder.getOrderNumber();
    }
    
    /*
     * Create a new Customer object and add it to the list of customers
     */
    public void createCustomer(String name, String address) {
    	// Check name parameter to make sure it is not null or ""
    	// If it is not a valid name, throw error
    	// Repeat this check for address parameter
    	if (name == null || name.equals("")) 
      {
        throw new InvalidCustomerException("Invalid Customer Name");
      }
      else if (address == null || address.equals(""))
      {
        throw new InvalidAddressException("Invalid Customer Address");
      }
      // Create a Customer object and add to array list
      customers.add(new Customer(generateCustomerId(), name, address));
    }
    
    public ProductOrder shipOrder(String orderNumber)
    {
      // Check if order number exists first. If it doesn't, throw error
    	// and return false
    	// Retrieve the order from the orders list, remove it, then add it to the shippedOrders array list
    	// return a reference to the order
      for (ProductOrder order : orders)
      {
        // If the order is found ship it
        if (order.getOrderNumber().equals(orderNumber))
        {
          shippedOrders.add(order);
          orders.remove(order);
          order.print();
          return order;
        }
      }
      // Throw error
      throw new InvalidOrderException("Order #" + orderNumber + " Not Found");
    }
    
    /*
     * Cancel a specific order based on order number
     */
    public void cancelOrder(String orderNumber)
    {
      // Check if order number exists first. If it doesn't, throw error
    	// and return false
    	for (ProductOrder order : orders)
      {
        // If the order is found cancel it
        if (order.getOrderNumber().equals(orderNumber))
        {
          orders.remove(order);

          // If the object was cancelled, the order stat is reduced
          STATS.put(order.getProduct().getId(), STATS.get(order.getProduct().getId()) - 1);

          return;
        }
      }
      // Return error if the order is not found
      throw new InvalidOrderException("Order #" + orderNumber + " Not Found");
    }
    
    // Sort products by increasing price
    public void sortByPrice()
    {
      // Create array list to store products temporarily
      ArrayList<Product> prods = new ArrayList<Product>();

      // Get each product from the HashMap
      for (String key : products.keySet())
      {
        prods.add(products.get(key));
      }

      Collections.sort(prods);

      for (Product prod : prods)
      {
        prod.print();
      }
    }
    
    // Comparator Class used for sorting products by name
    class compareName implements Comparator<Product>
    {
      public int compare(Product one, Product two)
      {
        return one.getName().compareTo(two.getName());
      }
    }
    
    // Sort products alphabetically by product name
    public void sortByName()
    {
      // Create array list to store products temporarily
      ArrayList<Product> prods = new ArrayList<Product>();

      // Get each product from the HashMap
      for (String key : products.keySet())
      {
        prods.add(products.get(key));
      }

      Collections.sort(prods, new compareName());

      for (Product prod : prods)
      {
        prod.print();
      }
    }
    
        
    // Sort products alphabetically by product name
    public void sortCustomersByName()
    {
  	  Collections.sort(customers);
    }

    // Comparator Class used for sorting books by year published
    class compareDate implements Comparator<Book>
    {
      public int compare(Book one, Book two)
      {
        return one.getYear() - two.getYear();
      }
    }

    // Print books written by a person sorted by year published
    public void booksByAuthor(String author)
    {
      // Create array list to store products temporarily
      ArrayList<Product> prods = new ArrayList<Product>();

      // Get each product from the HashMap
      for (String key : products.keySet())
      {
        prods.add(products.get(key));
      }

      // Array List to store all books written by the author
      ArrayList<Book> allBooks = new ArrayList<Book>();

      // Loop through all products and check if each product is a book
      for (Product prod : prods)
      {

        if (prod.getCategory().equals(Product.Category.BOOKS))
        {
          Book book = (Book) prod;
          // If the product is a book check if its written by the author
          if (book.getAuthor().equalsIgnoreCase(author))
          {
            // Append the book to the array
            allBooks.add(book);
          }
        }
      }

      // Sort the array
      Collections.sort(allBooks, new compareDate());

      // Print each book in the array 
      for (Book book : allBooks)
      {
        book.print();
      }
    }
    // Add a product to the Customer's cart
    public void addProduct(String productId, String customerId, String productOptions)
    {
    	// First check to see if customer object with customerId exists in array list customers
    	// if it does not, throw error else get the Customer objec
      Customer orderCust = null;

      // Loop through all customers checking for Id and save them
    	for (Customer cust : customers)
      {
        if (cust.getId().equals(customerId))
        {
          orderCust = cust;
          break;
        }
      }

      // Check if we found the customer
      if (orderCust == null)
      {
        // If we didn't throw error
        throw new UnknownCustomerException("Customer " + customerId + " Not Found");
      }

    	// Check to see if product object with productId exists in map of products
    	// if it does not, throw error, else get the Product object 
      Product orderProd = null;

      // Loop through all products checking for Id and save it
      orderProd = products.get(productId);

      // Check if we found the product
      if (orderProd == null)
      {
        // If we didn't throw error
        throw new UnknownProductException("Product " + productId + " Not Found");
      }
    	
    	// Check if the options are valid for this product 
    	// If options are not valid, throw error
      if (!orderProd.validOptions(productOptions))
      {
        throw new InvalidOptionException("Product " + orderProd.getName() + " ProductId " + orderProd.getId() 
        + " Invalid Options: " + productOptions);
      }
    	
    	// Check if the product has stock available
    	// If no stock available, throw error
    	if (orderProd.getStockCount(productOptions) <= 0)
      {
        throw new ProductStockException("Product " + orderProd.getName() + " ProductId " + orderProd.getId() 
        + " Invalid Stock: " + productOptions);
      }

      // Create a ProductOrder and add to cart
      CartItem newItem = new CartItem(orderProd, productOptions);
      orderProd.reduceStockCount(productOptions); // Reduce Stock
      orderCust.getCart().addToCart(newItem);
    }
    // Print all items in the Customer's cart
    public void printCart(String customerId)
    {
      Customer orderCust = null;

      // First check to see if customer object with customerId exists in array list customers
    	// if it does not, throw error else get the Customer object
    	for (Customer cust : customers)
      {
        if (cust.getId().equals(customerId))
        {
          orderCust = cust;
          break;
        }
      }

      // Check if we found the customer
      if (orderCust == null)
      {
        // If we didn't throw error
        throw new UnknownCustomerException("Customer " + customerId + " Not Found");
      }

      orderCust.getCart().print(); // Run the print method for the cart
    }
    // Remove item from the Customer's cart
    public void removeItem(String productId, String customerId)
    {
      Customer orderCust = null;

      // First check to see if customer object with customerId exists in array list customers
    	// if it does not, throw error else get the Customer object
    	for (Customer cust : customers)
      {
        if (cust.getId().equals(customerId))
        {
          orderCust = cust;
          break;
        }
      }

      // Check if we found the customer
      if (orderCust == null)
      {
        // If we didn't throw error
        throw new UnknownCustomerException("Customer " + customerId + " Not Found");
      }

      Cart cart = orderCust.getCart(); // Get the cart object and save it for easier use

      // Loop through all products checking for Id and save it
      for (CartItem item : cart.getList())
      {
        // Check if product is the same
        if (item.getProduct().getId().equalsIgnoreCase(productId))
        {
          cart.removeFromCart(item); // Remove from cart
          return;
        }
      }
      // If we never found the product throw error
      throw new UnknownProductException("Product " + productId + " Not Found");
    }
    // Order all the items in the customer's cart
    public void orderItems(String customerId)
    {
      Customer orderCust = null;

      // First check to see if customer object with customerId exists in array list customers
    	// if it does not, throw error else get the Customer object
    	for (Customer cust : customers)
      {
        if (cust.getId().equals(customerId))
        {
          orderCust = cust;
          break;
        }
      }

      // Check if we found the customer
      if (orderCust == null)
      {
        // If we didn't throw error
        throw new UnknownCustomerException("Customer " + customerId + " Not Found");
      }

      Cart cart = orderCust.getCart(); // Get the cart object and save it for easier use

      // Nothing to order if cart is empty
      if (cart.getList().size() == 0) 
      {
        // Throw error
        throw new CartSizeException("Customer " + customerId + " has nothing in their cart");
      }

      for (int i = 0; i < cart.getList().size();)
      {
        CartItem item = cart.getList().get(i); // Get the cart item and order it with its product option
        ProductOrder newOrder = new ProductOrder(generateOrderNumber(), item.getProduct(), orderCust, item.getOption());

        STATS.put(item.getProduct().getId(), STATS.get(item.getProduct().getId())+1); // Update frequency ordered
        orders.add(newOrder); // Add the order
        
        // Remove the item from the cart
        cart.removeFromCart(item);
      }
    }
    // Print Product Order Statistics
    public void printStats()
    {
      // Create array list to store keys temporarily
      ArrayList<String> freq = new ArrayList<String>();

      // Get each key from the HashMap
      freq.addAll(STATS.keySet());

      // Sort it using the compareFreq comparator
      Collections.sort(freq, new compareFreq());

      for (String key : freq) // Print all freq stats
      {
        System.out.printf("\nName: %-25s Id: %-5s Ordered: %-5d", products.get(key).getName(), key, STATS.get(key));
      }
    }

    // Comparator Class used for sorting STATS by greatest frequency to least
    class compareFreq implements Comparator<String>
    {
      public int compare(String one, String two)
      {
        // Order from Greatest to Least
        return STATS.get(two) - STATS.get(one);
      }
    }

    // Method used for rating a product
    public void rateProduct(String productId, int rating)
    {
      // Check if the rating is in bounds
      if (rating < 1 || rating > 5)
      {
        // If it is not throw an error
        throw new IndexOutOfBoundsException("The rating " + rating + " is out of bounds (1-5)");
      }

      // Check if the ratings map contains the product Id
      if (ratings.containsKey(productId))
      {
        // Get the current ratings, add the new rating
        // Index 5 of ratings saves how many times the product has been rated
        int[] arr = ratings.get(productId);
        arr[rating-1] += 1;
        arr[5]++;
        ratings.put(productId, arr); // Save it in the rating map
      }
      else
      {
        // Throw error if product was not found
        throw new UnknownProductException("Product " + productId + " Not Found");
      }
    }

    // Print a product's rating
    public void prodRating(String productId)
    {
      if (ratings.containsKey(productId)) {
        // Print product and its rating
        products.get(productId).print();
        System.out.printf(" Average Rating: %5.2f",avgRating(ratings.get(productId)));
      }
      else
      {
        // Throw error if product was not found
        throw new UnknownProductException("Product " + productId + " Not Found");
      }
    }

    // Print all products by rating average
    public void printByRating(String category, double rating)
    {
      // Check if the rating is in bounds
      if (rating < 1 || rating > 5)
      {
        // If it is not throw an error
        throw new IndexOutOfBoundsException("The rating average " + rating + " is out of bounds (1-5)");
      }

      Product.Category prodCat; // Category we will be checking for

      if (category.equalsIgnoreCase("FURNITURE") || category.equalsIgnoreCase("COMPUTERS") || category.equalsIgnoreCase("CLOTHING") || 
      category.equalsIgnoreCase("GENERAL") || category.equalsIgnoreCase("BOOKS")) {
        prodCat = Product.Category.valueOf(category.toUpperCase()); // Set the value of the category
      } else {
        // If category is invalid throw error
        throw new InvalidCategoryException("The " + category + " is not a valid category!");
      }

      for (String key : products.keySet())
      {
        // Check if the category is right and if its rating is high enough
        if (products.get(key).getCategory() == prodCat && avgRating(ratings.get(key)) >= rating)
        {
          // If it is print the product and its average rating 
          products.get(key).print();
          System.out.printf(" Average Rating: %5.2f", avgRating(ratings.get(key)));
        }
      }
    }

    // Get the average rating of a product
    public double avgRating(int[] arr)
    { 
      double average = 0;
      int counter = 1;

      // Add each rating multipled by its value
      // Example: 1 stars are worth 1, 5 stars are worth 5
      // Subtract one from length because Index 5 saves Review count
      for (int i = 0; i < arr.length-1; i++)
      {
        average += arr[i] * counter;
        counter++;
      }

      return average/arr[5];
    }
}

/*
Below is all the custom exceptions used
throughout the program
*/
// Used for Unknown Customer input
class UnknownCustomerException extends RuntimeException
{
  public UnknownCustomerException() {}

  public UnknownCustomerException(String message)
  {
    super(message);
  }
}
// Used for Unknown product input
class UnknownProductException extends RuntimeException
{
  public UnknownProductException() {}

  public UnknownProductException(String message)
  {
    super(message);
  }
}
// Used for invalid product option input
class InvalidOptionException extends RuntimeException
{
  public InvalidOptionException() {}

  public InvalidOptionException(String message)
  {
    super(message);
  }
}
// Used if stock is empty
class ProductStockException extends RuntimeException
{
  public ProductStockException() {}

  public ProductStockException(String message)
  {
    super(message);
  }
}
// Used if customer input is invalid
class InvalidCustomerException extends RuntimeException
{
  public InvalidCustomerException() {}

  public InvalidCustomerException(String message)
  {
    super(message);
  }
}
// Used if customer address input is invalid
class InvalidAddressException extends RuntimeException
{
  public InvalidAddressException() {}

  public InvalidAddressException(String message)
  {
    super(message);
  }
}
// Invalid order number
class InvalidOrderException extends RuntimeException
{
  public InvalidOrderException() {}

  public InvalidOrderException(String message)
  {
    super(message);
  }
}
// Invalid size of Cart
class CartSizeException extends RuntimeException
{
  public CartSizeException() {}

  public CartSizeException(String message)
  {
    super(message);
  }
}
// Invalid Category
class InvalidCategoryException extends RuntimeException
{
  public InvalidCategoryException () {}

  public InvalidCategoryException(String message)
  {
    super(message);
  }
}
