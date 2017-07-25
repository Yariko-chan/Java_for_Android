package typization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by user on 30.06.2017.
 */
public class Main {

    public static void main(String[] args) {

        String query = "devic";
        String[] words = query.split(" ");
        String anySymbols = "(.|\n)*";
        String caseInsensive = "(?i)";
        StringBuilder builder =  new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            builder.append("(").append(anySymbols).append(caseInsensive).append(words[i]).append(anySymbols).append(")");
            builder.append("||");
        }
        // append last word without ||
        builder.append("(").append(anySymbols).append(caseInsensive).append(words[words.length - 1]).append(anySymbols).append(")");
        Pattern pattern = Pattern.compile(builder.toString());

        System.out.println(pattern.matcher("").matches());
    }
}
