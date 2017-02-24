package setB.que2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("localhost", 6969);
			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
			System.out.println("Enter data:");
			Scanner scanner = new Scanner(System.in);
			String buff = null;
			while (true) {
				buff = scanner.next();
				outputStream.writeUTF(buff);
				if (buff.equals("END"))
					break;
			}
			scanner.close();
		} catch (IOException e) {
			System.out.println("Unable to establish connection");
		}
	}
}
