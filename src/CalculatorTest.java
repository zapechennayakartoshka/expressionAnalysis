import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }
    @Test
    public void test1() throws Exception {
        String expression = "60+5*(8-3)";
        ExpressionAnalysis str = new ExpressionAnalysis();
        String result = "";
        result = str.ExpressionAnalysis(expression);
        Calculator calc = new Calculator(result);
        assertEquals(85.0,calc.calculate());
    }
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    @Test
    public void test2() throws Exception {
        try{String expression = "60+5*(8/0)";
        ExpressionAnalysis str = new ExpressionAnalysis();
        String result = "";
        result = str.ExpressionAnalysis(expression);
        Calculator calc = new Calculator(result);}
        catch (Exception e) {
            System.out.println(e.getMessage());
            assertEquals("Невозможно делить на 0!", output.toString());}
    }
    @Test
    public void test3() throws Exception {
        try{String expression = "(80-33)5(3+4)";
            ExpressionAnalysis str = new ExpressionAnalysis();
            String result = "";
            result = str.ExpressionAnalysis(expression);
            Calculator calc = new Calculator(result);}
        catch (Exception e) {
            System.out.println(e.getMessage());
            assertEquals("Неверный ввод!", output.toString());}
    }
}