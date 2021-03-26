package clientConnection;
import java.net.*;



import java.io.*;
public class Client {
	private Socket socket =null;
	private DataOutputStream out =null;
	private DataInputStream input = null;
	
	public Client(String address,int port) {
		
		try {
			socket = new Socket(address ,port );
			System.out.println("Connected");
			input = new DataInputStream(System.in);
			out = new DataOutputStream(socket.getOutputStream());
			String line ="";
			while(!line.equals("Over")) {
				try {
					line = input.readLine();
					out.writeUTF(line);
					System.out.println(line	);
				}
				catch(IOException i){
					System.out.println(i);
				}
			}
			try {
				input.close();
				out.close();
				socket.close();
			}			catch(IOException i){
				System.out.println(i);
		}
		}
		
		catch(UnknownHostException u) {
			System.out.println(u);
		}
		catch(IOException i ) {
			System.out.println(i);
		}
	}
	public static void main(String args[]) {
		Client client = new Client("34.206.160.228",8000);
	}
	
}
