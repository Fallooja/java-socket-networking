package ie.atu.sw;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MultiDayTimeServer {
	
	public final static int PORT = 13;
	
	public static void main(String[] args) {
		try(ServerSocket server = new ServerSocket(PORT)){
			while(true) { //creates infinite loop
				System.out.println("Listen for connect to port" + PORT);
				try(Socket connection = server.accept()){
					System.out.println("Client connected from host " +
					connection.getRemoteSocketAddress() + ", port " + connection.getPort());
					Thread.sleep(500);
					Writer output = new OutputStreamWriter(connection.getOutputStream());
					Date now = new Date();
					output.write(now + "\r\n"); //carriage return new line pair
					output.flush(); //send straight away no packet wait
				} catch (IOException ex) {
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
			} catch (IOException ex) {
				System.err.println(ex);
			}
		}
	}

