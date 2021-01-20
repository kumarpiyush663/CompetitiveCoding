package ftpFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SFTPFile {
	@SuppressWarnings("resource")
	public static void main(String args[]) {

		String host = "10.64.216.90";
		int port = 22;
		String user = "root";
		String password = "reliance@1234";
		JSch jsch = new JSch();
		Session session = null;
		ChannelSftp sftpChannel = null;
		ChannelExec channelExec = null;
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("source File Path (e.g:- /root/piyush/test1/abc.txt)  = ");
			String sourceFilePath = scanner.nextLine();
			System.out.print("destination File Path (e.g:- /root/piyush/test1)  = ");
			String destinationFilePath = scanner.nextLine();
			
			session = jsch.getSession(user, host, port);
			session.setPassword(password);
			session.setConfig("StrictHostKeyChecking", "no");
			System.out.println("Establishing Connection...");
			session.connect();
			System.out.println("Connection established.");
			System.out.println("Creating SFTP Channel.");
			sftpChannel = (ChannelSftp) session.openChannel("sftp");
			sftpChannel.connect();
			System.out.println("SFTP Channel created.");
			
			
			channelExec = (ChannelExec) session.openChannel("exec");
			channelExec.setCommand("mkdir -p "+ destinationFilePath);
			channelExec.connect();			
			System.out.println("channelExec.isConnected() = "+channelExec.isConnected());
			
			
			sftpChannel.cd(destinationFilePath);
			File file = new File(sourceFilePath);
			FileInputStream fis = new FileInputStream(file);
			sftpChannel.put(fis, file.getName());
			fis.close();
			System.out.println("File uploaded successfully - "+ file.getAbsolutePath());
			

		} catch (Exception e) {
			System.err.print(e);
		}
		finally {
			try {
				if(channelExec != null && channelExec.isConnected()) channelExec.disconnect();
				if(sftpChannel != null && sftpChannel.isConnected()) sftpChannel.disconnect();
				if(session != null &&session.isConnected()) session.disconnect();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
	}
}
