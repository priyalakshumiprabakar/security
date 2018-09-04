import java.util.Scanner;
public class Diffie_hellman 
{
  public static int mod(int a,int Xa,int q)
  {
      int Ya=1;
      a=a%q;
        while(Xa>0)
        {
            if( (Xa & 1 )==1)
            {
                Ya=(Ya * a)%q;
            }
            Xa = Xa >> 1;
            a = (a * a)%q;
             //System.out.println(a);
        }
   return Ya;
  }
  public static void main(String args[])
  {
    Scanner s=new Scanner(System.in);
    int q,a,Xa,Xb;
    System.out.println("Enter the values q and a(alpha)");
    q=s.nextInt();
    a=s.nextInt();
    System.out.println("Enter the private keys of A and B:");
    Xa=s.nextInt();
    Xb=s.nextInt();
    int Ya,Yb;
    Ya=mod(a,Xa,q);
    Yb=mod(a,Xb,q);
    System.out.println("Public key of A:"+Ya);
    System.out.println("Public key of B:"+Yb);
    System.out.println("After exchanging Public keys,");
    System.out.println("Public key of A:"+Yb);
    System.out.println("Public key of B:"+Ya);
    int Ka=mod(Yb,Xa,q);
    int Kb=mod(Ya,Xb,q);
    System.out.println("key of A:"+Ka);
    System.out.println("key of B:"+Kb);
  }
}
