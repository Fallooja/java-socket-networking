package ie.atu.sw;

import java.net.*;
import java.io.*;


public class LowPortScanner {
	public static final int MAX_PORT = 1024;
	
	public static void main(String[] args) {
		String hostname = args.length > 0 ? args[0] : "localhost";
		System.out.println("\nScanning ports on host " + hostname);
		
		//String hostname = "localhost";
		//System.out.println("\nScanning Ports...");
		
		for (int port = 1; port < MAX_PORT; port++) {
			try (Socket socket = new Socket()){ //try w/ resources
				//System.out.println("Attempting to connect to port"+ port + "on host" + hostname);
				//Socket socket = new Socket(hostname, port);
				socket.connect(new InetSocketAddress(hostname, port), 10);
				System.out.println("There is a server on port "+ port + " of " + hostname);
				//socket.close();
			} catch (UnknownHostException ex) {
				System.err.println(ex);
				break;
			} catch (IOException ex) {
				//System.out.println("no server on this port");
			}
			
		}
		System.out.println("finished scan");
	}

}
