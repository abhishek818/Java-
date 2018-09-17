/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_bucketsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ABHISHEK
 */
public class DS_BucketSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] intArray = { 54, 46, 83, 66, 95, 92, 43 };
        
        bucketSort(intArray);
        for(int i = 0; i < intArray.length; i++)
        {
            System.out.println(intArray[i]);
        }
    }
    
    public static void bucketSort(int[] input)
    {
        List<Integer>[] buckets = new List[10];
        
        for(int i = 0; i<buckets.length ; i++)
        {
              // using linked lists for the buckets
            //buckets[i] = new LinkedList<Integer>();

            // using arraylists as the buckets
            buckets[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<input.length; i++)
        {
            buckets[hash(input[i])].add(input[i]);
        }
        for(List bucket : buckets)
        {
            Collections.sort(bucket);
        }
        
        int j = 0;
        for(int i = 0; i<buckets.length; i++)
        {
            for(int value: buckets[i])
            {
                input[j++] = value;
            }
        }
    }
    
    private static int hash(int value)
    {
        return value/ 10;
    }
    
}