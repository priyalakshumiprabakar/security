/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package information.security;

import java.util.Scanner;


public class CaesarCipher {
    public static void main(String args[])
    {
        System.out.println("Caesar Cipher\n");
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the key");
        int m=s.nextInt();
        System.out.println("Enter the plain text");
        String text=s.next();
        StringBuffer result= new StringBuffer();
         StringBuffer dec= new StringBuffer();
 
        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) +  m - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) +  m - 97) % 26 + 97);
                result.append(ch);
            }
        }
        System.out.println("encrypted text:"+result);
         for (int i=0; i<result.length(); i++)
        {
            if (Character.isUpperCase(result.charAt(i)))
            {
                char ch = (char)(((int)result.charAt(i) - m - 65) % 26 + 65);
                dec.append(ch);
            }
            else
            {
                char ch = (char)(((int)result.charAt(i) - m - 97) % 26 + 97);
                dec.append(ch);
            }
        }
        System.out.println("decrypted text:"+dec);
    }
    

}
