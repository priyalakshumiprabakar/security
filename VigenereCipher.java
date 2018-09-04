import java.io.*;
import java.util.*;
public class VigenereCipher
{
    public static String encrypt(String text, final String key)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
    public static String decrypt(String text, final String key)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String message=sc.nextLine();
        String key=sc.nextLine();
        String encryptedMsg = encrypt(message, key);
        System.out.println("String: " + message);
        System.out.println("Encrypted message: " + encryptedMsg);
        System.out.println("Decrypted message: " + decrypt(encryptedMsg, key));
    }
}
