
import java.util.Vector;
//вычисление выражения
public class Calculator
{
    private String[] symbols;//строка символов
    private int pos;//позиция элемента
    public Calculator(String symbols)
    {
        this.symbols = symbols.split(" ");
        this.pos = 0;
    }
    public double calculate() throws Exception
    {
        double result = Add_with_Sub();
        if (pos != symbols.length) {
            throw new Exception("Неверный ввод!");
        }
        return result;
    }
    //для сложения и вычитания
    public double Add_with_Sub() throws Exception
    {
        double num1 = Mul_with_Div();
        while (pos <symbols.length)
        {
            String action = symbols[pos];
            if (!action.equals("+") && !action.equals("-"))
                break;
            else pos++;
            if (pos < symbols.length)
            {
                double num2 = Mul_with_Div();
                if (action.equals("+"))
                    num1 += num2;
                else num1 -= num2;
            }
            else
                throw new Exception("Неверный ввод!");
        }
        return num1;
    }
    //для умножения и деления
    public double Mul_with_Div() throws Exception
    {
        double num1 = Brackets();

        while (pos <symbols.length)
        {
            String action = symbols[pos];
            if (!action.equals("*") && !action.equals("/"))
                break;
            else pos++;
            if (pos < symbols.length) {
                double num2 = Brackets();
                if (action.equals("*"))
                    num1 *= num2;
                else
                if (num2 != 0)
                    num1 /= num2;
                else
                    throw new Exception("Невозможно делить на 0!");
            } else
                throw new Exception("Неверный ввод!");
        }
        return num1;
    }
    //проверка на скобки
    public double Brackets() throws Exception
    {
        String next = symbols[pos];
        double result;
        if(next.equals("-"))
        {
            pos++;
            String newMinus = symbols[pos];
            if (newMinus.equals("-"))
                throw new Exception("Неверный ввод!");
            result = Brackets();
            return -result;

        }
        if (next.equals("("))
        {
            pos++;
            result = Add_with_Sub();
            String closingBracket;
            if (pos < symbols.length)
                closingBracket = symbols[pos];
            else throw new Exception("Конец выражения");
            if (closingBracket.equals(")"))
            {
                pos++;
                return result;
            }
            throw new Exception("Отсутствует закрывающая скобка");
        }
        pos++;
        if (next.equals("+") || next.equals("*") || next.equals("/") || next.equals(")"))
            throw new Exception("Неверный ввод!");
        return Double.parseDouble(next);
    }
}