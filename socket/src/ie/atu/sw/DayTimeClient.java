package ie.atu.sw;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class DayTimeClient {
	
	public static final int DAYTIME_PORT = 13;
	
	public static void main(String[] args) {
		String hostname = args.length > 0 ? args[0] : "time.nist.gov";
		
		try (Socket socket = new Socket(hostname, DAYTIME_PORT)) { //try with resources
			System.out.println("Connected to Daytime Server on host " + hostname);
			socket.setSoTimeout(15000);
			InputStream input = socket.getInputStream();
			byte[] inputBytes = input.readAllBytes();
			String time = new String (inputBytes, StandardCharsets.US_ASCII);
			System.out.println(time);
			
		} catch (UnknownHostException e) {
			System.out.println("cant connect to host");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
