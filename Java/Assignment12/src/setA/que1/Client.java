package setA.que1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("localhost", 4242);
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			System.out.println(inputStream.readUTF());
		} catch (IOException e) {
			System.out.println("Unable to establish connection");
		} finally {
			if (socket != null)
				try {
					socket.close();
				} catch (IOException e) {
					System.out.println("Unable to close connections");
				}
		}
	}
}
