// 2.2.5

import java.util.Scanner;

public class CalculateTwoNumbers 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first number: ");
        String strNum1 = scanner.nextLine();
        double num1 = Double.parseDouble(strNum1);

        System.out.print("Enter the second number: ");
        String strNum2 = scanner.nextLine();
        double num2 = Double.parseDouble(strNum2);

        System.out.println("Sum: " + MMath.Sum(num1, num2));
        System.out.println("Difference: " + MMath.Difference(num1, num2));
        System.out.println("Product: " + MMath.Product(num1, num2));
        if (num2 != 0) 
        {
            System.out.println("Quotient: " + MMath.Quotient(num1, num2));
        }
        else
        {
            System.out.println("Division by zero is not allowed.");
        }
        
        scanner.close();
        
        System.exit(0);
    }
}

class MMath
{
    public static double Sum(double a, double b) { return a + b; }
    public static double Difference(double a, double b) { return a - b; }
    public static double Product(double a, double b) { return a * b; }
    public static double Quotient(double a, double b)
    {
        double quotient = 0;
        if (b != 0) quotient = a / b;
        return quotient;
    }
}