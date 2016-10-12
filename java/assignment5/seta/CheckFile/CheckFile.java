import java.io.File;
import java.util.Scanner;
import java.io.*;

public class CheckFile {

	public static void main(String args[]) throws IOException {

		if(args.length == 0) {
			System.out.println("Error : no input");
			System.exit(0);
		}

		File file = new File(args[0]);
		if(file == null) {
			System.out.println("Error : file not found");
		}

		if(file.isDirectory()) {

			String files[] = file.list();
			System.out.println("Content of Directory :");
			for(int i = 0; i < files.length; i++) {	
					System.out.println(files[i]);
			}
			for(int i = 0; i < files.length; i++) {
				File temp = new File(file.getPath() + "/" + files[i]);
				if(temp.isFile())
					if(files[i].endsWith(".txt")) {
						System.out.print("Do you want to delete " + files[i] + " (y/n) ? : ");
						BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
						char ch = (char) br.read();
						if(ch == 'y' || ch == 'Y')
							temp.delete();
					}
			}
		}

		else if(file.isFile()) {

			System.out.println("File Information :");
			System.out.println("Name :  " + file.getName());
			System.out.println("Path : " + file.getAbsolutePath());
			System.out.println("Size : " + file.length() + " bytes");
		}
	}
}
