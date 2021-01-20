package ftpFile;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
		Date date = new Date();
		System.out.println(simpleDateFormat.format(date));

	}

}
