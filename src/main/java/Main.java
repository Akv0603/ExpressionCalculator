import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        for(;;) {
            System.out.println("Введите значения с пробелами между знаками!");
            Scanner scanner = new Scanner(System.in);
            String expr = scanner.nextLine();
            if(expr.equals("q"))
                break;
            ExpressionCalculator calculator = new ExpressionCalculator(expr);
            double result = calculator.parse();
            System.out.println(expr + " = " + result);
        }
    }
}
