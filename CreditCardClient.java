package brennan4114;

/**
 * 
 * @author dtbrennan1 - 020 194 114
 * Assignment 3 - step 4
 *  Credit Card Client sends a credit card
 *  object to server and receives the object
 *  back with validation. 
 *  
 */

import java.net.*;
import java.io.*;

public class CreditCardClient {
	/**
	 * Client sends a CreditCard object to server and receives
	 * the object back with validation complete.
	 */
	public static void main(String[] args) {
		Socket clientSocket;
		
		try {
			clientSocket = new Socket(InetAddress.getByName("localhost"), 4114);
			System.out.println("Connected to " + clientSocket.getInetAddress().getHostName());
			
			ObjectInputStream oisFromServer = new ObjectInputStream(clientSocket.getInputStream());
			
			ObjectOutputStream oosToServer = new ObjectOutputStream(clientSocket.getOutputStream());
			
			System.out.print("I/O streams connected to the socket\n");
			
			CreditCard[] ccs = new CreditCard[3];
			
			ccs[0] = new CreditCard(4012888888881881L);
			ccs[1] = new CreditCard(4002888888881881L);
			ccs[2] = new CreditCard(7854124569853254L);
			
			for(int i = 0; i < 3; i++) {
				try {
					oosToServer.writeObject(ccs[i]);
					oosToServer.flush();
					System.out.println("\n### sending credit card to the server for validation:\n" + ccs[i]);

					ccs[i] = (CreditCard) oisFromServer.readObject(); // casting!
					System.out.println("### the credit card returned by the server:\n"+ ccs[i]);
									
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) { }				
				} catch (ClassNotFoundException cnf) {
					cnf.printStackTrace();
				} catch (EOFException eof) {
					System.out.println("The server connection has terminated!");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("\nClient: connection is closing ...");
			oosToServer.close();
			oisFromServer.close();
			clientSocket.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println("*** the client running is stopped ***");
	}
}
