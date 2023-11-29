package hello.world;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decoder {
    private static final Pattern VOWEL_PATTERN = Pattern.compile("[1-5]");
    private static final Pattern CONSONANT_PATTERN = Pattern.compile("[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]");

    public static String decodeVowelEncoding(String encodedMessage) {
        Matcher matcher = VOWEL_PATTERN.matcher(encodedMessage);
        StringBuilder decodedMessage = new StringBuilder();

        while (matcher.find()) {
            switch (matcher.group()) {
                case "1":
                    matcher.appendReplacement(decodedMessage, "a");
                    break;
                case "2":
                    matcher.appendReplacement(decodedMessage, "e");
                    break;
                case "3":
                    matcher.appendReplacement(decodedMessage, "i");
                    break;
                case "4":
                    matcher.appendReplacement(decodedMessage, "o");
                    break;
                case "5":
                    matcher.appendReplacement(decodedMessage, "u");
                    break;
            }
        }

        matcher.appendTail(decodedMessage);
        return decodedMessage.toString();
    }

    public static String decodeConsonantEncoding(String encodedMessage) {
        Matcher matcher = CONSONANT_PATTERN.matcher(encodedMessage);
        StringBuilder decodedMessage = new StringBuilder();

        while (matcher.find()) {
            char currentChar = matcher.group().charAt(0);
            char nextChar = (char) (currentChar + 1);

            if (nextChar == '{' || nextChar == '[') {
                nextChar = 'a';
            }

            if (nextChar == 'z' || nextChar == 'Z') {
                nextChar = 'b';
            }

            matcher.appendReplacement(decodedMessage, Character.toString(nextChar));
        }

        matcher.appendTail(decodedMessage);
        return decodedMessage.toString();
    }

    public static void main(String[] args) {
        String encodedMessage1 = "t2st3ng";
        String encodedMessage2 = "ufttjoh";
        /*приклад з завдання "замінюються на наступний"
        але в прикладі щоб з  "ufttjoh" вийшло "testing"
        треба замінити на попередні літери*/

        String encodedMessage3 = "sdrshmf";

        String decodedMessage1 = decodeVowelEncoding(encodedMessage1);
        String decodedMessage2 = decodeConsonantEncoding(encodedMessage2);
        String decodedMessage3 = decodeConsonantEncoding(encodedMessage3);

        System.out.println("Decoded Message 1: " + decodedMessage1);
        System.out.println("Decoded Message 2: " + decodedMessage2);
        System.out.println("Decoded Message 3: " + decodedMessage3);
    }
}