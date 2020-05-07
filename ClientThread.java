import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread extends Thread {

	Socket socket = null;

	public ClientThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			Scanner c = new Scanner(System.in);

			OutputStream os = socket.getOutputStream();

			PrintWriter out = new PrintWriter(os, true);
			String message = c.nextLine();
			out.println(message);

			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String clientInput = in.readLine();
			System.out.println(clientInput);

			in.close();
			out.close();
			os.close();
			socket.close();
		} catch (Exception e) {

		}
	}
}
