package com.epam.ld.javabasics2_1.stringstask;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringsTask {
    public static void main(String[] args) {

        //Составить из букв введенной строки слова
        //Вводится строка, состоящая из букв и пробелов. Составить из входящих в нее букв несколько любых их сочетаний (слов) любой длины. Каждую букву строки можно использовать неограниченное количество раз.
        System.out.println("Составить из букв введенной строки слова");
        sTask1("abjkla sdfkapfm imigcao crupwei");

        //Является ли строка идентификатором
        //Определить, является ли введенное слово идентификатором, т.е. начинается ли оно с английской буквы в любом регистре или знака подчеркивания и не содержит других символов, кроме букв английского алфавита (в любом регистре), цифр и знака подчеркивания.
        System.out.println();
        System.out.println("Является ли строка идентификатором");
        sTask2(new String[] {"ksdj", "_sfas", "8342aslfjs", "тест", "_тест"});

        //Удалить из строки пробелы и определить, является ли она перевертышем
        //Вводится строка. Удалить из нее все пробелы. После этого определить, является ли она палиндромом (перевертышем), т.е. одинаково пишется как с начала, так и с конца.
        System.out.println();
        System.out.println("Удалить из строки пробелы и определить, является ли она перевертышем");
        sTask3(new String[] {"потоП", "ten et", "8342aslfjs", "тест", "_тест"});

        //Отфильтровать из строки числа
        //Вводится строка, содержащая буквы, целые неотрицательные числа и иные символы. Требуется все числа, которые встречаются в строке, поместить в отдельный целочисленный массив. Например, если дана строка "data 48 call 9 read13 blank0a", то в массиве должны оказаться числа 48, 9, 13 и 0.
        System.out.println();
        System.out.println("Отфильтровать из строки числа");
        sTask4("data 48 call 9 read13 blank0a");

        //Удаление из строки повторяющихся символов
        //Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde def", то должно быть выведено "abcdef".
        System.out.println();
        System.out.println("Удаление из строки повторяющихся символов");
        sTask5("abc cde def");

        //Замена подстроки
        //Найти в строке указанную подстроку и заменить ее на новую. Строку, ее подстроку для замены и новую подстроку вводит пользователь.
        System.out.println();
        System.out.println("Замена подстроки");
        sTask6("2 * 2 = 5", "= 5", "< 6");

        //Самая длинная строка в массиве
        //Вводятся строки. Определить самую длинную строку и вывести ее номер на экран. Если самых длинных строк несколько, то вывести номера всех таких строк.
        System.out.println();
        System.out.println("Самая длинная строка в массиве");
        sTask7(new String[] {"потоП", "ten et", "8342aslfjs", "834dgsdfgs", "тест", "_тест"});

        //Самое длинное слово в строке
        //Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых длинных слов может быть несколько, не обрабатывать.
        System.out.println();
        System.out.println("Самое длинное слово в строке");
        sTask8("Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");

        //Удаление лишних пробелов
        //Вводится ненормированная строка, у которой могут быть пробелы в начале, в конце и между словами более одного пробела. Привести ее к нормированному виду, т.е. удалить все пробелы в начале и конце, а между словами оставить только один пробел.
        System.out.println();
        System.out.println("Удаление лишних пробелов");
        sTask9("    Lorem ipsum dolor sit amet consectetur     adipiscing elit sed do eiusmod tempor incididunt           ut labore et dolore magna aliqua   ");

        //Количество строчных и прописных букв в строке
        //Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские буквы.
        System.out.println();
        System.out.println("Количество строчных и прописных букв в строке");
        sTask10("Lorem Ipsum Dolor Sit Amet Consectetur Adipiscing Elit Sed Do Eiusmod Tempor Incididunt Ut Labore Et Dolore Magna Aliqua");

        //Количество слов в строке
        //Вводится строка, состоящая из слов, разделенных пробелами. Требуется посчитать количество слов в ней.
        System.out.println();
        System.out.println("Количество слов в строке");
        sTask11("Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");

    }

    private static void sTask1(String s) {
        Set<Character> chars = new HashSet<>();
        s.chars().forEach(ch -> chars.add(new Character((char) ch)));
        chars.remove(' ');
        Character[] charArray = chars.toArray(new Character[0]);

        List<String> words = new ArrayList();
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        IntStream.range(0, tlr.nextInt(3,7)).forEach(i -> {
            StringBuilder sb = new StringBuilder();
            IntStream.range(0, tlr.nextInt(5,12)).forEach(j -> sb.append(charArray[tlr.nextInt(charArray.length)]));
            words.add(sb.toString());
        });

        System.out.println(String.format("\"%s\" -> \"%s\"", s, words.stream().collect(Collectors.joining(" "))));
    }

    private static final Pattern TASK2_PATTERN = Pattern.compile("^[a-zA-Z_]\\w*$");
    private static void sTask2(String[] strings) {
        for (String s : strings) {
            System.out.println(String.format("Identifier \"%s\" is %scorrect.", s, TASK2_PATTERN.matcher(s).matches()?"":"not "));
        }
    }

    private static void sTask3(String[] strings) {
        processing: for (String s : strings) {
            String ss = s.replaceAll(" ", "").toLowerCase();
            int i = 0;
            int j = ss.length() - 1;
            while (i < j) {
                if (ss.charAt(i++) != ss.charAt(j--)) {
                    System.out.println("\"" + s + "\" is not a palindrome.");
                    continue processing;
                }
            }
            System.out.println("\"" + s + "\" is a palindrome.");
        }
    }

    private static final Pattern TASK4_PATTERN = Pattern.compile("\\d+");
    private static void sTask4(String s) {
        Matcher m = TASK4_PATTERN.matcher(s);
        List<Integer> ints = new ArrayList<>();
        while (m.find()) {
            ints.add(Integer.parseInt(m.group()));
        }
        System.out.println(String.format("Source \"%s\", int array is %s", s, ints));
    }

    private static void sTask5(String s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> chars = new HashSet<>();
        chars.add(' ');
        for (char c:s.toCharArray()) {
            if (!chars.contains(c)) {
                chars.add(c);
                sb.append(c);
            }
        }
        System.out.println(String.format("Source \"%s\", result string is \"%s\"", s, sb));
    }

    private static void sTask6(String s, String toFind, String replaceWith) {
        String out = s.replace(toFind, replaceWith);
        System.out.println(String.format("Source \"%s\", replace \"%s\" with \"%s\" : result string is \"%s\"", s, toFind, replaceWith, out));
    }

    private static void sTask7(String[] strings) {
        List<Integer> maxList = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            int l = s.length();
            if (max < l) {
                maxList.clear();
                max = l;
            }
            if (max == l) {
                maxList.add(i);
            }
        }
        if (maxList.size() > 0) {
            System.out.println(String.format("From strings \"%s\", the most longest is/are %s", Arrays.asList(strings), maxList));
        } else {
            System.out.println("Nothing to check!");
        }
    }

    private static final Pattern TASK8_PATTERN = Pattern.compile("[^\\s]+");
    private static void sTask8(String s) {
        Matcher m = TASK8_PATTERN.matcher(s);
        int maxLength = 0;
        String word = "";
        while (m.find()) {
            String currentWord = m.group();
            if (currentWord.length() > maxLength) {
                maxLength = currentWord.length();
                word = currentWord;
            }
        }
        if (maxLength > 0) {
            System.out.println(String.format("The first longest word in \"%s\" is :\"%s\"", s, word));
        } else {
            System.out.println("Nothing to check");
        }
    }

    private static void sTask9(String s) {
        String out = s.replaceAll("\\s{2,}","").trim();
        System.out.println(String.format("Source \"%s\", result string is \"%s\"", s, out));
    }

    private static void sTask10(String s) {
        int lower = 0;
        int upper = 0;
        for (char c:s.toCharArray()) {
            if ((c >= 'a') && (c <= 'z')) {
                lower++;
            } else if ((c >= 'A') && (c <= 'Z')) {
                upper++;
            }
        }
        System.out.println(String.format("String \"%s\" contains %d uppercase and %d lowercase characters", s, upper, lower));
    }

    private static void sTask11(String s) {
        int wordCount = s.split("\\s+").length;
        System.out.println(String.format("String \"%s\" contains %d word(s)", s, wordCount));
    }

}
