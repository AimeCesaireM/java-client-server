import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PingWithSubProcess {

	public static void main(String [] args) throws Exception {
		
		Scanner scanner = new Scanner (System.in);
		String ipAddress;
		String line;
		
		System.out.print("Enter destination-host address: ");
		ipAddress = scanner.nextLine();
		
		Process process = Runtime.getRuntime().exec("ping "+ ipAddress );// this returns a process object that enables interaction with cmd output
		BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
		scanner.close();
	}
	
	public boolean isValid(String ipAddress) {
		
		String[] segments = ipAddress.split(".");
		
		if (segments.length != 4)
			return false;
		
		for (String segment: segments) {
			
			int segInt = Integer.parseInt(segment);
			if( segInt <0 || segInt >255) {
				return false;
			}
		}
		
		return true;
	}
}


// Or you can use the InetAddressValidator class for apache.org:)
