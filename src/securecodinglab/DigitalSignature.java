package securecodinglab;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Scanner;
//import java.io.*;

public class DigitalSignature {

	public static void main(String[] args) throws Exception{
	
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter some text:");
		String msg=sc.nextLine();
		
		KeyPairGenerator keypair=KeyPairGenerator.getInstance("DSA");
		keypair.initialize(2048);
		KeyPair pair=keypair.generateKeyPair();
		
		PrivateKey privatekey=pair.getPrivate();
		PublicKey publickey=pair.getPublic();
		//System.out.println("Private key: "+privatekey);
		//System.out.println("Public Key: "+publickey);
		
		Signature sign=Signature.getInstance("SHA256withDSA");
		sign.initSign(privatekey);
		byte[] bytes=msg.getBytes();
		sign.update(bytes);
		byte[] signature=sign.sign();
		
		for(int i=0;i<signature.length;i++)
			System.out.print(" "+signature[i]);
		System.out.println();
		
		sign.initVerify(pair.getPublic());
		sign.update(bytes);
		boolean bool=sign.verify(signature);
		if(bool) {
			System.out.println("Signature is verified");
		}
		else {
			System.out.println("Signature is failed");
		}
		sc.close();
	}

}
