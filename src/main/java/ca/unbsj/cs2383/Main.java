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

/**
 *
 * @author Nicholas
 */
public class Main {

    public static void main(String[] args) {
        BloomFilter smith = new BloomFilter();

        try {
            URL u = new URL("http://gutenberg.ca/ebooks/brontec-shirley/brontec-shirley-00-t.txt");
            String l;

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(u.openStream()));

            while ((l = in.readLine()) != null) {
                for (String word : l.split("[^A-Za-z]+")) {
                    if (word.length() > 0) {
//                        if (smith.contains(word)) {
//                            System.out.println(word);
//                        } else {
//                            if (smith.h.contains(word)== false) {
//                                System.out.println("fALSE");
//                            } else {
//                                smith.add(word);
//                                smith.h.add(word);
//                            }
//                        }
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Something didn't work reading URL " + e);
        }

    }
}
