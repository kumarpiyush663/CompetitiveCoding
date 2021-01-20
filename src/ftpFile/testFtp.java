package ftpFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class testFtp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tranferFile3();

	}

	public static void tranferFile() {

		FTPClient ftpClient = new FTPClient();
		try {
			String host = "10.64.216.92";
			int port = 22;
			String username = "root";
			String password = "rancore@123";
			ftpClient.connect(host, port);
			ftpClient.login(username, password);
			ftpClient.enterLocalPassiveMode();

			System.out.println("connection established");

			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			File sourceFile = new File("abc.txt");
			InputStream inputStream = new FileInputStream(sourceFile);

			boolean done = ftpClient.storeFile("filename which receiver get", inputStream);
			inputStream.close();
			if (done) {
				System.out.println("file is uploaded successfully..............");
			}

		} catch (IOException e) {
			System.out.println("Exception occured while ftp : " + e);
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException e) {
				System.out.println("Exception occured while ftp logout/disconnect : " + e);
			}
		}

	}

	public static void tranferFile2() {
		FTPClient client = new FTPClient();
		String host = "10.64.216.92";

		String username = "root";
		String password = "rancore@123";

		try {
			client.connect(host);

			if (FTPReply.isPositiveCompletion(client.getReplyCode())) {
				if (client.login(username, password)) {
					FileInputStream fis = new FileInputStream("abc.txt");

					try {
						if (client.storeFile("root/piyush/", fis)) {
							System.out.println("File uploaded!");
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						fis.close();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void tranferFile3() {
		JSch jsch = new JSch();
		Session session = null;
		try {
			String host = "10.64.216.92";
			int port = 22;
			String user = "root";
			String password = "rancore@123";
			String remoteFile = "/root/piyush/threadDump12Aug.tdump";
			session = jsch.getSession(user, host, port);
			session.setPassword(password);
			Properties props = new Properties();
			props.put("StrictHostKeyChecking", "no");
			session.setConfig(props);
			session.connect();
			Channel channel = session.openChannel("sftp");
			channel.connect();
			ChannelSftp channelsftp = (ChannelSftp) channel;

			ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
			channelExec.setCommand("mkdir -p /root/piyush/test1");
			channelExec.connect();

			// channelsftp.cd("/root/piyush");
			// channelsftp.lcd("abc.txt");
			FileOutputStream fos = new FileOutputStream(new File("abc.txt"));
			channelsftp.get("/root/piyush/test1/abc.txt", fos);
			fos.flush();
			fos.close();
			channelsftp.disconnect();
			channelExec.disconnect();
			session.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
