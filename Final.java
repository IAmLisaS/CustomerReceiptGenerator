// Lisa Sinn
// Intro to Java - CSCI 1146 
// CSCI 1146-241
// Final Exam
// Final.java

import java.io.PrintWriter;
import java.util.Scanner;

public class Final {

   public static double getCommision(double amount) {
       double commission=0;
       if(amount<200){
           commission = 2;
       }else if(amount<400){
           commission = 3;
       }else if(amount<600){
           commission = 4;
       }else if(amount>600){
           commission = 5;
       }
       return commission;
   }

   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       try{
           //array to store 5 amount value
           double amounts[]=new double[5];

           for(int i=1;i<=5;i++){
               System.out.print("Enter the total amount of the customer’s order # "+i+": ");
               amounts[i-1] = sc.nextDouble();
           }
           PrintWriter outputFile = new PrintWriter("Order.txt");
           double tax;
           double amountWithTax;
           double commission;
           double commissionAmount;
           double finalOrderPrice;
           double totalOrderSum=0;
           for(int i=0;i<5;i++){
               outputFile.write("\nAmount of order # "+(i+1)+" is: $"+amounts[i]);
               outputFile.write(" ");
               tax = amounts[i]*7/100;
               outputFile.write("\nAmount of Sales tax(7%): $"+tax);
               outputFile.write(" ");
               amountWithTax = amounts[i]+tax;
               outputFile.write("\nThe total amount including tax added: $"+amountWithTax);
               outputFile.write(" ");
               commission = getCommision(amounts[i]);
               commissionAmount = amounts[i]*commission/100;
               outputFile.write("\nCommission percent "+commission+" %"+": $"+commissionAmount);
               outputFile.write(" ");
               finalOrderPrice = amountWithTax - commissionAmount;
               outputFile.write("\nOrder net amount after commission is: $"+finalOrderPrice);
               outputFile.write(" ");
               totalOrderSum+=finalOrderPrice;
               outputFile.write("\n=================================== ");
           }
          
           outputFile.write("\nSum of total order is: $"+totalOrderSum);
           outputFile.write(" ");
           outputFile.write("\nAverage of total order is: $"+totalOrderSum/5);
           outputFile.write(" ");
           outputFile.write("\nThanks for your business and please come again.");
           outputFile.close();
           System.out.println("Data exported to Order.txt successfully!");
           System.out.println("Thanks for your business and please come again.");
       }catch(Exception e){
           System.out.println("Error while opening while");
       }
   }
}