package securecodinglab;
import java.net.*;
import java.io.*;
public class DiffieHellmanServer {

	public static void main(String[] args) {
		try {
			int port = 8088;
			int b=3;
			double clientP,clientG,clientA,B,Bdash;
			String Bstr;
			
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Waiting for client "+serverSocket.getLocalPort());
			Socket server = serverSocket.accept();
			System.out.println("Connected to "+server.getRemoteSocketAddress());
			
			System.out.println("From server: private key="+b);
			DataInputStream in = new DataInputStream(server.getInputStream());
			clientP = Integer.parseInt(in.readUTF());
			System.out.println("From Client: p="+clientP);
			
			clientG= Integer.parseInt(in.readUTF());
			System.out.println("From client: g="+clientG);
			
			clientA = Double.parseDouble(in.readUTF());
			System.out.println("From client: public key="+clientA);
			
			B = ((Math.pow(clientG, b)) % clientP); 
			Bstr = Double.toString(B);

			
			OutputStream outToclient = server.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToclient);

			out.writeUTF(Bstr);
			Bdash = ((Math.pow(clientA,b))%clientP);
			System.out.println("Secret Key to perform Symmetric Encryption = "+ Bdash);
			server.close();

		}
		catch(SocketTimeoutException s) {
			System.out.println("Socket timed out..");
		}
		catch(IOException e) {}
	}

}
