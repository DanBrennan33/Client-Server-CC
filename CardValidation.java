package brennan4114;

/**
 * 
 * @author dtbrennan1 - 020 194 114
 * Assignment 3 - step 1
 *  Credit Card validation algorithm. 
 *  
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardValidation {
	
	/**
	 *  Main that tests for validation of a credit card number.
	 * @param args
	 */
	public static void main(String[] args) {
		long creditCardNumber = 4012888888881881L;
		System.out.println(isValid(creditCardNumber));
	}
	
	/**
	 * Method to create a list of long digits from an 
	 * initial long value. This breaks each digit up 
	 * individually into a list to return.
	 * @param  l  is ceditcardnumber as a long value.
	 * @return cc is a list of individual digits 
	 *            built from ceditcardnumber long
	 */
	public static List<Long> toDigits(long l) {
		List<Long> cc = new ArrayList<Long>();
		while(l > 0) {
			cc.add(l % 10);
			l /= 10;
		} 
		
		Collections.reverse(cc);
		
		return cc;
	}

	/**
	 * Method to reverse the list of digits, that
	 * then returns the list reversed to be used.
	 * 
	 */
	
	/**
	 * Method to reverse the list of digits, that
	 * then returns the list reversed to be used.
	 * @param  l  is creditcardnumber as a long value.
	 * @return cc is a list of individual digits 
	 *            built from creditcardnumber long.
	 */
	public static List<Long> toDigitsReverse(long l) {
		List<Long> cc = toDigits(l);
		Collections.reverse(cc);
		doubleSecond(cc);
		return cc;
	}

	/**
	 * This method doubles every other digit in
	 * the list. Which then returns with the new
	 * values doubled where needed.
	 * @param  list reversed list of individual digits from creditcardnumber
	 * @return list returns list with ever other digit doubled.
	 */
	public static List<Long> doubleSecond(List<Long> list) {
		for(int i = 0; list.size() > i; i++){
			if(i % 2 == 1) {
				long temp = list.get(i);
				temp *= 2;
				list.set(i, temp);
			}
		}
		return list;
	}

	/**
	 * Method to add the individual digits together 
	 * to find the grand sum from the list of Long digits.
	 * @param  list reversed list of doubled individual digits from creditcardnumber
	 * @return sum  overall sum of list from th digits.
	 */
	public static long sumDigits(List<Long> list) {
		long sum = 0;
		for(int i = 0; list.size() > i; i++) {
			if(list.get(i) > 9) {
				long value = list.get(i);
				while(value > 0) {
					sum += (value % 10);
					value /= 10;
				}
			} else {
				sum += list.get(i);
			}
		}
		return sum;
	}

	/**
	 * Method to validate after the sum of digits 
	 * is calculated. This returns a boolean variable
	 * determining whether the credit card is valid 
	 * or not.
	 * @param  l     CreditCardNumber object to validate.
	 * @return valid boolean variable to return after 
	 *               validating creditcard number object.
	 */
	public static boolean isValid(long l) {
		List<Long> cc = toDigitsReverse(l);
		long value = sumDigits(cc);
		boolean valid = false;
		if(value % 10 == 0) {
			valid = true;
		}
		return valid;
	}
	
	
}
