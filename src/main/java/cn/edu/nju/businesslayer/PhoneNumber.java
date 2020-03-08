package cn.edu.nju.businesslayer;

public class PhoneNumber {

	private String phoneNumber;

	/**
	 *   * This is the constructor method  which checks the    * phone number
	 * for an InvalidTelephoneException. If the   * exception is not thrown, the
	 * method will print the    * toString(). If the exception is thrown, a
	 * message is   * displayed explaining how the numbers should be formatted.
	 *   *    * @param phoneNumber This is the phone number submitted to the
	 * program.   * @exception InvalidTelephoneException is thrown if phone
	 * number is invalid.  
	 */
	public PhoneNumber(String phoneNumber) throws InvalidTelephoneException {
		this.phoneNumber = phoneNumber;

		try {
			lengthCheck(phoneNumber);
			phoneNumber = toString();
		} catch (InvalidTelephoneException ite) {
			System.out.println("Phone numbers must follow the following format: ### ### ####.");
		}

	}

	/**
	 *   * This is the lengthCheck method which checks the    * phone number for
	 * an InvalidTelephoneException. If    * the phone number submitted is less
	 * than digits or    * if the number submitted is 11 digits long or more   *
	 * and does not begin with the number '1' than an    * exception is thrown.
	 * The phone number entered is    * removed of all non-numeric characters
	 * using the    * replaceAll() method. The resulting string is named   *
	 * stringNoSpace and checked for its length.   *    * @param string This is
	 * the phone number submitted to the program.   * @exception
	 * InvalidTelephoneException thrown if entry is invalid.  
	 */
	public static void lengthCheck(String string) throws InvalidTelephoneException {
		String stringNoSpace = string.replaceAll("[^\\d]", "");

		if (string.length() <= 0) {
			System.out.println("No Number");
		} else {
			if (stringNoSpace.length() < 10) {
				throw new InvalidTelephoneException("");
			} else if (stringNoSpace.length() == 11 && !(stringNoSpace.charAt(0) == '1')) {
				throw new InvalidTelephoneException("");
			} else if (stringNoSpace.length() > 11) {
				throw new InvalidTelephoneException("");
			}
		}
	}

	/**
	 *   * This is the getter method which returns the phone number   *
	 * submitted by the user.   *    * @return This returns a String.  
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 *   * This is the setter method which stores the the phone number   *
	 * submitted by the user as the phone number used within this class.   *   
	 * * @param phoneNumber This is the phone number submitted to the program.  
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 *   * This is the method which first removes all spaces from    * the phone
	 * number submitted, splits the string at every non-   * numeric symbol, and
	 * returns the area code as a three digit   * string.   *    * @param string
	 * This is the phone number submitted to the program.   * @return This
	 * returns a String.  
	 */
	public String getAreaCode(String string) {

		String result;
		String stringNoSpace = string.replaceAll("^[\\s()]+|[\\s()]+$", "");

		String[] split = stringNoSpace.split("[\\s()-.]+");

		if (split.length == 1) {
			result = string.substring(0, 3);
			return result;
		} else if (stringNoSpace.length() > 10 && stringNoSpace.startsWith("1")) {
			if (split.length <= 1) {
				result = stringNoSpace.substring(0, 3);
			} else if (split[1].isEmpty()) {
				result = split[2];
			} else {
				result = split[1];
			}
			return result;
		} else {
			if (split.length <= 1) {
				result = stringNoSpace.substring(0, 3);
			} else if (split[0].isEmpty()) {
				result = split[1].replaceAll("\\s", "");
			} else {
				result = split[0].replaceAll("\\s", "");
			}
			return result;
		}
	}

	/**
	 *   * This is the method which first removes all spaces from    * the phone
	 * number submitted, splits the string at every non-   * numeric symbol, and
	 * returns the exchange code as a three digit   * string. The location of
	 * that three digit string is determined by    * the format that the
	 * original string was submitted as.   *    * @param string This is the
	 * phone number submitted to the program.   * @return This returns a String.
	 *  
	 */

	public String getExchange(String string) {
		String result;
		String stringNoSpace = string.replaceAll("^[\\s()]+|[\\s()]+$", "");

		String[] split = stringNoSpace.split("[\\s()-.]+");

		if (split.length == 1) {
			result = string.substring(3, 6);
			return result;
		} else if ((stringNoSpace.startsWith("1")) || (split[0].isEmpty())) {
			result = split[2].replaceAll("\\s", "");
			return result;
		} else {
			result = split[1].replaceAll("\\s", "");
		}
		return result;
	}

	/**
	 *   * This is the method which first removes all spaces from    * the phone
	 * number submitted, splits the string at every non-   * numeric symbol, and
	 * returns the local number as a four digit   * string. The location of that
	 * three digit string is determined by    * the format that the original
	 * string was submitted as.   *    * @param string This is the phone number
	 * submitted to the program.   * @return This returns a String.  
	 */

	public String getLocalNumber(String string) {
		String result = null;
		String stringNoSpace = string.replaceAll("^[\\s()]+|[\\s()]+$", "");

		String[] split = stringNoSpace.split("[\\s()-.]+");

		if (split.length == 1) {
			result = string.substring(6, 10);
			return result;
		} else if (split.length == 4) {
			if (stringNoSpace.startsWith("1") || (split[0].isEmpty())) {
				result = split[3].replaceAll("\\s", "");
			}
		} else {
			result = split[2].replaceAll("\\s", "");
		}
		return result;
	}

	/**
	 *   * This is the method which prints the area code, exchange code, and   
	 * * local number generated by the getAreaCode(), getExchangeCode, and   *
	 * getLocalNumber() methods. The numbers are formatted as follows:    *
	 * (###) ### ####.    *   * @return This returns a String.  
	 */

	public String toString() {
		return "(" + getAreaCode(phoneNumber) + ") " + getExchange(phoneNumber) + "-" + getLocalNumber(phoneNumber);
	}

}
