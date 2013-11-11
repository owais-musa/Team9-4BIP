package il.ac.technion.cs.ssdl.cs234311.yp09.connectionToServer;


// this interface represents the functionality of sending a message to the server
public interface ClientCom {
	
	public ErrorType  send2Server(String message2send);
	
}
