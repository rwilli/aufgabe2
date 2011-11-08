package entities;

/**
 * The message class implements a message type.
 * 
 * @author rainer
 */
public class Message {
	// holds the message
	private String message;
	
	/**
	 * default constructor
	 * 
	 * @param s Message
	 */
	public Message(String s) {
		this.message = s;
	}
	
	/**
	 * Getter message
	 * 
	 * @return message
	 */
	public String getMessage() {
		return this.message;
	}

}
