# Online-Retail-Simulator 
This Online Retail Simulator was created as a university project with starter boilerplate code. Functionality was then explained and required the programmer to build apon it themselves. A quick description of the purpose of the program is explained below, the commands can also be foud at the bottom of the document.

# How To Run
Running this program is really simple. All you need is the Java compiler on your PC and an IDE that will allow you to run the program. Since this is a non-graphics based project, the source will have to be manually compiled.

```
javac ECommerceUserInterface.java
java ECommerceUserInterface
```
You can also just utilize this command directly in new versions of Java.
```
java EcommerceUserInterface.java
```
Finally, in editors like VSCode, you can just download the Coderunner extension to execute the code for you.
# Purpose Statement
This program allows you to simulate a simple Ecommerce System with two methods of purchase. You can either utilize commandst to directly order products for customers. Or instead utilize the cart method, and add items to a users cart before purchase. Shipping is done the same for both. Customers can be added using built-in commands. The database of products must be coded in directly or provided through the products.txt, but it is a rather easy implimentation to be done through the program.

If you wish to add a product to the products.txt, get a good understanding of the properties of the product you wish to add. 
For example, if you wanted to add a basic GENERAL product, you would have to provide a category, name, price, and stock.
```
GENERAL
Rock Hammer
10.0
22
```
For example, if you wanted to include a new book object, you would have to include the prior info and also provide extra types of stock (Hardcover, Paperback), author, title, and year.
```
BOOKS
Book
45.0
4 2
Ahm Gonna Make You Learn More:Mr. Professor:2022
```
If you want to include a shoes object, currently it is only possible through direct code in the database. Please see the commented out shoe objects in Ecommerce System to add your own.

# Commands
### **Q**
>This command will exit the simulation.
### **QUIT**
>This is a reflavour of the Q command.
## *Input Commands (Information Saved To Database)*
### **NEWCUST**
>This command lets you allocate space for a new customer in the database. You will have to provide it with a quick user profile, but the allocation is done using linear probing.
### **ORDER**
>This command lets you order a product for a respective customer. This command does not work with books and shoes as those products require added detail.
### **ORDERBOOK**
>This command is a child of ORDER and lets you order a book for a respective customer.
### **ORDERSHOES**
>This command is a child of ORDER and lets you order shoes for a respective customer.
### **CANCEL**
>This command lets you cancel an order.
### **SHIP**
>This command lets you ship an order that you have already created prior. Once a product is shipped, it cannot be returned.

## *Output Commands (Information to Screen)*
### **PRODS**
>This command will print out all current registered products in the simulation. Products can be added with an alternate command.
### **CUSTS**
>This command will print out all current registered customers in the simulation. Customers can be added with an alternate command.
### **BOOKS**
>This command will print all products in the simulation that are strictly of type book. This is a child command of PRODS.
### **ORDERS**
>This command will print out all orders in the simulation. Orders allow customers to purchase products. Orders can be created with an alternate command.
### **SHIPPED**
>This command will print out all shipped products in the simulation. If you create an order for a customer and ship it, it will be present in this list.
### **STATS**
>This command will print all products and their respective ratings. See the alternate rating command (RATE) to rate a product.
### **PRODRATING**
>This command will print all products from greatest rating to least. See the alternate rating command (RATE) to rate a product.

## *Sorting Commands (Sorted Output)*
### **SORTBYPRICE**
>This command will print all products from least to greatest by the price of the product. This command will output the same amount of information as PRODS but with a different order.
### **SORTBYNAME**
>This command will print all products in alphabetical order. This command will output the same amount of information as PRODS but with a different order.
### **SORTCUSTS**
>This command will print all customers in alphabetical order. This command will output the same amount of information as CUSTS but with a different order.
### **BOOKSBYAUTHOR**
>This command will print all book products written by the provided author.

## *Cart Commands (Advanced Method of Purchase)*
### **ADDTOCART**
>This command lets you add a product to a customers cart.
### **REMCARTITEM**
>This command lets remove a product from a customers cart.
### **PRINTCART**
>This command lets you output all products of the provided customer.
### **ORDERITEMS**
>This command will order the items inside the customers cart. Shipping is done manually afterwards.