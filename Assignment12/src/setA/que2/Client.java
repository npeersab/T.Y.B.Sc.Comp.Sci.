package setA.que2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("localhost", 6969);
			System.out.print("Enter file name: ");
			Scanner scanner = new Scanner(System.in);
			String fileName = scanner.next();
			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
			outputStream.writeUTF(fileName);
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			String buff = null;
			while (!(buff = inputStream.readUTF()).equals("EOF"))
				System.out.println(buff);
			scanner.close();
			inputStream.close();
			outputStream.close();
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
