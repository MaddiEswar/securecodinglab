package securecodinglab;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Scanner;
public class SymmetricCipherAES {
	private static Cipher cipher = null;

	public static void main(String[] args) throws Exception {

		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();
		cipher = Cipher.getInstance("AES");

		String plainText = "";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter plain text: ");
		plainText=sc.nextLine();
		System.out.println("Plain Text Before Encryption: " + plainText);
        
		System.out.println("Key: " +secretKey);
		byte[] plainTextByte = plainText.getBytes("UTF8");
		byte[] encryptedBytes = encrypt(plainTextByte, secretKey);

		String encryptedText = new String(encryptedBytes, "UTF8");
		System.out.println("Encrypted Text After Encryption: " + encryptedText);

		byte[] decryptedBytes = decrypt(encryptedBytes, secretKey);
		String decryptedText = new String(decryptedBytes, "UTF8");
		System.out.println("Decrypted Text After Decryption: " + decryptedText);
		sc.close();
	}

	static byte[] encrypt(byte[] plainTextByte, SecretKey secretKey) throws Exception
	{
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedBytes = cipher.doFinal(plainTextByte);
		return encryptedBytes;
	}

	static byte[] decrypt(byte[] encryptedBytes, SecretKey secretKey) throws Exception 
	{
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
		return decryptedBytes;
	}
}