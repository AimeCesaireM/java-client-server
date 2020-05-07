import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		try {
			Scanner c = new Scanner(System.in);
			InetAddress serverAddress = InetAddress.getLocalHost();
			
			boolean stop = false;

			while (!stop) {
				Socket socket = new Socket(serverAddress, 9090);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				System.out.println(input.readLine());
				String message = c.nextLine();
				out.println(message);
				out.close();
				input.close();
				socket.close();
			}


		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
