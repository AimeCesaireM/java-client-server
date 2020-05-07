import java.io.IOException;
import java.net.ServerSocket;

public class LocalPortScanner {

	public static void main(String[] args) {
		
		System.out.println("Voila");
		int port = 5040;

		for ( port = 1; port <= 65535; port++ ) {
			
			try {
				ServerSocket server = new ServerSocket(port);
				//System.out.println("Accessing port "+ port);
			} catch (IOException e) {
				System.out.println("Port " +port+" is already open");				
			}
		}
		
	}

}
