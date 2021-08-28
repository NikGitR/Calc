
import java.io.IOException;
import java.util.Scanner;

public class DataReader {

    public boolean flag, flag2 = false;
    private int number1;
    private int number2;
    private char operation;

    public void read() {

      //  Integer[] arabic = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        String[] roman = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};

        System.out.println("Введите выражение, состоящее из двух целых чисел от 0 до 10, и знака операции (напр. 2+2): ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        try {
            String[] blocks = text.split("[+-/*]");
            if (blocks.length < 2) {
                throw new MyException();
            }
            // проверяем, входит ли строка blocks[0] в массив строк массива "roman"
            for (int i = 0; i < roman.length; i++) {
                if (roman[i].equals(blocks[0])) {
                    flag = true;
                }
            }
            for (int i = 0; i < roman.length; i++) {
                if (roman[i].equals(blocks[1])) {
                    flag2 = true;
                }
            }
            if (blocks.length > 2) {
                throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }

            if (flag != flag2) {
                throw new IOException("т.к. используются одновременно разные системы счисления");
            }
            //flag = true, значит будем иметь дело с римскими обозначениями
            if (flag && flag2) {
                number1 = ToNumber.romanToNumber(blocks[0]);
                number2 = ToNumber.romanToNumber(blocks[1]);
            } else {
                number1 = Integer.parseInt(blocks[0]);
                number2 = Integer.parseInt(blocks[1]);
            }
            operation = text.charAt(blocks[0].length());

            if ((number1 > 10 || number1 < 0) || (number2 > 10 || number2 < 0)) {
                throw new IllegalArgumentException();
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Неверный формат данных");
        } catch (IOException e) {
            throw new IllegalArgumentException("throws Exception т.к. используются одновременно разные системы счисления");
        } catch (MyException e) {
            throw new IllegalArgumentException("throws Exception т.к. строка не является математической операцией");
        } catch (Exception e) {
            throw new IllegalArgumentException("throws Exception т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
    }

    public int getVar1() {

        return number1;
    }

    public int getVar2() {

        return number2;
    }

    public char getOper() {

        return operation;
    }

    public boolean getFlag() {
        return flag;
    }

    public boolean getFlag2() {
        return flag2;
    }
}
