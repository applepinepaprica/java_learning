package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println(countMaches("obababab", "bab"));

        try(BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            int times = 0;

            while ((line = br.readLine()) != null) {
                times += countMaches(line.toLowerCase(), "sus");
            }

            System.out.println(times);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int countMaches(String str, String substr) {
        int times = 0;
        int index = 0;

        while((index = str.indexOf(substr, index)) != -1) {
            times++;
            index++;
        }

        return times;
    }
}
