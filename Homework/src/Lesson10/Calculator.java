package Lesson10;

import java.util.Scanner;

/**
 * Created by Diana on 14.06.2017.
 */
public class Calculator {
    private int num1, num2;
    private char sign;

    public static void main(String[] args) {
        Calculator c = new Calculator();
        try {
            c.input();
            int result = c.calculate();
            System.out.println("Result: " + result);
        } catch (UnsupportedSignException e) {
            System.out.println("Error: " + e.getRussianMessage() + ": " + e.getSign());
        } catch (DivideByZeroException e) {
            System.out.println("Error: " + e.getRussianMessage());
        }
    }

    private int calculate() throws DivideByZeroException {
        int result;
        switch (sign) {
            case '-' : result = num1 - num2; break;
            case '*' : result = num1 * num2; break;
            case '/' : {
                if (num2 == 0) throw new DivideByZeroException();
                result = num1 / num2;
                break;
            }
            default : result = num1 + num2; break;
        }
        return result;
    }

    private void input() throws UnsupportedSignException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number:");
        num1 = sc.nextInt();

        System.out.println("Enter second number:");
        num2 = sc.nextInt();

        System.out.println("Enter sign (+, -, /, *): ");
        sign = sc.next().charAt(0);
        if ("+-*//*".indexOf(sign) < 0) {
            throw new UnsupportedSignException(sign);
        }

    }

    private class UnsupportedSignException extends Throwable {
        private final char sign;
        private final String message = "Unsupported sign";
        private final String russianMessage = "Знак не поддерживается";

        public UnsupportedSignException(char sign) {
            this.sign = sign;
        }

        public String getRussianMessage() {
            return russianMessage;
        }

        public char getSign() {
            return sign;
        }
    }

    private class DivideByZeroException extends Throwable {
        private final String message = "Divide by zero is unsupported";
        private final String russianMessage =  "Деление на ноль не поддерживается";

        public String getRussianMessage() {
            return russianMessage;
        }
    }
}
