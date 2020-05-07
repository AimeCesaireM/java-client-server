import java.net.Socket;

public class Task extends Thread{

	int start;
	String ipAddress;
	public Task(String ipAddress,int start) {
		this.start = start;
		this.ipAddress = ipAddress;
	}
	public void run () {
		try {
			Socket socket = new Socket(ipAddress, start);
			System.out.println("Port " + start + " is successfully connected to.");

			socket.close();
		} catch (Exception e) {
			System.out.println("Unable to connect to port " + start);
		}
		
	}
}
