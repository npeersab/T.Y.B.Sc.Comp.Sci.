package setB.que2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(6969);
			System.out.println("Server started");
			while (true) {
				System.out.println("Waiting for client");
				Socket socket = serverSocket.accept();
				System.out.println("Client connected");
				
				System.out.println("Data from client:");
				DataInputStream inputStream = new DataInputStream(socket.getInputStream());
				String buff = null;
				while (!(buff = inputStream.readUTF()).equals("END"))
					System.out.println(buff);
				
				System.out.println("Client disconnected\n");
				inputStream.close();
			}
		} catch (IOException e) {
			System.out.println("Unable to establish connection");
		}
	}
}
