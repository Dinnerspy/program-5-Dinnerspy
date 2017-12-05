/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.unbsj.cs2383;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Nicholas
 */
public class Main {

    public static void main(String[] args) {
        BloomFilter smith = new BloomFilter();
        ArrayList<String> WordList = new ArrayList<>();
        double Count, Fails = 0;

        try {
            URL u = new URL(args[0]);
            String l;

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(u.openStream()));

            while ((l = in.readLine()) != null) {
                for (String word : l.split("[^A-Za-z]+")) {
                    if (word.length() > 0) {
                        WordList.add(word.toLowerCase());

                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Something didn't work reading URL " + e);
        }
        Count = 0;
        Fails = 0;
        System.out.println("Runing test on 3 phrase strings:");
        for (int i = 0; i < WordList.size() - 3; i++) {
            String word;

            word = WordList.get(i) + " " + WordList.get(i + 1) + " " + WordList.get(i + 2);
            Count++;
            if (smith.contains(word.toLowerCase())) {

                if (smith.h.contains(word.toLowerCase()) == false) {
                    Fails++;

                    System.out.println("FALSE Positive");

                } else {

                    System.out.println(word.toLowerCase());
                }
            } else {

                smith.add(word.toLowerCase());
                smith.h.add(word.toLowerCase());

            }

        }
        System.out.println("\nFail Rate : "+Fails / Count);
        
        System.out.println("\n\nRuning test on 4 phrase strings:\n");
        smith = new BloomFilter();
        Count = 0;
        Fails = 0;
        for (int i = 0; i < WordList.size() - 4; i++) {
            String word;

            word = WordList.get(i) + " " + WordList.get(i + 1) + " " + WordList.get(i + 2) + " " + WordList.get(i + 3);
            Count++;
            if (smith.contains(word.toLowerCase())) {

                if (smith.h.contains(word.toLowerCase()) == false) {
                    Fails++;

                    System.out.println("FALSE Positive");

                } else {

                    System.out.println(word.toLowerCase());
                }
            } else {

                smith.add(word.toLowerCase());
                smith.h.add(word.toLowerCase());

            }

        }

        System.out.println("\nFail Rate : "+Fails / Count);
        System.out.println("\n\n\n\nRuning test on 5 phrase strings:\n\n\n\n");
        smith = new BloomFilter();
        Count = 0;
        Fails = 0;
        for (int i = 0; i < WordList.size() -5; i++) {
            String word;

            word = WordList.get(i) + " " + WordList.get(i + 1) + " " + WordList.get(i + 2) + " " + WordList.get(i + 3)+ " " + WordList.get(i + 4);
            Count++;
            if (smith.contains(word.toLowerCase())) {

                if (smith.h.contains(word.toLowerCase()) == false) {
                    Fails++;

                    System.out.println("FALSE Positive");

                } else {

                    System.out.println(word.toLowerCase());
                }
            } else {

                smith.add(word.toLowerCase());
                smith.h.add(word.toLowerCase());

            }

        }

        System.out.println("\nFail Rate : "+Fails / Count);

    }
}
