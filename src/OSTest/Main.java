package OSTest;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.InetAddress;
//import java.util.StringTokenizer;

public class Main {
	
	//private static final String localHost = "127.0.0.1";
	//private static InetAddress routerIP = null;
	private static String str;
	
	
	public static void main() {
	System.out.println("OSTest is starting");
	str = checkOS();
	System.out.println("OS is " + str);
	}
	
	private static String checkOS() {
	    	String name = System.getProperty("os.name").toLowerCase();
    		System.out.println("os.name is " + name);	    	
	    	if (name.contains("windows")) {
	    		System.out.println("This is a type of Windows");
	    		return "Windows";
	    	} else if (name.contains("linux")) {
	    		System.out.println("This is a type of Linux");
	    		return "Linux";
	    	} else if (name.contains("mac")) {
	    		System.out.println("This is a type of Mac OS");
	    		return "Mac";
	    	} else {
	    		System.out.println(name + " is a new operating system.");
	    		System.out.println("Try running 'netstat -rn'");
	    		return "Unknown";   		
	    	}    	
	   }

	/*
	 * Code for running netstat -rn' from within class but can be done from terminal
	 * May remove this later or incorporate into checkOS command
	 * 
	   private InetAddress getRouter(String OS) {
		   String gateway = "";
		   try {
			   // Ignore unknown OS case as can't handle
			   if (OS.equals("Unknown")) {
				   System.out.println("Unsupported OS so setting router as loopback address.");
				   return InetAddress.getByName(localHost);
			   }
			   Process result = Runtime.getRuntime().exec("netstat -rn");	   
			   BufferedReader output = new BufferedReader
					    (new InputStreamReader(result.getInputStream()));
					    String line = output.readLine();
					    while(line != null){
					    if (line.startsWith("default") || line.startsWith("0.0.0.0"))
					        break;      
					    line = output.readLine();
					    }
					    //getLogger().info("Captured line is '" + line + "'");
					    StringTokenizer st = new StringTokenizer( line );
					    // Case for Mac/Linux, 2nd token is gateway
					    // Solaris will probably fit in here as well
					    if (OS.equals("Mac") || OS.equals("Linux")) { 
					    	st.nextToken();
					    	gateway = st.nextToken();
					    	st.nextToken();
					    	st.nextToken();
					    	st.nextToken();
					    //
					    // If other cases added then change next line to
					    // } else if (OS.equals("Windows"))) {
					    //
						// Must be Windows otherwise, 3rd token is gateway
					    } else {
					    	st.nextToken();
					    	// 
					    	// Example line for debugging a new test case
					    	// String one = st.nextToken();
					    	/ getLogger().info("Token 1 is '" + one + "'");
					    	//
					    	st.nextToken();
						    gateway = st.nextToken();
						    st.nextToken();
					    	st.nextToken();    	
					    } 
				InetAddress routerIP = InetAddress.getByName(gateway);
				// getLogger().info("Gateway is set to " + gateway);
				return routerIP;
		   } catch (Exception e ) { 
			   System.out.println(e.toString());
		   } 
		   return routerIP;
	   }
	   */		   
}
