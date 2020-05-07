import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(9090);
			boolean isActive = true;

			while (isActive) {
				System.out.println("Waiting for client...");
				Socket socket = server.accept();
				System.out.println("Client request accepted");

				OutputStream os = socket.getOutputStream();

				PrintWriter out = new PrintWriter(os, true);
				out.println("Hello Client");

				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String clientInput = in.readLine();
				System.out.println(clientInput);

				in.close();
				out.close();
				os.close();
				socket.close();
			}

			 server.close();//unreachable code; need to tweak the while condition

		} catch (IOException e) {
			System.out.println("Port is already open");
		}

	}

}
