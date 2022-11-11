
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите выражение:");
            String expression = in.next();
            ExpressionAnalysis str = new ExpressionAnalysis();
            String result ="";
            result = str.ExpressionAnalysis(expression);
            System.out.println("Результат: " + result);
            Calculator calc = new Calculator(result);
            System.out.println(calc.calculate());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    //для переменных ввод
    public int inputVariable() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите значение для переменой: ");
        int variable;
        while (!in.hasNextInt()) {
            System.out.println("Неверное значение!");
            System.out.print("Введите корректное значение: ");
            in.next();
        }
        variable = in.nextInt();
        return variable;
    }
}