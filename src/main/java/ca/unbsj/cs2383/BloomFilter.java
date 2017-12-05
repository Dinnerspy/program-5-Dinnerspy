/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.unbsj.cs2383;

import java.util.BitSet;
import java.util.HashSet;

/**
 *
 * @author Nicholas
 */
public class BloomFilter {

    HashSet<String> h = new HashSet<>();

    BitSet Test = new BitSet(1000000);

    public BloomFilter() {
        Test.set(0, Test.size(), false);
    }

    int hash1(String x) {
    
        return (x.hashCode() & 0x7fffffff) % 1000000;
    }

    int hash2(String x) {

        int HashReturn = 0;

        for (int i = 0; i < x.length(); i++) {

            HashReturn += x.charAt(i) - 48;

        }

        return Math.abs(HashReturn % 100000);
    }

    //using homers rule
    int hash3(String x) {
    
    int Hash = 0;
    for (int i= x.length()-1; i>=0; i--){
    
        Hash = ( i + Hash*128) % 100000;
    
    }

        return Hash;
    }

    int hash4(String x) {
        x.replace("\\s+", "");
         int HashReturn = 0;

        for (int i = 0; i < x.length(); i++) {

            HashReturn += x.charAt(i) - 48;

        }
       
        return Math.abs(HashReturn % 100000);

    }

    public void add(String Data) {

        Test.set(this.hash1(Data), true);
        Test.set(this.hash2(Data), true);
        Test.set(this.hash3(Data), true);
        Test.set(this.hash4(Data), true);
    }

    public boolean contains(String Data) {

        boolean Ans = false;

        if (Test.get(this.hash1(Data)) && Test.get(this.hash2(Data)) && Test.get(this.hash3(Data)) && Test.get(this.hash4(Data))) {

            Ans = true;

        }

        return Ans;
    }

}
