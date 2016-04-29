package brennan4114;

/**
 * 
 * @author dtbrennan1 - 020 194 114
 * Assignment 3 - step 2
 *  Credit Card class that sends 
 *  objects of type credit card 
 *  over the net. 
 *  
 */

import java.io.*;

public class CreditCard implements Serializable {
	/**
	 * This variable is used to remove the warning 
	 * from class CreditCard due to implementing serialization.
	 */
	public static final long serialVersionUID = 1L;
	
	long creditCardNumber;
	boolean valid;
	
	/**
	 * Constructor to set the CrediCardNumber object.
	 * @param ccn credit card number object from server.
	 */
	public CreditCard(long ccn) {
		creditCardNumber = ccn;
	}

	/**
	 * toString method to print the CreditCarNumber object
	 * and whether the value. 
	 */
	@Override
	public String toString() {
		return "\tCredit Card [Credit Card Number = " + creditCardNumber + ", valid = " + valid + "]";
	}
	
	/**
	 * Valid method that utilizes CardValidation.java that
	 * receives the boolean object returned by the CreditCardNumber
	 * object.
	 */
	public void Valid() {
		valid = CardValidation.isValid(creditCardNumber);
	}
	
}
