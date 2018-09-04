import java.util.Scanner;
public class RSA 
{
  static int multinv,q,t1,t2,t3;
  public static int inverse(int a1,int a2,int a3,int b1,int b2,int b3)
  {
    if(b3==1)
    {
     multinv=b2;
     return multinv;
    }
    else 
    {
    q=a3/b3;
    t1=a1-q*b1;
    t2=a2-q*b2;
    t3=a3-q*b3;
    return inverse(b1,b2,b3,t1,t2,t3);
    }
  }
  public static void main(String args[])
  {
      Scanner s=new Scanner(System.in);
      int p,q,n,pi,e,d;
      System.out.println("Enter 2 large prime no's:");
      p=s.nextInt();
      q=s.nextInt();
      System.out.println("Enter the exponent value:");
      e=s.nextInt();
      System.out.println("Enter the i/p msg:");
      int pt=s.nextInt();
      n=p*q;
      pi=(p-1)*(q-1);
      //System.out.println(pi);
      int gcd=0;
      int a=e,b=pi,t;
      while(a!=0)
      {
          t=b;
          b=a;
          a=t%a;
          if(a==0)
              gcd=b;
      }
      if(gcd==1)
         System.out.println("The e and pi(n) are coprimes.");
      else
          System.exit(0);
      int a1=1,a2=0,a3=pi,b1=0,b2=1,b3=e;
      d=inverse(a1,a2,a3,b1,b2,b3);
      System.out.println("Private key:("+d+","+n+")");
      System.out.println("Public key:("+e+","+n+")");
      int ct=1,m=e;
      int p1=n;
      a=pt;
        a=a%p1;
        while(m>0)
        {
            if( (m & 1 )==1)
            {
                ct=(ct * a)%p1;
            }
            m = m >> 1;
            a = (a * a)%p1;
             //System.out.println(a);
        }
      System.out.println("Encryption: "+ct);
      pt=1;
      m=d;
      p1=n;
      a=ct;
      a=a%p1;
        while(m>0)
        {
            if( (m & 1 )==1)
            {
                pt=(pt * a)%p1;
            }
            m = m >> 1;
            a = (a * a)%p1;
             //System.out.println(a);
        }
      System.out.println("Decryption: "+pt);
   } 
 
}
