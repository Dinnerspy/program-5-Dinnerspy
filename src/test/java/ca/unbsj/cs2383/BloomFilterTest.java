/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.unbsj.cs2383;
import static org.junit.Assert.*;
import  org.junit.*;
import java.util.*;
/**
 *
 * @author Nicholas
 */
public class BloomFilterTest {
      @Test
    public void ContainsTest()
    {
	BloomFilter BF = new BloomFilter();
        BF.add("Smith Jim Test");
        BF.add("Amih wdw Test");
	assertEquals(true, BF.contains("Smith Jim Test"));
        assertEquals(false, BF.contains("Smith wdw Test"));
    }
    
    
    

}
