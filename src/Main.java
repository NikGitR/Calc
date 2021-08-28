import java.io.IOException;

public class Main {
   // private static final char exitCharacter = '!';

    public static void main(String[] args) {
        DataReader reader = new DataReader(/*exitCharacter*/);
        while (true) {
            try {
                reader.read();
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                continue;
            }

            int result = Calculator.calculate(reader.getVar1(), reader.getVar2(), reader.getOper());
            if (reader.getFlag() && reader.getFlag2()) {
                if (result < 0) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.err.println("throws Exception т.к. в римской системе нет отрицательных чисел");
                    }
                    // continue;
                    break;
                }
                System.out.println(ToRoman.intToRoman(result));

            } else {
                System.out.println(result);

            }
        }
    }
}
