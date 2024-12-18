package hust.soict.ict.lab01;
import java.util.Scanner;

public class CreateTriangle 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the height of the triangle: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) 
        {
            for (int j = i; j < n; j++) System.out.print(" ");
            for (int k = 1; k <= (2 * i - 1); k++) System.out.print("*");
            System.out.println();
        }
    }
}
