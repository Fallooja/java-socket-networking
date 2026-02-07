package ie.atu.sw;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PooledDaytimeServer {
	
	public final static int PORT = 13;
	
	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newFixedThreadPool(50);
		try (ServerSocket server = new ServerSocket(PORT)){
			System.out.println();
			while(true) {
				try {
					Socket connection = server.accept();
					System.out.println();
					Callable<Void> task = new DaytimeTask(connection);
					pool.submit(task);
				} catch (IOException ex) {
				}
			}
		}catch (IOException ex) {
			System.err.println();
		}	
		
	}
	
	private static class DaytimeTask implements Callable<Void>{
		private Socket connection;
		DaytimeTask(Socket connection){this.connection = connection;}
		
		@Override
		public Void call() {
			try {
				Thread.sleep(500);
				System.out.println();
				Writer out = new OutputStreamWriter(connection.getOutputStream());
				Date now = new Date();
				out.write(now.toString() + "\r\n");
				out.flush();
			}catch (IOException | InterruptedException ex) {
				System.err.println(ex);
				}finally {
					try {
						connection.close();
					}catch (IOException e) {
				}
		}
			return null;
		
	}

}
}