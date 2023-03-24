package securecodinglab;
import java.util.*;


public class MonoAlphabeticCipher {

	public static void main(String[] args) {
		String text,cipher="";
		int choice;
		Scanner s=new Scanner(System.in);
		String s1="abcdefghijklmnopqrstuvwxyz";
		String s2="nopqrstuvwxyzabcdefghijklm";
		System.out.println("1.At sender(Encryption) \n2.At Receiver(Decryption)");
		System.out.print("Enter choice:");
		choice=s.nextInt();
		if(choice==1) {
		System.out.print("Enter the plain text: ");
		text=s.next();
		//char[] arr1= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		//char[] arr2= {'n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m'};
		
		for(int i=0;i<text.length();i++) {
			char c=text.charAt(i);
			int index=s1.indexOf(c, 0);
			cipher=cipher+s2.charAt(index);
		}
		System.out.println("Plain Text:"+text);
		System.out.print("Cipher Text:"+cipher);
		}
		else {
			text="";
			System.out.print("Enter cipher text: ");
			cipher=s.next();
			for(int i=0;i<cipher.length();i++) {
				char c=cipher.charAt(i);
				int index=s2.indexOf(c, 0);
				text=text+s1.charAt(index);
			}
			System.out.print("Plain Text:"+text);
		}
		s.close();
	}

}
