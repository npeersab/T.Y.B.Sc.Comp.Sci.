package setB.que1;

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
			System.out.print("How many files?: ");
			Scanner scanner = new Scanner(System.in);
			int n = scanner.nextInt();
			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
			outputStream.writeInt(n);
			System.out.println("Enter file names:");
			for (int i = 0; i < n; i++) {
				String fileName = scanner.next();
				outputStream.writeUTF(fileName);
			}
			scanner.close();
			
			System.out.println("\nResults:");
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			for (int i = 0; i < n; i++)
				System.out.println(inputStream.readUTF());

			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Unable to create connection");
		}
	}
}
