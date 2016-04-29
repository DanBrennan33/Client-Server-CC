package brennan4114;

/**
 * 
 * @author dtbrennan1 - 020 194 114
 * Assignment 3 - step 3
 *  Credit Card Server that runs on local host.
 *  Receives a credit card object and validates. 
 *  
 */

import java.net.*;
import java.io.*;

public class CreditCardServer {
	/**
	 * Server that runs on localhost using a port number that is provided
	 * by my student ID#. This server receives a CreditCard object and 
	 * validates this number, which is then sent back to the client.
	 */
	public static void main(String[] args) {
		ServerSocket serverSocket;
		
		try {
			serverSocket = new ServerSocket(4114);
			
			System.out.println("*** This server validates a credit card number ***");
			System.out.println("listening for connection ...");
			
			Socket socketConnection = serverSocket.accept();
			
			ObjectOutputStream oosToClient = new ObjectOutputStream(socketConnection.getOutputStream());
			
			ObjectInputStream oisFromClient = new ObjectInputStream(socketConnection.getInputStream());
			
			CreditCard cc;
			
			try {
				while(true) {
					cc = (CreditCard) oisFromClient.readObject();
					System.out.println("\n*** Receive an object from the CLIENT:\n" + cc);
					
					cc.Valid();
					
					oosToClient.writeObject(cc);;
					oosToClient.flush();
					
					System.out.println("*** send the object to the CLIENT ***");
				}
			} catch(ClassNotFoundException cnf) {
				cnf.printStackTrace();
			} catch(EOFException eof) {
				System.out.println("*** the CLIENT connection has terminated ***");
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			oosToClient.close();
			oisFromClient.close();
			socketConnection.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("*** the server is stopping ***");
	}
}
