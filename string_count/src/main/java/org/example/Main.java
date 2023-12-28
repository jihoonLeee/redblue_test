package org.example;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("문장을 입력해주세요.");
        String sentence = scanner.nextLine();
        System.out.println("입력한 문장 : "+ sentence);
        Map<Character, Integer> counts = StringCounter.countCharacters(sentence);

        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            System.out.println("'" + entry.getKey() + "' : " + entry.getValue()+"개");
        }
        scanner.close();
    }
}