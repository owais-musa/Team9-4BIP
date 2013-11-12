package il.ac.technion.cs.ssdl.cs234311.yp09.connectionToServer;

import java.lang.String;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

 

public class Client implements ClientCom  {
	
	/*   -----------   ------------------  ------------------- **
	**   -----------       CONSTUNTS       ------------------- **
	**   -----------   ------------------  ------------------- */
		
	private static final String ERROR_URL = "an ERROR acurred while creating URL";
	private static final String ERROR_CONNECT = "an ERROR acurred while connecting to server" ;
	private static final String ERROR_SET_POST = "problem setting POST";
	private static final String ERROR_BAD_RESPONSE_CODE = " got a bad response code from server : ";
	private static final String ERROR_OPEN_CONNECT = "problem opening output stream";
	private static final String ERROR_OPEN_STREAM = " an ERROR while opening output stream";
	private static final String ERROR_WRITING_MESSAGE ="error ecured while writing message";
	private static final String ERROR_READING_RESPONSE = "could not read response";
	private static final String ERROR_CLOSING_OUTPUTDATASTREAM = "could not close DataOutputStream";
	private static final String URL_ADRRESS_DEFAULT = "http://1.talserver22.appspot.com/talserver";
	
	
	/*   -----------   ------------------  ------------------- **
	**   -----------       FIELDS          ------------------- **
	**   -----------   ------------------  ------------------- */
	private String URL_ADRRESS;
	
	
	/*   -----------   ------------------  ------------------- **
	**   -----------      CONSTRUCTORS     ------------------- **
	**   -----------   ------------------  ------------------- */
	public Client(){
		URL_ADRRESS = URL_ADRRESS_DEFAULT;
	}
	
	public Client(String url){
		URL_ADRRESS = url;
	}
	
	
	/*   -----------   ------------------  ------------------- **
	**   -----------     USER FUNCTIONS    ------------------- **
	**   -----------   ------------------  ------------------- */

	@Override
	public ErrorType  send2Server(String message2send)		{ return  sendPost(message2send, false);}
	
	
	/*   -----------   ------------------  ------------------- **
	**   -----------     DEBUG FUNCTIONS   ------------------- **
	**   -----------   ------------------  ------------------- */
	
	public ErrorType  send2ServerDebeg(String message2send){ return  sendPost(message2send, true);}
	
	
	/*   -----------   ------------------  ------------------- **
	**   -----------     COMM FUNCTIONS    ------------------- **
	**   -----------   ------------------  ------------------- */
	private ErrorType  sendPost(String message2send, boolean debugMode) {// sends a message to server
		
		URL obj =null;
		
		// make a new URL object out of address string
		try {	obj = new URL(URL_ADRRESS);
			}catch (MalformedURLException e) {
			return endWithError(ErrorType.SEND_FAIL, ERROR_URL, debugMode );
			}
		
		HttpURLConnection con =null;
		// open connection 
		try {con = (HttpURLConnection) obj.openConnection();
		} catch (IOException e) {
			return endWithError(ErrorType.SEND_FAIL, ERROR_CONNECT, debugMode );
			}
		
		// post message
		try { con.setRequestMethod("POST");
		}  catch (IOException e1) {
			return endWithError(ErrorType.SEND_FAIL, ERROR_SET_POST, debugMode );
			}
		
		con.setDoOutput(true);
		DataOutputStream wr = null;
		
		try { wr = new DataOutputStream(con.getOutputStream());
		} catch (IOException e1) {
			return endWithError(ErrorType.SEND_FAIL, ERROR_OPEN_STREAM, debugMode );
		}
				
		try {
			wr.writeBytes(message2send);
		}  catch (IOException e1) {
			return endWithError(ErrorType.SEND_FAIL, ERROR_WRITING_MESSAGE, debugMode );
		}
		 
		int responseCode = -1;
		// sending the GET message
		try {responseCode = con.getResponseCode();
		} catch (IOException e) {
			return endWithError(ErrorType.SEND_FAIL, ERROR_OPEN_CONNECT, debugMode );
			}

		if (responseCode != 200 ) {// problem with sending the message
			return endWithError(ErrorType.BAD_RESPONSE, ERROR_BAD_RESPONSE_CODE, debugMode );
			}
		
		BufferedReader in =null;
		try {
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} catch (IOException e) {
			return endWithError(ErrorType.BAD_RESPONSE, ERROR_READING_RESPONSE, debugMode );

			}
		
		StringBuffer response = new StringBuffer();
		String inputLine;

		try {
			while ((inputLine = in.readLine()) != null)	response.append(inputLine);
		} catch (IOException e) { 
			return endWithError(ErrorType.BAD_RESPONSE, ERROR_READING_RESPONSE, debugMode );
		}
		
		try {	in.close();
		}catch (IOException e){
				return endWithError(ErrorType.BAD_RESPONSE, ERROR_CLOSING_OUTPUTDATASTREAM, debugMode );
		}
			
			//  ONLY FOR DEBUG PURPOSES 
		if (debugMode){/// if we are in debug mode we would like to read the server response
			System.out.println("the response is : ");
			System.out.println(response.toString());
			}
		 
		return endWithError(ErrorType.NO_ERROR, response.toString(), debugMode );
	}
	
	private static ErrorType endWithError (ErrorType et ,String errorMessage, boolean debugMode ){
		
		if (debugMode) System.out.println(errorMessage);
		et.s = errorMessage;
		return et;
	}
}
