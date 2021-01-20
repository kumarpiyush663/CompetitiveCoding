import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class ConvertTimeToTimeRange {
	
	public static void main(String[] args) throws ParseException {
		String time = "20180623105509";
		
		SimpleDateFormat dataDateForamt = new SimpleDateFormat("yyyymmddHHmmss");
		
		//String formatteddate = dataDateForamt.format(time);
		//System.out.println("formatteddate ::: "+formatteddate);
		Date parseddate = dataDateForamt.parse(time);
		
		
		System.out.println("time ::: "+time);
		System.out.println("parseddate ::: "+parseddate);
		
		Calendar calenderInstance1 = Calendar.getInstance();
		calenderInstance1.setTime(parseddate);
		calenderInstance1.add(Calendar.SECOND, 10);
		System.out.println("calenderInstance1 ::: "+calenderInstance1.getTime());
		
		Calendar calenderInstance2 = Calendar.getInstance();
		calenderInstance2.setTime(parseddate);
		calenderInstance2.add(Calendar.SECOND, -10);
		System.out.println("calenderInstance2 ::: "+calenderInstance2.getTime());
		
		
		
	}

}
