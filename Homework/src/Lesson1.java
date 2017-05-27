/**
 * Created by Diana on 24.05.2017.
 */
public class Lesson1 {

    public static void main(String[] args) {
        task1();
        System.out.println();
        task2();
        System.out.println();
        task3();
        System.out.println();
        task4();
        System.out.println();
        task5();
        System.out.println();
        task6();
        System.out.println();
    }

    private static void task6() {
        int x = 3;
        int s = 5;
        int t = 2;

        double y = Math.pow(Math.sin(Math.pow(x, t)), 2)/Math.sqrt(1 + Math.pow(x, s));

        System.out.printf("x = %d, y = %.5f" , x, y);
    }

    private static void task5() {
        // HELLOcHELLO HELLOHELLOiHELLOofbjo
        String s = "?c? ??i#?###ofbjo##################";

        String preresult = s.replace("?", "HELLO");
        String result  = preresult.replace("#", "");
        System.out.println(result);
    }

    private static void task4() {
        int count = 1152;

        int suffix = count%100; // last two numbers

        if (suffix >= 5 && suffix <= 20) {
            System.out.printf("%d рублей\n", count);
        } else if (suffix%10 == 1) {
            System.out.printf("%d рубль\n", count);
        } else if (suffix%10 == 0) {
            System.out.printf("%d рублей\n", count);
        } else {
            System.out.printf("%d рубля\n", count);
        }
    }

    private static void task3() {
        int a = 5;
        int b = 32;
        int r = 10;

        double hyp = Math.sqrt(a*a + b*b);
        double d = r*2;

        if(d >= hyp) {
            System.out.println("Card will close hole");
        } else {
            System.out.println("Card is less than hole");
        }

    }

    private static void task2() {
        int num = 9327;

        System.out.println(num%10 == 7 ? "Number ends with 7. " : "Number doesn't end with 7. ");

        if (num%10 == 7) {
            System.out.println("Number ends with 7. ");
        } else {
            System.out.println("Number doesn't end with 7. ");
        }
    }

    private static void task1() {
        String s = "We’ll send you a few quick emails on how to get the most out of Slack.";
        System.out.println(s);
        System.out.printf("Count of symbols is %d \n", s.length());

        String part1 = s.substring(0, s.length()/2);
        String part2 = s.substring(s.length()/2);
        System.out.println(part1);
        System.out.println(part2);
    }
}
