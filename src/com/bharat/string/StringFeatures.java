package com.bharat.string;

import com.bharat.array.ArrayFeatures;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StringFeatures {

    static String[] reverseStrings(String[] testStrings){
        return Arrays.stream(testStrings)
                .filter(Predicate.not(s-> Objects.isNull(s) || s.isBlank()))
                //Predicate.not() static method in interface -> Provides utility behaviour
                .map(s-> new StringBuilder(s).reverse().toString().intern())
                .toArray(String[]::new);
    }

    static String getStringFromArray(String @NotNull [] array){
        String temp = array[0];
        return Arrays.stream(array)
                .filter(s -> temp == s) //filter is to check if intern() working
//                .collect(Collectors.joining(","));
        //Collectors.joining internally uses StringJoiner (Java 8) can be replaced as below
                .collect(Collector.of(() ->
                        new StringJoiner(","),  //supplier
                        StringJoiner::add,              //accumulator (BiConsumer)
                        StringJoiner::merge,            //combiner (BinaryOperator/BiFunction)
                        StringJoiner::toString));       //finisher (Function)
                                                        //Characteristics optional
    }

    static Map<Boolean, List<String>> checkCircularStrings(String[] testStrings, String actualString) {
        return Arrays.stream(testStrings)
                .collect(
                        Collectors.groupingBy(s -> (s + s).contains(actualString), //main logic
                                Collectors.toList()));
    }

    static void testRepeatAndLines(String s){

        String repeat = s.repeat(1);
        System.out.println(repeat.lines().collect(Collectors.joining(",")));
    }

    static boolean checkIfAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        } else {
            Map<Integer, Long> map1 = a.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Map<Integer, Long> map2 = b.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            return map1.equals(map2);
            // or can be done using array countArray[256 characters] do ++ for each character
        }
    }

    static String removeAllWhitespaces(String s){
        return s.replaceAll("\\s+","");
        //or s.replace(" ","");
    }

    static boolean containsVowel(String s){
        return s.toLowerCase().matches(".*[aeiou].*");
    }

    static void printPositionsOfBinaryOneOfNumber(int n){
        char[] s = Integer.toBinaryString(n).toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '1') {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //Sample Input bharat,bharat@bharat!bharat
        //[trim()/strip()],split with good regex
        String[] testStrings = bufferedReader.readLine().strip().split("[@,!\\s]+");

        // isBlank(), builder.reverse(), intern() ,
        //Collector.of()
        System.out.println(getStringFromArray(reverseStrings(testStrings)));

        System.out.println(checkCircularStrings(new String[]{"aratbh", "tbharat","tarahb"},"bharat"));
        // repeat(), lines()->Stream<String>
        testRepeatAndLines("this is one line \n");
        // replaceAll()
        System.out.println(removeAllWhitespaces("this is a sentence with whitespaces"));
        //chars()
        System.out.println(checkIfAnagram("abcdef","fedbac"));
        // matches()
        System.out.println(containsVowel("bharat"));
        //toCharArray()
        printPositionsOfBinaryOneOfNumber(9);
        ArrayFeatures af = new ArrayFeatures();
        // character stream to String using Collectors.joining, maptoObj() for IntStream to Boxed Stream
        af.caesarCipher("zxyat");
        //Pattren.compile, matcher.find , matcher.group()
        System.out.println(patternSyntaxChecker("this is is bye bye a sentence with words which are duplicate duplicate and we will remove duplicate words with regex"));
    }

    private static String patternSyntaxChecker(String s) {
        Matcher matcher = Pattern.compile("\\b([a-zA-Z]+)\\b(?:\\s+\\1\\b)+").matcher(s);
        boolean matches = matcher.matches(); //matches entire input -> return false
        System.out.println("Pattern:"+matcher.pattern().pattern());
        System.out.println("String to check:"+s);
        System.out.println("Entire string Matches? :"+matches);
        while(matcher.find()){
            String wholeMatchedSequence = matcher.group(); // s.substring(matcher.start(),matcher.end())
            System.out.println(matcher.group(1)); //to get particular group
            s= s.replaceAll(
                    matcher.group(),
                    matcher.group(1));
        }
        return s;
    }

}
