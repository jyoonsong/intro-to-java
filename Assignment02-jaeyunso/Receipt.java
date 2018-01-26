import java.util.*;
import java.io.*;
import java.time.*;
// Jaey (Jaeyun) Song
// ITP 109, Fall 2017
// Homework 02
// jaeyunso@usc.edu
public class Receipt {
     //instance variables
     private Scanner scan;
     private final double TAX_RATE = 0.0758;
     private String storeName = "Bad-Mart";
     private String storeLocation = "3551 Trousdale Pkwy, Los Angeles, CA";
     
     public Receipt(){ // Already complete
         scan = new Scanner(System.in);
     }
     
     public void run(){// Already complete
         System.out.println("Welcome to the command-line receipt tool.");
         String name = askForItemName();
         int qty = askForItemQty();
         Double price = askForItemPrice();
         printReceipt(name, qty, price);
         System.out.println("Good-bye.");
     }
     
     private String askForItemName(){
         //TODO: Fill this in
         System.out.print("Please enter an item for receipt: ");
         // scan.nextLine(); - if it's second time to use this program, scanner needs to be flushed
         String itemName = scan.nextLine(); //local variable
         return itemName;
     }
     
     private int askForItemQty(){
         //TODO: Fill this in
         System.out.print("Please enter a quantity for item: ");
         int itemQty = scan.nextInt(); //local variable
         return itemQty;
     }
     
     private double askForItemPrice(){
         //TODO: Fill this in
         System.out.print("Please enter a price for item: $");
         Double itemPrice = scan.nextDouble(); //local variable
         return itemPrice;
     }
     
     private void printReceipt(String name, int qty, double price){
         //TODO: Finish this method
         double subTotal = qty * price;
         double taxRate = 100*TAX_RATE;
         double totalPrice = subTotal + subTotal*TAX_RATE;
         
         System.out.println();
         System.out.println("----------------------------------------------------");
         System.out.println("| Store: " + storeName);
         System.out.println("| Location: " + storeLocation);
         System.out.println("| Date: " + LocalDateTime.now() );
         System.out.println("|");
         System.out.println("| Item: " + name);
         System.out.println("| Qty: " + qty);
         System.out.println("| Price: $" + String.format("%.2f", price) );
         System.out.println("| ..................................................");
         System.out.println("| Subtotal: $" + String.format("%.2f", subTotal) );
         System.out.println("| Tax Rate: " + String.format("%.2f", taxRate) + "%");
         System.out.println("|");
         System.out.println("| ..................................................");
         System.out.println("| Total Price: $" + String.format("%.2f", totalPrice) );
         System.out.println("|");
         System.out.println("|");
         System.out.println("| Thank you for using " + storeName);
         System.out.println("| No refund possible :) Sorry haha");
         System.out.println("----------------------------------------------------");
         System.out.println();
     }
}