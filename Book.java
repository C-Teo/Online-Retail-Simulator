/* 
 * A book is a product that has additional information - e.g. title, author
 * A book also comes in different formats ("Paperback", "Hardcover", "EBook")
 * The format is specified as a specific "stock type" in get/set/reduce stockCount methods.
 */
public class Book extends Product
{
  private String author;
  private String title;
  private int year;
  
  // Stock related information NOTE: inherited stockCount variable is used for EBooks
  int paperbackStock;
  int hardcoverStock;
  
  public Book(String name, String id, double price, int paperbackStock, int hardcoverStock, String title, String author, int year)
  {
  	// Make use of the constructor in the super class Product. Initialize additional Book instance variables. 
  	// Set category to BOOKS 
    super(name, id, price, (int) Double.POSITIVE_INFINITY, Category.BOOKS);
    // New Book instance variables
    this.paperbackStock = paperbackStock;
    this.hardcoverStock = hardcoverStock;
    this.title = title;
    this.author = author;
    this.year = year;
  }
    
  // Check if a valid format  
  public boolean validOptions(String productOptions)
  {
  	// check productOptions for "Paperback" or "Hardcover" or "EBook"
  	// if it is one of these, return true, else return false
    return (productOptions.equalsIgnoreCase("Paperback") || productOptions.equalsIgnoreCase("Hardcover") 
    || productOptions.equalsIgnoreCase("EBook"));
  }
  
  // Override getStockCount() in super class.
  public int getStockCount(String productOptions)
	{
  	// Use the productOptions to check for (and return) the number of stock for "Paperback" etc
  	// Use the variables paperbackStock and hardcoverStock at the top. 
  	// For "EBook", use the inherited stockCount variable.
    // If option is Paperback
    if (productOptions.equalsIgnoreCase("Paperback"))
    {
      return this.paperbackStock;
    }
    // If option is Hardcover
    else if (productOptions.equalsIgnoreCase("Hardcover"))
    {
      return this.hardcoverStock;
    }
    else
    // If option is EBook
    {
      // Param does not matter but "Ebook" looks more organized
      return super.getStockCount("EBook"); 
    }
	}
  
  public void setStockCount(int stockCount, String productOptions)
	{
    // Use the productOptions to check for (and set) the number of stock for "Paperback" etc
   	// Use the variables paperbackStock and hardcoverStock at the top. 
   	// For "EBook", set the inherited stockCount variable.
    if (productOptions.equalsIgnoreCase("Paperback"))
    {
      this.paperbackStock = stockCount;
    }
    // If option is Hardcover
    else if (productOptions.equalsIgnoreCase("Hardcover"))
    {
      this.hardcoverStock = stockCount;
    }
    else
    // If option is EBook
    {
      // Param does not matter but "Ebook" looks more organized
      super.setStockCount(super.getStockCount("EBook"), "EBook");
    }
	}
  
  // Get the year published of the book
  public int getYear()
  {
    return this.year;
  }

  // Set the year published of the book
  public void setYear(int year)
  {
    this.year = year;
  }

  // Get the author of the book
  public String getAuthor()
  {
    return this.author;
  }

  // Set the author of the book
  public void setAuthor(String author)
  {
    this.author = author;
  }

  /*
   * When a book is ordered, reduce the stock count for the specific stock type
   */
  public void reduceStockCount(String productOptions)
	{
  	// Use the productOptions to check for (and reduce) the number of stock for "Paperback" etc
   	// Use the variables paperbackStock and hardcoverStock at the top. 
   	// For "EBook", set the inherited stockCount variable.
    if (productOptions.equalsIgnoreCase("Paperback"))
    {
      this.paperbackStock--;
    }
    // If option is Hardcover
    else if (productOptions.equalsIgnoreCase("Hardcover"))
    {
      this.hardcoverStock--;
    }
    else
    // If option is EBook
    {
      // Param does not matter but "Ebook" looks more organized
      super.setStockCount(super.getStockCount("EBook"), "EBook");
    }
	}
  /*
   * Print product information in super class and append Book specific information title and author
   */
  public void print()
  {
  	// Replace the line below.
  	// Make use of the super class print() method and append the title and author info. See the video
    super.print();
    System.out.print(" Book Title: " + this.title + " Author: " + this.author + " Year Published: " + this.year);
  }
}
