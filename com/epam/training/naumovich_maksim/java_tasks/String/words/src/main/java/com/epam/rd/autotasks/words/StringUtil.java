package com.epam.rd.autotasks.words;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if(sample == null || words == null || words.length == 0){
            return 0;
        }
        int count = 0;
        sample = sample.trim();
        for (String word : words){
            word = word.strip();
            if (sample.equalsIgnoreCase(word)){
                count++;
            }
        }
        return count;
    }

    public static String[] splitWords(String text) {
        if (text==null || text == ""){
            return null;
        }
        StringTokenizer string = new StringTokenizer(text, ",.:;!? ", false);
        if (string.countTokens() == 0){
            return null;
        }
        String[] words = new String[string.countTokens()];
        int countTokens = string.countTokens();
        for (int i=0; i < countTokens; i++){
            words[i] = string.nextToken();
        }
        return words;
    }

    private static boolean hasRegex(String regex, String path) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(path);
        return m.lookingAt();
    }

    private static boolean isPath(String path) {
        if (hasRegex(".*~.*~", path)) {
            return false;
        }
        if (hasRegex(".+~", path)) {
            return false;
        }
        if (hasRegex("~.*\\\\", path)) {
            return false;
        }
        if (hasRegex(".*C:.*C:", path)) {
            return false;
        }
        if (hasRegex(".+C:", path)) {
            return false;
        }
        if (hasRegex("C:.*/", path)) {
            return false;
        }
        if (hasRegex(".*/.*\\\\", path)) {
            return false;
        }
        if (hasRegex(".*\\\\.*/", path)) {
            return false;
        }
        return true;
    }

    public static boolean isWindows(String path) {
        Pattern p = Pattern.compile(".*\\\\");
        Matcher m = p.matcher(path);
        return m.lookingAt();
    }

    public static boolean isRegex(String regex, String path) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(path);
        return m.matches();
    }

    public static String toUnix(String path) {
        if (isRegex("C:\\\\User.*", path)) {
            Pattern p = Pattern.compile("C:\\\\User");
            Matcher m = p.matcher(path);
            path = m.replaceFirst("~");
        } else if (isRegex("C:\\\\.*", path)) {
            Pattern p = Pattern.compile("C:\\\\");
            Matcher m = p.matcher(path);
            path = m.replaceFirst("/");
        }
        Pattern p = Pattern.compile("\\\\");
        Matcher m = p.matcher(path);
        path = m.replaceAll("/");
        return path;
    }

    public static String toWindows(String path) {
        if (isRegex("~.*", path)) {
            Pattern p = Pattern.compile("~");
            Matcher m = p.matcher(path);
            path = m.replaceFirst("C:\\\\User");
        } else if (isRegex("/.*", path)) {
            Pattern p = Pattern.compile("/");
            Matcher m = p.matcher(path);
            path = m.replaceFirst("C:\\\\");
        }
        Pattern p = Pattern.compile("/");
        Matcher m = p.matcher(path);
        path = m.replaceAll("\\\\");
        return path;
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path == "" || !isPath(path)) {
            return null;
        }

        boolean isWin = isWindows(path);
        if (isWin && toWin) {
            return path;
        }
        if (!isWin && !toWin) {
            return path;
        }

        if (toWin) {
            path = toWindows(path);
        } else {
            path = toUnix(path);
        }

        return path;
    }

    public static String joinWords(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }

        String resultStr = "[";
        boolean hasNotEmptyString = false;
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            hasNotEmptyString = true;
            resultStr += word;
            resultStr += ", ";
        }

        if (!hasNotEmptyString) {
            return null;
        }
        resultStr = resultStr.substring(0, resultStr.length() - 2);
        resultStr += "]";
        return resultStr;
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}