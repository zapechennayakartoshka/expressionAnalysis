import java.util.Vector;
import java.util.Vector;
//анализ введенного выражения
class ExpressionAnalysis {
    Vector<String> letter;//вектор для переменных
    Vector<Integer> number;//вектор для чисел
    public ExpressionAnalysis() {
        letter = new Vector<String>(10);//для переменных
        number = new Vector<Integer>(10);//для чисел
    }
    public String ExpressionAnalysis(String str) throws Exception
    {
        String result = "";
        int position = 0;
        while (position < str.length())
        {
            char ch = str.charAt(position);
            switch (ch)
            {
                case '(': case ')': case '+': case '-': case '*': case '/':
                result += ch;
                result += " ";
                position++;
                continue;
                default:
                    if (ch <= '9' && ch >= '0')
                    {
                        String ch1 = "";
                        do {
                            ch1 += ch;
                            position++;
                            if (position >= str.length())
                                break;
                            ch = str.charAt(position);
                        } while (ch <= '9' && ch >= '0');
                        result += ch1;
                        result += " ";
                    }else if (ch <= 'z' && ch >= 'a' || ch >= 'A' && ch <= 'Z') {
                        String ch1 = "";
                        do {
                            ch1 += ch;
                            position++;
                            if (position >= str.length())
                                break;
                            ch = str.charAt(position);
                        } while (ch <= 'z' && ch >= 'a' || ch >= 'A' && ch <= 'Z');
                        if (letter.isEmpty())
                        {
                            Main main = new Main();
                            int value = main.inputVariable();
                            letter.add(ch1);
                            number.add(value);
                            ch1 = String.valueOf(number.elementAt(0));
                        } else
                        {
                            boolean flag = false;
                            for (int i = 0; i < letter.size(); i++)
                            {
                                if (ch1.equals(letter.elementAt(i)))
                                {
                                    ch1 = String.valueOf(number.elementAt(i));
                                    flag = true;
                                }
                            }
                            if (flag == false)
                            {
                                Main main = new Main();
                                int value = main.inputVariable();
                                letter.add(ch1);
                                number.add(value);
                                ch1 = String.valueOf(number.lastElement());
                            }
                        }
                        result += ch1;
                        result += " ";
                    }else
                    {
                        if (ch != ' ')
                            throw new Exception("Неверный символ");
                        position++;
                    }
            }
        }
        return result;
    }
}