import java.util.Scanner;

public class LinearAndQuadraticSolver 
{

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the type of equation to solve:");
        System.out.println("0. Close calculator");
        System.out.println("1. First-degree equation with one variable");
        System.out.println("2. System of first-degree equations with two variables");
        System.out.println("3. Second-degree equation with one variable");
        int choice = scanner.nextInt();

        switch (choice) 
        {
        	case 0: System.exit(0); break;
            case 1: SolveFirstDegreeEquation(scanner); break;
            case 2: SolveSystemOfFirstDegreeEquations(scanner); break;
            case 3: SolveSecondDegreeEquation(scanner); break;
            default: System.out.println("Invalid choice");
        }
        
        System.exit(0);
    }

    private static void SolveFirstDegreeEquation(Scanner scanner) 
    {
        System.out.println("Solving first-degree equation ax + b = 0");
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();

        if (a != 0) System.out.println("The solution is x = " + (double)(-b / a));
        else System.out.println("No solution, a cannot be zero.");
    }

    private static void SolveSystemOfFirstDegreeEquations(Scanner scanner) 
    {
        System.out.println("Solving system of first-degree equations:");
        System.out.println("Equation 1: a1*x + b1*y = c1");
        System.out.println("Equation 2: a2*x + b2*y = c2");

        System.out.print("Enter a1: ");
        double a1 = scanner.nextDouble();
        System.out.print("Enter b1: ");
        double b1 = scanner.nextDouble();
        System.out.print("Enter c1: ");
        double c1 = scanner.nextDouble();

        System.out.print("Enter a2: ");
        double a2 = scanner.nextDouble();
        System.out.print("Enter b2: ");
        double b2 = scanner.nextDouble();
        System.out.print("Enter c2: ");
        double c2 = scanner.nextDouble();

        double determinant = a1 * b2 - a2 * b1;

        if (determinant != 0) 
        {
            double x = (c1 * b2 - c2 * b1) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;
            System.out.println("The solution is x = " + x + ", y = " + y);
        } 
        else System.out.println("No unique solution exists.");
    }

    private static void SolveSecondDegreeEquation(Scanner scanner) 
    {
    	System.out.println("Solving second-degree equation ax^2 + bx + c = 0");
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();

        if (a == 0) 
        {
            System.out.println("No root, a cannot be zero.");
            return;
        }

        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) System.out.println("No root, the discriminant is less than zero.");
        else if (discriminant == 0) 
        {
            double root = -b / (2 * a);
            System.out.println("The root is real and same.");
            System.out.println("Root: " + root);
        } 
        else 
        {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The roots are real and different.");
            System.out.println("Root 1: " + root1);
            System.out.println("Root 2: " + root2);
        }
    }
}
