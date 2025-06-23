import java.util.Scanner;

public class FinancialForecasting {

    // Recursive method to calculate future value
    // FV(n) = FV(n-1) * (1 + growthRate)
    // Base case: FV(0) = presentValue
    public static double futureValueRecursive(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return futureValueRecursive(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    // Iterative method to calculate future value (optimized)
    public static double futureValueIterative(double presentValue, double growthRate, int years) {
        double futureValue = presentValue;
        for (int i = 0; i < years; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Financial Forecasting Tool");
        System.out.print("Enter present value: ");
        double presentValue = scanner.nextDouble();

        System.out.print("Enter annual growth rate (e.g., 0.05 for 5%): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter number of years to forecast: ");
        int years = scanner.nextInt();

        double fvRecursive = futureValueRecursive(presentValue, growthRate, years);
        System.out.printf("Future value (recursive): %.2f%n", fvRecursive);

        double fvIterative = futureValueIterative(presentValue, growthRate, years);
        System.out.printf("Future value (iterative): %.2f%n", fvIterative);

        /*
         * Analysis:
         * - Time complexity for both methods is O(n), where n is the number of years.
         * - Recursive approach has additional overhead due to multiple function calls.
         * - Iterative approach is generally more efficient and avoids stack overflow risk.
         * - For large 'years', iterative method is preferred.
         */

        scanner.close();
    }
}
