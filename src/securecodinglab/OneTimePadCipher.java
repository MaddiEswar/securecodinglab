package securecodinglab;
import java.util.*;
public class OneTimePadCipher {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String text,key,cipher="";
		int c1,c2,c;
		System.out.print("Enter the plain text: ");
		text=s.next();
		System.out.print("Enter the key: ");
		key=s.next();
		s.close();
		int i=0;
		if(key.length()!=text.length()) {
			while(key.length()!=text.length() ) {
				key=key+key.charAt(i);
				i++;
				if(i>key.length())
					i=0;
			}
		}
		System.out.println("key:"+key);
		for(i=0;i<text.length();i++) {
			c1=text.charAt(i);
			c2=key.charAt(i);
			c=c1^c2;
			cipher=cipher+(char)c;
			
		}
		System.out.println("Cipher Text: "+cipher);
		text="";
		for(i=0;i<cipher.length();i++) {
			c1=cipher.charAt(i);
			c2=key.charAt(i);
			c=c1^c2;
			
			text=text+(char)c;
			
		}
		System.out.println("Decrypted Text: "+text);
		
	}

}
