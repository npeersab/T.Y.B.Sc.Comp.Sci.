import java.util.Date;
import java.text.SimpleDateFormat;

public class date {

	public static void main(String args[]) {

		Date date1 = new Date();
		System.out.println(date1.toString());
		System.out.println(date1.toGMTString());
	}
}
