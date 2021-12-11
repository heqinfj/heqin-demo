package com.heqin.javabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Test class for splitting a string into lines at linebreaks
 *
 * @Author heqin
 * @Date 2021/10/12 9:40
 */
public class LineBreakTest {
    /**
     * Main method: pass in desired line count as first parameter (default = 10000).
     */
    public static void main(String[] args) {
        int lineCount = args.length == 0 ? 10000 : Integer.parseInt(args[0]);
        System.out.println("Comparing line breaking performance of different solutions");
        System.out.printf("Testing %d lines%n", lineCount);
        String text = createText(lineCount);
        //System.out.printf("text:%s",text);
        testSplitAllPlatforms(text);
        testSplitWindowsOnly(text);
        testScanner(text);
        testReader(text);
    }

    private static void testSplitAllPlatforms(String text) {
        long start = System.currentTimeMillis();
        text.split("\n\r|\r");
        System.out.printf("Split (regexp): %d%n", System.currentTimeMillis() - start);
    }

    private static void testSplitWindowsOnly(String text) {
        long start = System.currentTimeMillis();
        text.split("\n");
        System.out.printf("Split (CR only): %d%n", System.currentTimeMillis() - start);
    }

    private static void testScanner(String text) {
        long start = System.currentTimeMillis();
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(text)) {
            while (scanner.hasNextLine()) {
                result.add(scanner.nextLine());
            }
        }
        System.out.printf("Scanner: %d%n", System.currentTimeMillis() - start);
    }

    private static void testReader(String text) {
        long start = System.currentTimeMillis();
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new StringReader(text))) {
            String line = reader.readLine();
            while (line != null) {
                result.add(line);
                line = reader.readLine();
            }
        } catch (IOException exc) {
            // quit
        }
        System.out.printf("Reader: %d%n", System.currentTimeMillis() - start);
    }

    private static String createText(int lineCount) {
        StringBuilder result = new StringBuilder();
        StringBuilder lineBuilder = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            lineBuilder.append("word ");
        }
        String line = lineBuilder.toString();
        for (int i = 0; i < lineCount; i++) {
            result.append(line);
            result.append("\n");
        }
        return result.toString();
    }
}