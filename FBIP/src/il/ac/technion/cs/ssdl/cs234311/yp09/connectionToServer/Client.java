package il.ac.technion.cs.ssdl.cs234311.yp09.connectionToServer;

import java.lang.String;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
 
//import javax.net.ssl.HttpsURLConnection;

public class Client implements ClientCom  {
		
	// for regular use
	public ErrorType  send2Server(String message2send){ return  sendPost(message2send, false);}
	
	//for debug use
	public ErrorType  send2ServerDebeg(String message2send){ return  sendPost(message2send, true);}

	
	private ErrorType  sendPost(String message2send, boolean debugMode) {// sends a message to server
		
		String url = "http://1.talserver22.appspot.com/talserver";
		URL obj =null;
		
		// make a new URL object out of address string
		try {obj = new URL(url);
			}catch (MalformedURLException e) {
			if (debugMode) System.out.println("an ERROR acurred while creating URL");// for debugging purpose
			return ErrorType.SEND_FAIL;
			}
		
		HttpURLConnection con =null;
		// open connection 
		try {con = (HttpURLConnection) obj.openConnection();
		} catch (IOException e) {
			if (debugMode) System.out.println("an ERROR acurred while connecting to server");// for debugging purpose
			return ErrorType.SEND_FAIL;
			}
		
		// post message
		try { con.setRequestMethod("POST");
		}  catch (IOException e1) {
			System.out.println("problem setting GET"); 
			return ErrorType.SEND_FAIL;
			}
		
		 
		con.setDoOutput(true);
		DataOutputStream wr = null;
		try {
			 wr = new DataOutputStream(con.getOutputStream());
		} catch (IOException e1) {System.out.println("problem opening output stream");}
		
		
		try {
			wr.writeBytes(message2send);
		}  catch (IOException e1) {System.out.println("writing message");}
		 
		int responseCode = -1;
		// sending the GET message
		try {responseCode = con.getResponseCode();
		} catch (IOException e) {
			if (debugMode) System.out.println("an ERROR acurred while tring to get response from server");// for debugging purpose
			return ErrorType.SEND_FAIL;
			}
		System.out.println("response code is :" + responseCode);
		
		BufferedReader in =null;
		try {
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} catch (IOException e) {
			if (debugMode) System.out.println("could not read response");}
		
		//  ONLY FOR DEBUG PURPOSES 
		 if (debugMode){/// if we are in debug mode we would like to read the server response
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			try {
				while ((inputLine = in.readLine()) != null)	response.append(inputLine);
			} catch (IOException e) { System.out.println("could not read response");		}
			
			try {
				in.close();
			} catch (IOException e){ System.out.println("could not close DataOutputStream");}
			
			System.out.println("the response is : ");
			System.out.println(response.toString());
			}
		 
		 return ErrorType.NO_ERROR;
	}
	
	

}
