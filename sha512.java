//package informationsecurity;
import java.util.*;
public class sha512 {

    /**
     * @param args the command line arguments
     */
    public static int[] add(int[] a,int[] b)
    {
        int carry=0;
        int[] ans=new int[a.length];
        for(int i=63;i>=0;i--)
        {
            ans[i]=a[i]+b[i]+carry;
            if(ans[i]>=2)
            {
                carry=ans[i]/2;
                ans[i]%=2;
            }
            else
            {
                carry=0;
            }
        }
        return ans;
    }
    public static int[] maj(int[] a, int[] b,int[] c)
    {
        int[] ans=new int[a.length];
        for(int i=0;i<64;i++)
        {
            int[] val={0,0};
            val[a[i]]++;
            val[b[i]]++;
            val[c[i]]++;
            if(val[0]>val[1])ans[i]=0;
            else ans[i]=1;
        }
        return ans;
    }
    public static int[] ch(int[] e,int[] f,int[] g)
    {
        int[] ans=new int[e.length];
        for(int i=0;i<ans.length;i++)
        {
            if(e[i]==1)ans[i]=f[i];
            else  ans[i]=g[i];
        }
        return ans;
    }
    public static int[] sigma(int[] a)
    {
        int[] ans = new int[a.length];
        for(int i=0;i<ans.length;i++)
        {
            ans[i]^=a[(a.length-14+i)%a.length];
            ans[i]^=a[(a.length-18+i)%a.length];
            ans[i]^=a[(a.length-41+i)%a.length];
        }
        return ans;
    }
    public static int[] sig(int[] a)
    {
        int[] ans = new int[a.length];
        for(int i=0;i<ans.length;i++)
        {
            ans[i]^=a[(a.length-28+i)%a.length];
            ans[i]^=a[(a.length-34+i)%a.length];
            ans[i]^=a[(a.length-39+i)%a.length];
        }
        return ans;
    }
    public static String converttohex(String s)
    {
        String ans="";
        for(int i=0;i<s.length();i+=4)
        {
            int val=(s.charAt(i+0)-'0')*8+(s.charAt(i+1)-'0')*4+(s.charAt(i+2)-'0')*2+(s.charAt(i+3)-'0')*1;
            String hx=Integer.toHexString(val);
            ans+=hx;
        }
        return ans;
    }
    public static int[] sigma0(int[] a)
    {
        int[] ans =new int[a.length];
        for(int i=0;i<ans.length;i++)ans[i]=0;
        for(int i=7;i<a.length;i++)
        {
            ans[i]^=a[i-7];
        }
        for(int i=0;i<a.length;i++)
        {
            ans[i]^=a[(a.length-1+i)%a.length];
            ans[i]^=a[(a.length-8+i)%a.length];
        }
        return ans;
    }
    public static int[] sigma1(int[] a)
    {
        int[] ans =new int[a.length];
        for(int i=0;i<ans.length;i++)ans[i]=0;
        for(int i=6;i<a.length;i++)
        {
            ans[i]^=a[i-6];
        }
        for(int i=0;i<a.length;i++)
        {
            ans[i]^=a[(a.length-19+i)%a.length];
            ans[i]^=a[(a.length-61+i)%a.length];
        }
        return ans;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        String text="";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Message ");
        text=sc.nextLine();
        int l=text.length()*8;
        int extra=0;
        if(l%1024!=0)extra=1;
        int[] block =new int[l/1024*1024+extra*1024];
        for(int i=0;i<text.length();i++)
        {
            int c=text.charAt(i);
            for(int j=7;j>=0;j--){
            block[i*8+j]=c&1;
            c>>=1;
            
                    }
        }
        block[text.length()*8]=1;
        for(int i=0;i<128;i++)
        {
            block[block.length-1-i]=l&1;
            l>>=1;
        }
        
        int[][] m=new int[l/1024+extra][1024];
        int k=0;
        for(int i=0;i<m.length;i++)
        {
            for(int j=0;j<m[i].length;j++)
            {
                
                m[i][j]=block[k++];
            }
        }
        String[] arr=new String[8];
         arr[0] = "6A09E667F3BCC908"; arr[4] = "510E527FADE682D1";
        arr[1]= "BB67AE8584CAA73B";arr[5] = "9B05688C2B3E6C1F";
        arr[2] = "3C6EF372FE94F82B";arr[6] = "1F83D9ABFB41BD6B";
        arr[3] = "A54FF53A5F1D36F1";arr[7]= "5BE0CD19137E2179";
        String[] keys=new String[]{"0x428a2f98d728ae22", "0x7137449123ef65cd", "0xb5c0fbcfec4d3b2f", "0xe9b5dba58189dbbc", "0x3956c25bf348b538", 
              "0x59f111f1b605d019", "0x923f82a4af194f9b", "0xab1c5ed5da6d8118", "0xd807aa98a3030242", "0x12835b0145706fbe", 
              "0x243185be4ee4b28c", "0x550c7dc3d5ffb4e2", "0x72be5d74f27b896f", "0x80deb1fe3b1696b1", "0x9bdc06a725c71235", 
              "0xc19bf174cf692694", "0xe49b69c19ef14ad2", "0xefbe4786384f25e3", "0x0fc19dc68b8cd5b5", "0x240ca1cc77ac9c65", 
              "0x2de92c6f592b0275", "0x4a7484aa6ea6e483", "0x5cb0a9dcbd41fbd4", "0x76f988da831153b5", "0x983e5152ee66dfab", 
              "0xa831c66d2db43210", "0xb00327c898fb213f", "0xbf597fc7beef0ee4", "0xc6e00bf33da88fc2", "0xd5a79147930aa725", 
              "0x06ca6351e003826f", "0x142929670a0e6e70", "0x27b70a8546d22ffc", "0x2e1b21385c26c926", "0x4d2c6dfc5ac42aed", 
              "0x53380d139d95b3df", "0x650a73548baf63de", "0x766a0abb3c77b2a8", "0x81c2c92e47edaee6", "0x92722c851482353b", 
              "0xa2bfe8a14cf10364", "0xa81a664bbc423001", "0xc24b8b70d0f89791", "0xc76c51a30654be30", "0xd192e819d6ef5218", 
              "0xd69906245565a910", "0xf40e35855771202a", "0x106aa07032bbd1b8", "0x19a4c116b8d2d0c8", "0x1e376c085141ab53", 
              "0x2748774cdf8eeb99", "0x34b0bcb5e19b48a8", "0x391c0cb3c5c95a63", "0x4ed8aa4ae3418acb", "0x5b9cca4f7763e373", 
              "0x682e6ff3d6b2b8a3", "0x748f82ee5defb2fc", "0x78a5636f43172f60", "0x84c87814a1f0ab72", "0x8cc702081a6439ec", 
              "0x90befffa23631e28", "0xa4506cebde82bde9", "0xbef9a3f7b2c67915", "0xc67178f2e372532b", "0xca273eceea26619c", 
              "0xd186b8c721c0c207", "0xeada7dd6cde0eb1e", "0xf57d4f7fee6ed178", "0x06f067aa72176fba", "0x0a637dc5a2c898a6", 
              "0x113f9804bef90dae", "0x1b710b35131c471b", "0x28db77f523047d84", "0x32caab7b40c72493", "0x3c9ebe0a15c9bebc", 
              "0x431d67c49c100d4c", "0x4cc5d4becb3e42b6", "0x597f299cfc657e2a", "0x5fcb6fab3ad6faec", "0x6c44198c4a475817"};
        String keystring=keys[0].substring(2);
        int[] key=new int[64];
        int[][] hash=new int[8][64];
        int[][] inithash=new int[8][64];
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<16;j++)
            {   char hex=arr[i].charAt(j);
            int ll;
            if(hex<='9')ll=hex-'0';
            else ll=hex-'A'+10;
                for(int p=3;p>=0;p--)
                {hash[i][j*4+p]=ll&1;
                inithash[i][j*4+p]=ll&1;
                ll>>=1;
                }
            }
        }
        
        int[][] word=new int[80][64];
        for(int i=0;i<m.length;i++){
        for(int p=0;p<16;p++)
                for(int j=0;j<64;j++)
                {
                    word[p][j]=m[i][p*64+j];
                }
        }
            for(int j=16;j<80;j++)
            {
                word[j]=add(add(add(word[j-16],sigma0(word[j-15])),word[j-7]),sigma1(word[j-2]));
               
            }
        
        for(int i=0;i<m.length;i++)
        {
            
            k=0;
            
            for(int q=0;q<80;q++){
                keystring=keys[q].substring(2);
                for(int j=0;j<16;j++)
            {   char hex=keystring.charAt(j);
            int ll;
            if(hex<='9')ll=hex-'0';
            else ll=hex-'A'+10;
                for(int p=3;p>=0;p--)
                {key[j*4+p]=ll&1;
                ll>>=1;
                }
            }
            int[] val1=ch(hash[4],hash[5],hash[6]);
            int[] val2=add(val1,hash[7]);
            int[] val3=sigma(hash[4]);
            int[] val4=add(val3,val2);
            int[] val5=add(val4,word[q]);
            int[] val6=add(val5,key);
            
            int[] val7=add(val6,hash[3]);
            int[][] nhash=new int[8][64];
            nhash[7]=hash[6].clone();
            nhash[6]=hash[5].clone();
            nhash[5]=hash[4].clone();
            nhash[4]=val7.clone();
            val1=maj(hash[0],hash[1],hash[2]);
            
            val2=sig(hash[0]);
            val3=add(val2,val1);
            
            val4=add(val3,val6);
            nhash[3]=hash[2].clone();
            nhash[2]=hash[1].clone();
            nhash[1]=hash[0].clone();
            nhash[0]=val4.clone();
            
            System.out.println("The new hash value  after round "+(q+1)+" is ");
            for(int p=0;p<8;p++)
            {
                String hx="";
                hash[p]=nhash[p];
                for(int j=0;j<nhash[p].length;j++)
                    hx=hx+nhash[p][j];
                System.out.print((char)('a'+p)+" : ");
                System.out.print(converttohex(hx)+" ");
            }
            System.out.println();
            }
            System.out.println("The final Message digest is ");
            for(int p=0;p<8;p++)
            {
                hash[p]=add(hash[p],inithash[p]);
                String hx="";
                for(int j=0;j<hash[p].length;j++)
                    hx=hx+hash[p][j];
                System.out.print(converttohex(hx)+" ");
                
            }
        }
    }
    
}
