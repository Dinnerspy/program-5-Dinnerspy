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
       // System.out.println("----------");
       // System.out.println((x.hashCode() & 0x7fffffff) % 1000000);
        return (x.hashCode() & 0x7fffffff) % 1000000;
    }

    int hash2(String x) {

        int HashReturn = 0;

        for (int i = 0; i < x.length(); i++) {

            HashReturn += x.charAt(i) - 48;

        }
       // System.out.println(HashReturn % 100000);
       // System.out.println("----------");
        return Math.abs(HashReturn % 100000);
    }

    int hash3(String x) {

        return (x.hashCode() & 0x7fffffff) % 1000000;
    }

    int hash4(String x) {

        return (x.hashCode() & 0x7fffffff) % 1000000;
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
