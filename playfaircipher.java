import java.util.*;
class playfaircipher
{
	static String plaintext = "", ciphertext = "", decryptedtext = "", key = "";
	static int digcount, matend=0, matnotinc = 0, alp[];
	static char mat[][], dig[][], newdig[][];
	
	static void matdef()
	{
		key = key.toUpperCase();
		mat = new char[5][5];
		alp = new int[26];
		for(int i=0;i<26;i++) 				alp[i]=0;
		for(int i=0;i<key.length();i++) 	alp[((int)(key.charAt(i)))-65]++;
		int i=0,j=0,k=0,flag=0;
		for(;i<5;i++)
		{
			j=0;
			for(;j<5;j++)
				if(k<key.length())
				{
					char ch = key.charAt(k++);
			
                                        if(alp[((int)ch)-65]!=-1)
					{
						mat[i][j] = ch;
						alp[((int)ch)-65]=-1;
					}
					else	{	j--; continue;	}
				}
				else { flag=1; break; }
			if(flag==1) break;
		}
		k=0;
		for(;i<5 && k<26;i++)
		{
			for(;j<5 && k<26;j++)
			{
				if(alp[k]==0)
				{
					mat[i][j]=(char)(k+65);
					alp[k]=-1;
					matend = k++;
				}
				else 
				{
					j--;
					matend  = k++;
					continue;
				}
			}
			j=0;		
		}
		for(i=25;i>0;i++)
			if(alp[i]==0)
			{
				matnotinc = i;
				break;
			}
		for(i=0;i<5;i++)
		{
			for(j=0;j<5;j++)
				System.out.print(mat[i][j]+" ");
			System.out.println();
		}
	}
	static void digram(String txt)
	{
		for(int i=0;i<txt.length()-1;i+=2)
			if(txt.charAt(i)==txt.charAt(i+1))
			{
				StringBuilder str = new StringBuilder(txt);
				str.insert(i+1,'X');
				txt = str.toString();
			}
		if(txt.length()%2!=0)			txt+='X';
		digcount = txt.length()/2;
		dig = new char[digcount][2];
		newdig = new char[digcount][2];
		for(int i=0;i<digcount;i++)		
		{
			dig[i][0] = txt.charAt(i*2);
			dig[i][1] = txt.charAt(i*2+1);
		}
		System.out.println();
		for(int i=0;i<digcount;i++) System.out.println(dig[i][0]+" "+dig[i][1]);
	}
	static void en_de_cryption(char cho)
	{
		String maintext = "";
		String restext = "";
		int cons;
		if(cho=='e') { maintext = plaintext;  cons = 1;  }
		else 		 { maintext = ciphertext; cons = -1; }
		System.out.println(maintext);
		maintext = maintext.toUpperCase();
		maintext = maintext.replaceAll("[^A-Z]+","");
		char ch1 = (char) (matend+65);
		char ch2 = (char) (matnotinc+65);
		maintext = maintext.replace(ch2,ch1);
		digram(maintext);
		for(int k=0;k<digcount;k++)
		{
			char c[] = {dig[k][0],dig[k][1]};
			int ipos[], jpos[];
			ipos = new int[2];
			jpos = new int[2];
			for(int n=0;n<2;n++)
			{
				int fl=0;
				for(int i=0;i<5;i++)
				{
					for(int j=0;j<5;j++)
						if(c[n]==mat[i][j])
						{
							ipos[n]=i;
							jpos[n]=j;
							fl=1;
							break;
						}
					if(fl==1) break;
				}
			}
			if(ipos[0]==ipos[1])
			{
				int j0 = (jpos[0]+cons)%5;
				if(j0<0) j0+=5;
				int j1 = (jpos[1]+cons)%5;
				if(j1<0) j1+=5;
				newdig[k][0] = mat[ipos[0]][j0];
				newdig[k][1] = mat[ipos[0]][j1];
			}
			else 
				if(jpos[0]==jpos[1])
				{
					int i0 = (ipos[0]+cons)%5;
					if(i0<0) i0+=5;
					int i1 = (ipos[1]+cons)%5;
					if(i1<0) i1+=5;
					newdig[k][0] = mat[i0][jpos[0]];
					newdig[k][1] = mat[i1][jpos[0]];
				}
				else
				{
					newdig[k][0] = mat[ipos[0]][jpos[1]];
					newdig[k][1] = mat[ipos[1]][jpos[0]];
				}
		}	
		for(int i=0;i<digcount;i++)
			restext+=Character.toString(newdig[i][0])+Character.toString(newdig[i][1]);
		if(cho=='e') ciphertext = restext;
		else decryptedtext = restext;
	}
	public static void main(String args[])
	{
		Scanner abu = new Scanner(System.in);
		System.out.println("Enter plaintext ... ");
		plaintext = abu.nextLine();
		System.out.println("Enter key ... ");
		key = abu.nextLine();
		matdef();
		en_de_cryption('e');
		System.out.println("Cipher Text ... \n"+ciphertext);
		System.out.println("Wanna Decipher the above text(0) or a new text (1) ... ");
		int choice = abu.nextInt();
		if(choice==0) 	en_de_cryption('d');
		else
		{
			abu.nextLine();
			System.out.println("Enter ciphertext ... ");
			ciphertext = abu.nextLine();
			System.out.println("Enter key ... ");
			key = abu.nextLine();
			matdef();
			en_de_cryption('d');		
		}
		System.out.println("Decrypted Text ... \n"+decryptedtext);
  }
}

