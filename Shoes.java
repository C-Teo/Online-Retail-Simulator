/* 
 *  Shoes is a product that has additional properties
 *  It can have sizes from 6 to 10 inclusive and be colored
 *  Black or Brown.
*/
public class Shoes extends Product
{   
    // Decrement size by final to get index in stock array
    private static final int INDEX = 6; 

    // Different type of shoe stock
    // Can be in size 6, 7, 8, 9, 10
    private int[] blackStock;
    private int[] brownStock;

    // Constructor for the Shoe class
    public Shoes(String name, String id, double price, int[] blackStock, int[] brownStock)
    {
        super(name, id, price, 0, Category.CLOTHING);
        this.blackStock = blackStock.clone();
        this.brownStock = brownStock.clone();
    }
    // Check if a valid format
    public boolean validOptions(String productOptions)
    {
        // Check if productOptions is empty or null return false
        if (productOptions.equals("") || productOptions == null)
        {
            return false;
        }

        // If productOptions is not empty program routed through the right function
        // Take the input and split it into color and size
        String[] options = productOptions.split("/");

        // Check if it is the right color (Black or Brown)
        // If color chosen is black or brown check stock
        if (options[1].equalsIgnoreCase("Black") || options[1].equalsIgnoreCase("Brown")) 
        {
            // Check if it is the right size (6,7,8,9,10)
            // If size chosen is between 6 and 10 inclusive it is a valid option
            return (options[0].equals("6") || options[0].equals("7") || options[0].equals("8") || options[0].equals("9") || options[0].equals("10"));
            // This weird order is to make sure the second input is a number
        }

        // Return false if above parameter is not met
        return false;
    }
    // Get the amount of stock of a specific shoe type
    public int getStockCount(String productOptions)
    {
        // Take the input and split it into color and size
        String[] options = productOptions.split("/");

        // Check if the color is black or brown
        if (options[1].equalsIgnoreCase("Black"))
        {
            return this.blackStock[Integer.parseInt(options[0])-INDEX];
        }
        else if (options[1].equalsIgnoreCase("Brown"))
        {
            return this.brownStock[Integer.parseInt(options[0])-INDEX];
        }
        return 0; // If more colors are added later
    }
    // Set the stock of a specific shoe type
    public void setStockCount(int stockCount, String productOptions)
    {
        // Take the input and split it into color and size
        String[] options = productOptions.split("/");

        // Check if the color is black or brown
        if (options[1].equalsIgnoreCase("Black"))
        {
            this.blackStock[Integer.parseInt(options[0])-INDEX] = stockCount;
        }
        else if (options[1].equalsIgnoreCase("Brown"))
        {
            this.brownStock[Integer.parseInt(options[0])-INDEX] = stockCount;
        }
    }
    // When a Shoe is ordered, reduce the stock for the specific type by one
    public void reduceStockCount(String productOptions)
    {
        // Take the input and split it into color and size
        String[] options = productOptions.split("/");

        // Check if the color is black or brown
        if (options[1].equalsIgnoreCase("Black"))
        {
            this.blackStock[Integer.parseInt(options[0])-INDEX] -= 1;
        }
        else if (options[1].equalsIgnoreCase("Brown"))
        {
            this.brownStock[Integer.parseInt(options[0])-INDEX] -= 1;
        }
    }
}

