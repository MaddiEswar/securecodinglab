package securecodinglab;

import java.util.Scanner;

public class IDEA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String plainText = "";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter plain text: ");
		plainText=sc.nextLine();
		System.out.println("Plain Text Before Encryption: " + plainText);
		sc.close();
	}

}
