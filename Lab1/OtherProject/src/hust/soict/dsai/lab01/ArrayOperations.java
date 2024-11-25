package hust.soict.dsai.lab01;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) array[i] = scanner.nextInt();

        Arrays.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));

        int sum = 0;
        for (int num : array) sum += num;
        double average = (double) sum / n;

        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average of array elements: " + average);
    }
}
