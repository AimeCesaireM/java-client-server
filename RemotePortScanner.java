import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RemotePortScanner {

	static void print(Object arg) {
		System.out.print(arg.toString());
	}

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		String ipAddress = null;
		int start = 0, end = 0;
		int nThreads = 5;

		print("Enter the ip address to scan: ");
		ipAddress = reader.nextLine();

		print("Enter the start port: ");
		start = reader.nextInt();

		print("Enter the end port: ");
		end = reader.nextInt();

		if (start >= 1 && end <= 65536 && start < end) {
			while (start <= end) {
				
				ExecutorService executor = Executors.newFixedThreadPool(nThreads);
				
				Task task = new Task (ipAddress, start);
				executor.execute(task);
				start++;

			}
		} else {
			newline("Port out of range.");
		}
		reader.close();
		newline("Port scan completed.");
	}

	private static void newline(Object arg) {
		System.out.println(arg);
	}

}
