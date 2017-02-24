package setB.que1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(6969);
			System.out.println("Server started...");
			while (true) {
				System.out.println("Waiting for client...");
				Socket socket = serverSocket.accept();
				System.out.println("Client connected...");
				DataInputStream inputStream = new DataInputStream(socket.getInputStream());
				int n = inputStream.readInt();
				String files[] = new String[n];
				
				System.out.println("Recieving file names...");
				for (int i = 0; i < n; i++)
					files[i] = inputStream.readUTF();

				String status = null;
				DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
				for (int i = 0; i < n; i++) {
					if ((new File(files[i])).exists())
						status = "Found";
					else
						status = "Not Found";

					outputStream.writeUTF(files[i] + ": " + status);
				}
			}

		} catch (IOException e) {
			System.out.println("Unable to establish connection");
		}
	}
}
