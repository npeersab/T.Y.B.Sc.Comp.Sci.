package setA.que2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(6969);
			System.out.println("Server Started...");
			while (true) {
				System.out.println("Waiting for client...");
				Socket socket = serverSocket.accept();
				System.out.println("Client connected...");

				DataInputStream  inputStream = new DataInputStream(socket.getInputStream());
				String fileName = inputStream.readUTF();
				File file = new File(fileName);
				DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
				if (file.exists()) {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String buff = null;
					System.out.println("File found");
					System.out.println("Sending data...");
					while ((buff = reader.readLine()) != null)
						outputStream.writeUTF(buff);
					reader.close();
				}
				else {
					System.out.println("Error: File not found");
					outputStream.writeUTF("Error: File not found");
				}
				outputStream.writeUTF("EOF");
			}
		} catch (IOException e) {
			System.out.println("Unable establish connection");
		}
	}
}
