package setA.que1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
	public static void main(String[] args) {
		ServerSocket serverSocket = null; 
		try {
			serverSocket = new ServerSocket(4242);
			System.out.println("Server started");
			Socket socket = serverSocket.accept();
			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
			outputStream.writeUTF("Server time: " + (new Date()).toString());
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Unable to establish connection");
		} finally {
			if (serverSocket != null)
				try {
					serverSocket.close();
				} catch (IOException e) {
					System.out.println("Error in closing connections");
				}
		}
	}
}
