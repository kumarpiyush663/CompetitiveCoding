
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

//import org.apache.commons.codec.binary.Base64;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String string = "cc   ";
		String string2[] = string.split(" ");
		
		for(int i=0;i<string2.length;i++) System.out.println(i+" "+string2[i]);
		
		System.exit(0);
		
//		File x = new File("C:/Users/piyush12.kumar/eclipse-workspace/CompetitiveCoding/test4");
//		x.mkdir();
		
		
		
		
		
		try {
			File x = new File("C:/Users/piyush12.kumar/Desktop/graphplots/fixed_sarima_08-06-2020-14-56-082821.png");
			System.out.println(new testMain().encodeFileToBase64Binary(x));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.exit(0);
		try {
			
			String content =  "123456fghj";
			String fileNamee = "abc.txt";
			String remoteFilePath = "C:/Users/piyush12.kumar/eclipse-workspace/CompetitiveCoding/test8/";
			
			File remoteFile = new File(remoteFilePath);
			System.out.println(remoteFile.mkdir());
			String fileName = remoteFile.getName();
			FileOutputStream outputStream = new FileOutputStream(remoteFilePath+"/"+fileNamee);
	        byte[] strToBytes =content.getBytes();
	        outputStream.write(strToBytes);
	        outputStream.flush();
	        outputStream.close();
	        
			System.out.println(fileName);
			Thread.sleep(5000);
//			File file1 = new File(remoteFilePath);
			System.out.println((new File(remoteFilePath+"/"+fileNamee)).delete());
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
	}
	public String encodeFileToBase64Binary(File file){
		String className = this.getClass().getSimpleName() + " :: encodeFileToBase64Binary";
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile =  Base64.getEncoder().encodeToString(bytes);
        } catch (FileNotFoundException e) {

			e.printStackTrace();
		
        } catch (IOException e) {

			e.printStackTrace();
		
        }

        return encodedfile;
    }

}

