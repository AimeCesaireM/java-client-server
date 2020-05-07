import java.net.InetAddress;

//The InetAddress class has the isReachable() method necessary for this ping program

public class PingWithIsReachable {

	public static void main(String[] args) throws Exception{
		
		String hostAddress = "facebook.com";
		InetAddress host = InetAddress.getByName(hostAddress);
		int timeout = 1000;
		
		System.out.println("[+] Host reachability status : "+ host.isReachable(timeout));

	}

}
