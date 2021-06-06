import java.util.Scanner;


/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Kieran Jimenez
 */
/*
 *           "Tax Calculator" output
 *What is the order amount? 10
 *What is the state? WI
 *The subtotal is $10.00.
 *The tax is $0.55.
 *The total is $10.55.
 */
public class App
{
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        App myApp = new App();

        System.out.print("What is the order amount? ");
        double order = in.nextDouble();

        System.out.print("What is the state? ");
        String state = in.next();
        state = state.toLowerCase();

        String result = String.format("The total is $%.2f.", order);

        if(state.equals("wi"))
        {
            double tax = myApp.calculateTax(order);
            result = String.format("The subtotal is $%.2f.\nThe tax is $%.2f.\nThe total is $%.2f.", order, tax, order + tax);
        }

        System.out.println(result);
    }

    private double calculateTax(double subtotal)
    {
        double result = .055 * subtotal;
        double temp = result;

        temp *= 100;

        if(temp%1 > 0.00000000000001)//checks for fractions of a cent, 0.00000000000001 is present even when perfectly divided
        {
            result -= (temp%1)/100;
            result += 0.01;
        }

        return result;
    }
}
