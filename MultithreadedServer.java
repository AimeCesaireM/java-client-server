import java.net.*;
import java.io.*;


public class MultithreadedServer {

	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(9090);

			boolean stop = false;
			while (!stop) {
				System.out.println("Waiting for connection...");
				Socket clientSocket = serverSocket.accept();
				System.out.println("Client is connected.");
				//Once a connection is made, it is passed to a thread to handle it.
				
				ClientThread clientThread = new ClientThread(clientSocket);
				clientThread.start();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
