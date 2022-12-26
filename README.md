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


# Commands
## Input Commands (Information Saved To Database)
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

## Output Commands (Information to Screen)
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

## Sorting Commands (Sorted Output)
### **SORTBYPRICE**
>This command will print all products from least to greatest by the price of the product. This command will output the same amount of information as PRODS but with a different order.
### **SORTBYNAME**
>This command will print all products in alphabetical order. This command will output the same amount of information as PRODS but with a different order.
### **SORTCUSTS**
>This command will print all customers in alphabetical order. This command will output the same amount of information as CUSTS but with a different order.
### **BOOKSBYAUTHOR**
>This command will print all book products written by the provided author.
