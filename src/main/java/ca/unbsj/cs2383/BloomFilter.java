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
import java.util.BitSet;

/**
 *
 * @author Nicholas
 */
public class BloomFilter {
    
    
   BitSet Test = new BitSet(1000000);

    public BloomFilter() {
    }
    
   
    public static void main(String [] args) {
    
    
    try {
	    URL u = new URL(args[0]);
            String l;
	    int wordCtr = 0;
	    BufferedReader in = new BufferedReader(
						   new InputStreamReader(u.openStream()));
	    
	    // may not perfectly match assignment requirements for words. But it might...
	    while ((l = in.readLine()) != null) {
		for (String word: l.split("[^A-Za-z]+"))
		    if (word.length() > 0) {
			ix.addWordOccurrence(word, 1 + wordCtr/1000);
			wordCtr++;
		    }
	    }
            
            
	}
	catch (IOException e) {
	    System.err.println("Something didn't work reading URL " + e);}
    
    
    }
    
}
