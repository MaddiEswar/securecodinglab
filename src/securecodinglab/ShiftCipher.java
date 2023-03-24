package securecodinglab;
import java.util.*;
//Labprogram-1 To Implement and Break shift cipher

public class ShiftCipher {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int choice,shift,c,n;
		System.out.println("1.At sender(Encryption) \n2.At Receiver(Decryption)");
		System.out.print("Enter choice:");
		choice=s.nextInt();
		String text,str="";
		if(choice==1) {
		System.out.print("Enter plain text: ");
		text=s.next();
		System.out.print("Enter shift(key): ");
		shift=s.nextInt();
		for(int i=0;i<text.length();i++) {
			n=text.charAt(i);
			n=n-97;
			c=(n+shift)%26;
			str=str+(char)(c+97);
		}
		System.out.println("Cipher Text: "+str);
		}
		else if(choice==2) {
			int r=0;
			System.out.print("Enter plain text:");
			String plaintext=s.next();
			System.out.print("Enter cipher text: ");
			text=s.next();
			for(shift=0;shift<=26;shift++) {
				str="";
			for(int i=0;i<text.length();i++) {
				n=text.charAt(i);
				n=n-97;
				c=(n-shift)%26;
				if(c<0) {
					c=c+26;
				}
				str=str+(char)(c+97);
				
			}
			if(str.equals(plaintext)) {
				r=shift;
			}
			System.out.println("Plain Text for key"+shift+": "+str);
			}
			System.out.print("key found at "+r);
		}
		s.close();
	}

}
