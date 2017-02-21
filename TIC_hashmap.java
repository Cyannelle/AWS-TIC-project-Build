/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic_hashmap;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author aimez
 */
public class TIC_hashmap {

 
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String s = "abc"; 
        long n_hash = 0, i = 0;
        long n_first = 0;
        boolean flag = false;
        String s1, s_hash = ""; 
        HashMap<Long, String> hashTable = new HashMap<Long, String>();
        Set<Map.Entry<Long, String>> entrySet=hashTable.entrySet();
        
        
        s1 = sha256(s);
        hashTable.put(i, s1);
        
        
     while (!flag) {
        s1 = sha256(hashTable.get(i));
         if (hashTable.containsValue(s1) != false) {
             flag = true;
             n_hash = i;
             s_hash = s1;
             
         } 
         else {
            i++;
            hashTable.put(i, s1);
            System.out.print(i);
            System.out.print(" ");
            System.out.println(s1);
            
         }
     }
     
     

    /*
    for (Map.Entry<Long,String> pair : entrySet) {
        if (s1.equals(pair.getValue())) {
            n_first = pair.getKey();
        }
    }
     */
     System.out.println();
     //System.out.print("First number: ");
     //System.out.println(n_first);
     System.out.print(++n_hash);
     System.out.print(" ");
     System.out.println(s_hash);
    
    }
    
     static String sha256(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] result = input.getBytes();
        byte[] result_kp = new byte[5];
        
        md.update(result);
	result=md.digest();
      
        for (int j = 0; j <= 4; j++) {
            result_kp[j] = result[j];
        }

        return bytesToString(result_kp);
    }
    
        
        
        static String bytesToString(byte[] input) {
            
         StringBuffer sb = new StringBuffer();
        
         for (int i = 0; i < input.length ; i++) {
            sb.append(Integer.toString((input[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
            
        }
    
}
